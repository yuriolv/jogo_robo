import java.util.Scanner;

import exception.MovimentoInvalidoException;
import exception.PosicaoInvalidaException;

public class MainDoisRobos {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Robo walle = new Robo("Azul");
        Robo eva = new Robo("Vermelho");


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
                newEixoY = tela.definirAlimento(eixoY, eixoX);
            } catch(PosicaoInvalidaException e) {
                System.out.println(e);
            }
            tela.ClearConsole();
        }while(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0);

        tela.mostrarPlano();
        tela.mostrarTransição(1500);
        tela.ClearConsole();

        while(alimentoEncontradoWalle == false || alimentoEncontradoEva == false) {
            
            System.out.println("    ------ Vez de Wall-e ------\n");
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

            System.out.println("    ------ Vez de Wall-e ------\n");
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

                System.out.printf("ultimo movimento: %d\n", movimento);
                System.out.println(e);
                walle.setQtdMovimentoInvalido();
                tela.mostrarTransição(2000);
            } 
            tela.ClearConsole();

            if(alimentoEncontradoWalle == true) 
                break;


            System.out.println("    ------ Vez de Eva ------\n");
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

            System.out.println("    ------ Vez de Eva ------\n");
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

                System.out.printf("ultimo movimento: %d\n", movimento);
                System.out.println(e);

                eva.setQtdMovimentoInvalido();
                tela.mostrarTransição(2000);
                tela.ClearConsole();
            }
            tela.ClearConsole();
            alimentoEncontradoWalle = tela.checarEncontroAlimento(walle, eixoX, newEixoY);
            alimentoEncontradoEva = tela.checarEncontroAlimento(eva, eixoX, newEixoY);

        }
        tela.mostrarPlano();
        if(alimentoEncontradoWalle == true)
            System.out.println(" Walle Encontrou alimento");
        else 
            System.out.println("Eva Encontrou alimento");

        System.out.printf("Quantidade de movimentos validos de Walle: %d\n", walle.getQtdMovimentoValido());
        System.out.printf("Quantidade de movimentos invalidos de Walle: %d\n", walle.getQtdMovimentoInvalido());
        System.out.printf("Quantidade de movimentos validos de Eva: %d\n", eva.getQtdMovimentoValido());
        System.out.printf("Quantidade de movimentos invalidos de Eva: %d\n", eva.getQtdMovimentoInvalido());

        entrada.close();
    }

    


}

