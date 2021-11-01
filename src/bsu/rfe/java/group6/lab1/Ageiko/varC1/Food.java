package bsu.rfe.java.group6.lab1.Ageiko.varC1;

public abstract class Food implements Consumable, Nutritious{
    private String _name = null;
    private int _calories = 0;


    public Food(String name, int calories){
        _calories = calories;
        _name = name;
    }

    public int get_calories() {
        return _calories;
    }
    protected void set_calories(int calories) {
        _calories = calories;
    }


    private void set_name(String name) {
        _name = name;
    }


    @Override
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food)) return false;
        if (_name==null || ((Food)arg0)._name==null) return false;
        return _name.equals(((Food)arg0)._name);
    }

    @Override
    public String toString() {
        return _name;
    }
    public String get_name() {
        String s = toString();
        return s;
    }
}
