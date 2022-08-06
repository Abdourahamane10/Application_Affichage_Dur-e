package durree;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppliDurree {
	
	private Durree d;

	private JFrame frmProgrammationControle;
	private JTextField minutes;
	private JTextField secondes;
	private JTextField duree;
	private JTextField heures;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppliDurree window = new AppliDurree();
					window.frmProgrammationControle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppliDurree() {
		initialize();
	}
	
	//Méthode pour pércuter sur la durée en bas les modifications apportées par les flèches
	private void percuteBas() {
		d = new Durree(Integer.valueOf(heures.getText()), Integer.valueOf(minutes.getText()), Integer.valueOf(secondes.getText()));
		duree.setText(d.enSecondes()+" secondes");
	}
	
	//Méthode pour pércuter sur les champs des heures, minutes et secondes les modifications apportées par les bouttons - et +
	private void percuteHaut() {
		int indice = duree.getText().indexOf('s');
		d = new Durree(Integer.valueOf(duree.getText().substring(0, indice-1)));
		heures.setText(String.valueOf(d.getHeures()));
		minutes.setText(String.valueOf(d.getMinutes()));
		secondes.setText(String.valueOf(d.getSecondes()));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProgrammationControle = new JFrame();
		frmProgrammationControle.setTitle("Programmation 1 - Controle Machines");
		frmProgrammationControle.setBounds(100, 100, 479, 300);
		frmProgrammationControle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProgrammationControle.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.GREEN);
		frmProgrammationControle.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelGauche = new JPanel();
		panelGauche.setBackground(SystemColor.control);
		panelPrincipal.add(panelGauche);
		panelGauche.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHeures = new JPanel();
		panelGauche.add(panelHeures, BorderLayout.CENTER);
		panelHeures.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton bouttonGH = new JButton("\u25B2");
		bouttonGH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//------------------------------------------------------------------
				if(Integer.valueOf(heures.getText()) < 23) {
					heures.setText(String.valueOf(Integer.valueOf(heures.getText()) +1));
				}
				else {
					heures.setText("00");
				}
				percuteBas();
				//------------------------------------------------------------------
			}
		});
		panelHeures.add(bouttonGH);
		
		heures = new JTextField();
		heures.setText("11");
		heures.setHorizontalAlignment(SwingConstants.RIGHT);
		heures.setFont(new Font("Tahoma", Font.BOLD, 14));
		heures.setEditable(false);
		panelHeures.add(heures);
		heures.setColumns(10);
		
		JButton bouttonGB = new JButton("\u25BC");
		bouttonGB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//----------------------------------------------------------
				if(Integer.valueOf(heures.getText()) > 0) {
					heures.setText(String.valueOf(Integer.valueOf(heures.getText()) -1));
				}
				else {
					heures.setText("23");
				}
				percuteBas();
				//----------------------------------------------------------
			}
		});
		panelHeures.add(bouttonGB);
		
		JLabel h = new JLabel("h");
		h.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelGauche.add(h, BorderLayout.EAST);
		
		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(SystemColor.control);
		panelPrincipal.add(panelCentre);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMinutes = new JPanel();
		panelCentre.add(panelMinutes, BorderLayout.CENTER);
		panelMinutes.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton bouttonCH = new JButton("\u25B2");
		bouttonCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//-----------------------------------------------
				if(Integer.valueOf(minutes.getText()) < 59) {
					minutes.setText(String.valueOf(Integer.valueOf(minutes.getText()) +1));
				}
				else {
					minutes.setText("00");
				}
				percuteBas();
				//-----------------------------------------------
			}
		});
		panelMinutes.add(bouttonCH);
		
		minutes = new JTextField();
		minutes.setHorizontalAlignment(SwingConstants.RIGHT);
		minutes.setFont(new Font("Tahoma", Font.BOLD, 14));
		minutes.setEditable(false);
		minutes.setText("39");
		panelMinutes.add(minutes);
		minutes.setColumns(10);
		
		JButton bouttonCB = new JButton("\u25BC");
		bouttonCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//------------------------------------------------
				if(Integer.valueOf(minutes.getText()) > 0) {
					minutes.setText(String.valueOf(Integer.valueOf(minutes.getText()) -1));
				}
				else {
					minutes.setText("59");
				}
				percuteBas();
				//------------------------------------------------
			}
		});
		panelMinutes.add(bouttonCB);
		
		JLabel m = new JLabel("m");
		m.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCentre.add(m, BorderLayout.EAST);
		
		JPanel panelDroit = new JPanel();
		panelDroit.setBackground(SystemColor.control);
		panelPrincipal.add(panelDroit);
		panelDroit.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSecondes = new JPanel();
		panelDroit.add(panelSecondes, BorderLayout.CENTER);
		panelSecondes.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton bouttonDH = new JButton("\u25B2");
		bouttonDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//-----------------------------------------------
				if(Integer.valueOf(secondes.getText()) < 59) {
					secondes.setText(String.valueOf(Integer.valueOf(secondes.getText()) + 1));
				}
				else {
					secondes.setText("00");
				}
				percuteBas();
				//-----------------------------------------------
			}
		});
		panelSecondes.add(bouttonDH);
		
		secondes = new JTextField();
		secondes.setHorizontalAlignment(SwingConstants.RIGHT);
		secondes.setFont(new Font("Tahoma", Font.BOLD, 14));
		secondes.setEditable(false);
		secondes.setText("6");
		panelSecondes.add(secondes);
		secondes.setColumns(10);
		
		JButton bouttonDB = new JButton("\u25BC");
		bouttonDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//------------------------------------------------
				if(Integer.valueOf(secondes.getText()) > 0) {
					secondes.setText(String.valueOf(Integer.valueOf(secondes.getText()) -1));
				}
				else {
					secondes.setText("59");
				}
				percuteBas();
				//------------------------------------------------
			}
		});
		panelSecondes.add(bouttonDB);
		
		JLabel s = new JLabel("s");
		s.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelDroit.add(s, BorderLayout.EAST);
		
		JPanel panelSud = new JPanel();
		frmProgrammationControle.getContentPane().add(panelSud, BorderLayout.SOUTH);
		
		JButton moins = new JButton("-");
		moins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//----------------------------------------------
				int indice = duree.getText().indexOf('s');
				if(Integer.valueOf(duree.getText().substring(0, indice-1)) > 0) {
					duree.setText(String.valueOf(Integer.valueOf(duree.getText().substring(0, indice-1)) - 1)+duree.getText().substring(indice-1));
				}
				else {
					moins.disable();
				}
				percuteHaut();
				//----------------------------------------------
			}
		});
		panelSud.add(moins);
		
		duree = new JTextField();
		duree.setEditable(false);
		duree.setFont(new Font("Tahoma", Font.BOLD, 14));
		duree.setText("41946 secondes");
		panelSud.add(duree);
		duree.setColumns(10);
		
		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//-------------------------------------------
				int indice = duree.getText().indexOf('s');
				if(Integer.valueOf(duree.getText().substring(0, indice-1)) < 86399) {
					duree.setText(String.valueOf(Integer.valueOf(duree.getText().substring(0, indice-1)) + 1)+duree.getText().substring(indice-1));
				}
				else {
					plus.disable();
				}
				percuteHaut();
				//-------------------------------------------
			}
		});
		panelSud.add(plus);
	}

}
