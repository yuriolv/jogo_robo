import java.util.*;

import exception.PosicaoInvalidaException;
import exception.MovimentoInvalidoException;

public class MainRoboInteligente {
    public static void main(String args[]) {
        Tela tela = new Tela();
        Robo walle = new Robo("ferrugem");
        Robo eva = new RoboInteligente("Branco");
        Scanner leitor = new Scanner(System.in);

        boolean tesouroWalle = false;
        boolean tesouroEva = false;
        boolean ambosAcharam = false;
        int movimento, eixoX, eixoY, newEixoY = 0;
        
        do{  
            System.out.println("Digite as coordenadas da posicao do alimento (max 4)");
            System.out.print("Coordenada em x: ");
            eixoX = leitor.nextInt();
            System.out.print("Coordenada em y: ");
            eixoY = leitor.nextInt();

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
        tela.mostrarTransição(2000);
        tela.ClearConsole();

        
        do {
            if(tesouroWalle==false){
                System.out.println("-----------Vez do robô normal-------------");
                tela.mostrarTransição(1500);
            
                try {
                    tela.gerarPlano();
                    tela.definirAlimento(eixoY, eixoX);
                } catch (PosicaoInvalidaException e) {
                    System.out.println(e);
                }

                try {
                    movimento = walle.gerarMovimento();
                    tela.moverRobo(walle, movimento);
                    walle.mover(movimento);
                    tela.ClearConsole();
                } catch( MovimentoInvalidoException e){
                    tela.moverRobo(walle);

                    System.out.println(e);                    
                    tela.mostrarTransição(2000);
                } finally{
                    tela.moverRobo(eva);
                }

                tela.mostrarPlano();
                tela.mostrarTransição(2000);
            }
            tela.ClearConsole();

            System.out.println("-----------Vez do robô inteligente-------------");
            tela.mostrarTransição(1500);

            if(tesouroEva == false){

                try {
                    tela.gerarPlano();
                    tela.definirAlimento(eixoY, eixoX);
                } catch (PosicaoInvalidaException e) {
                    System.out.println(e);
                } 
                try {
                
                    movimento = eva.gerarMovimento();
                    tela.moverRobo(eva, movimento);
                    eva.mover(movimento);
                    tela.ClearConsole();
                } catch( MovimentoInvalidoException e){
                    ((RoboInteligente) eva).setCometeuUmErro(true);
                    tela.moverRobo(eva);
                
                    System.out.println(e); 
                    tela.mostrarTransição(2000);

                } finally{
                    tela.moverRobo(walle);
                }
                tela.mostrarPlano();
                tela.mostrarTransição(1500);
            }
            tela.ClearConsole();
            
            tesouroWalle = tela.checarEncontroAlimento(walle, eixoX, newEixoY);
            tesouroEva = tela.checarEncontroAlimento(eva, eixoX, newEixoY);
            
            if(tesouroEva && tesouroWalle){
                ambosAcharam=true;
            }

        } while (ambosAcharam != true);
        leitor.close();
    
    }
    
}