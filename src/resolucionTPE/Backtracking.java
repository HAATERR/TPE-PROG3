package resolucionTPE;
import java.util.*;

/*
 * - El árbol de exploración se genera combinando todas las posibles activaciones de máquinas.
 *   Cada nodo representa un estado parcial: una secuencia de activaciones y su suma de piezas.
 *   Desde cada nodo, se ramifica agregando una nueva activación, puede repetir.
 * - Un estado final es aquel cuya suma total de piezas es igual al objetivo.
 *   Un estado solución es aquel que alcanza el objetivo con la menor cantidad de activaciones posibles.
 * - Se aplican dos podas principales para reducir el espacio de búsqueda:
 *     1.Poda por exceso: si la suma parcial supera el objetivo, se descarta la rama.
 *     2.Poda por menos óptima: si la cantidad de activaciones ya es igual o mayor que la mejor solución encontrada hasta el momento, se corta la exploración.
 * - Se utiliza DFS, explorando todas las combinaciones posibles en orden recursivo.
 * - Se cuenta la cantidad de estados generados para medir el costo computacional del algoritmo.
 */



public class Backtracking {
    private List<Maquina> maquinas;
    private int objetivo;
    private Solucion mejorSolucion;
    private int estadosGenerados;

    public Backtracking(List<Maquina> maquinas, int objetivo){
      this.maquinas = maquinas;
      this.objetivo = objetivo;
      this.mejorSolucion = null;
      this.estadosGenerados = 0;
    }

    public Solucion resolver(){
        Solucion actual = new Solucion();
        backtrack(actual);
        if (mejorSolucion != null){
            mejorSolucion.setCosto(estadosGenerados);
        }
        return mejorSolucion;
    }
    private void backtrack(Solucion actual){
        estadosGenerados++;

        int suma = actual.getTotalPiezas();
        //Solucion ideal
        if (suma==objetivo){
            if (mejorSolucion == null || actual.getActivaciones() < mejorSolucion.getActivaciones()){
                mejorSolucion = copiarSolucion(actual);
            }
            return;
        }
        // Poda si me pase
        if (suma > objetivo){
            return;
        }

        // Poda si ya use mas activaciones que la mejor solucion
        if(mejorSolucion != null && actual.getActivaciones() >= mejorSolucion.getActivaciones()){
            return;
        }
        // Recorro todas las maquinas (puedo repitir)
        for (Maquina m : maquinas){
            actual.agregarMaquina(m);
            backtrack(actual);
            actual.quitarUltimaMaquina();
        }
    }
    private Solucion copiarSolucion(Solucion original){
        Solucion copia = new Solucion();
        for (Maquina m : original.getSecuencia()){
            copia.agregarMaquina(m);
        }
        return copia;
    }
}
