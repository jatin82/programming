process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";

process.stdin.on("data", function (input) {
    stdin_input += input;                               
});

process.stdin.on("end", function () {
   main(stdin_input);
});

Array.prototype.peek = function(){
    return this[this.length-1];    
};
Array.prototype.getLast = function(){
    return parseInt(this[this.length-1]);
};
Array.prototype.setLast = function(x){
    this[this.length-1] = x;
};
Array.prototype.toString = function(){
    return this.join(' ');
};
Number.prototype.compareTo = function(x){
    if(x === this) return 0;
    else if(x>this) return -1;
    else return 1;
};

var Scanner = (function () {
    function Scanner(input) {
        this.token = 0;
        this.input = input.split("\n");
    }
    Scanner.prototype.next = function () {
        return this.input[this.token++];
    };
    Scanner.prototype.nextInt = function () {
        return parseInt(this.input[this.token++]);
    };
    Scanner.prototype.nextIntArray = function (delimiter) {
        var ans = this.input[this.token++].split(delimiter);
        var ansInt = [];
        for (var i = 0; i < ans.length; i++) {
            ansInt.push(+ans[i]);
        }
        return ansInt;
    };
    return Scanner;
}());

/*function Scanner(input){
    this.input = input.split('\n');
    this.nextToken = 0;
    this.nextLine = function(){
        return this.input[this.nextToken++];
    };
    this.nextIntArray = function(delimter){
        var ans = this.input[this.nextToken++].split(delimter);
        ans.forEach(function(entry){
            entry = parseInt(entry);
        },this);
        return ans;
    }
}
*/

function main(input) {
    
    let sc = new Scanner(input);
    let testCase = sc.nextInt();
    while(testCase-->0){
        let n = sc.nextInt();
        let a = sc.nextIntArray(' ');
        count = {};
        for(let i of a){
            let temp = 0;
            if(i in count){
                temp = count[i];
            }
            count[i] = temp + 1;
        }
        let min = -1;
        for(let i in count){
            let temp = i * count[i];
            if(min===-1 || temp < min){
                min = temp;
            }
        }
        let ans = 0;
        for(let i of a){
            ans = ans + i;
        }
        ans = ans - min;
        process.stdout.write(ans+"\n");
    }
    
}

main("2\n3\n1 1 3\n3\n1 2 3");
