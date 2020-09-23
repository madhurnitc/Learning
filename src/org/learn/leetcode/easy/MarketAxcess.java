package org.learn.leetcode.easy;

public class MarketAxcess {


    public static int entryTime(String s, String keypad) {
        // Write your code here

        int colIndex = 0;
        int rowIndex = 0;
        int totalTime = 0;
        boolean firstChar = true;
        for (char c : s.toCharArray()) {

            int intVal = Character.getNumericValue(c);
            int index = keypad.indexOf(c);
            if (firstChar) {
                colIndex = index % 3;
                rowIndex = index / 3;
                firstChar = false;
            } else {
                int currentColIndex = index % 3;
                int currentRowIndex = index / 3;
                if (currentColIndex == colIndex && currentRowIndex == rowIndex) {

                } else if (isNeighbor(currentColIndex, currentRowIndex, colIndex, rowIndex)) {
                    totalTime = totalTime + 1;
                } else {
                    totalTime = totalTime + 2;
                }
                colIndex = currentColIndex;
                rowIndex = currentRowIndex;
            }

        }

        return totalTime;

    }

    private static boolean isNeighbor(int currentColIndex, int currentRowIndex, int startColIndex, int startRowIndex) {

        if (startColIndex == currentColIndex && startRowIndex != currentRowIndex) {

            if (startRowIndex + 1 == currentColIndex || startRowIndex - 1 == currentColIndex) {
                return true;
            }
        } else if (startColIndex != currentColIndex && startRowIndex == currentRowIndex) {
            if (startColIndex + 1 == currentColIndex || startColIndex - 1 == currentColIndex) {
                return true;
            }
        } else {
            if ((startColIndex + 1 == currentColIndex && startRowIndex + 1 == currentRowIndex) ||
                    (startColIndex + 1 == currentColIndex && startRowIndex - 1 == currentRowIndex) ||
                    (startColIndex - 1 == currentColIndex && startRowIndex - 1 == currentRowIndex) ||
                    (startColIndex - 1 == currentColIndex && startRowIndex + 1 == currentRowIndex)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(entryTime("5111", "752961348"));
    }
}
