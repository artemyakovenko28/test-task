package com.company;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class ConverterTest {

    private final Converter converter = new Converter();

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void convertToString_0() {
        assertThat(converter.convertToString(123), is("1-3"));
    }

    @Test
    public void convertToString_1() {
        assertThat(converter.convertToString(135), is("1,3,5"));
    }

    @Test
    public void convertToString_2() {
        assertThat(converter.convertToString(125), is("1-2,5"));
    }

    @Test
    public void convertToString_3() {
        assertThat(converter.convertToString(12367), is("1-3,6-7"));
    }

    @Test
    public void convertToString_4() {
        assertThat(converter.convertToString(134567), is("1,3-7"));
    }

    @Test
    public void should_be_thrown_exception_when_digit_is_less_than_1() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("digits in number cannot be less than 1 or greater than 7");

        converter.convertToString(101);
    }

    @Test
    public void should_be_thrown_exception_when_digit_is_greater_than_7() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("digits in number cannot be less than 1 or greater than 7");

        converter.convertToString(181);
    }
}
