create schema inpia_monolith collate utf8_czech_ci;

create table order_form
(
  id          int auto_increment primary key,
  order_state varchar(255) null
);

create table ordered_product
(
  id         int auto_increment primary key,
  amount     int null,
  order_id   int null,
  product_id int null
);

create table product
(
  id   int auto_increment primary key,
  name varchar(255) null
);

