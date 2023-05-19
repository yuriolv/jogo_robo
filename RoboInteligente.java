import java.util.Random;

import exception.MovimentoInvalidoException;

public class RoboInteligente extends Robo {
    private boolean errou;

    public RoboInteligente(String cor){
        super(cor);
    }
    public void mover()throws MovimentoInvalidoException{
        Random gerador = new Random();
        int movimento;
        if(errou){
            movimento = gerador.nextInt(3);
        }
        else
            movimento = gerador.nextInt(3);

        if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
            throw new MovimentoInvalidoException();

        else               
            switch (movimento) {
                case 0:
                    eixoY++;    
                break;

                case 1:            
                    eixoY--;    
                break;

                case 2:         
                    eixoX++;    
                break;
        
                default:
                    eixoX--;
        }

    }
}
