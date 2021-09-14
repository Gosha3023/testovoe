insert into user_model(id, avatar, email, name, status, timestamp) values
    (
        nextval('hibernate_sequence'),
        'http://localhost:8080/api/v1/images/user1.png',
        'user1@mail.ru',
        'user1',
        false ,
        '2021-02-02T20:20:20'
     ),
    (
        nextval('hibernate_sequence'),
        'http://localhost:8080/api/v1/images/user2.png',
         'user2@mail.ru',
         'user2',
         false ,
        '2021-02-02T20:20:20'
    );