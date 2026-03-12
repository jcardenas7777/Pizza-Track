/**
 * Clase Pizza - Modelo de datos que representa un pedido.
 * Utiliza un arreglo de tamaño fijo (3) para los ingredientes.
 */
public class Pizza {

    private String nombre;
    private String[] ingredientes; // Arreglo fijo de 3 ingredientes

    /**
     * Constructor que recibe el nombre y los 3 ingredientes de la pizza.
     *
     * @param nombre      Nombre de la pizza
     * @param ingrediente1 Primer ingrediente
     * @param ingrediente2 Segundo ingrediente
     * @param ingrediente3 Tercer ingrediente
     */
    public Pizza(String nombre, String ingrediente1, String ingrediente2, String ingrediente3) {
        this.nombre = nombre;
        this.ingredientes = new String[3];
        this.ingredientes[0] = ingrediente1;
        this.ingredientes[1] = ingrediente2;
        this.ingredientes[2] = ingrediente3;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return "Pizza: " + nombre
                + " | Ingredientes: [" + ingredientes[0]
                + ", " + ingredientes[1]
                + ", " + ingredientes[2] + "]";
    }
}
