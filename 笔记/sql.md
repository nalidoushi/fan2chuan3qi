# SQL

## 基本概念

### 数据库

数据库，简而言之就是存储数据的仓库，可以按照一定的数据结构存储管理大量的数据及数据 与数据之间的关系，它本质上是一种信息管理系统。

数据库根据存储采用的数据结构的不同可 以分为许多种，其中常见的有层次式数据库、网络式数据库、关系型数据库。

其中关系型数据 库占据着市场的主流。

### 关系型数据库

关系型数据库是建立在关系模型基础上的数据库。

这种定义听起来十分抽象，这里我们不深入 讨论什么叫做“关系模型”--大学计算机专业专门有一门课叫“离散数学”专门讨论过关系模 型，只是简单的表述为 利用表来存储数据，用表和表之间的关系保存数据之间的关系的数据库 称为关系型数据库，这个定义不太严谨，但是更好理解。

### 常见关系型数据库

#### 商业数据库： 

> Oracle -- 甲骨文公司开发
>
> SQLServer -- 微软公司开发，.Net技术中常用 
>
> DB2 -- IBM公司开发 
>
> Sybase -- Sybase公司开发

#### 开源数据库:

> MySql -- 瑞典MySql AB研发，非常受欢迎，已经被Oracle收购 
>
> SQLite -- 小型轻量级开源关系型数据库，常用作嵌入式设备数据库

## MySQL常见概念

### 数据库服务器

指的就是一个数据库管理程序，这个程序可以管理多个数据库。 具体来看就是在系统中运行的mysql的服务。 该服务器根据配置监听当前机器的指定端口(默认3306)等待客户端的连接访问。

### 数据库客户端

用来连接数据库服务器进行数据库操作的程序称之为数据库客户端程序，简称数据库客户端。 

mysql自带了客户端程序，即bin/mysql.exe，可以通过该程序连接数据库服务器。

### 数据库

所谓的数据库就是在数据库服务器中创建的以一系列的表的形式存储数据的仓库。 一个数据库服务器中可以创建多个数据库。 多个数据库之间是互相隔离的。 通常一个项目对应一个数据库。 每个项目各自创建和使用各自的数据库，从而可以实现多个项目在一个数据库服务器中互不干扰的 工作。

### 表

数据库中以表来存储数据。

 一个数据库中可以创建多个表。 

通常一个javabean类对应一个表。

![image-20240129155754795](images/sql/image-20240129155754795.png)

### 表记录

表中一条数据就是一个表记录。 

一个表中可以存储多条表记录。 

通常一个javabean对象对应一个表记录。

![image-20240129155815340](images/sql/image-20240129155815340.png)

## SQL语言

### 概念

> SQL--Structured Query Language, 结构化查询语言,是关系型数据库通用的操作语言。 
>
> 是一种非过程性语言。
>
>  由美国国家标准局(ANSI）与国际标准化组织（ISO）制定SQL标准。
>
> 各大数据库厂商都对其做了实 现。所以我们只要学会了SQL语言，就可以操作各大关系型数据库了。 
>
> 为加强SQL的语言能力，各厂商增强了过程性语言的特征,增加了一些非标准的SQL，这样的SQL称 为该数据库的“方言”。
>
>  SQL是用来存取关系数据库的语言，具有查询、操纵、定义和控制关系型数据库的四方面功能

### 分类

•**数据定义语言（**DDL**）**: Data Definition Language

•**数据操纵语言（**DML**） **: Data Manipulation Language

•**数据查询语言（**DQL**） **：Data Query Language

•**事务控制语言（**TCL**） **：Transaction Control Language

•**数据控制语言（**DCL**） **: Data Control Language

## DDL

Data Definition Language  数据定义语言

用于建立、修改、删除数据库对象

包括:

CREATE: 创建表或其他对象结构

ALTER:修改表或其他对象结构

DROP:删除表或其他对象结构

TRUNCATE:摧毁并重建表



### 创建数据库

#### 语法

```sql
CREATE DATABASE [IF NOT EXISTS] db_name [create_specification [, create_specification] ...]
```

**IF NOT EXISTS:**

在创建前判断是否存在，如果不存在则创建，存在则不创建也不报错

**create_specification:**

CHARACTER SET charset_name #数据库默认编码集 

COLLATE collation_name #数据库默认校对规则

#### 练习

1) 创建一个名称为mydb1的数据库

   ```sql
   CREATE DATABASE mydb1;
   ```

