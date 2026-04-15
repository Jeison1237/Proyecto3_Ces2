import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        System.out.println("========== PUNTO 1 ==========");
        // Cree 5 jugadores que sean del equipo de ENVIGADO y de la categoria JUNIOR
        Jugador j1 = new Jugador("Mateo", Categoria.JUNIOR, Equipo.ENVIGADO);
        Jugador j2 = new Jugador("Santiago", Categoria.JUNIOR, Equipo.ENVIGADO);
        Jugador j3 = new Jugador("Luis", Categoria.JUNIOR, Equipo.ENVIGADO);
        Jugador j4 = new Jugador("Carlos", Categoria.JUNIOR, Equipo.ENVIGADO);
        Jugador j5 = new Jugador("Andres", Categoria.JUNIOR, Equipo.ENVIGADO);

        // Asignar a cada jugador los goles de los últimos 5 partidos
        int[] golesUltimos5Partidos = {1, 0, 2, 1, 0}; // Goles simulados
        Jugador[] arregloJugadores = {j1, j2, j3, j4, j5};

        for (Jugador jugador : arregloJugadores) {
            for (int goles : golesUltimos5Partidos) {
                jugador.agregarGoles(goles);
            }
        }

        // Cree un Stack con estos 5 jugadores llamado jugadores
        Stack<Jugador> jugadores = new Stack<>();
        for (Jugador jugador : arregloJugadores) {
            jugadores.push(jugador);
        }

        // Cree un entrenador de ENVIGADO, JUNIOR y asigne al Deque los 5 jugadores
        Entrenador entrenador = new Entrenador("Juan Carlos", Categoria.JUNIOR, Equipo.ENVIGADO, 10);
        entrenador.getJugadores().addAll(jugadores);
        System.out.println("Jugadores y Entrenador creados y asignados correctamente.\n");


        System.out.println("========== PUNTO 2 ==========");
        // ListIterator con el Stack jugadores
        System.out.println("--- Mostrando con ListIterator (Stack) ---");
        ListIterator<Jugador> listIterator = jugadores.listIterator();
        while (listIterator.hasNext()) {
            Jugador j = listIterator.next();
            System.out.println("Nombre: " + j.getNombre() + " | Categoría: " + j.getCategoria() + " | Equipo: " + j.getEquipo());
        }

        // Iterator con el Deque de los jugadores del entrenador
        System.out.println("\n--- Mostrando con Iterator (Deque del Entrenador) ---");
        Iterator<Jugador> iterator = entrenador.getJugadores().iterator();
        while (iterator.hasNext()) {
            Jugador j = iterator.next();
            System.out.println("Nombre: " + j.getNombre() + " | Categoría: " + j.getCategoria() + " | Equipo: " + j.getEquipo());
        }
        System.out.println();


        System.out.println("========== PUNTO 3 ==========");
        // Código dado por el profesor
        Deque<Jugador> dequeJugadores = new ArrayDeque<>(jugadores);

        // (Opcional: Agregar un jugador de Nacional para comprobar que el filtro funciona)
        dequeJugadores.add(new Jugador("David", Categoria.PROFESIONAL, Equipo.NACIONAL));

        System.out.println("Jugadores en el equipo NACIONAL (Usando Programación Funcional):");
        dequeJugadores.stream()
                .filter(j -> j.getEquipo() == Equipo.NACIONAL)
                .map(Jugador::getNombre)
                .forEach(System.out::println);
        System.out.println();


        System.out.println("========== PUNTO 4 ==========");
        // Función que utiliza Function<T,R> para sumar los goles
        Function<Jugador, Integer> sumarGoles = jugador -> {
            int suma = 0;
            for (Integer gol : jugador.getGoles()) {
                suma += gol;
            }
            return suma;
        };

        // Llamar a esta función con el método correspondiente (apply)
        int totalGolesJ1 = sumarGoles.apply(j1);
        System.out.println("Prueba Punto 4 - Goles totales de " + j1.getNombre() + " usando sumarGoles.apply(): " + totalGolesJ1);
        System.out.println();


        System.out.println("========== PUNTO 5 ==========");
        // Hacer que un jugador llame al método verTotalGoles y muestre su total de goles
        System.out.println("Llamando al método dentro de la clase Jugador:");
        j2.verTotalGoles(sumarGoles);
        j3.verTotalGoles(sumarGoles);
    }
}