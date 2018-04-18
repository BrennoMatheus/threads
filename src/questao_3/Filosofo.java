package questao_3;

public class Filosofo extends Thread{
	
	final static int TEMPO_MAXIMO = 100;
	Mesa mesa;
	int filosofo;
	
	Filosofo(String nome, Mesa mesa, int i){
		super(nome);
		this.mesa = mesa;
		this.filosofo = i;
	}
	
	public void run() {
		int tempo;
		
		while(true) {
			try {
				sleep(5000);
				tempo  = (int) (Math.random() * TEMPO_MAXIMO);
				pensar(tempo);
				getGarfos();
				
				tempo  = (int) (Math.random() * TEMPO_MAXIMO);
				comer(tempo);	
				returnGarfos();
			} catch (Exception e) {
				
			}	
		}
	}
	
	
	public void pensar(int tempo) {
		try {
			sleep(tempo);
		} catch (Exception e) {
			 System.out.println("O Filófoso pensou demais");
		}
	}
	
	public void comer(int tempo) {
		try {
			sleep(tempo);
		} catch (Exception e) {
			System.out.println("O Filósofo comeu demais");
		}
	}
	
	public void getGarfos() {
		this.mesa.pegarGarfos(this.filosofo);
	}
	
	public void returnGarfos() {
		this.mesa.returnGarfos(this.filosofo);
	}
}
