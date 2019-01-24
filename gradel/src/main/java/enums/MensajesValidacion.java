package enums;

public enum MensajesValidacion {
    SOLO_NUMEROS("¡Solo se permiten números!"),
    SOLO_LETRAS("¡Solo se permiten letras!"),
    CAMPO_VACIO("¡No puede dejar este campo vacio!"),
    ERROR_AUTORIZACION("¡Error de autenticación!"),
    NO_HAY_ELEMENTOS_ACTUALIZAR("¡No hay registros para actualizar!"),
    NO_HAY_ELEMENTOS_ELIMINAR("¡No hay registros para eliminar!"),
    CERRAR_APLICACION("¿Realmente desea cerrar la aplicación?"),
    CAMPO_SIN_SELECCIONAR("¡Haga una selección por favor!");


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
