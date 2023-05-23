import java.util.*;

public class RoboInteligente extends Robo {
    private boolean cometeuUmErro;
    private int ultimoMovimento;

    public RoboInteligente(String cor){
        super(cor);
        cometeuUmErro=false;
    }

    public void mover(int movimento){   
        ultimoMovimento = movimento;
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
    public int gerarMovimento(){
        Random gerador = new Random();
        if(cometeuUmErro==false){
            int numeroGerado = gerador.nextInt(4);
            switch (numeroGerado) {
                case 0:
                    numeroGerado=5;    
                break;
                
                case 1:
                    numeroGerado= 2;                      
                break;
                
                case 2:
                    numeroGerado= 3;                      
                break;
                
                default:
                    numeroGerado= 1;      
            }                
            return numeroGerado;
        }
        else{
            cometeuUmErro = false;
            switch (ultimoMovimento) {
                case 5:
                    return 2;
                case 2:            
                    return 5;           
                case 3:         
                    return 1;    
                default:
                    return 3;
            }
        }
    }
    public String toString(){
        return "Robo inteligente -      "+qtdMovimentoValido+" - "+ qtdMovimentoInvalido+" - "+(qtdMovimentoValido+qtdMovimentoInvalido);
    }

    public boolean isCometeuUmErro() {
        return cometeuUmErro;
    }
    public void setCometeuUmErro(boolean cometeuUmErro) {
        this.cometeuUmErro = cometeuUmErro;
    }
    public int getUltimoMovimento() {
        return ultimoMovimento;
    }
    public void setUltimoMovimento(int ultimoMovimento) {
        this.ultimoMovimento = ultimoMovimento;
    }
}



