
# SQL TRICKY

1. DB : https://en.wikibooks.org/wiki/SQL_Exercises/Employee_management#:~:text=Select%20the%20number%20of%20employees,and%20the%20number%20of%20employees).&text=SELECT%20Department%2C%20COUNT(*)%20FROM,10.

select Departments.Name , COUNT(<b>Employees.Name</b>) from Departments LEFT JOIN Employees on Departments.code = Employees.Department group by Departments.name order by COUNT(*) DESC, Departments.name;

https://www.hackerrank.com/challenges/african-cities/problem


2. find the country name with its count from city table
  solution : select ct.NAME , count(c.CountryCode) from COUNTRY as ct left join CITY as c on c.CountryCode = ct.Code group by ct.NAME;
  
  
# SQL Engines

InnoDB is the most widely used storage engine with transaction support. It is an ACID compliant storage engine. It supports row-level locking, crash recovery and multi-version concurrency control. It is the only engine which provides foreign key referential integrity constraint. Oracle recommends using InnoDB for tables except for specialized use cases.

MyISAM is the original storage engine. It is a fast storage engine. It does not support transactions. MyISAM provides table-level locking. It is used mostly in Web and data warehousing.

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


