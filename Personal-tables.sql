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

--Crates user roles
insert into user_roles (role_name) values ('Member'), ('free_to_Play'), ('Player_Moderator'), ('Admin'), ('Dev');

--creates a new forum user
insert into app_users (first_name, last_name, email, username, password, role_id)
values
    ('Patrick', 'Starfish', 'Underthesea@pineapple.com', 'ThisisPatrick', 'Starfishpass', 2),
    ('Jack', 'Rosen', 'Blainthepain@aol.com', 'Vaertox', 'Incedus', 5),
    ('Kris', 'Tran', 'Coolplace@hotmail.com', 'Seiyran', 'Dog1234', 3),
    ('Mike', 'Hunt', 'Dontreadme@places.com', 'Gucci', 'Cat4321', 2),
    ('Jenna', 'Tools', 'Whyyou@dothis.com', 'Hehehehe', 'dogsncats', 1),
    ('Haywood', 'Jahblowme', 'Sketchy@perhaps.com', 'Sounder', 'Blaster', 2),
    ('Zezima', 'Whodat', 'Srslyspam@aol.com', 'Zezima', 'abc1234', 4);


