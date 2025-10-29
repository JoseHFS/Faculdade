public class listacircular {
    nocircular inicio;
    nocircular fim;

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
        System.out.println("Nó "+inicio.valor);
        while (atual != inicio){
            System.out.println("Nó "+atual.valor);
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
                if (atual == inicio && atual == fim) { 
                    inicio = null;
                    fim = null;
                } else if (atual == inicio) { 
                    inicio = inicio.prox;
                    fim.prox = inicio;
                } else if (atual == fim) { 
                    fim = anterior;
                    fim.prox = inicio;
                } else { 
                    anterior.prox = atual.prox;
                }
                
                return;
            }
           


            if (atual == fim){
                break;
            }

            anterior = atual;
            atual = atual.prox;
        } 

        System.out.println("Valor não encontrado!");
    }
}


