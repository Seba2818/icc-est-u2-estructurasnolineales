package evaluacion;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PersonaController {

    public Set<Persona> filtrarYOrdenar(List<Persona> personas, int edadUmbral) {

        Comparator<Persona> comparador = (p1, p2) -> {

            
            if (p1.getEdad() == p2.getEdad()
                    && p1.getNombre().equalsIgnoreCase(p2.getNombre())) {
                return 0;
            }

            // Edad descendente
            int compararEdad = Integer.compare(p2.getEdad(), p1.getEdad());

            if (compararEdad != 0) {
                return compararEdad;
            }

            // Nombre ascendente ignorando mayúsculas
            return p1.getNombre().compareToIgnoreCase(p2.getNombre());
        };

        Set<Persona> resultado = new TreeSet<>(comparador);

        for (Persona persona : personas) {
            if (persona.getEdad() >= edadUmbral) {
                resultado.add(persona);
            }
        }

        return resultado;
    }

    public Map<String, Set<String>> agruparPorEdad(List<Persona> personas, int edadUmbral) {
        return null;
    }
}
