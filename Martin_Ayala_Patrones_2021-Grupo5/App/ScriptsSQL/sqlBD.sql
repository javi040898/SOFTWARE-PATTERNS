drop table "Directiva";
drop table "Socio";
drop table "MiembroCuerpoTecnico";
drop table "Jugador";
drop table "Dueño";
drop table "Equipo";
drop table "Liga";


CREATE TABLE public."Jugador"(
	"DNI" varchar NOT NULL,	
	"Dorsal" smallint,
	"Nombre" varchar,
	"Apellidos" varchar,
	"MediaPuntos" smallint,
	"MediaRebotes" smallint,
	"MediaAsistencias" smallint,
	"FechaFinContrato" date,-----------------ATENCION
	"Nacionalidad" varchar,
	"Posicion" varchar,
	"Salario" integer,
	"Estado" varchar,
	"id_Equipo" smallint,
	"CorreoElectronico" varchar NOT NULL,
	"Password" varchar,
	CONSTRAINT "Jugador_pk" PRIMARY KEY ("DNI")

);
ALTER TABLE public."Jugador" OWNER TO postgres;

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
	"Password" varchar,
	CONSTRAINT "MiembroCuerpoTecnico_pk" PRIMARY KEY ("DNI")

);

ALTER TABLE public."MiembroCuerpoTecnico" OWNER TO postgres;

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
	"Password" varchar,
	CONSTRAINT "Directiva_pk" PRIMARY KEY ("DNI")

);

ALTER TABLE public."Directiva" OWNER TO postgres;

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
ALTER TABLE public."Equipo" OWNER TO postgres;

CREATE TABLE public."Liga"(
	id smallint NOT NULL,
	"Pais" varchar,
	"Categoria" varchar,
	CONSTRAINT "Liga_pk" PRIMARY KEY (id)

);
ALTER TABLE public."Liga" OWNER TO postgres;
ALTER TABLE public."Jugador" ADD CONSTRAINT "Equipo_fk" FOREIGN KEY ("id_Equipo")
REFERENCES public."Equipo" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public."Directiva" ADD CONSTRAINT "Equipo_fk" FOREIGN KEY ("id_Equipo")
REFERENCES public."Equipo" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public."MiembroCuerpoTecnico" ADD CONSTRAINT "Equipo_fk" FOREIGN KEY ("id_Equipo")
REFERENCES public."Equipo" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public."Equipo" ADD CONSTRAINT "Liga_fk" FOREIGN KEY ("id_Liga")
REFERENCES public."Liga" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public."Socio"(
	"DNI" varchar NOT NULL,
	"Nombre" varchar,
	"Apellidos" varchar,
	"CorreoElectronico" varchar NOT NULL,
	"id_Equipo" smallint,
	"Password" varchar,
	CONSTRAINT "Aficionado_pk" PRIMARY KEY ("DNI")

);

ALTER TABLE public."Socio" OWNER TO postgres;

ALTER TABLE public."Socio" ADD CONSTRAINT "Equipo_fk" FOREIGN KEY ("id_Equipo")
REFERENCES public."Equipo" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public."Dueño"(
	"DNI" varchar NOT NULL,
	"Nombre" varchar,
	"Apellidos" varchar,
	"Nacionalidad" varchar,
	"CorreoElectronico" varchar NOT NULL,
	"id_Equipo" smallint,
	"Password" varchar,
	CONSTRAINT "Dueño_pk" PRIMARY KEY ("DNI")

);

ALTER TABLE public."Dueño" OWNER TO postgres;

ALTER TABLE public."Dueño" ADD CONSTRAINT "Equipo_fk" FOREIGN KEY ("id_Equipo")
REFERENCES public."Equipo" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public."Dueño" ADD CONSTRAINT "Dueño_uq" UNIQUE ("id_Equipo");











