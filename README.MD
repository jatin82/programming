# Database Page
<a href="https://github.com/jatin82/programming/blob/master/db/Readme.md">click here</a>

# Problems 
[ARRAY] https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/ <br>
[ARRAY] https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/ <br>
[ARRAY] https://www.geeksforgeeks.org/maximum-water-that-can-be-stored-between-two-buildings/ <br>
[ARRAY] https://www.geeksforgeeks.org/trapping-rain-water/ <br>
[ARRAY]<b>*</b> https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/ <br>
[ARRAY] https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/ <br>
[  DP ]<b>*</b> https://www.geeksforgeeks.org/find-the-maximum-of-all-distances-to-the-nearest-1-cell-from-any-0-cell-in-a-binary-matrix/

# REVISE AGAIN

1. https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
2. https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/ 
3. https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
4. https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
5. https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/ --->look at the 2 pointer approach
6. https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
7. https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/ 
8. https://www.geeksforgeeks.org/kth-non-repeating-character/
10. https://www.geeksforgeeks.org/bottom-view-binary-tree/		
11. https://www.geeksforgeeks.org/amazon-sde-interview-experience-july20-2019/

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
 
 <img align="center" src = "https://i.stack.imgur.com/DlA29.png" width="1000" height="500"/>
 <img align="center" src = "https://github.com/jatin82/programming/blob/master/CAP.jpg" width="1000" height="500"/>
 <img align="center" src = "https://github.com/jatin82/programming/blob/master/thread_Life_cycle.jpg" width="1000" height="500"/>
