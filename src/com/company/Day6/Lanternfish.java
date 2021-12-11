package com.company.Day6;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Lanternfish
{
    public static void main(String[] args)
    {
        // Get input
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        BigInteger[] count = new BigInteger[10];
        for (int i = 0; i <= 9; i++)
            count[i] = BigInteger.ZERO;
        for (String str : input)
            count[Integer.parseInt(str)] = count[Integer.parseInt(str)].add(BigInteger.ONE);
        System.out.println("List: " + Arrays.toString(count));

        for (int days = 1; days <= 256; days++)
        {
            BigInteger sum = BigInteger.ZERO;
            count[9] = count[0];
            for (int i = 1; i <= 9; i++)
                count[i-1] = count[i];
            count[6] = count[6].add(count[9]);
            count[9] = BigInteger.ZERO;
            for (int i = 0; i <= 8; i++)
                sum = sum.add(count[i]);
            System.out.println("After Day " + days + ": " + sum + ", " + Arrays.toString(count));
        }
    }
}
