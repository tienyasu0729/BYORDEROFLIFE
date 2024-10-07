import java.util.Scanner;

public class ss {
    public static void main(String[] args) {
        int n;
        System.out.print("Enter the number of first digits in " +
                "the fibonacci sequence you want to output: ");
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
        }

        int n1 = 0, n2 = 1;

        if (n == 1) {
            System.out.print(n1);
        } else if (n == 2) {
            System.out.print(n1 + " " + n2);
        } else {
            System.out.print(n1 + " " + n2);
            int tempNthTerm;
            for (int i = 3; i <= n; i++) {
                tempNthTerm = n1 + n2;
                System.out.print(" " + tempNthTerm);
                n1 = n2;
                n2 = tempNthTerm;
            }
        }
    }
}