2) 创建一个使用gbk字符集的mydb2数据库

   ```sql
   CREATE DATABASE mydb2 character set gbk;
   ```

3) 创建一个使用utf8字符集，并带校对规则utf8_bin的mydb3数据库

   ```sql
   CREATE DATABASE mydb3 character set utf8 collate utf8_bin;
   ```

### 查询数据库

#### 语法

1. 查看所有数据库

   ```sql
   show databases;
   ```

2. 查看数据库建库语句

   ```sql
   show create database db_name;
   ```

### 修改数据库

#### 语法

```sql
ALTER DATABASE [IF NOT EXISTS] db_name [alter_specification [, alter_specification] ...]
```

**IF NOT EXISTS：**

在修改前判断是否存在，如果存在则修改，如果不存在则不修改也不报错

**alter_specification:**

CHARACTER SET charset_name #修改数据库字符集编码集 

COLLATE collation_name #修改数据库校对规则

#### 练习

1. 把mydb2库的字符集修改为utf8 

   ```sql
   alter database mydb2 character set utf8;
   ```

### 删除数据库

#### 语法

```sql
DROP DATABASE [IF EXISTS] db_name
```

**IF EXISTS:** 

在删除前判断是否存在，如果存在则删除，如果不存在则不删除也不报错

#### 练习

1. 删除前面创建的mydb1数据库 	

   ```sql
   drop database mydb1;
   ```

### 切换数据库

#### 语法

```sql
use db_name;
```

### 创建表

#### 语法

```sql
CREATE TABLE table_name(
	field1 datatype [cons],
	field2 datatype [cons],
	field3 datatype [cons]
)[character set 字符集] [collate 校对规则]
field：指定列名
datatype：指定列类型
cons:约束条件
```

#### 案例

1. 创建Employee表 

   | 字段       | 属性     | 约束 |
   | ---------- | -------- | ---- |
   | id         | 整形     |      |
   | name       | 字符型   |      |
   | gender     | 字符型   |      |
   | birthday   | 日期     |      |
   | entry_date | 日期     |      |
   | job        | 字符类型 |      |
   | salary     | 浮点型   |      |
   | resume     | 大文本   |      |

   ```sql
   create table employee(
     id int,
     name varchar(255),
     gender char(1),
     birthday date,
     entry_date date,
     job varchar(255),
     salary double,
     resume text
   );
   ```


### 查看表

#### 语法

显示所有表

```sql
show tables;
```

查看表结构

```sql
desc tab_name;
```

查看建表语句

```sql
show create table tab_name;
```

### 删除表

#### 语法

```sql
drop table tab_name;
```

#### 案例

1. 删除employee表

   ```sql
   drop table employee;
   ```

### 修改表

#### 增加列

```sql
ALTER TABLE tab_name ADD (column datatype [DEFAULT expr][, column datatype]...);
```

在上面员工表的基础上增加一个image列。

```sql
alter table employee add (image blob);
```

#### 修改列

```sql
ALTER TABLE tab_name MODIFY column datatype [DEFAULT expr][, column datatype]...;
```

修改job列，使其长度为60。

```sql
alter table employee modify column job varchar(60);
```

#### 删除列

```sql
ALTER TABLE tab_name DROP (column);
```

删除gender列

```
alter table employee drop gender;
```

#### 修改表名

```sql
ALTER TABLE old_tab_name RENAME TO new_tab_name;
或
RENAME TABLE old_tab_name TO new_tab_name;
```

表名改为user

```
alter table employee rename to user;

rename table user to employee;
```

#### 修改列名

```sql
ALTER TABLE tab_name CHANGE [column] old_col_name new_col_name datatype;
```

列名name修改为username

```sql
alter table employee change column name username varchar(255);
```

#### 修改列的顺序

```sql
ALTER TABLE tab_name MODIFY col_name1 datatype AFTER col_name2;
ALTER TABLE tab_name MODIFY col_name1 datatype FIRST;
```

