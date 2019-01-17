package enums;

import java.util.Arrays;
import java.util.List;

public enum EstatusProyecto {
    SINRESPUESTA("----"),
    ACEPTADO("Aceptado"),
    RECHAZADO("Rechazado");

    private String estado;

    EstatusProyecto(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static String[] getEstados() {
        List<EstatusProyecto> list = Arrays.asList(EstatusProyecto.values());
        String lista[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            lista[i] = list.get(i).getEstado();
        }
        return lista;
    }

}
