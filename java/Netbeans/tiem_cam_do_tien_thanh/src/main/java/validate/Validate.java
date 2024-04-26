package validate;

import java.util.Scanner;

public class Validate {
    private static Scanner scanner = new Scanner(System.in);
        public static String checkIntInPut(String regex, String firstEnter, String errorEnter) {
        System.out.print(firstEnter);
        String input = scanner.nextLine();
        while (!input.matches(regex)){
            System.out.print(errorEnter);
            input = scanner.nextLine();
        }
        return input;
    }
}

