package com.datamodel;
import com.constant.Message;

import java.util.*;

public class Polynomial {
    private HashMap<Integer, Monomial> poly;
    private HashMap<Integer, Monomial> reminder;

    public Polynomial(){
        poly = new HashMap<Integer, Monomial>();
        reminder = new HashMap<Integer, Monomial>();
    }

    public void addMonomial(Monomial mon){
        poly.put(mon.getDegree(),mon);
    }

    public void additionPolynomial(Polynomial q) throws Exception{
        for(Monomial value : this.poly.values()){
            Integer degree = value.getDegree();
            if(q.poly.containsKey(degree)){
                value.addition(q.poly.get(degree));
                q.poly.remove(degree);
            }
        }

        for(Monomial value: q.poly.values()){
            this.addMonomial(value);
        }
        q.poly.clear();
    }

    public void subtractionPolynomial(Polynomial q) throws Exception {
        for (Monomial value : this.poly.values()) {
            Integer degree = value.getDegree();
            if (q.poly.containsKey(degree)) {
                value.subtraction(q.poly.get(degree));
                q.poly.remove(degree);
            }
        }
        for (Monomial value : q.poly.values()) {
            value.setCoefficient((-1) * value.getCoefficient());
            this.addMonomial(value);
        }
        q.poly.clear();
    }

    public void multiplicationPolynomial(Polynomial q) throws Exception{
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer,Monomial> entry:poly.entrySet()){
            Polynomial auxResult = new Polynomial();
            for(Map.Entry<Integer,Monomial> secondEntry:q.poly.entrySet()){
                Monomial auxCoefficient = Monomial.multiplication(entry.getValue(),secondEntry.getValue());
                auxResult.addMonomial(auxCoefficient);
            }
            if(result == null){
                result = auxResult;
            }
            else {
                result.additionPolynomial(auxResult);
            }
        }
        this.poly = result.poly;
    }

    public void divisionPolynomial(Polynomial q) throws Exception{
        Polynomial a = this;
        Polynomial b = q;
        Polynomial result = new Polynomial();

        Integer i = this.getCoefficientOfMaxPower();
        Integer j = q.getCoefficientOfMaxPower();

        if(j == 0){
            if(Float.compare(b.poly.get(0).getCoefficient(),0f) == 0){
                throw new Exception("Nu se poate efectua impartirea la 0!");
            }
            for(Map.Entry<Integer,Monomial> entry:poly.entrySet()){
                result.addMonomial(Monomial.division(entry.getValue(),b.poly.get(0)));
            }
        }
        else {
            do {
                Monomial firstTerm = Monomial.division(a.poly.get(i), b.poly.get(j));
                Polynomial auxPoly = new Polynomial();
                result.addMonomial(firstTerm);
                auxPoly.addMonomial(firstTerm);
                auxPoly.multiplicationPolynomial(b);
                a.subtractionPolynomial(auxPoly);
                i = a.getCoefficientOfMaxPower();
            } while (i >= j);
            this.reminder = a.poly;
        }
        this.poly = result.poly;
    }

    public void derivativePolynomial(){
        HashMap<Integer,Monomial> p = new HashMap<Integer,Monomial>();
        for(Map.Entry<Integer,Monomial> entry:poly.entrySet()){
            if(entry.getKey() - 1 >= 0)
                p.put(entry.getKey() - 1, Monomial.derivative(entry.getValue()));
        }
        this.poly = p;
    }

    public void integralPolynomial(){
        HashMap<Integer,Monomial> p = new HashMap<Integer,Monomial>();
        for(Map.Entry<Integer,Monomial> entry:poly.entrySet()){
            p.put(entry.getKey() + 1, Monomial.integral(entry.getValue()));
        }
        this.poly = p;
    }

    private int getCoefficientOfMaxPower() throws Exception{
        List<Integer> pDegreesArray = new ArrayList(this.poly.keySet());
        Collections.reverse(pDegreesArray);
        for(Integer i : pDegreesArray){
            if(this.poly.get(i) == null){
                throw new Exception(Message.NULL_POLY);
            }
            if(this.poly.get(i).getCoefficient()!=0){
                return i;
            }
        }
        return -1;
    }
    public String toString(String s){
        HashMap<Integer,Monomial>x;
        String str = "";
        if(s.equals("p")){
            x = this.poly;
        }
        else{
            x = this.reminder;
        }
        boolean firstTerm = true;
        for(Monomial value: x.values()){
            Float coefficient = value.getCoefficient();
            if(coefficient< 0){
                str +=value.toString();
                firstTerm=false;
            }
            else if(coefficient>0){
                if(!firstTerm) {
                    str += "+";
                }
                else{
                    firstTerm = false;
                }

                str +=value.toString();
            }
        }
        if(str.equals("")){
            str="0";
        }
        return str;
    }

    public HashMap<Integer, Monomial> getReminder() {return reminder;}
}

