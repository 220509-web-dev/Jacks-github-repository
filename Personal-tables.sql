create schema foundation_app;

set search_path to foundation_app;

CREATE TABLE user_roles (
    id int generated always as identity primary key,
    role_name varchar not null unique
);

CREATE TABLE app_users (
  id int generated always as identity primary key,
  first_name varchar NOT NULL,
  last_name varchar NOT NULL,
  email varchar unique NOT NULL,
  username varchar unique NOT NULL check(length(username) >= 4),
  password varchar NOT NULL check(length(password) >= 7),
  role_id int default 1,
  
  constraint app_users_fk
  foreign key (role_id)
  references user_roles(id)
);