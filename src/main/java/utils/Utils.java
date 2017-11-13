package utils;

public class Utils {
    public static boolean stringIsEmpty(String input) {
        return (input == null) || (input.equals("") || (input.length() == 0));
    }
}
