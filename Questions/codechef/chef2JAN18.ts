// https://www.codechef.com/JAN18/problems/MAXSC

class Question{
    constructor(private input:string){
        this.solve(this.input);
    }
    private solve(input:string):void{
        let sc = new Scanner(input);
        let testCase:number = sc.nextInt();
        while(testCase-->0){
            let n:number = sc.nextInt();

            let a:number[][] = [];
            for(let i=0;i<n;i++){
                a[i] = sc.nextIntArray(' ');
            }
            
            let sum:number = 0;
            let prev:number = -1;
            let flag:boolean = true;
            for(let i=n-1;i>=0&&flag;i--){
                
                let max:number = -1;

                for(let j=0;j<n;j++){
                    if(prev===-1&&max<a[i][j]||max<a[i][j]&&prev>a[i][j]) max = a[i][j];
                }
                // console.log("max:"+max);
                if(max===-1) flag = false;
                else prev = max;
                // console.log("prev:"+prev);
                sum = sum + prev;
            }
            if(flag)
                console.log(sum);
            else
                console.log(-1);
        }
    }

}