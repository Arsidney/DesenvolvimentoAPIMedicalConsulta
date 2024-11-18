INSERT INTO USUARIOS (NOME_USUARIO, EMAIL, CPF, TELEFONE, DATANASCIMENTO, PERMISSAO)
VALUES ('ArsidneyMartins', 'arsidney@gmail.com', '10020035000', '83988889999', '1985-10-15', 'ADMIN'),
('Fulano', 'fulano@gmail.com', '22233355545', '83988558855', '1991-02-02', 'SECRETARIO'),
('Cicrano', 'cidrano@gmail.com', '11133355544', '83955664455', '1980-03-03', 'PACIENTE');


INSERT INTO CONSULTAS(DATA_CONSULTA, PROFISSIONAL, ESPECIALIDADE, DESCRICAO, ID_USUARIO)
VALUES ('2024-10-28', 'Dr João','Cardiologista', 'Exemplo de descricao', 3),
('2024-10-29', 'Dra. Maria', 'Nutricionista', 'Exemplo descricao', 3);
