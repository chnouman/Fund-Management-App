package com.example.haresh.dinero;

/**
 * Created by ajayrahul on 16/3/16.
 */
public class memberfunddata {
    private String _name,_fundname;

    private int _id;



    public memberfunddata(int id, String name, String fundname) {
        _id = id;
        _name = name;
       _fundname=fundname;


    }

    public String get_name() {
        return _name;
    }

    public int get_id() {
        return _id;
    }

    public String get_fundname() {
        return _fundname;
    }


   public void set_name(String _name) {
       this._name = _name;
   }

    public void set_fundname(String _fundname) {
        this._fundname = _fundname;
    }

       public void set_id(int _id) {
        this._id = _id;
    }
}