prompt
prompt
prompt **************************************************** Creating tables...;
drop table Item cascade constraints;
create table Item
(upc char(6) not null,
ititle varchar(30),
type varchar(3),
category varchar(12),
company varchar(30),
year char(4),
price number(38,2),
stock integer,
PRIMARY KEY (upc));

drop table LeadSinger cascade constraints;

create table LeadSinger
(upc char(6) not null,
sname varchar(20) not null,
PRIMARY KEY (upc, sname),
foreign key (upc) 
	references Item);

drop table HasSong cascade constraints;

create table HasSong
(upc char(6) not null,
stitle varchar(30) not null,
PRIMARY KEY (upc, stitle),
foreign key (upc) 
	references Item);

drop table Customer cascade constraints;

create table Customer
(cid varchar(10) not null,
password varchar(20),
cname varchar(30),
address varchar(40),
phone varchar(10),
PRIMARY KEY (cid));

drop table Purchase cascade constraints;

create table Purchase
(receiptId integer not null,
pdate date,
cid varchar(10),
cardno varchar(16),
expirydate char(4),
expecteddate date,
delivereddate date,
PRIMARY KEY (receiptId),
foreign key (cid) 
	references Customer);

DROP SEQUENCE purchase_receiptId;	
CREATE SEQUENCE purchase_receiptId	
START WITH 1000
INCREMENT BY 1;

drop table PurchaseItem cascade constraints;

create table PurchaseItem
(receiptId integer not null,
upc char(6) not null,
quantity integer not null,
PRIMARY KEY(receiptId, upc),
foreign key (receiptId) 
	references Purchase,
foreign key (upc) 
	references Item);

	
drop table Return cascade constraints;

create table Return
(retid integer not null,
receiptId integer not null,
rdate date null,
PRIMARY KEY (retid),
foreign key (receiptId) 
	references Purchase);

DROP SEQUENCE return_retid;
CREATE SEQUENCE return_retid;

drop table ReturnItem cascade constraints;

create table ReturnItem
(retid integer not null,
upc char(6) not null,
quantity integer null,
PRIMARY KEY (retid, upc),
foreign key (retid) 
	references Return,
foreign key (upc) 
	references Item);
prompt **************************************************** Inserting into Item;
insert into Item
	values('111111', 'Thriller', 'CD', 'Pop','Sony', '1983',9.99, 20);
insert into Item
	values('111112', 'Bad', 'CD', 'Pop','Sony', '1987',8.99, 10);
insert into Item
	values('111113', 'Metallica', 'CD', 'Metal','Elektra', '1991',8.99, 25);
insert into Item
	values('111114', 'Straight outa Compton', 'DVD', 'Rap','Sony', '1989',12.99, 5);
insert into Item
	values('111115', 'Mozart', 'CD', 'Classical','BMG', '1656',9.99, 20);
insert into Item
	values('111116', 'Yeezus', 'CD', 'Rap','Sony', '2013', 11.99, 100);
insert into Item
	values('111117', 'Beethoven', 'DVD', 'Classical', 'Warner', '1834', 14.99, 34);
insert into Item
	values('111118', 'Star Wars Soundtrack', 'CD', 'Instrumental','LucasArts', '1983',9.99, 40);
insert into Item
	values('111119', 'Best of Johnny Cash', 'CD', 'Country','Columbia', '2007',12.99, 25);
insert into Item
	values('111120', 'Songs from the Big Chair Live', 'DVD', 'New Wave','Phonogram Records', '1685',9.99, 12);
	
	
prompt **************************************************** Inserting into LeadSinger;
insert into LeadSinger
	values ('111111', 'Michael Jackson');
insert into LeadSinger
	values ('111112', 'Michael Jackson');
insert into LeadSinger
	values ('111113', 'Metallica');
insert into LeadSinger
	values ('111114', 'NWA');
insert into LeadSinger
	values ('111115', 'Mozart');
insert into LeadSinger
	values ('111116', 'Kanye West');
insert into LeadSinger
	values ('111117', 'Ludwig van Beethoven');
insert into LeadSinger
	values ('111118', 'John Williams');
insert into LeadSinger
	values ('111119', 'Johnny Cash');
insert into LeadSinger
	values ('111120', 'Tears for Fears');
prompt **************************************************** Inserting into HasSong;
insert into HasSong
	values('111111', 'Beat it');
insert into HasSong
	values('111111', 'Thriller');
insert into HasSong
	values('111111', 'Baby be mine');
insert into HasSong
	values('111112', 'Smooth criminal');
