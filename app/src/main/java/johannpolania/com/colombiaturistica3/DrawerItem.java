package johannpolania.com.colombiaturistica3;

/**
 * Created by koanco on 24/04/2016.
 */
public class DrawerItem {

    private String opcion;
    private int icono;

    public DrawerItem(String opcion, int icono) {
        this.opcion = opcion;
        this.icono = icono;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
