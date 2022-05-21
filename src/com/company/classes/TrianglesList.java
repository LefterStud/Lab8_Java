package com.company.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrianglesList implements java.io.Serializable{
    private ArrayList<Triangle> trianglesList;
    public TrianglesList(){
        trianglesList=new ArrayList<>();
    }
    public ArrayList<Triangle> getList() {
        return trianglesList;
    }

    @Override
    public String toString() {
        return "TrianglesList" + trianglesList;
    }
    public boolean add(Triangle triangle){
        return trianglesList.add(triangle);
    }
    public void remove(int number){
        if(number< trianglesList.size()){
            trianglesList.remove(number);
        }
    }
    public Triangle findMaxSquareTriangleList() {
        Triangle maxTriangle = trianglesList.get(0);
        for (Triangle triangle:trianglesList) {
            if (triangle.getSquare() > maxTriangle.getSquare()) {
                maxTriangle = triangle;
            }
        }
        return maxTriangle;
    }
    public Triangle findMinSquareTriangleList() {
        Triangle minTriangle = trianglesList.get(0);
        for (Triangle triangle:trianglesList) {
            if (triangle.getSquare() < minTriangle.getSquare()) {
                minTriangle = triangle;
            }
        }
        return minTriangle;
    }

    public String findSameTrianglesList() {
        String numberSameTrianglesList = "";
        boolean[] sameArray = new boolean[trianglesList.size()];
        boolean isFirstEqual;
        for (int i = 0; i < trianglesList.size(); i++) {
            isFirstEqual = true;
            for (int j = i + 1; j < trianglesList.size(); j++) {
                if ((!sameArray[j]) && (trianglesList.get(j).getASideSize()) == (trianglesList.get(i).getASideSize()) && ((trianglesList.get(j).getBSideSize()) == (trianglesList.get(i).getBSideSize())) && ((trianglesList.get(j).getCSideSize()) == (trianglesList.get(i).getCSideSize()))) {
                    sameArray[j] = true;
                    if (isFirstEqual) {
                        isFirstEqual = false;
                        numberSameTrianglesList += (i + 1) + " ";
                    }
                    numberSameTrianglesList += (j + 1) + " ";
                }
            }
            numberSameTrianglesList += "\n";
        }
        return numberSameTrianglesList;
    }
}
