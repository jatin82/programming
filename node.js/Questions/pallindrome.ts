// https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/one-swap-to-palindrome-d96d4e21/description/

class Question{

    constructor(private input:string){
        this.solve();
    }

    public solve():void{
        let sc:Scanner = new Scanner(this.input);
        let testCase:number = sc.nextInt();
        let yes:string = "Yes";
        let no:string = "No";
        
        while(testCase-->0){
            let s:string = sc.next();
            let l:number = 0;
            let r:number = s.length-1;
            let n:number = s.length;
            let cnt = 0;
            let a:string = "";
            let b:string = "";
            let c:string = "";
            let d:string = "";
            
            while(l<r){
                let lc:string = s.charAt(l);
                let rc:string = s.charAt(r);


                if(lc !== rc){
                    cnt = cnt +1;
                    if(cnt===1){
                        a = lc;
                        b = rc;
                    }
                    else if(cnt===2){
                        c = lc;
                        d = rc;
                    }
                    else
                    {
                        break;
                    }
                }
                r = r-1;
                l = l+1;
            }
            if(cnt>2) {
                console.log(no);
            }
            else if(cnt===2){
                if((a === c && b === d) || (a === d && b === c)){
                    console.log(yes);    
                } 
                else{
                    console.log(no);
                }
            }
            else if(cnt===1){
                if(n%2===0){
                    console.log(no);
                }
                else if(s.charAt(n/2) === a || s.charAt(n/2) === b ){
                    console.log(yes);
                }
                else{
                    console.log(no);
                }
            }
        }

    }

}