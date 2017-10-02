package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int a = Integer.parseUnsignedInt(br.readLine());
            int b = Integer.parseUnsignedInt(br.readLine());
            if ((a <=0 )||(b <= 0) ) throw new Exception();
            System.out.println(gcd(a,b));
        br.close();
    }

        public static int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
}
