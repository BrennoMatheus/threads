package questao_3;

public class Mesa {
	
	final static int PENSANDO = 1;
	final static int COMENDO = 2;
	final static int FOME = 3;
	final static int NR_FILOSOFOS = 5;
	final static int PRIMEIRO_FILOSOFO = 0;
	final static int ULTIMO_FILOSOFO = NR_FILOSOFOS - 1;

	boolean garfos[] = new boolean[NR_FILOSOFOS];
	int filosofos[] = new int[NR_FILOSOFOS];
	int tentativas[] = new int[NR_FILOSOFOS];
	
	Mesa() {
		for(int i = 0; i < NR_FILOSOFOS; i++) {
			garfos[i] = true;
			filosofos[i] = PENSANDO;
			tentativas[i] = 0;
		}
	}
	
	public synchronized void pegarGarfos(int filosofo) {
		filosofos[filosofo] = FOME;
		
		if(filosofos[aEsquerda(filosofo)] == COMENDO || filosofos[aDireita(filosofo)] == COMENDO) {
			try {
				tentativas[filosofo]++;
				wait();
			} catch (Exception e) {
				System.out.println("O Filósofo morreu de fome");
			}
		}
		tentativas[filosofo] = 0;
		garfos[garfoEsquerdo(filosofo)] = false;
		garfos[garfoDireito(filosofo)] = false;
		imprimeEstadosFilosofos();
	    imprimeGarfos();
	    imprimeTentativas();
	}
	
	public synchronized void returnGarfos(int filosofo) {
		garfos[aEsquerda(filosofo)] = true;
		garfos[aDireita(filosofo)] = true;
		
		if(filosofos[aDireita(filosofo)] == FOME || filosofos[aEsquerda(filosofo)] == FOME) {
			notifyAll();
		}
		
		filosofos[filosofo] = PENSANDO;
		imprimeEstadosFilosofos();
	    imprimeGarfos();
	    imprimeTentativas();
	}
	
	
	
	private void imprimeTentativas() {
		System.out.print("Tentou comer = [ ");
	      for (int i = 0; i < NR_FILOSOFOS; i++)
	      {
	         System.out.print(filosofos[i] + " ");
	      }
	      System.out.println("]");	
	}

	private void imprimeGarfos() {
		String garfo = "*";
	      System.out.print("Garfos = [ ");
	      for (int i = 0; i < NR_FILOSOFOS; i++)
	      {
	         if (garfos[i])
	         {
	            garfo = "LIVRE";
	         }
	         else
	         {
	            garfo = "OCUPADO";
	         }
	         System.out.print(garfo + " ");
	      }
	      System.out.println("]");
	}

	private void imprimeEstadosFilosofos() {
		 String texto = "*";
	      System.out.print("Filósofos = [ ");
	      for (int i = 0; i < NR_FILOSOFOS; i++)
	      {
	         switch (filosofos[i])
	         {
	            case PENSANDO :
	               texto = "PENSANDO";
	               break;
	            case FOME :
	               texto = "FOME";
	               break;
	            case COMENDO :
	               texto = "COMENDO";
	               break;
	         }
	         System.out.print(texto + " ");
	      }
	      System.out.println("]");
		
	}

	public int aEsquerda(int i) {
		int esquerdo;
		
		if(i == PRIMEIRO_FILOSOFO) {
			esquerdo =  ULTIMO_FILOSOFO;
		} else {
			esquerdo = i - 1;
		}
		
		return esquerdo;
	}
	
	public int aDireita(int i) {
		int direito;
		
		if(i == ULTIMO_FILOSOFO) {
			direito =  PRIMEIRO_FILOSOFO;
		} else {
			direito = i + 1;
		}
		
		return direito;
	}
	
	public int garfoEsquerdo(int filosofo) {
		int garfoEsquerdo = filosofo;
		return garfoEsquerdo;
	}
	
	public int garfoDireito(int filosofo) {
		int garfoDireito;
		if(filosofo == ULTIMO_FILOSOFO) {
			garfoDireito = 0;
		} else {
			garfoDireito = filosofo + 1;
		}
		return garfoDireito;
	}

}
