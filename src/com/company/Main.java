package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int requiredNumber = 0;
        int lastSmallNumber = 9999;

        System.out.print("Enter number : ");
        try{
            requiredNumber = Math.abs(scanner.nextInt());
        }
        catch(InputMismatchException im){
            System.out.println(new Number(0,1,true,"none"));
        }


        if (requiredNumber % 2 != 0 ){ //if not divisible by 2 without

            if (requiredNumber < lastSmallNumber) { // if < 9999 - sieve of Erathosthene,

                if (requiredNumber == 2) // if 2 -> simple
                    System.out.println(new Number(2,1,false,"none"));
                if (requiredNumber == 1)
                    System.out.print(new Number(1,0,true,"none"));

                else {

                    SieveOfErathosthenes soe = new SieveOfErathosthenes(requiredNumber);
                    Number number = soe.Algo();
                    System.out.println(number);
                }
            }

            else {

                RabinMillerTest rmt = new RabinMillerTest(requiredNumber);
                Number number = rmt.Algo();
                System.out.println(number);
            }
        }

        else{
            System.out.println(new Number(requiredNumber,0,true,"none"));

        }
    }

}
