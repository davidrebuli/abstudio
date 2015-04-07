# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table attivita (
  codice                    varchar(255) not null,
  nome                      varchar(255),
  installatore_id           integer,
  cliente_codice_fiscale    varchar(255),
  tecnico_email             varchar(255),
  lavoro_id                 bigint,
  avanzamento               integer,
  indirizzo                 varchar(255),
  comune                    varchar(255),
  provincia                 varchar(255),
  cap                       varchar(255),
  foglio                    integer,
  mappale                   varchar(255),
  constraint pk_attivita primary key (codice))
;

create table cliente (
  codice_fiscale            varchar(255) not null,
  codice                    integer,
  nome                      varchar(255),
  cognome                   varchar(255),
  luogo_nascita             varchar(255),
  data_nascita              varchar(255),
  sesso                     varchar(255),
  indirizzo                 varchar(255),
  comune                    varchar(255),
  provincia                 varchar(255),
  cap                       varchar(255),
  telefono                  varchar(255),
  ritenuta                  boolean,
  cartellina                varchar(255),
  constraint pk_cliente primary key (codice_fiscale))
;

create table elaborato (
  codice                    varchar(255) not null,
  descrizione               varchar(255),
  constraint pk_elaborato primary key (codice))
;

create table installatore (
  id                        integer not null,
  ragione_sociale           varchar(255),
  partita_iva               varchar(255),
  indirizzo                 varchar(255),
  comune                    varchar(255),
  provincia                 varchar(255),
  cap                       integer,
  legale_rapp               varchar(255),
  cf                        varchar(255),
  luogo_nascita             varchar(255),
  data_nascita              varchar(255),
  constraint pk_installatore primary key (id))
;

create table lavoro (
  id                        bigint not null,
  descrizione               varchar(255),
  tipo                      varchar(255),
  constraint pk_lavoro primary key (id))
;

create table tecnico (
  email                     varchar(255) not null,
  nome                      varchar(255),
  password                  varchar(255),
  firma                     varchar(255),
  via                       varchar(255),
  provincia                 varchar(255),
  cf                        varchar(255),
  pi                        varchar(255),
  tel                       varchar(255),
  fax                       varchar(255),
  banca                     varchar(255),
  filiale                   varchar(255),
  iban                      varchar(255),
  contr_inps                integer,
  contr_cassa               integer,
  iva                       integer,
  num_iscrizione            integer,
  collegio                  varchar(255),
  cell                      varchar(255),
  pec                       varchar(255),
  constraint pk_tecnico primary key (email))
;


create table lavoro_elaborato (
  lavoro_id                      bigint not null,
  elaborato_codice               varchar(255) not null,
  constraint pk_lavoro_elaborato primary key (lavoro_id, elaborato_codice))
;
create sequence attivita_seq;

create sequence cliente_seq;

create sequence elaborato_seq;

create sequence installatore_seq;

create sequence lavoro_seq;

create sequence tecnico_seq;

alter table attivita add constraint fk_attivita_installatore_1 foreign key (installatore_id) references installatore (id) on delete restrict on update restrict;
create index ix_attivita_installatore_1 on attivita (installatore_id);
alter table attivita add constraint fk_attivita_cliente_2 foreign key (cliente_codice_fiscale) references cliente (codice_fiscale) on delete restrict on update restrict;
create index ix_attivita_cliente_2 on attivita (cliente_codice_fiscale);
alter table attivita add constraint fk_attivita_tecnico_3 foreign key (tecnico_email) references tecnico (email) on delete restrict on update restrict;
create index ix_attivita_tecnico_3 on attivita (tecnico_email);
alter table attivita add constraint fk_attivita_lavoro_4 foreign key (lavoro_id) references lavoro (id) on delete restrict on update restrict;
create index ix_attivita_lavoro_4 on attivita (lavoro_id);



alter table lavoro_elaborato add constraint fk_lavoro_elaborato_lavoro_01 foreign key (lavoro_id) references lavoro (id) on delete restrict on update restrict;

alter table lavoro_elaborato add constraint fk_lavoro_elaborato_elaborato_02 foreign key (elaborato_codice) references elaborato (codice) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists attivita;

drop table if exists cliente;

drop table if exists elaborato;

drop table if exists lavoro_elaborato;

drop table if exists installatore;

drop table if exists lavoro;

drop table if exists tecnico;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists attivita_seq;

drop sequence if exists cliente_seq;

drop sequence if exists elaborato_seq;

drop sequence if exists installatore_seq;

drop sequence if exists lavoro_seq;

drop sequence if exists tecnico_seq;

