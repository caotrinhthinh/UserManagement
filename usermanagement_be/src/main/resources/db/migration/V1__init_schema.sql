-- ==============================
-- USERS TABLE
-- ==============================
CREATE TABLE users (
    id CHAR(36) PRIMARY KEY,
    username VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE,
    password VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    dob DATE
);

-- ==============================
-- ROLES TABLE
-- ==============================
CREATE TABLE role (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description VARCHAR(255)
);

-- ==============================
-- PERMISSIONS TABLE
-- ==============================
CREATE TABLE permission (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(255)
);

-- ==============================
-- USER_ROLES M:N RELATION
-- ==============================
CREATE TABLE user_roles (
    user_id CHAR(36),
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES role(id)
);

-- ==============================
-- ROLE_PERMISSIONS M:N RELATION
-- ==============================
CREATE TABLE role_permission (
    role_id BIGINT,
    permission_id BIGINT,
    PRIMARY KEY (role_id, permission_id),
    CONSTRAINT fk_role_permission_role FOREIGN KEY (role_id) REFERENCES role(id),
    CONSTRAINT fk_role_permission_permission FOREIGN KEY (permission_id) REFERENCES permission(id)
);

-- ==============================
-- INVALIDATED TOKENS TABLE
-- ==============================
CREATE TABLE invalidated_token (
    id VARCHAR(255) PRIMARY KEY,
    expiry_time TIMESTAMP
);
