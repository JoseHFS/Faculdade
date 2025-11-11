public class App {
    public static void main(String[] args) throws Exception {
         metodos arvore = new metodos();
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(3);
        arvore.inserir(7);

        arvore.buscar(15);
        arvore.buscar(20);

        System.out.println("\nPre ordem:");
        arvore.preOrdem(arvore.raiz);

        System.out.println("\nEm ordem:");
        arvore.emOrdem(arvore.raiz);

        System.out.println("\nPos ordem:");
        arvore.posOrdem(arvore.raiz);

    }
}
