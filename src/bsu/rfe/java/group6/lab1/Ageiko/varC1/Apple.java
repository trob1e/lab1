package bsu.rfe.java.group6.lab1.Ageiko.varC1;

public class Apple extends Food{
    private String _size = null;
    public Apple(String size) {
        super("Apple", 50);
        _size = size;
    }

    public String get_size() {
        return _size;
    }
    private void set_size(String size) {
        _size = size;
    }

    @Override
    public void consume() {
        System.out.println(get_name() + " with worms! Fuck!");
    }

    @Override
    public int calculateCalories() {
        return get_calories();
    }

    @Override
    public String toString(){ return get_size()+" "+ super.toString() ;}
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Apple)) return false;
        return (_size.equals(((Apple) obj)._size));
    }
}
