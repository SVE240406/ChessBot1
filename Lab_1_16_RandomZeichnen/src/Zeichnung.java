public class Zeichnung {
    public void zeichneX(int hoehe) {
        if (hoehe % 2 == 1) {
            for (int i = 0; i <= hoehe / 2 - 1; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                for (int j = 2; j < hoehe - i*2; j++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }

            for (int j = 0; j < hoehe/2; j++) {
                System.out.print(" ");
            }
            System.out.println("*");

            for (int i = hoehe/2 - 1; i >=0; i--) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                for (int j = 2; j < hoehe - i*2; j++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }
    }

    public void zeichneZahlenX(int hoehe) {
        if (hoehe % 2 == 1) {
            for (int i = 0; i <= hoehe / 2 - 1; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                System.out.print((i+1)%10);
                for (int j = 2; j < hoehe - i*2; j++) {
                    System.out.print(" ");
                }
                System.out.println((hoehe-i)%10);
            }

            for (int j = 0; j < hoehe/2; j++) {
                System.out.print(" ");
            }
            System.out.println((hoehe/2+1)%10);

            for (int i = hoehe/2 - 1; i >=0; i--) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                System.out.print((i+1)%10);
                for (int j = 2; j < hoehe - i*2; j++) {
                    System.out.print(" ");
                }
                System.out.println((hoehe-i)%10);
            }
        }
    }
}
