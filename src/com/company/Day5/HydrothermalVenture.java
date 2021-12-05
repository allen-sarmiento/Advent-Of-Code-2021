package com.company.Day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HydrothermalVenture
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Points points = new Points();

        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            if (line.equals("x")) break;
            else
            {
                String x1 = line.substring(0,line.indexOf(","));
                String y1 = line.substring(x1.length()+1,line.indexOf(" "));
                line = line.substring(x1.length()+y1.length()+5);
                String x2 = line.substring(0,line.indexOf(","));
                String y2 = line.substring(x2.length()+1);
                points.addPoint(x1,y1,x2,y2);
            }
        }
        Diagram diagram = new Diagram(points.xMax,points.yMax);
        // points.print();
        for (int i = 0; i < points.count; i++)
            diagram.coverLine(points.startX.get(i), points.startY.get(i), points.endX.get(i), points.endY.get(i));
        diagram.print();
        System.out.println("Answer: " + diagram.twoCount);
    }
}
