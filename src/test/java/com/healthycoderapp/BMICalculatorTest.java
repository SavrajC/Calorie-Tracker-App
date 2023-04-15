package com.healthycoderapp;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BMICalculatorTest {

    @Nested
    @DisplayName("Female Calorie Calc")
    @Tag("fmCalc")
    class femaleCalc {

        @Test
        @DisplayName("Valid input")
        public void testFemaleCalc() {
            Assertions.assertAll(
                    () -> Assertions.assertEquals(1368.0, BMICalculator.caloriesWomen(1.67, 60,22,1.5),0.001),
                    () -> Assertions.assertThrows(IllegalArgumentException.class, () -> BMICalculator.caloriesWomen(3.1, 60,22,1.5))
            );
        }
    }

    @Nested
    @DisplayName("Male Calorie Calc")
    @Tag("mCalc")
    class maleCalc {

        @Test
        @DisplayName("Valid input")
        public void testMaleCalc() {
            Assertions.assertAll(
                    () -> Assertions.assertEquals(1368.0, BMICalculator.caloriesMen(1.8, 60,22, 1.5),1747.6),
                    () -> Assertions.assertThrows(IllegalArgumentException.class, () -> BMICalculator.caloriesMen(3.1, 60,22,1.5))
            );
        }
    }


}