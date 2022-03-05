package edu.neu.coe.info6205.union_find;

import java.util.Random;


public class HWQUPC_Solution {
    public static int count(int n, UF_HWQUPC ufHwqupc){
        int connectionsCount = 0;
        while(ufHwqupc.components() > 1){
            int[] randomPair = randomPair(n);
            int i = randomPair[0];
            int j = randomPair[1];
            connectionsCount++;
            ufHwqupc.connect(i,j);
        }
        return connectionsCount;
    }

    private static int[] randomPair(int n) {
        Random ran = new Random();
        int[] ans = new int[2];
        int p = ran.nextInt(n);
        int q;
        do {
            q = ran.nextInt(n);
        } while(p==q);

        ans[0] = p;
        ans[1] = q;
        return ans;
    }

    public static void main(String args[]){
        int[] t = {10, 20, 40, 80, 800, 1600, 3200};
        int[] countResult = new int[50];
        for(int i=0; i<t.length; i++){
            int avgCount = 0;
            for(int j= 0; j<50;j++){
                UF_HWQUPC ufHwqupc = new UF_HWQUPC(t[i]);
                countResult[j] = count(t[i], ufHwqupc);
                avgCount += countResult[j];
            }
            int avg = avgCount / 50;
            System.out.println("Average:("+ t[i] +") -> "  + avg);
        }
    }
}
