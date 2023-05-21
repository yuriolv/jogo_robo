import java.util.*;

import exception.PosicaoInvalidaException;
import exception.MovimentoInvalidoException;

public class DueloRoboInteligente {
    public static void main(String args[]) {
        Tela tela = new Tela();
        Robo robo1 = new Robo("Azul");
        Robo robo2 = new RoboInteligente("Preto");
        Scanner leitor = new Scanner(System.in);

        boolean tesouro = false;
        int movimento, eixoX, eixoY, newEixoY = 0;
        
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
        tela.mostrarTransição(2000);
        tela.ClearConsole();

        
        do {
            System.out.println("-----------Vez do robô normal-------------");
            tela.mostrarTransição(1500);
            
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
            } catch( MovimentoInvalidoException e){
                tela.moverRobo(robo1);
                
                tela.ClearConsole();
                System.out.println(e);                    
                tela.mostrarTransição(2000);
            } finally{
                tela.moverRobo(robo2);
            }
            tela.mostrarPlano();
            tela.mostrarTransição(2000);
            
            tela.ClearConsole();

            System.out.println("-----------Vez do robô inteligente-------------");
            tela.mostrarTransição(1500);


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
            } catch( MovimentoInvalidoException e){
                ((RoboInteligente) robo2).setCometeuUmErro(true);
                tela.moverRobo(robo2);
                
                tela.ClearConsole();
                System.out.println(e);                    
                tela.mostrarTransição(2000);
            } finally{
                tela.moverRobo(robo1);
            }

            tela.mostrarPlano();
            tela.mostrarTransição(2000);
            tela.ClearConsole();

            tesouro = tela.checarEncontroAlimento(robo1, eixoX, newEixoY);
            tesouro = tela.checarEncontroAlimento(robo2, eixoX, newEixoY);

        } while (tesouro != true);
        leitor.close();
    
    }
    
}