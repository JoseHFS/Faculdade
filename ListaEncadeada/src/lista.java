public class lista{
    no inicio;
    public void inserir(int valor){
        no novoNo=new no(valor);
        if(inicio==null){
            inicio=novoNo;
        }
        else{
            no noAtual=inicio;
            while(noAtual.prox!=null){
                noAtual=noAtual.prox;
            }
            noAtual.prox=novoNo;
        }
    }
    public void listar(){
    if(inicio==null){
        System.out.println("Lista vazia");
    }
    else{
        no noAtual=inicio;
        while(noAtual.prox!=null){
            System.out.println("Nó "+noAtual.valor);
            noAtual=noAtual.prox;
        }
        System.out.println("Nó "+noAtual.valor);
    }
}
public void buscar(int valor){
    if(inicio==null){
        System.out.println("Lista vazia");
    }
    else{
        if(inicio.valor==valor){
            System.out.println("Existe valor "+inicio.valor);
        }
        else{
            no noAtual=inicio.prox;
            while(noAtual!=null&&noAtual.valor!=valor){
                noAtual=noAtual.prox;
            }
        
        if(noAtual!=null){
            System.out.println("exist valor "+noAtual.valor);
        }
        else{
            System.out.println("Não existe");
        }
    }
}
}
public void remover(int valor){
    if(inicio==null){
        System.out.println("Lista vazia");
    }
    if (inicio.valor == valor) {
        inicio = inicio.prox;
        System.out.println("Nó "+valor);
    }

    no anterior = inicio;
    no noAtual= inicio.prox;
    while(noAtual!=null){
        if(noAtual.valor==valor){
            anterior.prox=noAtual.prox;
            return;

        }
        anterior = noAtual;
        noAtual=noAtual.prox;
    }
    System.out.println("Valor inexistente");
    
}
}


