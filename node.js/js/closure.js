function counter(){
    let n = 0;
    return {
        count:function(){
            return n++;
        },
        reset:function(){
            n=0;
        }
    }
}

var c = counter();
var d = counter();
c.count();
c.count();
console.log(c.count());
console.log(d.count());