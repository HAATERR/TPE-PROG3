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

### Solucion con Backtracking

***Solucion optima*** cuando la suma de las piezas que producen las maquinas agregadas a la solucion es igual al objetivo de piezas necesarias, se la compara con la mejor solucion encontrada hasta el momento. En el caso de que la nueva solucion tenga menor costo, se la guarda como la mejor solucion, y si no lo es, se la descarta

- ***Caso ideal:*** suma == objetivo y nuevaSolucion.costo < mejorSolucion.costo
  
Tenemos 2 podas: 

- **Poda por Exceso:** cuando la suma de piezas ya superó el objetivo se descarta, ya que las piezas no pueden disminuir
- **Poda de Optimización:** Si el costo (cant de activaciones) de la nueva solucion iguala o excede el costo de la mejor solucion encontrada hasta el momento, se descarta, esa solucion ya no puede ser mejor a la que tenemos