insert into HasSong
	values('111112', 'Man in the mirror');
insert into HasSong
	values('111113', 'Enter sandman');
insert into HasSong
	values('111113', 'Sad but true');
insert into HasSong
	values('111113', 'Unforgiven');
insert into HasSong
	values('111114', 'Straight outa Compton');
insert into HasSong
	values('111114', 'F*** the Police');
insert into HasSong
	values('111115', 'Symphony');
insert into HasSong
	values('111116', 'Black Skinhead');
insert into HasSong
	values('111116', 'I am a God');
insert into HasSong
	values('111117', '9th Symphony');
insert into HasSong
	values('111118', 'Star Wars Theme');
insert into HasSong
	values('111118', 'Return of the Empire');
insert into HasSong
	values('111119', 'I Walk the Line');
insert into HasSong
	values('111119', 'Hurt');
insert into HasSong
	values('111120', 'Mad World');
insert into HasSong
	values('111120', 'Shout');
prompt **************************************************** Inserting into Customer, Purchase and PurchaseItem;
insert into Customer
	values('jeff123', 'pass', 'Jeff Son', '12 Electric Ave', 6049992222);
insert into Customer
	values('jack123', 'jackpass', 'Jack Son', '12 Thunder Ave', 6049991111);
insert into Customer
	values('josh123', 'josh123', 'Josh Son', '13 Lightning Lane', 6049993333);
insert into Customer
	values('joe123', 'joe123', 'Joe Son', '11 Electric Ave', 6049991111);
insert into Purchase
	values(purchase_receiptId.nextval, '2013-03-22', 'joe123', '4444555566667777', '0101', null, null); 
insert into PurchaseItem
	values(purchase_receiptId.currval, '111111', 1);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111112', 1);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111113', 4);
insert into Purchase 
	values (purchase_receiptId.nextval, '03-03-19', 'joe123', '0000999988887777', '0101', '02-02-12', null);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111115', 1);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111116', 4);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111117', 5);
prompt **************************************************** Inserting into Customer, Purchase and PurchaseItem;
insert into Customer
	values('john123', 'pass', 'John Smith', '101 university Blvd, Vancouver, BC', '6049999999');
insert into Purchase
	values(purchase_receiptId.nextval, '2013-03-20', 'john123', '4444555566667778', '0101', '2012-01-01', '2012-01-05' );
insert into PurchaseItem
	values(purchase_receiptId.currval, '111114', 6);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111113', 1);
prompt **************************************************** Inserting into Customer, Purchase and PurchaseItem;
insert into Customer
	values('rog12', 'passw', 'Roger Boyle', '141 Vine Blvd, Vancouver, BC', '7789998899');
insert into Purchase
	values(purchase_receiptId.nextval, '2013-03-21', 'rog12', '4444555566667778', '0101', '2012-06-01', '2012-06-05' );
insert into PurchaseItem
	values(purchase_receiptId.currval, '111114', 1);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111111', 2);

insert into Customer
	values('jim123', null, null, null, null);
insert into Purchase
	values(purchase_receiptId.nextval, '2003-03-18', null, null, null, null, null);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111113', 2);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111115', 1);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111116', 7);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111117', 12);

insert into Purchase
	values(purchase_receiptId.nextval, '2003-03-18', 'jim123', '1234123412341234', 0404, null, null);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111118', 9);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111119', 3);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111120', 11);

insert into Purchase
	values(purchase_receiptId.nextval, '2013-05-25', null, null, null, null, null);
insert into PurchaseItem
	values(purchase_receiptID.currval, '111111', 2);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111113', 8);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111115', 3);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111118', 13);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111120', 7);

insert into Purchase
	values(purchase_receiptId.nextval, '2013-05-25', null, null, null, null, null);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111115', 1);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111112', 3);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111119', 3);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111120', 5);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111116', 7);
insert into Purchase
	values(purchase_receiptId.nextval, '2013-07-31', null, null, null, null, null);
insert into PurchaseItem values('1009', '111118', 4);
prompt **************************************************** Inserting into Return and ReturnItem;

insert into Return
	values(return_retid.nextval, '1006', '2003-03-23');
insert into ReturnItem
	values(return_retid.currval, '111118', 1);
insert into Return
	values(return_retid.nextval, '1008', '2013-05-29');
insert into ReturnItem
	values(return_retid.currval, '111116', 2);
insert into Return
	values(return_retid.nextval, '1006', '2003-04-02');
insert into ReturnItem
	values(return_retid.currval, '111120', 3);
prompt
prompt
prompt