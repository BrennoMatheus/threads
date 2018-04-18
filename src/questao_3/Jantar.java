package questao_3;

public class Jantar {
	
	public static void main(String[] args) {
		
		Mesa mesa = new Mesa();
		
		for(int i = 0; i < 5; i++) {
			new Filosofo("Filosofo "+i, mesa, i).start();
		}
		
	}
	
	
}
