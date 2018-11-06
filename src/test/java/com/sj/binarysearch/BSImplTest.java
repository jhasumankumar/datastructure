package com.sj.binarysearch;


import com.sj.exception.ElementNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BSImplTest {

    private BSImpl bs = new BSImpl();

    @Test
    void shouldReturnCorrectIndex() {
        Integer[] intArr = {1,2,3,4,5,6,7,8,9,10,11};
        assertEquals(10, bs.search(intArr, 11));
    }

    @Test
    void shouldThrowNotFoundException() {
        Integer[] intArr = {1,2,3,4,5,6,7,8,9,10,11};
        assertThrows(ElementNotFoundException.class, () ->  bs.search(intArr, 100));
    }

    @Test
    void searchDecimalValue() {
        Float[] intArr = {.1f,2f,3f,4f,5f,6f,7f,8f,9f,10f,11f};
        assertEquals(10, bs.search(intArr, 11f));
    }
}
