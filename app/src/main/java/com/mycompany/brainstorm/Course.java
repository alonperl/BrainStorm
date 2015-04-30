package com.mycompany.brainstorm;

public class Course {
	private String _courseName;
	private int _id;

	
	public Course(int _id, String _courseName){
		this._id = _id;
		this._courseName = _courseName;	
	}
	
	public String get_courseName(){
		return this._courseName;
		
	}

	public int get_courseId(){
		return this._id;
	}
}
