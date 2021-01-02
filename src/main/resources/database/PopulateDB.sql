INSERT INTO users (name, email, password, registered)
VALUES ('User', 'user@gmail.com', 'user', '2020-03-30 17:00:00'),
       ('Admin', 'admin@gmail.com', 'admin', '2018-11-25 19:00:00');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100001);

INSERT INTO restaurants (name, admin_id, address, description, register_date)
VALUES ('Chez Marlene', '100001', 'avenue de Paris', 'French Cuisine', '2020-03-30 10:00:00'),
       ('Chez Antoine', '100001', 'rue de Versailles', 'Creperie', '2018-05-28 11:00:00'),
       ('Cheval Rouge', '100001', 'Place de la Loi', 'English Cuisine', '2019-11-15 13:00:00');

INSERT INTO menus (rest_id, creation_date, description)
VALUES (100002, '2020-03-30 10:00:00', 'French Lunch Menu'),
       (100003, '2020-03-30 10:00:00', 'Crepes'),
       (100004, '2020-03-30 10:00:00', 'English Lunch Menu');

INSERT INTO likes (menu_id, user_id)
VALUES (100005, 100000),
       (100007, 100001);


