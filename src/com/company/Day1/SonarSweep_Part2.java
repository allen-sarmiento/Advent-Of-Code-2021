package com.company.Day1;

import java.util.ArrayList;
import java.util.Scanner;

public class SonarSweep_Part2
{
    public static void main(String[] args)
    {
        int count = 0;
        ArrayList<Short> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers (Enter non-number to finish):");
        while (sc.hasNextShort())
            list.add(sc.nextShort());
        for (int i = 0; i < list.size()-3; i++)
            if (list.get(i) + list.get(i+1) + list.get(i+2) < list.get(i+1) + list.get(i+2) + list.get(i+3))
                count++;
        System.out.println("Answer: " + count);
    }
}
