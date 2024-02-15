package com.mvc;


import com.datamodel.Polynomial;
public class Model {

    private Polynomial p1;
    private Polynomial p2;

    public Model(View view) {
        String polynomial1 = view.getPolynomial1Text();
        String polynomial2 = view.getPolynomial2Text();
        System.out.println("in model view:::: ");
        System.out.println(polynomial1);
        System.out.println(polynomial2);
    }

    public void setP1(Polynomial p1) {
        this.p1 = p1;
    }

    public Polynomial getP1() {
        return p1;
    }

    public void setP2(Polynomial p2) {
        this.p2 = p2;
    }

    public Polynomial getP2() {
        return p2;
    }
}
