Create database chuyendoicsdl;
use chuyendoicsdl;
create table PHIEUXUAT(
so_PX int primary key,
Ngay_Xuat datetime not null
);
create table VATTU(
Ma_VTU int primary key,
Ten_VTU varchar(45) not null
);
create table chi_tiet_phieu_xuat(
so_PX int,
Ma_VTU int,
DG_Xuat varchar(45) not null,
SL_Xuat int not null,
foreign key(so_PX)references PHIEUXUAT(so_PX),
foreign key(Ma_VTU)references VATTU(Ma_VTU)
);
create table PHIEUNHAP(
So_PN int primary key,
Ngay_Nhap datetime not null
);
create table chi_tiet_phieu_nhap(
Ma_VTU int,
So_PN int,
DG_Nhap varchar(45) not null,
SL_Nhap int not null,
foreign key(Ma_VTU)references VATTU(Ma_VTU),
foreign key(So_PN)references PHIEUNHAP(So_PN)
);
create table DONDH(
Don_DH int primary key,
Ngay_DH datetime not null,
Ma_NCC int,
foreign key(Ma_NCC) references NHACC(Ma_NCC)
);
create table chi_tiet_don_dat_hang(
Ma_VTU int,
Don_DH int,
So_DH int not null,
Ngay_DH datetime not null,
foreign key(Ma_VTU)references VATTU(Ma_VTU),
foreign key(Don_DH)references DONDH(Don_DH)
);
create table NHACC(
Ma_NCC int primary key,
Ten_NCC varchar(45) not null,
Dia_Chi varchar(45) not null
);
create table SDT(
Ma_NCC int,
SDT varchar(10) not null,
foreign key(Ma_NCC) references NHACC(Ma_NCC)
);


drop database chuyendoicsdl;


