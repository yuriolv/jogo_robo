import java.util.Scanner;

import exception.MovimentoInvalidoException;
import exception.PosicaoInvalidaException;

public class RoboManual {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Robo walle = new Robo("Azul");
        Scanner entrada = new Scanner(System.in);
        
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        
        boolean tesouro = false;
        int movimento = 0, eixoX, eixoY, newEixoY = 0;
        
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
                tela.mostrarTransição(2000);
            }
            tela.ClearConsole();
        }while(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0);

        tela.mostrarTransição(1500);
        tela.mostrarComandos();
        System.out.println("    -----Faça o Robo chegar ao alimento-----\n");
        tela.mostrarPlano();
        
        do {

            tela.gerarPlano();

            try {
                tela.definirAlimento(eixoY, eixoX);
            } catch (PosicaoInvalidaException e) {
                System.out.println(e);
                tela.mostrarTransição(2000);
            } 

            System.out.print("Digite a direção: ");
            comando = entrada.next();
            
            try {
                movimento = walle.transformarComando(comando);
                tela.moverRobo(walle, movimento);

                walle.mover(movimento);
            } catch( MovimentoInvalidoException e){

                System.out.println(e + " " + movimento);
                tela.mostrarTransição(2000);

            } catch (NumberFormatException e) {
                System.out.println("Caractere digitado é invalido");
                tela.mostrarTransição(2000);

            } finally{
                tela.moverRobo(walle);
            }
            
            tela.ClearConsole();
            System.out.println("    -----Faça o Robo chegar ao alimento-----\n");
            tela.mostrarPlano();
            tesouro = tela.checarEncontroAlimento(walle, eixoX, newEixoY);
            
        } while (tesouro != true);

        System.out.println("Finalmente " + ANSI_BLUE + "wall-e" + ANSI_RESET +" encontrou o alimento!!");
        entrada.close();
        
    }
}
