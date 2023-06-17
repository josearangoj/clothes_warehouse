create table if not exists items (
  id identity,
  brand varchar(50),
  yearOfCreation int not null,
  price int not null
);