"use strict";
process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";
process.stdin.on("data", function (input) {
    stdin_input += input;
});
process.stdin.on("end", function () {
    main(stdin_input);
});
Array.prototype.peek = function () {
    return this[this.length - 1];
};
Array.prototype.getLast = function () {
    return parseInt(this[this.length - 1]);
};
Array.prototype.setLast = function (x) {
    this[this.length - 1] = x;
};
Array.prototype.toString = function () {
    return this.join(' ');
};
Array.prototype.fromLast = function (x) {
    return this[this.length - 1 - x];
};
Number.prototype.compareTo = function (x) {
    if (x === this)
        return 0;
    else if (x > this)
        return -1;
    else
        return 1;
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
    new Question(input);
}
var Question = (function () {
    function Question(input) {
        this.input = input;
        this.input = input;
        this.solve();
    }
    Question.prototype.solve = function () {
        var sc = new Scanner(this.input);
        var testCase = sc.nextInt();
        while (testCase-- > 0) {
            var n = sc.nextInt();
            var occurance = [];
            for (var i = 0; i < 10; i++) {
                occurance.push(0);
            }
            var y = n.toString();
            for (var i = 0; i < y.length; i++) {
                occurance[parseInt(y.charAt(i))]++;
            }
            var count = 0;
            for (var i = 1; i < 10; i++) {
                if (occurance[count] < occurance[i]) {
                    count = i;
                }
            }
            console.log(count);
        }
    };
    return Question;
}());
