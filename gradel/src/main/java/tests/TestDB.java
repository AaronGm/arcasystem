/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import dao.postgres.UsuarioDB;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.util.List;

/**
 *
 * @author aarongmx
 */
public class TestDB {
    public static void main( String[] args ) {
        /*InvalidFormatException {
            FileInputStream fis = new FileInputStream("/home/aarongmx/NetBeansProjects/ArcaSystem/src/tests/t1.docx");
            XWPFDocument doc = new XWPFDocument(OPCPackage.open(fis));
            TestDB.rep(doc, "FECHA", Helpers.fechaDocumentos());
            TestDB.rep(doc, "EPTO", "ISC");
            TestDB.rep(doc, "NOOF", "0349");
            TestDB.rep(doc, "YEAR", String.valueOf(Helpers.FECHA.getYear()));

            TestDB.rep(doc, "ASESOR", "Ing. Aarón Gómez Méndez".toUpperCase());
            TestDB.rep(doc, "REVISOR1", "Ing. Angel Gómez Méndez".toUpperCase());
            TestDB.rep(doc, "REVISOR2", "Ing. Juan Martinez Nuñez".toUpperCase());
            TestDB.rep(doc, "PROYECTO", "I.A. PARA EL LA CLASIFICACIÓN DE IMAGENES".toUpperCase());
            TestDB.rep(doc, "ALUMNO", "ARTURO DÍAZ LÓPEZ".toUpperCase());
            TestDB.rep(doc, "NOCONTROL", "151080123".toUpperCase());

            doc.write(new FileOutputStream("/home/aarongmx/NetBeansProjects/ArcaSystem/src/tests/new.docx"));
        XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
        System.out.println(extractor.getText());*/

        UsuarioDB usuarioDB = new UsuarioDB();
        System.out.println(usuarioDB.auth("aarongm", "aagmx"));

    }


    public static void rep(XWPFDocument doc, String wrd, String rep) {
        doc.getParagraphs().forEach(parrafos -> {
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
