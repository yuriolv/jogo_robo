import java.util.*;

import exception.MovimentoInvalidoException;
public class Robo {

    protected int eixoX, eixoY, qtdMovimentoValido, qtdMovimentoInvalido;
    protected String cor;
    
    public Robo(String cor){
        eixoX = 0;
        eixoY = 4;
        this.cor = cor;
    }
    
    public void mover() throws MovimentoInvalidoException{ 
        Random gerador = new Random();
        int movimento = gerador.nextInt(3);

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

    public void mover(String movimento) throws MovimentoInvalidoException {
        
        if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
            throw new MovimentoInvalidoException();

        else               
            switch (movimento) {
                case "Up":
                    eixoY--;    
                break;

                case "Down":              
                    eixoY++;    
                break;

                case "Right":               
                    eixoX++;    
                break;
            
                default:               
                    eixoX--;
            }
            
    } 

    public void mover(int movimento) throws MovimentoInvalidoException{

        if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
            throw new MovimentoInvalidoException();

        else               
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

    public void setQtdMovimentoValido(int qtdMovimentoValido) {
        this.qtdMovimentoValido = qtdMovimentoValido;
    }

    public int getQtdMovimentoInvalido() {
        return qtdMovimentoInvalido;
    }

    public void setQtdMovimentoInvalido(int qtdMovimentoInvalido) {
        this.qtdMovimentoInvalido = qtdMovimentoInvalido;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    
}