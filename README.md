# Manage People

### API para gerenciar pessoas e seus endereços.

## Métodos
Requisições para a API devem seguir os padrões:

| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |

## Respostas

| Código | Descrição                                                          |
|--------|--------------------------------------------------------------------|
| `200`  | Requisição executada com sucesso (success).                        |
| `201`  | Registro salvo com sucesso.                                        |
| `400`  | Erros de validação ou os campos informados não existem no sistema. |
| `404`  | Registro pesquisado não encontrado (Not found).                    |
| `500`  | Erro inesperado no servidor.                                       |

### createPerson (Create) [POST /api/person]

+ Request (application/json)
    + Body

            {
              "name": "Pessoa da Silva Sauro",
              "birthDate": "1999-02-11",
              "email": "pesssoadasilvasauro@gmail.com",
              "telephone": "11111111111"
            }
  
+ Response 201 (application/json)
    + Body

            {
              "id": 74,
              "name": "Pessoa da Silva Sauro",
              "birthDate": "1999-02-11T00:00:00.000+00:00",
              "email": "pesssoadasilvasauro@gmail.com",
              "telephone": "11111111111"
            }
+ Response 400 (application/json)
   + Body

             {
               "message": "não deve estar em branco",
               "field": "email",
               "status": "BAD_REQUEST"
             }

### editPersonData (Update) [PUT /api/person/74]

+ Request (application/json)
    + Body

            {
              "name": "Fulano",
              "birthDate": "1999-02-01",
              "email": "2105@gmail.com",
              "telephone": "11111111112"
            }

+ Response 201 (application/json)
    + Body

            {
              "id": 74,
              "name": "Fulano",
              "birthDate": "1999-02-01T00:00:00.000+00:00",
              "email": "2105@gmail.com",
              "telephone": "11111111112"
            }
+ Response 400 (application/json)
    + Body

              {
                "message": "não deve estar em branco",
                "field": "email",
                "status": "BAD_REQUEST"
              }

+ Response 404 (application/json)
    + Body

              {
                "message": "Id person not found!",
                "field": "null",
                "status": "NOT_FOUND"
              }

### consultPersonById (Read) [GET /api/person/74]

+ Request (application/json)
    + Body

            {
              "name": "Fulano",
              "birthDate": "1999-02-01",
              "email": "2105@gmail.com",
              "telephone": "11111111112"
            }

+ Response 200 (application/json)
    + Body

            {
              "id": 74,
              "name": "Fulano",
              "birthDate": "1999-02-01T00:00:00.000+00:00",
              "email": "2105@gmail.com",
              "telephone": "11111111112"
            }

+ Response 404 (application/json)
    + Body

              {
                "message": "Id person not found!",
                "field": "null",
                "status": "NOT_FOUND"
              }

### listPerson (Read) [GET /api/person]

+ Response 200 (application/json)
    + Body

            [
              {
                "id": 74,
                "name": "Fulano",
                "birthDate": "1999-02-01T00:00:00.000+00:00",
                "email": "2105@gmail.com",
                "telephone": "11111111112"
              },
              {
                "id": 8,
                "name": "Ciclano Aparecido",
                "birthDate": "1994-04-21T00:00:00.000+00:00",
                "email": "ciclano@gmail.com",
                "telephone": "11111111113"
              },
              {
                "id": 9,
                "name": "Beltrano Oliveira",
                "birthDate": "1996-08-11T00:00:00.000+00:00",
                "email": "beltrano@gmail.com",
                "telephone": "11111111114"
              }
            ]

### deletePersonById (Delete) [DELETE /api/person/74]

+ Response 200 (application/json)
    + Body

            74

+ Response 404 (application/json)
    + Body

              {
                "message": "Id person not found!",
                "field": "null",
                "status": "NOT_FOUND"
              }

  ### createdAddress (Create) [POST /api/person/address]

+ Request (application/json)
    + Body

            {
              "publicPlace": "rua das flores",
              "cep": "00000000",
              "number": "2105",
              "city": "Alameda",
              "mainAddress":true,
              "personId": 38
            }

+ Response 201 (application/json)
    + Body

            {
              "id": 80,
              "publicPlace": "rua das flores",
              "number": "2105",
              "city": "Alameda",
              "mainAddress": true,
              "cep": "00000000"
            }
+ Response 400 (application/json)
    + Body

              {
                "message": "Invalid zip code!",
                "field": "CEP",
                "status": "BAD_REQUEST"
              }

### editAddressPerson (Update) [PUT /api/person/address/80]

+ Request (application/json)
    + Body

            {
              "publicPlace": "rua das flores",
              "cep": "00000000",
              "number": "2105",
              "city": "Alameda",
              "mainAddress":true,
              "personId": 38
            }

+ Response 201 (application/json)
    + Body

            {
              "id": 80,
              "publicPlace": "rua das flores",
              "number": "2105",
              "city": "Alameda",
              "mainAddress": true,
              "cep": "00000000"
            }
+ Response 400 (application/json)
    + Body

              {
                "message": "Invalid zip code!",
                "field": "CEP",
                "status": "BAD_REQUEST"
              }

+ Response 404 (application/json)
    + Body

              {
                "message": "Address not found!",
                "field": null,
                "status": "NOT_FOUND"
              }

### listAddressPerson (Read) [GET /api/person/address/38]

+ Response 200 (application/json)
    + Body

             [
               {
                 "id": 80,
                 "publicPlace": "rua das flores",
                 "number": "2105",
                 "city": "Alameda",
                 "mainAddress": true,
                 "cep": "00000000"
               }, 
               {
                 "id": 81,
                 "publicPlace": "rua do Ypê",
                 "number": "2105",
                 "city": "Alameda",
                 "mainAddress": false,
                 "cep": "40000000"
               }
             ]

+ Response 404 (application/json)
    + Body

              {
                "message": "Id person not found!",
                "field": "null",
                "status": "NOT_FOUND"
              }

### consultMainAddressPersonById (Read) [GET /api/person/address/main/9]

+ Response 200 (application/json)
    + Body 
  
              {
                "id": 83,
                "publicPlace": "rua das Rosas",
                "number": "2",
                "city": "Alameda",
                "cep": "99999999",
                "mainAddress": true
              }

### deleteAddressPerson (Delete) [DELETE /api/person/address/88]

+ Response 200 (application/json)
    + Body

            88



