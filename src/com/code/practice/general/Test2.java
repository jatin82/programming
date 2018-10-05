package com.code.practice.general;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

	
  class Test2 {
  	
  		private InputStream is;
  		
  		private  PrintWriter out;
  		
  		void solve() throws IOException
  			{
  			
  			int N=ni();
      		
      		int X=ni();
      		
      		long value[]=new long[N+1];
      		
      		long height[]=new long[N+1];
      		
      		for(int i=1;i<=N;i++)
      			value[i]=ni();
      		
      		ArrayList<Integer> tree[]=new ArrayList[N+1];
      		
      		for(int i=1;i<=N;i++)
      			tree[i]=new ArrayList<>();
      		
      		for(int i=1;i<=N-1;i++)
      		{
      			int u=ni();
      			int v=ni();
      			tree[u].add(v);
      			tree[v].add(u);
      		}
      		
      		long ans=bfs(tree,height,N)*X;
      		
      		for(int i=1;i<=N;i++)
      			ans+=(height[i]*value[i]);
      			
      		out.println(ans);

	    	}
  		
			private long bfs(ArrayList<Integer>[] tree,long height[],int N) {
				
				long index=-1;
				
				boolean vis[]=new boolean[N+1];
				
				vis[1]=true;
				
				ArrayList<Integer> q=new ArrayList<>();
				
				q.add(1);
				
				height[1]=1;
				
				long hi=1;
				
				long ehi=1;
				
				while(true)
				{
					ArrayList<Integer> temp=new ArrayList<>();
					
					while(!q.isEmpty())
					{
						int u=q.remove(0);
						
						for(int i=0;i<tree[u].size();i++)
						{
							int v=tree[u].get(i);
							
							if(!vis[v])
							{	
								vis[v]=true;
								height[v]=height[u]+1;
								temp.add(v);
							}
						}
						
					}
					
					
					ehi*=2;
					
					hi++;
					
					if(index==-1&&temp.size()<ehi)
					{
						index=hi;
					}
					
					if(temp.isEmpty())
					{   
						break;
					}
					
					q=temp;
				}
				
				return index;
				
			}

  		
  		
  		 void run() throws Exception {
  		    	is = System.in;
  		    	out = new PrintWriter(System.out);
  		    	solve();
  		    	out.flush();
      	
  		    }	
               
            

				public static void main(String[] args) throws Exception {
              		new Thread(null, new Runnable() {
              			public void run() {
              				try {
              					new Test2().run();
              				} catch (Exception e) {
              					e.printStackTrace();
              				}
              			}
              		}, "1", 1 << 26).start();
  	}
   
  	// To Get Input
  	// Some Buffer Methods
  	private byte[] inbuf = new byte[1024];
  	public int lenbuf = 0, ptrbuf = 0;
  	
  	private int readByte() {
  		if (lenbuf == -1)
  			throw new InputMismatchException();
  		if (ptrbuf >= lenbuf) {
  			ptrbuf = 0;
  			try {
  				lenbuf = is.read(inbuf);
  			} catch (IOException e) {
  				throw new InputMismatchException();
  			}
  			if (lenbuf <= 0)
  				return -1;
  		}
  		return inbuf[ptrbuf++];
  	}
   
  	private boolean isSpaceChar(int c) {
  		return !(c >= 33 && c <= 126);
  	}
   
  	private int skip() {
  		int b;
  		while ((b = readByte()) != -1 && isSpaceChar(b))
  			;
  		return b;
  	}
   
  	private double nd() {
  		return Double.parseDouble(ns());
  	}
   
  	private char nc() {
  		return (char) skip();
  	}
   
  	private String ns() {
  		int b = skip();
  		StringBuilder sb = new StringBuilder();
  		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != '
  									// ')
  			sb.appendCodePoint(b);
  			b = readByte();
  		}
  		return sb.toString();
  	}
   
  	private char[] ns(int n) {
  		char[] buf = new char[n];
  		int b = skip(), p = 0;
  		while (p < n && !(isSpaceChar(b))) {
  			buf[p++] = (char) b;
  			b = readByte();
  		}
  		return n == p ? buf : Arrays.copyOf(buf, p);
  	}
   
   
   
  	private int[] na(int n) {
  		int[] a = new int[n];
  		
  		for (int i = 0; i < n; i++)
  			{
  			  a[i] = ni();
  			  
  			  
  			}
  		
  		
  		return a;
  	}
   
  	private void pa(int[] a) {
  		int i=0;
  		
  	   while(i<a.length)
  	   {
  		   System.out.print(a[i++]+" ");
  	   }
  		
  		
  		
  		
  	}
  	
  	
  	private int ni() {
  		int num = 0, b;
  		boolean minus = false;
  		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
  			;
  		if (b == '-') {
  			minus = true;
  			b = readByte();
  		}
   
  		while (true) {
  			if (b >= '0' && b <= '9') {
  				num = num * 10 + (b - '0');
  			} else {
  				return minus ? -num : num;
  			}
  			b = readByte();
  		}
  	}
   
  	private long nl() {
  		long num = 0;
  		int b;
  		boolean minus = false;
  		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
  			;
  		if (b == '-') {
  			minus = true;
  			b = readByte();
  		}
   
  		while (true) {
  			if (b >= '0' && b <= '9') {
  				num = num * 10 + (b - '0');
      			} else {
      				return minus ? -num : num;
      			}
      			b = readByte();
      		}
      	}
      	
 	 
	}
