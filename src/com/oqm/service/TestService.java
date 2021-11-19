package com.oqm.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.oqm.bean.HistoryBean;
import com.oqm.bean.QuestionBean;
import com.oqm.bean.TestBean;
import com.oqm.dao.QuestionDAO;
import com.oqm.dao.TestDao;

public class TestService 
{
	public ArrayList <TestBean> ViewAllQuestions(TestBean testbean) {
		//Validation for ViewAllQuestion
		   //If validations are success then call dao
		TestDao testdao = new TestDao();
		   ArrayList <TestBean> QusList= testdao.ViewAllQuestions(testbean); 
		   System.out.println("Inside Service");  
	  	   return QusList;//Returning to controller
	}
	
	public int AnswerCheck(TestBean testbean) throws SQLException 
	{
		//Validation for AnswerCheck
		   //If validations are success then call dao
		int count=0;
		TestDao testdao=new TestDao();
		count=testdao.CheckAnswer(testbean);//Response from dao
		return count;//Returning to controller
	}

	public int SetHistory(HistoryBean historybean) throws SQLException {
		//Validation for SetHistory
		   //If validations are success then call dao
		int count=0;
		TestDao testdao=new TestDao();
		count=testdao.SetHistory(historybean);//Response from dao
		return count;//Returning to controller
	}

	public ArrayList<HistoryBean> GetHistory(HistoryBean history) throws SQLException {
		//Validation for GetHistory
		   //If validations are success then call dao
		ArrayList<HistoryBean> testlist=new ArrayList<HistoryBean>();
		TestDao testdao=new TestDao();
		testlist=testdao.GetHistory(history);
		return testlist;//Returning to controller
	}
}
