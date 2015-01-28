package principal;

public class MergeSort {

	
	int max; //array size
	int[] dados;
	int[] afinal;
	
	public double calcular(int[] dados,int eIniciais,boolean aquecedor) 
	{
		
		
		this.max = dados.length;
		this.dados=dados;
		afinal = new int[max];
		long inicio = System.nanoTime();
		
		ordenarMergeSort(0,max-1);
		double tempo=System.nanoTime()-inicio;
		if(aquecedor==false)
			System.out.println("tempo merge: "+tempo/eIniciais);
		return tempo;
		
	}
	private void ordenarMergeSort(Integer low, Integer top) 
	{
		if(low >= top)
			return;
		int medio = (low+top) /2;
		ordenarMergeSort(low, medio);
		ordenarMergeSort(medio + 1, top);

		int pontEsq = low;
		int pontDir = medio+1;

		int totElementos = top - low +1;
		for(int i = 0; i < totElementos; i++)
			if(pontEsq > medio)
			{
				afinal[i] = dados[pontDir];
				pontDir++;
			}
			else if(pontDir > top || dados[pontEsq] < dados[pontDir])
			{
				afinal[i] = dados[pontEsq];
				pontEsq++;
			}
			else
			{
				afinal[i] = dados[pontDir];
				pontDir++;
			}

		for(int i = 0; i < totElementos; i++)
			dados[low + i] = afinal[i];
	}
}
