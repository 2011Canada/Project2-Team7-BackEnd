create schema project2;
set schema 'project2';

create table users(
	userId serial,
	userName VARCHAR(50),
	userPassword VARCHAR(300),
	firstName VARCHAR(100),
	lastName  VARCHAR(100),
	constraint USERS_USERID_PK primary key (userId)
);

create table favorites(
	userId int,
	drinkId int,
	constraint FAVORITES_PK primary key (userId, drinkId),
	constraint FAVORITES_USERID_FK foreign key (userId) references users(userId),
	constraint FAVORITES_DRINKID_FK foreign key (drinkId) references drinks(drinkId)
)

create table drinks(
	drinkId serial,
	drinkName VARCHAR(200),
	drinkDegree int,
	drinkCreator VARCHAR(200),
	constraint DRINKS_DRINKID_PK primary key (drinkId)
)

create table reviews(
	reviewId serial,
	userId int,
	drinkId int,
	description text,
	rate int,
	constraint REVIEW_REVIEWID_PK primary key (reviewId),
	constraint REVIEW_USERID_FK foreign key (userId) references users(userId),
	constraint REVIEW_DRINKID_FK foreign key (drinkId) references drinks(drinkId)
)

create table ingredients(
	ingId serial,
	ingName VARCHAR(200),
	constraint INGREDIENTS_PK primary key (ingId)
)

create table recipes(
	ingId int,
	drinkId int,
	constraint recipes_PK primary key (ingId, drinkId),
	constraint recipes_INGID_FK foreign key (ingId) references ingredients(ingId),
	constraint recipes_DRINKID_FK foreign key (drinkId) references drinks(drinkId)
)

insert into users(userName, userPassword, firstName, lastName)
				values ('dy', '0000','domanic', 'yalda');
				
insert into drinks(drinkcreator,drinkname,drinkdegree)
			values (4, 'JagerBombs', 25 );

select * from users;
select * from drinks;
			