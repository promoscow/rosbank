create table employees
(
    id        bigint auto_increment
        primary key,
    branch_id    bigint          not null,
    name   varchar(1024)     not null,
    is_online   boolean     not null,
    count_lid   int    not null
);
