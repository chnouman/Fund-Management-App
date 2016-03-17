package com.example.haresh.dinero;

/**
 * Created by ajayrahul on 16/3/16.
 */
public class userdata {
    private String _name, _email, _password;

    private int _id;


    public userdata(int id, String name, String email, String password) {
        _id = id;
        _name = name;
        _email = email;
        _password = password;

    }

    public String get_name() {
        return _name;
    }

    public int get_id() {
        return _id;
    }

    public String get_email() {
        return _email;
    }

    public String get_password() {
        return _password;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}