## JAVA Tricks

1. ArrayList initialization
<pre>
List<Integer> list = new ArrayList<Integer>() {
        {
        int x = 0 ; add(0); add(9);
    }
};
</pre>
