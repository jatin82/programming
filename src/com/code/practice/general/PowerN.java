package com.code.practice.general;


public class PowerN {

	
	public static long powerFast(long a,long n,long MOD) {
		if(n==0) return 1;

		long firstHalf = powerFast(a,n/2,MOD)%MOD;
		
		if(n%2==0) {
			return (firstHalf*firstHalf)%MOD;
		}
		else
			return (firstHalf*firstHalf*a)%MOD;
		
	}
	
	public static long powerSlow(long a,long n,long MOD) {
		if(n==0) return 1;

		long result = 1;
		
		for(long i=1;i<=n;i++) {
			System.out.println("Iteration: "+i);
			result = result*a;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		long a = 2;
		
		long n = (long)Math.pow(10, 18);
		
		long mod = (long)Math.pow(10, 7);
		
		double start = System.currentTimeMillis();
		
		long x = powerFast(a,n,mod);
		
		double end  = System.currentTimeMillis();
		System.out.println("Time:"+(end-start));
		
		
		start = System.currentTimeMillis();
		
		x = (long)Math.pow(a, n);
		
		end  = System.currentTimeMillis();
		
		System.out.println("Time:"+(end-start));
		
		
		start = System.currentTimeMillis();
		
		x = powerSlow(a,n,mod);
		
		end  = System.currentTimeMillis();
		
		System.out.println("Time:"+(end-start));
		
		
	}
}