将image插入到username列的后面

```sql
alter table employee modify image blob after username;
```

#### 修改表的字符集

```sql
ALTER TABLE tab_name CHARACTER SET character_name;
```

修改表的字符集为gbk

```
alter table employee character set gbk;
alter table employee character set utf8;
```

## DML

Data Manipulation Language 数据库操作语言

用于改变数据库表中的数据

包括:

INSERT UPDATE DELETE

### 准备数据

```sql
create table employee(
  id int,
  name varchar(255),
  gender char(1),
  birthday date,
  entry_date date,
  job varchar(255),
  salary double,
  resume text
);
```



### 新增数据

#### 语法

```sql
INSERT INTO tab_name [(column [, column...])] VALUES (value [, value...]);
```

注意:

在values后声明的值必须和values前声明的列相匹配 

可以省略列的声明，则值按照表中列的顺序来指定值

插入的数据应与对应字段的数据类型相匹配

数据的大小应在列的规定范围内 

字符串和日期格式的数据要用单引号引起来 

不想给值的列，可以赋值为null

#### 案例

1.  向员工表中插入三条数据

   ```sql
   insert into employee (id,name,gender,birthday,entry_date,job,salary,resume) 
   values 
   (1,'刘备','m','2000-10-10','2020-11-11','卖鞋',998.00,'鞋编的好~');
   
   insert into employee 
   (id,gender,name,salary,job,resume) 
   values 
   (2,'f','关羽',888.00,'耍大刀','看家护院好管家~~');
   
   insert into employee values (3,'张飞','m','2003-03-03','2003-05-05','杀猪的',1000.00,null);
   
   insert into employee values 
   (4,'刘备2','m','2000-10-10','2020-11-11','卖鞋',998.00,'鞋编的好~'),
   (5,'刘备3','m','2000-10-10','2020-11-11','卖鞋',998.00,'鞋编的好~'),
   (6,'刘备4','m','2000-10-10','2020-11-11','卖鞋',998.00,'鞋编的好~');
   ```

### 修改数据

#### 语法

```sql
UPDATE tab_name SET col_name1=expr1 [, col_name2=expr2 ...] [WHERE where_definition]
```

UPDATE语法可以实现对表记录的修改

SET子句指定要修改哪些列，要给予哪些值

WHERE子句指定修改符合什么条件的表记录中

如没有WHERE子句，则修改所有的行

#### 案例

1. 将所有员工薪水修改为5000元

   ```sql
   update employee set salary=5000;
   ```

2. 将姓名为‘张飞’的员工薪水修改为3000元

   ```sql
   update employee set salary=3000 where name='张飞';
   ```

3. 将姓名为‘关羽’的员工薪水修改为4000元,job改为"看大院"

   ```sql
   update employee set salary=4000,job='看大院' where name='关羽';
   ```

4. 将刘备的薪水在原有基础上增加1000元。

   ```sql
   update employee set salary=salary+1000 where name='刘备';
   ```

### 删除数据

#### 语法

```sql
DELETE FROM tab_name [WHERE where_definition]
```

where用来指定要删除符合那些条件的表记录 

如果不使用where子句，将删除表中所有数据 

delete语句不能删除某一列的值（可使用update） 

delete语句仅删除记录，不删除表本身

如要删除表，使用drop table语句

也可以使用truncate来“清除数据”，本质上是摧毁后重建表，相对于delete效率更高，但只能删除整表数据，无法操作单条数据

#### 案例

1. 删除表中名称为’张飞’的记录

   ```sql
   delete from employee where name = '张飞';
   ```

2. 删除表中所有记录

   ```sql
   delete from employee;
   ```

3. 使用truncate删除表中记录

   ```sql
   truncate employee;
   ```

## 约束

> 数据库中可以为字段设定额外的限定条件，要求必须符合这些条件的数据才可以被存入。
>
> 这些额外的限定条件就称之为约束。

### 主键约束

通常每张表都会有一个字段或多个字段联合起来唯一标识表记录

这样的字段称为这张表的主 键字段。

基于它的作用，主键必然不可为空且不可重复。

数据库中可以为主键字段声明主键约束，一旦声明过后，数据库会帮我们维护该字段的值，非空且唯一。

