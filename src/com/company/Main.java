package com.company;

import com.company.classes.*;

import java.io.IOException;

/**
 * Lefter Olexiy, 18
 */
public class Main {
    /**
     * Создать класс треугольник, члены класса – координаты 3-х точек.
     * Предусмотреть в классе методы проверки существования треугольника, вычисления и вывода сведений о фигуре – длины сторон,
     * углы, периметр, площадь. Создать производный класс – прямоугольный треугольник, предусмотреть в классе проверку,
     * является ли треугольник прямоугольным. Написать программу,
     * демонстрирующую работу с классом: дано N треугольников и M прямоугольных треугольников,
     * найти треугольники с максимальной иS минимальной площадью и вывести номера одинаковых прямоугольных треугольников.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final int MAX_SIDE_SIZE = 100;
        final int N = 5;
        final int M = 5;
        int tempX1;
        int tempY1;
        int tempX2;
        int tempY2;
        int tempX3;
        int tempY3;
        TrianglesList trianglesList = new TrianglesList();
        TrianglesList rightTrianglesList = new TrianglesList();
        TrianglesList trianglesListPrev = new TrianglesList();
        TrianglesList rightTrianglesListPrev = new TrianglesList();
        System.out.println();
        for (int i = 0; i < N; i++) {
            while (!Triangle.isExistTriangle(tempX1 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY1 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempX2 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY2 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempX3 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY3 = (int) (Math.random() * MAX_SIDE_SIZE) - 50)) {
            }
            trianglesList.add(new Triangle(tempX1, tempY1, tempX2, tempY2, tempX3, tempY3));
        }
        System.out.println(trianglesList);
        for (int i = 0; i < M; i++) {
            while (!RightTriangle.isRightTriangle(tempX1 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY1 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempX2 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY2 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempX3 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY3 = (int) (Math.random() * MAX_SIDE_SIZE) - 50)) {
            }
            rightTrianglesList.add(new RightTriangle(tempX1, tempY1, tempX2, tempY2, tempX3, tempY3));
        }
        System.out.println(rightTrianglesList);

        System.out.println("\n--------------------------------\n");

        try {
            trianglesList = Packer.autoLoadNative("simple");
            rightTrianglesList = Packer.autoLoadNative("right");
            trianglesListPrev = Packer.autoLoadJSON("simple");
            rightTrianglesListPrev = Packer.autoLoadJSON("right");

            System.out.println(trianglesList);
            System.out.println(rightTrianglesList);

            System.out.println("\n--------------------------------\n");

            System.out.println(trianglesListPrev);
            System.out.println(rightTrianglesListPrev);
        } catch (Exception e) {
            for (int i = 0; i < N; i++) {
                while (!Triangle.isExistTriangle(tempX1 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY1 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempX2 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY2 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempX3 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY3 = (int) (Math.random() * MAX_SIDE_SIZE) - 50)) {
                }
                trianglesList.add(new Triangle(tempX1, tempY1, tempX2, tempY2, tempX3, tempY3));
            }
            System.out.println(trianglesList);

            for (int i = 0; i < M; i++) {
                while (!RightTriangle.isRightTriangle(tempX1 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY1 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempX2 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY2 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempX3 = (int) (Math.random() * MAX_SIDE_SIZE) - 50, tempY3 = (int) (Math.random() * MAX_SIDE_SIZE) - 50)) {
                }
                rightTrianglesList.add(new RightTriangle(tempX1, tempY1, tempX2, tempY2, tempX3, tempY3));
            }
            System.out.println(rightTrianglesList);
        }

        Packer.autoSaveNative(trianglesList,"simple");
        Packer.autoSaveNative(rightTrianglesList,"right");
        Packer.autoSaveJSON(trianglesListPrev, "simple");
        Packer.autoSaveJSON(rightTrianglesListPrev, "right");

        System.out.println("--------------------------------------------------------");

        Packer.saveNative(trianglesList, "Triangle");
        Packer.saveJSON(trianglesList, "TrianglesJSON");
        Packer.saveNative(rightTrianglesList,"rTriangle");
        Packer.saveJSON(rightTrianglesList, "rTrianglesJSON");

        System.out.println(Packer.loadNative("./src/Pack/Triangle.txt"));
//        System.out.println(Packer.loadJSON("./src/PackJSON/TrianglesJSON.json"));
        System.out.println(Packer.loadNative("./src/Pack/rTriangle.txt"));
//        System.out.println(Packer.loadJSON("./src/PackJSON/rTrianglesJSON.json"));

    }
}
