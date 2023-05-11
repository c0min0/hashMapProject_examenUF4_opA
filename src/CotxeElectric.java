public class CotxeElectric extends Cotxe{
    float capacitatBateria;

    /**
     * Constructor del cotxeElectric
     * @param matricula del cotxe
     * @param preu del cotxe
     * @param capacitat del cotxe
     */
    public CotxeElectric(String matricula, int preu, float capacitat) {
        super(matricula, preu);
        this.capacitatBateria = capacitat;
    }

    /**
     * Mètode sobreescrit de la classe abstracta Cotxe on mostrem la informació del cotxe elèctric per pantalla
     * segons el format indicat
     * @return String amb la informació del cotxe
     */
    @Override
    public String getInfo() {
        String matricula = String.format("%-15s%s", "Matrícula:", this.matricula);
        String preu = String.format("%-15s%d €", "Preu:", this.preu);
        String capacitat = String.format("%-15s%.2f mA/h", "Capacitat:", this.capacitatBateria);
        String autonomia = String.format("%-15s%d km", "Autonomia:", getAutonomia());
        return matricula +
                "\n" + preu +
                "\n" + capacitat +
                "\n" + autonomia + "\n";
    }

    /**
     * Mètode sobreescrit de la interfície Autonoma que calcula l'autonomia del cotxe
     * @return
     */
    @Override
    public int getAutonomia() {
        return (int) (capacitatBateria * 10);
    }
}
