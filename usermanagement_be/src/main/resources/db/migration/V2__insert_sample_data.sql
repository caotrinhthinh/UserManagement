-- PERMISSIONS
INSERT INTO permission (id, name, description) VALUES 
  (1, 'READ', 'Read access'),
  (2, 'WRITE', 'Write access'),
  (3, 'DELETE', 'Delete access'),
  (4, 'UPDATE', 'Update access');

-- ROLES
INSERT INTO role (id, name, description) VALUES 
  (1, 'ADMIN', 'Admin role'),
  (2, 'USER', 'User role'),
  (3, 'MANAGER', 'Manager role');

-- ROLE - PERMISSION mappings
INSERT INTO role_permission (role_id, permission_id) VALUES 
  -- ADMIN has all permissions
  (1, 1), (1, 2), (1, 3), (1, 4),
  -- USER has only READ
  (2, 1),
  -- MANAGER has READ, WRITE, UPDATE
  (3, 1), (3, 2), (3, 4);

-- USERS
-- Passwords are all hashed using BCrypt for "admin", "user", "manager"
INSERT INTO users (id, username, password, first_name, last_name) VALUES 
  ('1', 'admin',   '$2a$10$Ism.mWMCdT3hRnTqmJeK3uhRO9U7W5VetGb.GGc6ysC3349nmwVqK', 'Admin', 'Root'),
  ('2', 'user01',  '$2a$10$Ism.mWMCdT3hRnTqmJeK3uhRO9U7W5VetGb.GGc6ysC3349nmwVqK', 'User', 'One'), -- newPassword123
  ('3', 'manager', '$2a$10$Ism.mWMCdT3hRnTqmJeK3uhRO9U7W5VetGb.GGc6ysC3349nmwVqK', 'Manager', 'Boss');

-- USER - ROLE mappings
INSERT INTO user_roles (user_id, role_id) VALUES 
  ('1', 1), -- admin -> ADMIN
  ('2', 2), -- user01 -> USER
  ('3', 3); -- manager -> MANAGER
