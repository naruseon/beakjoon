package com.github.naruseon.beakjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1780 {

    static int cnt = 0;
    static String[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        paper = new String[size][size];
        for (int i = 0; i < size; i++) {
            String[] arr = br.readLine().split(" ");
            System.arraycopy(arr, 0, paper[i], 0, size);
        }
        solve(0, 0, size);
        System.out.println(cnt);
    }

    // 0 1 2
    // 3 4 5
    // 6 7 8

    public static void solve(int x, int y, int size) {
        if (isCorrect(x, y, size)) {
            cnt++;
            return;
        }
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solve(x + i * newSize, y + i * newSize, newSize);
            }
        }
    }

    public static boolean isCorrect(int x, int y, int size) {
        String std = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!std.equals(paper[i][j]))
                    return false;
            }
        }
        return true;
    }
}
