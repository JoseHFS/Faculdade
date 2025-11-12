public class metodos {
    no raiz;

    
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

   
     no inserirRec(no atual, int valor) {
       
        if (atual == null) {
            return new no(valor);
        }

        
        if (valor < atual.valor) {
            atual.left = inserirRec(atual.left, valor);
        } else if (valor > atual.valor) {
            atual.right = inserirRec(atual.right, valor);
        } 
        

        return atual;
    }

    public void preOrdem(no atual) {
    if (atual != null) {
        System.out.print(atual.valor + " ");  
        preOrdem(atual.left);                 
        preOrdem(atual.right);                
    }
}

// Em ordem: esquerda → raiz → direita
public void emOrdem(no atual) {
    if (atual != null) {
        emOrdem(atual.left);
        System.out.print(atual.valor + " ");
        emOrdem(atual.right);
    }
}


public void posOrdem(no atual) {
    if (atual != null) {
        posOrdem(atual.left);
        posOrdem(atual.right);
        System.out.print(atual.valor + " ");
    }
}

public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    
     public boolean buscarRec( no atual,int valor) {
        
        if (atual == null) {
            System.out.println("Arvore vazia");
            return false;
        }

        if(atual.valor==valor){
            System.out.println("Valor encontrado");
            return true;
        }

        
        if (valor < atual.valor) {
        return buscarRec(atual.left, valor);
    } else {
        return buscarRec(atual.right, valor);
    }
        

    }
}

