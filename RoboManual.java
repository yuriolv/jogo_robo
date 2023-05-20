import java.util.Scanner;

import exception.MovimentoInvalidoException;
import exception.PosicaoInvalidaException;
import java.io.*;

public class RoboManual {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Robo walle = new Robo("ferrugem");

        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";
        
        boolean tesouro = false;
        Scanner entrada = new Scanner(System.in);
        int eixoX, eixoY, newEixoY = 0;
        String comando;
        int movimento;

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

        tela.ClearConsole();
        tela.mostrarPlano();
        
        do {

            tela.gerarPlano();

            try {
                tela.definirAlimento(eixoY, eixoX);
            } catch (PosicaoInvalidaException e) {
                System.out.println(e );
                tela.mostrarTransição(2000);
            } 

             try {

                comando = entrada.next();
                movimento = walle.transformarComando(comando);
                tela.moverRobo(walle, movimento);

                walle.mover(movimento);
            } catch( MovimentoInvalidoException e){

                System.out.println(e);
                tela.mostrarTransição(2000);

            } finally{
                tela.moverRobo(walle);
            }
            
            tela.ClearConsole();
            tela.mostrarPlano();
            tesouro = tela.checarEncontroAlimento(walle, eixoX, newEixoY);
            
        } while (tesouro != true);

        System.out.println(ANSI_YELLOW + "Finalmente o wall-e encontrou o alimento!!" + ANSI_RESET);

        entrada.close();
    
    }
}
