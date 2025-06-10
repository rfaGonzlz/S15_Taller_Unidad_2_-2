import java.util.*;

/**
 * Clase Persona que extiende de PersonaAbstract.
 * Permite el ingreso de datos de personas y realiza diversas operaciones con ellos.
 */
public class Persona extends PersonaAbstract {


    List<Persona> personas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // Constructor por defecto.
    public Persona() {
    }

    // Constructor que extiende los atributos de la clase PersonaAbstract.
    public Persona(String nombre, String apellido, int edad, String genero, double sueldoHora, String cargo) {
        super(nombre, apellido, genero, cargo, edad, sueldoHora);
    }

    @Override
    public void ingresoDatos() {
        // Implementación para ingreso de datos de una persona.
        String opcion;
        do {
            System.out.print("\nDigite el nombre de la persona:");
            setNombre(scanner.nextLine());

            System.out.print("Digite el apellido de la persona: ");
            setApellido(scanner.nextLine());

            System.out.print("Digite la edad de la persona: ");
            setEdad(scanner.nextInt());

            scanner.nextLine(); // Consumir el salto de línea pendiente.
            System.out.print("Digite el género de la persona (Masculino/Femenino): ");
            setGenero(scanner.nextLine());

            System.out.print("Digite el sueldo por hora de la persona: ");
            setSueldoHora(scanner.nextDouble());

            scanner.nextLine(); // Consumir el salto de línea pendiente.
            System.out.print("Digite el cargo de la persona: ");
            setCargo(scanner.nextLine());

            Persona p = new Persona(getNombre().toUpperCase(), getApellido().toUpperCase(), getEdad(), getGenero().toUpperCase(), getSueldoHora(), getCargo().toUpperCase());
            personas.add(p);

            System.out.print("\n¿Desea ingresar otra persona? (Si/No): ");
            opcion = scanner.nextLine().toUpperCase();


        } while (opcion.equals("SI"));


    }


    public void imprimirDatos() {

        // Cantidad de personas.
        long totalPersonas = personas.stream().count();
        System.out.println("\n\nCantidad total de personas: " + totalPersonas);

        //Promedio de edades.
        double promedioEdad = personas.stream()
                .mapToInt(Persona::getEdad)
                .average()
                .orElse(0);
        System.out.println("Promedio de edades: " + promedioEdad);

        // Personas mayores de edad.
        long mayoresEdad = personas.stream()
                .filter(p -> p.getEdad() >= 18)
                .count();
        System.out.println("Cantidad de personas mayores de edad: " + mayoresEdad);

        // Personas con nombre que empieza con "A".
        System.out.println("\n\nPersonas con nombre que empieza con 'A':\n");
        personas.stream()
                .filter(p -> p.getNombre().startsWith("A"))
                .forEach(p -> System.out.println("  - " + p.getNombre()));

        // Personas con apellido que contiene 'M'.
        System.out.println("\nPersonas con apellido que contiene 'M':\n");
        personas.stream()
                .filter(p -> p.getApellido().contains("M"))
                .forEach(p -> System.out.println("  - " + p.getApellido()));

        // operaciones con lambdas.
        System.out.println("\n=== Operaciones Avanzadas ===\n\n");

        // Sueldo de 8h para directores de genero (MASCULINO).
        personas.stream()
                .filter(p -> p.getCargo().equals("DIRECTOR") && p.getGenero().equals("MASCULINO"))
                .peek(p -> System.out.print("Nombre: " + p.getNombre() + " " + p.getApellido() + " "))
                .map(p -> p.getSueldoHora() * 8)
                .forEach(sueldo -> System.out.println("sueldo por 8 horas: $" + sueldo));

        //Primera desarrolladora (FEMENINA).
        Optional<Persona> desarrolladora = personas.stream()
                .filter(p -> p.getCargo().equals("DESARROLLADOR") && p.getGenero().equals("FEMENINO"))
                .findFirst();
        desarrolladora.ifPresent(p -> System.out.println("\nPrimera desarrolladora encontrada:\n\n " + p));

        //Desarrollador que más gana por hora.
        Optional<Persona> masGana = personas.stream()
                .filter(p -> p.getCargo().equals("DESARROLLADOR"))
                .max(Comparator.comparing(Persona::getSueldoHora));

        if (masGana.isPresent()) {
            System.out.println("\nDesarrollador que más gana por hora:\n");
            System.out.println(masGana.get());
        } else {
            System.out.println("\nNo hay desarrolladores en la lista.");
        }

    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " " + getApellido() +
                ", Edad: " + getEdad() +
                ", Género: " + getGenero() +
                ", Sueldo por hora: $" + getSueldoHora() +
                ", Cargo: " + getCargo();
    }

}

