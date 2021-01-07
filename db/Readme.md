https://www.hackerrank.com/challenges/african-cities/problem

1.find the country name with its count from city table


solution : select ct.NAME , count(c.CountryCode) from COUNTRY as ct left join CITY as c on c.CountryCode = ct.Code group by ct.NAME;
