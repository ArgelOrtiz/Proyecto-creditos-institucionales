use Creditos;

/*Mostrar los elementos ingresados en las tablas*/
select * from Alumno;
select * from Asiste;
select * from Conferencias;
select * from AlumnoCreditos;
select * from Reuniones;

select No_Control
from Alumno
where No_Control = 15240564;

insert into Alumno(No_Control, Semestre, Nombre) values (15240564,5,'Argel Ortiz Arenas');

insert into Reuniones(Nombre_Tutor, Lugar, Motivo, Fecha, Hora, Comentarios, No_Control_FK) values ('Pintor','edificioD','Primera reunion'
																									,'2017/12/02','08:45',null,15240564);