package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea() {
        var s = new Triangle(10.0, 10.0, 12.0);
        double result = s.triangleArea();
        Assertions.assertEquals(48.0, result);
    }

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(15.0, new Triangle(4.0, 5.0, 6.0).trianglePerimeter());
    }

    @Test
    void testEquality() {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(5.0, 4.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality2() {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(5.0,3.0, 4.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try{
            new Triangle(-5.0, 3.0, 4.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }

    @Test
    void cannotCreateTriangleWhereTheSumOfTwoSideLessThanThirdSide() {
        try{
            new Triangle(1.0, 2.0, 4.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }
}
