import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/**
Panel 2:
Q1: Find the number of pythogoran triplets found for given array a[].

x2 + y2 = z2

x2 && y2 < z2




ar[]

i,j,k

O(n3)




Map<Integer,integer> map

 a[i]*a[i] , i>

for(j-N){
  
  for(k=j+1 -- N){
    squares = a[j]*a[j] + a[i]*a[i]
    
    find that in out map
    
  }
  
}

O(N2)
O(N)




Q2: Given string, find the longest palidrome substring

Ex: bananas - anana



i,j

maxLong = 1;

for(i-N){

  for(j=i+1 -> N){
    
    isPalindrome(i,j,str)
    maxLong = Math.max(j-i+1,maxLong);
    
  }
}


O(n3)



X(str,i,j) = {
      if i==jth char --> 2+ X(str,i+1,j-1) 
      else {
        Math.max(X(str,i+1,j),X(str,i,j-1))
}
      

maxLong = 1;

dp[0][N] - boolean value



for() length==1 -- diagonal boolean value true;


abab

ab  len=3

aba

bab

1,1,0
0,1,1
0,0,1





for(int len = 2; len--N){
  
  for(int j = 0; j<n-len+1; j++){
  
      int endIndex = j+len-1;
      if(len==2){
      
       dp[j][endIndex] = str.charAt(j)==str.charAt(endIndex);
      
      }
      else{
      
        if(str.charAt(j)==str.charAt(endIndex)){
          dp[j][endIndex] = dp[j+1][endIndex-1];
        }
        else{
          dp[j][endIndex] = dp[j+1][endIndex] || dp[j][endIndex-1]
        }

      
      
      }
      
      if(dp[j][endIndex]){

        maxLong = Math.max(endIndex - j + 1,maxLong);

      }
      
       
  }

} 
Q3: find a odd ball from provided 8 balls by comparing.

}


class  Node{

  String str1
  String st2;
  

  @overrdide
  public boolean equals(Object o){
  
    Node temp = (Node) o;
    
    return str1.equals(o.str1) && str2.equals(o.str1);
    
  }
  
  @Override
  public int hashCode(){
    return str1.hashCode() + str2.hashCode();
  }
  

}


class TimstampValue{
  
  long timestamp;
  int value;

}


func("str1","str2")


ConcurrentHashMap<Node,Integer>()


int r = Math.random(0,n);






key -> Node(str1,str2) // first time 

value -> TimestampValue(new Date().getTime(),value);


if(it is greater than 1 minute)
{
  delete that key
}
else{

  
  return 

}

Node-->ll


ll(){
  ll next;
  ll prev;
  int value;

}















**/
class Solution {
  
  
  
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
  }
}

