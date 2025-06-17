package resolucionTPE;
import java.io.*;
import java.util.*;

public class Lector {

    public static List<Maquina> maquinas = new ArrayList<>();
    public static int objetivo;

    public static void leerArchivo(String rutaArchivo) throws IOException {
        maquinas.clear();
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        objetivo = Integer.parseInt(br.readLine());

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(", ");
            String nombre = partes[0];
            int piezas = Integer.parseInt(partes[1]);
            maquinas.add(new Maquina(nombre, piezas));
        }

        br.close();
    }
}
