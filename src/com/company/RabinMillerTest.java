package com.company;

import java.util.Random;

/**
 * Created by lucas63 on 14.11.15.
 */
public class RabinMillerTest {
    private int requiredNumber;
    private int s;
    private int t;
    private int roundsNumber;

    public RabinMillerTest(int number) {
        this.requiredNumber = number;
        this.s=0;
        this.roundsNumber = (int)Math.log(requiredNumber);

    }

    public Number Algo() {
        findParameters();
        Random rand = new Random();
        for(int i =0; i< roundsNumber; i++)
        {
            int a = rand.nextInt(requiredNumber-1)+1;
            if(!isDivisible(a)&&ruleAboutPow(a))
                return new Number(requiredNumber,0,false,"Rabin-Miller test",1/Math.pow(4,roundsNumber));


        }
        return new Number(requiredNumber,0,true,"Rabin-Miller test",1/Math.pow(4,roundsNumber));
    }

    public void findParameters()
    {

        if((requiredNumber-1)% Math.pow(2,s) == 0 || s==0)
        {
            t = (int) ((requiredNumber-1)/ Math.pow(2,s));
            s++;
            findParameters();

        }
        else
        {
            s--;
        }
    }

    public boolean isDivisible(int a) //rule 1 : IF requiredNumber % a != 0 - a is witness of simplicity
    {
        return requiredNumber%a == 0;

    }

    public boolean ruleAboutPow(int a) // rule 2 : if pow(a,t) mod requiredNumber = 1 - a is witness of simplicity
    {
        if(Math.pow(a,t)%requiredNumber == 1)
        {
            return true;
        }
        if(ruleAdditionalRule(a))
        {
            return true;
        }

        return false;
    }
    public boolean ruleAdditionalRule(int a)
    {
        for(int k = 0; k<s; k++)
        {
            if((Math.pow(a,Math.pow(2,k)*t)+1)%requiredNumber == 0)
                return true;

        }
        return false;
    }



}
