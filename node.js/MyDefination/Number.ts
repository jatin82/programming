interface Number{
    compareTo(x:number):number;
}

Number.prototype.compareTo = function(x){
    if(x === this) return 0;
    else if(x>this) return -1;
    else return 1;
};