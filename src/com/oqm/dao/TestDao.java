package com.oqm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oqm.DBUtil.DBUtil;
import com.oqm.bean.HistoryBean;
import com.oqm.bean.QuestionBean;
import com.oqm.bean.TestBean;

public class TestDao 
{
	public ArrayList<TestBean> ViewAllQuestions(TestBean testbean){
		ArrayList<TestBean> questionList=new ArrayList<TestBean>();
		try {
			Connection connection=DBUtil.getDBConnection();//Connection to DB file
			String query="select * from oqm_tbl_questions where topic=?";//Query to retrive question
			PreparedStatement preparedStatement = connection.prepareStatement(query);//Calling prepare statement
			preparedStatement.setString(1, testbean.getTopic());//setting the values in query
			ResultSet resultSet = preparedStatement.executeQuery();//executing query
			System.out.println("testbean.getTopic()");
			while(resultSet.next()) {//Output of query
				System.out.println("Inside DAO");	
				TestBean bean = new TestBean();
				System.out.println("H");
				//setting values and adding to list
				bean.setTopic(resultSet.getString("topic"));
				bean.setQuestion(resultSet.getString("question"));
				bean.setOption1(resultSet.getString("option1"));
				bean.setOption2(resultSet.getString("option2"));
				bean.setOption3(resultSet.getString("option3"));
				bean.setOption4(resultSet.getString("option4"));
				bean.setAnswer(resultSet.getString("answer"));
				
				questionList.add(bean);
			}
			resultSet.close();//closing result set
			preparedStatement.close();//closing preparedStatement
		} catch (Exception e) {
			System.out.println(e);
		}
		return questionList;//value passed to service
}

	public int CheckAnswer(TestBean testbean) throws SQLException
	{
		int count=0;
		Connection connection=DBUtil.getDBConnection();//Connection to DB file
		String query="select * from oqm_tbl_questions where question=? and answer=?";//Query to checkAnswer
		PreparedStatement preparedStatement = connection.prepareStatement(query);//Calling prepare statement
		System.out.println("query"+query);
		/*Getting the values from query*/
		System.out.println("testbean.getQuestion"+testbean.getQuestion());
		System.out.println("testbean.getStudentOption"+testbean.getStudentOption());
		/*setting the values in query*/
		preparedStatement.setString(1, testbean.getQuestion());
		preparedStatement.setString(2, testbean.getStudentOption());
		ResultSet resultSet = preparedStatement.executeQuery();//executing query
		count = preparedStatement.executeUpdate();
	
		//testbean.setTopic(resultSet.getString("topic"));
		return count;//value passed to service
	}
	public int SetHistory(HistoryBean historybean) throws SQLException {
		int	count=0;
		Connection connection=DBUtil.getDBConnection();//Connection to DB file
		String query="insert into oqm_tbl_history values(?,?,?,?,?)";//Query to insert into History table
		System.out.println("history query is"+query);
		PreparedStatement preparedstatement=connection.prepareStatement(query);//Calling prepare statement
		/*setting the values in query*/
		preparedstatement.setString(1, historybean.getTopic());
		preparedstatement.setString(2, historybean.getDate());
		preparedstatement.setString(3, historybean.getStudentName());
		preparedstatement.setString(4, historybean.getEmail());
		preparedstatement.setInt(5, historybean.getScore());
		count = preparedstatement.executeUpdate();
		return count;//value passed to service
		
	}

	public ArrayList<HistoryBean> GetHistory(HistoryBean historybean) throws SQLException
	{
	  int count=0;
	  ArrayList<HistoryBean> testlist=new ArrayList<HistoryBean>();
		Connection connection=DBUtil.getDBConnection();//Connection to DB file
		String query="select * from oqm_tbl_history where email=?";//Query to retrieve History table
		PreparedStatement preparedstatement=connection.prepareStatement(query);//Calling prepare statement
		preparedstatement.setString(1, historybean.getEmail());
		ResultSet resultset=preparedstatement.executeQuery();//executing query
		while(resultset.next())
		{
		   HistoryBean historyBean=new HistoryBean();
		   /*Getting the values from query*/
		   historyBean.setTopic(resultset.getString("topic"));
		   System.out.println(historyBean.getTopic());
		   System.out.println(historyBean.getDate());
		   System.out.println(historyBean.getStudentName());
		   System.out.println(historyBean.getEmail());
		   System.out.println(historyBean.getScore());
		   /*setting the values in query*/
		   historyBean.setEmail(resultset.getString("email"));
		   historyBean.setStudentName(resultset.getString("student_name"));
		   historyBean.setDate(resultset.getString("dateandtime"));
		   historyBean.setScore(resultset.getInt("score"));
		   testlist.add(historyBean);
		}
		count = preparedstatement.executeUpdate();
		return testlist;//value passed to service
	}
}

