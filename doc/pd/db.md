### 用户信息表
TABLE_USER

|字段|类型|描述|
|:---|:---|:---|
|id|int|用户id(主键)|
|name|varchar|用户名|
|nickname|varchar|昵称|
|password|varchar|处理以后的密码|
|email|varchar|邮箱|
|QQ|varchar|QQ|
|headUrl|varchar|头像地址|


### token表


TABLE_TOKEN

|字段|类型|描述|
|:---|:---|:---|
|userid|int|用户id(主键)|
|accesstoken|varchar||
|refreshtoken|varchar||


SQL:

create table table_user (
user_id int NOT NULL AUTO_INCREMENT,
name varchar(30) not null,
nickname varchar(30) not null,
password varchar(30) not null,
email varchar(30),
QQ varchar(15),
head_url varchar(200),
PRIMARY KEY (user_id));


create table table_user (
PRIMARY KEY int userid,
varchar(30) accesstoken not null,
varchar(30) refreshtoken not null);

create table table_version (
int version
);