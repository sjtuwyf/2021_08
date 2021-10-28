package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/9/12
 */
public class S0463 {

    public int islandPerimeter(int[][] grid) {
        int area = 0;
        int coincide = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    area++;

//                    if (i == 0) {
//                        if (grid[i + 1][j] == 1) {
//                            coincide++;
//                        }
//                    } else if (i == row - 1) {
//                        if (grid[i - 1][j] == 1) {
//                            coincide++;
//                        }
//                    } else {
//                        if (grid[i - 1][j] == 1) {
//                            coincide++;
//                        }
//                        if (grid[i + 1][j] == 1) {
//                            coincide++;
//                        }
//                    }
                    if (i > 0){
                        if (grid[i - 1][j] == 1) {
                            coincide++;
                        }
                    }
                    if (i < row -1){
                        if (grid[i + 1][j] == 1) {
                            coincide++;
                        }
                    }

                    if (j > 0){
                        if (grid[i][j -1] == 1) {
                            coincide++;
                        }
                    }
                    if (j < col -1){
                        if (grid[i][j+1] == 1) {
                            coincide++;
                        }
                    }
//
//                    if (j == 0) {
//                        if (grid[i][j + 1] == 1) {
//                            coincide++;
//                        }
//                    } else if (j == col - 1) {
//                        if (grid[i][j - 1] == 1) {
//                            coincide++;
//                        }
//                    } else {
//                        if (grid[i][j - 1] == 1) {
//                            coincide++;
//                        }
//                        if (grid[i][j + 1] == 1) {
//                            coincide++;
//                        }
//                    }
                }

            }
        }

        return 4*area-coincide;
    }
}
