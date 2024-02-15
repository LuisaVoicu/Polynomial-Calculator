package com.datamodel;

import java.math.RoundingMode;
import java.text.DecimalFormat;
public class Monomial {
    private Integer degree;
    private Float coefficient;

    public Monomial (Integer degree, Float coefficient){
        this.degree = degree;
        this.coefficient = coefficient;
    }

    public void addition (Monomial a) throws Exception {
        if(!degree.equals(a.getDegree())){
            throw new Exception("Monoamele nu au acelasi grad. Nu se poate efectua operatia de ADUNARE!");
        }
        coefficient += a.getCoefficient();

    }

    public void subtraction (Monomial a) throws Exception {
        if(!degree.equals(a.getDegree())) {
            throw new Exception("Monoamele nu au acelasi grad. Nu se poate efectua operatia de SCADERE!");
        }
        coefficient -= a.getCoefficient();
    }

    public static Monomial multiplication (Monomial a, Monomial b){
        Integer resultDegree = a.getDegree() + b.getDegree();
        Float resultCoefficient = a.getCoefficient() * b.getCoefficient();
        return new Monomial(resultDegree,resultCoefficient);
    }

    public static Monomial division(Monomial a, Monomial b) throws Exception{
        int degA = 0;
        int degB = 0;
        if(a!=null){
            degA = a.getDegree();
        }
        if(b!=null){
            degB = b.getDegree();
        }
        Integer resultDegree = degA - degB;
        Float coeffA = Float.valueOf(0);
        Float coeffB = Float.valueOf(0);
        if(a!=null){
            coeffA=a.getCoefficient();
        }
        if(b!=null){
            coeffB=b.getCoefficient();
        }
        if(coeffB == 0){
            throw new Exception("Impartitorul nu poate fi 0!");
        }
        Float resultCoefficient = coeffA / coeffB;
        return new Monomial(resultDegree,resultCoefficient);
    }

    public static Monomial derivative(Monomial a){
        Integer degree = a.getDegree();
        a.setCoefficient(a.getCoefficient() * degree);
        a.setDegree(degree-1);
        return a;
    }

    public static Monomial integral(Monomial a){
        Integer degree = a.getDegree();
        a.setDegree(degree+1);
        a.setCoefficient(a.coefficient/(degree+1));
        return a;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        String s ="";
        if(degree!=0){
            if(df.format(coefficient).compareTo(String.valueOf(-1))==0) {
                s += "-";
            }else if(df.format(coefficient).compareTo(String.valueOf(1))!=0) {
                s += df.format(coefficient);
            }
        }else{
            s += df.format(coefficient);
        }
        if(degree>0){
            if(degree!=1) {
                s += "x^" + degree;
            }
            else{
                s+="x";
            }
        }
        return s;
    }

    public Integer getDegree(){
        return degree;
    }

    public Float getCoefficient(){
        return coefficient;
    }

    public void setDegree(Integer degree){
        this.degree=degree;
    }

    public void setCoefficient(Float coefficient){
        this.coefficient=coefficient;
    }


}
