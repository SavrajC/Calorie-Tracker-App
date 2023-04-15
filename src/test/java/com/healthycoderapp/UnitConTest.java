package com.healthycoderapp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.healthycoderapp.unitCon.metersToFeet;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit Conversion Test")
@Tag("unit")
public class UnitConTest {

    @Nested
    @DisplayName("Meters to Feet Conversion")
    @Tag("conversion")
    class MetersToFeetConversion {

        static Collection<Object[]> data() {
            List<Object[]> list = new ArrayList<>();
            list.add(new Object[]{0.0, 0.0});
            list.add(new Object[]{1.0, 3.28});
            list.add(new Object[]{2.0, 6.56});
            list.add(new Object[]{5.0, 16.4});
            list.add(new Object[]{10.0, 32.8});
            return list;
        }

        @ParameterizedTest
        @MethodSource("data")
        @DisplayName("Valid input")
        public void testMetersToFeet(double meters, double expectedFeet) {
            assertEquals(expectedFeet, unitCon.metersToFeet(meters), 0.01);
        }
        @Test
        public void testMetersToFeet() {
            Assertions.assertAll(
                    () -> Assertions.assertEquals(0, metersToFeet(0)),
                    () -> Assertions.assertEquals(3.28, metersToFeet(1)),
                    () -> Assertions.assertEquals(6.56, metersToFeet(2)),
                    () -> Assertions.assertEquals(9.84, metersToFeet(3)),
                    () -> Assertions.assertThrows(IllegalArgumentException.class, () -> metersToFeet(-1)),
                    () -> Assertions.assertThrows(IllegalArgumentException.class, () -> metersToFeet(-10))
            );
        }
        static Collection<Double> invalidInput() {
            return Arrays.asList(-1.0, -10.0);
        }

        @ParameterizedTest
        @MethodSource("invalidInput")
        @DisplayName("Invalid input")
        public void testInvalidInput(double meters) {
            assertThrows(IllegalArgumentException.class, () -> unitCon.metersToFeet(meters));
        }
    }

    @Nested
    @DisplayName("Feet to Meters Conversion")
    @Tag("conversion")
    class FeetToMetersConversion {

        @Test
        void testFeetToMeters() {
            Assertions.assertAll(
                    () -> Assertions.assertEquals(1.8288, unitCon.feetToMeters(6),0.001),
                    () -> Assertions.assertEquals(3.048, unitCon.feetToMeters(10),0.001),
                    () -> Assertions.assertEquals(0.9144, unitCon.feetToMeters(3),0.001),
                    () -> Assertions.assertThrows(IllegalArgumentException.class, () -> unitCon.feetToMeters(-1)),
                    () -> Assertions.assertThrows(IllegalArgumentException.class, () -> unitCon.feetToMeters(0))
            );
        }

        @ParameterizedTest
        @CsvSource({
                "6, 1.8288",
                "10, 3.048",
                "3, 0.9144"
        })
        void testFeetToMeters(double feet, double expectedMeters) {
            double actualMeters = unitCon.feetToMeters(feet);
            Assertions.assertEquals(expectedMeters, actualMeters, 0.001);
        }
    }

    @Nested
    @DisplayName("Pounds to Kilograms Conversion")
    @Tag("conversion")
    class LbsToKGConversion {

        @Test
        @DisplayName("Valid input")
        public void testLbsToKG() {
            assertEquals(unitCon.lbsToKG(1.0), 0.45454545454545453);
            assertNotEquals(unitCon.lbsToKG(1.0), 3.28);
            Assertions.assertAll(
                    () -> Assertions.assertEquals(0.45454545454545453, unitCon.lbsToKG(1),0.001),
                    () -> Assertions.assertEquals(0, unitCon.lbsToKG(0),0.001),
                    () -> Assertions.assertThrows(IllegalArgumentException.class, () -> unitCon.lbsToKG(-1)),
                    () -> Assertions.assertThrows(IllegalArgumentException.class, () -> unitCon.lbsToKG(-10))
            );
        }
    }
    @Nested
    @DisplayName("Pounds to Kilograms Conversion")
    @Tag("conversion")
    class KGsToLbsConversion {

        @Test
        @DisplayName("Valid input")
        public void testKGToLbs() {
            Assertions.assertAll(
                    () -> Assertions.assertEquals(2.2, unitCon.kgTolbs(1),0.001),
                    () -> Assertions.assertEquals(0, unitCon.kgTolbs(0),0.001),
                    () -> Assertions.assertThrows(IllegalArgumentException.class, () -> unitCon.lbsToKG(-1)),
                    () -> Assertions.assertThrows(IllegalArgumentException.class, () -> unitCon.lbsToKG(-10))
            );
        }
    }
}