
// before compiling make changes in tsconfig file to remove scanner class error
class Question{
    constructor(private input:string){
        this.solve();
    }
    public solve():void{
        let sc = new Scanner(this.input);
        let testCase = sc.nextInt();
        while(testCase-->0){
            let a = sc.next(),b = sc.next();
            let check = new Set();
            
            for(let i=0;a.length;i++){
                check.add(a[i]);
            }
            let flag = -1;
            for(let i=0;i<b.length;i++){
                if(check.has(b[i])){
                    flag = 1;
                }
            }
            if(flag===1)
                console.log("Yes");
            else
                console.log("No");
        }

    }
}
function main(input:string):void{
    new Question(input);
}