INSERT INTO users (name, email, password)
VALUES ('User', 'user@gmail.com', 'user'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100001);

INSERT INTO restaurants (name, address, description, register_date)
VALUES ('Chez Marlene', 'avenue de Paris', 'French Cuisine', '2020-03-30 10:00:00'),
       ('Chez Antoine', 'rue de Versailles', 'Creperie', '2018-05-28 11:00:00'),
       ('Cheval Rouge', 'Place de la Loi', 'English Cuisine', '2019-11-15 13:00:00');

INSERT INTO menus (rest_id, creation_date, description)
VALUES (100002, '2020-03-30 10:00:00', 'French Lunch Menu'),
       (100003, '2020-03-30 10:00:00', 'Crepes'),
       (100004, '2020-03-30 10:00:00', 'English Lunch Menu');

INSERT INTO likes (menu_id, user_id)
VALUES (100005, 100000),
       (100007, 100001);


