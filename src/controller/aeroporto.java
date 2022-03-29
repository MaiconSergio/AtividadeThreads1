package controller;



import java.util.concurrent.Semaphore;



public class aeroporto extends Thread {
private int idAviao;
private Semaphore PistaNorte;
private Semaphore PistaSul;



public aeroporto(int idAviao, Semaphore semaforo, Semaphore semaforo1) {
this.idAviao = idAviao;
this.PistaNorte = semaforo;
this.PistaSul = semaforo1;
}



@Override
public void run() {
manobrar();
taxiar();



if ((int) (Math.random() * 2) + 1 == 1) {
try {
PistaNorte.acquire();
String pista = "pista norte";
decolagem(pista);
} catch (InterruptedException e) {
e.printStackTrace();
} finally {
PistaNorte.release();
afastamento();
}
}

else {
try {
PistaSul.acquire();
String pista = "pista sul";
decolagem(pista);
} catch (InterruptedException e) {
e.printStackTrace();
} finally {
PistaSul.release();
afastamento();
}
}

}



private void manobrar() {
int tempoManobra = (int) (Math.random() * 5000) + 3000;
try {
sleep(tempoManobra);
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("#" + idAviao + " esta manobrando");
}



private void taxiar() {
int tempoTaxiar = (int) (Math.random() * 6000) + 5000;
try {
sleep(tempoTaxiar);
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("#" + idAviao + " esta taxiando");
}



private void decolagem(String pista) {
System.out.println("#" + idAviao + " esta decolando");
int tempoDecolagem = (int) (Math.random() * 4000) + 1000;
try {
sleep(tempoDecolagem);
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("#" + idAviao + " decolou pela "+pista);
}



private void afastamento() {
int tempoAfastamento = (int) (Math.random() * 6000) + 3000;
try {
sleep(tempoAfastamento);
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("#" + idAviao + " esta se afastando");
}
}