package com.company;

/**
 * Created by lucas63 on 14.11.15.
 */
public class Number {
    private boolean isComposite; //if number is not simple, we checking it as true, and dont use it any more
    private int value; //value of element
    private int indexOfSimplicitySeries;
    private double probability;
    private String algorythm = "";

    public Number(int value) {
        this.isComposite = false;
        this.value = value;
        this.indexOfSimplicitySeries = 0;
        this.probability = 1;
        this.algorythm = "none";
    }

    public Number(int value,int indexOfSimplicitySeries,boolean isComposite,String algorythm) {
        this.isComposite = isComposite;
        this.value = value;
        this.indexOfSimplicitySeries = indexOfSimplicitySeries;
        this.algorythm = algorythm;
        this.probability = 1;
    }

    public Number( int requiredNumber, int i,boolean b,String algorythm,double probability) {
        this.isComposite = b;
        this.value = requiredNumber;
        this.indexOfSimplicitySeries = i;
        this.probability = probability;
        this.algorythm = algorythm;
    }

    public boolean isComposite() {
        return isComposite;
    }

    public int getValue() {
        return value;
    }

    public void setIsComposite(boolean isComposite) {
        this.isComposite = isComposite;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndexOfSimplicitySeries() {
        return indexOfSimplicitySeries;
    }

    public void setIndexOfSimplicitySeries(int indexOfSimplicitySeries) {
        this.indexOfSimplicitySeries = indexOfSimplicitySeries;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public String getAlgorythm() {
        return algorythm;
    }

    public void setAlgorythm(String algorythm) {
        this.algorythm = algorythm;
    }

    @Override
    public String toString() {
        String a = "";
        a+="\n";
        a+="--- Report ---";
        a+="\n";
        a+="Number : "+this.getValue();
        a+="\n";
        a+="Is simple : "+!this.isComposite();
        a+="\n";
        a+="Number in simplicity series : "+((this.getIndexOfSimplicitySeries()==0)?"missing":this.getIndexOfSimplicitySeries());
        a+="\n";
        a+="Probability of result : "+((this.getProbability()==0||this.getProbability()==1)?"not stochastic":this.getProbability());
        a+="\n";
        a+="Algorythm : "+((this.algorythm=="none")?"not used":this.algorythm);
        a+="\n";

        return a;
    }
}
