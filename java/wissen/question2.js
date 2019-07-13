
// Sample code to perform I/O:

process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";

process.stdin.on("data", function (input) {
    stdin_input += input;                               // Reading input from STDIN
});

process.stdin.on("end", function () {
   main(stdin_input);
});

function main(input) {
    process.stdout.write("Hi, " + input + ".\n");       // Writing output to STDOUT
}

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail


function main(input){
    input = input.split('\n');
    let n = input[0];
    let a = input[1].split(' ');
    
    let total = 0;
    for(let i=0;i<a.length;i++){
        total += (+a[i]);
    }
    
    let ans = [];
    for(let i=0;i<a.length;i++){
        let sum=0;
        for(let j=i;j<a.length;j++){
            sum+=(+a[j]);
            let temp = total - sum;
            
            let count = j-i+1;
            let left = a.length - count;
            
            let current = +(sum/count);
            let leftAvg = +(temp/left);
            if(left==0) leftAvg = 0;
            
            // process.stdout.write(current+" "+leftAvg+"\n");  
            
            if(current > leftAvg){
                ans.push([(i+1),(j+1)]);
                // process.stdout.write((i+1)+" -- "+(j+1)+"\n");  
            }
        }
    }
    process.stdout.write(ans.length+"\n");
    for(let i=0;i<ans.length;i++){
      process.stdout.write(ans[i][0]+" "+ans[i][1]+"\n");  
    }
}

// Write your code here

