import java.util.Scanner;

import exception.MovimentoInvalidoException;
import exception.PosicaoInvalidaException;

public class RoboManual {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Robo walle = new Robo("ferrugem");
        
        
        boolean tesouro = false;
        Scanner entrada = new Scanner(System.in);
        int eixoX, eixoY;
        String comando;
        int movimento;


        System.out.println("Digite as coordenadas da posicao do alimento (max 5)");
        System.out.print("Coordenada em x: ");
        eixoX = entrada.nextInt();
        System.out.print("Coordenada em y: ");
        eixoY = entrada.nextInt();
        tela.gerarPlano();
        
        try {
            tela.moverRobo(walle);
            tela.definirAlimento(eixoY - 1, eixoX - 1); 
        } catch (PosicaoInvalidaException e) {
            System.out.println(e);
        }
        tela.mostrarPlano();
        
        do {
           
                tela.gerarPlano();
            
            
            try {
                tela.definirAlimento(eixoY - 1, eixoX - 1);
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
            
            tela.mostrarPlano();
            tesouro = tela.checarEncontroAlimento(walle);
            
        } while (tesouro != true);
        entrada.close();
    
    }
}
