/**
 * Clase GestionPedidos - Controlador del sistema Undo/Redo.
 *
 * Coordina dos pilas manuales:
 *   - pilaUndo (Principal): almacena los pedidos activos.
 *   - pilaRedo (Secundaria): almacena los pedidos deshechos temporalmente.
 *
 * Cada nueva acción de escritura (registrar) limpia la pilaRedo,
 * respetando el comportamiento estándar de Undo/Redo.
 */
public class GestionPedidos {

    private PilaManual pilaUndo;  // Pila principal - pedidos activos
    private PilaManual pilaRedo;  // Pila secundaria - pedidos deshechos

    public GestionPedidos() {
        pilaUndo = new PilaManual();
        pilaRedo = new PilaManual();
    }

    /**
     * Registra un nuevo pedido en la pila principal.
     * Al registrar uno nuevo, se limpia la pila Redo.
     *
     * @param pizza Nueva pizza a registrar
     */
    public void registrarPedido(Pizza pizza) {
        pilaUndo.push(pizza);
        // Al registrar un nuevo pedido, el historial de Redo se invalida
        limpiarRedo();
        System.out.println("\n Pedido registrado exitosamente.");
        System.out.println("   " + pizza);
    }

    /**
     * Deshace el último pedido: lo mueve de pilaUndo a pilaRedo.
     */
    public void deshacer() {
        if (pilaUndo.isEmpty()) {
            System.out.println("\n No hay pedidos para deshacer.");
            return;
        }
        Pizza pizzaDesecha = pilaUndo.pop();
        pilaRedo.push(pizzaDesecha);
        System.out.println("\n Pedido deshecho:");
        System.out.println("   " + pizzaDesecha);
    }

    /**
     * Rehace el último pedido deshecho: lo mueve de pilaRedo a pilaUndo.
     */
    public void rehacer() {
        if (pilaRedo.isEmpty()) {
            System.out.println("\nNo hay pedidos para rehacer.");
            return;
        }
        Pizza pizzaRecuperada = pilaRedo.pop();
        pilaUndo.push(pizzaRecuperada);
        System.out.println("\n Pedido recuperado:");
        System.out.println("   " + pizzaRecuperada);
    }

    /**
     * Muestra el pedido en el tope de la pila (listo para producción).
     */
    public void mostrarPedidoActual() {
        if (pilaUndo.isEmpty()) {
            System.out.println("\n No hay ningún pedido activo en este momento.");
            return;
        }
        Pizza actual = pilaUndo.peek();
        System.out.println("\n Pedido en producción (tope de la pila):");
        System.out.println("   " + actual);
    }

    /**
     * Muestra el estado completo de ambas pilas.
     */
    public void mostrarEstado() {
        System.out.println("\n─────────────────────────────────────────");
        System.out.println("PILA PRINCIPAL (Pedidos activos): " + pilaUndo.getTamanio());
        pilaUndo.mostrarTodos();
        System.out.println("PILA REDO (Pedidos deshechos):   " + pilaRedo.getTamanio());
        pilaRedo.mostrarTodos();
        System.out.println("─────────────────────────────────────────");
    }

    /**
     * Vacía la pila Redo descartando todos sus elementos.
     */
    private void limpiarRedo() {
        while (!pilaRedo.isEmpty()) {
            pilaRedo.pop();
        }
    }

    // Getters para acceso externo si se requiere
    public PilaManual getPilaUndo() { return pilaUndo; }
    public PilaManual getPilaRedo()  { return pilaRedo; }
}
