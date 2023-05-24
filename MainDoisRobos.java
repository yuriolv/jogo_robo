import java.util.Scanner;

import exception.MovimentoInvalidoException;
import exception.PosicaoInvalidaException;

public class MainDoisRobos {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Robo walle = new Robo("Azul");
        Robo eva = new Robo("Vermelho");
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";


        Scanner entrada = new Scanner(System.in);
        boolean alimentoEncontradoWalle = false;
        boolean alimentoEncontradoEva = false;
        int eixoX, eixoY, newEixoY = 0;
        int movimento;

        do {
            System.out.println("Digite as coordenadas da posicao do alimento (max 4)");
            System.out.print("Coordenada em x: ");
            eixoX = entrada.nextInt();
            System.out.print("Coordenada em y: ");
            eixoY = entrada.nextInt();

            tela.gerarPlano();

            try {
                tela.moverRobo(walle);
                tela.moverRobo(eva);
                newEixoY = tela.definirAlimento(eixoY, eixoX);
            } catch(PosicaoInvalidaException e) {
                System.out.println(e);
                tela.mostrarTransição(2000);
            }
            tela.ClearConsole();
        }while(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0);

        tela.mostrarPlano();
        tela.mostrarTransição(1500);
        tela.ClearConsole();

        while(alimentoEncontradoWalle == false && alimentoEncontradoEva == false) {
            
            System.out.println("\t  ------ Vez de Wall-e ------\n");
            tela.mostrarPlano();
            tela.mostrarTransição(1000);
            tela.ClearConsole();
            tela.gerarPlano();

            try {
                tela.moverRobo(eva);
                tela.definirAlimento(eixoY, eixoX);
            } catch(PosicaoInvalidaException e) {
                System.out.println(e);
                //tela.mostrarTransicao(2000);
            }

            System.out.println("\t  ------ Vez de Wall-e ------\n");
            movimento = walle.gerarMovimento();
            try {
                
                tela.moverRobo(walle, movimento);
                walle.mover(movimento);

                tela.mostrarPlano();
                tela.mostrarTransição(2000);
                walle.setQtdMovimentoValido();

            } catch(MovimentoInvalidoException e) {
                tela.moverRobo(walle);
                tela.mostrarPlano();

                System.out.println(e + " " + movimento);
                tela.mostrarTransição(2000);
                walle.setQtdMovimentoInvalido();
            } 
            tela.ClearConsole();
            alimentoEncontradoWalle = tela.checarEncontroAlimento(walle, eixoX, newEixoY);
            if(alimentoEncontradoWalle == true) 
                break;


            System.out.println("\t  ------ Vez de Eva ------\n");
            tela.mostrarPlano();      
            tela.mostrarTransição(1000);
            tela.ClearConsole();
           
            tela.gerarPlano();
            try {
                tela.definirAlimento(eixoY, eixoX);
                tela.moverRobo(walle);
            } catch(PosicaoInvalidaException e) {
                System.out.println(e);
            }

            System.out.println("\t  ------ Vez de Eva ------\n");
            try {
                movimento = eva.gerarMovimento();
                tela.moverRobo(eva, movimento);
                eva.mover(movimento);

                tela.mostrarPlano();
                tela.mostrarTransição(2000);
                eva.setQtdMovimentoValido();
            } catch(MovimentoInvalidoException e) {

                tela.moverRobo(eva);
                tela.mostrarPlano();

                System.out.println(e + " " + movimento);
                tela.mostrarTransição(2000);

                eva.setQtdMovimentoInvalido();
                tela.ClearConsole();
            }
            tela.ClearConsole();
            alimentoEncontradoWalle = tela.checarEncontroAlimento(walle, eixoX, newEixoY);
            alimentoEncontradoEva = tela.checarEncontroAlimento(eva, eixoX, newEixoY);

        }
        tela.mostrarPlano();
        if(alimentoEncontradoWalle == true)
            System.out.println(ANSI_BLUE+"Walle Encontrou a bateria"+ANSI_RESET);
        else 
            System.out.println(ANSI_RED+"Eva Encontrou a bateria"+ANSI_RESET);

        tela.mostrarResultado(walle, eva);

        entrada.close();
    }

    


}

