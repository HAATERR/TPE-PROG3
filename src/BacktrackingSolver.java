import java.util.*;
public class BacktrackingSolver {
    private List<Maquina> maquinas;
    private int objetivo;
    private Solucion mejorSolucion;
    private int estadosGenerados;

    public BacktrackingSolver(List<Maquina> maquinas, int objetivo){
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
