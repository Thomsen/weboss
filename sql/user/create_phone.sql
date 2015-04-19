create table t_phone(
	f_id integer primary key not null,
	f_number varchar(20),
	f_phonetype integer
);

create sequence t_phone_id_seq
	start with 1
	increment by 1
	no minvalue
	no maxvalue
	cache 1;
	
alter table t_phone alter column f_id set default nextval('t_phone_id_seq');