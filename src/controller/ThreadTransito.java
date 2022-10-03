package controller;

import java.util.concurrent.Semaphore;

public class ThreadTransito extends Thread {

	private int idCarro;
	private Semaphore semaphoro;
	private static int distanciaPercorrer = 200;
	private static int iPosicao = 0;
	
	public ThreadTransito(int idCarro, Semaphore semaphoro) {	
		this.idCarro = idCarro;
		this.semaphoro = semaphoro;
	}
	
	@Override
	public void run() {
		CarroAndando();
		try {
			semaphoro.acquire();		
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {			
			semaphoro.release();
			CarroParou(iPosicao);
		}		
	}
	
	public void CarroAndando() {
		int distancia = 0;
		
		while (distancia < distanciaPercorrer) {
			int rodada = (int) (Math.random() * 6) + 20;
			distancia += rodada;
			System.out.println("O Carro "+idCarro+" percorreu "+distancia+" Metros");
			try {
				Thread.sleep(100);
				if (distancia >= 200) {
					iPosicao++;
				}				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void CarroParou(int posicao) {		
		System.out.println("O Carro "+idCarro+" chegou na "+posicao+"º posição");
	}

}
