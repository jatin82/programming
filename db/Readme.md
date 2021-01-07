
# SQL TRICKY

1. DB : https://en.wikibooks.org/wiki/SQL_Exercises/Employee_management#:~:text=Select%20the%20number%20of%20employees,and%20the%20number%20of%20employees).&text=SELECT%20Department%2C%20COUNT(*)%20FROM,10.

select Departments.Name , COUNT(<b>Employees.Name</b>) from Departments LEFT JOIN Employees on Departments.code = Employees.Department group by Departments.name order by COUNT(*) DESC, Departments.name;

https://www.hackerrank.com/challenges/african-cities/problem


2. find the country name with its count from city table
  solution : select ct.NAME , count(c.CountryCode) from COUNTRY as ct left join CITY as c on c.CountryCode = ct.Code group by ct.NAME;
  
  
# SQL Engines

InnoDB is the most widely used storage engine with transaction support. It is an ACID compliant storage engine. It supports row-level locking, crash recovery and multi-version concurrency control. It is the only engine which provides foreign key referential integrity constraint. Oracle recommends using InnoDB for tables except for specialized use cases.

MyISAM is the original storage engine. It is a fast storage engine. It does not support transactions. MyISAM provides table-level locking. It is used mostly in Web and data warehousing.


