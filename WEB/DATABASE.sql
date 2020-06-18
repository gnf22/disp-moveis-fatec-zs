/*Script criado para a disciplina de Dispositivos Móveis
Aluno: Gustavo Nascimento Ferreira
R.A: 1370481811023
*/

/*Criação do Banco de Dados "db2020"*/
create database db2020;

/*Criação da tabela "Aluno" */
create table db2020.aluno (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  sexo VARCHAR(10),
  idade VARCHAR(3),
  cpf VARCHAR(20),
  primary key (id));
  
  /*Criação da tabela "Instituição" */
  create table db2020.instituicao (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  ano_fund VARCHAR(4),
  endereco VARCHAR(255),
  primary key (id));
  
  /*Criação da Tabela "Aluno-Instituição" */
  create table db2020.aluno_instituicao (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idAlu BIGINT,
  idIns BIGINT, 
  observacao VARCHAR(255),
  primary key (id));
  
  /*Criação da Tabela "Usuário" */
  create table db2020.usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (id));
  
  /*Criação das Chaves Estrangeiras*/
  ALTER TABLE db2020.aluno_instituicao ADD CONSTRAINT FK_ALU_INS_ID FOREIGN KEY (IDALU) REFERENCES db2020.ALUNO (ID);
  ALTER TABLE db2020.aluno_instituicao ADD CONSTRAINT FK_INS_ALU_ID FOREIGN KEY (IDINS) REFERENCES db2020.INSTITUICAO (ID);
