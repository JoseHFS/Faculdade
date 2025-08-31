# Faculdade
José Henrique Fernandes e Silva

Ponteiros são variáveis que guardam o endereço de outra variável na memória

int *p; ponteiro do tipo inteiro. O * diz que essa variável é um ponteiro

p = &x; isso diz que o ponteiro recebe o endereço da memória da variável x

printf("%p", p); isso exibe o endereço para o qual o ponteiro aponta, sendo o mesmo que:
printf("%p", &x)

É possível também exibir o valor da variável cujo endereço o ponteiro recebeu, usando o próprio ponteiro
printf("%d", *p);

Eles podem ser: int, float, double, char, short, long, ponteiros de ponteiros, arrays e matrizes

int *p;
float *p;
double *p;
char *p;
short *p;
long *p;

int array[4];
int *p = array;

int matriz[4][4];
int *p = &matriz[0][0];

Eu os usei onde deu pra usar, como na matriz 4x4 dos jogadores, onde fiz um ponteiro para a matriz e a percorri para exibir os jogadores e os sets. Quase todas as variáveis eu fiz ponteiros para elas. Houve uma confusão na hora de percorrê-las, já que percorrer uma matriz e percorrer um ponteiro para matriz são meios diferentes.
