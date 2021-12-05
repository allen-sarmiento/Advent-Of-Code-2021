package com.company.Day5;

import java.util.ArrayList;
import java.util.List;

public class Points
{
    public List<Integer> startX, endX, startY, endY;
    public int xMax, yMax, count;

    public Points()
    {
        xMax = 0;
        yMax = 0;
        count = 0;

        startX = new ArrayList<>();
        endX = new ArrayList<>();
        startY = new ArrayList<>();
        endY = new ArrayList<>();
    }

    public void print()
    {
        System.out.println("X1: " + startX.toString());
        System.out.println("Y1: " + startY.toString());
        System.out.println("X2: " + endX.toString());
        System.out.println("Y2: " + endY.toString());
    }

    public void addPoint(String x1, String y1, String x2, String y2)
    {
        startX.add(Integer.parseInt(x1));
        endX.add(Integer.parseInt(x2));
        startY.add(Integer.parseInt(y1));
        endY.add(Integer.parseInt(y2));
        xMax = Math.max(xMax, Math.max(Integer.parseInt(x1), Integer.parseInt(x2)));
        yMax = Math.max(yMax, Math.max(Integer.parseInt(y1), Integer.parseInt(y2)));
        count++;
    }
}
