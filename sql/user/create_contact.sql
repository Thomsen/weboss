
drop table if exists t_contact cascade;

create table t_contact(
	f_id integer primary key not null,
	f_email varchar(40),
	f_addressid integer,
	f_phoneid integer,
	foreign key(f_addressid) references t_address(f_id) on delete cascade on update cascade,
	foreign key(f_phoneid) references t_phone(f_id) on delete cascade on update cascade
);

create sequence t_contact_id_seq
	start with 1
	increment by 1
	no minvalue
	no maxvalue
	cache 1;
	
alter table t_contact alter column f_id set default nextval('t_contact_id_seq');

alter table t_contact drop constraint t_contact_f_addressid_fkey;
alter table t_contact drop constraint t_contact_f_phoneid_fkey;
