-- DROP DATABASE "family-budget";

--CREATE DATABASE IF NOT EXISTS "family-budget"
--    WITH 
--    OWNER = postgres
--    ENCODING = 'UTF8'
--    LC_COLLATE = 'Portuguese_Brazil.1252'
--    LC_CTYPE = 'Portuguese_Brazil.1252'
--    TABLESPACE = pg_default
--    CONNECTION LIMIT = -1;

CREATE SEQUENCE IF NOT EXISTS "user_seq";
CREATE TABLE IF NOT EXISTS "user"(
	"id" INTEGER NOT NULL DEFAULT NEXTVAL ('user_seq'),
	"name" CHARACTER VARYING(200) NOT NULL,
	"email" CHARACTER VARYING(100) NOT NULL,
	"password" CHARACTER VARYING(200) NOT NULL,
	PRIMARY KEY ("id")
);