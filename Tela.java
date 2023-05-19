import exception.MovimentoInvalidoException;
import exception.PosicaoInvalidaException;

public class Tela {
    String plano [][] = new String [5][5];
    
    public void gerarPlano(){
        for(int i=0;i < 5; i++){
            for(int j=0; j < 5; j++){
                plano[i][j] = "*    ";
            }
        }
    }

    public void definirAlimento(int eixoY, int eixoX) throws PosicaoInvalidaException{
        if(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0) 
            throw new PosicaoInvalidaException();

        plano[eixoY][eixoX] = "A    ";
    }

    public void mostrarPlano(){
        for(int i=0;i < 5; i++){
            for(int j=0; j < 5; j++){
                System.out.print(plano[i][j]); 
            }
            System.out.println();
            System.out.println();
        }
    }

    public void moverRobo(Robo robo, int movimento)  throws MovimentoInvalidoException{
        int eixoX, eixoY;
        eixoX = robo.getEixoX();
        eixoY= robo.getEixoY();
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
            
            case 1:
                eixoX--;  
            break;
        }
        if(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0) 
        throw new MovimentoInvalidoException(); 
        
        plano[eixoY][eixoX] = "R    ";
    }
    public void moverRobo(Robo robo){
        int eixoX, eixoY;
        eixoX = robo.getEixoX();
        eixoY = robo.getEixoY();
        plano[eixoY][eixoX] = "R    ";
    }


    public boolean checarEncontroAlimento(Robo robo) {
        if(plano[robo.getEixoX()][robo.getEixoY()] == "A    ") {
            return true;
        }

        return false;
    }
}