package com.oqm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.Servlet;

import com.oqm.bean.OqmBean;
import com.oqm.service.OqmService;

//@SuppressWarnings("serial")
public class OqmController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1749776600209731956L;
	OqmBean oqmBean = new OqmBean();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String trigerFrom = req.getParameter("Insert");//Name from JSP
		if (trigerFrom.equals("Register")) {//Register from JSP
			/*User Input Fields */
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password= req.getParameter("password");
			String cpassword= req.getParameter("cpassword");
			String number= req.getParameter("mobileno");
			String designation= req.getParameter("designation");
			/*Setting User Input Fields */
			oqmBean.setName(name);
			oqmBean.setEmail(email);
			oqmBean.setPassword(password);
			oqmBean.setCpassword(cpassword);
			oqmBean.setMobileno(number);
			oqmBean.setDesignation(designation);
			OqmService employeeService = new OqmService();//Calling service
			String status = employeeService.insertUser(oqmBean);//Calling Method insertUser

			if (status.equals("Success")) {//Response from service
				/*Redirection Page*/
				resp.sendRedirect("LandingPage.jsp");
			} else {
				resp.sendRedirect("InsertFail.jsp");
			}

		}
		if(trigerFrom.equals("Log in"))//Login From JSP
		{
			//User Input Fields
			String email = req.getParameter("email");
			String password= req.getParameter("password");
			/*Setting User Input Fields */
			oqmBean.setEmail(email);
			oqmBean.setPassword(password);
			OqmService oqmService = new OqmService();//Calling Service
			OqmBean bean = oqmService.loginUser(oqmBean);//Calling Method LoginUser
			HttpSession session=req.getSession(true);//Getting Session values
			if(bean!=null)
			{
				
			session.setAttribute("uname",bean.getName());
			session.setAttribute("designation",bean.getDesignation());
			}
            if((bean!=null)&&(bean.getDesignation().equals("professor")))//Response from service
            {
            	resp.sendRedirect("ProfessorHome.jsp?name="+oqmBean.getEmail());//Redirection Page
            }
            
            else if(bean!=null)
            {
            	resp.sendRedirect("Student_Home.jsp?name="+oqmBean.getEmail());//Redirection Page
            }
            else
            {
            	resp.sendRedirect("LoginFail.jsp");//Redirection Page
            }
			
		}
		if(trigerFrom.equals("submit"))//Submit from JSP
		{
			System.out.println("came here to submit in contoller ");
			/*User Inputs*/
			String password= req.getParameter("currentpassword");
			String newpassword= req.getParameter("newpassword");//User Input
			String cpassword = req.getParameter("confirmpassword");
			String status="";
			/*Validating Passwords*/
			if(newpassword.equals(cpassword))
			{
				if( password.equals(newpassword))
				{
					
				}
				else
				{
					/*Setting User Inputs*/
				oqmBean.setPassword(password);
				oqmBean.setCpassword(cpassword);
				OqmService oqmService = new OqmService();//Calling Service
			    status = oqmService.changePassword(oqmBean);//Calling Method ChangePassword
				}
			}	
			HttpSession session=req.getSession(true);//Getting Session Values
			String desi=String.valueOf(session.getAttribute("designation"));//Getting designation
			System.out.println("came here to designation in contoller "+desi);
			if (status.equals("Success")) {//Response from Service
				if(desi.equals("student")) {//Redirecting to JSP based on designation
				resp.sendRedirect("Student_Home.jsp");////Redirection Page
				}else
				{
					resp.sendRedirect("ProfessorHome.jsp");//Redirection Page
				}
			} else {
				resp.sendRedirect("PwdUpdateFail.jsp");//Redirection Page
			}
		}
		
		if(trigerFrom.equals("forgotpw"))//Forgot Password from JSP
		{
			System.out.println("came here to forgotpw in contoller ");
			/*User Inputs*/
			String email= req.getParameter("email");
			String newpassword= req.getParameter("newpassword");
			String cpassword = req.getParameter("confirmpassword");
			String status="";
			System.out.println("came here to newpassword in contoller "+newpassword);
			System.out.println("came here to cpassword in contoller "+cpassword);
			System.out.println("came here to email in contoller "+email);
			if(newpassword.equals(cpassword))//Validating Password
			{
				/*Setting User Inputs*/
				oqmBean.setEmail(email);
				oqmBean.setPassword(newpassword);
				
				OqmService oqmService = new OqmService();//Calling Service
			    status = oqmService.forgotPassword(oqmBean);//Calling Method ForgotPassword
				
			}	
			HttpSession session=req.getSession(true);
		//	String desi=String.valueOf(session.getAttribute("designation"));
			if (status.equals("Success")) {//Response from Service
				//if(desi.equals("student"))
				resp.sendRedirect("LandingPage.jsp");//Redirection Page
			} else {
				resp.sendRedirect("Forgotpasswordfail.jsp");//Redirection Page
			}
		}
		
		}
	}

    
	
