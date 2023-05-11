import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Concessionari {
    public static HashMap<String, Cotxe> cotxes = new HashMap<>();

    /**
     * Mètode per afegir cotxes a un HashMap de key matricula i value Cotxe
     * @param c cotxe que volem afegir a l'array
     */
    public static void afegirCotxe(Cotxe c) {
        cotxes.put(c.getMatricula(), c);
    }

    /**
     * Mètode per eliminar un cotxe d'un HashMap de cotxes
     * @param matricula matrícula del cotxe que volem eliminar de l'array
     */
    public static void eliminarCotxe(String matricula) {
        cotxes.remove(matricula);
    }

    /**
     * Mètode que filtra cotxes segons el tipus (subclasse) del cotxe
     * @param tipus String amb el tipus de cotxe que volem filtrar ("Electric" o "Combustio")
     * @return retorna un HashMap amb els cotxes del HashMap cotxes del tipus passat per paràmetres
     */
    public static ArrayList<Cotxe> filtrarCotxe(String tipus) {
        // Convertim els tipus d'entrada als de les classes
        if (tipus.equals("Electric")) tipus = CotxeElectric.class.getSimpleName();
        if (tipus.equals("Combustio")) tipus = CotxeCombustio.class.getSimpleName();

        //Creem un nou ArrayList
        ArrayList<Cotxe> cotxesFiltrats = new ArrayList<>();

        // Afegim cada element del tipus desitjat al nou ArrayList
        for (String i : cotxes.keySet()) {
            if (tipus.equals(cotxes.get(i).getClass().getSimpleName())) {
                cotxesFiltrats.add(cotxes.get(i));
            }
        }

        return cotxesFiltrats;
    }

    /**
     * Mètode que retorna la informació dels cotxes del HashMap triat segons el mètode getInfo de la classe Cotxe
     * @param al ArrayList a mostrar
     */
    public static void mostrarLlista(ArrayList<Cotxe> al) {
        al.forEach(a -> System.out.println(a.getInfo()));
    }

    /**
     * Mètode principal on fem les operacions
     * @param args Paràmetre d'inici que no utilitzem
     */
    public static void main(String[] args) {
        // Creem uns quants cotxes
        Cotxe c1 = crearCotxeCombustio("0000-CCC", 25000, 60, 6.5f);
        Cotxe c2 = crearCotxeCombustio("1111-CCC", 30000, 70, 6.5f);
        Cotxe c3 = crearCotxeCombustio("2222-CCC", 20000, 70, 5.5f);
        Cotxe e1 = crearCotxeElectric("3333-EEE", 25001, 60f);
        Cotxe e2 = crearCotxeElectric("4444-EEE", 30001, 70f);
        Cotxe e3 = crearCotxeElectric("5555-EEE", 20001, 80f);

        // Els afegim a l'array cotxes
        afegirCotxe(c1);
        afegirCotxe(c2);
        afegirCotxe(c3);
        afegirCotxe(e1);
        afegirCotxe(e2);
        afegirCotxe(e3);

        // Eliminem un cotxe
        eliminarCotxe("3333-EEE");

        // Filtrem els cotxes de combustió, els ordenem per preu i els mostrem
        System.out.println("Cotxes de combustió ordenats per preu:");
        ArrayList<Cotxe> filtratsCombustio = filtrarCotxe("Combustio");
        // Ordenem
        Collections.sort(filtratsCombustio);
        // Mostrem
        mostrarLlista(filtratsCombustio);

        // Filtrem els cotxes elèctrics, els ordenem per preu i els mostrem
        System.out.println("Cotxes elèctrics ordenats per preu:");
        ArrayList<Cotxe> filtratsElectrics = filtrarCotxe("Electric");
        // Ordenem
        Collections.sort(filtratsElectrics);
        // Mostrem
        mostrarLlista(filtratsElectrics);

        // Provem de crear un cotxe amb un valor de preu incorrecte
        System.out.println("Introducció de vehicle incorrecte:");
        Cotxe cotxeDefectuos = crearCotxeElectric("PROVA", 1000, 100);
    }

    /**
     * Mètode per crear un cotxe de combustió si les dades s'introdueixen bé,
     * o retornar null si no es pot crear i mostrar el motiu per pantalla.
     * @param matricula del cotxe
     * @param preu del cotxe
     * @param capacitat del cotxe
     * @param consum del cotxe
     * @return el cotxe creat o null si no s'ha pogut crear
     */
    private static Cotxe crearCotxeCombustio(String matricula, int preu, int capacitat, float consum) {
        Cotxe c = null;
        try {
            c = new CotxeCombustio(matricula, preu, capacitat, consum);
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    /**
     * Mètode per crear un cotxe elèctric si les dades s'introdueixen bé,
     * o retornar null si no es pot crear i mostrar el motiu per pantalla.
     * @param matricula del cotxe
     * @param preu del cotxe
     * @param capacitat del cotxe
     * @return el cotxe creat o null si no s'ha pogut crear
     */
    private static Cotxe crearCotxeElectric(String matricula, int preu, float capacitat) {
        Cotxe c = null;
        try {
            c = new CotxeElectric(matricula, preu, capacitat);
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
