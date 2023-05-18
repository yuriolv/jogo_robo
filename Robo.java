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
    
    public void mover() throws MovimentoInvalidoException{ //resolvido na task de mover robô...
        Random gerador = new Random();
        int movimento = gerador.nextInt(3);
        
        switch (movimento) {
            case 0:
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
                    throw new MovimentoInvalidoException();
                else               
                eixoY++;    
            break;

            case 1:
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
                    throw new MovimentoInvalidoException();
                else               
                eixoY--;    
            break;

            case 2:
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
                    throw new MovimentoInvalidoException();
                else               
                eixoX++;    
            break;
            
            default:
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0 )
                    throw new MovimentoInvalidoException();
                else
                eixoX--;
        }
    }

    public void mover(String movimento) throws MovimentoInvalidoException {

        switch (movimento) {
            case "Up":
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
                    throw new MovimentoInvalidoException();
                else               
            eixoY--;    
            break;
            case "Down":
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
                    throw new MovimentoInvalidoException();
                else               
            eixoY++;    
            break;

            case "Right":
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
                    throw new MovimentoInvalidoException();
                else               
            eixoX++;    
            break;
            
            default:
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
                    throw new MovimentoInvalidoException();
                else               
                eixoX--;
            }
            
    } 

    public void mover(int movimento) throws MovimentoInvalidoException{

        switch (movimento) {
            case 5:
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
                    throw new MovimentoInvalidoException();
                else               
                eixoY--;    
                break;
            case 2:
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
                    throw new MovimentoInvalidoException();
                else               
                eixoY++;    
            break;

            case 3:
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
                    throw new MovimentoInvalidoException();
                else               
                eixoX++;    
            break;
            
            default:
                if(eixoX + 1 > 4 || eixoY + 1 > 4 || eixoX - 1 < 0 || eixoY - 1 < 0)
                    throw new MovimentoInvalidoException();
                else               
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