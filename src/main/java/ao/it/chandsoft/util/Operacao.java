package ao.it.chandsoft.util;

/**
 * @author CHANDIMBA
 */
public enum Operacao {
    ADICAO("parcela1", "parcela2", "+"),
    SUBTRACAO("diminuendo", "diminuidor", "-"),
    MULTIPLICACAO("factor1", "factor2", "*"),
    DIVISAO("dividendo", "divisor", "/");
    
    private String parametro1;
    private String parametro2;
    private String sinalDeOperacao;
    
    private Operacao(String parametro1, String parametro2, String sinalDeOperacao) {
        this.parametro1 = parametro1;
        this.parametro2 = parametro2;
        this.sinalDeOperacao = sinalDeOperacao;
    }

    public String getParametro1() {
        return parametro1;
    }

    public String getParametro2() {
        return parametro2;
    }

    public String getSinalDeOperacao() {
        return sinalDeOperacao;
    }
    
}