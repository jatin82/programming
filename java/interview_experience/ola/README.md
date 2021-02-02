## Round 1 - Problem Solving

1. SortOnes to left of array -> [3,1,4,8,1] =>[3,4,8,1,1]
2. Convex Hull
3. Jump game DP


## Round 2 - Problem Solving


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

## Round 3 - Design

1. Asked about the project
2. Design a Credit Card System which collects data from Vendors and process limits
3. Follow ups :
      3.1 Multiple Classes can be there for Data
      3.2 Data Processing vs Thread Processing
      3.3 Correct Class Design names
      3.4 HLD - which Database and Why?
      3.5 Cassandra key size limit ?
      3.6 S3 for storage of large files
      3.7 Database Design for Scalability - Partition strategy.
      3.8 How to handle large history of Data.
      3.9 How to handle load of data.
4. General Discussion about OLA vision.

## Round 4 - HM

1. Asked about my choice to Join OLA.
2. Why leaving current organization.
3. General Disussion about Work/culture at OLA.

## Round 5 - HR

1. Introduction about me - Family, Education, Hobbies, Which project domain worked till Now.
2. reason for leaving previous organizations,
3. what are your expectation from OLA?
4. Salary Expectation.

Result - Selected, but didn't got call due to High Salary Expecations ( 34 LPA)

