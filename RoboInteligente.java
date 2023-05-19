import java.util.Random;

public class RoboInteligente extends Robo {
    private boolean errou;

    public RoboInteligente(String cor){
        super(cor);
    }

    public void mover(){
        Random gerador = new Random();
        int movimento;
        if(errou){
            movimento = gerador.nextInt(3);
        }
        else
            movimento = gerador.nextInt(3);         
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
