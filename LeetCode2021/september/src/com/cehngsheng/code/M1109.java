package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/10/25
 */
public class M1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] result = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            for (int j = 0; j < n; j++) {
                if (bookings[i][0]<=j+1&&j+1<=bookings[i][1]){
                    result[j]+=bookings[i][2];
                }
            }
        }

        return result;
    }

    public int[] corpFlightBookings2(int[][] bookings, int n) {

        int[] chafen =new int[n+1];

        for (int i = 0; i < bookings.length; i++) {
            chafen[bookings[i][0]]+=bookings[i][2];
            if (bookings[i][1]<=n-1){
                chafen[bookings[i][1]+1]-=bookings[i][2];
            }
        }
        int[] result = new int[n];
        result[0]=chafen[1];
        for (int i = 1; i < n; i++) {
            result[i]=result[i-1]+chafen[i+1];
        }
        return result;
    }
}
