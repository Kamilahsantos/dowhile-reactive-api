# dowhile-reactive-api
Projeto desenvolvido para o workshop do evento dowhile da rocketseat

## ⚙ Tecnologias

- Java
- Spring WebFlux
- Spring Data Reactive MongoDB

## 📥 Executar esse projeto no seu computador

- clone esse repositório: 
- instale as dependências (necessário java e maven instalado)

 ### Para conectar com o mongodb utilizando o docker (banco de dados utilizado na aplicação):

baixar a imagem do mongodb:
 ```
 docker pull mongo
 ```

rodar o container do mongodb
 ```
 docker run --name mongodb -p 27017:27017 -d mongo
 ```

verificar os processos em execução
```
docker ps
```

- execute a classe Main: ProjetoApplication

