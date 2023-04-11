-- Use the Join Clause to get the data from the tables institution and employee
select idEmployee, firstName, lastName, idCompany from employee e
inner join institution i where e.idInstitution = i.idInstitution and e.idInstitution = 1;

select idEmployee, firstName, lastName, idCompany from employee e
inner join institution i where e.idInstitution = i.idInstitution and e.idInstitution = 2;

select idEmployee, firstName, lastName, instName from employee e
inner join institution i where e.idInstitution = i.idInstitution and e.idInstitution = 3;

-- Use Sub-Queries to get the data from the children whose parents work in PriceSmart (idCompany = 5). Get the data only from the table children.
select * from children 
where idEmployee in(
	select idEmployee from employee 
    where idCompany = 5
);

