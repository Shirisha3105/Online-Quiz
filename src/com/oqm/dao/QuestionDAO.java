package com.oqm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oqm.DBUtil.DBUtil;
import com.oqm.bean.QuestionBean;

public class QuestionDAO {
	public int addQuestion(QuestionBean questionBean) {
		int count = 0;//Variable to store query output
		String quesn="NONE";
		try {			
			Connection connection = DBUtil.getDBConnection();//Connection to DB file
			try {
				String query = "select count(*) totalqnos from oqm_tbl_questions where topic=? and question=?";//Query to know existing question in DB
				PreparedStatement preparedStatement = connection.prepareStatement(query);//Calling prepare statement	
				preparedStatement.setString(1, questionBean.getTopic());//setting the values in query
				preparedStatement.setString(2, questionBean.getQuestion());//setting the values in query
				ResultSet rs=preparedStatement.executeQuery();//executing query
				while(rs.next()) {
				 quesn=rs.getString("totalqnos");	//output of query
				System.out.println("quesn"+quesn);
				}
				
				}catch (Exception e) {
				System.out.println(e);
				}
		//	int qno=Integer.parseInt("quesn");
		//	System.out.println("qno"+qno);
			if(quesn.equalsIgnoreCase("0"))//If output is 0 it will add new question
			{
			String query = "insert into oqm_tbl_questions values(?,?,?,?,?,?,?,?)";//Query for addition of question
			PreparedStatement preparedStatement = connection.prepareStatement(query);	//Calling prepare statement
			/*setting the values in query*/
			preparedStatement.setString(1, questionBean.getTopic());
			preparedStatement.setString(2, questionBean.getQuestion());
			preparedStatement.setString(3, questionBean.getOption1());
			preparedStatement.setString(4, questionBean.getOption2());
			preparedStatement.setString(5, questionBean.getOption3());
			preparedStatement.setString(6, questionBean.getOption4());
			preparedStatement.setString(7, questionBean.getAnswer());
			preparedStatement.setString(8, questionBean.getEmail());
			count = preparedStatement.executeUpdate();//Executing the query and storing in count
			System.out.println(count);
		}
		}catch (Exception e) {
			System.out.println(e);
		}
		return count;//value passed to service
	}
	public ArrayList<QuestionBean> ViewAllQuestions(QuestionBean questionbean){
		ArrayList<QuestionBean> questionList=new ArrayList<QuestionBean>();
		try {
			Connection connection=DBUtil.getDBConnection();//Connection to DB file
			String query="select * from oqm_tbl_questions where topic=? and email=?";//Query for retrive questions
			System.out.println("query is"+query);
			PreparedStatement preparedStatement = connection.prepareStatement(query);//Calling prepare statement
			/*setting the values in query*/
			preparedStatement.setString(1, questionbean.getTopic());
			preparedStatement.setString(2, questionbean.getEmail());
			System.out.println("questionbean.getEmail()"+questionbean.getEmail());
			ResultSet resultSet = preparedStatement.executeQuery();//executing query
			while(resultSet.next()) {
				System.out.println("Inside DAO");
				System.out.println("helooo");
				QuestionBean bean = new QuestionBean();
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
			System.out.println("Dao " +  questionList);
		} catch (Exception e) {
			System.out.println(e);
		}
		return questionList;//value passed to service
}
	public int SearchQus(QuestionBean qus, int num) throws SQLException 
	{
		int count=0;
		Connection connection=DBUtil.getDBConnection();//Connection to DB file
		String query="select * from oqm_tbl_questions where topic=?";//Query for SearchQus
		PreparedStatement preparedStatement = connection.prepareStatement(query);//Calling prepare statement
		preparedStatement.setString(1, qus.getTopic());//setting the values in query
		ResultSet resultSet = preparedStatement.executeQuery();//Executing prepare statement
		while(resultSet.next())
		{
		  count++;
		if(count==num)
		{
			break;
		}
		}
		count=preparedStatement.executeUpdate();//Executing the query and storing in count
		//setting values
		qus.setTopic(resultSet.getString("topic"));
		qus.setQuestion(resultSet.getString("question"));
		qus.setOption1(resultSet.getString("option1"));
		qus.setOption2(resultSet.getString("option2"));
		qus.setOption3(resultSet.getString("option3"));
		qus.setOption4(resultSet.getString("option4"));
		qus.setAnswer(resultSet.getString("answer"));
		return count;//value passed to service
	}
	public int UpdateQus(QuestionBean questionBean) throws SQLException {
		int count=0;
		Connection connection=DBUtil.getDBConnection();//Connection to DB file
		String query = "update oqm_tbl_questions set question=?,option1=?,option2=?,option3=?,option4=?,answer=?,topic=? where question=?";//Query for UpdateQus
		System.out.println("query for update is"+query);
		PreparedStatement preparedStatement = connection.prepareStatement(query);	//Calling prepare statement
		/*setting the values in query*/
		preparedStatement.setString(1, questionBean.getQuestion());
		preparedStatement.setString(2, questionBean.getOption1());
		preparedStatement.setString(3, questionBean.getOption2());
		preparedStatement.setString(4, questionBean.getOption3());
		preparedStatement.setString(5, questionBean.getOption4());
		preparedStatement.setString(6, questionBean.getAnswer());
		preparedStatement.setString(7, questionBean.getTopic());
		preparedStatement.setString(8, questionBean.getOldQuestion());
		count=preparedStatement.executeUpdate();//Executing the query and storing in count
		return count;//value passed to service
	}
	public int DeleteQus(QuestionBean questionBean) throws SQLException {
		int count=0;
		Connection connection=DBUtil.getDBConnection();//Connection to DB file
		String query = "delete from oqm_tbl_questions where topic=? and question=?";//Query for DeleteQus
		System.out.println("query for update is"+query);
		PreparedStatement preparedStatement = connection.prepareStatement(query);	//Calling prepare statement
//		preparedStatement.setString(1, questionBean.getQuestion());
//		preparedStatement.setString(2, questionBean.getOption1());
//		preparedStatement.setString(3, questionBean.getOption2());
//		preparedStatement.setString(4, questionBean.getOption3());
//		preparedStatement.setString(5, questionBean.getOption4());
//		preparedStatement.setString(6, questionBean.getAnswer());
		
		/*setting the values in query*/
		preparedStatement.setString(1, questionBean.getTopic());
		preparedStatement.setString(2, questionBean.getOldQuestion());
		
		preparedStatement.execute();//Executing the query and storing in count
		
		System.out.println("count"+count);
		
		return count;//value passed to service
	}
		
}