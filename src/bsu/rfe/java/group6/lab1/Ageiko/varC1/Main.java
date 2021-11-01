package bsu.rfe.java.group6.lab1.Ageiko.varC1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do u want to sort? (y/n) ");
        String sorted = scanner.nextLine();

        System.out.print("Do u want to calculate calories? (y/n) ");
        String calories = scanner.nextLine();


        ArrayList<Food> breakfast = new ArrayList<Food>();
        FillArrayList(breakfast);

        PrintArrayList(breakfast);


        if (sorted.equals("y")) {
            SortArrayList(breakfast);
            System.out.println("Sorted breakfast");
            PrintArrayList(breakfast);
        }

        Consume(breakfast);

        if (calories.equals("y"))
            System.out.println("U ate " + CalculateCalories(breakfast) + " calories");
    }

    private static void Consume(ArrayList<Food> breakfast) {
        if (breakfast == null)
            return;
        for (Food el:breakfast)
            el.consume();
    }

    public static void FillArrayList(ArrayList<Food> breakfast) throws Exception{
        String answer;
        int count_breakfast = 0;
        do {
            System.out.print("Enter food: ");
            String food = scanner.nextLine();

            if (food.equals("Apple")) {
                System.out.println("Enter size of apple: ");
                String size = scanner.nextLine();
                if (size.equals("medium") || size.equals("Small") || size.equals("Big")) {
                    breakfast.add(new Apple(size));
                }
            }
            else if (food.equals("Cheese"))
                breakfast.add(new Cheese());
            else if (food.equals("Sandwich")){
                System.out.print("Enter first filling: ");
                String filling1 = scanner.nextLine();
                if (!(filling1.equals("Ham") || filling1.equals("Chicken")))
                    throw new ClassNotFoundException("This food so fat for breakfast!");
                System.out.print("Enter second filling: ");
                String filling2 = scanner.nextLine();
                if (!(filling2.equals("Ketchup") || filling2.equals("Mayonnaise")))
                    throw new ClassNotFoundException("This food so fat for breakfast!");
                breakfast.add(new Sandwich(filling1,filling2));
            }
            else throw new ClassNotFoundException("This food so fat for breakfast!");

            System.out.print("Do u want more? (y/n) ");
            answer = scanner.nextLine();
            count_breakfast++;
        } while(answer.equals("y"));
        int count = 0;
        Food[] breakfast_diff = new Food[count_breakfast];
        for (int i = 0; i < count_breakfast; i++) {
            count = 1;
            boolean to_continue = false;
            for(int j = 0; j < count_breakfast; j++)
            {
                if(breakfast_diff[j] == null) continue;
                if(breakfast_diff[j].equals(breakfast.get(i))){
                    to_continue = true;
                }
            }
            if(to_continue) continue;
            for (int j = i + 1; j < count_breakfast; j++) {
                if ((breakfast.get(j).equals(breakfast.get(i)))) {
                    count++;
                }
            }
            breakfast_diff[i] = breakfast.get(i);
            String s = breakfast.get(i).toString();
            System.out.println(s +" - " + count + " раз(а)");
        }
        System.out.println("Cъедено продуктов - "+  count_breakfast++);

    }

    public static void PrintArrayList(final ArrayList<Food> breakfast)throws ClassNotFoundException, NoSuchFieldException {
        if (breakfast == null)
            System.out.println("U are fat, u are not allowed to eat!");
        System.out.println("U want to eat today: ");
        for (int i = 0; i < breakfast.size(); i++) {
            if (breakfast.get(i) == null) continue;
            System.out.println(breakfast.get(i).toString());
            //breakfast[i].consume();
        }
        System.out.println();
    }

    public static void SortArrayList(ArrayList<Food> breakfast){
        Collections.sort(breakfast, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.get_name().length() < o2.get_name().length() ? -1 :
                        o1.get_name().length() > o2.get_name().length() ? 1 : 0;
            }
        });
    }

    public static int CalculateCalories(ArrayList<Food> breakfast){
        if (breakfast == null)
            return 0;
        int calories = 0;
        for (Food el : breakfast)
            calories += el.calculateCalories();
        return calories;
    }
}
