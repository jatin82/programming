//https://www.hackerearth.com/problem/algorithm/lucky-inversions-861e1a4b/description/

class Question
{
    public primes:boolean[] = [];
    public maxSize = 30;// 1000001;

    constructor(private input:string){   
        this.solve();
    }
    public solve():void{
        let sc = new Scanner(this.input);
        let n = sc.nextInt();
        this.sieveAlgo(); 
        let a:number[] = sc.nextIntArray(" ");
        let ans:number[] = [];
        for(let i=0;i<n;i++){
            if(this.primes[a[i]]){
                ans.push(a[i]);
            }
        }
        ans.sort((a:number,b:number)=>{
            if(a>b) return 1;
            else return -1;
        });
        a.sort((a:number,b:number)=>{
            if(a>b) return -1;
            else return 1;
        });
        for(let i=0;i<n;i++){
            if(!this.primes[a[i]])
            {
                ans.push(a[i]);
            }
        }
        ans.toString = function(){
            return this.join(' ');
        }
        console.log(ans.toString());

        // console.log(this.primes);
        // for(let x in this.primes){
        //     if(this.primes[x])
        //     {
        //         console.log('x:'+x);
        //         // console.log(x);
        //     }
        // }

    }
    public sieveAlgo():void{
        
        // console.log("calculating primes");
        for(let i=0;i<this.maxSize;i++){
            
            this.primes.push(true);
        }
        // console.log('this.primes:'+this.primes);
        this.primes[0] = false;
        this.primes[1] = false;
        for(let i=2;i*i<this.maxSize;i++){
            // console.log(this.primes[i]);
            if(this.primes[i]){
                for(let j=i*i;j<this.maxSize;j = j + i){
                    this.primes[j] = false;
                    // console.log('heres');
                }
            }
        }
    }
}

function main(input:string):void{
    new Question(input);
}
// console.log('start app'); // uncomment for node js
//             main("5\n1 4 3 2 6");