package exception;

public class MovimentoInvalidoException extends Exception {

    public String toString(){
        return "O ultimo movimento foi invalido";
    }
}
