/*
https://www.hackerearth.com/challenge/competitive/code-monk-dynamic-programming/algorithm/samu-and-shopping/


-----> DP competition <------
https://www.hackerearth.com/challenge/competitive/code-monk-dynamic-programming/problems/

*/

class Question{
    constructor(private input:string){
        this.solve();
    }

    private solve(){
        let sc:Scanner = new Scanner(this.input);
        let testCase:number = sc.nextInt();
        
        while(testCase-->0){
            let n:number = sc.nextInt();
            let dp:number[][] = [];
            for(let i=0;i<n;i++){
                let temp:number[] = [];
                for(let j=0;j<3;j++){
                    temp.push(0);    
                }
                dp.push(temp);
            }
            let items:number[] = sc.nextIntArray(' ');
            
            dp[0][0] = items[0];
            dp[0][1] = items[1];
            dp[0][2] = items[2];

            for(let i=1;i<n;i++){
                let items:number[] = sc.nextIntArray(' ');
                for(let j=0;j<items.length;j++){
                    let c1:number=0,c2:number=0;
                    if(j==0){
                        c1 = items[j] + dp[i-1][1];
                        c2 = items[j] + dp[i-1][2];
                    }
                    else if(j==1){
                        c1 = items[j] + dp[i-1][0];
                        c2 = items[j] + dp[i-1][2];
                    }
                    else if(j==2){
                        c1 = items[j] + dp[i-1][1];
                        c2 = items[j] + dp[i-1][0];
                    }
                    dp[i][j] = Math.min(c1,c2);        
                }
            }

            let ans = Math.min(dp[n-1][0],dp[n-1][1],dp[n-1][2]);
            console.log(ans);
        }
    }
}