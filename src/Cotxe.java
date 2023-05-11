public abstract class Cotxe implements Autonomia, Comparable<Cotxe>{
    String matricula;
    int preu;

    /**
     * Constructor utilitzat per les subclasses
     * @param matricula del cotxe
     * @param preu del cotxe
     */
    public Cotxe(String matricula, int preu) {
        if (!preuOK(preu)) throw new Error("Preu incorrecte!");

        this.matricula = matricula;
        this.preu = preu;
    }

    /**
     * Mètode que mostra la informació del cotxe per pantalla, sobreescrit a les subclasses
     * @return
     */
    public abstract String getInfo();

    /**
     * Mètode per obtenir la matrícula del cotxe des de fora d'aquest paquet
     * @return matrícula del cotxe
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Mètode que valida que el preu sigui més gran que 5000 i més petit que 50000
     * @param preu que volem validar
     * @return true si està dins dels paràmetres o false si no
     */
    boolean preuOK(int preu) {
        return !(preu < 5000 || preu > 50000);
    }

    /**
     * Mètode sobreescrit de la interfície Comparable que ens permet comparar per preu els cotxes
     * @param c cotxe amb el que volem comparar el nostre cotxe
     * @return 1 si el nostre cotxe és més car, 0 si el nostre cotxe té el mateix preu i
     * -1 si el nostre cotxe és més barat
     */
    @Override
    public int compareTo(Cotxe c) {
        return Integer.compare(this.preu, c.preu);
    }

}
