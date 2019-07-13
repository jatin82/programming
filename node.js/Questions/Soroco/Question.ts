class Question
{
    constructor(private input:string){
        
    }
    

public deduplicate(content:any, chunkSize:any):any {
    let compressed = "";
    let index=0;
    for(let i=0;i<content.length;i=i+chunkSize){
        let temp = content.substring(i,i+chunkSize);
        let foundIndex = compressed.indexOf(temp);
        if(foundIndex!==-1){
            let commaIndex = compressed.indexOf(",", foundIndex);
            let z = compressed.slice(0,commaIndex);
            let y = compressed.slice(commaIndex);
            compressed = compressed.slice(0,commaIndex) + "-"+index + compressed.slice(commaIndex);
        }
        else{
            compressed+= temp+"-"+index+",";
        }
        index++;
    }
    return compressed;
}

/*
 * Complete the 'reduplicate' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING content
 *  2. INTEGER chunkSize
 */

public reduplicate(content:any, chunkSize:any):any {
    let arr = [];
    let n = content.length;
    let len = 0;
    for(let i=0;i<n;i++){
        if(content.charAt(i)==='-'){
            len++;
            arr.push("");
        }
    }

    let i = 0;
    while(i<n){
        let compressedString = content.substring(i,i+chunkSize); 
        let compressedIndex = content.indexOf(",",i+chunkSize);
        let indexes = content.substring(i+chunkSize,compressedIndex);
        indexes = indexes.substring(1).split('-').map(x=>+x);
        for(let x of indexes){
            arr.splice(x,1,compressedString);
        }
        i = compressedIndex+1;
    }
    let ans = "";
    for(let f = 0;f<arr.length;f++)
    {
        ans+=arr[f];
    }
    return ans;
}



    
}