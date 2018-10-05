package com.code.dp;

import java.util.Scanner;

public class ShootingGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int n = sc.nextInt();
			int w = sc.nextInt();
			double p1 = sc.nextInt()*0.01;
			double p2 = sc.nextInt()*0.01;
			
			double [][]dp = new double[n+1][w+1];
			for(int i=0;i<=n;i++){
				dp[i][0] = 1;
			}
			
			for(int i=1;i<=w;i++){
				for(int j=1;j<=n;j++){
					int ptbackx = i-x;
					int ptbacky = i-y;
					if(ptbackx<0) ptbackx = 0;
					if(ptbacky<0) ptbacky = 0;
					double xp = p1*dp[j-1][ptbackx] + (1-p1)*dp[j-1][i];
					double yp = p2*dp[j-1][ptbacky] + (1-p2)*dp[j-1][i];
					dp[j][i] = Math.max(xp,yp);
				}
			}
			System.out.println(String.format("%.6f",dp[n][w]*100));
			sc.close();
		
		}
		
	}
}
