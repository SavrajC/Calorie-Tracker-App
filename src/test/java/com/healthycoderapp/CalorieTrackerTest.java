package com.healthycoderapp;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static com.healthycoderapp.CalorieTracker.main;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalorieTrackerTest {


    @Nested
    @DisplayName("FSM")
    @Tag("FiniteStateMachine")
    class fsmCheck {
    @Test
    public void testLogin() {
        String input = "john\n123\n6"; // simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // set System.in to the input stream

        main(new String[0]); // run the main method

        assertEquals(6, CalorieTracker.currentState); // assert that the current state is the main menu
    }

    @Test
    public void testView() {
        String input = "john\n123\n1\n6"; // simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // set System.in to the input stream

        main(new String[0]); // run the main method

        assertEquals(6, CalorieTracker.currentState); // assert that the current state is the main menu
    }

    @Test
    public void testEditParams() {
        String input = "john\n123\n2\n190\n6.2\n22\nm\n1.5\n0\n6"; // simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // set System.in to the input stream

        main(new String[0]); // run the main method

        assertEquals(6, CalorieTracker.currentState); // assert that the current state is the main menu
    }

    @Test
    public void testTrack() {
        String input = "john\n123\n3\n6"; // simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // set System.in to the input stream

        main(new String[0]); // run the main method

        assertEquals(6, CalorieTracker.currentState); // assert that the current state is the main menu
    }

    @Test
    public void testAdd() {
        String input = "john\n123\n4\n200\n6"; // simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // set System.in to the input stream

        main(new String[0]); // run the main method

        assertEquals(6, CalorieTracker.currentState); // assert that the current state is the main menu
    }

    @Test
    public void testSubtract() {
        String input = "john\n123\n5\n200\n6"; // simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // set System.in to the input stream

        main(new String[0]); // run the main method

        assertEquals(6, CalorieTracker.currentState); // assert that the current state is the main menu
    }
}
    @Nested
    @DisplayName("FSM")
    @Tag("DecisionCoverage")
    class DecisionCov {
        @Test
        public void testMaleCal() {
            String input = "john\n123\n2\n190\n6.2\n22\nm\n1.5\n0\n6"; // simulate user input
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in); // set System.in to the input stream

            main(new String[0]); // run the main method

            assertEquals(CalorieTracker.dailyCalories, 1672);
        }
        //CalorieTracker calorieTracker = new CalorieTracker();
        // Commented out because previous test was bleeding data into this one and could not fix without complete refactor. Moved to a separate class
//        @Test
//        public void testFemaleCal() {
//            CalorieTracker calorieTracker = new CalorieTracker();
//            String input = "john\n123\n2\n135\n5.6\n22\nF\n1.5\n0\n6"; // simulate user input
//            InputStream in = new ByteArrayInputStream(input.getBytes());
//            System.setIn(in); // set System.in to the input stream
//
//            main(new String[0]); // run the main method
//
//            assertEquals(1388,CalorieTracker.dailyCalories) ;
//        }
    }

}
