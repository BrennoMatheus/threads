package questao_1;
public class ThreadAcesso extends Thread  {
	
	private long min;
	private long max;
	private String senha;
	private int id;
	
	public ThreadAcesso(long min, long max, String senha, int id){
		this.min = min;
		this.max = max;
		this.senha = senha;
		this.id = id;
	}
	
	public void run(){
		
		for(long i = min; i < max && Main.rodando == true; i++){
			String s = String.format("%010d", i);
			if(s.equals(senha)== true){
				System.out.println("Senha encontrada");
				System.out.println("A senha é "+ s);
				System.out.println("a thread " + this.id + " decobriu a senha");
				Main.rodando = false;
					
				break;
			}
				
		}
		
}
	
	
}
