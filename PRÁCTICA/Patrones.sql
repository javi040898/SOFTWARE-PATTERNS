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
	"Password" varchar,
	CONSTRAINT "MiembroCuerpoTecnico_pk" PRIMARY KEY ("DNI")

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
	"Password" varchar,
	CONSTRAINT "Directiva_pk" PRIMARY KEY ("DNI")

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
	"Password" varchar,
	CONSTRAINT "Aficionado_pk" PRIMARY KEY ("DNI")

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
	"Password" varchar,
	CONSTRAINT "Dueño_pk" PRIMARY KEY ("DNI")

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


INSERT INTO "Liga" VALUES(1,'Estados Unidos','Primera');


INSERT INTO "Equipo" VALUES(1,'Lakers','Los Angeles','Staples Center','Wish','Amarillo','Morado',1,50);

delete from "Equipo";

INSERT INTO "Directiva" VALUES('23478544U','Joe','Smith','Director Deportivo',10000,'8/06/2025','Canadiense',1,'joesm@hotmail.com','1234');

INSERT INTO "Directiva" VALUES('2455544U','Pepe','Viyuela','Director Deportivo',45451,'30/06/2025','Holandes',2,'chema@hotmail.com');

delete from "Directiva" where "Nombre"='d';


INSERT INTO "MiembroCuerpoTecnico" VALUES('65889822T','Nick','Nurse','Entrenador',9000,'30/06/2022','Estadounidense',
							 'Pick and Roll',1,'nickn@gmmil.com','1234');
							 
delete from "MiembroCuerpoTecnico";

INSERT INTO "Jugador" VALUES('48569822H',23,'LeBron','James',29,9,10,'3/06/2021','Estadounidense',
							 'Alero',40000000,'Sano',1,'lebronjames23@gmmil.com','1234');
							 
delete from "Jugador";
							 
							 
INSERT INTO "Socio" VALUES('28632477J','Donald','Trump','donalt@gmail.com',1,'1234');

							 
INSERT INTO "Dueño" VALUES('22889889P','Jerry','Buss','Estadounidense','jerryb@gmail.com',1,'1234');

INSERT INTO "Dueño" VALUES('94567315R','Jerry','Buss','Estados Unidos','jerrybuss@gmail.com',1,'1453');
INSERT INTO "Dueño" VALUES('45648315S','Steve','Ballmer','Estados Unidos','steveballmer@gmail.com',2,'4454');
INSERT INTO "Dueño" VALUES('91741234F','Joseph','Tsai','Estados Unidos','josephtsai@gmail.com',3,'5450');
INSERT INTO "Dueño" VALUES('13568315R','Wes','Edens','Estados Unidos','wesedens@gmail.com',4,'6457');
INSERT INTO "Dueño" VALUES('57896455D','Logan','Williams','Estados Unidos','LoganWilliams@gmail.com',5,'7455');
INSERT INTO "Dueño" VALUES('14789655L','Jerry','Reinsdorf','Estados Unidos','JerryReinsdorf@gmail.com',6,'8455');

delete from "Dueño";
							 
							 
select * from "Jugador" inner join "Equipo" on "id_Equipo"="id" where "Equipo"."Nombre" = 'Lakers';

select "DNI" from "Jugador" where "DNI"='48569822H';

update "Dueño" set "Password" = '1234' where "DNI" = '94567315R';

select * from "MiembroCuerpoTecnico";

select * from "Jugador" where "id_Equipo"=1;

select "Jugador"."Nombre","Apellidos","MediaPuntos","MediaRebotes","MediaAsistencias","Equipo"."Nombre" from "Jugador"
inner join "Equipo" on "Jugador"."id_Equipo"="Equipo"."id";

select * from "Dueño";

select * from "Directiva";
select "id_Equipo" from "Directiva" where "DNI" = '123456'

select "id_Equipo" from "Directiva" where "DNI" = 'fffff';

select "id_Equipo" from "Directiva" where "DNI" = '23478544U';

select count(*) from "Socio" where "id_Equipo"=6;

select * from "MiembroCuerpoTecnico";

select * from "Socio" where "Password"='1234';

delete from "Socio";

select count(*) from "Jugador" where "id_Equipo"=1 and "Dorsal" = 15;

select count(*) from "Jugador" where "id_Equipo"=2;