如果主键字段为int类型，则可以在声明主键约束时，声明auto_increment,则该主键将具有自增特性。

```sql
primary key [auto_increment]
```

### 非空约束

如果希望某个字段的值不可以为空，则可以声明非空约束

```sql
not null
```

### 唯一约束

如果希望某个字段的值不可以重复，则可以声明唯一约束

```sql
unique
```

### 检查约束

如果希望自己指定约束条件，可以使用检查约束

```sql
check (检查的条件)
```

### 默认约束

默认情况下，字段的默认值NULL，可以通过设置默认约束指定字段的默认值

```sql
default v;
```

### 外键约束

多表设计相关的约束，后续讲解。

### 案例

创建employee2表

| 字段       | 属性     | 约束             |
| ---------- | -------- | ---------------- |
| id         | 整形     | 主键自增         |
| name       | 字符型   | 唯一             |
| gender     | 字符型   | 非空             |
| birthday   | 日期     |                  |
| entry_date | 日期     | 必须大于出生日期 |
| job        | 字符类型 | 默认值为'未知'   |
| salary     | 浮点型   |                  |
| resume     | 大文本   |                  |

```sql
create table employee2(
    id int primary key auto_increment,
    name varchar(255) unique, 
    gender char(1) not null,
    birthday date ,
    entry_date date check(entry_date>birthday),
    job varchar(255) default '未知',
    salary double,
    resume text
);
insert into employee2 values 
(null,'刘备','m','2000-03-03','2021-04-04','卖鞋',999.99,'鞋子不错~');

#insert into employee2 values 
#(null,'刘备','m','2000-03-03','2021-04-04','卖鞋',999.99,'鞋子不错~');

#insert into employee2 values 
#(3,'关羽',null,'2002-03-03','2023-04-04','卖鞋',999.99,'鞋子不错~');

#insert into employee2 values 
#(3,'关羽','f','2002-03-03','2001-04-04','刷刀',999.99,'看家护院~');

insert into employee2 values 
(3,'关羽','f','2002-03-03','2003-04-04','刷刀',999.99,'看家护院~');

insert into employee2 values 
(null,'张飞','m','2005-05-05','2006-06-06','杀猪',999.99,'杀猪小能手~');

insert into employee2 
(id,name,gender,birthday,entry_date,job,salary,resume)
values 
(null,'赵云','m','2007-05-05','2008-06-06',null,500.00,'老大的贴身保镖');

insert into employee2 
(id,name,gender,birthday,entry_date,salary,resume)
values 
(null,'赵云2','m','2007-05-05','2008-06-06',500.00,'老大的贴身保镖');
```

## DQL

DQL用于查询表中的记录

### 准备数据

```sql
create table exam(
	id int primary key auto_increment,
    name varchar(20) not null,
    chinese double,
    math double,
    english double
);
insert into exam values (null,'关羽',85,76,70);
insert into exam values (null,'张飞',70,75,70);
insert into exam values (null,'赵云',90,65,95);
insert into exam values (null,'张三丰',82,79,null);
```

### 基础查询

#### 语法

```sql
SELECT [DISTINCT] *|{column1, column2. column3..} FROM tab_name;
```

select 指定查询哪些列的数据

column指定列名

*号代表查询所有列

from指定查询哪张表

DISTINCT可选，指显示结果时，是否剔除重复数据

#### 练习

1. 查询表中所有学生的信息

   ```sql
   select id,name,chiese,math,english from exam;
   select * from exam;
   ```

2. 查询表中所有学生的姓名和对应的英语成绩

   ```sql
   select name,english from exam;
   ```

3. 查询所有英语成绩并过滤重复数据

   ```sql
   select distinct english from exam;
   ```

4. 在所有学生分数上加10分特长分显示

   ```sql
   select name,math+10,chinese+10,english+10 from exam;
   ```

5. 统计每个学生的总分

   ```sql
   select name,math+chinese+english from exam;
   ```

6. 使用别名表示学生总分

   ```sql
   select name as 姓名,math+chinese+english as 总分 from exam;
   select name 姓名,math+chinese+english 总分 from exam;
   ```

   

​		
