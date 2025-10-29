public class listadupla {
    noduplo inicio;
    public void inserir(int valor){
        noduplo novoNo=new noduplo(valor);
        if(inicio==null){
            inicio=novoNo;
        }
        else{
            noduplo noAtual=inicio;
            while(noAtual.prox!=null){
                noAtual=noAtual.prox;
            }
            noAtual.prox=novoNo;
            novoNo.anterior=noAtual;
        }
    }


    public void listar(){
    if(inicio==null){
        System.out.println("Lista vazia");
    }
    else{
        noduplo noAtual=inicio;
        while(noAtual!=null){
            System.out.println("Nó "+noAtual.valor);
            noAtual=noAtual.prox;
        }
        
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
            noduplo noAtual=inicio.prox;
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
        return;
    }
    if (inicio.valor == valor) {
        if(inicio.prox==null){
            inicio=null;
        }
        else{
            inicio=inicio.prox;
            inicio.anterior=null;
        }
        return;
    }
    

    noduplo noAtual= inicio.prox;
    while(noAtual!=null){
        if(noAtual.valor==valor){
            if(noAtual.prox==null){
                noAtual.anterior.prox=null;
                noAtual.anterior=null;
            }
            else{
                noAtual.anterior.prox=noAtual.prox;
            noAtual.prox.anterior=noAtual.anterior;

            }
            return;
            

        }
        noAtual=noAtual.prox;
    }
    
}
}

