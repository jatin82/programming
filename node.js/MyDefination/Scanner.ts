class Scanner{
    private token:number;
    private input:string[];
    constructor(input:string){
        this.token = 0;
        this.input = input.split("\n");
    }
    public next():string{
        return this.input[this.token++];
    }
    public nextInt():number{
        return parseInt(this.input[this.token++]);
    }
    public nextIntArray(delimiter:string):number[] {
        let ans:string[] = this.input[this.token++].split(delimiter);
        let ansInt:number[] = [];
        for(let i:number = 0;i < ans.length;i++){
            ansInt.push(+ans[i]);
        }
        return ansInt;
    }
}

function main(input:string):void{
    new Question(input);
}
