## Problema general

Tenemos que encontrar la mejor solucion al proceso de seleccion de maquinas de una fabrica de construccion de automotores. Teniendo como objetivo encontrar la menor secuencia de maquinas que generen una cantidad especifica de piezas

Teniendo en cuenta:

- **Maquinas**
    - Producen un numero determinado de piezas *(no se puede disminuir esa cantidad)*
    - La cant de piezas se conoce de antemano
    - Las maquinas solo pueden funcionar una a la vez
    - Pueden repetirse

**Objetivo:** Conseguir el conjuto solucion con la cantidad minima de maquinas que generen la cantidad de piezas necesarias

### Solucion con Greedy

Analizamos el problema:

***¿Cuales son los candidatos que vamos a considerar para la solucion?***

- Lista de maquinas disponibles que producen una cantidad de piezas determinada cada una.

***¿Con que criterio greedy evaluamos a las maquinas?***

- Como necesitamos conseguir usar la menor cantidad de maquinas posibles para producir el pedido de piezas, es necesario ordenar la lista de maquinas de mayor a menor considerando la cantidad de piezas que producen. Esto nos garantiza que siempre seleccionemos la maquina mas productiva, pudiendo llegar a la cantidad de piezas necesarias mas rapido

### Solución con Backtracking

La estrategia de resolución consiste en construir todas las combinaciones posibles de activaciones de máquinas utilizando búsqueda en profundidad (DFS), aplicando poda para evitar ramas innecesarias.

Se considera una **solución óptima** cuando la suma de las piezas producidas por las máquinas activadas es *exactamente igual al objetivo*, y además *tiene menor costo* que la mejor solución encontrada hasta el momento. Si cumple estas condiciones, se guarda como nueva mejor solución, si no, se descarta.

Esta estrategia permite recorrer únicamente las ramas prometedoras del árbol de decisiones, mejorando el rendimiento sin afectar la corrección del algoritmo.

#Condición de solución ideal:
- `suma == objetivo` **y** `activaciones < mejorSolucion.activaciones`

#Se aplican dos podas principales:

- **Poda por exceso:**  
  Si la suma parcial de piezas supera el objetivo, la rama se descarta directamente, ya que no se pueden restar piezas.

- **Poda por optimización:**  
  Si la cantidad de activaciones ya iguala o supera la cantidad de activaciones de la mejor solución encontrada, también se descarta, porque no puede mejorar el resultado.



