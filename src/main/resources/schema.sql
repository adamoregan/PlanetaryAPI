CREATE TABLE users (
                          name VARCHAR(255) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          role ENUM('ADMIN', 'STAFF', 'STUDENT') NOT NULL,
                          enabled BOOLEAN NOT NULL DEFAULT TRUE,
                          created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                          updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE planets (
                          planet_id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255),
                          type VARCHAR(255),
                          radius_km INT,
                          mass_kg INT,
                          orbital_period_days INT
);

CREATE TABLE moons (
                          moon_id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255),
                          diameter_km INT,
                          orbital_period_days INT,
                          planet_id INT,
                          FOREIGN KEY (planet_id) REFERENCES planets(planet_id)
                              ON DELETE CASCADE
                              ON UPDATE CASCADE
);
