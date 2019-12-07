create table skills
(
    id         bigint auto_increment
        primary key,
    name   varchar(255) null,
    person_id bigint
);
