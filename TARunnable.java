import java.util.Scanner;

public class TARunnable implements Runnable {

    private final static int SLEEPTIME = 1000; 

    private int id;

    private static long limiteS;

    public TARunnable(int id) {
        this.id = id;
    }

    public void run() {
        // Primer Thread (pares)
        if (id == 0) {
            System.out.println("Inicio Thread Pares");
            for (int i = 1; i < limiteS; i++) {
                if (i % 2 == 0){
                    System.out.println("Salida Thread Par: " + i);
                    try {
                        Thread.sleep(SLEEPTIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //Segundo Thread (impares)
        else if(id == 1){
            System.out.println("Inicio Thread Impares");
            for (int i = 1; i < limiteS; i++){
                if (i % 2 != 0){
                    System.out.println("Salida Thread impar: " + i);
                    try {
                        Thread.sleep(SLEEPTIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Limite  superior (exclusivo): ");
        limiteS = input.nextInt();
        input.close();

        Thread tpares = new Thread(new TARunnable(0));
        Thread timpares = new Thread(new TARunnable(1));

        tpares.start();
        timpares.start();
    }
    
}
