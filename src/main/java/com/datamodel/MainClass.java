package com.datamodel;

import com.mvc.*;

public class MainClass {
    public static void main(String[] args){
        View v = new View();
        Model m = new Model(v);
        new Controller(v, m);
    }
}
