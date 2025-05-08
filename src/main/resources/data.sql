-- todo
INSERT INTO subscriptions(id, name)
VALUES ('fb262d1a-5d77-4d45-a271-ad78375e6cef', 'YouTube'),
    ('325030ed-8163-4e6f-87a9-a6ca8ac1df92', 'VK'),
    ('ebe4d182-da23-4238-96b5-6324132fec20', 'Yandex');

INSERT INTO public.users (day_of_born, id, email, name, subscriptions)
VALUES (
        '2025-05-01',
        '3b04c377-7ff1-487f-989f-4cea69e54f11',
        'a.gustov@gmail.com',
        'Alex Gustov',
        '["1dfb0519-e0be-4f40-8a73-8bd62237127b"]'
    );
