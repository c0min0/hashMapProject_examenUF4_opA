public class CotxeCombustio extends Cotxe {
    int capacitatDiposit;
    float consum100;

    /**
     * Cosntructor de la classe CotxeCombustio
     * @param matricula del cotxe
     * @param preu del cotxe
     * @param capacitat del cotxe
     * @param consum del cotxe
     */
    public CotxeCombustio(String matricula, int preu, int capacitat, float consum) {
        super(matricula, preu);
        this.capacitatDiposit = capacitat;
        this.consum100 = consum;
    }

    /**
     * Mètode sobreescrit de la classe abstracta Cotxe on mostrem la informació del cotxe de combustió per pantalla
     * segons el format indicat
     * @return String amb la informació del cotxe
     */
    @Override
    public String getInfo() {
        String matricula = String.format("%-15s%s", "Matrícula:", this.matricula);
        String preu = String.format("%-15s%d €", "Preu:", this.preu);
        String capacitat = String.format("%-15s%d mA/h", "Capacitat:", this.capacitatDiposit);
        String autonomia = String.format("%-15s%d km", "Autonomia:", getAutonomia());
        return matricula +
                "\n" + preu +
                "\n" + capacitat +
                "\n" +autonomia + "\n";
    }

    /**
     * Mètode sobreescrit de la interfície Autonomia que calcula l'autonomia del cotxe
     * @return
     */
    @Override
    public int getAutonomia() {
        return (int) (capacitatDiposit * 100 / consum100);
    }
}
