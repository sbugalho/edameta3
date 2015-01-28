package principal;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafico {
	int numVezes;
	static ChartPanel chartPanel;
	int opcao=1;
	int eIniciais;//=100;
	//-------------------------------frame grafico---------------------------
		 public Grafico(JFrame frame, int opcao,int eIniciais, int numVezes) 
		 {
			 this.numVezes=numVezes;
			 this.eIniciais=eIniciais;
		        XYDataset dataset = createDataset(opcao);
		        JFreeChart chart = createChart(dataset);
		        if(chartPanel!=null)
		         	frame.remove(chartPanel);
		        chartPanel = new ChartPanel(chart);
		        chartPanel.setBounds(230, 190, 670, 430);
		       
		        frame.add(chartPanel);
		        frame.repaint();
		    }
	//----------------------------------inicializar grafico------------------------
		 static private JFreeChart createChart(final XYDataset dataset) {
		        
		        // criar grafico
		        final JFreeChart chart = ChartFactory.createXYLineChart(
		            "Tempos de execução (Nanosegundos)",        // chart title
		            "Nº Elementos",           				   // x axis label
		            "Tempo em ",             				  // y axis label
		            dataset,                				 // data
		            PlotOrientation.VERTICAL,
		            true,                     			   // include legend
		            true,                    			  // tooltips
		            false                   			 // urls
		        );

		        //CUSTOMISATION OF THE CHART...
		        chart.setBackgroundPaint(Color.white);
		        
		        // get a reference to the plot for further customisation...
		        final XYPlot plot = chart.getXYPlot();
		        plot.setBackgroundPaint(Color.lightGray);

		        plot.setDomainGridlinePaint(Color.white);
		        plot.setRangeGridlinePaint(Color.white);
		        plot.setDomainCrosshairVisible(true);
		        plot.setRangeCrosshairVisible(true);
		        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		        plot.setRenderer(renderer);

		        // change the auto tick unit selection to integer units only...
		        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		        // OPTIONAL CUSTOMISATION COMPLETED.
		          
		        
		        //save JPG
		        try {
					ChartUtilities.saveChartAsJPEG(new File("//Users//sergiobugalho//documents//chart.jpg"), chart, 500, 300);
				} catch (IOException e) {
		
					e.printStackTrace();
				}
		        
		        return chart;
		        
		    }	 

	//----------------------------------------------------------
		 private XYDataset createDataset(int opcao) {
		        
			 
		        final XYSeries series1 = new XYSeries("Bubble");
		        final XYSeries series2 = new XYSeries("Merge");
		        final XYSeries series3 = new XYSeries("Btree");
		        
		        Random ran = new Random();

		        System.out.println("");
		        for(int i = 0; i < numVezes; i++)
		        	{
		        	
		        	//Para o grafico ter incremento para aparecer os dados sequenciais
		        	
		        	//**
		        	
		        	
		        	int max=eIniciais;
		        	int inc=0;
		   
		        	
		        	for (int j = 0; j < i; j++) 
					
		        	max = max *10;	
					//max=eIniciais*i;
		        	inc=eIniciais*i;
		        	
		        	//System.out.println(max);
		        	
				 	int[] dados = new int[max];
				 	
				 	for(int r = 0; r < max; r++)
				 		dados[r] = ran.nextInt();
				 	if(opcao==1)
				 	{
				 		series1.add(inc, BubbleSort.calcular(dados,eIniciais,false)/eIniciais);
					}
				 	else if(opcao==2)
				 	{
						 MergeSort merge=new MergeSort();
						 series2.add(inc, merge.calcular(dados,eIniciais,false)/eIniciais);
					}
				 	else if(opcao==3)
				 	{
						 BinaryTree btree=new BinaryTree();
						 series3.add(inc, btree.calcular(dados,eIniciais,false)/eIniciais);
					}
				 	else if(opcao==4)
					{
						 series1.add(inc, BubbleSort.calcular(dados,eIniciais,false)/eIniciais);
		
						 MergeSort merge=new MergeSort();
						
						 series2.add(inc, merge.calcular(dados,eIniciais,false)/eIniciais);
					 
						 BinaryTree btree=new BinaryTree();

						 for(int r = 0; r < max; r++)
						 		dados[r] = ran.nextInt();
							 series3.add(inc, btree.calcular(dados,eIniciais,false)/eIniciais);
					 }
		        	}


		        final XYSeriesCollection dataset = new XYSeriesCollection();
		        if(opcao==1){
		        	dataset.addSeries(series1);
				 }else if(opcao==2){
					 dataset.addSeries(series2);
				 }else if(opcao==3){
					 dataset.addSeries(series3);
				 }else if(opcao==4){
					 dataset.addSeries(series1);
					 dataset.addSeries(series2);
					 dataset.addSeries(series3);
				 }
	    
		        return dataset;
		        
		    }
}
