//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Maquina> maquinas = List.of(
                new Maquina("M1", 7),
                new Maquina("M2", 3),
                new Maquina("M3", 4),
                new Maquina("M4", 1)
        );

        int objetivo = 2;

        BacktrackingSolver solver = new BacktrackingSolver(maquinas, objetivo);
        Solucion solucion = solver.resolver();

        System.out.println(" Solución encontrada con Backtracking:");
        System.out.println(solucion);

        }
    }
