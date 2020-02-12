/*==============================================================*/
/* Tabela Users                                                 */
/*==============================================================*/

SET IDENTITY_INSERT Users ON
INSERT INTO [Users]
  ([id],[username],[password],[email],[isAdmin])
VALUES(1, 'douglas.correia', '123456', 'douglas.correia@iteris.com.br', 1);
INSERT INTO [Users]
  ([id],[username],[password],[email],[isAdmin])
VALUES(2, 'nina', '123456', 'nina@iteris.com.br', 1);
INSERT INTO [Users]
  ([id],[username],[password],[email],[isAdmin])
VALUES(3, 'roney', '123456', 'roney@iteris.com.br', 1);
INSERT INTO [Users]
  ([id],[username],[password],[email],[isAdmin])
VALUES(4, 'jean', '123456', 'jean@iteris.com.br', 1);
INSERT INTO [Users]
  ([id],[username],[password],[email],[isAdmin])
VALUES(5, 'victor', '123456', 'victor@iteris.com.br', 1);


/*==============================================================*/
/* Tabela Rooms                                                 */
/*==============================================================*/
SET IDENTITY_INSERT Rooms ON
INSERT INTO Rooms
  (colNum,rowNum)
VALUES(10, 10);

/*==============================================================*/
/* Table Sessions (ATENÇÃO, RODAR O INSERT DE FILME ANTES)      */
/*==============================================================*/
insert into SessionsMovie
  ([dateSession],[idMovie],[idRoom])
values
  ('20120618 10:34:09', 1, 1);
insert into SessionsMovie
  ([dateSession],[idMovie],[idRoom])
values
  ('20120618 22:34:09', 1, 1);
insert into SessionsMovie
  ([dateSession],[idMovie],[idRoom])
values
  ('20120618 16:34:09', 1, 1);

/*==============================================================*/
/* Table Tikects (ATENÇÃO, RODAR O INSERT DE USER E SESSAO ANTES)*/
/*==============================================================*/
insert into Tickets
  (idUser,idSessionMovie,seatColunm,seatRow)
values
  (1, 1, 5, 5);
insert into Tickets
  (idUser,idSessionMovie,seatColunm,seatRow)
values
  (2, 2, 3, 5);
insert into Tickets
  (idUser,idSessionMovie,seatColunm,seatRow)
values
  (3, 3, 8, 5);
insert into Tickets
  (idUser,idSessionMovie,seatColunm,seatRow)
values
  (4, 1, 1, 1);


