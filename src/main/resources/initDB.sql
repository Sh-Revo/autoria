CREATE TABLE categories
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value)
);

alter table categories owner to postgres;

CREATE TABLE categories_body
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value),
	category_id int,
	foreign key(category_id) references categories(value)
);

alter table categories_body owner to postgres;

CREATE TABLE brand
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value),
	category_id int,
	foreign key(category_id) references categories(value)
);

alter table brand owner to postgres;

CREATE TABLE model
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value)
);

alter table model owner to postgres;

CREATE TABLE region
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value)
);

alter table region owner to postgres;

CREATE TABLE city
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value),
	region_id int,
	foreign key(region_id) references region(value);
);

alter table city owner to postgres;

CREATE TABLE drive_type
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value),
	category_id int,
	foreign key(category_id) references categories(value)
);

alter table drive_type owner to postgres;

CREATE TABLE fuel_type
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value)
);

alter table fuel_type owner to postgres;

CREATE TABLE gearbox
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value),
	category_id int,
	foreign key(category_id) references categories(value)
);

alter table gearbox owner to postgres;

CREATE TABLE option
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value),
	category_id int,
	foreign key(category_id) references categories(value)
);

alter table option owner to postgres;

CREATE TABLE color
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value)
);

alter table color owner to postgres;

CREATE TABLE country
(
    value int,
    name  varchar NOT NULL,
	PRIMARY KEY(value)
);

alter table country owner to postgres;