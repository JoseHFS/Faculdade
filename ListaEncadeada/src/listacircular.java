public class listacircular {
    private nocircular inicio;
    private nocircular fim;

    public listacircular() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserir(int valor) {
        nocircular novo = new nocircular(valor);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
            novo.prox = inicio;
        } else {
            fim.prox = novo;
            novo.prox = inicio;
            fim = novo;
        }
    }

    public void listar() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }


        nocircular atual = inicio.prox;
        System.out.print("Lista: "+inicio.valor);
        while (atual != inicio){
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        } 
    }

    public void buscar(int valor) {
        if (inicio == null) {
            return;
        }

        if(inicio.valor==valor){
            System.out.println("Valor "+ valor);
            return;
        }

        nocircular atual = inicio.prox;
        while (atual != inicio){
            if (atual.valor == valor) {
                System.out.println("Valor " + valor);
                return;
            }
            atual = atual.prox;
        } 

        System.out.println("Valor não exste");
        
    }

    public void remover(int valor) {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }

        nocircular atual = inicio;
        nocircular anterior = fim;



        while (true){
            if (atual.valor == valor) {
                if (atual == inicio && atual == fim) { // apenas um elemento
                    inicio = null;
                    fim = null;
                } else if (atual == inicio) { // removendo o primeiro
                    inicio = inicio.prox;
                    fim.prox = inicio;
                } else if (atual == fim) { // removendo o último
                    fim = anterior;
                    fim.prox = inicio;
                } else { // removendo do meio
                    anterior.prox = atual.prox;
                }
                System.out.println("Valor " + valor + " removido!");
                return;
            }
            anterior = atual;
            atual = atual.prox;

            if (atual == fim) break; // se chegou ao último, para o loop
    anterior = atual;
    atual = atual.prox;
        } 

        System.out.println("Valor não encontrado!");
    }
}
