package com.example.haresh.dinero;

/**
 * Created by ajayrahul on 16/3/16.
 */
public class funddata {
    private String _name,_fundname,_details;

    private int _id,_trans;



    public funddata(int id, String name, String fundname, int trans,String details) {
        _id = id;
        _name = name;
       _fundname=fundname;
        _trans=trans;
        _details=details;

    }

    public String get_name() {
        return _name;
    }
    public String get_details() {
        return _details;
    }


    public int get_id() {
        return _id;
    }

    public String get_fundname() {
        return _fundname;
    }
    public int get_trans() {
        return _trans;
    }


   public void set_name(String _name) {
       this._name = _name;
   }
    public void set_details(String _details) {
        this._details = _details;
    }

    public void set_fundname(String _fundname) {
        this._fundname = _fundname;
    }

    public void set_trans(int _trans) {
        this._trans = _trans;
    }


    public void set_id(int _id) {
        this._id = _id;
    }
}