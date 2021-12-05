-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.9.1
-- PostgreSQL version: 10.0
-- Project Site: pgmodeler.io
-- Model Author: ---


-- Database creation must be done outside a multicommand file.
-- These commands were put in this file only as a convenience.
-- -- object: new_database | type: DATABASE --
-- -- DROP DATABASE IF EXISTS new_database;
-- CREATE DATABASE new_database;
-- -- ddl-end --
-- 

-- object: public."Jugador" | type: TABLE --
-- DROP TABLE IF EXISTS public."Jugador" CASCADE;
CREATE TABLE public."Jugador"(
	"DNI" varchar NOT NULL,
	"Dorsal" smallint,
	"Nombre" varchar,
	"Apellidos" varchar,
	"MediaPuntos" smallint,
	"MediaRebotes" smallint,
	"MediaAsistencias" smallint,
	"FechaFinContrato" date,
	"Nacionalidad" varchar,
	"Posicion" varchar,
	"Salario" integer,
	"Estado" varchar,
	"id_Equipo" smallint,
	"CorreoElectronico" varchar NOT NULL,
	"Contraseña" varchar,
	CONSTRAINT "Jugador_pk" PRIMARY KEY ("DNI","CorreoElectronico")

);
-- ddl-end --
ALTER TABLE public."Jugador" OWNER TO postgres;
-- ddl-end --

-- object: public."MiembroCuerpoTecnico" | type: TABLE --
-- DROP TABLE IF EXISTS public."MiembroCuerpoTecnico" CASCADE;
CREATE TABLE public."MiembroCuerpoTecnico"(
	"DNI" varchar NOT NULL,
	"Nombre" varchar,
	"Apellidos" varchar,
	"Puesto" varchar,
	"Salario" integer,
	"FechaFinContrato" date,
	"Nacionalidad" varchar,
	"TacticaFavorita" varchar,
	"id_Equipo" smallint,
	"CorreoElectronico" varchar NOT NULL,
	"Contraseña" varchar,
	CONSTRAINT "MiembroCuerpoTecnico_pk" PRIMARY KEY ("DNI","CorreoElectronico")

);
-- ddl-end --
ALTER TABLE public."MiembroCuerpoTecnico" OWNER TO postgres;
-- ddl-end --

-- object: public."Directiva" | type: TABLE --
-- DROP TABLE IF EXISTS public."Directiva" CASCADE;
CREATE TABLE public."Directiva"(
	"DNI" varchar NOT NULL,
	"Nombre" varchar,
	"Apellidos" varchar,
	"Puesto" varchar,
	"Salario" integer,
	"FechaFinContrato" date,
	"Nacionalidad" varchar,
	"id_Equipo" smallint,
	"CorreoElectronico" varchar NOT NULL,
	"Contraseña" varchar,
	CONSTRAINT "Directiva_pk" PRIMARY KEY ("DNI","CorreoElectronico")

);
-- ddl-end --
ALTER TABLE public."Directiva" OWNER TO postgres;
-- ddl-end --

-- object: public."Equipo" | type: TABLE --
-- DROP TABLE IF EXISTS public."Equipo" CASCADE;
CREATE TABLE public."Equipo"(
	id smallint NOT NULL,
	"Nombre" varchar,
	"Ciudad" varchar,
	"Pabellon" varchar,
	"Patrocinador" varchar,
	"EquipacionLocal" varchar,
	"EquipacionVisitante" varchar,
	"id_Liga" smallint,
	"Puntos" integer,
	CONSTRAINT "Equipo_pk" PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public."Equipo" OWNER TO postgres;
-- ddl-end --

-- object: public."Liga" | type: TABLE --
-- DROP TABLE IF EXISTS public."Liga" CASCADE;
CREATE TABLE public."Liga"(
	id smallint NOT NULL,
	"Pais" varchar,
	"Categoria" varchar,
	CONSTRAINT "Liga_pk" PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public."Liga" OWNER TO postgres;
-- ddl-end --

-- object: "Equipo_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Jugador" DROP CONSTRAINT IF EXISTS "Equipo_fk" CASCADE;
ALTER TABLE public."Jugador" ADD CONSTRAINT "Equipo_fk" FOREIGN KEY ("id_Equipo")
REFERENCES public."Equipo" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Equipo_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Directiva" DROP CONSTRAINT IF EXISTS "Equipo_fk" CASCADE;
ALTER TABLE public."Directiva" ADD CONSTRAINT "Equipo_fk" FOREIGN KEY ("id_Equipo")
REFERENCES public."Equipo" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Equipo_fk" | type: CONSTRAINT --
-- ALTER TABLE public."MiembroCuerpoTecnico" DROP CONSTRAINT IF EXISTS "Equipo_fk" CASCADE;
ALTER TABLE public."MiembroCuerpoTecnico" ADD CONSTRAINT "Equipo_fk" FOREIGN KEY ("id_Equipo")
REFERENCES public."Equipo" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Liga_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Equipo" DROP CONSTRAINT IF EXISTS "Liga_fk" CASCADE;
ALTER TABLE public."Equipo" ADD CONSTRAINT "Liga_fk" FOREIGN KEY ("id_Liga")
REFERENCES public."Liga" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."Socio" | type: TABLE --
-- DROP TABLE IF EXISTS public."Socio" CASCADE;
CREATE TABLE public."Socio"(
	"DNI" varchar NOT NULL,
	"Nombre" varchar,
	"Apellidos" varchar,
	"CorreoElectronico" varchar NOT NULL,
	"id_Equipo" smallint,
	"Contraseña" varchar,
	CONSTRAINT "Aficionado_pk" PRIMARY KEY ("DNI","CorreoElectronico")

);
-- ddl-end --
ALTER TABLE public."Socio" OWNER TO postgres;
-- ddl-end --

-- object: "Equipo_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Socio" DROP CONSTRAINT IF EXISTS "Equipo_fk" CASCADE;
ALTER TABLE public."Socio" ADD CONSTRAINT "Equipo_fk" FOREIGN KEY ("id_Equipo")
REFERENCES public."Equipo" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."Dueño" | type: TABLE --
-- DROP TABLE IF EXISTS public."Dueño" CASCADE;
CREATE TABLE public."Dueño"(
	"DNI" varchar NOT NULL,
	"Nombre" varchar,
	"Apellidos" varchar,
	"Nacionalidad" varchar,
	"CorreoElectronico" varchar NOT NULL,
	"id_Equipo" smallint,
	"Contraseña" varchar,
	CONSTRAINT "Dueño_pk" PRIMARY KEY ("DNI","CorreoElectronico")

);
-- ddl-end --
ALTER TABLE public."Dueño" OWNER TO postgres;
-- ddl-end --

-- object: "Equipo_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Dueño" DROP CONSTRAINT IF EXISTS "Equipo_fk" CASCADE;
ALTER TABLE public."Dueño" ADD CONSTRAINT "Equipo_fk" FOREIGN KEY ("id_Equipo")
REFERENCES public."Equipo" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Dueño_uq" | type: CONSTRAINT --
-- ALTER TABLE public."Dueño" DROP CONSTRAINT IF EXISTS "Dueño_uq" CASCADE;
ALTER TABLE public."Dueño" ADD CONSTRAINT "Dueño_uq" UNIQUE ("id_Equipo");
-- ddl-end --


