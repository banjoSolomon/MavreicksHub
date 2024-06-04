truncate table users cascade;
truncate table media cascade;
insert into users(id, email, password, time_created) values
                                                         (200, 'johndoe@gmail.com', 'password', '2024-06-04T15:03:03.792009700' ),
                                                         (201, 'jamesdoe@gmail.com', 'password', '2024-06-04T15:03:03.792009700' ),
                                                         (202, 'janedoe@gmail.com', 'password', '2024-06-04T15:03:03.792009700' ),
                                                         (203, 'johnnydoe@gmail.com', 'password', '2024-06-04T15:03:03.792009700');

insert into media(id, category, description, url, time_created) values
                                                                    (100, 0, 'media 1', 'https://www.cloudinary.com/media1', '2024-06-04T15:03:03.792009700'),
                                                                    (101, 1, 'media 2', 'https://www.cloudinary.com/media2', '2024-06-04T15:03:03.792009700'),
                                                                    (102, 2, 'media 3', 'https://www.cloudinary.com/media3', '2024-06-04T15:03:03.792009700'),
                                                                    (103, 3, 'media 4', 'https://www.cloudinary.com/media4', '2024-06-04T15:03:03.792009700'),
                                                                    (104, 4, 'media 5', 'https://www.cloudinary.com/media5', '2024-06-04T15:03:03.792009700');;