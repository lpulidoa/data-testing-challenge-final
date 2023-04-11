# Data testing challenge 
This project is a demo of how to implement JPA using Hibernate and is a solution for the database testing challenge for the Endava Internship 2023-1. The challenge consisted of the following:
1. Create the table institution that will have a relationship with the table employee (use foreign key), to show the studies from an employee. Take a screenshot from the new Entity-Relationship Diagram.  
_**Solution:**_ The .sql file in which the table was created can be found in the _queries_ folder as _"institution_creation.sql"_. The new entity-relationship diagram for the new database is as follows: 
![diagrama](https://user-images.githubusercontent.com/109924753/231036886-05edc11d-786d-4a63-a08a-d15da004e6a8.png)

2. Use the Join Clause to get the data from the tables institution and employee.  
_**Solution:**_ The .sql file in which the queries were made can be found in the _queries_ folder as _"queries.sql"_.

3. Use Sub-Queries to get the data from the children whose parents work in PriceSmart
(idCompany = 5). Note: Get the data only from the table children.
_**Solution:**_ The .sql file in which the queries were made can be found in the _queries_ folder as _"queries.sql"_.

4. Create a Java program using JPA+Hibernate to create a database connection, where the user should be able to perform the following actions:  
  * Get all records from the table employee.
  * Get employees by last name from the table employee
  * Insert a new record in the table employee
  * Update a record in the table employee
  * Delete a record in the table employee  
  _**Solution:**_ The java project in this repository is the solution to this part of the challenge. Each of the bullet points is approached as a method in the _"Runner"_ class.
