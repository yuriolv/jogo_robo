import java.util.Scanner;

import exception.MovimentoInvalidoException;
import exception.PosicaoInvalidaException;

public class RoboManual {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Robo walle = new Robo("ferrugem");
        Scanner entrada = new Scanner(System.in);
        
        

        boolean tesouro = false;
        int movimento, eixoX, eixoY, newEixoY = 0;
        
        String comando;

        do{  
            System.out.println("Digite as coordenadas da posicao do alimento (max 4)");
            System.out.print("Coordenada em x: ");
            eixoX = entrada.nextInt();
            System.out.print("Coordenada em y: ");
            eixoY = entrada.nextInt();
            tela.gerarPlano();

            try {
                tela.moverRobo(walle);
                newEixoY = tela.definirAlimento(eixoY, eixoX); 
            } catch (PosicaoInvalidaException e) {
                System.out.println(e);
            }
            tela.ClearConsole();
        }while(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0);

        tela.mostrarPlano();
        
        do {

            tela.gerarPlano();

            try {
                tela.definirAlimento(eixoY, eixoX);
            } catch (PosicaoInvalidaException e) {
                System.out.println(e);
            } 

             try {

                comando = entrada.next();
                movimento = walle.transformarComando(comando);
                tela.moverRobo(walle, movimento);

                walle.mover(movimento);
            } catch( MovimentoInvalidoException e){

                System.out.println(e);

            } finally{
                tela.moverRobo(walle);
            }
            
            tela.ClearConsole();
            tela.mostrarPlano();
            tesouro = tela.checarEncontroAlimento(walle, eixoX, newEixoY);
            
        } while (tesouro != true);
        entrada.close();
    
    }
}
