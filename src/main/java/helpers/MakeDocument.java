package helpers;

import excepciones.ExcepcionGeneral;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class MakeDocument {

    private XWPFDocument docx;

    public MakeDocument(String filePath) throws ExcepcionGeneral {
        try {
            FileInputStream document = new FileInputStream(filePath);
            docx = new XWPFDocument(document);
        } catch (IOException e) {
            throw new ExcepcionGeneral(e.getMessage());
        }
    }


    public void replace(String wrd, String rep) {
        docx.getParagraphs().forEach(parrafos -> {
            List<XWPFRun> runs = parrafos.getRuns();
            if (runs != null) {
                runs.forEach(run -> {
                    String text = run.getText(0);
                    if (text != null && text.contains(wrd)) {
                        text = text.replaceAll(wrd, rep);
                        run.setText(text, 0);
                    }
                });
            }
        });
    }



}
