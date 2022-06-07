create schema forum_app;

set search_path to forum_app;


CREATE TABLE app_users (
  id int generated always as identity primary key,
  username varchar unique NOT NULL check(length(username) >= 4),
  password varchar NOT NULL check(length(password) >= 7),
,
  

);





