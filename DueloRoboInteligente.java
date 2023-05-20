import java.util.*;

import exception.PosicaoInvalidaException;
import exception.MovimentoInvalidoException;

public class DueloRoboInteligente {
    public static void main(String args[]) {
        Tela tela = new Tela();
        Robo robo1 = new Robo("Azul");
        Robo robo2 = new Robo("Preto");
        Scanner leitor = new Scanner(System.in);

        boolean tesouro = false;
        int movimento, eixoX, eixoY, newEixoY = 0;
        
        String comando;
        do{  
            System.out.println("Digite as coordenadas da posicao do alimento (max 4)");
            System.out.print("Coordenada em x: ");
            eixoX = leitor.nextInt();
            System.out.print("Coordenada em y: ");
            eixoY = leitor.nextInt();

            tela.gerarPlano();

            try {
                tela.moverRobo(robo1);
                newEixoY = tela.definirAlimento(eixoY, eixoX); 
            } catch (PosicaoInvalidaException e) {
                System.out.println(e);
            }
            tela.ClearConsole();
        }while(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0);

        tela.mostrarPlano();
        
        do {
            try {
                tela.gerarPlano();
                tela.definirAlimento(eixoY, eixoX);
            } catch (PosicaoInvalidaException e) {
                System.out.println(e);
            } 
            try {
                movimento = robo1.gerarMovimento();
                tela.moverRobo(robo1, movimento);
                robo1.mover(movimento);
                System.out.println("Vez do robô 1");
            } catch( MovimentoInvalidoException e){
                System.out.println(e);                    
            } finally{
                tela.moverRobo(robo1);
                tela.moverRobo(robo2);
            }
            tela.mostrarPlano();
            leitor.nextLine();
            
            
            try {
                tela.gerarPlano();
                tela.definirAlimento(eixoY, eixoX);
            } catch (PosicaoInvalidaException e) {
                System.out.println(e);
            } 
            try {
                
                movimento = robo2.gerarMovimento();
                tela.moverRobo(robo2, movimento);
                robo2.mover(movimento);
                System.out.println("Vez do robô 2");
            } catch( MovimentoInvalidoException e){

                System.out.println(e);

            } finally{
                tela.moverRobo(robo1);
                tela.moverRobo(robo2);
            }

           /*  tela.ClearConsole(); */
            tela.mostrarPlano();
            leitor.nextLine();

            tesouro = tela.checarEncontroAlimento(robo1, eixoX, newEixoY);
            tesouro = tela.checarEncontroAlimento(robo2, eixoX, newEixoY);

        } while (tesouro != true);
        leitor.close();
    
    }
    
}
