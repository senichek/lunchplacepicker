DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS menus cascade ;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS likes;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR                           NOT NULL,
    email      VARCHAR                           NOT NULL,
    password   VARCHAR                           NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name          VARCHAR                           NOT NULL,
    rest_admin_id      INTEGER                           NOT NULL,
    address       VARCHAR                           NOT NULL,
    description   VARCHAR                           NOT NULL,
    register_date TIMESTAMP           DEFAULT now() NOT NULL,
    FOREIGN KEY (rest_admin_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE menus
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    rest_id     INTEGER   NOT NULL,
    creation_date   TIMESTAMP NOT NULL,
    description TEXT      NOT NULL,
    FOREIGN KEY (rest_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE likes
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    menu_id     INTEGER   NOT NULL,
    user_id    INT       NOT NULL,
    creation_date   TIMESTAMP DEFAULT now() NOT NULL,
    FOREIGN KEY (menu_id) REFERENCES menus (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX unique_userLike_per_menu_idx ON likes (user_id, menu_id);
