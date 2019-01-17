package enums;

public enum MensajesValidacion {
    SOLO_NUMEROS("¡Solo se permiten números!"),
    SOLO_LETRAS("¡Solo se permiten letras!"),
    ERROR_AUTH("¡Error de autenticación!"),
    NO_ITEMS_UPDATE("¡No hay registros para actualizar!"),
    NO_ITEMS_DELETE("¡No hay registros para eliminar!");

    private String mensaje;

    MensajesValidacion(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
