import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Beschreiben Sie hier die Klasse Rechnen.
 * 
 * @author Nikolai Sverdlov
 * @version 2025.01.23
 */
public class Rechnen
{
    Random rand = new Random();
    public static Scanner scn = new Scanner(System.in);

    public void getArithmetischesMittel(){
        System.out.print("Geben Sie eine Zahl ein: ");
        int i = 0;
        while(scn.hasNext()){
            if(scn.hasNextInt()){
                i = scn.nextInt();
                if(i <= 0){
                    System.out.print("Nur Zahlen größer als 0 erlaubt! Geben Sie eine Zahl ein: ");
                }
                else{
                    break;
                }
            }
            else
                scn.next();
        }
        int[] randomNumbers = new int[i];
        for(int j = 0; j < i; j++){
            int randomNumber = rand.nextInt(0, 20);
            if(j == 0)
                System.out.print(randomNumber);
            else
                System.out.print(", "+randomNumber);
            randomNumbers[j] = randomNumber;
        }
        System.out.println("; arithmetisches Mittel = "+Arrays.stream(randomNumbers).average());
    }

    public void fakultaet(int zahl) {
        int res = 1;

        if (zahl <= 0){
            zahl = 3;
            System.err.println("Zahl muss größer als 0 sein!");
        }
        for (int i = zahl; i >0; i--){
            res = res * i;
            if(i != zahl)
                System.out.print("*");
            System.out.print(i);
        }
        System.out.println("="+res);
    }

    public void printDreieckszahlen(){
        int zahl = rand.nextInt(5,10);
        for(int i = 1; i <= zahl; i++){
            int res = 0;
            for(int j = 1; j < i; j++)
                res += j;
            System.out.print(res);
            if(i != zahl)
                System.out.print(", ");
        }
    }

    public static void menue(){
        for(int i = 0; i <= 50; i++)
            System.out.println();
        System.out.println("\t\tArithmetisches Mittel\t\tFakultät\t\tDreieckszahlen\n\tQuit");
        
        Rechnen rechnen = new Rechnen();

        int fall = 0;
        while (scn.hasNext()){
            switch (scn.next().toLowerCase().charAt(0)){
                case 'a':
                    rechnen.getArithmetischesMittel();


                    while (scn.hasNext()){
                        if(scn.hasNext()) {
                            String s = scn.next();
                            if (s.charAt(0) == 'q') {
                                for (int i = 0; i <= 50; i++)
                                    System.out.println();
                                System.out.println("\t\tArithmetisches Mittel\t\tFakultät\t\tDreieckszahlen\n\tQuit");
                                break;
                            }
                        }
                    }
                    break;
                case 'f':

                    System.out.print("Geben Sie eine Zahl ein: ");
                    while (scn.hasNext()) {
                        if(scn.hasNextInt()) {
                            rechnen.fakultaet(scn.nextInt());
                            break;
                        }
                    }

                    while (scn.hasNextInt()) {
                        if(scn.hasNext()) {
                            String s = scn.next();
                            if (s.charAt(0) == 'q') {
                                for (int i = 0; i <= 50; i++)
                                    System.out.println();
                                System.out.println("\t\tArithmetisches Mittel\t\tFakultät\t\tDreieckszahlen\n\tQuit");
                                break;
                            }
                        }
                    }
                    break;
                case 'd':
                    rechnen.printDreieckszahlen();

                    while (scn.hasNext()){
                        if(scn.hasNext()) {
                            String s = scn.next();
                            if (s.charAt(0) == 'q') {
                                for (int i = 0; i <= 50; i++)
                                    System.out.println();
                                System.out.println("\t\tArithmetisches Mittel\t\tFakultät\t\tDreieckszahlen\n\tQuit");
                                break;
                            }
                        }
                    }
                    break;
                case 'q':
                    System.exit(0);
            }
        }
    }
}
