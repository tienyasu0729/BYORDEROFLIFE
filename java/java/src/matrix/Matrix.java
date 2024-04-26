package matrix;

import java.util.Scanner;

public class Matrix {
    private int rows;
    private int cols;
    private double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public void inputMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    try {
                        data[i][j] = Double.parseDouble(Validate.checkIntInPut("^-?\\d+$","Enter value at row " + (i + 1) + ", col " + (j + 1) + ": "));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Values of matrix must be a number.");
                    }
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Matrix additionMatrix(Matrix matrix2) {
        if (this.rows != matrix2.rows || this.cols != matrix2.cols) {
            return null;  // Ma trận phải có cùng kích thước để thực hiện phép cộng.
        }

        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + matrix2.data[i][j];
            }
        }

        return result;
    }

    public Matrix subtractionMatrix(Matrix matrix2) {
        if (this.rows != matrix2.rows || this.cols != matrix2.cols) {
            return null;  // Ma trận phải có cùng kích thước để thực hiện phép trừ.
        }

        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - matrix2.data[i][j];
            }
        }

        return result;
    }

    public Matrix multiplicationMatrix(Matrix matrix2) {
        if (this.cols != matrix2.rows) {
            return null;  // Số cột của ma trận thứ nhất phải bằng số hàng của ma trận thứ hai để thực hiện phép nhân.
        }

        Matrix result = new Matrix(this.rows, matrix2.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix2.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * matrix2.data[k][j];
                }
            }
        }

        return result;
    }
}
