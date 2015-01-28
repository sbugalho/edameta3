package principal;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;

public class Principal {

	static JFrame frame;
	
	
	
	JRadioButton rbBublleSort,rbMergeSort,rbBTree,rbBTodos,rbInc,rbSemInc;
	static int opcao=0;
	boolean incremento=true;
	static JPanel panel1, panel2;
	static TitledBorder titledBorder;
	
	public static void main(String[] args)
	{
		new Principal();
	}
	public Principal(){
		
		frame = new JFrame("Painel de Controlo");
		frame.setLayout(null);
		frame.setBounds(10,10,1100,700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		titledBorder = new TitledBorder("Ordenação:");
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(20, 20, 350, 150);
		panel1.setBorder(titledBorder);
		frame.add(panel1);
	
		
		titledBorder = new TitledBorder("OPÇOES:");
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(500, 20, 450, 150);
		panel2.setBorder(titledBorder);
		frame.add(panel2);
		
		
		
		ButtonGroup bg = new ButtonGroup();
		rbBublleSort = new JRadioButton("Bubble sort", true);
		rbBublleSort.setBounds(10,20,100,30);
		rbBublleSort.setBackground(Color.GREEN);
		bg.add(rbBublleSort);
		panel1.add(rbBublleSort);
		
		
		rbMergeSort = new JRadioButton("Merge sort");
		rbMergeSort.setBounds(10,50,100,30);
		rbMergeSort.setBackground(Color.GREEN);
		bg.add(rbMergeSort);
		panel1.add(rbMergeSort);
		
		rbBTree = new JRadioButton("Binary Tree");
		rbBTree.setBounds(10,80,100,30);
		rbBTree.setBackground(Color.GREEN);
		bg.add(rbBTree);
		panel1.add(rbBTree);
		
		rbBTodos = new JRadioButton("Todos");
		rbBTodos.setBounds(10,110,100,30);
		rbBTodos.setBackground(Color.GREEN);
		bg.add(rbBTodos);
		panel1.add(rbBTodos);
		
		JLabel lblElementosIniciais = new JLabel("Elementos:");
		lblElementosIniciais.setBounds(20, 20, 100, 25);
		panel2.add(lblElementosIniciais);
		
		final JTextField tfElementosIniciais = new JTextField("100");
		tfElementosIniciais.setBounds(20,40,100,25);
		panel2.add(tfElementosIniciais);
		
		JLabel lblNumVezes = new JLabel("Nº de vezes:");
		lblNumVezes.setBounds(270, 20, 100, 25);
		panel2.add(lblNumVezes);
		
		final JTextField tfNumVezes = new JTextField("5");
		tfNumVezes.setBounds(270,40,100,25);
		panel2.add(tfNumVezes);		

		JButton buttonCompute = new JButton("Executar");
		buttonCompute.setBounds(20,100,120,30);
		panel2.add(buttonCompute);
		buttonCompute.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	            {
				 String elementosIniciais=tfElementosIniciais.getText();
				 String numeroVezes=tfNumVezes.getText();
				 if(elementosIniciais!=null){
					 int eIniciais=Integer.parseInt(elementosIniciais);
					 int numVezes=Integer.parseInt(numeroVezes)+1;
					 goButtonActionPerformed(e,eIniciais,numVezes);
					 
				 }
	            }
		});
		
		JButton savGraf = new JButton("guardar");
		savGraf.setBounds(40, 200, 120, 30);
		frame.add(savGraf);
		savGraf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		frame.setVisible(true);
	}
	private void goButtonActionPerformed(ActionEvent evt,int eIniciais,int numVezes) {
		
		
	     if(rbBublleSort.isSelected()) {   
	    	 
	    		 Grafico grafico = new Grafico(frame,1,eIniciais,numVezes);
	    	 
	     }
	     if(rbMergeSort.isSelected()) {
	    	 opcao=2;
	    	 Grafico grafico = new Grafico(frame,2,eIniciais,numVezes);
	     }
	     if(rbBTree.isSelected()) {
	    	 opcao=3;
	    	 Grafico grafico = new Grafico(frame,3,eIniciais,numVezes);
	     }
	     if(rbBTodos.isSelected()) {
	    	 opcao=4;
	    	 Grafico grafico = new Grafico(frame,4,eIniciais,numVezes);
	     }
	} 
//----------------------------------------------------------	
}
