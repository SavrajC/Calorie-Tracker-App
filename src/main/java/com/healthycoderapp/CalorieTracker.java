package com.healthycoderapp;

import java.util.Scanner;

// STATE_MAIN_MENU, STATE_VIEW_PARAMETERS, STATE_EDIT_PARAMETERS, STATE_TRACK_CALORIES,
// STATE_ADD_CALORIES, STATE_SUBTRACT_CALORIES, STATE_EXIT, STATE_LOGIN,
// weight, height, age, gender, dailyCalories, activityLevel, metric.

public class CalorieTracker {
    public static final int STATE_MAIN_MENU = 0;
    public static final int STATE_VIEW_PARAMETERS = 1;
    public static final int STATE_EDIT_PARAMETERS = 2;
    public static final int STATE_TRACK_CALORIES = 3;
    public static final int STATE_ADD_CALORIES = 4;
    public static final int STATE_SUBTRACT_CALORIES = 5;
    public static final int STATE_EXIT = 6;

    public static final int STATE_LOGIN = 7;

    public static float weight;
    public static double height;
    public static int age;
    public static String gender;
    public static double dailyCalories = 0;

    public static double activityLevel = 0;

    private static int metric = 1;

    static User user = new User("john", "123");
    public static int currentState = STATE_LOGIN;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (currentState != STATE_EXIT) {
            switch (currentState) {
                case STATE_MAIN_MENU:
                    System.out.println("Select an option:");
                    System.out.println("1. View parameters");
                    System.out.println("2. Edit parameters");
                    System.out.println("3. Track calories");
                    System.out.println("4. Add calories");
                    System.out.println("5. Subtract calories");
                    System.out.println("6. Exit");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            currentState = STATE_VIEW_PARAMETERS;
                            break;
                        case 2:
                            currentState = STATE_EDIT_PARAMETERS;
                            break;
                        case 3:
                            currentState = STATE_TRACK_CALORIES;
                            break;
                        case 4:
                            currentState = STATE_ADD_CALORIES;
                            break;
                        case 5:
                            currentState = STATE_SUBTRACT_CALORIES;
                            break;
                        case 6:
                            currentState = STATE_EXIT;
                            break;
                        default:
                            System.out.println("Invalid choice, please try again.");
                            break;
                    }
                    break;
                case STATE_VIEW_PARAMETERS:
                    if(metric == 1){
                        System.out.println("Weight: " + weight);
                        System.out.println("Height: " + height);
                    }else{
                        System.out.println("Weight: " + unitCon.kgTolbs(weight));
                        System.out.println("Height: " + unitCon.metersToFeet(height));
                    }
                    System.out.println("Age: " + age);
                    System.out.println("Gender: " + gender);
                    System.out.println("Activity Level: " + activityLevel);
                    currentState = STATE_MAIN_MENU;
                    break;
                case STATE_EDIT_PARAMETERS:
                    System.out.print("Enter weight: ");
                    weight = scanner.nextFloat();
                    System.out.print("Enter height: ");
                    height = scanner.nextDouble();
                    System.out.print("Enter age: ");
                    age = scanner.nextInt();
                    System.out.print("Enter gender (M/F): ");
                    gender = scanner.next();
                    System.out.print("Enter Activity level 1-2: ");
                    activityLevel = scanner.nextDouble();
                    System.out.print("Enter 1 for Metric or 0 for Imperial: ");
                    metric = scanner.nextInt();
                    if(metric == 0){
                        height = unitCon.feetToMeters(height);
                        weight = (float) unitCon.lbsToKG(weight);
                    }
                    if(gender.equals("m") || gender.equals("M")) {
                        dailyCalories = BMICalculator.caloriesMen(height, weight, age, activityLevel);
                    } else if (gender.equals("f") || gender.equals("F")){
                        dailyCalories = BMICalculator.caloriesWomen(height, weight, age, activityLevel);
                    }
                    currentState = STATE_MAIN_MENU;
                    break;
                case STATE_TRACK_CALORIES:
                    System.out.println("Your daily calorie requirement is " + dailyCalories + " calories.");
                    currentState = STATE_MAIN_MENU;
                    break;
                case STATE_ADD_CALORIES:
                    System.out.print("Enter calories to add: ");
                    double caloriesToAdd = scanner.nextDouble();
                    dailyCalories += caloriesToAdd;
                    System.out.println("Daily calories updated to " + dailyCalories + " calories.");
                    currentState = STATE_MAIN_MENU;
                    break;
                case STATE_SUBTRACT_CALORIES:
                    System.out.print("Enter calories to subtract: ");
                    double caloriesToSubtract = scanner.nextDouble();
                    dailyCalories -= caloriesToSubtract;
                    System.out.println("Daily calories updated to " + dailyCalories + " calories.");
                    currentState = STATE_MAIN_MENU;
                    break;
                case STATE_LOGIN:
                    System.out.print("Username: ");
                    String userName = scanner.next();
                    System.out.print("Password: ");
                    String password = scanner.next();
                    if(userName.equals(user.getUsername()) && password.equals(user.getPassword())){
                        System.out.println("Successful login");
                        currentState = STATE_MAIN_MENU;
                    } else {
                        System.out.println("Failed login, try again");
                        System.out.println(user.getUsername());
                        System.out.println(user.getPassword());
                        currentState = STATE_LOGIN;
                    }
                    break;
            }
        }
    }
}
