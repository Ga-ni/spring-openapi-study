drop table if exists search_word CASCADE;
    create table search_word
    (
        id   bigint generated by default as identity,
        word varchar(255),
        search_count bigint,
        primary key (id)
);