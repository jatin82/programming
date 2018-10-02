/*
    Hamilton Path = DP + Bit Masking + Graph
    https://www.hackerearth.com/practice/algorithms/graphs/hamiltonian-path/practice-problems/algorithm/fredos-crush-2/description/

*/


class Question
{
    constructor(private input:string){
        this.solve();
    }

    public findHamiltonPath(graph:Array<Set<number>>):Array<Array<number>>{
        
        let dp:Array<Array<number>> = new Array<Array<number>>();
        let n:number = graph.length;
        for(let i = 0; i < (1<<n) ; i++ ){
            for(let j=0;j<n;j++){
                dp[i].push(0);
            }    
        }
        for(let i=0;i < n;i++){
            dp[i][1<<i] = 1;
        }

        for(let i = 0; i < (1<<n) ; i++ ){
            for(let j=0;j<n;j++){
                if( ( i & (1<<j)) === 1 ) {
                    for(let k=0;k<n;k++){
                        // if(j!==k && (i & (1<<k) && graph[j].))
                    }
                }       
                


            }    
        }


        return dp;    

    }
    public printGraph(graph:Array<Set<number>>):void{
        for(let i=0;i<graph.length;i++){
            for(let j:number of graph[i].){

            }
            // let temp:Iterator<number>  = graph[i].keys();
            console.log(graph[i]);
        }
    }

    public solve():void{
        let sc = new Scanner("1\n3 2\n1 2\n2 3");
        let testCase = sc.nextInt();
        while(testCase-->0){
            let [n,m]:number[] = sc.nextIntArray(' ');
            let graph = new Array<Set<number>>();
            for(let i = 0; i < n;i++){
                graph.push(new Set<number>());
            }
            for(let i=0;i<m;i++){
                let [e,v]:number[] = sc.nextIntArray(' ');
                graph[e-1].add(v-1);
                graph[v-1].add(e-1);
            }
            this.printGraph(graph);
            // this.findHamiltonPath(graph);

        }
        
    }
}