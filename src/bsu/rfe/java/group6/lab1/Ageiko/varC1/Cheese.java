package bsu.rfe.java.group6.lab1.Ageiko.varC1;

public class Cheese extends Food{
    public Cheese() {
        super("Cheese", 400);
    }
    @Override
    public boolean equals(Object arg0) {
        return super.equals(arg0);
    }

    @Override
    public void consume() {
        System.out.println(get_name()  + " eaten! Yummy!");
    }

    @Override
    public int calculateCalories() {
        return get_calories();
    }



    @Override
    public String toString(){ return super.toString(); }
}
