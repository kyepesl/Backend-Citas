INSERT INTO usuarios (correo, password, nombre, apellido) VALUES ('kyepesl16@gmail.com','$2a$10$pgBs/3Iwe30KOjM.VJU79ecbhzCq/I6NhynO9fi1Jo0/MQYEMcPa.', 'Karen', 'Yepes');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO estados_citas (nombre) VALUES ('Aceptada');
INSERT INTO estados_citas (nombre) VALUES ('Rechazada');
INSERT INTO estados_citas (nombre) VALUES ('Pendiente por aprobación');
INSERT INTO estados_citas (nombre) VALUES ('Completada');

INSERT INTO tipos_citas (nombre) VALUES ('Urgencia');
INSERT INTO tipos_citas (nombre) VALUES ('Vacunación');
INSERT INTO tipos_citas (nombre) VALUES ('Revisión');
INSERT INTO tipos_citas (nombre) VALUES ('Desparasitación');
INSERT INTO tipos_citas (nombre) VALUES ('Vacunación y desparasitación');

INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1, 2);
