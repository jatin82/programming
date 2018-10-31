class Question
{
    constructor(private input:string){
        this.solve();
    }
    public solve():void{
        let sc = new Scanner(this.input);
        let testCase = sc.nextInt();
        while(testCase-->0){
            let [k , n] = sc.nextIntArray(' ');
            let a = sc.nextIntArray(' ');
            let count = 0;
            for(let i=0;i<n;i++){
                if(a[i]<k){
                    count = count + k-a[i];
                }
                else{
                    count = count + Math.min(a[i]%k,k - a[i]%k);
                }
            }
            console.log(count);
        }
        
    }
}