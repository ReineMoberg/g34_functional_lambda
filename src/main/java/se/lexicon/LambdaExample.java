package se.lexicon;


import se.lexicon.interfaces.*;

import java.util.Random;

public class LambdaExample {


    public static String duStringStuff(String s1, String s2, DoStringStuff operator) {
        return operator.operate(s1, s2);
    }

    public static double calcOperator(double a, double b, DoubleOperator operator) {
        return operator.apply(a, b);
    }


    public static void main(String[] args) {
        /*
        // ternary operator
        // http://tutorials.jenkov.com/java/ternary-operator.html
        String v1 = "Test";
        String v2 = "Hello";
        if (v1.length() >= v2.length()){
            System.out.println(v1);
        } else{
            System.out.println(v2);
        }
        //v1.length() >= v2.length() ? v1 : v2;
         */

        System.out.println("-----------------------");


        DoStringStuff getBiggestString = (str1, str2) -> str1.length() >= str2.length() ? str1 : str2;
        System.out.println(getBiggestString.operate("ABC", "ABCDEFGH"));

        DoStringStuff concatenate = ((s1, s2) -> s1.concat(" ").concat(s2));
        System.out.println(concatenate.operate("Mehrdad", "Javan"));

        // Define Functional Interface in method parameter
        System.out.println(duStringStuff("Hello", "Lambda", concatenate));
        System.out.println(duStringStuff("Hello", "Lambda", getBiggestString));

        DoubleOperator addition = (firstNumber, secondNumber) -> firstNumber + secondNumber;
        DoubleOperator subtraction = (firstNumber, secondNumber) -> firstNumber - secondNumber;
        DoubleOperator moltiplication = (firstNumber, secondNumber) -> firstNumber * secondNumber;
        DoubleOperator devission = (firstNumber, secondNumber) -> firstNumber / secondNumber;

        System.out.println(calcOperator(12d, 44, addition));
        System.out.println(calcOperator(12d, 44, subtraction));
        System.out.println(calcOperator(12d, 44, moltiplication));
        System.out.println(calcOperator(12d, 44, devission));
        System.out.println("----------------------------------------");
        // Single Argument Lambda Expression
        Printer printer= (String message) -> System.out.println(message);
        printer.print("Hello Lambda!");

        Printer printerEx2 = message -> System.out.println(message);
        printerEx2.print("Hello Java!");


        Conditional positiveNumber = n -> n > 0; // if n > 0 return true else return false
        Conditional positiveNumberEx2 = n -> {
            if (n> 0)
                return true;
            else
                return false;
        }; // if n > 0 return true else return false
        System.out.println(positiveNumber.testInt(-100)); // false

        // No argument Lambda Expression
        IntRandomGen rng = () -> new Random().nextInt();
        System.out.println(rng.generate());


    }


}
