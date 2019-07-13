/*

1
4
1 2 3 4 5
2 4 5 6 7
1 2 3 4 5
1 4 2 2 3

main("1\n4\n1 2 3 4 5\n2 4 5 6 7\n1 2 3 4 5\n1 4 2 2 3\n");




*/

class Question{

    constructor(private input:string){
        this.solve();
    }

    public solve():void{
        let sc = new Scanner(this.input);
        let testCase = sc.nextInt();
        while(testCase-->0){
            let n = sc.nextInt();
            let a = [];
            
            for(let x = 0;x<n;x++){
                let[t1,t2,t3,t4,t5] = sc.nextIntArray(' ');
                a.push({
                    t1:t1,
                    t2:t2,
                    t3:t3,
                    t4:t4,
                    t5:t5,
                    index:x+1
                });
            }

            let teamWon = a.reduce((team1,team2)=>{
                let score1 = 0;
                let score2 = 0;
                team1.t1>team2.t1 ? score1++:score2++;
                team1.t2>team2.t2 ? score1++:score2++;
                team1.t3>team2.t3 ? score1++:score2++;
                team1.t4>team2.t4 ? score1++:score2++;
                team1.t5>team2.t5 ? score1++:score2++;

                if(score1 === score2){
                    return team1.index>team2.index ? team2:team1;
                }
                return score1>score2 ? team1:team2;
            });
            console.log(teamWon.index);

        }

    }


}