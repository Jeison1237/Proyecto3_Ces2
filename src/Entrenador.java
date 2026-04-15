import java.util.Deque;
import java.util.ArrayDeque;
public class Entrenador {
    private String nombre;
    private Categoria Categoria;
    private Equipo equipo;
    private int partidosGanados;

    private Deque<Jugador> jugadores;
    public Entrenador() {
        this.jugadores = new ArrayDeque<>();
    }
    public Entrenador(String nombre, Categoria categoria, Equipo equipo, int partidosGanados) {
        this.nombre = nombre;
        this.Categoria = categoria;
        this.equipo = equipo;
        this.partidosGanados = partidosGanados;
        this.jugadores = new ArrayDeque<>();
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(Categoria categoria) { this.Categoria = categoria; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }
    public void setPartidosGanados(int partidosGanados) { this.partidosGanados = partidosGanados; }
    public void setJugadores(Deque<Jugador> jugadores) { this.jugadores = jugadores; }

    public Deque<Jugador> getJugadores() { return jugadores; }
}
}
