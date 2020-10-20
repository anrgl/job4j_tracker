package ru.job4j.streamapi;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void whenMatrixThenFlatList() {
        Integer[][] matrix = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = List.of(1, 2, 3, 4);
        List<Integer> rsl = Matrix.flat(matrix);
        assertThat(rsl, is(expect));
    }
}