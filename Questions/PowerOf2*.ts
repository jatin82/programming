class Question{
    constructor(private input:string){
        this.solve(this.input);
    }
    public checkPowerOf2(x:number):boolean{
        if(x===0)
            return false;
        x = (x & (x-1));
        return x===0;
    }
    public printBits(x:number):void{
        if(x===0)
        {
            console.log(0);
            return;
        }
        else
        {
            for(let i=0;(1<<i)<=x;i++){
                if(this.isBitSet(x,i))
                    process.stdout.write("1");
                else
                    process.stdout.write("0");
            }
            console.log();
        }
    }
    public isBitSet(x:number,index:number):boolean{
        return (x & (1<<index))!==0;
    }
    public solve(input:string):void{
        let sc = new Scanner(input);
        let testCase = sc.nextInt();

        while(testCase-->0){
            let n = sc.nextInt();
            let arr = sc.nextIntArray(' ');
            let total:number = 0;
            let flag:boolean = false;
            if(n===1){
                if(this.checkPowerOf2(arr[0]))
                    flag = true;
            }
            else{
                for(let i=0;i<31;i++){
                    // console.log(total);
                    total = total+(1<<i);
                }
                let ans = total;
                //this.printBits(total);
                for(let i=0;i<32;i++)
                {
                    ans = total;
                    for(let j of arr){
                        if(this.isBitSet(j,i)) ans = ans & j;
                    }
                    if(this.checkPowerOf2(ans)){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag)
                console.log("YES");
            else
                console.log("NO");
        }
    }
}