create table employees
(
    id        bigint auto_increment
        primary key,
    branch_id    bigint          not null,
    name   string     not null,
    is_online   boolean     not null,
    count_lid   int    not null
);
