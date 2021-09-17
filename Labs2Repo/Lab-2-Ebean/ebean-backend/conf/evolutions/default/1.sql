# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table lab2tbl (
  id                            bigint auto_increment not null,
  author                        varchar(255),
  title                         varchar(255),
  pages                         varchar(255),
  year                          varchar(255),
  crossref                      varchar(255),
  journal                       varchar(255),
  booktitle                     varchar(255),
  journal_volume                varchar(255),
  journal_number                varchar(255),
  ee                            varchar(255),
  url                           varchar(255),
  location                      varchar(255),
  constraint pk_lab2tbl primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  username                      varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists lab2tbl;

drop table if exists user;

