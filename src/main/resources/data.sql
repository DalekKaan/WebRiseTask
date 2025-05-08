
INSERT INTO subscriptions(id, name)
VALUES ('fb262d1a-5d77-4d45-a271-ad78375e6cef', 'YouTube'),
    ('325030ed-8163-4e6f-87a9-a6ca8ac1df92', 'VK'),
    ('1d9d89bd-621e-4837-81f4-7ff975cbf865', 'Netflix'),
    ('ebe4d182-da23-4238-96b5-6324132fec20', 'Yandex');

INSERT INTO users (day_of_born, id, email, name, subscriptions)
VALUES (
        '1990-05-01',
        'fb262d1a-5d77-4d45-a271-ad78375e6cef',
        'a.gustov@gmail.com',
        'Alex Gustov',
        '["fb262d1a-5d77-4d45-a271-ad78375e6cef", "325030ed-8163-4e6f-87a9-a6ca8ac1df92"]'
    ),
    (
          '1990-04-07',
          '924a3173-e11b-4900-a875-6458ce4f309d',
          'j.smith@gmail.com',
          'John Smith',
          '["fb262d1a-5d77-4d45-a271-ad78375e6cef", "ebe4d182-da23-4238-96b5-6324132fec20"]'
    ),
    (
        '1991-02-11',
        '0db037e2-b87b-4999-93bc-15390430be9c',
        'i.karkarov@gmail.com',
        'Igor Karkarov',
        '["fb262d1a-5d77-4d45-a271-ad78375e6cef", "325030ed-8163-4e6f-87a9-a6ca8ac1df92", "ebe4d182-da23-4238-96b5-6324132fec20"]'
    );
