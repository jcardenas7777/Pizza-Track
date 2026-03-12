
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        GestionPedidos pedidos = new GestionPedidos();
        try (Scanner teclado = new Scanner(System.in)) {
            String opcion = "";
            
            do {
                menu();
                System.out.println("INGRESE UNA OPCION: ");
                opcion = teclado.nextLine();
                
                switch (opcion) {
                    
                    case "1":
                        String subOpcion = "";
                        do {
                            subMenu();
                            System.out.print("INGRESE UNA OPCION: ");
                            subOpcion = teclado.nextLine();
                            
                            switch (subOpcion) {
                                case "1":
                                    System.out.println("***REGISTRAR PIZZA***\n");
                                    System.out.print("Nombre de la pizza: ");
                                    String nombre = teclado.nextLine();
                                    
                                    if (nombre.isEmpty()) {
                                        System.out.println("El nombre no puede estar vacío.");
                                        break;
                                    }
                                    
                                    String[] ingredientes = new String[3];
                                    for (int i = 0; i < 3; i++) {
                                        System.out.print("  Ingrediente " + (i + 1) + ": ");
                                        ingredientes[i] = teclado.nextLine().trim();
                                        if (ingredientes[i].isEmpty()) {
                                            ingredientes[i] = "Sin especificar";
                                        }
                                    }
                                    
                                    Pizza nuevaPizza = new Pizza(
                                            nombre,
                                            ingredientes[0],
                                            ingredientes[1],
                                            ingredientes[2]
                                    );
                                    pedidos.registrarPedido(nuevaPizza);
                                    
                                    pedidos.mostrarEstado();
                                    break;
                                    
                                case "2":
                                    System.out.println("Volviendo al menú principal...");
                                    break;
                                    
                                default:
                                    System.out.println("Opción no válida.");
                            }
                            
                        } while (!subOpcion.equals("2"));
                        break;
                        
                    case "2":
                        System.out.println("***DESHACER (UNDO)***\n");
                        pedidos.deshacer();
                        pedidos.mostrarEstado();
                        break;
                        
                    case "3":
                        System.out.println("***REHACER (REDO)***\n");
                        pedidos.rehacer();
                        pedidos.mostrarEstado();
                        break;
                        
                    case "4":
                        System.out.println("***MOSTRAR PEDIDO ACTUAL***\n");
                        pedidos.mostrarPedidoActual();
                        break;
                        
                    case "0":
                        break;
                        
                    default:
                        System.out.println("OPCION NO VALIDA, INTENTE DE NUEVO");
                }
                
            } while (!opcion.equals("0"));
            
            System.out.println("PROGRAMA TERMINADO...");
        }
    }

    public static void menu() {
        System.out.println("\n=====PIZZA-TRACK=====");
        System.out.println("1. REGISTRAR PIZZA");
        System.out.println("2. DESHACER (UNDO)");
        System.out.println("3. REHACER  (REDO)");
        System.out.println("4. MOSTRAR PEDIDO ACTUAL");
        System.out.println("0. SALIR");
    }

    public static void subMenu() {
        System.out.println("\n--- Gestión de Pizzas ---");
        System.out.println("1. Registrar nueva pizza");
        System.out.println("2. Volver al menú principal");
        System.out.println("-------------------------");
    }
    
}