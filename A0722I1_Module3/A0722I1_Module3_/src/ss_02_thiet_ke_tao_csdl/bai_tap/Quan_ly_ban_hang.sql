Create database QuanLyBanHang;
use QuanLyBanHang;
create table customer(
cID int primary key,
cName varchar(45) not null,
cAge int not null
);
create table `order`(
oID int primary key,
oDate date not null,
oTotalPrice int not null,
cID int not null,
foreign key (cID)references customer(cID)
);
create table Product(
pID int primary key,
pName varchar(45) not null,
pPrice int not null
);
create table OrderDetail(
oID int not null,
pID int not null,
odQTY varchar(45) not null,
foreign key(oID)references `order`(oID),
foreign key(pID)references Product(pID)
);
drop database quanlybanhang;