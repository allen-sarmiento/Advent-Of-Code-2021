package com.company.Day4;

import java.util.*;

public class GiantSquid_Part1 {

    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] calls = {};
        List<List<List<String>>> boards = new ArrayList<>();
        for (int i = 0;;i++) {
            if (i == 0)
                calls = sc.nextLine().split(",");
            else if (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equals("x"))
                    break;
                else if (line.isEmpty()) {
                    i--;
                    continue;
                } else if (line.charAt(0) == ' ')
                    line = line.substring(1);
                if (boards.size() < Math.ceil(i / 5.0))
                    boards.add(new ArrayList<>());
                boards.get((boards.size()-1)).add(new ArrayList<String>(Arrays.asList(line.split("\\s+"))));
            }
        }
        bingo: {
            // For each call
            for (int i = 0; i < calls.length; i++) {
                // For each board
                for (int j = 0; j < boards.size(); j++) {
                    // For each row
                    for (int k = 0; k < boards.get(j).size(); k++) {
                        // For each number
                        for (int l = 0; l < boards.get(j).get(k).size(); l++) {
                            // If number equals call
                            if (boards.get(j).get(k).get(l).equals(calls[i])) {
                                boards.get(j).get(k).set(l, "X");
                                PrintBoard(boards.get(j), calls[i], j+1);
                                // Check Rows and Cols
                                if (CheckRows(boards.get(j)) > 0) {
                                    System.out.println("Answer: " + (CheckRows(boards.get(j)) * Integer.parseInt(calls[i])));
                                    break bingo;
                                } else if (CheckCols(boards.get(j)) > 0) {
                                    System.out.println("Answer: " + (CheckCols(boards.get(j)) * Integer.parseInt(calls[i])));
                                    break bingo;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void PrintBoard(List<List<String>> board, String call, int boardNum) {
        System.out.println("Call: " + call + ", Board #" + boardNum);
        for (List<String> row : board) {
            for (String num : row)
                System.out.print(num + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static int CheckRows(List<List<String>> board) {
        for (int i = 0; i < 5; i++) {
            int markCount = 0;
            for (int j = 0; j < 5; j++)
                if (board.get(i).get(j).equals("X"))
                    markCount++;
            if (markCount == 5) {
                int sum = 0;
                for (List<String> row : board)
                    for (String num : row)
                        if (!num.equals("X"))
                            sum += Integer.parseInt(num);
                return sum;
            }
        }
        return -1;
    }

    public static int CheckCols(List<List<String>> board) {
        for (int j = 0; j < 5; j++) {
            int markCount = 0;
            for (int i = 0; i < 5; i++)
                if (board.get(i).get(j).equals("X"))
                    markCount++;
            if (markCount == 5) {
                int sum = 0;
                for (List<String> row : board)
                    for (String num : row)
                        if (!num.equals("X"))
                            sum += Integer.parseInt(num);
                return sum;
            }
        }
        return -1;
    }
}
