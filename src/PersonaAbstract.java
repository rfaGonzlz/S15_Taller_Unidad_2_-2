// Clase abstract que define la estructura para las proximas clases de Persona.
public abstract class PersonaAbstract {

    // Atributos de la clase PersonaAbstract.
    private String nombre, apellido, genero, cargo;
    private int edad;
    private double sueldoHora;

    // Constructor por defecto.
    public PersonaAbstract() {
    }

    // Constructor que inicializa los atributos de la clase PersonaAbstract.
    public PersonaAbstract(String nombre, String apellido, String genero, String cargo, int edad, double sueldoHora) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.cargo = cargo;
        this.edad = edad;
        this.sueldoHora = sueldoHora;
    }

    // Getters y Setters para los atributos de la clase PersonaAbstract.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldoHora() {
        return sueldoHora;
    }

    public void setSueldoHora(double sueldoHora) {
        this.sueldoHora = sueldoHora;
    }


    // Métodos abstractos que deben ser implementados por las clases hijas.
    public abstract void ingresoDatos();

    public abstract void imprimirDatos();
}
