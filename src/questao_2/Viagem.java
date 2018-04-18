package questao_2;

import java.util.ArrayList;

public class Viagem {
	
	static int qntTurmas;
	private Parque[] listaParques = new Parque[5];
	private ArrayList <Turma> listaTurmas = new ArrayList<Turma>();
	
	
	public Viagem(int qnt){
		
		Viagem.qntTurmas = qnt;
		
		for(int i = 0; i < Viagem.qntTurmas; i++){
			this.listaTurmas.add(new Turma(this.listaParques,"0"+Integer.toString(i)));
		}
		
		inicializaParques();
		
	}
	
	public void iniciarViagem(){
		for(int i = 0; i < this.listaTurmas.size(); i++){
			this.listaTurmas.get(i).start();
		}
	}
	
	private void inicializaParques(){
		this.listaParques[0] = new Parque("PA");
		this.listaParques[1] = new Parque("PB");
		this.listaParques[2] = new Parque("PC");
		this.listaParques[3] = new Parque("PD");
		this.listaParques[4] = new Parque("PE");
	}
	

	
	

}

