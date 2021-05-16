/*The default password for Admin = admin
  The Default password for User = user
  Encrypted by BCrypt */
INSERT INTO users (name, email, password, registered)
VALUES ('User', 'user@gmail.com', '$2a$10$6WZL2gzFrQZ3TXuZi0ClQektYMypL7wvQvNRW04Q2YkeEVMjcvkOS', '2020-03-30 17:00:00'),
       ('Admin', 'admin@gmail.com', '$2a$10$TnuLvKiSOudIoIESqRPbbukqwib.qNxzz8qRdjRgNlK8QAlFObd.i', '2018-11-25 19:00:00');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100001);

INSERT INTO restaurants (name, rest_admin_id, address, description, register_date, img_url)
VALUES ('Chez Marlene', '100001', '58 avenue de Paris', 'French Cuisine', '2020-03-30 10:00:00', 'resources/images/placeholder_restaurant_pic.jpg'),
       ('Chez Antoine', '100001', '93 rue de Versailles', 'Creperie', '2018-05-28 11:00:00', 'resources/images/placeholder_restaurant_pic.jpg'),
       ('La Belle Epoque', '100000', '10 Place de la Mairie', 'French Cuisine', '2017-03-28 12:00:00', 'resources/images/placeholder_restaurant_pic.jpg'),
       ('La Veranda', '100000', '1 Boulevard de la Reine', 'European Cuisine', '2016-05-28 13:00:00', 'resources/images/placeholder_restaurant_pic.jpg'),
       ('Le Sept', '100000', '7 Rue de Montreuil', 'European Cuisine', '2015-05-27 14:00:00', 'resources/images/placeholder_restaurant_pic.jpg'),
       ('La Table du 11', '100001', '8 Rue de la Chancellerie', 'French Cuisine', '2017-05-13 15:00:00', 'resources/images/placeholder_restaurant_pic.jpg'),
       ('Chez Tiouiche', '100001', '4 Rue Saint-Julien', 'Creperie', '2018-05-28 16:00:00', 'resources/images/placeholder_restaurant_pic.jpg'),
       ('Cheval Rouge', '100001', 'Place de la Loi', 'English Cuisine', '2020-11-15 17:00:00', 'resources/images/placeholder_restaurant_pic.jpg');

INSERT INTO menus (rest_id, creation_date, description, img_url)
VALUES (100002, '2020-03-30 12:00:00', 'French Lunch Menu', 'resources/images/placeholder_menu_pic.jpg'),
       (100003, '2020-03-30 17:00:00', 'Crepes', 'resources/images/placeholder_menu_pic.jpg'),
       (100004, '2020-03-30 10:00:00', 'English Lunch Menu', 'resources/images/placeholder_menu_pic.jpg'),
       (100005, '2020-03-30 10:00:00', 'English Breakfast Menu', 'resources/images/placeholder_menu_pic.jpg'),
       (100006, '2020-03-30 10:00:00', 'French Lunch Menu', 'resources/images/placeholder_menu_pic.jpg'),
       (100007, '2020-03-30 10:00:00', 'English Dinner Menu', 'resources/images/placeholder_menu_pic.jpg'),
       (100008, '2020-03-30 10:00:00', 'English Breakfast Menu', 'resources/images/placeholder_menu_pic.jpg'),
       (100009, '2020-03-30 10:00:00', 'Crepes', 'resources/images/placeholder_menu_pic.jpg');

INSERT INTO likes_of_menu (menu_id, user_id, creation_date)
VALUES (100010, 100000, (TO_TIMESTAMP('2021-05-01 07:00.00', 'YYYY-MM-DD HH24:MI:SS.FF'))),
       (100017, 100001, (TO_TIMESTAMP('2021-05-01 08:00.00', 'YYYY-MM-DD HH24:MI:SS.FF')));

INSERT INTO likes_of_restaurant (rest_id, user_id, creation_date)
VALUES (100005, 100001, (TO_TIMESTAMP('2021-05-01 07:00.00', 'YYYY-MM-DD HH24:MI:SS.FF')));


