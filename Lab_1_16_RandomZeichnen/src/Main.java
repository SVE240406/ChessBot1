//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Zeichnung zeichnung = new Zeichnung();
        zeichnung.zeichneX(7);
        zeichnung.zeichneZahlenX(13);
        System.out.println("Bitte schreiben Sie \"quit\" um in das Spielemenü zu kommen.");
        while (Spiel.scn.hasNext()){
            if(Spiel.scn.next().toLowerCase().charAt(0) == 'q'){
                break;
            }
        }
        Spiel spiel = new Spiel();
        spiel.menu();
    }
}