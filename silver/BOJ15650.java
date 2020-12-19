package com.github.naruseon.beakjoon;

import java.util.*;

// N��  M, silver 3

public class BOJ15650 {
	
	static boolean[] isused;
	static int N, M;
	static int[] selected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		isused = new boolean[N];
		selected = new int[M];
		solve(0, 0);
	}
	
	public static void solve(int start, int k) {
		if (k == M) {
			for (int i : selected) {
				System.out.print((i + 1) + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			if (!isused[i]) {
				isused[i] = true;
				selected[k] = i;
				solve(i + 1, k + 1);
				isused[i] = false;
			}
		}
	}
}
