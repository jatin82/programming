interface Array<T>{
    peek():T
    getLast():T;
    setLast(x:T):void;
    fromLast(x:T):T;
}

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

Array.prototype.fromLast = function(x){
    return this[this.length-1-x];
};

