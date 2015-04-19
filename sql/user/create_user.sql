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
	constraint fk_user_role_id foreign key(f_roleid) references t_role(f_id) on delete cascade on update cascade,
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