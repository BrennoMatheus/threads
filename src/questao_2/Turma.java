package questao_2;

import java.util.Random;

public class Turma extends Thread {
	
		private Random time = new Random();
		private Parque[] listaParques = new Parque[5];
		private String nome;
		
		public Turma(Parque[] p, String n){
			this.listaParques = p;
			this.nome = n;
		}
		

		public void run(){
			
			try{
				listaParques[0].entrar(this);
				System.out.println("Turma "+ this.nome + " entrou no parque");
				System.out.println("Turma "+ this.nome + " iniciou o passeio");
				Thread.sleep(time.nextInt(10)*1000);
				System.out.println("Turma "+ this.nome + " terminou o passeio");
				listaParques[0].sair(this);
				System.out.println("Turma "+ this.nome + " saiu do parque");
				
				listaParques[1].entrar(this);
				System.out.println("Turma "+ this.nome + " entrou no parque");
				System.out.println("Turma "+ this.nome + " iniciou o passeio");
				Thread.sleep(time.nextInt(10)*1000);
				System.out.println("Turma "+ this.nome + " terminou o passeio");
				listaParques[1].sair(this);
				System.out.println("Turma "+ this.nome + " saiu do parque");
				
				listaParques[2].entrar(this);
				System.out.println("Turma "+ this.nome + " entrou no parque");
				System.out.println("Turma "+ this.nome + " iniciou o passeio");
				Thread.sleep(time.nextInt(10)*1000);
				System.out.println("Turma "+ this.nome + " terminou o passeio");
				listaParques[2].sair(this);
				System.out.println("Turma "+ this.nome + " saiu do parque");
				
				listaParques[3].entrar(this);
				System.out.println("Turma "+ this.nome + " entrou no parque");
				System.out.println("Turma "+ this.nome + " iniciou o passeio");
				Thread.sleep(time.nextInt(10)*1000);
				System.out.println("Turma "+ this.nome + " terminou o passeio");
				listaParques[3].sair(this);
				System.out.println("Turma "+ this.nome + " saiu do parque");
				
				listaParques[4].entrar(this);
				System.out.println("Turma "+ this.nome + " entrou no parque");
				System.out.println("Turma "+ this.nome + " iniciou o passeio");
				Thread.sleep(time.nextInt(10)*1000);
				System.out.println("Turma "+ this.nome + " terminou o passeio");
				listaParques[4].sair(this);
				System.out.println("Turma "+ this.nome + " saiu do parque");
			} 
			catch (Exception e){
				e.getMessage();
			}
		}
}
