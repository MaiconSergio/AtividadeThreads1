package bilheteria;



import java.util.concurrent.Semaphore;



import bilheteria.bilheteria2;



public class Main2 {



public static void main(String[] args)
{
int permissoes = 1;
Semaphore semaforo = new Semaphore(permissoes);

for (int idComprador = 1; idComprador < 301; idComprador++)
{
Thread t = new bilheteria2(idComprador, semaforo);
t.start();
}



}



}