#include <stdio.h>
int main(){
	
	
	//Cofre do jão
	int cofrinho=40;
	int *ponteiro=&cofrinho;
	printf("Valor do cofrinho %d\n",cofrinho);
	printf("Valor apontado pelo ponteiro %d\n",*ponteiro);
	printf("endereco apontado pelo ponteiro %p\n",ponteiro);
	
	//Idade aluno
	int idade;
	printf("Digite a idade do aluno\n");
	scanf("%d",&idade);
	int *ponteiro_idade=&idade;
	printf("Valor da idade apontado pelo ponteiro %d\n",*ponteiro_idade);
	printf("Endereco da idade %p\n",ponteiro_idade);
	
	
	//Loja
	float preco[5];
	float *ponteiro_preco=preco;
	int i;
	for(i=0;i<5;i++){
		printf("Digite o preco do produto %d \n",i+1);
		scanf("%f",ponteiro_preco+i);
		printf("Produto %d preco %.2f \n",i+1,*(ponteiro_preco+i));
		printf("Produto %d com 10 por cento de desconto %f \n",i+1,*(ponteiro_preco+i)*0.90);
	}
	
	
	//Empresa
	int n;
	printf("Digite o tamnho do vetor \n");
	scanf("%d",&n);
	float vetor[n];
	float *ponteiro_horas=vetor;
	float soma=0.0;
	
	for(i=0;i<n;i++){
		printf("Digite as horas dos funcionarios %d \n",i+1);
		scanf("%f",ponteiro_horas+i);
		soma+= *(ponteiro_horas+i);
	}
	printf("Total de horas trabalhadas %f \n",soma);
	
	
	//Pesquisa escola
	
	float notas[6];
	float *ponteiro_notas=notas;
	n=5;
	for(i=0;i<6;i++){
		printf("Digite a nota do aluno %d \n",i+1);
		scanf("%f",ponteiro_notas+i);
		
	}
	printf("Ordem invertida\n");
	for(i=0;i<6;i++){
		n=5-i;
		
		printf("%f \n",*(ponteiro_notas+n));
	}
	

	
	
	//Escola matriz
	float notas_alunos[3][3];
	float *ponteiro_alunos=&notas_alunos[0][0];
	int j;
	float diagonal;
	
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf(" Escreva a nota da prova %d do aluno %d \n",j+1,i+1);
			scanf("%f", (ponteiro_alunos + i * 3 + j));
		}
	}
	
	printf("Matriz \n");
	
	for(i=0;i<3;i++){
		diagonal += *(ponteiro_alunos+i * 3+i);
		for(j=0;j<3;j++){
			printf("Prova %d do aluno%d \n",j+1,i+1);
			printf("%f \n",*(ponteiro_alunos + i * 3+ j));
			
			
		}
	}
	
	

	printf("Diagonal soma %f \n",diagonal);
	
	//jogadores e sets
	
	
	int jogo[4][4]={{5, 7, 8, 6},{4, 6, 5, 7},{3, 9, 6, 8},{2, 4, 7, 5}};
	
	int *ponteiro_jogo=&jogo[0][0];
	
	int par=0;
	int impar=0;
	int *ponteiro_par=&par;
	int*ponteiro_impar=&impar;
	int lista_jogadores[4]={0,0,0,0};
	int *ponteiro_lista_jogadores=lista_jogadores;
	
	
	for (i=0;i<4;i++){
		for(j=0;j<4;j++){
			printf("jogador %d set %d pontos %d \n",i+1,j+1,*(ponteiro_jogo + i * 4 + j));
			if(i==0){
				*(ponteiro_lista_jogadores+i)+=*(ponteiro_jogo+i *4+j);
				
			}
			
			if(i==1){
				*(ponteiro_lista_jogadores+i)+=*(ponteiro_jogo+i *4+j);
				
			}
			
			if(i==2){
				*(ponteiro_lista_jogadores+i)+=*(ponteiro_jogo+i *4+j);
				
			}
			
			if(i==3){
				*(ponteiro_lista_jogadores+i)+=*(ponteiro_jogo+i *4+j);
				
			}
			
			
			if(*(ponteiro_jogo+i *4+j)%2==0){
				*ponteiro_par+=1;
				
			}
			else{
				*ponteiro_impar+=1;
			}
			
		}
	}
	
	
	
	printf("Numero de pontos pares %d numero de pontos impares %d \n",*ponteiro_par,*ponteiro_impar);
	
	int maior_pontuacao = *ponteiro_lista_jogadores;
	int *ponteiro_maior_pontuacao=&maior_pontuacao;
    int jogador_vencedor = 1;
    int *ponteiro_jogador_vencedor=&jogador_vencedor;

    for (i = 0; i < 4; i++) {
    	printf("Jogador %d pontos %d \n",i+1,*(ponteiro_lista_jogadores+i));
        if (*(ponteiro_lista_jogadores + i) > *ponteiro_maior_pontuacao) {
            *ponteiro_maior_pontuacao = *(ponteiro_lista_jogadores + i);
            *ponteiro_jogador_vencedor += 1;
        }
    }
    
    printf("Jogador com maior pontuacao: Jogador %d %d pontos\n", *ponteiro_jogador_vencedor, *ponteiro_maior_pontuacao);
    
    int lista_sets[4]={0,0,0,0};
    int *ponteiro_lista_sets=lista_sets;
    int maior_set=0;
    int *ponteiro_maior_set=&maior_set;
    
    for (i=0;i<4;i++){
    	for (j=0;j<4;j++){
    		*(ponteiro_lista_sets+i)+=*(ponteiro_jogo+j *4+i);
    		
    		
		}
		
		if(*ponteiro_maior_set<*(ponteiro_lista_sets+i)){
			*ponteiro_maior_set=*(ponteiro_lista_sets+i);
		}
		
		printf("Set %d pontos %d \n",i+1,*(ponteiro_lista_sets+i));
	}
	
	printf("Set mais disputado %d \n",*ponteiro_maior_set);
	float media_sets;
	float *ponteiro_media_sets=&media_sets;
	
	for(i=0;i<4;i++){
		*ponteiro_media_sets=((float)*(ponteiro_lista_jogadores+i))/4;
		printf("Media do jogador %d %f \n",i+1,*ponteiro_media_sets);
		
	}
	
	//Variancia jogador
	
	int variancia[4];
	int *ponteiro_variancia=variancia;
	int maior_variancia;
	int menor_variancia;
	int *ponteiro_maior_variancia=&maior_variancia;
	int *ponteiro_menor_variancia=&menor_variancia;
	j=0;
	
	for(i=0;i<4;i++){
		maior_variancia=*(ponteiro_jogo+i * +0);
		menor_variancia=*(ponteiro_jogo+i * +0);
		for(j=0;j<4;j++){
			
			if(*ponteiro_maior_variancia<*(ponteiro_jogo+i * 4+j)){
				*ponteiro_maior_variancia=*(ponteiro_jogo+i * 4+j);
				
				
			}
			if(*ponteiro_menor_variancia>*(ponteiro_jogo+i * 4+j)){
				*ponteiro_menor_variancia=*(ponteiro_jogo+i * 4+j);
				
				
			}
			
			
		}
		printf("Maior variancia %d \n",*ponteiro_maior_variancia);
		printf("Menor variancia %d \n",*ponteiro_menor_variancia);
		
		*(ponteiro_variancia+i)=*ponteiro_maior_variancia-*ponteiro_menor_variancia;
		printf("Variancia %d \n",*(ponteiro_variancia+i));
	}
	
	*ponteiro_menor_variancia=*(ponteiro_variancia+0);
	int contador=1;
	
	for(i=0;i<4;i++){
		if(*ponteiro_menor_variancia>*(ponteiro_variancia+i)){
			*ponteiro_menor_variancia=*(ponteiro_variancia+i);
			contador+=1;
		}
		
		
	}
	
	printf("O jogador %d tem a menor variancia %d",contador,*ponteiro_menor_variancia);
	
	return 0;
}
