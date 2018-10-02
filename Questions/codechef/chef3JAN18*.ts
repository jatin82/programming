// https://www.codechef.com/JAN18/problems/KCON
// kedane's algorithm

class Question{
    constructor(private input:string){
        this.solve();
    }
    private solve():void{
        let sc = new Scanner(this.input);
        let testCase = sc.nextInt();
        while(testCase-->0){
            let [n,k] = sc.nextIntArray(' ');
            let a:number[] = sc.nextIntArray(' ');
            let max_so_far:number = Number.MIN_VALUE;
            let max_ends:number = 0;
            for(let i=0;i<2*n;i++){
                let index = i%n;
                max_ends = max_ends + a[index];
                if(max_ends>max_so_far)
                    max_so_far = max_ends;
                if(max_ends<0)
                    max_ends = 0;
            }
            console.log("so_far:"+max_so_far);
            let sum:number = 0;
            for(let i of a) sum = sum + i;

            if(sum>0){
                max_so_far = max_so_far + max_so_far*(k-2);
                console.log(max_so_far);
            }
            else{
                console.log(max_so_far);
            }
        }
    }
}