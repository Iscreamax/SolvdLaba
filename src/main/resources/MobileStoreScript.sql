-- 1. Created statements for insertion.
-- fill in the battery table
use mobilestore;
insert into batteries (name,capacity) values ("Samsung",4300);
insert into batteries (name,capacity) values ("Apple",3300);
insert into batteries (name,capacity) values ("Honor",4350);
-- fill in the users table
insert into users (name,surname,email) values ("Oleg","Ran","olegRun@mail.ru");

insert into users (name,surname,email) values ("Renat","Karat","renatKarat@mail.ru");
insert into users (name,surname,email) values ("Alex","Lesley","alexLesley@gmail.com");
insert into users (name,surname,email) values ("Vik","Rubel","vikRubel@mail.ru");
insert into users (name,surname,email) values ("Axe","Effect","axeEffect@gmail.com");
insert into users (name,surname,email) values ("Ann","Ratakovski","annRatakovski@mail.ru");
insert into users (name,surname,email) values ("Kate","Kricheva","kateKricheva@mail.ru");
insert into users (name,surname,email) values ("Jack","Lux","jackLux@mail.ru");
insert into users (name,surname,email) values ("Lee","Cooper","leeCooper@mail.ru");
insert into users (name,surname,email) values ("Kris","Kross","krisKross@mail.ru");
insert into users (name,surname,email) values ("Kate","Luise","kateLuise@mail.ru");
insert into users (name,surname,email) values ("Mak","Neel","makNeel@mail.ru");
-- fill in the mobile_stores table
insert into mobile_stores (name,address) values ("Apple Store","13 Lenin Street");
insert into mobile_stores (name,address) values ("Xiaome Store","Pobediteley Avenue 9");
insert into mobile_stores (name,address) values ("usersSvyaznoy","11 Zaslavskaya Street");
insert into mobile_stores (name,address) values ("Samsung Store","5 Beruta Street");
-- fill in the workers table
insert into workers (position,experience,users_id,mobile_stores_id) values ("Administrator","5 years 10 months",5,1);
insert into workers (position,experience,users_id,mobile_stores_id) values ("Sales consultant","2 years 2 months",2,1);
insert into workers (position,experience,users_id,mobile_stores_id) values ("Trainee","2 months",4,1);
insert into workers (position,experience,users_id,mobile_stores_id) values ("Administrator","3 years 5 months",1,4);
insert into workers (position,experience,users_id,mobile_stores_id) values ("Sales consultant","1 years 2 months",3,4);
insert into workers (position,experience,users_id,mobile_stores_id) values ("Trainee","1 months",6,4);
-- fill in the clients table
insert into clients (creditCardNumber,user_id) value (1324088725,1);
insert into clients (creditCardNumber,user_id) value (1832184522,2);
insert into clients (creditCardNumber,user_id) value (1234521237,3);
insert into clients (creditCardNumber,user_id) value (1845621723,4);
insert into clients (creditCardNumber,user_id) value (3534516574,5);
insert into clients (creditCardNumber,user_id) value (3564215247,6);
insert into clients (creditCardNumber,user_id) value (4525464565,7);
insert into clients (creditCardNumber,user_id) value (4356575534,8);
insert into clients (creditCardNumber,user_id) value (5674543578,9);
insert into clients (creditCardNumber,user_id) value (3426547789,10);
insert into clients (creditCardNumber,user_id) value (7678764534,11);
insert into clients (creditCardNumber,user_id) value (4356667684,12);

-- 2. Created statements for updating.
-- the women got married
update users set surname="Kandy(renamed)", email="kateKandy@mail.ru(renamed)" where id=11;
update users set surname="White(renamed)", email="annWhite@mail.ru(renamed)" where id=6;
update users set surname="Smith(renamed)", email="kateSmith@mail.ru(renamed)" where id=7;
update users set surname="Prod(renamed)", email="krisProd(renamed)" where id=10;
-- promotion
update workers set position="Branch Director(renamed)" where id=1;
update workers set position="Seller-cashier(renamed)" where id=2;
update workers set position="Sales consultant(renamed)" where id=3;
update workers set position="Branch Director(renamed)" where id=4;
update workers set position="Cashier(renamed)" where id=5;
update workers set position="Sales consultant(renamed)" where id=6;
-- the stores has moved
update mobile_stores set address="20 Lenin Street(rename)" where id=2;
update mobile_stores set address="Pobediteley Avenue 191(rename)" where id=1;
update mobile_stores set address="69 Beruta Street(rename)" where id=3;

