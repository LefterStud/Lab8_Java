package com.company.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Triangle implements java.io.Serializable{
    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;

    public Triangle(final int x1, final int y1, final int x2, final int y2, final int x3, final int y3) {
        this.setX1(x1);
        this.setY1(y1);
        this.setX2(x2);
        this.setY2(y2);
        this.setX3(x3);
        this.setY3(y3);
    }

    protected void setX1(int x1) {
        this.x1 = x1;
    }

    protected void setX2(int x2) {
        this.x2 = x2;
    }

    protected void setX3(int x3) {
        this.x3 = x3;
    }

    protected void setY1(int y1) {
        this.y1 = y1;
    }

    protected void setY2(int y2) {
        this.y2 = y2;
    }

    protected void setY3(int y3) {
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getX3() {
        return x3;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public double getY3() {
        return y3;
    }

    public static double getSideSize(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public double getASideSize() {
        return Math.sqrt(Math.pow((getX2() - getX1()), 2) + Math.pow((getY2() - getY1()), 2));
    }

    public double getCSideSize() {
        return Math.sqrt(Math.pow((getX1() - getX3()), 2) + Math.pow((getY1() - getY3()), 2));
    }

    public double getBSideSize() {
        return Math.sqrt(Math.pow((getX3() - getX2()), 2) + Math.pow((getY3() - getY2()), 2));
    }

    public double getA1Angle() {
        return Math.acos((Math.pow(getASideSize(), 2) + Math.pow(getBSideSize(), 2) - Math.pow(getCSideSize(), 2)) / (2 * getASideSize() * getBSideSize())) * 57.2957795;
    }

    public double getA2Angle() {
        return Math.acos((Math.pow(getBSideSize(), 2) + Math.pow(getCSideSize(), 2) - Math.pow(getASideSize(), 2)) / (2 * getBSideSize() * getCSideSize())) * 57.2957795;
    }

    public double getA3Angle() {
        return Math.acos((Math.pow(getASideSize(), 2) + Math.pow(getCSideSize(), 2) - Math.pow(getBSideSize(), 2)) / (2 * getASideSize() * getCSideSize())) * 57.2957795;
    }

    public double getPerimeter() {
        return getASideSize() + getBSideSize() + getCSideSize();
    }

    public double getSquare() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - getASideSize()) * (p - getBSideSize()) * (p - getCSideSize()));
    }

    public static boolean isExistTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        double A = getSideSize(x1, y1, x2, y2);
        double B = getSideSize(x3, y3, x2, y2);
        double C = getSideSize(x1, y1, x3, y3);
        return (A + B > C) && (B + C > A) && (A + C > B);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "x1=" + x1 +
                "; x2=" + x2 +
                "; x3=" + x3 +
                "; y1=" + y1 +
                "; y2=" + y2 +
                "; y3=" + y3 +
                "; aSide=" + String.format("%.2f", getASideSize()) +
                "; bSide=" + String.format("%.2f", getBSideSize()) +
                "; cSide=" + String.format("%.2f", getCSideSize()) +
                "; perimeter=" + String.format("%.2f", getPerimeter()) +
                "; square=" + String.format("%.2f", getSquare()) +
                "; angle1=" + String.format("%.2f", getA1Angle()) +
                "; angle2=" + String.format("%.2f", getA2Angle()) +
                "; angle3=" + String.format("%.2f", getA3Angle()) +
                "}\n";
    }

}

