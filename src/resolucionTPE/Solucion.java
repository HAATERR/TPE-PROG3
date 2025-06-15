package resolucionTPE;
import java.util.ArrayList;

import java.util.List;


public class Solucion {
    private List<Maquina> secuencia;
    private int totalPiezas;
    private int costo;

    public Solucion() {
        this.secuencia = new ArrayList<>();
        this.totalPiezas = 0;
        this.costo = 0;
    }

    public void agregarMaquina(Maquina m) {
        secuencia.add(m);
        totalPiezas += m.getPiezas();
    }

    public void quitarUltimaMaquina() {
        if(!secuencia.isEmpty()) {
            Maquina ultima = secuencia.remove(secuencia.size() - 1);
            totalPiezas -= ultima.getPiezas();
        }
    }
    public int getTotalPiezas() {
        return totalPiezas;
    }
    public int getCosto() {
        return costo;
    }
    public int getActivaciones(){
        return secuencia.size();
    }
    public List<Maquina> getSecuencia() {
        return secuencia;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Secuencia: ");
        for (Maquina m : secuencia) {
            sb.append(m.getNombre()).append(" ");
        }
        sb.append("\nTotal piezas: ").append(totalPiezas);
        sb.append("\nActivaciones: ").append(getActivaciones());
        sb.append("\nCosto: ").append(costo);
        return sb.toString();
    }
    //modifico el texto de la informacion para que vaya con el significado del greedy
    public String getSolucionGreedy() {
    	StringBuilder sb = new StringBuilder("Secuencia: ");
        for (Maquina m : secuencia) {
            sb.append(m.getNombre()).append(" ");
        }
        sb.append("\nTotal piezas: ").append(totalPiezas);
        sb.append("\nCantidad de candidatos considerados: ").append(costo);
        return sb.toString();
    }
}
