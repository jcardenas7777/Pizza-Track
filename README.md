#  Pizza-Track — Sistema de Gestión de Pedidos con Undo/Redo

Proyecto desarrollado en Java como actividad académica para comprender la estructura de datos **Pila (Stack)** aplicada a un sistema real de gestión de pedidos de pizzería.

---

##  Arquitectura del Proyecto

```
PizzaTrack/
├── src/
│   ├── Pizza.java          → Modelo de datos (nombre + arreglo[3] ingredientes)
│   ├── Nodo.java           → Nodo de la lista ligada
│   ├── PilaManual.java     → Implementación de la pila con lista ligada
│   ├── GestionPedidos.java → Controlador Undo/Redo (dos pilas)
│   └── Main.java           → Menú interactivo en consola
└── README.md
```

---

## Diagrama de la Estructura

```
PILA PRINCIPAL (pilaUndo)       PILA SECUNDARIA (pilaRedo)
┌──────────────────┐            ┌──────────────────┐
│  Pizza Hawaiana  │ ← TOPE    │                  │
├──────────────────┤            │   (vacía al      │
│  Pizza Margherita│            │    inicio)       │
├──────────────────┤            │                  │
│  Pizza BBQ       │ ← BASE    └──────────────────┘
└──────────────────┘
         │ pop() al hacer Undo ──────────────► push() en pilaRedo
         │ ◄──────── pop() de pilaRedo al hacer Redo
```

---

## ⚙️ Clases y Responsabilidades

### `Pizza.java`
- Representa un pedido de pizza.
- Atributos: `nombre` (String) e `ingredientes` (String[3] — arreglo fijo).
- Constructor: recibe nombre y 3 ingredientes por separado.

### `Nodo.java`
- Eslabón de la lista ligada.
- Contiene un objeto `Pizza` y la referencia `siguiente` al próximo nodo.

### `PilaManual.java`
- Implementación de pila desde cero con lista ligada.
- **Restricción cumplida:** no usa `java.util.Stack`.
- Métodos obligatorios:
  | Método | Descripción |
  |--------|-------------|
  | `push(Pizza)` | Inserta pizza en el tope |
  | `pop()` | Retira y devuelve la pizza del tope |
  | `peek()` | Consulta el tope sin retirarlo |
  | `isEmpty()` | Retorna `true` si la pila está vacía |

### `GestionPedidos.java`
- Coordina dos instancias de `PilaManual`:
  - **pilaUndo** (Principal): pedidos activos.
  - **pilaRedo** (Secundaria): pedidos deshechos temporalmente.
- Al registrar un nuevo pedido, **limpia pilaRedo** (comportamiento estándar de Undo/Redo).

### `Main.java`
- Menú interactivo con las siguientes opciones:
  ```
  1. Registrar Pizza  → push() en pilaUndo
  2. Deshacer (Undo)  → pop() pilaUndo + push() pilaRedo
  3. Rehacer (Redo)   → pop() pilaRedo + push() pilaUndo
  4. Mostrar Actual   → peek() en pilaUndo
  5. Ver Estado       → muestra ambas pilas
  0. Salir
  ```

---

## Flujo Undo/Redo

```
Acción          pilaUndo (tope→base)       pilaRedo (tope→base)
──────────────────────────────────────────────────────────────
Registrar A     [A]                        []
Registrar B     [B, A]                     []
Registrar C     [C, B, A]                  []
Undo            [B, A]                     [C]
Undo            [A]                        [B, C]
Redo            [B, A]                     [C]
Registrar D     [D, B, A]                  []  ← Redo se limpia
```

---

##  Cómo Compilar y Ejecutar

```bash
# Compilar (desde la carpeta src/)
javac Pizza.java Nodo.java PilaManual.java GestionPedidos.java Main.java

# Ejecutar
java Main
```

---

##  Restricciones Cumplidas

-  Arreglo fijo de tamaño 3 para ingredientes en `Pizza.java`
-  Lista ligada manual con clase `Nodo`
-  No se usa `java.util.Stack`
-  Métodos `push()`, `pop()`, `peek()`, `isEmpty()` implementados
-  Dos pilas coordinadas para Undo/Redo
-  Menú consola con las 5 opciones requeridas

---

## 👥 Autores

| Nombre | Rol |
|--------|-----|
|JONATAN ESTIBEN CARDENAS CARRASQUILLA  | Desarrollador/a |
|   | |
| ||

---

*Actividad académica — Estructuras de Datos — Java*
Sustentación Individual (Video Explicativo):

Cada estudiante debe grabar un video individual (máximo 3 minutos) donde:

Se presente formalmente (mostrando su rostro).

Explique la lógica de los métodos push() y pop() implementados manualmente.

"Realice una prueba de ejecución mostrando el ciclo: Registro -> Deshacer -> Rehacer."

https://drive.google.com/file/d/104Z84SbpkIv8QWAWDCWGpLa-KeEEL60k/view?usp=sharing



![alt text](<Captura de pantalla 2026-03-12 093043-1.png>) ![alt text](<Captura de pantalla 2026-03-12 093231-1.png>) ![alt text](<Captura de pantalla 2026-03-12 093258-1.png>) ![alt text](<Captura de pantalla 2026-03-12 093335-1.png>) ![alt text](<Captura de pantalla 2026-03-12 093400-1.png>) ![alt text](<Captura de pantalla 2026-03-12 093429-1.png>) ![alt text](<Captura de pantalla 2026-03-12 093448-1.png>)