-- WORKSHOP

-- First "Get employees with a salary greater than 3000 and that were born before 1983."
select * from employee
where Salary > 3000 and year(birthDate) < 1983;

-- Second "Get the data corresponding to the child Gohan from the Children table."
select * from children
where fullName = "gohan";

-- Third "Use the Join Clause to get the data from the employee Krilin and get the data from the company where he works."
select idEmployee, firstName, lastName, idCompany from employee e
inner join company c where e.idCompany = c.idCompany and e.firstName = "Krilin";

-- Fourth "Use Sub-Queries to get the data of Trunks' dad whose idChild is equal to 3, only from the table Company"
select * from company
where idCompany in(
	select idCompany from employee
	where idEmployee in (
		select idEmployee from children
		where idChild = 3
	)
);

-- Fifth "Get the data from the employees who are parents"
select * from employee e
inner join children c on e.idEmployee = c.idEmployee;

select * from employee
where idEmployee in(
	select idEmployee from children
);
