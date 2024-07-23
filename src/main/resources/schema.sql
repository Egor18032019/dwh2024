
SELECT 'CREATE ROLE read_user'
WHERE NOT EXISTS (SELECT FROM pg_catalog.pg_roles WHERE rolname = 'read_user');
ALTER USER read_user WITH PASSWORD 'pass';

SELECT 'CREATE ROLE write_user'
WHERE NOT EXISTS (SELECT FROM pg_catalog.pg_roles WHERE rolname = 'read_user');
ALTER USER write_user WITH PASSWORD 'pass' VALID UNTIL '2025-12-31';

DROP SEQUENCE IF EXISTS global_seq CASCADE;
CREATE SEQUENCE global_seq START WITH 100000;
DROP TABLE IF EXISTS example;
CREATE table example (close float(53), date integer, high float(53), low float(53), open float(53), time integer, id bigint not null, vol bigint, per varchar(255), ticker varchar(255), primary key (id));