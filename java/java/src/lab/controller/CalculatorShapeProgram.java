package lab.controller;

import lab.model.Circle;
import lab.model.Rectangle;
import lab.model.Shape;
import lab.model.Triangle;
import lab.validate.Validate;

import java.util.Scanner;

public class CalculatorShapeProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====Calculator Shape Program=====");
        double rectWidth = Double.parseDouble(Validate.checkIntInPut("^[+]?(?:\\d+|\\d*\\.\\d+)$","- Please input side width of Rectangle: ","- Invalid data, please re-enter: "));
        double rectLength = Double.parseDouble(Validate.checkIntInPut("^[+]?(?:\\d+|\\d*\\.\\d+)$","- Please input length of Rectangle: ","- Invalid data, please re-enter: "));
        double circleRadius = Double.parseDouble(Validate.checkIntInPut("^[+]?(?:\\d+|\\d*\\.\\d+)$","- Please input radius of Circle: ","- Invalid data, please re-enter: "));
        double triangleSideA;
        double triangleSideB;
        double triangleSideC;
        Boolean check;
        do {
            triangleSideA = Double.parseDouble(Validate.checkIntInPut("^[+]?(?:\\d+|\\d*\\.\\d+)$", "- Please input side A of Triangle: ", "- Invalid data, please re-enter: "));
            triangleSideB = Double.parseDouble(Validate.checkIntInPut("^[+]?(?:\\d+|\\d*\\.\\d+)$", "- Please input side B of Triangle: ", "- Invalid data, please re-enter: "));
            triangleSideC = Double.parseDouble(Validate.checkIntInPut("^[+]?(?:\\d+|\\d*\\.\\d+)$", "- Please input side C of Triangle: ", "- Invalid data, please re-enter: "));
            if(((triangleSideA + triangleSideB) > triangleSideC)){
                check = false;
            }else {
                check = true;
                System.out.println("- Invalid data, please re-enter: ");
            }
        }while (check);
        Shape rectangle = new Rectangle(rectWidth, rectLength);
        Shape circle = new Circle(circleRadius);
        Shape triangle = new Triangle(triangleSideA, triangleSideB, triangleSideC);

        rectangle.printResult();
        circle.printResult();
        triangle.printResult();

        scanner.close();
    }
}
