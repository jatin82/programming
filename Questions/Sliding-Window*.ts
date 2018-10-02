//https://www.hackerearth.com/problem/algorithm/swaps-e4a6b638/

class Question{
    constructor(private input:string){
        this.solve(this.input);
    }

    public solve(input:string):void{
        
        let sc =  new Scanner(input);
        let [n,k] = sc.nextIntArray(' ');
        let arr = sc.nextIntArray(' ');
        
        let count = 0;

        for(let i of arr) if(i>=k) count++;

        // console.log("count:"+count);
        let swap = 0;
        let max = 0;

        for(let i=0;i<count;i++) if(arr[i]<k) max++;

        swap = max;
        for(let i=count;i<n;i++){
            let first:number = arr[i-count];
            let last:number = arr[i];

            let carry = 0;
            if(first<k){
                 carry = -1;
            }
            if(last<k)
            { 
                carry = carry + 1;
            }
            max = max + carry;

            if(max<swap) swap = max;
        }
        console.log(swap);
    }
}