package enums;

import java.util.Arrays;
import java.util.List;

public enum EstadoProfesor {
    TIEMPO_COMPLETO("Tiempo Completo"),
    CLAVE_10("Clave 10"),
    CLAVE_20("Clave 20"),
    CLAVE_95("Clave 95"),
    HORARIO("Por Horario"),
    ASIGNATURA("Por Asignatura");

    private String estado;

    EstadoProfesor(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static String[] getEstados() {
        List<EstadoProfesor> list = Arrays.asList(EstadoProfesor.values());
        String lista[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            lista[i] = list.get(i).getEstado();
        }
        return lista;
    }

}
