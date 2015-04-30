package com.mycompany.brainstorm;

import java.util.ArrayList;

/**
 * Created by vladi on 30/04/2015.
 */
public class User {

    private String _password;
    private String _username;
    private String _email;
    private int _phoneNum;
    private ArrayList<Course> _courses;

    public User(String password, String username, String email,
                int phoneNum){

        if (this._courses == null)
            this._courses = new ArrayList<Course>();
        this._password = password;
        this._username = username;
        this._phoneNum = phoneNum;
    }

    public String get_password(){
        System.out.println("stam 123");
        return this._password;
    }

    public String get_username(){
        return this._username;
    }

    public String get_email(){
        return this._email;
    }

    public int _phoneNum(){
        return this._phoneNum;
    }

    public ArrayList<Course> get_courses(){
        return this._courses;
    }
}