package se.lexicon;

import se.lexicon.imp.Calculator;
import se.lexicon.imp.StringOperator;
import se.lexicon.interfaces.DoStringStuff;
import se.lexicon.interfaces.DoubleOperator;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        System.out.println("Part 1. Functional Interfaces");
        // ex1
        StringOperator concatter = new StringOperator();
        String firstName = "Mehrdad";
        String lastName = "Javan";
        String fullName = concatter.operate(firstName,lastName);
        System.out.println("fullName = " + fullName);

        // ex2
        Calculator calculator= new Calculator();
        double result = calculator.apply(10d,20d);
        System.out.println("Addition: " + result);

        System.out.println("Part 2. Anonymous Inner Class");
        // Anonymous inner class is a class that has not name and declared in one statement using "new" keyword
        DoStringStuff getBiggestString = new DoStringStuff() {
            @Override
            public String operate(String s1, String s2) {
                return s1.length() >= s2.length() ? s1 : s2; // same to if and else statement
            }
        }; // notice semicolon

        DoStringStuff concat = new DoStringStuff() {
            @Override
            public String operate(String s1, String s2) {
                return s1.concat(" ").concat(s2);
            }
        };
        System.out.println("GetBiggestString: " + getBiggestString.operate("ABCD", "ABCDEFG") ); // ABCDEFG
        System.out.println("FullName: " + concat.operate("Mehrdad","Javan")); // Mehrdad Javan

        DoubleOperator addition = new DoubleOperator() {
            @Override
            public Double apply(Double a, Double b) {
                return a + b;
            }
        };

        DoubleOperator subtraction = new DoubleOperator() {
            @Override
            public Double apply(Double a, Double b) {
                return a - b;
            }
        };

        System.out.println("Addition: " + addition.apply(20d,30d));
        System.out.println("Subtraction: " + subtraction.apply(100d,50d));

        System.out.println("Part 3. Moving Anonymous Inner class to fields");
        // AnonymousExample.java
    }

}
