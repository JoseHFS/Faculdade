grafo = {}


def adicionar_vertice(grafo, v):
    if v not in grafo:
        grafo[v] = {}
    else:
        print(f"Vértice ",v," já existe")


#Não direcionado peloes vertices serem cidades e as arestas serem estradas
def adicionar_aresta(grafo, origem, destino, peso=1):
    if origem not in grafo:
        adicionar_vertice(grafo, origem)
    if destino not in grafo:
        adicionar_vertice(grafo, destino)

    grafo[origem][destino] = peso
    grafo[destino][origem] = peso


#remover vertice
def remover_vertice(grafo, vertice):
    if vertice in grafo:
        # remover arestas para v em outros vértices
        for i in list(grafo.keys()):
            if vertice in grafo[i]:
                del grafo[i][vertice]

        # remover o próprio vértice
        del grafo[vertice]
    else:
        print(f"não existe.")



# remover aresta
def remover_aresta(grafo,origem, destino, direcionado=False):
    if origem in grafo and destino in grafo[origem]:
        del grafo[origem][destino]
        del grafo[destino][origem]



# Printar grafo
def exibir(grafo):
    for i in grafo:
        print(f"{i} -> {grafo[i]}")

adicionar_vertice(grafo, "Belo Horizonte")
adicionar_vertice(grafo, "São Paulo")
adicionar_vertice(grafo, "Rio")
adicionar_aresta(grafo, "São Paulo", "Rio", 430)

adicionar_aresta(grafo, "São Paulo", "Belo Horizonte", 586)

exibir(grafo)

inicio = "São Paulo"
fim = "Belo Horizonte"

#djastra
dist = {v: float("inf") for v in grafo}
dist[inicio] = 0

visitados = set()


while len(visitados) < len(grafo):

    
    nao_visitados = []
    for v in grafo:
        if v not in visitados:
            nao_visitados.append(v)

    
    atual = nao_visitados[0]
    menor_dist = dist[atual]

    for v in nao_visitados:
        if dist[v] < menor_dist:
            menor_dist = dist[v]
            atual = v

    visitados.add(atual)

    
    if atual == fim:
        break

    
    for vizinho, peso in grafo[atual].items():
        nova_dist = dist[atual] + peso
        if nova_dist < dist[vizinho]:
            dist[vizinho] = nova_dist



if dist[fim] == float("inf"):
    print("Não existe caminho entre ", inicio, " e ", fim)
else:
    print("Distância mínima de ", inicio, " até ", fim, dist[fim])



