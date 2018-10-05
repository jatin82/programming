/*
https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/pepper-and-palindromic-love-76ae8763/

note: question statement is wrong
*/

class Question{
    constructor(private input:string){
        this.input = input;
        this.solve();
    }
    private solve():void{
        let sc = new Scanner(this.input);
        let testCase:number = sc.nextInt();
        while(testCase-->0){
            let n:number = sc.nextInt();
            let occurance:number[] = [];
            for(let i=0;i<10;i++){
                occurance.push(0);
            }
            let y:string = n.toString();
            for(let i=0;i<y.length;i++){
                occurance[parseInt(y.charAt(i))]++;
            }

            let count:number = 0;
            for(let i:number=1;i<10;i++){
                if(occurance[count]<occurance[i]){
                    count = i;
                }
            
            }
            console.log(count);
        }
    }
}