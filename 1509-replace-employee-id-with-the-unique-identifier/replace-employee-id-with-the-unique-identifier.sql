/* Write your PL/SQL query statement below */
SELECT unique_id,name
FROM Employees e 
LEFT JOIN EmployeeUNI eu
ON e.id=eu.id;