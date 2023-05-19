import java.util.Scanner;

import exception.MovimentoInvalidoException;

public class RoboManual {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Robo walle = new Robo("ferrugem");
        
        
        boolean tesouro = false;
        Scanner entrada = new Scanner(System.in);
        int eixoX, eixoY;


        System.out.println("Digite as coordenadas da posicao do alimento (max 5)");
        System.out.print("Coordenada em x: ");
        eixoX = entrada.nextInt();
        System.out.print("Coordenada em y: ");
        eixoY = entrada.nextInt();
        tela.gerarPlano();
        tela.definirAlimento(eixoY - 1, eixoX - 1);
        
        try {
            tela.moverRobo(walle.getEixoY(), walle.getEixoX());
        } catch( MovimentoInvalidoException e){
            System.out.println(e);
        }
        tela.mostrarPlano();
        
        do {
            
            tela.gerarPlano();
            tela.definirAlimento(eixoY - 1, eixoX - 1);

            try {
                tela.moverRobo(walle.getEixoY(), walle.getEixoX());
            } catch( MovimentoInvalidoException e){
                System.out.println(e);
            }
            
            tela.mostrarPlano();
            
        } while (tesouro != true);

       /*  tela.gerarPlano();
        tela.definirAlimento(3, 3); */
        
        /* try {
            walle.mover(2);
            tela.moverRobo(walle.getEixoY(), walle.getEixoX());
        } catch(MovimentoInvalidoException e) {
            System.out.println(e);
        } */
        
    }
}
