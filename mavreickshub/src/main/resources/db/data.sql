truncate table users cascade;
truncate table media cascade;
insert into users(id, email, password, time_created) values
        (200, 'johndoe@gmail.com', '$2a$10$K3mHUEliZkX/5Vtf9o50LeYTDm8kp43GpI7XIcb.HThPIO3oFCibW', '2024-06-04T15:03:03.792009700' ),
       (201, 'jamesdoe@gmail.com', '$2a$10$K3mHUEliZkX/5Vtf9o50LeYTDm8kp43GpI7XIcb.HThPIO3oFCibW', '2024-06-04T15:03:03.792009700' ),
       (202, 'janedoe@gmail.com', '$2a$10$K3mHUEliZkX/5Vtf9o50LeYTDm8kp43GpI7XIcb.HThPIO3oFCibW', '2024-06-04T15:03:03.792009700' ),
       (203, 'johnnydoe@gmail.com', '$2a$10$K3mHUEliZkX/5Vtf9o50LeYTDm8kp43GpI7XIcb.HThPIO3oFCibW', '2024-06-04T15:03:03.792009700');

insert into media(id, category, description, url, time_created, uploader_id) values
    (100,  'ROMANCE', 'media 0', 'https://www.cloudinary.com/media1', '2024-06-04T15:03:03.792009700', 200),
    (101,  'ROMANCE','media 1', 'https://www.cloudinary.com/media2', '2024-06-04T15:03:03.792009700', 200),
     (102,  'ACTION', 'media 2', 'https://www.cloudinary.com/media3', '2024-06-04T15:03:03.792009700', 201),
      (103,  'ROMANCE', 'media 3', 'https://www.cloudinary.com/media4', '2024-06-04T15:03:03.792009700', 200),
      (104,  'ACTION', 'media 4', 'https://www.cloudinary.com/media5', '2024-06-04T15:03:03.792009700', 201);