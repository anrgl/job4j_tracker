package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class FunTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Fun.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = Fun.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResult() {
        List<Double> result = Fun.diapason(1, 4, x -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(1D, 4D, 27D);
        assertThat(result, is(expected));
    }
}