-- 3. Created statements for deletions. 
-- firing workers
delete from workers where id=2;
delete from workers where id=6;
delete from workers where id=3;
-- the shops have closed
delete from mobile_stores where id=2;
delete from mobile_stores where id=3;
-- the user died
delete from users where id = 7;
delete from users where id = 9;
delete from users where id = 11;
-- the firms have left the market
delete from batteries where id=2;
delete from batteries where id=1;

-- 4.Created alter tables
-- adding columns to tables
alter table users add(age int not null);
alter table clients add(validTHRU char(5));
alter table batteries add(price int);
-- modifying columns to tables
alter table batteries modify price char(10);
alter table users modify age int(20) ;
-- renaming columns to tables
alter table batteries rename column name to manufacturer;
alter table workers rename column position to post;

-- 5. Created big statement to join all tables in the database.
select *from users join clients using(id);
select *from users right join  clients using(id);
select *from users inner join workers using(id);
select *from users left join workers using(id);
select *from users right join workers using(id);
select  u.id,u.name,u.surname,u.email,u.age,c.creditCardNumber,w.post,w.experience,m.address,b.manufacturer,b.capacity from users u  join clients c on u.id=c.user_id
join mobile_stores m join workers w on u.id=w.users_id and m.id=w.mobile_stores_id  join  batteries b   ;

-- 6. Creted statements with aggregate functions and group by and without having.
update users set age=20 where id=1;
update users set age=42 where id=2;
update users set age=33 where id=3;
update users set age=21 where id=4;
update users set age=19 where id=5;
update users set age=52 where id=6;
update users set age=25 where id=8;
update users set age=29 where id=10;
update users set age=27 where id=12;
alter table batteries modify price int(10);
update batteries set price =35 where id=3;
insert into batteries (manufacturer,capacity,price) values ("Honor",3300,15);
insert into batteries (manufacturer,capacity,price) values ("Honor",5100,55);
insert into batteries (manufacturer,capacity,price) values ("Log",2300,23);
insert into batteries (manufacturer,capacity,price) values ("Log",1100,10);
insert into batteries (manufacturer,capacity,price) values ("Log",4100,30);
insert into batteries (manufacturer,capacity,price) values ("Power",800,5);
insert into batteries (manufacturer,capacity,price) values ("Power",1350,12);
insert into batteries (manufacturer,capacity,price) values ("Power",3100,33);
insert into users (name,surname,email,age) values ("Oleg","R","olegR@mail.ru",45);
insert into users (name,surname,email,age) values ("Alex","Don","alexDon@mail.ru",52);
insert into users (name,surname,email,age) values ("Renat","Brat","renatBrat",19);
insert into users (name,surname,email,age) values ("Vik","Big","VikBig",19);
select manufacturer,capacity,avg(price) avgPrice from batteries group by manufacturer;
select manufacturer,min(capacity) minCap,price from batteries group by manufacturer;
select name,age,avg(age) avgAge  from users group by name;
select name,age,min(age) minAge  from users group by name;
select name,age,max(age) maxAge  from users group by name;
select name,age,sum(age) sumAge from users group by name;
select name,age,count(age) countAge from users group by name;
select *from users where age =(select max(age) as maxAge from users);

-- 7. Creted statements with aggregate functions and group by and with having.
select manufacturer,capacity,avg(price) avgPrice from batteries group by manufacturer having avgPrice>20;
select manufacturer,min(capacity) minCap,price from batteries group by manufacturer having minCap<1000;
select name,age,avg(age) avgAge  from users group by name having avgAge>30;
select name,age,min(age) minAge  from users group by name having minAge<25;
select name,age,max(age) maxAge  from users group by name having maxAge>40;
select name,age,sum(age) sumAge from users group by name having sumAge>80;
select name,age,count(age) countAge from users group by name having countAge>1 ;
