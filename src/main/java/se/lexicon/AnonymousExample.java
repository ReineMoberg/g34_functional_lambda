package se.lexicon;

import se.lexicon.interfaces.DoStringStuff;
import se.lexicon.interfaces.DoubleOperator;

// Part 3. Moving Anonymous Inner classes to fields
public class AnonymousExample {

    static DoStringStuff getBiggestString = new DoStringStuff() {
        @Override
        public String operate(String s1, String s2) {
            return s1.length() >= s2.length() ? s1 : s2;
        }
    };

    static DoStringStuff concat = new DoStringStuff() {
        @Override
        public String operate(String s1, String s2) {
            return s1.concat(" ").concat(s2);
        }
    };

    // addition and subtraction
    static DoubleOperator addition = new DoubleOperator() {
        @Override
        public Double apply(Double a, Double b) {
            return a + b;
        }
    };

    static DoubleOperator subtraction = new DoubleOperator() {
        @Override
        public Double apply(Double a, Double b) {
            return a - b;
        }
    };
    static DoubleOperator multiplication = new DoubleOperator() {
        @Override
        public Double apply(Double a, Double b) {
            return a * b;
        }
    };

    public static String duStringStuff(String s1, String s2, DoStringStuff operator) {
        return operator.operate(s1, s2);
    }

    public static double calcOperator(double a,double b, DoubleOperator operator){
        return operator.apply(a,b);
    }

    public static void main(String[] args) {
        System.out.println(getBiggestString.operate("ABC", "ABCDEFG"));
        System.out.println(concat.operate("Mehrdad", "Javan"));

        System.out.println(addition.apply(12d, 11d));
        System.out.println(subtraction.apply(12d, 11d));

        // Functional Interfaces in method parameter
        // first solution
        String result = duStringStuff("Mehrdad", "Javan", new DoStringStuff() {
            @Override
            public String operate(String s1, String s2) {
                return s1.concat(" ").concat(s2);
            }
        });
        System.out.println("result = " + result);

        double additionResult = calcOperator(12d,11d, addition);
        System.out.println("additionResult = " + additionResult);
        double subtractionResult = calcOperator(100d,10d,subtraction);
        System.out.println("subtractionResult = " + subtractionResult);

    }

}
