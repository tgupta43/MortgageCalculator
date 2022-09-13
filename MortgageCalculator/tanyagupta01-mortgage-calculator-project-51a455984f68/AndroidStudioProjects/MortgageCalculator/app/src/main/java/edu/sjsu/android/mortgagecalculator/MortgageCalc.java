package edu.sjsu.android.mortgagecalculator;
import java.lang.Math;
import java.text.DecimalFormat;

public class MortgageCalc
{
    public static String mortgage(float principal, float interest, int term, boolean tax)
    {
        DecimalFormat df = new DecimalFormat("0.00");
        float J=interest/1200;
        int N=12*term;
        double T=0;
        if (tax==true) //if user checks the box
        {
            T=0.001*principal;
        }
        else
        {
            T=0;
        }
        if (interest==0) //formula for when interest 0
        {
            return df.format((principal/N)+T);
        }
        else //original formula
        {
            return df.format((principal*(J/(1-(Math.pow((1+J),-N)))))+T);
        }

    }

}
