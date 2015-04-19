
-------------------- t_phone start -------------------------

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

-------------------- t_address start -------------------------

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

-------------------- t_contact start -------------------------

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


-------------------- t_user start -------------------------

drop table if exists t_user cascade;

create table t_user(
	f_id integer,
	f_username varchar(20),
	f_nickname varchar(20),
	f_loginname varchar(20),
	f_password varchar(20),
	f_birthday date,
	f_gender varchar(4),
	f_createtime timestamp,
	f_logintime timestamp,
	f_roleid integer,
	f_contactid integer,
	f_description varchar(255),
	unique (f_id, f_nickname),
	constraint pk_user_id primary key(f_id),
	--constraint fk_user_role_id foreign key(f_roleid) references t_role(f_id) on delete cascade on update cascade,
	foreign key(f_contactid) references t_contact(f_id) on delete cascade on update cascade
);

drop sequence if exists t_user_id_seq;

create sequence t_user_id_seq
	start with 1
	increment by 1
	no minvalue
	no maxvalue
	cache 1;
	
alter table t_user alter column f_id set default nextval('t_user_id_seq');

commit;

-------------------- t_user end -------------------------