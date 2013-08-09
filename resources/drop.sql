
-- drop specific tables
prompt **************************************************** TABLES BEFORE DROP;
select table_name from user_tables;
drop table ITEM cascade constraints;
drop table RETURN cascade constraints;
drop table PURCHASE cascade constraints;
drop table CUSTOMER cascade constraints;
drop table BRANCH cascade constraints;
drop table DRIVER cascade constraints;
drop table LICENSE cascade constraints;
drop table LEADSINGER cascade constraints;
drop table EXAM cascade constraints;
drop table HASSONG cascade constraints;
drop table AUTHORS cascade constraints;
drop table PUBLISHERS cascade constraints;
drop table ROYSCHED cascade constraints;
drop table TITLEAUTHORS cascade constraints;

drop table TITLES cascade constraints;
drop table EDITORS cascade constraints;
drop table TITLEDITORS cascade constraints;
drop table SALES cascade constraints;
drop table SALESDETAILS cascade constraints;
drop table CARDLIST cascade constraints;

drop table PURCHASEITEM cascade constraints;
drop table RETURNITEM cascade constraints;
prompt **************************************************** TABLES AFTER DROP;
select table_name from user_tables;