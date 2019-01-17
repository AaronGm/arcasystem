package enums;

import java.util.Arrays;
import java.util.List;

public enum GradoEstudios {
    LICIENCIATURA("Licenciatura"),
    INGENIERIA("Ingeniería"),
    MAESTRIA("Maestría"),
    DOCTORADO("Doctorado");

    private String grado;
    GradoEstudios(String grado) {
        this.grado = grado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public static String[] getGrados() {
        List<GradoEstudios> list = Arrays.asList(GradoEstudios.values());
        String lista[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            lista[i] = list.get(i).getGrado();
        }
        return lista;
    }
}
