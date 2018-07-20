
create table employee(
	id number(5) primary key,
	name varchar2(30),
	salary number(7,2),
	department varchar2(40),
	dob Date,
	doj Date
	);
	
	
create sequence empid_seq start with 1000;