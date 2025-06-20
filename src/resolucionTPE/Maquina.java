package resolucionTPE;

public class Maquina implements Comparable<Maquina>{
    private String nombre;
    private int piezas;

    public Maquina(String nombre, int piezas) {
        this.nombre = nombre;
        this.piezas = piezas;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPiezas() {
        return piezas;
    }

    @Override
    public String toString() {
        return nombre + " (" + piezas + ")";
    }
    public int compareTo(Maquina m) {//compara las maquinas de mayor a menor por produccion de piezas
    	return m.piezas - this.piezas; 
    }
}
