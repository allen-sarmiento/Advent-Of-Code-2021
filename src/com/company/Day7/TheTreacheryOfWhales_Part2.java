package com.company.Day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TheTreacheryOfWhales_Part2
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
        for (int pos : crabs)
            if (pos != target)
                fuel += GetFuel(Math.abs(pos - target));
        System.out.println("Target: " + target);
        System.out.println("Fuel: " + fuel);
    }

    public static int GetTarget(List<Integer> crabs)
    {
        // [** *] [**] 2.5
        // [**] [**] 2
        double target = crabs.size()/2.0;
        int leftFuel = 0, rightFuel = 0;
        for (int pos = 0; pos < target; pos++)
            leftFuel += GetFuel(pos);
        for (int pos = (int)Math.ceil(target); pos < crabs.size(); pos++)
            rightFuel += GetFuel(pos);
        if (Math.abs(leftFuel - rightFuel) > GetFuel((int)Math.abs(Math.ceil(target) - target)) &&
            leftFuel > rightFuel)
            return GetTarget(crabs.subList(0, (int)target));
        else if (rightFuel < leftFuel)
            return GetTarget(crabs.subList((int)Math.ceil(target), crabs.size()));
        else


        return 0;
    }

    public static int GetFuel(int num)
    {
        if (num >= 1)
            return num + GetFuel(num-1);
        else
            return 0;
    }
}
