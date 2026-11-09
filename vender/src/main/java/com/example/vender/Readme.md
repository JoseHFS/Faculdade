C:\Users\\Desktop\vender>curl -X POST http://localhost:8080/clientes -H "Content-Type: application/json" -d "{\"nome\":\"João Silva\",\"telefone\":\"86999999999\"}"
{"id":1,"nome":"João Silva","pedidos":[],"telefone":"86999999999"}
C:\Users\\Desktop\vender>curl http://localhost:8080/clientes
[{"id":1,"nome":"João Silva","pedidos":[],"telefone":"86999999999"}]
C:\Users\\Desktop\vender>curl -X POST http://localhost:8080/produtos -H "Content-Type: application/json" -d "{\"nome\":\"Teclado\",\"preco\":120.50,\"estoque\":10}"
{"estoque":10,"id":1,"nome":"Teclado","pedidos":[],"preco":120.50}
C:\Users\\Desktop\vender>curl http://localhost:8080/produtos
[{"estoque":10,"id":1,"nome":"Teclado","pedidos":[],"preco":120.50}]
C:\Users\\Desktop\vender>curl -i -X POST http://localhost:8080/clientes -H "Content-Type: application/json" -d "{\"nome\":\"Joao Silva\",\"telefone\":\"86999999999\"}"
HTTP/1.1 201 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 09 Nov 2026 01:01:40 GMT

{"id":2,"nome":"Joao Silva","pedidos":[],"telefone":"86999999999"}
C:\Users\\Desktop\vender>curl -i -X POST http://localhost:8080/produtos -H "Content-Type: application/json" -d "{\"nome\":\"Teclado\",\"preco\":120.50,\"estoque\":10}"
HTTP/1.1 201 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 09 Nov 2026 01:04:37 GMT

{"estoque":10,"id":2,"nome":"Teclado","pedidos":[],"preco":120.50}
C:\Users\\Desktop\vender>curl -i http://localhost:8080/clientes/999
HTTP/1.1 404 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 09 Nov 2026 01:06:42 GMT

{"erro":"Cliente não encontrado"}