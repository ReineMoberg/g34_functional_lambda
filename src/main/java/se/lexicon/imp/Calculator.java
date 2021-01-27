package se.lexicon.imp;

import se.lexicon.interfaces.DoubleOperator;

public class Calculator implements DoubleOperator {
    @Override
    public Double apply(Double a, Double b) {
        return a + b;
    }
}
