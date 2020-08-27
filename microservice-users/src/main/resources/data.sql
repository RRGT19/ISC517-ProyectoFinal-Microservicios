/*Roles*/
INSERT INTO roles (role_id, role) VALUES (1, 'ADMIN');
INSERT INTO roles (role_id, role) VALUES (2, 'EMPLOYEE');
INSERT INTO roles (role_id, role) VALUES (3, 'CLIENT');

/*Users*/
INSERT INTO users (name, password, username, email, created_at)
  values ('Admin Account', '123456', 'admin', 'admin@gmail.com', TO_DATE('15/08/2020', 'DD/MM/YYYY'));

INSERT INTO user_role (user_id, role_id) values (1, 1);
