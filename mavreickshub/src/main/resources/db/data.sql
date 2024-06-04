truncate table users cascade;
truncate table media cascade;
insert into users(id, email, password, time_created) values
        (200, 'johndoe@gmail.com', 'password', '2024-06-04T15:03:03.792009700' ),
       (201, 'jamesdoe@gmail.com', 'password', '2024-06-04T15:03:03.792009700' ),
       (202, 'janedoe@gmail.com', 'password', '2024-06-04T15:03:03.792009700' ),
       (203, 'johnnydoe@gmail.com', 'password', '2024-06-04T15:03:03.792009700');

insert into media(id, category, description, url, time_created) values
    (100,  'ROMANCE', 'media 0', 'https://www.cloudinary.com/media1', '2024-06-04T15:03:03.792009700'),
    (101,  'ROMANCE','media 1', 'https://www.cloudinary.com/media2', '2024-06-04T15:03:03.792009700'),
     (102,  'ACTION', 'media 2', 'https://www.cloudinary.com/media3', '2024-06-04T15:03:03.792009700'),
      (103,  'ROMANCE', 'media 3', 'https://www.cloudinary.com/media4', '2024-06-04T15:03:03.792009700'),
      (104,  'ACTION', 'media 4', 'https://www.cloudinary.com/media5', '2024-06-04T15:03:03.792009700');