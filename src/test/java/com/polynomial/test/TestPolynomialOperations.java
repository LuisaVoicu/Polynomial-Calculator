package com.polynomial.test;

import com.datamodel.Operation;
import com.datamodel.Polynomial;
import org.junit.*;

import static org.junit.Assert.assertEquals;



public class TestPolynomialOperations {

    private static int totalTeste = 0;
    private static int succesTeste = 0;

    @BeforeClass
    public static void setUpBeforeClass(){
        System.out.println("=== Testare Calculator Polinoame ===");
    }

    @AfterClass
    public static void tearDownAfterClass(){
        System.out.println("Numarul total de teste executate: " + totalTeste + "\nFinalizate cu succes: "+ succesTeste);
    }

    @Before
    public void setUp(){
        totalTeste++;
    }
    @Test
    public void additionTest(){
        String sp="4x^5-3x^4+x^2-8x+1";
        String sq="3x^4-x^3+x^2+2x-1";
        String sr="-6x+2x^2-x^3+4x^5";
        String srm="";
        Polynomial p = Operation.stringWithRegex(sp);
        Polynomial q = Operation.stringWithRegex(sq);
        try {
            p.additionPolynomial(q);
            srm = p.toString("p");
        }catch (Exception e){
            srm=e.getMessage();
        }finally{
            assertEquals(sr,srm);
            succesTeste++;
        }
    }

    @Test
    public void subtractionTest(){
        String sp="4x^5-3x^4+x^2-8x+1";
        String sq="3x^4-x^3+x^2+2x-1";
        String sr="2-10x+x^3-6x^4+4x^5";
        String srm="";
        Polynomial p = Operation.stringWithRegex(sp);
        Polynomial q = Operation.stringWithRegex(sq);
        try {
            p.subtractionPolynomial(q);
            srm = p.toString("p");
        }catch (Exception e){
            srm=e.getMessage();
        }finally{
            assertEquals(sr,srm);
            succesTeste++;
        }
    }

    @Test
    public void multiplicationTest(){
        String sp="3x^2-x+1";
        String sq="x-2";
        String sr="-2+3x-7x^2+3x^3";
        String srm="";
        Polynomial p = Operation.stringWithRegex(sp);
        Polynomial q = Operation.stringWithRegex(sq);
        try {
            p.multiplicationPolynomial(q);
            srm = p.toString("p");
        }catch (Exception e){
            srm=e.getMessage();
        }finally{
            assertEquals(sr,srm);
            succesTeste++;
        }
    }

    @Test
    public void integralPolynomial(){
        String sp="12x^5-15x^4+3x^2-8x+1";
        String sr="x-4x^2+x^3-3x^5+2x^6";
        String srm="";
        Polynomial p = Operation.stringWithRegex(sp);
        try {
            p.integralPolynomial();
            srm = p.toString("p");
        }catch (Exception e){
            srm=e.getMessage();
        }finally{
            assertEquals(sr,srm);
            succesTeste++;
        }
    }

    @Test
    public void derivativePolynomial(){
        String sp="12x^5-15x^4+3x^2-8x+1";
        String sr="-8+6x-60x^3+60x^4";
        String srm="";
        Polynomial p = Operation.stringWithRegex(sp);
        try {
            p.derivativePolynomial();
            srm = p.toString("p");
        }catch (Exception e){
            srm=e.getMessage();
        }finally{
            assertEquals(sr,srm);
            succesTeste++;
        }
    }
    @Test
    public void divisionPolynomial(){
        String sp="x^3-2x^2+6x-5";
        String sq="x^2-1";
        String sr="-2+x";
        String srRe="-7+7x";
        String srm="";
        String srmRe="";
        Polynomial p = Operation.stringWithRegex(sp);
        Polynomial q = Operation.stringWithRegex(sq);
        try {
            p.divisionPolynomial(q);
            srm = p.toString("p");
            srmRe = p.toString("r");
        }catch (Exception e){
            srm=e.getMessage();
        }finally{
            assertEquals(sr,srm);
            assertEquals(srRe,srmRe);
            succesTeste++;
        }
    }



}
