--Task – Select all records from the Employee table.

select * from "Employee";

--Task – Select all records from the Employee table where last name is King.

select * from "Employee"
   where "LastName" = 'King';
  
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

select * from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" IS NULL;

--Task – Select all albums in album table and sort result set in descending order

select * from "Album"
ORDER BY "AlbumId" DESC;

--Task – Select first name from Customer and sort result set in ascending order

select * from "Customer"
order by "FirstName";

--Task – Insert two new records into Genre table
INSERT INTO "Genre"(
     "GenreId",
     "Name"
 )
  Values(
    '29',
    'CHillystep'
 ),
 ('30',
  'PianoRock'
 );

--Task – Insert two new records into Employee table

INSERT INTO "Employee"(
"EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate",
"Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email"
 )
  Values('9', 'Scott', 'Michael', 'PaperSalesmen', '2', '1964-05-08 00:00:00.000', '2000-01-01 00:00:00.000',
  '42069 Paper Str', 'Office', 'AB', 'USA', '97055', '(503)826-1606', '(780)867-5309',	'Papermill@paperchinook.com'
 ),
 ('10', 'Sam', 'Rosen',	'GeneralForeman', '6', '1954-03-01 00:00:00.000', '2001-05-12 00:00:00.000', '420 Jazz Ave', 
 'Paris', 'OR',	'USA', '97055',	'(505)826-1606', '(505)420-9669', 'Samuel@chinookcorp.com'
 );

select * from "Employee";
--Task – Insert two new records into Customer table


INSERT INTO "Customer"(
"CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State",
"Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId"
 )
  Values('60', 'Michael', 'Sara', 'Nintendo', 'Applekurky',	'Nottingham', 'UN', 'USA',
  '97055', '(503)670-1234',	'NULL',	'Yearone@yahoo.com', '3'
 ),
 ('61', 'andy', 'Mephisto', 'NULL', 'Dubarko Rd',	'Portland',	'OR', 'USA', '97086',	
 '(505)321-2020', 'NULL', 'Mephisto@gmail.com',	'3'
 );

--Task – Update Aaron Mitchell in Customer table to Robert Walter

UPDATE "Customer"
SET 
    "FirstName" = 'Robert',
    "LastName" = 'Walter'
Where
    "CustomerId" = '32';

--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”

   UPDATE "Artist"
SET 
    "Name" = 'CCR'
Where
    "ArtistId" = '76';
   
--Task – Select all invoices with a billing address like “T”

   SELECT * FROM "Invoice" 
  WHERE "BillingAddress"  LIKE 'T%';
   
--Task – Select all invoices that have a total between 15 and 50

   SELECT * FROM "Invoice" 
  WHERE "Total"  between '15' and '50';
 
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

 SELECT * FROM "Employee" 
  WHERE "HireDate"  between '2003-6-1' and '2004-3-1';
 
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

  
delete from "InvoiceLine" where "InvoiceId" in (select "InvoiceId" from "Invoice" i where "CustomerId" = 32);
delete from "Invoice" where "CustomerId" = 32;
delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';

--Task – Create a query that leverages a system-defined function to return the current time.

SELECT CURRENT_TIMESTAMP;
   
--Task – Create a query that leverages a system-defined function to return the length of a mediatype from the mediatype table

--i cant figure out what your asking of me.

select * from "MediaType";


--Task – Create a query that leverages a system-defined function to return the average total of all invoices

SELECT AVG("Total")
FROM "Invoice";

--Task – Create a query that leverages a system-defined function to return the most expensive trackf

select MAX("UnitPrice")
from "Track";

--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.


--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.

Select "CustomerId", "FirstName", "LastName", "InvoiceId", "Total"
From "Customer" E
full outer JOIN "Invoice" on "Invoice" = "InvoiceId";

--task – Create a right join that joins album and artist specifying artist name and title.
alter table "Artist" rename "ArtistId" to "Artist_Id";

select "Name", "Title", from "Artist", right join "Album" on "Artist_Id" = "AlbumId";

--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

select * from "Album" a cross join "Artist" a2 order by "Name asc";

--Task – Perform a self-join on the employee table, joining on the reports to column.
select * from "Employee" e1 join "Employee" e2 on e1."ReportsTo" = e2"reportsTo";



