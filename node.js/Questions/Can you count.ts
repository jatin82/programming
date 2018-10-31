//https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/can-you-count-11795975/

class Question{
    constructor(private input:string){
        this.solve();
    }
    public solve():void{
        let sc = new Scanner(this.input);
        let testCase = sc.nextInt();
        while(testCase-->0){
            let str = sc.next();
            let vowels:Set<string> = new Set([
                "a","e","i","o","u"
            ]);
            let ans = 1;
            let vowelsCount:number = 0;
            for(let i = 0;i<str.length;i++){
                let cur:string = str[i];
                if(vowels.has(cur)){
                    vowels.delete(cur);
                    vowelsCount++;
                }
                else if(str[i].localeCompare("_")){
                    ans = ans * vowelsCount;
                }
            }
            console.log(ans);
        }
    }
}

function main(input:string):void{
    new Question(input);
}