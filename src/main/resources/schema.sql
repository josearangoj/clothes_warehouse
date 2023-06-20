create table if not exists item_model (
  id identity,
  brand varchar(50),
  year_of_creation int not null,
  price int not null,
  created_at timestamp not null
);