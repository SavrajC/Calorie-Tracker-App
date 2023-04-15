package com.healthycoderapp;

public class unitCon {

    public static double metersToFeet(double meters) throws IllegalArgumentException {
        if (meters < 0) {
            throw new IllegalArgumentException("Meters value cannot be negative");
        }
        double feet = meters * 3.28;
        return feet;
    };
    public static double feetToMeters(double feet){
        if (feet <= 0) {
            throw new IllegalArgumentException("Feet value cannot be negative");
        }
        double meters = feet / 3.28;
        return meters;
    };
    public static double lbsToKG(double lbs){
        if (lbs < 0) {
            throw new IllegalArgumentException("LBS value cannot be negative");
        }
        double kg = lbs / 2.2;
        return kg;
    };

    public static double kgTolbs(double kg){
        if (kg < 0) {
            throw new IllegalArgumentException("KG value cannot be negative");
        }
        double lbs = kg * 2.2;
        return lbs;
    };


}

