import java.util.Scanner;



import exception.PosicaoInvalidaException;

public class MainDoisRobos {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Robo walle = new Robo("azul");
        Robo eva = new Robo("Branco");


        Scanner entrada = new Scanner(System.in);
        boolean alimentoEncontrado = false;
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
                //tela.moverRobo(walle);
                newEixoY = tela.definirAlimento(eixoY, eixoX);
            } catch(PosicaoInvalidaException e) {
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
            } catch(PosicaoInvalidaException e) {
                System.out.println(e);
                tela.mostrarTransição(2000);
            }

            //System.out.println("------ Vez de Wall-e se mover ------");

            movimento = walle.gerarMovimento();
            walle.mover(movimento);
            tela.moverRobo(walle);
            
            tela.mostrarTransição(2000);

            tela.ClearConsole();
            tela.mostrarPlano();
            alimentoEncontrado = tela.checarEncontroAlimento(walle, eixoX, newEixoY);
            
        }while(alimentoEncontrado != true);
        System.out.println(" Walle Encontrou alimento");
        entrada.close();
    }

    


}
