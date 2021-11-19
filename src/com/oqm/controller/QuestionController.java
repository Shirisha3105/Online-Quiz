package com.oqm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oqm.bean.QuestionBean;
import com.oqm.service.QuestionService;

public class QuestionController extends HttpServlet {
	QuestionBean questionBean = new QuestionBean();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
		System.out.println("Hello");
		String trigerFrom = req.getParameter("questionButton");//Name from JSP
		
		if (trigerFrom.equals("Add"))//Add from JSP
		{
			//String topic=req.getParameter("topic");
			/*User Input Fields */
			String question = req.getParameter("question");
			String option1= req.getParameter("option1");
			String option2= req.getParameter("option2");
			String option3=req.getParameter("option3")
			String option4= req.getParameter("option4");
			String answer= req.getParameter("answer");
			//questionBean.setTopic(topic);
			HttpSession session = req.getSession(true);//Setting session
			//session.setAttribute("topic","Aptitude" );
			String email=(String) session.getAttribute("email");//Getting Email from session
			
			System.out.println("email in controller"+email);
			/*Setting User Input Fields */
			questionBean.setQuestion(question);
			questionBean.setOption1(option1);
			questionBean.setOption2(option2);
			questionBean.setOption3(option3);
			questionBean.setOption4(option4);
			questionBean.setAnswer(answer);
			questionBean.setEmail(email);
		//	questionBean.setEmail(String.valueOf(session.getAttribute("email")));	
//			HttpSession session = req.getSession(true);
//			session.getAttribute("email");
//			System.out.println("String.valueOf(session.getAttribute(\"email\")"+session.getAttribute("email"));
			QuestionService qService = new QuestionService();//Calling services
			String status = qService.addQuestion(questionBean);//Calling Method addQuestion
System.out.println("questionBean.getTopic()"+questionBean.getTopic());
System.out.println("questionBean.getTopic()"+questionBean.getTopic());
System.out.println("questionBean.getTopic()"+questionBean.getEmail());
			if (status.equals("Success")) {//Response from service
				/*Redirecting page*/
				resp.sendRedirect("AddQuestion.jsp?selectedTopic?="+questionBean.getTopic());
			} else {
				resp.sendRedirect("AddQuestionFail.jsp?selectedTopic?="+questionBean.getTopic());
			}

		}
		if (trigerFrom.equals("Aptitude"))//Aptitude from JSP
		{
			/*User Input fields*/
			String topic=req.getParameter("questionButton");
			System.out.println("dhg");
			questionBean.setTopic(topic);//setting user Input fields
			QuestionService questionService = new QuestionService();//Calling service
			ArrayList<QuestionBean> qusList=questionService.ViewAllQuestions(questionBean);//calling Method ViewAllQuestions
			System.out.println("In Controller qusList"+qusList);
			HttpSession session = req.getSession(true);  //getting session values                     
			session.setAttribute("topic","Aptitude" );
			req.setAttribute("qusList",qusList);
			req.getRequestDispatcher("ProfessorViewAll.jsp").forward(req, resp);
		}
		if (trigerFrom.equals("C"))//C from JSP
		{
			/*User Input fields*/
			String topic=req.getParameter("questionButton");
			questionBean.setTopic(topic);//setting user Input fields
			QuestionService questionService = new QuestionService();//Calling service
			ArrayList<QuestionBean> qusList=questionService.ViewAllQuestions(questionBean);//calling Method ViewAllQuestions
			System.out.println("In Controller qusList"+qusList);
			HttpSession session = req.getSession(true);//getting session values
			session.setAttribute("topic","C" );
			req.setAttribute("qusList",qusList);
			req.getRequestDispatcher("ProfessorViewAll.jsp").forward(req, resp);
		}
		if (trigerFrom.equals("JAVA"))//JAVA from JSP
		{
			/*User Input fields*/
			String topic=req.getParameter("questionButton");
			questionBean.setTopic(topic);//setting user Input fields
			QuestionService questionService = new QuestionService();//Calling service
			ArrayList<QuestionBean> qusList=questionService.ViewAllQuestions(questionBean);//calling Method ViewAllQuestions
			System.out.println("In Controller qusList"+qusList);
			HttpSession session = req.getSession(true);//getting session values
			session.setAttribute("topic","JAVA" );
			req.setAttribute("qusList",qusList);//setting request
			req.getRequestDispatcher("ProfessorViewAll.jsp").forward(req, resp);//getting RequestDispatcher
		}
		
}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside Controller");
		String trigerFrom = req.getParameter("questionButton");
		
		if (trigerFrom.equals("Aptitude")) {
			System.out.println("Inside Controller1");
			QuestionService questionService = new QuestionService();//Calling service
			questionBean.setTopic("Aptitude");
			HttpSession session = req.getSession(true);//getting session values
			session.setAttribute("topic","Aptitude" );
			String email=(String) session.getAttribute("email");
			
			questionBean.setEmail(email);
			ArrayList<QuestionBean> qusList=questionService.ViewAllQuestions(questionBean);
			System.out.println("In Controller qusList"+qusList);
			req.setAttribute("qusList",qusList);
			req.getRequestDispatcher("ProfessorViewAll.jsp").forward(req, resp);

		}
		if (trigerFrom.equals("C"))
		{
			String topic=req.getParameter("questionButton");
			questionBean.setTopic("C");
			HttpSession session = req.getSession(true);//getting session values
			session.setAttribute("topic","C" );
String email=(String) session.getAttribute("email");
			
			questionBean.setEmail(email);
			QuestionService questionService = new QuestionService();
			ArrayList<QuestionBean> qusList=questionService.ViewAllQuestions(questionBean);
			System.out.println("In Controller qusList"+qusList);
			req.setAttribute("qusList",qusList);
			req.getRequestDispatcher("ProfessorViewAll.jsp").forward(req, resp);
		}
		if (trigerFrom.equals("JAVA"))
		{
			String topic=req.getParameter("questionButton");
			questionBean.setTopic("JAVA");
			HttpSession session = req.getSession(true);//getting session values
			session.setAttribute("topic","JAVA" );
String email=(String) session.getAttribute("email");
			
			questionBean.setEmail(email);
			QuestionService questionService = new QuestionService();
			ArrayList<QuestionBean> qusList=questionService.ViewAllQuestions(questionBean);
			System.out.println("In Controller qusList"+qusList);
			req.setAttribute("qusList",qusList);
			req.getRequestDispatcher("ProfessorViewAll.jsp").forward(req, resp);
		}
	if(trigerFrom.equals("Update"))
	{
		System.out.println("in update controller");
		int count=0;
		/*User Input Fields */
		String question = req.getParameter("question");
		String option1= req.getParameter("option1");
		String option2= req.getParameter("option2");
		String option3=req.getParameter("option3");
		String option4= req.getParameter("option4");
		String answer= req.getParameter("answer");
		String oldquestion = req.getParameter("oldqus");
		String topic = req.getParameter("topic");
		/*Setting User Input Fields */
		questionBean.setQuestion(question);
		questionBean.setOption1(option1);
		questionBean.setOption2(option2);
		questionBean.setOption3(option3);
		questionBean.setOption4(option4);
		questionBean.setAnswer(answer);
		questionBean.setOldQuestion(oldquestion);
		questionBean.setTopic(topic);
		QuestionService questionService = new QuestionService();//Calling service
		try {
		 count=questionService.UpdateQus(questionBean);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		resp.sendRedirect("ProfessorHome.jsp?name=");//Redirecting page
		
	}
	if(trigerFrom.equals("Delete"))
	{
		System.out.println("in delete controller");
		int count=0;
		/*User Input Fields */
		String question = req.getParameter("question");
		String option1= req.getParameter("option1");
		String option2= req.getParameter("option2");
		String option3=req.getParameter("option3");
		String option4= req.getParameter("option4");
		String answer= req.getParameter("answer");
		String oldquestion = req.getParameter("oldqus");
		String topic = req.getParameter("topic");
		System.out.println("question"+question+"oldquestion"+oldquestion+"topic"+topic);	
		/*Setting User Input Fields */
	questionBean.setQuestion(question);
		questionBean.setOption1(option1);
		questionBean.setOption2(option2);
		questionBean.setOption3(option3);
		questionBean.setOption4(option4);
		questionBean.setAnswer(answer);
		questionBean.setOldQuestion(oldquestion);
		questionBean.setTopic(topic);
		QuestionService questionService = new QuestionService();//Calling service
		try {
		 count=questionService.DeleteQus(questionBean);//calling Method DeleteQus
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		resp.sendRedirect("ProfessorHome.jsp?name=");//Redirecting page
		
	}
    	 
     }
	
	
	
	
	
	
		
		
}

