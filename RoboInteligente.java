public class RoboInteligente extends Robo {
    private boolean cometeuUmErro;

    public RoboInteligente(String cor){
        super(cor);
    }
    public void mover(int movimento){
        if(cometeuUmErro==false){   
            movimento = gerarMovimento();
            switch (movimento) {
                case 5:
                    eixoY--;    
                break;

                case 2:            
                    eixoY++;    
                break;

                case 3:         
                    eixoX++;    
                break;
            
                default:
                    eixoX--;
            }
        }
        else{
            analisarCampo();

        }
    }
    public void analisarCampo(){
            

        }

}



