## Round -1
//You are given an array showing number of coins in coin bags. If you pick a packet with n coins then any packet with //n-1 or n+1 coins disappear. How many maximum coins can you pick?


1 5 6 =>7


8 5 6 3 5 8

8 6 3 => 17

8 5 6 3 5 8

ex: 8 5 6 3 5 8  7 7 7 7 7

8 8 7 7 7 7 7 6 5 5 3

5 6 7 5

5=10
6=6
7=7

<pre>
Map<Integer,Integer> map
        Key, sum

  global maxSum = 0;
  sumSoFar = 0;
 
 
 rec(int key,Map<Integer,Integer> map){
     
     if(!map.containsKey(key)) return 0;
     
     //key = 6
     // left = 10
     //
     
     
     
     // key - 1
     // Currentkey = 5
     // sumSoFar = 0
     // left = 6
     // x(5) = 10
     // root = 10
     // maxSum = 10
     // 10
     
     // key + 1
     // Currentkey = 7
     // sumSoFar = 0
     // left = 6
     // x(7) = 7
     // root = 7
     // maxSum = 10
     // return 7
     
     do for all keys: 
         
         
         x = map.get(key)
         
         x1 = map.get(key+1);
         x2 = map.get(key-1);
         map.remove(key+1);
         map.remove(key-1);
         
         int left = sumSoFar + Math.max(rec(key+1,map) , rec(key-1,map));
         
         int root = sumSoFar+x;
         map.put(key+1,x1);
         map.put(key-1,x2);
         
         
         sumSoFar = Math.max(root,left);
         
         if(sumSoFar>maxSum)
         maxSum = sumSoFar;
         
    return sumSoFar;
 }
 </pre>
 
 1. Map - interger - count;
 2. sort the Array
 
 3. dp[n]
 
 <pre>
 maxSum = 0;
 for unique x element of array
     dp [x] = map.get(x) + dp[x-2];
     maxSum = Math.max(maxSum,dp[x]);
  
 
 
 public int maxSum(int [] arr){
 
    Map<Integer,Integer> 
 
 
 }
 </pre>
 
//Given two numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find //subtraction of these two numbers.

 s1 = "3212"
 s2 = " 999" 
  
  s3 = 3121
  
  
 carry = 1
 
 <pre>
  public String minus(String s1,String s2){
     
      int n1 = s1.length();
      int n2 = s2.length();
      if(n1==0 && n2==0) return "";
      if(n2==0) return s1;
      
      if(n2>n1){
          return "-"+minus(s2,s1);
      }
      
      StringBuilder s3 = new StringBuilder();
      
      
      int i=n1-1;
      int j = n2-1;
      int carry = 0;
      
      // O(max(n1,n2))
      
      while(i>=0 && j>=0){
          
          int a = (int)(s1.charAt(i--) - '0');
          int b = (int)(s2.charAt(j--) - '0');
          
          a -= carry;
          
          if(a<b){
              a = a*10;
              carry = 1;
          }
          
          int diff = a-b;
          s3.append(diff+"");
      }      
  
      while(i>=0){
          int a = (int)(s1.charAt(i--) - '0');
          a-= carry;
          s3.append(a+"");
      }
      return s3.reverse().toString();
  }

</pre>





## ROUND - 2

API_key - hotstar



Map<Stirng,RequestObject> map

RequestObject{
    int count;
    long LastTimestamp;
    long startTimestamp;
}

<pre>
public boolean isApiThrottl(String apiKey,Map<String,RequestObject> map){


   if(!map.containsKey(apiKey)){
       map.put(apiKey,new RequestObject(1,Calender.getInstance().getTime());
       return false;
   } else {
       
       RequestObject obj = map.get(apiKey);
       long time = Calender.getInstance().getTime() - obj.getStartTimeStamp();
       
       if(time <= 1000L && obj.getCount()>=5){
           return true;
       } else if(time>=1000L) {
           obj.setStartTimeStamp(Calender.getInstance().getTime());
           obj.setCount(1);
       }
       else {
           obj.setCount(obj.getCount()+1);
       }
       
       return false;
   }

}
</pre>

Testing
100ms - c = 1, st =100,lt =100
200ms - c = 2, st =100, lt=200
400ms - c = 3, st = 100, lt = 400
600ms - c = 4, st = 100 , lt =600
900ms - c = 5, st = 100, lt = 900
930ms - 
4500ms - 



## ROUND - 3 VP


Problem statement:

Subscribe users to Buy Hotstar,Netflix,Zee services for Duration using Digital Payments. (UPI,Online Payment Option)

Solution :



1. Front End side Using Android Application.
2. All of our request will be in encrypted state ( security breach)
3. Microsservices :
  3.1 - Font end Service - 
        1. Validate and decrypt request and encrypt response
        2. Validate User token.
        3. Show all the available Offers and there price.
        4. Cart checkout.
        5. Consent on using some OTP ( optional )
        6. Process ammount deduction for UPI method.
        
  3.2 Order and Payment Processing.
      1. Initiate the transaction for Particular Cart Checkout.
      2. Process the Payment using some UPI service ( Async call will be recieved from UPI service)
      3. After Successfull Transaction initiate the subscription with Vendors.
      4. If Transaction failed Initiate Refund.
      5. IF success mark the payment Success and subscribce the user for Service.
  
  3.3 Reporting Service
      1. Generate Reports on the transaction subscribed Service.
      2. Provide detailed report about Customer Interests.
      



First MS - FrontEnd Service.

<pre>
1. interface OfferService{
    List<Offer> getAllOffer(CustomerDetails);
}


2. interface CartService{
    
    OrderDetails cartCheckout(OrderRequest request);
    
    Transaction processPayment(OrderDetails,UpiHandler);
}

Second MS - Order And Payment

interface PaymentService{

  Transaction initiatePayment(OrderDetails,UpiHandler)

  void asycProcessPayment(UpiCallback, Transaction);
  
  Transaction refund(UpiHandler,Transaction);
  
  PaymentResponse paymentSuccess(Transaction); 
}

interface SubscriptionService{

  SubscriptionResponse subcribe(Offer,)
}
</pre>
