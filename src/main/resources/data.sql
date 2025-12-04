INSERT INTO planets (name, type, radius_km, mass_kg, orbital_period_days)
VALUES
    ('Mercury', 'Terrestrial', 2440, 33, 88),
    ('Venus', 'Terrestrial', 6052, 487, 225),
    ('Earth', 'Terrestrial', 6371, 597, 365),
    ('Mars', 'Terrestrial', 3390, 64, 687),
    ('Jupiter', 'Gas Giant', 69911, 190000, 4331),
    ('Saturn', 'Gas Giant', 58232, 56800, 10747);
INSERT INTO moons (name, diameter_km, orbital_period_days, planet_id)
VALUES
    ('Moon', 3474, 27, 3),

    ('Phobos', 22, 1, 4),
    ('Deimos', 12, 1, 4),

    ('Io', 3643, 2, 5),
    ('Europa', 3122, 4, 5),
    ('Ganymede', 5268, 7, 5),
    ('Callisto', 4821, 17, 5),

    ('Titan', 5150, 16, 6),
    ('Enceladus', 504, 1, 6);
INSERT INTO users (name, password, role, enabled)
VALUES
    ('Admin', '$2a$10$79i0SCydI6eAkQAS8n.ufusPPW953LpaqeCWEA8zP1U0g/GZN1S9G', 'ADMIN', true), -- password
    ('Staff', '$2a$10$79i0SCydI6eAkQAS8n.ufusPPW953LpaqeCWEA8zP1U0g/GZN1S9G', 'STAFF', true),
    ('Student', '$2a$10$79i0SCydI6eAkQAS8n.ufusPPW953LpaqeCWEA8zP1U0g/GZN1S9G', 'STUDENT', true),
    ('Disabled', '$2a$10$79i0SCydI6eAkQAS8n.ufusPPW953LpaqeCWEA8zP1U0g/GZN1S9G', 'STUDENT', false);