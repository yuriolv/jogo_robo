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

    public int definirAlimento(int eixoY, int eixoX) throws PosicaoInvalidaException{
        if(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0) 
            throw new PosicaoInvalidaException();

        if(eixoY > 2)
            eixoY = 4 % eixoY;
        else if(eixoY < 2)
            eixoY = (eixoY % 10) - 6;

        plano[eixoY][eixoX] = "A    ";

        return eixoY;
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


    public boolean checarEncontroAlimento(Robo robo , int eixoX, int eixoY) {
        if(robo.getEixoX() == eixoX && robo.getEixoY() == eixoY) { //aplicar a mesma lógica do definir alimento
            return true;
        }

        return false;
    }

    public void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
}