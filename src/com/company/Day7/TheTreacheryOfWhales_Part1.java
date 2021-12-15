package com.company.Day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TheTreacheryOfWhales_Part1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int sum = 0, fuel = 0, target;
        List<Integer> crabs = new ArrayList<>();
        sc.useDelimiter(",|\\s+");
        while (sc.hasNextInt())
        {
            crabs.add(sc.nextInt());
            sum += crabs.get(crabs.size()-1);
        }
        Collections.sort(crabs);
        target = crabs.get(crabs.size()/2);
        for (int pos : crabs)
            if (pos != target)
                fuel += Math.abs(pos - target);
        System.out.println("Target: " + target);
        System.out.println("Fuel: " + fuel);
    }
}
