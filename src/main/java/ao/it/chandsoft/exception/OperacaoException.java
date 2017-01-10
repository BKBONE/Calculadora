package ao.it.chandsoft.exception;

/**
 *
 * @author CHANDIMBA
 */
public class OperacaoException extends Exception{
    private String mensagem;

    public OperacaoException(String mensagem) {
        this.mensagem = mensagem;
    }
    
}
