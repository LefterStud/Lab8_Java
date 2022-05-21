package com.company.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class RightTriangle extends Triangle implements java.io.Serializable{
    public RightTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        super(x1, y1, x2, y2, x3, y3);
    }

    public static boolean isRightTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        double A = getSideSize(x1, y1, x2, y2);
        double B = getSideSize(x3, y3, x2, y2);
        double C = getSideSize(x1, y1, x3, y3);
        return Triangle.isExistTriangle(x1, y1, x2, y2, x3, y3) && ((A * A + B * B == C * C) || (B * B + C * C == A * A) || (A * A + C * C == B * B));
    }

    @Override
    public String toString() {
        return "Right" + super.toString();
    }
}
