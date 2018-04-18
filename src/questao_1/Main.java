package questao_1;
public class Main {
	
	public static boolean rodando = true;
	
	public static void main(String args[]){
		
		final String senha = "0000000001";//criação da senha
		long min;
		long max;
		
		int t = 15;
		long value = (9999999999l/t);//criando as faixas
		Math.floor(value);//arredondando o valor para baixo
		long resto = 9999999999l%t;
		
		for(int i = 1; i<=t;++i){ //repete o processo para a quantidade de threads que terão no código
			min = value*(i-1);
			max = min + value; //Calcula minimo e maximo
			if(i == t) {
				max += resto;
			}
			ThreadAcesso thread = new ThreadAcesso(min,max,senha,i); //cria a nova thread
			thread.start();
		}
		
		
	}
	
	
	


}
