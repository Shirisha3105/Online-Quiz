package com.oqm.service;


import java.sql.SQLException;
import java.util.ArrayList;

import com.oqm.bean.QuestionBean;
import com.oqm.dao.QuestionDAO;

public class QuestionService {
	

	public String addQuestion(QuestionBean questionBean) {
		//Validation for addQuestion
		   //If validations are success then call dao
		String status = "";
		   QuestionDAO questionDao = new QuestionDAO();
		   int count = questionDao.addQuestion(questionBean);
           System.out.println(count);
		   if(count == 1)//Response from dao
			   status = "Success";
		   else
			   status = "Fail";
		   return status;//Returning to controller
	}
	public ArrayList <QuestionBean> ViewAllQuestions(QuestionBean questionBean) {
		//Validation for ViewAllQuestion
		   //If validations are success then call dao
		QuestionDAO questionDao = new QuestionDAO();
		   ArrayList <QuestionBean> QusList= questionDao.ViewAllQuestions(questionBean); 
		   System.out.print("Inside Service");  
		return QusList;//Returning to controller
	}
	public int SearchQus(QuestionBean qus, int num) throws SQLException {
		//Validation for SearchQus
		   //If validations are success then call dao
		QuestionDAO questiondao=new QuestionDAO();
		int count=0;
		count=questiondao.SearchQus(qus,num);//Response from dao
		
		return count;//Returning to controller
	}
	public int UpdateQus(QuestionBean questionBean) throws SQLException 
	{
		//Validation for UpdateQus
		   //If validations are success then call dao
		QuestionDAO questionDao = new QuestionDAO();
		int count=questionDao.UpdateQus(questionBean); //Response from dao
		return count;//Returning to controller
	}
	public int DeleteQus(QuestionBean questionBean) throws SQLException 
	{
		//Validation for DeleteQus
		   //If validations are success then call dao
		QuestionDAO questionDao = new QuestionDAO();
		int count=questionDao.DeleteQus(questionBean); //Response from dao
		return count;//Returning to controller
	}
}