Sistema de um mercado com produto e estoque sendo 2 services diferentes

Produto

id
nome
preço
quantidade em estoque

EstoqueService cuida apenas do estoque, como impedir que o estoque fique negativo

O ProdutoService cuida do produto, como metodos para listar todos produtos, buscar um expecifico, deletar, cadastrar, e impedir erros como preço menor ou igual a zero e ter um nome

o Repository apenas chama esses metodos e mecher de fato no armazenamento

Controller é responsavel por conectar com o http

endpoints
@GetMapping
    public List<Produto> listarProdutos() {
        return service.listarTodos();
    }

@GetMapping("/{id_produto}")
    public Produto buscarProduto(@PathVariable Long id_produto) {
        return service.buscarPorId(id_produto);
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return service.cadastrar(produto);
    }

    @DeleteMapping("/{id_produto}")
    public void deletarProduto(@PathVariable Long id_produto) {
        service.deletar(id_produto);
    }

    @PutMapping("/{id_produto}")
    public Produto atualizarEstoque(
            @PathVariable Long id_produto,
            @RequestParam int quantidade) {

        return estoqueService.atualizarEstoque(id_produto, quantidade);
    }


    função de deletar:

curl -X DELETE http://localhost:8080/produtos/(id do produto)

listar produtos:
curl http://localhost:8080/produtos

Adicionar produto:

curl -X POST "http://localhost:8080/produtos" -H "Content-Type: application/json" -d "{\"id_produto\":\"001\",\"nome\":\"Arroz\",\"preco_produto\":25.90,\"quantidade_estoque\"}"

id,nome,preço,quantidade,valor_medida,medida

buscar por id:

curl http://localhost:8080/produtos/001

alterar quantidade de estoque de produto por id

curl -X PUT "http://localhost:8080/produtos/1?quantidade=10"


endpoints:

deletar
DELETE /produtos/{id_produto}

listar 
GET /produtos

buscar
GET /produtos/{id_produto}



adicionar
POST /produtos

