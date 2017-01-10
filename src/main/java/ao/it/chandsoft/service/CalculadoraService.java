package ao.it.chandsoft.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * @author CHANDIMBA
 */

@Service
public class CalculadoraService {
    
    public Map adicaoDeDoisNumeros(String parcela1, String parcela2) {
        Map<String,String> listaDeErros = new HashMap<>();
        
        if(isNotNumero(parcela1)) {
            listaDeErros.put("parcela1", "Valor inválido. Deve informar um número");
        }
        
        if(isNotNumero(parcela2)) {
            listaDeErros.put("parcela2", "Valor inválido. Deve informar um número");
        }
        
        if(!listaDeErros.isEmpty()) {
           return listaDeErros; 
        }
        
        Long soma = Long.valueOf(parcela1) + Long.valueOf(parcela2);
        Map<String,Long> resultado = new HashMap<>();      
        
        resultado.put("parcela1", Long.valueOf(parcela1) );
        resultado.put("parcela2", Long.valueOf(parcela2) );
        resultado.put("resultado", soma);
        
        return resultado;
    }
    
    public Map subtracaoDeDoisNumeros(String diminuendo, String diminuidor) {

        
        Map<String,String> listaDeErros = new HashMap<>();
        
        if(isNotNumero(diminuendo)) {
            listaDeErros.put("diminuendo", "Valor inválido. Deve informar um número");
        }
        
        if(isNotNumero(diminuidor)) {
            listaDeErros.put("diminuidor", "Valor inválido. Deve informar um número");
        }
        
        if(!listaDeErros.isEmpty()) {
           return listaDeErros; 
        }
        
        Long soma = Long.valueOf(diminuendo) - Long.valueOf(diminuidor);
        Map<String,Long> resultado = new HashMap<>();
        
        resultado.put("diminuendo", Long.valueOf(diminuendo) );
        resultado.put("diminuidor", Long.valueOf(diminuidor) );
       

        resultado.put("resultado", soma);
        
        
        return resultado;
    }
    
    public Map multiplicacaoDeDoisNumeros(String factor1, String factor2) {
        
      Map<String,String> listaDeErros = new HashMap<>();
        
        if(isNotNumero(factor1)) {
            listaDeErros.put("factor1", "Valor inválido. Deve informar um número");
        }
        
        if(isNotNumero(factor2)) {
            listaDeErros.put("factor2", "Valor inválido. Deve informar um número");
        }
        
        if(!listaDeErros.isEmpty()) {
           return listaDeErros; 
        }
        Long soma = Long.valueOf(factor1) * Long.valueOf(factor2);
        Map<String,Long> resultado = new HashMap<>();
        resultado.put("factor1", Long.valueOf(factor1) );
        resultado.put("factor2", Long.valueOf(factor2) );
        
 
        resultado.put("resultado", soma);
        
        
        return resultado;
    }
    
    public Map divisaoDeDoisNumeros(String dividendo, String divisor) {

        
        Map<String,String> listaDeErros = new HashMap<>();
        
        if(isNotNumero(dividendo)) {
            listaDeErros.put("dividendo", "Valor inválido. Deve informar um número");
        }
        
        if(isNotNumero(divisor)) {
            listaDeErros.put("divisor", "Valor inválido. Deve informar um número");
        }
        
        if(!listaDeErros.isEmpty()) {
           return listaDeErros; 
        }
        Long soma = Long.valueOf(dividendo) / Long.valueOf(divisor);
        Map<String,Long> resultado = new HashMap<>();
        resultado.put("dividendo", Long.valueOf(dividendo) );
        resultado.put("divisor", Long.valueOf(divisor) );
        
        
        resultado.put("resultado", soma);
        
        
        return resultado;
    }
    
    public boolean isNotNumero(String str) {
        return !str.matches("\\d{1,}");
    }
    
}