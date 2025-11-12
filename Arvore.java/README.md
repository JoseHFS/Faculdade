Recursividade é quando uma função chama a si mesma, criando um loop que só acaba quando o caso base é satisfeito como se pode ver no metodo de inserção onde se o no atual for nulo se retorna um novo nó com o valor

A arvore é percorrida como:
pre ordem raiz, filho esquerdo e filho direito
em ordem filho esquerdo, raiz e filho direito
pos ordem filho esquerdo, filho direito e raiz

usando uma estrutura como

public void preOrdem(no atual) {
    if (atual != null) {
        System.out.print(atual.valor + " ");  
        preOrdem(atual.left);                 
        preOrdem(atual.right);                
    }
}

A recursividade acaba enchendo a memoria pois toda vez que se chama está basicamente se clonando até o caso base seja cumprido, os loops while e for não se chamam apenas ficam repetindo dentro de uma mesma função

Na classe metodo temos primeiro a criação do nó raiz e depois do metodo inserir que serve como uma abstração para se usar o metodo de inserir recursivo onde se cria o no atual que recebe primeiro a raiz, se o atual for nulo se retorna um novo nó com o valor inserido sendo este o caso base se não a função chega se o nó atual é maior ou menor e percorre a lista indo para a esquerda ou direita e então ela se chama novamente

Os metodos de percorrer tem o if como o caso base, se o nó atual não for nulo ele para de se chamar, no caso do pre ordem, depois do if ele printa o valor do nó atual muda o atual para esquerda do nó atual e chama a si mesmo e isso se repete até não se ter mais nada na esquerda, quando não tem mais nada ele "volta" para o pai do nó em que está e vai para a sua direita e isso se repeta até percorrer todos os nós, os outros metodos de percorrer são basicamente a mesma coisa mais em ordem difente

O metodo buscar é um boolean que retorna verdadeiro ou falso dependendo se encontrou o valor ou não, junto com um texto informando, assim como o inserir ele tem primeiro um metodo simples para a abstração, o nó atual é igual a raiz e o valor recebe o valor, se o atual for nulo retorne falso e printe que o valor não foi encontrado, se for igual ao valor retorna true e printa que o valor foi achado, tambem possui um sistema para ir para esquerda ou direita baseado no metodo inserir, mas nesse caso ele apenas chama a propria função com o atual recebendo o valor de um dos seus filhos
