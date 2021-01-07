
# SQL TRICKY

1. DB : https://en.wikibooks.org/wiki/SQL_Exercises/Employee_management#:~:text=Select%20the%20number%20of%20employees,and%20the%20number%20of%20employees).&text=SELECT%20Department%2C%20COUNT(*)%20FROM,10.

select Departments.Name , COUNT(<b>Employees.Name</b>) from Departments LEFT JOIN Employees on Departments.code = Employees.Department group by Departments.name order by COUNT(*) DESC, Departments.name;

https://www.hackerrank.com/challenges/african-cities/problem


2.find the country name with its count from city table
  solution : select ct.NAME , count(c.CountryCode) from COUNTRY as ct left join CITY as c on c.CountryCode = ct.Code group by ct.NAME;
