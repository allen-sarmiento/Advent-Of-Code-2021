package com.company.Day2;

import java.util.Scanner;

public class Dive_Part2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String command;
        int hor = 0, dep = 0, aim = 0, val = 0;
        while(sc.hasNext())
        {
            command = sc.next();
            if (command.equals("x"))
                break;
            else
            {
                val = Integer.parseInt(sc.next());
                if (command.equals("forward"))
                {
                    hor += val;
                    dep += aim * val;
                }
                else if (command.equals("up"))
                    aim -= val;
                else if (command.equals("down"))
                    aim += val;
            }
        }
        System.out.println("Answer: " + hor * dep);
    }
}
