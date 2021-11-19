package com.oqm.service;

import com.oqm.bean.OqmBean;
import com.oqm.dao.OqmDAO;

public class OqmService {
	public String insertUser(OqmBean oqmBean) {
		   //Validation for SignUp
		   //If validations are success then call dao
		   String status = "";
		   System.out.println("Service");
		   OqmDAO oqmDao = new OqmDAO();
		   int count = oqmDao.insertUser(oqmBean);
		   if(count == 1)//Response from dao
			   status = "Success";
		   else
			   status = "Fail";
		   return status;//Returning to controller
			
	   }
	public OqmBean loginUser(OqmBean oqmBean) {
		 //Validation for Login
		   //If validations are success then call dao
		   String status = "";
		   OqmDAO oqmDao = new OqmDAO();
		   OqmBean oqmBean1 = oqmDao.loginUser(oqmBean);//Response from dao
		   return oqmBean1;
			
	   }
	public String changePassword(OqmBean oqmBean) {
		 //Validation for Change Password
		   //If validations are success then call dao
		   String status = "";
		   OqmDAO oqmDao = new OqmDAO();
		   int count = oqmDao.changePassword(oqmBean);
		   if(count == 1)//Response from dao
			   status = "Success";
		   else
			   status = "Fail";
		   return status;//Returning to controller
			
	   }
	
	public String forgotPassword(OqmBean oqmBean) {
		 //Validation for Forgot Password
		   //If validations are success then call dao
		   String status = "";
		   OqmDAO oqmDao = new OqmDAO();
		   int count = oqmDao.forgotPassword(oqmBean);
		   if(count == 1)//Response from dao
			   status = "Success";
		   else
			   status = "Fail";
		   return status;//Returning to controller
			
	   }
}
