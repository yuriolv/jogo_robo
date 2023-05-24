import java.util.*;

public class Robo {

    protected int eixoX, eixoY, qtdMovimentoValido, qtdMovimentoInvalido;
    protected String cor;
    
    public Robo(String cor){
        eixoX = 0;
        eixoY = 4;
        qtdMovimentoInvalido = 0;
        qtdMovimentoValido = 0;
        this.cor = cor;
    }
    
    
    public void mover(int movimento){         
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
    public int transformarComando(String movimento){

        switch (movimento) {
            case "up":
                return 5;    

            case "down":
                return 2;                  

            case "right":
                return 3;   
            case "left":
                return 1;

            default: 
                return Integer.parseInt(movimento);
        }
            
    } 

    public int gerarMovimento(){
        Random gerador = new Random();
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

    public String toString(){
       

        return "Robo comum: \njogadas validas: "+qtdMovimentoValido+"\njogadas invalidas:"+ qtdMovimentoInvalido+"\ntotal: "+(qtdMovimentoValido+qtdMovimentoInvalido);
    }

    public int getEixoX() {
        return eixoX;
    }

    public void setEixoX(int eixoX) {
        this.eixoX = eixoX;
    }

    public int getEixoY() {
        return eixoY;
    }

    public void setEixoY(int eixoY) {
        this.eixoY = eixoY;
    }

    public int getQtdMovimentoValido() {
        return qtdMovimentoValido;
    }

    public void setQtdMovimentoValido() {
        qtdMovimentoValido += 1;
    }

    public int getQtdMovimentoInvalido() {
        return qtdMovimentoInvalido;
    }

    public void setQtdMovimentoInvalido() {
        this.qtdMovimentoInvalido += 1;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}