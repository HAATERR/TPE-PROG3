package resolucionTPE;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    	List<Maquina> maquinas = List.of(
                new Maquina("M1", 7),
                new Maquina("M2", 3),
                new Maquina("M3", 4),
                new Maquina("M4", 1)
        );
		
		Fabrica autoPartes = new Fabrica (maquinas);
		autoPartes.getRecursosFabrica();
		autoPartes.hacerPedido(33);
    }
}
