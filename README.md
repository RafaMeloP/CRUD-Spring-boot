# Cadastro de funcionários

Aplicação para cadastro, exclusão e edição de funcionários utilizando Api feita com Spring-boot.

## Api
### Retornar uma lista de todos os funcionários

`GET` https://api-cadastro-funcionario.herokuapp.com/funcionario.
```javascript
[
  {
    id: 0,
    firstName: "Rafael",
    lastName: "Pereira",
    email: "rafaelrodmelo26@gmail.com"
  },
  {
    id: 1,
    firstName: "João",
    lastName: "Silva",
    email: "joao@gmail.com"
  }
]
```

### Retornar funcionário pelo id

`GET` https://api-cadastro-funcionario.herokuapp.com/funcionario/{ id }.
```javascript
{
  id: 0,
  firstName: "Rafael",
  lastName: "Pereira",
  email: "rafaelrodmelo26@gmail.com"
}
```

### Retornar funcionário pelo nome

`GET` https://api-cadastro-funcionario.herokuapp.com/funcionario/name/{ name }.
```javascript
{
  id: 0,
  firstName: "Rafael",
  lastName: "Pereira",
  email: "rafaelrodmelo26@gmail.com"
}
```
### Salvar novo funcionário

`POST` https://api-cadastro-funcionario.herokuapp.com/funcionario

```javascript
{
  firstName: String,
  lastName: String,
  email: String
}
```
### Editar funcionário já salvo

`PUT` https://api-cadastro-funcionario.herokuapp.com/funcionario/{ id }

```javascript
{
  firstName: String,
  lastName: String,
  email: String
}
```
### Excluir funcionário

`Delete` https://api-cadastro-funcionario.herokuapp.com/funcionario/{ id }
