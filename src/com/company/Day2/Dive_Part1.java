package com.company.Day2;

import java.util.Scanner;

public class Dive_Part1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String command;
        int hor = 0, dep = 0;
        while (sc.hasNext())
        {
            command = sc.next();
            if (command.equals("forward"))
                hor += Integer.parseInt(sc.next());
            else if (command.equals("down"))
                dep += Integer.parseInt(sc.next());
            else if (command.equals("up"))
                dep -= Integer.parseInt(sc.next());
            else
                break;
        }
        System.out.println("Answer: " + hor*dep);
    }
}
