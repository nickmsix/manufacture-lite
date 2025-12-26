package io.testomat.manufacture_lite.utils;

import static java.lang.Integer.parseInt;

public class StringParsers {

    public static Integer parseIntegerFromString(String testsCountLine) {
        return parseInt(testsCountLine.replaceAll("\\D+", ""));
    }
}
