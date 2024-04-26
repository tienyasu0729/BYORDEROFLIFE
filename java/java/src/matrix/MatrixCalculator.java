package matrix;

import java.util.Scanner;

public class MatrixCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMatrix Calculator Menu:");
            System.out.println("1. Add matrices");
            System.out.println("2. Subtract matrices");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Exit");
            int choice = Integer.parseInt(Validate.checkIntInPut("^[1-4]$", "- Enter your choice (1/2/3/4): "));

            switch (choice) {
                case 1:
                    int rows = Integer.parseInt(Validate.checkIntInPut("^\\d+$", "- Enter the number of rows for the matrices: "));
                    int cols = Integer.parseInt(Validate.checkIntInPut("^\\d+$", "- Enter the number of columns for the matrices: "));

                    Matrix matrix1 = new Matrix(rows, cols);
                    Matrix matrix2 = new Matrix(rows, cols);

                    System.out.println("Enter values for the first matrix:");
                    matrix1.inputMatrix();
                    System.out.println("Enter values for the second matrix:");
                    matrix2.inputMatrix();

                    Matrix result = matrix1.additionMatrix(matrix2);
                    if (result != null) {
                        System.out.println("\nResult of Addition:");
                        result.display();
                    } else {
                        System.out.println("Matrices must have the same dimensions for addition.");
                    }
                    break;

                case 2:
                    int rows2 = Integer.parseInt(Validate.checkIntInPut("^\\d+$", "- Enter the number of rows for the matrices: "));
                    int cols2 = Integer.parseInt(Validate.checkIntInPut("^\\d+$", "- Enter the number of columns for the matrices: "));
                    Matrix matrix12 = new Matrix(rows2, cols2);
                    Matrix matrix22 = new Matrix(rows2, cols2);

                    System.out.println("Enter values for the first matrix:");
                    matrix12.inputMatrix();
                    System.out.println("Enter values for the second matrix:");
                    matrix22.inputMatrix();

                    Matrix result2 = matrix12.subtractionMatrix(matrix22);
                    if (result2 != null) {
                        System.out.println("\nResult of Subtraction:");
                        result2.display();
                    } else {
                        System.out.println("Matrices must have the same dimensions for subtraction.");
                    }
                    break;

                case 3:
                    int rows3 = Integer.parseInt(Validate.checkIntInPut("^\\d+$","- Enter the number of rows for the matrices: "));
                    int cols3 = Integer.parseInt(Validate.checkIntInPut("^\\d+$","- Enter the number of columns for the matrices: "));
                    int rows23 = Integer.parseInt(Validate.checkIntInPut("^\\d+$", "- Enter the number of rows for the second matrix: "));
                    int cols23 = Integer.parseInt(Validate.checkIntInPut("^\\d+$", "- Enter the number of columns for the second matrix: "));

                    if (cols3 != rows23) {
                        System.out.println("The number of columns in the first matrix must match the number of rows in the second matrix.");
                    } else {
                        Matrix matrix13 = new Matrix(rows3, cols3);
                        Matrix matrix23 = new Matrix(rows23, cols23);

                        System.out.println("Enter values for the first matrix:");
                        matrix13.inputMatrix();
                        System.out.println("Enter values for the second matrix:");
                        matrix23.inputMatrix();

                        Matrix result3 = matrix13.multiplicationMatrix(matrix23);
                        if (result3 != null) {
                            System.out.println("\nResult of Multiplication:");
                            result3.display();
                        } else {
                            System.out.println("Invalid matrix dimensions for multiplication.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
            }
        }
    }
}