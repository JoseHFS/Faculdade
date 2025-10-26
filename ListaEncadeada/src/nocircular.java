public class nocircular {
    int valor;
    nocircular prox;

    nocircular(int valor) {
        this.valor = valor;
        this.prox = null;
    }
}