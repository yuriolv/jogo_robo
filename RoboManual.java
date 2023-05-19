import exception.MovimentoInvalidoException;

public class RoboManual {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Robo walle = new Robo("ferrugem");

        tela.gerarPlano();

        
        try {
            walle.mover(2);
            tela.moverRobo(walle.getEixoY(), walle.getEixoX());
        } catch(MovimentoInvalidoException e) {
            System.out.println(e);
        }

        /* try {

            tela.moverRobo(7, 0);

        } catch(MovimentoInvalidoException e) {
            System.out.println(e);
        } */
        
        System.out.printf("%d , %d", walle.getEixoX() , walle.getEixoY()); 

        System.out.println("chegou aqui");

    }
}
