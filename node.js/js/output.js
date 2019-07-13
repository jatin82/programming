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
        this.solve();
    }
    Question.prototype.solve = function () {
        console.log("Running");
        var sc = new Scanner(this.input);
        var testCase = sc.nextInt();
        while (testCase-- > 0) {
            var n = sc.nextInt();
            var a = [];
            for (var x = 0; x < n; x++) {
                var _a = sc.nextIntArray(' '), t1 = _a[0], t2 = _a[1], t3 = _a[2], t4 = _a[3], t5 = _a[4];
                a.push({
                    t1: t1,
                    t2: t2,
                    t3: t3,
                    t4: t4,
                    t5: t5,
                    index: x + 1
                });
            }
            var teamWon = a.reduce(function (team1, team2) {
                var score1 = 0;
                var score2 = 0;
                team1.t1 > team2.t1 ? score1++ : score2++;
                team1.t2 > team2.t2 ? score1++ : score2++;
                team1.t3 > team2.t3 ? score1++ : score2++;
                team1.t4 > team2.t4 ? score1++ : score2++;
                team1.t5 > team2.t5 ? score1++ : score2++;
                if (score1 === score2) {
                    return team1.index > team2.index ? team2 : team1;
                }
                return score1 > score2 ? team1 : team2;
            });
            console.log(teamWon.index);
        }
    };
    return Question;
}());

main("1\n4\n1 2 3 4 5\n2 4 5 6 7\n1 2 3 4 5\n1 4 2 2 3\n");
