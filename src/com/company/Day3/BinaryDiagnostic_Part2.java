package com.company.Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryDiagnostic_Part2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<char[]> bitmap = new ArrayList<>();
        while (sc.hasNext())
        {
            String line = sc.next();
            if (line.equals("x"))
                break;
            bitmap.add(line.toCharArray());
        }
        char[] O2Rating = GetRating("O2", bitmap, 12, 0).get(0);
        char[] CO2Rating = GetRating("CO2", bitmap, 12, 0).get(0);
        System.out.println("Answer: " + (Integer.parseInt(new String(O2Rating), 2) * Integer.parseInt(new String(CO2Rating), 2)));
    }

    public static List<char[]> GetRating(String type, List<char[]> bitmap, int byteSize, int recursionCount)
    {
        if (bitmap.size() > 1)
        {
            for (int i = recursionCount; i < byteSize; i++)
            {
                List<char[]> oneStarts = new ArrayList<>();
                List<char[]> zeroStarts = new ArrayList<>();
                for (int j = 0; j < bitmap.size(); j++)
                {
                    if (bitmap.get(j)[i] == '1')
                        oneStarts.add(bitmap.get(j));
                    else
                        zeroStarts.add(bitmap.get(j));
                }

                if (type.equals("O2") && oneStarts.size() >= zeroStarts.size())
                    return GetRating(type, oneStarts, byteSize, ++recursionCount);
                else if (type.equals("O2"))
                    return GetRating(type, zeroStarts, byteSize, ++recursionCount);
                else if (type.equals("CO2") && oneStarts.size() >= zeroStarts.size())
                    return GetRating(type, zeroStarts, byteSize, ++recursionCount);
                else if (type.equals("CO2"))
                    return GetRating(type, oneStarts, byteSize, ++recursionCount);
            }
        }
        return bitmap;
    }
}
