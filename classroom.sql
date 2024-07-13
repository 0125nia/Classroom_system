create table account
(
    id          varchar(9)   not null
        primary key,
    password    varchar(200) not null,
    code        int          not null,
    enable      tinyint(1)   null,
    card_number varchar(18)  not null
);
create table buildings
(
    id   int auto_increment
        primary key,
    name varchar(20) not null
);
create table classroom
(
    id          int auto_increment
        primary key,
    building_id int                            not null,
    name        varchar(20)                    not null,
    capacity    int         default 50         null,
    `desc`      varchar(20) default '普通教室' not null
);
create table maintain
(
    id     int          not null
        primary key,
    cid    int          null,
    `desc` varchar(100) null comment '维修说明',
    type   int          null comment '维修类型 1-电脑设备 2-桌椅 3-电灯'
);