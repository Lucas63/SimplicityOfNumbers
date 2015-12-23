package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas63 on 14.11.15.
 */
public class SieveOfErathosthenes {
    private ArrayList<Number> data;
    private int requiredNumber;


    public SieveOfErathosthenes(int number) {
        this.requiredNumber = number;


        this.data = new ArrayList<Number>();
        this.data.add(new Number(2));

        for (int i = 3; i < number + 1; i += 2) {
            data.add(new Number(i));
        }

    }

    public Number Algo() {
        int sqrt = (int) Math.sqrt(this.data.get(this.data.size() - 1).getValue()); // we need to check only number less then sqrt on number count

        for (int i = 1; data.get(i).getValue() <= sqrt; i++) {
            for (int j = i + 1; j < this.data.size(); j++) {
                checkElement(data.get(j), data.get(i).getValue());
            }
        }
        return infoAboutNumber();
    }

    public void checkElement(Number number, int testNumber) {
        if (number.getValue() % testNumber == 0) {
            number.setIsComposite(true);
        }
    }

    public Number infoAboutNumber() {
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (!data.get(i).isComposite()) {
                index++;
                if (data.get(i).getValue() == requiredNumber) {
                    data.get(i).setIndexOfSimplicitySeries(index);

                    data.get(i).setProbability(1);
                    data.get(i).setAlgorythm("Sieve of Erathsthenes");
                    return data.get(i);
                }
            }
        }
        Number result = new Number(requiredNumber,0,true,"Sieve of Erathosthenes");
        result.setIsComposite(true);
        return result;

    }
}


