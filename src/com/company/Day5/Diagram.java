package com.company.Day5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Diagram
{
    public List<List<String>> cartesian;
    public int twoCount;


    public Diagram(int xMax, int yMax)
    {
        twoCount = 0;
        cartesian = new ArrayList<>();
        for (int i = 0; i <= yMax; i++)
        {
            List<String> y = new ArrayList<>();
            for (int j = 0; j <= xMax; j++)
                y.add(".");
            cartesian.add(y);
        }
    }

    public void print()
    {
        for (List<String> y : cartesian)
        {
            for (String p : y)
                System.out.print(p);
            System.out.println();
        }
    }

    private void coverPoint(int x, int y)
    {
        if (cartesian.get(y).get(x).equals("."))
            cartesian.get(y).set(x, "1");
        else
        {
            int p = Integer.parseInt(cartesian.get(y).get(x));
            cartesian.get(y).set(x, String.valueOf(++p));
            if (p == 2)
                twoCount++;
        }
    }

    public void coverLine(int x1, int y1, int x2, int y2)
    {
        if (x1 == x2)
            for (int i = Math.min(y1,y2); i <= Math.max(y1,y2); i++)
                coverPoint(x1, i);
        else if (y1 == y2)
            for (int i = Math.min(x1,x2); i <= Math.max(x1,x2); i++)
                coverPoint(i, y1);
        else if (x2 > x1 && y2 > y1)
            for (int i = x1; i <= x2;)
                for (int j = y1; j <= y2;)
                    coverPoint(i++, j++);
        else if (x2 > x1 && y2 < y1)
            for (int i = x1; i <= x2;)
                for (int j = y1; j >= y2;)
                    coverPoint(i++, j--);
        else if (x2 < x1 && y2 > y1)
            for (int i = x1; i >= x2;)
                for (int j = y1; j <= y2;)
                    coverPoint(i--, j++);
        else if (x2 < x1 && y2 < y1)
            for (int i = x1; i >= x2;)
                for (int j = y1; j >= y2;)
                    coverPoint(i--, j--);
    }
}
