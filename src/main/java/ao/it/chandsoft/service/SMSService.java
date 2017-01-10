package ao.it.chandsoft.service;

import ao.it.chandsoft.modelo.SMS;
import ao.it.chandsoft.util.SMSUtil;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author CHANDIMBA
 */
@Service
public class SMSService {

    @Autowired
    private SMSUtil smsUtil;

    public ResponseEntity obterConteudoDoFicheiro(HttpServletRequest request) {

        try {
            URL url = getClass().getResource("ao/it/chandsoft/ficheiros/sms2.xls");

            
            System.out.println(url);
            
            if (url != null) {
                //System.out.println("toExternalForm: " + url.toExternalForm());
                System.out.println("toURI: " + url.toURI());
                System.out.println("toURI().getPath: " + url.toURI().getPath());
                System.out.println("toURI().getRawPath: " + url.toURI().getRawPath());
                System.out.println("toURI().toString: " + url.toURI().toString());
            } else {
                System.out.println("URL is null");
            }

            File ficheiro = new File(request.getServletContext().getRealPath("sms2.xls"));
            List<SMS> smss = smsUtil.obterConteudoDoFicheiro(ficheiro);

            return ResponseEntity.ok(smss);
        } catch (IOException | BiffException | URISyntaxException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(ex.getMessage());
        }
    }

}
