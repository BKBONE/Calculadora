package ao.it.chandsoft.util;

/**
 * @author CHANDIMBA
 */
public class Validador {
    
    public boolean isNotNumero(String str) {
        return !str.matches("\\d{1,}(\\.\\d{1,})?");
    }

    public boolean isZero(String numero) {
        return numero.equals("0");
    }
    
}
