package com.oqm.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oqm.DBUtil.DBUtil;
import com.oqm.bean.OqmBean;


public class OqmDAO {
	public int insertUser(OqmBean oqmBean) {
		int count = 0;//Variable to store query output
		int count1=0;//Variable to store count query output
		String abc=null;
		try {			
			Connection connection = DBUtil.getDBConnection();//Connection to DB file
			try {
				String query = "SELECT COUNT(*) emaildetails from oqm_tbl_users where email =?";//Query to know the existing Email Id in table
				PreparedStatement preparedStatement = connection.prepareStatement(query);//Calling prepare statement
				System.out.println("oqmBean.getEmail()"+oqmBean.getEmail());
				System.out.println("query.getEmail()"+query);
				preparedStatement.setString(1, oqmBean.getEmail());//setting the values in query
				ResultSet rs=preparedStatement.executeQuery();//executing query
				while(rs.next())
				{
				 abc=rs.getString("emaildetails");//output of query
					//count1++;
					System.out.println("abc"+abc);
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		//count1=Integer.parseInt("abc");
		//System.out.println("count1 is"+count);
		if(abc.equalsIgnoreCase("0") ){//If output is 0 it will insert new user
			String query = "insert into oqm_tbl_users values(?,?,?,?,?)";//Query for insertion
			PreparedStatement preparedStatement = connection.prepareStatement(query);//Calling prepare statement
			/*//setting the values in query*/
			preparedStatement.setString(1, oqmBean.getName());
			preparedStatement.setString(2, oqmBean.getEmail());
			preparedStatement.setString(3, oqmBean.getPassword());
			preparedStatement.setString(4, oqmBean.getMobileno());
			preparedStatement.setString(5, oqmBean.getDesignation());
			
			count = preparedStatement.executeUpdate();//Executing the query and storing in count
			System.out.println(count);
		} }catch (Exception e) {
			System.out.println(e);
		}
		return count;//value passed to service
	}
	public OqmBean loginUser(OqmBean oqmBean) {
	    OqmBean oqmBean1=null;
		try {			
			Connection connection = DBUtil.getDBConnection();//Connection to DB file
			String query = "select * from oqm_tbl_users where email=? and password=?";//query for Loginuser
			PreparedStatement preparedStatement = connection.prepareStatement(query);//Calling prepare statement
			/*//setting the values in query*/
			preparedStatement.setString(1, oqmBean.getEmail());
			preparedStatement.setString(2, oqmBean.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();//executing query
			while(resultSet.next()) {
			     oqmBean1=new OqmBean();
			     //Setting output of query
			     oqmBean1.setName(resultSet.getString("name"));
			     oqmBean1.setDesignation(resultSet.getString("designation"));
			     
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return oqmBean1;//value passed to service
	}
	public int changePassword(OqmBean oqmBean)
	{
		int count = 0;
		try {			
			Connection connection = DBUtil.getDBConnection();//Connection to DB file
			String query = "update oqm_tbl_users set password=? where email=? and password=?";//Query for ChangePassword
			PreparedStatement preparedStatement = connection.prepareStatement(query);//Calling prepare statement
			/*//setting the values in query*/
			preparedStatement.setString(2, oqmBean.getEmail());
			preparedStatement.setString(1,oqmBean.getCpassword());
			preparedStatement.setString(3,oqmBean.getPassword());
			
			String s=oqmBean.getEmail();
			System.out.println(s);
			count = preparedStatement.executeUpdate();//Executing the query and storing in count
			System.out.println(count);
		} catch (Exception e) {
			System.out.println(e);
		}
		return count;//value passed to service
	}
	
	public int forgotPassword(OqmBean oqmBean)
	{
		System.out.println("in dao");
		int count = 0;
		try {			
			Connection connection = DBUtil.getDBConnection();//Connection to DB file
			String query = "update oqm_tbl_users set password=? where email=?";//query for forgotPassword
			System.out.println("query is"+query);
			PreparedStatement preparedStatement = connection.prepareStatement(query);//Calling prepare statement
			/*//setting the values in query*/
			preparedStatement.setString(2, oqmBean.getEmail());
			preparedStatement.setString(1,oqmBean.getPassword());
			//preparedStatement.setString(3,oqmBean.getPassword());
			
			String s=oqmBean.getEmail();
			System.out.println(s);
			count = preparedStatement.executeUpdate();//Executing the query and storing in count
			System.out.println(count);
		} catch (Exception e) {
			System.out.println(e);
		}
		return count;//value passed to service
	}
}

