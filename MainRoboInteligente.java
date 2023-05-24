import java.util.*;

import exception.PosicaoInvalidaException;
import exception.MovimentoInvalidoException;

public class MainRoboInteligente {
    public static void main(String args[]) {
        Tela tela = new Tela();
        Robo walle = new Robo("Azul");
        Robo eva = new RoboInteligente("Vermelho");
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
                tela.moverRobo(eva);
                newEixoY = tela.definirAlimento(eixoY, eixoX); 
            } catch (PosicaoInvalidaException e) {
                System.out.println(e);
                tela.mostrarTransição(2000);
            }
            tela.ClearConsole();
        }while(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0);

        tela.mostrarPlano();
        tela.mostrarTransição(2000);
        tela.ClearConsole();

        
        do {
            if(tesouroWalle==false){
                System.out.println("   -------------Vez do robô comum-------------\n");
                tela.mostrarPlano();
                tela.mostrarTransição(1000);
                tela.ClearConsole();

                try {
                    tela.gerarPlano();
                    tela.definirAlimento(eixoY, eixoX);
                    tela.moverRobo(eva);
                } catch (PosicaoInvalidaException e) {
                    System.out.println(e);
                }
                System.out.println("   -------------Vez do robô comum-------------\n");
                movimento = walle.gerarMovimento();
                try {

                    tela.moverRobo(walle, movimento);
                    walle.mover(movimento);

                    walle.setQtdMovimentoValido();

                    tela.mostrarPlano();
                    tela.mostrarTransição(2000);
                } catch( MovimentoInvalidoException e){
                    tela.moverRobo(walle);
                    tela.mostrarPlano();

                    walle.setQtdMovimentoInvalido();

                    System.out.println(e+" "+movimento);                    
                    tela.mostrarTransição(2000);
  
                } 
                tela.ClearConsole();
            }

            
            if(tesouroEva == false){
                System.out.println(" -----------Vez do robô inteligente-----------\n");
                tela.mostrarPlano();
                tela.mostrarTransição(1000);
                tela.ClearConsole();
                
                try {
                    tela.gerarPlano();
                    tela.definirAlimento(eixoY, eixoX);
                    tela.moverRobo(walle);
                } catch (PosicaoInvalidaException e) {
                    System.out.println(e);
                } 

                System.out.println(" -----------Vez do robô inteligente-----------\n");
                movimento = eva.gerarMovimento();
                try {
                
                    tela.moverRobo(eva, movimento);
                    eva.mover(movimento);
                    
                    eva.setQtdMovimentoValido();

                    tela.mostrarPlano();
                    tela.mostrarTransição(2000);
                } catch( MovimentoInvalidoException e){
                    ((RoboInteligente) eva).setCometeuUmErro(true);
                    tela.moverRobo(eva);
                    tela.mostrarPlano();

                    eva.setQtdMovimentoInvalido();

                    System.out.print(e+" "+movimento); 
                    tela.mostrarTransição(2000);
                } 
                tela.ClearConsole();
            }

            
            tesouroWalle = tela.checarEncontroAlimento(walle, eixoX, newEixoY);
            tesouroEva = tela.checarEncontroAlimento(eva, eixoX, newEixoY);
            
            if(tesouroEva && tesouroWalle){
                ambosAcharam=true;
            }

        } while (ambosAcharam != true);
        
        tela.mostrarPlano();
        tela.mostrarTransição(2000);
        tela.ClearConsole();

        tela.mostrarResultado(walle, eva);
        leitor.close();
    }
    
}