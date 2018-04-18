package questao_2;

import java.util.ArrayList;

public class Parque {
	private ArrayList<Thread> visitando = new ArrayList <Thread> ();
	private String nome;
	
	public String getNome(){
		return this.nome;
	}
	
	public Parque(String nome){
		this.nome = nome;
	}
	
	public synchronized void entrar(Turma t){
		
		try{
			this.visitando.add(t);
			if(this.visitando.size() == Viagem.qntTurmas){
				System.out.println("todas as turmas entraram no parque "+ this.getNome());
				this.notifyAll();
			} else {
				this.wait();
			}
		} catch (Exception e){
			e.getMessage();
		}
		
	}
	
	public synchronized void sair(Turma t){
		
		try{
			this.visitando.remove(t);
			if(this.visitando.isEmpty()){
				System.out.println("todas as turmas sairam do parque" + this.getNome());
				this.notifyAll();
			} else {
				this.wait();
			}
			
		} catch (Exception e){
			e.getMessage();
		}
		
	}
}
