#Um sistema de supermercado, cada produto tem id,nome,preço,quantidade, o tipo de medida, como kg ml, e o valor numerico em si

usado:

-JAVA

-Spring Boot

-SpringWeb

-Maven

função de deletar:

curl -X DELETE http://localhost:8080/produtos/(id do produto)

listar produtos:
curl http://localhost:8080/produtos

Adicionar produto:

curl -X POST "http://localhost:8080/produtos" -H "Content-Type: application/json" -d "{\"id_produto\":\"001\",\"nome\":\"Arroz\",\"preco\":25.90,\"quantidade\":10,\"valor_medida\":5,\"medidade\":\"kg\"}"

id,nome,preço,quantidade,valor_medida,medida

buscar por id:

curl http://localhost:8080/produtos/001

endpoints:

deletar
DELETE /produtos/{id_produto}

listar 
GET /produtos

buscar
GET /produtos/{id_produto}



adicionar
POST /produtos









