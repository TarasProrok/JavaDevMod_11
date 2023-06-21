INSERT INTO client
(name)
VALUES
    ('Alfa'),
    ('Betta'),
    ('Gamma'),
    ('Delta'),
    ('Epsilon'),
    ('Dzeta'),
    ('Eita'),
    ('Teita'),
    ('Yota'),
    ('Kappa'),
    ('Omikron');

INSERT INTO planet
(id, name)
VALUES
    ('EH03', 'Earth'),
    ('MS04', 'Mars'),
    ('VA02', 'Venera'),
    ('UN07', 'Uran'),
    ('PO09', 'Pluto');

INSERT INTO ticket
(created_at, client_id, from_planet_id, to_planet_id)
VALUES
    ('2006-08-06 09:00:59+01', 1, 'EH03', 'MS04'),
    ('2007-09-07 10:00:59+02', 2, 'VA02', 'UN07'),
    ('2008-10-08 11:00:59+03', 3, 'PO09', 'EH03'),
    ('2009-11-09 12:00:59+04', 4, 'MS04', 'VA02'),
    ('2010-12-10 13:00:59+05', 5, 'UN07', 'PO09'),
    ('2011-01-11 14:00:59-05', 6, 'EH03', 'PO09'),
    ('2012-02-12 15:00:59-04', 7, 'VA02', 'MS04'),
    ('2013-03-13 15:00:59-03', 8, 'PO09', 'UN07'),
    ('2014-04-14 15:00:59-02', 9, 'MS04', 'EH03'),
    ('2015-05-05 15:00:59-01', 10, 'UN07', 'VA02');