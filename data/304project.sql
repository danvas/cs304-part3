drop table Item;

create table Item
(upc char(16) not null,
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
(upc char(16) not null,
sname varchar(20) not null,
PRIMARY KEY (upc, sname),
foreign key (upc) 
	references Item);

drop table HasSong;

create table HasSong
(upc char(16) not null,
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
cid varchar(10) not null,
cardno varchar(16),
expirydate char(4),
expecteddate date,
delivereddate date,
PRIMARY KEY (receiptId),
foreign key (cid) 
	references Customer);

drop table PurchaseItem;

create table PurchaseItem
(receiptId integer not null,
upc char(16) not null,
quantity integer not null,
PRIMARY KEY(receiptId, upc),
foreign key (receiptId) 
	references Purchase,
foreign key (upc) 
	references Item);
	
drop table Return;

create table Return
(retid varchar(10) not null,
receiptId integer not null,
rdate date null,
PRIMARY KEY (retid),
foreign key (receiptId) 
	references Purchase);

drop table ReturnItem;

create table ReturnItem
(retid varchar(10) not null,
upc char(16) not null,
quantity integer null,
PRIMARY KEY (retid, upc),
foreign key (retid) 
	references Return,
foreign key (upc) 
	references Item);

insert into Item
	values('1111111111111111', 'Thriller', 'CD', 'POP','Sony', '1983',9.99, 20);
insert into Item
	values('1111111111111112', 'Bad', 'CD', 'POP','Sony', '1987',8.99, 10);
insert into Item
	values('1111111111111113', 'Metallica', 'CD', 'Metal','Elektra', '1991',1.99, 25);
insert into Item
	values('1111111111111114', 'Straight outa Compton', 'DVD', 'RAP','Sony', '1989',12.99, 5);
insert into Item
	values('1111111111111115', 'Mozart', 'CD', 'Classical','BMG', '1656',9.99, 20);

insert into LeadSinger
	values ('1111111111111111', 'Michael Jackson');
insert into LeadSinger
	values ('1111111111111112', 'Michael Jackson');
insert into LeadSinger
	values ('1111111111111113', 'Metallica');
insert into LeadSinger
	values ('1111111111111114', 'NWA');
insert into LeadSinger
	values ('1111111111111115', 'Mozart');

insert into HasSong
	values('1111111111111111', 'Beat it');
insert into HasSong
	values('1111111111111111', 'Thriller');
insert into HasSong
	values('1111111111111111', 'Baby be mine');
insert into HasSong
	values('1111111111111112', 'Smooth criminal');
insert into HasSong
	values('1111111111111112', 'Man in the mirror');
insert into HasSong
	values('1111111111111113', 'Enter sandman');
insert into HasSong
	values('1111111111111113', 'Sad but true');
insert into HasSong
	values('1111111111111113', 'Unforgiven');
insert into HasSong
	values('1111111111111114', 'Straight outa Compton');
insert into HasSong
	values('1111111111111114', 'F*** the Police');
insert into HasSong
	values('1111111111111115', 'Symphony');

insert into Purchase
	values(11, '2001-01-01', '1234', '4444555566667777', '0101', null, null); 
insert into Purchase
	values(12, '2002-02-21', '5678', '4444555566667778', '0101', '2012-01-01', '2012-01-05' );
insert into Purchase
	values(13, '2003-03-18', '3456', null, null, null, null);

insert into PurchaseItem
	values(11, '1111111111111111', 1);
insert into PurchaseItem
	values(11, '1111111111111112', 1);
insert into PurchaseItem
	values(12, '1111111111111113', 1);
insert into PurchaseItem
	values(13, '1111111111111114', 1);

insert into Customer
	values('1234', null, null, null, null);
insert into Customer
	values('3456', null, null, null, null);
insert into Customer
	values('5678', 'pass', 'John Smith', '101 university Blvd, Vancouver, BC', '6049999999');

insert into Return
	values('12345', 13, '2003-03-23');

insert into ReturnItem
	values('12345', '1111111111111114', 1);











