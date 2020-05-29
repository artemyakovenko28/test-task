package com.company;

import java.util.ArrayList;
import java.util.List;

public final class Converter {

    public String convertToString(final Integer value) {
        final List<Integer> digits = splitToDigits(value);

        final StringBuilder result = new StringBuilder();
        boolean isSequence = false;

        if (digits.size() == 1) {
            return result.append(digits.get(0)).toString();
        }

        for (int i = digits.size() - 1; i > 0; i--) {
            int current = digits.get(i);
            int next = digits.get(i - 1);

            boolean isConsecutive = next - current == 1;
            if (isConsecutive && !isSequence) {
                isSequence = true;
                result.append(current);
            }
            if (isConsecutive && isSequence) {
                if (digits.indexOf(next) == 0) {
                    result.append("-").append(next);
                }
            }
            if (!isConsecutive && !isSequence) {
                result.append(current).append(",");
                if (digits.indexOf(next) == 0) {
                    result.append(next);
                }
            }
            if (!isConsecutive && isSequence) {
                isSequence = false;
                result.append("-").append(current).append(",");
                if (digits.indexOf(next) == 0) {
                    result.append(next);
                }
            }
        }

        return result.toString();
    }

    private List<Integer> splitToDigits(final Integer value) {
        int number = value;
        final List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            int digit = number % 10;
            if (digit < 1 || digit > 7) {
                throw new IllegalArgumentException("digits in number cannot be less than 1 or greater than 7");
            }
            digits.add(digit);
            number = number / 10;
        }
        return digits;
    }
}
