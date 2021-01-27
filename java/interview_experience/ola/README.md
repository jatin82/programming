## Round 1

1. SortOnes to left of array -> [3,1,4,8,1] =>[3,4,8,1,1]
2. Convex Hull
3. Jump game DP


## Round 2


Design a Module Service
Functionality
1. Throttles API
2. Request and Response filtering



APIService -> Redis -> DB


1. Throtling -> API_KEY,URL,Request_acceptance, TTL
2. Property -> API_key,URL
3. PropertyLoader interface in DB and cache it To redis
4. Filter in -> URLs
      4.1 will first check in Redis
      4.2 Yes then simply generate some Default Response
      4.3 add the Request count in our redis and update DB
5. RequestFormater and ResponseFormater Abstract -> predefined methods,
    abstract - format
6. PostRequest, PreRequest
7. IntegrationFilter -> backed Hystrix 
    7.1 RequestTimeout behaviour it will add iy to Redis and update DB.


<pre>
class SINGLETON{

    private static SINGLETON INSTANCE;

    private SINGLETON(){}

    public SINGLETON getInstacnce(){
        if(INSTANCE == null) {
        synchronized(SINGLETON.class){
            if(INSTANCE == null)
                INSTANCE = new SINGLETON();
            }
        }
        return INSTANCE;
    }

}
</pre>

## Round 3
... will be schedule

