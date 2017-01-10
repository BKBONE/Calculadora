package ao.it.chandsoft.controller;

import ao.it.chandsoft.service.SMSService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Responsável por mapear a url 
 * @author CHANDIMBA
 */
@RestController
@RequestMapping("/smsenviado") // mapeia a url calculadora
public class SMSController {
    
    @Autowired
    private SMSService smsService;
    
    
    @RequestMapping(value = "listar-todos", //mapeia a url "xls" na url "sms"
            produces = MediaType.APPLICATION_JSON_VALUE)// retorna um JSON
    
    public ResponseEntity obterConteudoDoFicheiro(HttpServletRequest request) {
        return smsService.obterConteudoDoFicheiro(request);
    }
    
}
