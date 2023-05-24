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
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLACK = "\u001B[030m";
        String ANSI_GREEN = "\u001B[042m";
        


        if(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0) 
            throw new PosicaoInvalidaException();

        if(eixoY > 2)
            eixoY = 4 % eixoY;
        else if(eixoY < 2)
            eixoY = ((eixoY - 10) + 6) * -1;

        plano[eixoY][eixoX] = ANSI_GREEN + ANSI_BLACK + "%" + ANSI_RESET +"    ";

        return eixoY;
    }

    public void mostrarPlano(){
        for(int i=0;i < 5; i++){
            for(int j=0; j < 5; j++){
                if(j == 0)
                System.out.print("            ");
                System.out.print(plano[i][j]); 
            }
            System.out.println();
            System.out.println();
        }
    }

    public void moverRobo(Robo robo, int movimento)  throws MovimentoInvalidoException{
        int eixoX, eixoY;
        eixoX = robo.getEixoX();
        eixoY = robo.getEixoY();

        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_PURPLE = "\u001B[35m";
        
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

            default:
                throw new MovimentoInvalidoException();
        }
        if(eixoX > 4 || eixoY > 4 || eixoX < 0 || eixoY < 0) 
            throw new MovimentoInvalidoException(); 

        if(robosJuntos(robo, eixoX, eixoY))
            plano[eixoY][eixoX] = ANSI_PURPLE+"R    "+ANSI_RESET;

        else if((robo.getCor()).equals("Vermelho"))
            plano[eixoY][eixoX] = ANSI_RED+"R    "+ANSI_RESET;
        else 
            plano[eixoY][eixoX] = ANSI_BLUE+"R    "+ANSI_RESET; 
    }


    public void moverRobo(Robo robo){
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_PURPLE = "\u001B[35m";

        int eixoX, eixoY;
        eixoX = robo.getEixoX();
        eixoY = robo.getEixoY();
        

      
        if(robosJuntos(robo, eixoX, eixoY))
            plano[eixoY][eixoX] = ANSI_PURPLE+"R    "+ANSI_RESET;
         
        else if(robo.getCor().equals("Vermelho"))
            plano[eixoY][eixoX] = ANSI_RED+"R    "+ANSI_RESET;
            
        else 
            plano[eixoY][eixoX] = ANSI_BLUE+"R    "+ANSI_RESET; 
        
        
            
    }
    public boolean robosJuntos(Robo robo, int eixoX, int eixoY) {
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";     

        if(robo.getCor().equals("Vermelho") && plano[eixoY][eixoX].equals(ANSI_BLUE+"R    "+ANSI_RESET))
            return true;
        
        else if(robo.getCor().equals("Azul") && plano[eixoY][eixoX].equals(ANSI_RED+"R    "+ANSI_RESET))
            return true;

        else
            return false;
    }

    public boolean checarEncontroAlimento(Robo robo , int eixoX, int eixoY) {
        if(robo.getEixoX() == eixoX && robo.getEixoY() == eixoY) {
            return true;
        }

        return false;
    }

    public void mostrarResultado(Robo walle, Robo eva){
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";

        System.out.println("--------------------------------------------------");
        System.out.println(ANSI_BLUE+walle.toString()+ANSI_RESET);
        System.out.println("--------------------------------------------------");
        System.out.println(ANSI_RED+eva.toString()+ANSI_RESET);
        System.out.println("--------------------------------------------------");
    }

    public void mostrarComandos(){
        System.out.println("-------------------------------------------------");
        System.out.println("Para mover o Robo utilize os seguintes comandos: ");
        System.out.println("                   5 ou 'Up'\n");
        System.out.println("                       ^");
        System.out.println("                       |");
        System.out.println("                       |");
        System.out.println("1 ou 'Left'      <----   ---->        3 ou 'Right'");
        System.out.println("                       |");
        System.out.println("                       |");
        System.out.println("                       v");
        System.out.println("                   2 ou 'Down'\n");
        System.out.println("-------------------------------------------------");

        mostrarTransição(5500);
        ClearConsole();
    }
    public void mostrarTransição(int tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            // TODO: handle exception
        }
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
