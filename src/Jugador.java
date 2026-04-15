import java.util.Stack;
import java.util.function.Function;

public class Jugador {
    private String nombre;
    private Categoria categoria;
    private Equipo equipo;
    private Stack<Integer> goles;

    public Jugador() {
        this.goles = new Stack<>();
    }

    public Jugador(String nombre, Categoria categoria, Equipo equipo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.equipo = equipo;
        this.goles = new Stack<>();
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }
    public void setGoles(Stack<Integer> goles) { this.goles = goles; }

    public String getNombre() { return nombre; }
    public Categoria getCategoria() { return categoria; }
    public Equipo getEquipo() { return equipo; }
    public Stack<Integer> getGoles() { return goles; }

    // PUNTO 1: Método para agregar goles al Stack
    public void agregarGoles(int cantidadGoles) {
        this.goles.push(cantidadGoles);
    }

    // PUNTO 5: Método que recibe la Function y muestra el total de goles
    public void verTotalGoles(Function<Jugador, Integer> funcionSumarGoles) {
        int total = funcionSumarGoles.apply(this);
        System.out.println("El jugador " + this.nombre + " tiene un total de: " + total + " goles.");
    }
}
