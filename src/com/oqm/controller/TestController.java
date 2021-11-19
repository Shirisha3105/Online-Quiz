package com.oqm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oqm.bean.HistoryBean;
import com.oqm.bean.QuestionBean;
import com.oqm.bean.TestBean;
import com.oqm.service.TestService;


public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		/*String trigerFrom = req.getParameter("Button");
		if (trigerFrom.equals("ans"))
		{
			
			int noOfQuestoins = Integer.parseInt(req.getParameter("noOfquestions"));
			int marks=0,total_marks=0,score=0;
			for(int i=1;i<=noOfQuestoins;i++) 
			{
			String studentoption=req.getParameter(String.valueOf(i));
			String studentquestion=req.getParameter("Ques"+String.valueOf(i));
			
			TestBean testbean = new TestBean();
			testbean.setStudentOption(studentoption);
			testbean.setQuestion(studentquestion);
			TestService studentService = new TestService();
			 
				try {
					marks = studentService.AnswerCheck(testbean);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 if(marks==1) 
				 total_marks=total_marks+1;
	
			}
			//HistoryBean historybean = new HistoryBean();
			
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			 Calendar calobj = Calendar.getInstance();
		       String dateandtime=(String)df.format(calobj.getTime());
		       HttpSession session1 = req.getSession(true);
		       String uname=(String)session1.getAttribute("user");
		       
		   
		        
		       
		     //  TestService testservice= new TestService();
		      // int check = testservice.SetHistory( historybean);
			//System.out.println(total_marks);
		      
		    	   HttpSession session = req.getSession(true); // reuse existing
		    	  
		    	     session.setAttribute("result",total_marks);
		    	     resp.sendRedirect("StudentExamFinish.jsp");
				
		}*/
		}	
		

		
     
	TestBean testbean=new TestBean();
	ArrayList<TestBean> qusList=new ArrayList<TestBean>();
	Iterator<TestBean> iterator =qusList.iterator();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		System.out.println("Hello");
		String trigerFrom = req.getParameter("aptitude");//Name from JSP
		if (trigerFrom.equals("taketest1"))//takettest1 from JSP
		{

			String topic="Aptitude";
			testbean.setTopic(topic);
			HttpSession session = req.getSession(true);//Setting session
			session.setAttribute("topic",topic);
			TestService testservice = new TestService();//Calling service
			qusList=testservice.ViewAllQuestions(testbean);//calling method ViewAllQuestions
			
			System.out.println("In Controller qusList"+qusList);
			req.setAttribute("qusList",qusList);
			 iterator =qusList.iterator();
			req.getRequestDispatcher("Student_Test.jsp").forward(req, resp);
		}

		if (trigerFrom.equals("taketest2"))//takettest2 from JSP
		{

			String topic="C";
			testbean.setTopic(topic);
			HttpSession session = req.getSession(true);//Setting session
			session.setAttribute("topic",topic);
			TestService testservice = new TestService();//Calling service
			qusList=testservice.ViewAllQuestions(testbean);//calling method ViewAllQuestions
			System.out.println("In Controller qusList"+qusList);
			req.setAttribute("qusList",qusList);
			 iterator =qusList.iterator();
			req.getRequestDispatcher("Student_Test.jsp").forward(req, resp);
		}
		
		 if (trigerFrom.equals("taketest3"))//takettest3 from JSP
		{

			String topic="JAVA";
			testbean.setTopic(topic);
			HttpSession session = req.getSession(true);//Setting session
			session.setAttribute("topic",topic);
			TestService testservice = new TestService();//Calling service
			qusList=testservice.ViewAllQuestions(testbean);//calling Method ViewAllQuestions
			System.out.println("In Controller qusList"+qusList);
			req.setAttribute("qusList",qusList);
			 iterator =qusList.iterator();
			req.getRequestDispatcher("Student_Test.jsp").forward(req, resp);
		}
		
			if (trigerFrom.equals("ans"))//ans from JSP
			{
				HttpSession session = req.getSession(true);//Setting session
				int noOfQuestoins = Integer.parseInt(String.valueOf(session.getAttribute("size")));//Getting size from session
				int marks=0,total_marks=0,score=0;
				for(int i=1;i<=noOfQuestoins;i++) 
				{
				String studentoption=req.getParameter(String.valueOf(i));
				String studentquestion=req.getParameter("Ques"+String.valueOf(i));
				TestBean testbean = new TestBean();
				testbean.setStudentOption(studentoption);
				testbean.setQuestion(studentquestion);
				TestService studentService = new TestService();//Calling service
				 
					try {
						marks = studentService.AnswerCheck(testbean);//calling AnswerCheck
					} catch (SQLException e) {
						e.printStackTrace();
					}
				 if(marks==1) //Marks validation
					 total_marks=total_marks+1;
		
				}
				System.out.println(total_marks);//Displays Total Marks
				HistoryBean historybean = new HistoryBean();
				historybean.setEmail(String.valueOf(session.getAttribute("email")));//Getting Email from session	
				historybean.setScore(total_marks);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");//Date format
				 Calendar calobj = Calendar.getInstance();
			       String dateandtime=(String)df.format(calobj.getTime());  
			       historybean.setDate(dateandtime);
			       historybean.setStudentName(String.valueOf(session.getAttribute("uname")));//Getting uname from session
			       historybean.setTopic(String.valueOf(session.getAttribute("topic")));
			     TestService testservice= new TestService();
			     try {
					int check = testservice.SetHistory( historybean);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			    	     req.setAttribute("result",historybean);//Display Results
			    	     resp.sendRedirect("StudentExamFinish.jsp?name="+historybean.getScore());
					
			}
			if(trigerFrom.equals("here"))//here  from JSP
			{
				int count=0;
				ArrayList<HistoryBean> testlist=new ArrayList<HistoryBean>();
				HistoryBean history=new HistoryBean();
				HttpSession session = req.getSession(true);//getting session values
			    history.setEmail(String.valueOf(session.getAttribute("email")));//Getting Email from session
				TestService service=new TestService();
				try {
					testlist=service.GetHistory(history);//calling service History
				} catch (SQLException e) {	
					e.printStackTrace();
				}
				
				req.setAttribute("testlist",testlist);	
				req.getRequestDispatcher("Student_History.jsp").forward(req, resp);
			    
			}
	}

	}
