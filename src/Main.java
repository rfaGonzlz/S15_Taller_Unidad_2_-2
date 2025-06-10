//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       // Se crea una instacia de la clase Persona.
        Persona persona = new Persona();
        // Se llama al método ingresoDatos para ingresar los datos de la persona.
        persona.ingresoDatos();
        // Se llama al método imprimirDatos para mostrar los datos ingresados.
        persona.imprimirDatos();
    }
}