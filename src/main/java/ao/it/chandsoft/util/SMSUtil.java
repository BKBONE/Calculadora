package ao.it.chandsoft.util;

import ao.it.chandsoft.modelo.SMS;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

/**
 * @author CHANDIMBA
 */
@Component
public class SMSUtil {

    private SimpleDateFormat formatadorDeData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public List<SMS> obterConteudoDoFicheiro(File ficheiro) throws IOException, BiffException {
        FileSystemResource fileSystemResource = new FileSystemResource("src/main/resources/excel/sms2.xls");
        
        //return listarConteudoDoFicheiroXLS(ficheiro);
        return listarConteudoDoFicheiroXLS2(fileSystemResource.getFile());
        
    }

    /* 
    Leitura do ficheiro XLS utilizando a biblioteca Jexcel API (jxl)
    Não está a ser utilizado
     */
    public List<SMS> listarConteudoDoFicheiroXLS(File ficheiro) throws IOException, BiffException {
        Workbook ficheiroXLS = Workbook.getWorkbook(ficheiro);
        List<SMS> mensagens = new ArrayList<>();
        Sheet folhaInicial = ficheiroXLS.getSheet(0);

        for (int j = 0; j < folhaInicial.getRows(); j++) {
            
            SMS sms = new SMS();
            sms.setDestinatario(folhaInicial.getCell(1, j).getContents().trim());
            sms.setMensagem(folhaInicial.getCell(2, j).getContents().trim());
            sms.setDataHora(folhaInicial.getCell(0, j).getContents().trim());

            mensagens.add(sms);
           
        }

        
        return mensagens;
    }

    /* 
    Leitura do ficheiro XLS utilizando a biblioteca Apache POI
     */
    public List<SMS> listarConteudoDoFicheiroXLS2(File ficheiro) throws FileNotFoundException {
        
        List<SMS> mensagens = new ArrayList<>();
        
        try (FileInputStream file = new FileInputStream(ficheiro)) {
            HSSFWorkbook ficheiroXLS = new HSSFWorkbook(file); // cria uma instância
            HSSFSheet folhaInicial = ficheiroXLS.getSheetAt(0); // obtem a primeira folha do ficheiro xls

            Iterator<Row> iterador = folhaInicial.iterator(); // objecto para iterar as linhas do ficheiro xls
            
            iterador.forEachRemaining(linhaActual -> {
                SMS sms = new SMS();
                Double telefone = linhaActual.getCell(1).getNumericCellValue();
                sms.setDestinatario(String.valueOf(telefone.longValue()));
                sms.setMensagem(linhaActual.getCell(2).getStringCellValue().trim());
                Double data = linhaActual.getCell(0).getNumericCellValue();
                sms.setDataHora(formatadorDeData.format(new Date(data.longValue())));

                mensagens.add(sms);
   
            });
            
            System.out.println(mensagens.size());
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mensagens;

    }
}
