# Problems 
[ARRAY] https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/ <br>
[ARRAY] https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/ <br>
[ARRAY] https://www.geeksforgeeks.org/maximum-water-that-can-be-stored-between-two-buildings/ <br>
[ARRAY] https://www.geeksforgeeks.org/trapping-rain-water/ <br>


# Important Links
 https://sookocheff.com/post/kafka/kafka-in-a-nutshell/ <br>
 https://towardsdatascience.com/cap-theorem-and-distributed-database-management-systems-5c2be977950e <br>
 https://blog.the-pans.com/different-ways-of-caching-in-distributed-system/ <br>
 [SOLID PRINCIPLES EXAMPLE] https://www.jrebel.com/blog/solid-principles-in-java <br>
 
 # JAVASCRIPT
 https://medium.com/javascript-everyday/javascript-theory-promise-vs-observable-d3087bc1239a
 
 # DBMS
 [ACID JPA LOCKS] https://vladmihalcea.com/a-beginners-guide-to-acid-and-database-transactions/
 
<b> TO Prevent Immutable CLass from reflection <b> <br>
To prevent it, we can take help of SecurityManager, define this method in ReflectionTest and uncomment its calling. This method prevents access check on private fields / methods via reflection.

private static void setSecuritymanager() {
 
    System.setSecurityManager(new SecurityManager() {
        @Override
        public void checkPermission(Permission perm) {
             if (perm.getClass() == ReflectPermission.class && "suppressAccessChecks".equals(perm.getName())) {
                throw new SecurityException("can't supress AccessChecks");
            }
        }
    });
}<br>
Now line nameField.setAccessible(true); throws exception.
 
 <img align="center" src = "https://github.com/jatin82/programming/blob/master/CAP.jpg" width="1000" height="500"/>
 <img align="center" src = "https://github.com/jatin82/programming/blob/master/thread_Life_cycle.jpg" width="1000" height="500"/>
