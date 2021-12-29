package org.learn.leetcode.medium;

public class WordSearch {
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i =0 ; i<board.length; i++) {
            for(int j = 0 ; j<board[0].length; j++) {
                if (exist(board, i, j, word,0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int i, int j , String word, int k) {
        if(k == word.length()) {
            return true;
        }
        if(i >= board.length || i < 0 || j<0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        boolean exists = false;
        visited[i][j] = true;
        if(board[i][j] == word.charAt(k)) {
            exists = exist(board, i+1,j,word,k+1)
                    || exist(board, i-1,j, word, k+1)
                    || exist(board, i, j+1, word, k+1)
                    || exist(board,i, j-1, word, k+1);
        }

        visited[i][j] = false;

        return exists;
    }

    public static void main(String[] args) {
        char[][] input = {{'C','A','A'},
                {'A','A','A'},
                {'B','C', 'D'}
        };

        String word = "AAB";

        new WordSearch().exist(input, word);

    }
}
