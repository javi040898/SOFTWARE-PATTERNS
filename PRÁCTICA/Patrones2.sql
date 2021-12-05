drop table "Directiva";
drop table "Socio";
drop table "MiembroCuerpoTecnico";
drop table "Jugador";

drop table "Equipo";
drop table "Dueño";
drop table "Liga";


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
	"CorreElectronico" varchar NOT NULL,
	CONSTRAINT "Jugador_pk" PRIMARY KEY ("DNI","CorreElectronico")

);

ALTER TABLE public."Jugador" OWNER TO postgres;

CREATE TABLE public."MiembroCuerpoTecnico"(
	"DNI" varchar NOT NULL,
	"Nombre" varchar,
	"Apellidos" varchar,
	"Puesto" varchar,
	"Salario" smallint,
	"FechaFinContrato" date,
	"Nacionalidad" varchar,
	"TacticaFavorita" varchar,
	"id_Equipo" smallint,
	"CorreoElectronico" varchar NOT NULL,
	CONSTRAINT "MiembroCuerpoTecnico_pk" PRIMARY KEY ("DNI","CorreoElectronico")

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
	CONSTRAINT "Directiva_pk" PRIMARY KEY ("DNI","CorreoElectronico")

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
	"JugadorFavorito" varchar,
	"id_Equipo" smallint,
	CONSTRAINT "Aficionado_pk" PRIMARY KEY ("DNI","CorreoElectronico")

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
	CONSTRAINT "Dueño_pk" PRIMARY KEY ("DNI","CorreoElectronico")

);





ALTER TABLE public."Dueño" OWNER TO postgres;
-- ddl-end --

-- object: "Equipo_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Dueño" DROP CONSTRAINT IF EXISTS "Equipo_fk" CASCADE;
ALTER TABLE public."Dueño" ADD CONSTRAINT "Equipo_fk" FOREIGN KEY ("id_Equipo")
REFERENCES public."Equipo" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public."Dueño" ADD CONSTRAINT "Dueño_uq" UNIQUE ("id_Equipo");


INSERT INTO "Liga" VALUES(1,'Estados Unidos','Primera');


INSERT INTO "Equipo" VALUES(1,'Lakers','Los Angeles','Staples Center','Wish','Amarillo','Morado',1);

INSERT INTO "Directiva" VALUES('23478544U','Joe','Smith','Director Deportivo',10000,'8/06/2025','Canadiense',1,'joesm@hotmail.com');


INSERT INTO "MiembroCuerpoTecnico" VALUES('65889822T','Nick','Nurse','Entrenador',9000,'30/06/2022','Estadounidense',
							 'Pick and Roll',1,'nickn@gmmil.com');

INSERT INTO "Jugador" VALUES('48569822H',23,'LeBron','James',29,9,10,'3/06/2021','Estadounidense',
							 'Alero',40000000,'Sano',1,'lebronjames23@gmmil.com');
							 
							 
INSERT INTO "Socio" VALUES('28632477J','Donald','Trump','donalt@gmail.com','LeBron',1);

							 
INSERT INTO "Dueño" VALUES('22889889P','Jerry','Buss','Estadounidense','jerryb@gmail.com');
							 
							 
select * from "Jugador";


