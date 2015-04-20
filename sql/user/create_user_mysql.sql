
#-------------------- t_phone start -------------------------
drop table if exists t_phone cascade;
create table t_phone(
	f_id integer primary key not null auto_increment,
	f_number varchar(20),
	f_phonetype integer
);

#-------------------- t_address start -------------------------
drop table if exists t_address cascade;
create table t_address(
	f_id integer primary key not null auto_increment,
	f_country varchar(20),
	f_province varchar(20),
	f_city varchar(64),
	f_street varchar(128),
	f_postcode varchar(20)
);

#-------------------- t_contact start -------------------------

drop table if exists t_contact cascade;

create table t_contact(
	f_id integer primary key not null  auto_increment,
	f_email varchar(40),
	f_addressid integer,
	f_phoneid integer,
	foreign key(f_addressid) references t_address(f_id) on delete cascade on update cascade,
	foreign key(f_phoneid) references t_phone(f_id) on delete cascade on update cascade
);

#-------------------- t_user start -------------------------

drop table if exists t_user cascade;

create table t_user(
	f_id integer not null primary key auto_increment,
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
	#constraint fk_user_role_id foreign key(f_roleid) references t_role(f_id) on delete cascade on update cascade,
	foreign key(f_contactid) references t_contact(f_id) on delete cascade on update cascade
);

#-------------------- t_user end -------------------------