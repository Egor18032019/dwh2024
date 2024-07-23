CREATE ROLE read_user WITH LOGIN PASSWORD 'pass' VALID UNTIL '2025-12-31';
CREATE USER write_user WITH PASSWORD 'pass' VALID UNTIL '2025-12-31';
CREATE SEQUENCE global_seq START WITH 100000;
CREATE table example (close float(53), date integer, high float(53), low float(53), open float(53), time integer, id bigint not null, vol bigint, per varchar(255), ticker varchar(255), primary key (id))