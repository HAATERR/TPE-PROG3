import resolucionTPE.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Leer archivo
            Lector.leerArchivo("src/archivos/archivo.txt");

            // Crear fábrica con las máquinas leídas
            Fabrica fabrica = new Fabrica(Lector.maquinas);

            // Mostrar recursos
            fabrica.getRecursosFabrica();

            // Procesar pedido
            fabrica.hacerPedido(Lector.objetivo);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
