# Actividades Multihilo

## Descripción del ejercicio

Este proyecto simula un sistema de productores y consumidores utilizando programación multihilo en Java. Cada productor genera productos de forma aleatoria y los deposita en un recurso compartido (Store), mientras que varios consumidores recogen y procesan esos productos.  
El objetivo es modelar una empresa donde se generan productos y se consumen siguiendo restricciones reales: capacidad limitada del almacén, tiempos variables de producción y consumo, espera cuando no hay productos o cuando el almacén está lleno, etc.

---

## Tipo de empresa elegido

Una empresa que produce diversos productos (lácteos, carnes, verduras,etc).

---

## Papel de cada elemento

### Manufacturer:

- Es un hilo que genera un producto.
- Sabe cuántos productos debe generar.
- Cada producto tarda un tiempo aleatorio en producirse.
- Si el almacén está lleno → espera.
- Cuando deposita un producto, notifica al resto de hilos.

### Client:

- Es el hilo consumidor que retira productos del `Store`.
- Espera si el almacén está vacío y consume productos a un ritmo variable.

### Store:

- Es el recurso compartido donde los productores depositan los productos y los consumidores los retiran.
- Tiene una capacidad máxima fija, controlando que no se sobrepase.
- Gestiona accesos concurrentes usando `synchronized`, `wait()` y `notifyAll()`.
- Hace que los productores esperen si el almacén está lleno y que los consumidores esperen si está vacío.

#### Controla:

- Espera si está lleno (para productores).
- Espera si está vacío (para consumidores).

---

## Diagrama simple

```
Productores --> [   STORE (capacidad N)   ] --> Consumidores
```

---

## Cómo ejecutar

Debido a que se solicitó que cada experimento se realizara en una rama distinta y que específicamente **estas no se mergearán a main**, el `main` está vacío. Anteriormente tenía métodos para realizar pruebas, pero se corrigió al final del ejercicio.  
Se deberá ir a **cada rama** para poder ejecutar su correspondiente experimento.

---

## Tecnologías usadas

- Java 17
- Programación multihilo
- `Thread`, `wait()`, `notifyAll()`, sincronización

---

## Organización del repositorio

- `main` → rama principal
- `develop` → rama de desarrollo
- `feature/threads` → se crearon los hilos
- `feature/experiments` → se crearon los experimentos para pruebas

## Experimentos

[Ir al Experimento Uno](./src/docs/experimentoUno.md)

[Ir al Experimento Dos](./src/docs/experimentoDos.md)

[Ir al Experimento Tres](./src/docs/experimentoTres.md)
