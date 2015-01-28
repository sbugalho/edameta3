package principal;

public class BubbleSort {
		
	public static double calcular(int[] dados, int eIniciais,boolean aquecedor) 
	{
	int max = dados.length;

	long inicio = System.nanoTime();
	
	for(int pos = max -1; pos > 0 ; pos--)
	  for(int i = 0; i < pos; i++)
		  if(dados[i] > dados[i+1])
		     {
			  int h = dados[i];
			  dados[i] = dados[i+1];
			  dados[i+1] = h;
		     }
	double tempo=System.nanoTime()-inicio;
	if(aquecedor==false)
		System.out.println("tempo bubble: "+tempo/eIniciais);
	return tempo;
	}
	
}