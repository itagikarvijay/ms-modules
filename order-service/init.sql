-- Create roles table
CREATE TABLE IF NOT EXISTS role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    enabled BOOLEAN DEFAULT TRUE
);

-- Create user_roles join table
CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE
);

-- Seed roles
INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');

-- Seed users (plain text passwords for dev only)
INSERT INTO users (username, password, email, enabled)
VALUES ('vijay', '{noop}vijay123', 'john@example.com', TRUE);

INSERT INTO users (username, password, email, enabled)
VALUES ('admin', '{noop}admin123', 'admin@example.com', TRUE);

-- Assign roles
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- john → ROLE_USER
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- admin → ROLE_ADMIN