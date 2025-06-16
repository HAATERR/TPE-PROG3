## Problema general

Tenemos que encontrar la mejor solucion al proceso de seleccion de maquinas de una fabrica de construccion de automotores. Teniendo como objetivo encontrar la menor secuencia de maquinas que generen una cantidad especifica de piezas.

Teniendo en cuenta:

- **Maquinas**
    - Producen un numero determinado de piezas *(no se puede disminuir esa cantidad)*
    - La cant de piezas se conoce de antemano
    - Las maquinas solo pueden funcionar una a la vez
    - Pueden repetirse

**Objetivo:** Conseguir el conjuto solucion con la cantidad minima de maquinas que generen la cantidad de piezas necesarias.

### Solucion con Greedy

Analizamos el problema:

***¿Cuales son los candidatos que vamos a considerar para la solucion?***

- Lista de maquinas disponibles que producen una cantidad de piezas determinada cada una.

***¿Con que criterio greedy evaluamos a las maquinas?***

- Como necesitamos conseguir usar la menor cantidad de maquinas posibles para producir el pedido de piezas, es necesario ordenar la lista de maquinas de mayor a menor considerando la cantidad de piezas que producen. Esto nos garantiza que siempre seleccionemos la maquina mas productiva, pudiendo llegar a la cantidad de piezas necesarias mas rapido.
