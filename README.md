# Meeting
Api Rest para gerenciamento de sessões de votação.

## Instalação Rápida

**1. Instalar Git**

**2. Instalar Docker**

**3. Instalar Docker compose**

**4. Clonar a aplicação**
```bash
git clone https://github.com/meloafc/meeting.git
```
**5. Navegar para a aplicação clonada**
```bash
cd meeting
```
**6. Executar o docker compose**
```bash
docker-compose up --build
```

O docker irá instalar e configurar todas as dependências necessárias para executar a aplicação, depois de alguns segundos a aplicação estará execultando em:

+ api: <http://localhost:8080/swagger-ui.html>

## Instalação Manual
### Requisitos backend

1. Java - 1.8.x
2. Maven - 3.x.x
3. Mysql - 5.x.x

### Etapas para a instalação

**1. Clonar a aplicação**

```bash
git clone https://github.com/meloafc/meeting.git
```

**2. Configurar o Mysql**
```bash
create database meeting
```

**3. Configurar usuário e senha do Mysql**

+ Abrir `pom.xml`

+ Trocar `DATASOURCE.URL`, `DATASOURCE.USERNAME` e `DATASOURCE.PASSWORD` por sua configuração.

**4. Executar o backend**

```bash
cd estacionamento/backend
mvn spring-boot:run
```

ou
```bash
cd estacionamento/backend
mvn spring-boot:run -DDATASOURCE.URL=jdbc:mysql://localhost:3306/meeting?useSSL=false -DDATASOURCE.USERNAME=root -DDATASOURCE.PASSWORD=root
```

O backend começará a ser executado em <http://localhost:8080/swagger-ui.html>.

### Tecnologias utilizadas
+ Spring boot
+ Mysql
+ Docker