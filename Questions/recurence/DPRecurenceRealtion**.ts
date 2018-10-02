/*

https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/vibhu-and-his-mathematics/


*/


class Question{
    private maxN:number;
    
    private modulo:number = Math.pow(10,9) + 7;

    constructor(private input:string){
        this.maxN = Math.pow(10,6);
        
        this.solve();
    }

    private preCompute():number[]{
        let ans:number[] = [];
        ans.push(1);
        ans.push(2);
        for(let i=3;i<this.maxN;i++){
            let index:number = i-1;
            ans.push( (ans[index-1] + ( (i-1)*ans[index-2]  ) % this.modulo) % this.modulo );
        }
        return ans;
    }


    private solve():void{
        let ans:number[] = this.preCompute();
        let sc:Scanner = new Scanner(this.input);
        let testCase:number = sc.nextInt();
        while(testCase-->0){
            let n:number = sc.nextInt()-1;
            console.log(ans[n]);
        }
    }
}