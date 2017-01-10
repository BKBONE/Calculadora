package ao.it.chandsoft.controller;

import ao.it.chandsoft.service.CalculadoraService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Responsável por mapear as URLs das operações matemáticas
 * @author CHANDIMBA
 */
@RestController //
@RequestMapping("/calculadora") // mapeia a url calculadora
public class CalculadoraController {
    
    @Autowired
    private CalculadoraService calculadoraService; //injecta o objecto "calculadoraService" 
    
    @RequestMapping(value = "/adicao", produces = {MediaType.APPLICATION_JSON_VALUE}) 
    public Map adicaoDeDoisNumeros(
            //adiciona os parâmetro para a url "adicao"
            @RequestParam(name = "parcela1", defaultValue = "0") String parcela1, 
            @RequestParam("parcela2") String parcela2) {
        //retorna a adição dos dois nº informados como parâmetros da url
        return calculadoraService.adicaoDeDoisNumeros(parcela1, parcela2);
    }
    
    @RequestMapping(value = "/subtracao", produces = {MediaType.APPLICATION_JSON_VALUE}) 
    public Map subtracaoDeDoisNumeros(
            //adiciona os parâmetro para a url "subtracao"
            @RequestParam("diminuendo") String diminuendo,
            @RequestParam("diminuidor") String diminuidor) {
        //retorna a subtração dos dois nº informados como parâmetros da url
        return calculadoraService.subtracaoDeDoisNumeros(diminuendo, diminuidor);
    }
    
    @RequestMapping(value = "/multiplicacao", produces = {MediaType.APPLICATION_JSON_VALUE}) 
    public Map multiplicacaoDeDoisNumeros(
            //adiciona os parâmetro para a url "multiplicacao"
            @RequestParam("factor1") String factor1,
            @RequestParam("factor2") String factor2) {
        //retorna a multiplicação dos dois nº informados como parâmetros da url
        return calculadoraService.multiplicacaoDeDoisNumeros(factor1, factor2);
    }
    
    @RequestMapping(value = "/divisao", produces = {MediaType.APPLICATION_JSON_VALUE}) 
    public Map divisaoDeDoisNumeros(
            //adiciona os parâmetro para a url "divisao"
            @RequestParam("dividendo") String dividendo,
            @RequestParam("divisor") String divisor) {
        //retorna a divisão dos dois nº informados como parâmetros da url
        return calculadoraService.divisaoDeDoisNumeros(dividendo, divisor);
    }
    
}
