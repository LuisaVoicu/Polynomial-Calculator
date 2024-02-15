package com.datamodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {
    public static Polynomial stringWithRegex(String exp){
        Polynomial p = new Polynomial();
        //String exp = "";
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(exp);

        while (matcher.find()) {
            String result = matcher.group(1);

            Float coefficient;
            Integer degree;

            if(result.indexOf("x")<0){
                coefficient = Float.parseFloat(result);
                degree = 0;
            }
            else{
                String[] strSplit = result.split("x");
                if(result.indexOf("x") == 0){
                    coefficient = 1f;
                }
                else{
                    if(strSplit[0].equals("-")){
                        coefficient=-1f;
                    }
                    else if(strSplit[0].equals("+")){
                        coefficient=1f;
                    }
                    else {
                        coefficient = Float.parseFloat(strSplit[0]);
                    }
                }
                if (result.indexOf("^") > 0) {
                    degree = Integer.parseInt(strSplit[1].substring(1));
                }
                else {
                    degree = 1;
                }
            }
            p.addMonomial(new Monomial(degree,coefficient));
        }
        return p;
    }

}
