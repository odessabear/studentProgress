package utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilsTest {

    private static final String EMPTY_INPUT = "";

    private static final String NOT_EMPTY_INPUT = "not empty string";

    @Test
    public void shouldReturnTrueWhenInputStringIsNull() {
        //GIVEN
        String input = null;

        //WHEN
        boolean result = Utils.isEmpty(input);

        //THEN

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenInputStringIsEmpty() {
        //GIVEN
        String input = EMPTY_INPUT;

        //WHEN
        boolean result = Utils.isEmpty(input);

        //THEN

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenInputStringIsNotEmpty() {
        //GIVEN
        String input = NOT_EMPTY_INPUT;

        //WHEN
        boolean result = Utils.isEmpty(input);

        //THEN

        assertFalse(result);
    }
}