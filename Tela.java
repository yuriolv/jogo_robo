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

    public void definirAlimento(int eixoX, int eixoY) throws PosicaoInvalidaException{
        if(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0) 
            throw new PosicaoInvalidaException();

        plano[eixoX][eixoY] = "A    ";
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

    public void moverRobo(int eixoY, int eixoX){
        plano[eixoY][eixoX] = "R    ";
    }

    public boolean checarEncontroAlimento(Robo robo) {
        if(plano[robo.getEixoX()][robo.getEixoY()] == "A    ") {
            return true;
        }

        return false;
    }
}