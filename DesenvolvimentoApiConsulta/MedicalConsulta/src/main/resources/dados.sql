INSERT INTO USUARIOS(NOMEUSUARIO, EMAIL, CPF, TELEFONE, DATANASCIMENTO, PERMISSAO)
VALUES ('Fulano', 'fulano@email.com','12345678910', '83123456789', '2000-09-07', 'ADMIN'),
('Beltrano', 'beltrano@email.com','12345678910', '83123456789', '2000-09-07', 'SECRETARIO'),
('Sicrano', 'sicrano@email.com','12345678910', '83123456789', '2000-09-07', 'PACIENTE');
INSERT INTO CONSULTAS(DATA_CONSULTA, PROFISSIONAL, ESPECIALIDADE, id_Usuario)
VALUES ('2024-10-28', 'Dr.João', 'Cardiologia', 1);