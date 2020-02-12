
/*==============================================================*/
/* Database: dbTicketStore                                       */
/*==============================================================*/

create database dbTicketStore;
go

use dbTicketStore;
go

/*==============================================================*/
/* Table: movies                                                */
/*==============================================================*/
create table Movies (
   id                   int                  identity,
   title                nvarchar(100)        not null,
   photo                nvarchar(255)        not null,
   category             nvarchar(100)        not null,
   plot                 nvarchar(1000)        not null,
   director             nvarchar(100)        not null,
   writer               nvarchar(100)        not null,
   yearOfCreation		int 				 not null
   constraint PK_MOVIE primary key (id)
)
go

/*==============================================================*/
/* Index: IndexMoviesCategory                                     */
/*==============================================================*/
create index IndexMovieCategory on Movies (
category ASC
)
go

/*==============================================================*/
/* Table: "SessionsMovie"                                               */
/*==============================================================*/
create table SessionsMovie (
   id                   int                  identity,
   dateSession          datetime             not null,
   idMovie              int                  not null,
   idRoom               int                  not null
   constraint PK_SESSION primary key (id)
)
go

/*==============================================================*/
/* Index: IndexSessionId                                  */
/*==============================================================*/
create index IndexSessionMovieId on "SessionsMovie" (
idMovie ASC
)
go

/*==============================================================*/
/* Index: IndexOrderOrderDate                                   */
/*==============================================================*/
create index IndexSessionDate on SessionsMovie (
dateSession ASC
)
go

/*==============================================================*/
/* Table: Ticket                                                */
/*==============================================================*/
create table Tickets (
   id                   int                  identity,
   idUser               int                  not null,
   idSessionMovie       int                  not null,
   seatRow              int                  not null,
   seatColunm           int                  not null,
   constraint PK_Ticket primary key (id)
)
go

/*==============================================================*/
/* Index: IndexOrderItemOrderId                                 */
/*==============================================================*/
create index IndexTicketIdSession on Tickets (
idSessionMovie ASC
)
go


/*==============================================================*/
/* Table: Product                                               */
/*==============================================================*/
create table Rooms (
   id                   int                  identity,
   rowNum               int                  not null,
   colNum               int                  not null,
   constraint PK_ROOM primary key (id)
)
go

/*==============================================================*/
/* Table: Users                                              */
/*==============================================================*/
create table Users (
   id                   int                  identity,
   username             nvarchar(100)        not null,
   [password]             nvarchar(100)        not null,
   email                nvarchar(100)        not null,
   isAdmin              bit default 0        not null,
   constraint PK_User primary key (id)
)
go


/*==============================================================*/
/* Builder FK´s                                                 */
/*==============================================================*/

alter table "SessionsMovie"
   add constraint FK_SESSIONS_REFERENCE_MOVIE foreign key (idMovie)
      references Movies (id)
go

alter table "SessionsMovie"
   add constraint FK_SESSIONS_REFERENCE_ROOM foreign key (idRoom)
      references Rooms (id)
go

alter table Tickets
   add constraint FK_TICKET_REFERENCE_USER foreign key (idUser)
      references Users (id)
go

alter table Tickets
   add constraint FK_TICKET_REFERENCE_SESSION foreign key (idSessionMovie)
      references SessionsMovie (id)
go

