import java.util.Arrays;
import java.util.Scanner;

public class Rechnen_Advanced {
    public static Scanner scn = new Scanner(System.in);

    public void getArithmetischesMittel(){
        System.out.println("Geben Sie eine Zahl ein: ");
        int[] numbers = null;
        while(scn.hasNext()){
            if(scn.hasNextInt()) {
                int zahl = scn.nextInt();
                if (zahl > 0) {
                    if (numbers == null) {
                        numbers = addArray(zahl);
                    } else {
                        numbers = addArray(numbers, zahl);
                    }
                } else {
                    break;
                }
            }else{
                scn.next();
            }
        }
        assert numbers != null;
        System.out.println("Average = " + Arrays.stream(numbers).average());
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

    public void dreieckszahl(int zahl) {
        if (zahl > 0) {
            int res = 0;
            for (int j = 1; j < zahl; j++)
                res += j;
            System.out.print(res);
        }
    }


    public static void menue(){
        for(int i = 0; i <= 50; i++)
            System.out.println();
        System.out.println("\t\tArithmetisches Mittel\t\tFakultät\t\tDreieckszahlen\n\tQuit");

        Rechnen_Advanced rechnen = new Rechnen_Advanced();

        int fall = 0;
        while (scn.hasNext()){
            switch (scn.next().toLowerCase().charAt(0)){
                case 'a':
                    rechnen.getArithmetischesMittel();

                    while (true){
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
                    while (true) {
                        if(scn.hasNextInt()) {
                            rechnen.fakultaet(scn.nextInt());
                            break;
                        }
                    }

                    while (true){
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
                    System.out.print("Geben Sie eine Zahl ein: ");
                    while (true) {
                        if(scn.hasNextInt()) {
                            rechnen.dreieckszahl(scn.nextInt());
                            break;
                        }
                    }

                    while (true){
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


    public int[] addArray(int[] arr, int n){
        int length = arr.length;
        int[] res = new int[length + n];
        for(int i = 0; i < length; i++){
            res[i] = arr[i];
        }
        res[length] = n;
        return res;
    }
    public int[] addArray(int n){
        int[] res = {n};
        return res;
    }
}
