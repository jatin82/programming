// https://www.codechef.com/JAN18/problems/RECTANGL

class Question{

    constructor(private input:string){
        this.solve(this.input);
    }
    public solve(input:string):void{

        let sc = new Scanner(input);
        let testCase = sc.nextInt();

        while(testCase-->0){

            let a:number[] = sc.nextIntArray(' ');
            let equal:number = 0;

            for(let i=0;i<a.length-1;i++){
                for(let j=i+1;j<a.length;j++){
                    if(a[i]===a[j])
                        equal++;
                }
            }
            if(equal!==0&&equal%2==0)
                console.log("YES");
            else
                console.log("NO");
        }
    }

}
