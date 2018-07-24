package ru.javawebinar.basejava;

public class MainUtil {

    public static void main(String[] args) {
        System.out.println(Integer.valueOf(-1) == Integer.valueOf(-1)); // true
        System.out.println(Integer.valueOf(-1) == new Integer(-1)); // false

        double x = 1.14;
        double y = x/0;
        System.out.println(y); // Infinity

        int result = getInt();
        System.out.println(result);
    }

    private static Integer getInt() {
        return null;
    }
}
