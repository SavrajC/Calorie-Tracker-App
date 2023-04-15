package com.healthycoderapp;

import java.util.Comparator;
import java.util.List;

public class BMICalculator {


	public static double caloriesMen(double height, float weight, float age, double activity){
		if (height > 3.0){
			throw new IllegalArgumentException("Height cannot be above 3");
		}
		double calories = 66.47 + (13.75*weight) + (5.003*height) - (6.755*age);
		return Math.round(calories * activity);
	};

	public static double caloriesWomen(double height, float weight, float age, double activity){
		if (height > 3.0){
			throw new IllegalArgumentException("Height cannot be above 3");
		}
		double calories = 447.593 + (9.247*weight) + (3.098*height) - (4.330*age);
		return Math.round(calories * activity);
	};




}
