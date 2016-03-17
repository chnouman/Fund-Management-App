package com.example.haresh.dinero;

/**
 * Created by ajayrahul on 16/3/16.
 */
public class fundlistdata {
    private String _fundname;

    private int _id;



    public fundlistdata(int id, String fundname) {
        _id = id;

       _fundname=fundname;


    }

    public int get_id() {
        return _id;
    }

    public String get_fundname() {
        return _fundname;
    }




    public void set_fundname(String _fundname) {
        this._fundname = _fundname;
    }

   public void set_id(int _id) {
        this._id = _id;
    }
}