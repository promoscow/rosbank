create table branch
(
    id        bigint auto_increment
        primary key,
    city_id    bigint          not null,
    name   varchar(1024)     not null,
    street   varchar(1024)     not null,
    geo_lat   double     not null,
    geo_lon   double    not null
);


