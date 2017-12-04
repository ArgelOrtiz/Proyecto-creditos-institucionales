Create database Credito_Institucional;

use Credito_Institucional;

create table Alumno(
No_Control int not null,
Semestre int not null,
Nombre varchar(50) not null);

create table Creditos(
Id_cre int not null,
Concepto varchar(20) not null,
fecha varchar(10) not null,
No_Control_FK int not null);

create table Conferencias(
Id_Confe int not null,
Nombre varchar(30) not null,
Fecha varchar(10) not null,
Horas int not null);

create table Reuniones(
Id_Reun int not null,
Nombre_Tutor varchar(50) not null,
Lugar varchar(30) not null,
Motivo varchar(30)  not null,
Fecha varchar(10) not null,
Hora varchar (5) not null,
Comentarios varchar(200) null,
No_Control_FK int not nuLL);

create table Asiste(

No_Control int not null,
Id_Confe int not null,
Id_Asis int not null);


/*Llaves primarias*/
alter table Alumno add primary key (No_Control);
alter table Creditos add primary key (Id_Cre);
alter table Conferencias add primary key (Id_Confe);
alter table Reuniones add primary key (Id_Reun);
alter table Asiste add primary key (Id_Asis);


/*LLaves foraneas*/
alter table Creditos add foreign key (No_Control_FK) references Alumno(No_Control);
alter table Reuniones add foreign key (No_Control_FK) references Alumno(No_Control);
alter table Asiste add foreign key (No_Control) references Alumno(No_Control);
alter table Asiste add foreign key (Id_Confe) references Conferencias(Id_Confe);


/*Tablas aunto incrementales*/
alter table Creditos change Id_cre Id_cre int auto_increment ;
alter table Conferencias change Id_Confe Id_Confe int auto_increment ;
alter table Reuniones change Id_Reun Id_Reun int auto_increment ;
alter table Asiste change Id_Asis Id_Asis int auto_increment ;


/*Ingresar Datos*/
insert into Alumno values (15240564,5,'Argel');

insert into Creditos(Concepto, Fecha, No_Control_FK) values ('Apoyo institucional','2017/12/4',15240564);
insert into Creditos(Concepto, Fecha, No_Control_FK) values ('Apoyo institucional','2017/12/3',15240564);
insert into Creditos(Concepto, Fecha, No_Control_FK) values ('Apoyo institucional','2017/12/2',15240564);
insert into Creditos(Concepto, Fecha, No_Control_FK) values ('Apoyo institucional','2017/12/1',15240564);

/*select * from creditos;*/

/*insert into Reuniones(Nombre_Tutor,Lugar,Motivo,Fecha, Hora, Comentarios, No_Control_FK) 
values ('Ferndando moreno','Edificio D','Primera reunion','2017/12/04','04:17','',15241246);*/

/*select Semestre, Nombre, count(Id_cre) 
from Alumno a join Creditos c
where a.No_Control = c.No_Control_FK and a.No_Control =15240564; */


