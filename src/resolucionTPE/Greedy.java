package resolucionTPE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Conseguir la secuencia minima de maquinas que puedan producir la cantidad de piezas que se piden
    Estrategia greedy: intentar usar las más maquinas que producen mas piezas primero
    Criterio greedy: Ordenamos las máquinas de mayor a menor segun la cant de piezas que producen
    Solucion: sentencia minima de maquinas que lleguen lo mas cerca de la solucion
 */
public class Greedy {
    private List<Maquina> maquinas; // Máquinas disponibles
    private int piezasNecesarias;          // Cantidad de piezas necesarias (se busca no pasarnos)
    private int cantMaquinasConsideradas; // Contador de costo para greedy
    
    public Greedy(List<Maquina> maquinas, int objetivo) {
        this.maquinas = new ArrayList<>(maquinas);
        this.piezasNecesarias = objetivo;
        this.cantMaquinasConsideradas = 0;
    }
    public Solucion resolver() {
        Solucion solucion = new Solucion();
        Collections.sort(this.maquinas);

        //Si la maquina mas productiva produce 0 piezas, no podemos hacer nada 
        if (this.maquinas.get(0).getPiezas() <= 0) {
            System.out.println("No se puede producir piezas");
            solucion.setCosto(cantMaquinasConsideradas);
            return solucion;
        }
       
       int indiceMaquina = 0; //indice de las maquinas consideradas para la solucion
        
        // Mientras no hayamos llegado al objetivo y que todavia nos queden maquinas que considerar
        while (solucion.getTotalPiezas() < this.piezasNecesarias && indiceMaquina < this.maquinas.size()) {
            
        	Maquina maquinaCandidata = this.maquinas.get(indiceMaquina);

            // si la suma de piezas en produccion + las piezas de la maquina seleccionada no supera el objetivo (cantidad de piezas especificas)
            if (solucion.getTotalPiezas() + maquinaCandidata.getPiezas() <= this.piezasNecesarias) {
                //agrego la maquina a la solucion
            	solucion.agregarMaquina(maquinaCandidata);
            	//sumamos uno a la cantidad de maquinas consideradas hasta ahora, para llevar el registro del costo
                this.cantMaquinasConsideradas++; 
                //Considerando que se pueden repetir las maquinas, al no pasar a la siguiente maquina una vez agregada a la solucion, 
                //podemos revaluarla, para ver si se puede usar nuevamente y asi llegar mas rapido al objetivo
            } else {
                // Si la maquina no nos sirve, pasamos a la siguiente máquina
                indiceMaquina++;
                if (indiceMaquina >= this.maquinas.size()) {
                    // Ya no hay máquinas que podamos agregar
                    break;
                }
            }
        }

        // Si al final del proceso no alcanzamos el objetivo exacto
        // retornamos el mejor resultado conseguido si lo hay
        solucion.setCosto(this.cantMaquinasConsideradas);
        return solucion;
    }
}