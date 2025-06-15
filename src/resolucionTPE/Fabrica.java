package resolucionTPE;

import java.util.ArrayList;
import java.util.List;

public class Fabrica {
    private List<Maquina> maquinas; // Máquinas disponibles  
    
    //constructor que recibe una lista de maquinas 
    public Fabrica (List<Maquina> maquinas) {
    	this.maquinas = new ArrayList<>(maquinas);
    }
    
    //para agregar alguna maquina
    public void addMaquina(Maquina m) {
    	this.maquinas.add(m);
    }
    //para quitar alguna maquina
    public void quitarMaquina(Maquina m) {
    	this.maquinas.remove(m);
    }
    
    public void getRecursosFabrica() {
    	System.out.println("Recursos:");
    	listarMaquinas();
    	listarCantPiezas();
    	System.out.println("\n------------------------------------");
    }
    
    public void hacerPedido(int cantPiezas) {
    	if(cantPiezas <= 0 || maquinas.isEmpty()) {
        	System.out.println("No podemos aceptar el pedido, disculpe las molestias");   
    	}else {
    		System.out.println("Procesando pedido ( " + cantPiezas + " piezas )\n");
    	
    	//llamo a los metodos de resolver el pedido con Backtracking y greedy
    	System.out.println(" Solucion encontrada con Greedy:");
    	Greedy greedy = new Greedy(maquinas, cantPiezas);
    	System.out.println(greedy.resolver().getSolucionGreedy());
    	
    	System.out.println("- - - - - - - - - - - - - - - - - - - - ");
    	
    	System.out.println(" Solucion encontrada con Backtracking:");
    	Backtracking solver = new Backtracking(maquinas, cantPiezas);
    	System.out.println(solver.resolver());
    	System.out.println("------------------------------------");    		
    	}
    }
    
    
    //metodos para imprimir las maquinas que tiene la fabrica
	
	public void listarMaquinas(){
		System.out.print("\nMaquinas");
		for (Maquina m : this.maquinas) {
			System.out.print("|" + m.getNombre() +"| ");
		}
	}
	
	public void listarCantPiezas() {
		System.out.print("\nPiezas ");
		for (Maquina m : this.maquinas) {
			System.out.print(" |" + m.getPiezas() +"| ");
		}
	}
}
