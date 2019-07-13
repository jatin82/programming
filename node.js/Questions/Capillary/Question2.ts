/*
3
1 2 3
3
1
2
3

main("3\n3 2 1\n3\n1\n2\n3\n");

4
4 3 2 1
4
1
2
3
4

main("4\n4 3 2 1\n4\n1\n2\n3\n4\n");

*/

class Question{
    private max:number;
    private mod:number;
    constructor(private input:string){
        this.max = 5 *Math.pow(10,5) +  1;
        this.mod = Math.pow(10,9) + 7;
        this.solve();
    }


    private preProcess(a:number[]):number[]{
        let ans:number[] = [];
        let sum = a.reduce((accumulator,x)=>accumulator+x,0);
        let delta = 0;
        let pre:number[] = [];
        for(let i = 0;i<=this.max;i++){
            pre.push(0);
        }

        for(let x = 0;x<a.length-1;x++){
            sum = sum - a[x];
            delta = delta + Math.abs((sum * 2)%this.mod - (a[x] * (a.length-x-1) * 2)% this.mod)%this.mod;
        }

        pre[1] = delta;
        for(let x = 2;x<=this.max;x++){
            pre[x] = (pre[x-1] + (delta*x)%this.mod)%this.mod;
        }
        return pre;
    }

    public solve():void{
        let sc = new Scanner(this.input);
        let n = sc.nextInt();
        let a = sc.nextIntArray(' ');
        let pre = this.preProcess(a);
        let queries = sc.nextInt();
        while(queries-->0){
            let query = sc.nextInt();
            console.log(pre[query]);
        }
    }
}