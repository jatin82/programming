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


function main(input) {
    let sc = new Scanner(input);
    let testCase = sc.nextInt();
    while(testCase-->0){
        let n = sc.nextInt();
        let u = sc.nextIntArray(' ');
        let a = sc.nextIntArray(' ');
        
        let ans = a[0];
        let prev = a[0];
        for(let i=1;i<n;i++){
            if(u[i-1] === u[i] && prev < a[i]){
                ans = ans + a[i] - prev;
                prev = a[i];
            }
            else if(u[i-1] !== u[i]){
                ans = ans + a[i];
                prev = a[i];
            }
        }
        process.stdout.write(ans + "\n");
        
    }
    
    
    
    
}

main("1\n8\n1 1 1 1 2 2 2 3 3\n1 2 1 4 4 1 1 2 2");

// main("1\n10\n15 15 12 13 13 13 1 1 1 1\n20 30 15 16 12 1 23 24 1 2");
