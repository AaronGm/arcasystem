/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import dao.postgres.AlumnoDB;
import dao.postgres.CarreraDB;
import dao.postgres.CorreoAlumnoDB;
import dao.postgres.DireccionDB;
import models.Alumno;
import models.Carrera;
import models.CorreoAlumno;
import models.Direcciones;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aarongmx
 */
public class TestDB {
    public static void main( String[] args ) throws IOException, InvalidFormatException {

        Carrera carreraDB = new CarreraDB().getById("ISC");
        System.out.println(carreraDB);
        AlumnoDB al = new AlumnoDB();
//        al.insert();
//
        Alumno alumno = new Alumno("Aarón","Gómez", "Mendez", "151080112", 8, "Ago - Dic 19", carreraDB);
        al.insert(alumno);
//        al.list().forEach(System.out::println);
//        CorreoAlumnoDB correoAlumnoDB = new CorreoAlumnoDB();
//        correoAlumnoDB.insert(new CorreoAlumno("l151080126@iztapalapa.tecnm.mx", "151080112"));

//        System.out.println(correoAlumnoDB.getById(alumno));

//        String cp = "20116";
//        ArrayList<Direcciones> direcciones = (ArrayList<Direcciones>) new DireccionDB().selected(cp);
//        direcciones.forEach(el -> {
//
//            System.out.println(el.getColonia());
//            System.out.println(el.getMunicipio());
//        });






//
//            FileInputStream fis = new FileInputStream("C:\\Users\\aarongmx\\Desktop\\arcasystem\\gradel\\src\\main\\java\\tests\\t1.docx");
//            XWPFDocument doc = new XWPFDocument(OPCPackage.open(fis));
//            TestDB.rep(doc, "FECHA", Helpers.fechaDocumentos());
//            TestDB.rep(doc, "EPTO", "ISC");
//            TestDB.rep(doc, "NOOF", "0349");
//            TestDB.rep(doc, "YEAR", String.valueOf(Helpers.FECHA.getYear()));
//
//            TestDB.rep(doc, "ASESOR", "Ing. Aarón Gómez Méndez".toUpperCase());
//            TestDB.rep(doc, "REVISOR1", "Ing. Angel Gómez Méndez".toUpperCase());
//            TestDB.rep(doc, "REVISOR2", "Ing. Juan Martinez Nuñez".toUpperCase());
//            TestDB.rep(doc, "PROYECTO", "I.A. PARA EL LA CLASIFICACIÓN DE IMAGENES".toUpperCase());
//            TestDB.rep(doc, "ALUMNO", "ARTURO DÍAZ LÓPEZ".toUpperCase());
//            TestDB.rep(doc, "NOCONTROL", "151080123".toUpperCase());
//
//            try {
//                doc.write(new FileOutputStream("C:\\Users\\aarongmx\\Desktop\\arcasystem\\gradel\\src\\main\\java\\tests\\nuevoT1.docx"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
//        System.out.println(extractor.getText());


//        UsuarioDB usuarioDB = new UsuarioDB();
//        System.out.println(usuarioDB.auth("aarongm", "aagmx"));
//        ScheduledExecutorService executor = Executors.
//            newSingleThreadScheduledExecutor();
//
//        ScheduledFuture future = executor.scheduleAtFixedRate(
//            () -> System.out.println("Ya pasaron 10 segundos"), 10, 4, TimeUnit.SECONDS);
//
//        try {
//            future.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        executor.shutdown();
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
