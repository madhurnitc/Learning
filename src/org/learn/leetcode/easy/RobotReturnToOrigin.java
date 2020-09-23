package org.learn.leetcode.easy;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        if (moves.length() % 2 != 0) return false;
        int verMoves = 0;
        int horMoves = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') verMoves++;
            if (moves.charAt(i) == 'D') verMoves--;
            if (moves.charAt(i) == 'L') horMoves--;
            if (moves.charAt(i) == 'R') horMoves++;
        }

        return (verMoves == 0) && (horMoves == 0);
    }

    public static void main(String[] args) {
        RobotReturnToOrigin rb = new RobotReturnToOrigin();
        System.out.println(rb.judgeCircle("UD"));
    }
}
