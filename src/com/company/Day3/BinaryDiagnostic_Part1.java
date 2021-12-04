package com.company.Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryDiagnostic_Part1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String gamma = "", epsilon = "";
        List<char[]> bitmap = new ArrayList<>();
        while (sc.hasNext())
        {
            String line = sc.next();
            if (line.equals("x"))
                break;
            bitmap.add(line.toCharArray());
        }
        for (int i = 0; i < 12; i++)
        {
            int oneCount = 0, zeroCount = 0;
            for (int j = 0; j < bitmap.size(); j++)
            {
                if (bitmap.get(j)[i] == '1')
                    oneCount++;
                else
                    zeroCount++;
            }
            if (oneCount > zeroCount)
            {
                gamma += "1";
                epsilon += "0";
            }
            else
            {
                gamma += "0";
                epsilon += "1";
            }
        }
        System.out.println("Answer: " + (Integer.parseInt(String.valueOf(gamma),2) * Integer.parseInt(String.valueOf(epsilon),2)));
    }
}
