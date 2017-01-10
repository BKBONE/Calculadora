package ao.it.chandsoft.service;

import ao.it.chandsoft.exception.OperacaoException;
import ao.it.chandsoft.util.Operacao;
import ao.it.chandsoft.util.Validador;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 * @author CHANDIMBA
 */
@Service
public class CalculadoraService {

    private String operacao;
    private Validador validador = new Validador();
    
    public Map adicaoDeDoisNumeros(String parcela1, String parcela2) {
        Map<String, String> listaDeErrosDeValidacao = obterPossiveisErrosDeValidacao(parcela1, parcela2, operacao = "ADICAO");;

        if (!listaDeErrosDeValidacao.isEmpty()) {
            return listaDeErrosDeValidacao;
        }

        return calculaEObterResposta(parcela1, parcela2, operacao);
    }

    public Map subtracaoDeDoisNumeros(String diminuendo, String diminuidor) {

        Map<String, String> listaDeErros = obterPossiveisErrosDeValidacao(diminuendo, diminuidor, operacao = "SUBTRACAO");

        if (!listaDeErros.isEmpty()) {
            return listaDeErros;
        }

        return calculaEObterResposta(diminuendo, diminuidor, operacao);
    }

    public Map multiplicacaoDeDoisNumeros(String factor1, String factor2) {

        Map<String, String> listaDeErros = obterPossiveisErrosDeValidacao(factor1, factor2, operacao = "MULTIPLICACAO");;

        if (!listaDeErros.isEmpty()) {
            return listaDeErros;
        }
        
        return calculaEObterResposta(factor1, factor2, operacao);
    }

    public Map divisaoDeDoisNumeros(String dividendo, String divisor) {
        Map<String, String> listaDeErros = obterPossiveisErrosDeValidacao(dividendo, divisor, operacao = "DIVISAO");

        if (validador.isZero(divisor)) {
            listaDeErros.put("divisor", "Valor inválido. O divisor deve ser diferente de zero");
            return listaDeErros;
        }

        if (!listaDeErros.isEmpty()) {
            return listaDeErros;
        }

        return calculaEObterResposta(dividendo, divisor, operacao);
    }

    public Map<String, String> obterPossiveisErrosDeValidacao(String parcela1, String parcela2, String operacao) {
        Operacao op = Operacao.valueOf(operacao);

        Map<String, String> listaDeErros = new HashMap<>();

        if (validador.isNotNumero(parcela1)) {
            listaDeErros.put(op.getParametro1(), "Valor inválido. Deve informar um número");
        }

        if (validador.isNotNumero(parcela2)) {
            listaDeErros.put(op.getParametro2(), "Valor inválido. Deve informar um número");
        }
        return listaDeErros;
    }

    public Map<String, Object> calculaEObterResposta(String parametro1, String parametro2,  String operacao) {
        try {
            Operacao op = Operacao.valueOf(operacao);
            
            Double resultado = calcular(parametro1, parametro2, op);
            
            Map<String, Object> map = new HashMap<>();
            map.put("resultado", resultado);
            
            return map;
        } catch (OperacaoException ex) {
            Map<String, Object> map = new HashMap<>();
            map.put("erro", ex.getMessage());
            return map;
        }
    }

    private Double calcular(String parametro1, String parametro2, Operacao operacao) throws OperacaoException{
        switch(operacao.getSinalDeOperacao()) {
            case "+": return Double.valueOf(parametro1) + Double.valueOf(parametro2);
            case "-": return Double.valueOf(parametro1) - Double.valueOf(parametro2);
            case "*": return Double.valueOf(parametro1) * Double.valueOf(parametro2);
            case "/": return Double.valueOf(parametro1) / Double.valueOf(parametro2);
            default: throw new OperacaoException("Operacao não suportada");
        }
    }
    
}
