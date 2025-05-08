
INSERT INTO subscriptions(id, name)
VALUES ('fb262d1a-5d77-4d45-a271-ad78375e6cef', 'YouTube'),
    ('325030ed-8163-4e6f-87a9-a6ca8ac1df92', 'VK'),
    ('1d9d89bd-621e-4837-81f4-7ff975cbf865', 'Netflix'),
    ('ebe4d182-da23-4238-96b5-6324132fec20', 'Yandex');

INSERT INTO users (day_of_born, id, email, name)
VALUES (
        '1990-05-01',
        'fb262d1a-5d77-4d45-a271-ad78375e6cef',
        'a.gustov@gmail.com',
        'Alex Gustov'
    ),
    (
          '1990-04-07',
          '924a3173-e11b-4900-a875-6458ce4f309d',
          'j.smith@gmail.com',
          'John Smith'
    ),
    (
        '1991-02-11',
        '0db037e2-b87b-4999-93bc-15390430be9c',
        'i.karkarov@gmail.com',
        'Igor Karkarov'
    );

INSERT INTO users_subscriptions (subscriptions_id, user_id) VALUES
    ('fb262d1a-5d77-4d45-a271-ad78375e6cef', 'fb262d1a-5d77-4d45-a271-ad78375e6cef'),
    ('1d9d89bd-621e-4837-81f4-7ff975cbf865', 'fb262d1a-5d77-4d45-a271-ad78375e6cef'),
    ('325030ed-8163-4e6f-87a9-a6ca8ac1df92', '924a3173-e11b-4900-a875-6458ce4f309d'),
    ('fb262d1a-5d77-4d45-a271-ad78375e6cef', '924a3173-e11b-4900-a875-6458ce4f309d'),
    ('325030ed-8163-4e6f-87a9-a6ca8ac1df92', '0db037e2-b87b-4999-93bc-15390430be9c'),
    ('fb262d1a-5d77-4d45-a271-ad78375e6cef', '0db037e2-b87b-4999-93bc-15390430be9c');
