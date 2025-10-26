import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        lista l=new lista();
        listadupla e=new listadupla();
        listacircular c=new listacircular();
        int tecla;
        Scanner scan = new Scanner(System.in);
        while(true){
            tecla=scan.nextInt();

            if(tecla==0){
                break;
            }


            if(tecla==1){
                while(true){
                    tecla=scan.nextInt();
                if(tecla==0){
                break;
                
            }
            if(tecla==1){ 
                l.inserir(scan.nextInt());
            }
            if(tecla==2){
                l.buscar(scan.nextInt());
            }
            if(tecla==3){
                l.listar();
            }
            if(tecla==4){
                l.remover(scan.nextInt());
            }
                }
            }

            if(tecla==2){
                while(true){
                    tecla=scan.nextInt();
                if(tecla==0){
                break;
                
            }
            if(tecla==1){ 
                e.inserir(scan.nextInt());
            }
            if(tecla==2){
                e.buscar(scan.nextInt());
            }
            if(tecla==3){
                e.listar();
            }
            if(tecla==4){
                e.remover(scan.nextInt());
            }
                }

            }

            if(tecla==3){
                while(true){
                    tecla=scan.nextInt();
                if(tecla==0){
                break;
                
            }
            if(tecla==1){ 
                c.inserir(scan.nextInt());
            }
            if(tecla==2){
                c.buscar(scan.nextInt());
            }
            if(tecla==3){
                c.listar();
            }
            if(tecla==4){
                c.remover(scan.nextInt());
            }
                }

            }


            

            
        }
        scan.close();
        

    } 
  
}
