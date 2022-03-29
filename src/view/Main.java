package view;



import java.util.concurrent.Semaphore;



import controller.aeroporto;



public class Main {

public static void main(String[] args) {

int PistaNorte = 1;
Semaphore semaforo = new Semaphore(PistaNorte);

int PistaSul = 1;
Semaphore semaforo1 = new Semaphore(PistaSul);



for (int idAviao = 0; idAviao <= 12; idAviao ++) {
Thread tAviao = new aeroporto(idAviao, semaforo, semaforo1);
tAviao.start();
}
}



}