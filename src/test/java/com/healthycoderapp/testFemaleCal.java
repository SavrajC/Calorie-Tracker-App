package com.healthycoderapp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.healthycoderapp.CalorieTracker.main;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFemaleCal {
    @Test
    public void testFemaleCal() {
        String input = "john\n123\n2\n135\n5.6\n22\nF\n1.5\n0\n6"; // simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // set System.in to the input stream

        main(new String[0]); // run the main method

        assertEquals(1388,CalorieTracker.dailyCalories) ;
    }
}

