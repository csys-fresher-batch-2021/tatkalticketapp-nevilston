create database trainapp_db
========================================
create Table train_details(train_name varchar(50) not null, train_number varchar(50) not null , seats_avaialble int not null);
Select * from train_details;

=========================================
CREATE Table user_details(user_id serial primary key, user_name varchar(50) not null, user_mobilenumber bigint not null, user_password varchar(20) not null )

========================================
CREATE TABLE train_classlist ( classtype varchar(20) not null , fare int not null)
INSERT INTO train_classlist ( classtype , fare )
Values ('First Class' , 800), 
	  ('Second Class',400),
	  ('Third Class',250)
	  
	  
===============================================
CREATE TABLE passenger_details(passenger_id int not null ,passenger_name varchar(50) not null ,passenger_age int not null , passenger_gender varchar(10) not null)

