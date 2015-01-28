package principal;

class No
{
	int valor;
	No menor;
	No maior;
} 

public class BinaryTree {
	int max;
	int[] dados;
	int posicao=0;
	
	public double calcular(int[] dados,int eIniciais,boolean aquecedor){
		this.max = dados.length;
		this.dados=dados;
		
		long inicioT = System.nanoTime();
		
		
		No inicio = null;
		
		for(int i = 0; i < max; i++)
		{
			inicio = acrescentar(inicio, dados[i]);
		}
		listar(inicio);
		
		double tempo=System.nanoTime()-inicioT;
		if(aquecedor==false)
			System.out.println("tempo btree: "+tempo/eIniciais);
		return tempo;
	}
	
	private void listar(No n) //ordenar crescente
	{
		if(n == null)
			return;

		listar(n.menor);	
		listar(n.maior);	

	}
//---------------------------------------------------------------
	
	private static No acrescentar(No n, int valor) 
	{

		if(n == null)
		{
			No novo = new No();
			novo.valor = valor;
			return novo;
		}
		if(valor < n.valor)
			n.menor = acrescentar(n.menor, valor);
		else if(valor > n.valor)
			n.maior = acrescentar(n.maior, valor);

		return n;
	}
}
