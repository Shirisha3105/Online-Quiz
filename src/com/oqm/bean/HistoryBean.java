package com.oqm.bean;

import java.sql.Date;

public class HistoryBean 
{
	private String topic;
	private String date;
	private String student_name;
	private String email; 
    private int score;
    
    public void setTopic(String topic)
    {
    	this.topic=topic;
    }
    public String getTopic()
    {
    	return topic;
    }
    public void setDate(String dateandtime)
    {
    	this.date=dateandtime;
    }
    public String getDate()
    {
    	return date;
    }
    public void setStudentName(String student_name)
    {
    	this.student_name=student_name;
    }
    public String getStudentName()
    {
    	return student_name;
    }
    public void setEmail(String email)
    {
    	this.email=email;
    }
    public String getEmail()
    {
    	return email;
    }
    public void setScore(int score)
    {
    	this.score=score;
    }
    public int getScore()
    {
    	return score;
    }
    
}
