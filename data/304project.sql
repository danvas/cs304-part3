drop table Item;
prompt **************************************************** Creating tables...;
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

drop table LeadSinger;

create table LeadSinger
(upc char(6) not null,
sname varchar(20) not null,
PRIMARY KEY (upc, sname),
foreign key (upc) 
	references Item);

drop table HasSong;

create table HasSong
(upc char(6) not null,
stitle varchar(30) not null,
PRIMARY KEY (upc, stitle),
foreign key (upc) 
	references Item);

delete table Customer;

create table Customer
(cid varchar(10) not null,
password varchar(20),
cname varchar(30),
address varchar(40),
phone varchar(10),
PRIMARY KEY (cid));

drop table Purchase;

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

drop table PurchaseItem;

create table PurchaseItem
(receiptId integer not null,
upc char(6) not null,
quantity integer not null,
PRIMARY KEY(receiptId, upc),
foreign key (receiptId) 
	references Purchase,
foreign key (upc) 
	references Item);

	
drop table Return;

create table Return
(retid integer not null,
receiptId integer not null,
rdate date null,
PRIMARY KEY (retid),
foreign key (receiptId) 
	references Purchase);

DROP SEQUENCE return_retid;
CREATE SEQUENCE return_retid;

drop table ReturnItem;

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
	values('111111', 'Thriller', 'CD', 'POP','Sony', '1983',9.99, 20);
insert into Item
	values('111112', 'Bad', 'CD', 'POP','Sony', '1987',8.99, 10);
insert into Item
	values('111113', 'Metallica', 'CD', 'Metal','Elektra', '1991',1.99, 25);
insert into Item
	values('111114', 'Straight outa Compton', 'DVD', 'RAP','Sony', '1989',12.99, 5);
insert into Item
	values('111115', 'Mozart', 'CD', 'Classical','BMG', '1656',9.99, 20);
	
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
prompt **************************************************** Inserting into LeadSinger;
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
prompt **************************************************** Inserting into Customer, Purchase and PurchaseItem;
insert into Customer
	values('joe123', null, null, null, null);
insert into Purchase
	(receiptid, pdate, cid, cardno, expirydate, expecteddate, delivereddate)
	values(purchase_receiptId.nextval, '2001-01-01', joe123, '4444555566667777', '0101', null, null); 
insert into PurchaseItem
	values(purchase_receiptId.currval, '111111', 1);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111112', 1);
prompt **************************************************** Inserting into Customer, Purchase and PurchaseItem;
insert into Customer
	values('john123', 'pass', 'John Smith', '101 university Blvd, Vancouver, BC', '6049999999');
insert into Purchase
	values(purchase_receiptId.nextval, '2002-02-21', john123, '4444555566667778', '0101', '2012-01-01', '2012-01-05' );
insert into PurchaseItem
	values(purchase_receiptId.currval, '111113', 1);
prompt **************************************************** Inserting into Customer, Purchase and PurchaseItem;
insert into Customer
	values('jim123', null, null, null, null);
insert into Purchase
	values(purchase_receiptId.nextval, '2003-03-18', null, null, null, null, null);
insert into PurchaseItem
	values(purchase_receiptId.currval, '111114', 1);
prompt **************************************************** Inserting into Return and ReturnItem;
insert into Return
	values(return_retid.nextval, 1000, '2003-03-23');
insert into ReturnItem
	values(return_retid.currval, '111114', 1);












