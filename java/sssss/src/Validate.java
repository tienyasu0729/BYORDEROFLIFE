import java.util.Scanner;

public class Validate {
    private static Scanner scanner = new Scanner(System.in);
        public static String checkIntInPut(String regex, String firstEnter, String errorEnter) {
        System.out.print(firstEnter);
        String input = scanner.nextLine().trim();
        while (!input.matches(regex)){
            System.out.print(errorEnter);
            input = scanner.nextLine().trim();
        }
        return input;
    }
}

