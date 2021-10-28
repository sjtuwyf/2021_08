package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/9/27
 */
public class M1604 {
    public static String tictactoe(String[] board) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < board.length; i++) {
            s.delete(0, s.length());
            s.append(board[i]);
            Character winer = isWiner(s);
            if (winer != ' ') {
                return String.valueOf(winer);
            }

        }
        int length = board[0].length();
        for (int i = 0; i < length; i++) {
            s.delete(0, s.length());
            for (int j = 0; j < board.length; j++) {
                s.append(board[j].charAt(i));
            }
            Character winer = isWiner(s);
            if (winer != ' ') {
                return String.valueOf(winer);
            }
        }
        s.delete(0, s.length());
        for (int i = 0; i < length; i++) {
            s.append(board[i].charAt(i));

        }
        Character winer = isWiner(s);
        if (winer != ' ') {
            return String.valueOf(winer);
        }
        s.delete(0, s.length());
        for (int i = 0; i < length; i++) {
            s.append(board[i].charAt(length-i-1));

        }
        winer = isWiner(s);
        if (winer != ' ') {
            return String.valueOf(winer);
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i].charAt(j) == ' '){
                    return "Pending";
                }
            }
        }
        return "Draw";
    }

    public static Character isWiner(StringBuffer s) {
        System.out.println(s);
        System.out.println("==========");
        int n = s.length();
        char c = s.charAt(0);
        if (c == ' ' ) {
            return c;
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != c) {
                return ' ';
            }
        }
        return c;
    }


    public static void main(String[] args) {
        System.out.println(tictactoe(new String[]{"O X", " XO", "X O"}));
    }
}
