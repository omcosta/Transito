package view;

import java.util.concurrent.Semaphore;

import controller.ThreadTransito;

public class Principal {

	public static void main(String[] args) {
		int numPermissoes = 3;
		Semaphore semaforo = new Semaphore(numPermissoes);
		for (int i=1; i<=3; i++ ) {
			Thread tTransito = new ThreadTransito(i, semaforo);
			tTransito.start();
		}		
	}

}
