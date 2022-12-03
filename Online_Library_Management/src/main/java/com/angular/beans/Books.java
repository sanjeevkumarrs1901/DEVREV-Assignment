package com.angular.beans;

public class Books {
	private String title;
	private String author;
	private String subject;
	private String date;
	private int id;
	public Books() {}
	public Books(int id,String title, String author,String subject,String date) {
		super();
		this.title = title;
		this.author = author;
		this.subject=subject;
		this.date=date;
		this.id=id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author=author;
	}
	public String getSubject()
	{
		return subject;
	}
	public void setSubject(String subject)
	{
		this.subject=subject;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date=date;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}

}