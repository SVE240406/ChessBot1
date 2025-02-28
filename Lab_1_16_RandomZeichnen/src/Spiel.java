import java.util.Random;
import java.util.Scanner;

public class Spiel {
    public Random rand = new Random();
    public static Scanner scn = new Scanner(System.in);


    private void compRaetZahl(int von, int bis){
        if(von > bis) {
            int temp = von;
            von = bis;
            bis = temp;
        }

        int raet;
        int timesGuessed = 0;
        boolean guessed = false;

        System.out.println("Bitte geben Sie -1 ein wenn die Zahl von Ihnen kleiner ist,"
                +" 0 wenn ich die Zahl erraten habe und 1 wenn die Zahl von Ihnen größer ist.");
        while(!guessed){
            raet = (von + bis)/2;

            timesGuessed++;
            System.out.print("Ich denke Ihre Zahl ist  " + raet + "  ");
            while (scn.hasNext()){
                if(scn.hasNextInt()){
                    timesGuessed++;
                    int answer = scn.nextInt();
                    if(answer == 0){
                        System.out.println("Ich habe " + timesGuessed/2 + " versuche gebraucht um Ihre Zahl zu erraten.");
                        guessed = true;
                        break;
                    }else if (answer == 1) {
                        von = raet+1;
                    }else {
                        bis = raet-1;
                    }

                    if(bis < von) {
                        System.out.println("Sie haben geschummelt! Das war nicht nett, ich habe Ihre Zahl erraten!");
                        guessed = true;
                    }
                    break;
                }else
                    scn.next();
            }
        }
        System.out.println("Please write quit to return to the menu");
        while (scn.hasNext()) {
            if (scn.next().toLowerCase().charAt(0) == 'q')
                break;
            else
                scn.next();
        }
        menu();
    }

    private void userRaetZahl(int von, int bis) {
        if(von > bis) {
            int temp = von;
            von = bis;
            bis = temp;
        }

        bis++;

        int randomZahl = rand.nextInt(von, bis) + 1;
        int raet = 0;
        int timesGuessed = 0;

        System.out.print("Bitte geben Sie eine Zahl ein:  ");
        while (scn.hasNext()) {
            if (scn.hasNextInt()) {
                raet = scn.nextInt();
                timesGuessed++;
                if (raet == randomZahl) {
                    System.out.println("\nRichtig! Du hast die Zahl "+randomZahl+" erraten!!!\tDafür hast du "
                            + timesGuessed + " versuche gebraucht");
                    break;
                } else if (raet > randomZahl) {
                    System.out.println("Die Zahl ist kleiner als " + raet);
                    System.out.print("Bitte geben Sie eine Zahl ein:  ");
                }
                else {
                    System.out.println("Die Zahl ist größer als " + raet);
                    System.out.print("Bitte geben Sie eine Zahl ein:  ");
                }

            } else {
                scn.next();
            }
        }
        System.out.println("Please write quit to return to the menu");
        while (scn.hasNext()) {
            if (scn.next().toLowerCase().charAt(0) == 'q')
                break;
            else
                scn.next();
        }
        menu();
    }

    public void menu() {
        for(int i = 0; i < 10; i++)
            System.out.println("\n\n");
        System.out.println("Bitte wählen Sie:");
        System.out.println("\tComputer rät Zahl\tSpieler rät Zahl\nQuit");

        char choosen='q';
        while(scn.hasNext()){
            switch(scn.next().toLowerCase().charAt(0)){
                case 'q':
                    System.out.println("Do you really Want to quit?\n\tyes\t\tno");
                    while (scn.hasNext()){
                        if (scn.next().toLowerCase().charAt(0) == 'y') {
                            scn.close();
                            System.exit(0);
                        }else {
                            choosen = 'm';
                            break;
                        }
                    }
                    break;
                case 'c':
                    choosen = 'c';
                    break;
                case 'u','s':
                    choosen = 'u';
                    break;
            }
            if (choosen != 'q')
                break;
        }
        if(choosen=='c'){
            int[] intervall = new int[2];
            System.out.print("Bitte geben Sie die Startzahl an  ");
            while(scn.hasNext()){
                if(scn.hasNextInt()){
                    intervall[0] = scn.nextInt();
                    break;
                }else
                    scn.next();
            }
            System.out.print("Bitte geben Sie die Endzahl an  ");
            while(scn.hasNext()){
                if(scn.hasNextInt()){
                    intervall[1] = scn.nextInt();
                    break;
                }else
                    scn.next();
            }
            compRaetZahl(intervall[0], intervall[1]);
        }else if(choosen=='u'){
            int[] intervall = new int[2];
            System.out.print("Bitte geben Sie die Startzahl an  ");
            while(scn.hasNext()){
                if(scn.hasNextInt()){
                    intervall[0] = scn.nextInt();
                    break;
                }else
                    scn.next();
            }
            System.out.print("Bitte geben Sie die Endzahl an  ");
            while(scn.hasNext()){
                if(scn.hasNextInt()){
                    intervall[1] = scn.nextInt();
                    break;
                }else
                    scn.next();
            }
            userRaetZahl(intervall[0], intervall[1]);
        }else
            menu();
    }
}