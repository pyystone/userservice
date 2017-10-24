
create table table_user (
user_id int NOT NULL AUTO_INCREMENT,
name varchar(30) not null,
nickname varchar(30) not null,
password varchar(30) not null,
email varchar(30),
QQ varchar(15),
head_url varchar(200),
PRIMARY KEY (user_id));


create table table_token (
  user_id int not null,
  access_token VARCHAR(30) not null,
  refresh_token VARCHAR(30) NOT NULL,
  PRIMARY KEY (user_id)
);

create table table_version (
  version int not NULL
);