create table t_address(
	f_id integer primary key not null,
	f_country varchar(20),
	f_province varchar(20),
	f_city varchar(64),
	f_street varchar(128),
	f_postcode varchar(20)
);

create sequence t_address_id_seq
	start with 1
	increment by 1
	no minvalue
	no maxvalue
	cache 1;
	
alter table t_address alter column f_id set default nextval('t_address_id_seq');