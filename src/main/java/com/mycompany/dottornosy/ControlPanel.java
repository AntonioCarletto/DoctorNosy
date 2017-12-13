package com.mycompany.dottornosy;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

import javax.swing.JFrame;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

/**
 * @author Antonio
 *
 */


public class ControlPanel {

	public static final boolean LOG_FLAG = true;
	public static final String CSV_DIR_NAME = "Report";
	public static final String CSV_FILE_NAME = CSV_DIR_NAME + "/" + DateAndTime.PDTBritish() + ".csv";
	public static final String LOG_FILE_NAME = DateAndTime.PDTBritish() + ".txt";
	public static int COUNT;
	public static int COUNT2;

	private JFrame frmDoctorNosy;
	private JTextField textField;
	private JTextField textFieldNome;
	private JTextField textField_1;
	private JTextField textFieldCognome;
	private JTextField textField_2;
	private JTextField textFieldCittà;
	private JTextField textIPRemote;
	private JTextField texthostRemote;
	private JTextField textCanonicRemote;
	private JTextField textInsert;
	private String nomeRicerca;
	private String cognomeRicerca;
	private String cittàRicerca;
	private String struttura;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPanel window = new ControlPanel();
					window.frmDoctorNosy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnknownHostException 
	 */
	public ControlPanel() throws UnknownHostException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws UnknownHostException 
	 */
	private void initialize() throws UnknownHostException {
		
		frmDoctorNosy = new JFrame();
		frmDoctorNosy.setResizable(false);
		frmDoctorNosy.setTitle("Doctor Nosy");
		frmDoctorNosy.setIconImage(Toolkit.getDefaultToolkit().getImage(ControlPanel.class.getResource("/Image/iconaDoctorNosy.png")));
		frmDoctorNosy.setBounds(100, 100, 1166, 595);
		frmDoctorNosy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDoctorNosy.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 162, 1124, 373);
		frmDoctorNosy.getContentPane().add(tabbedPane);

		ImageIcon icon = new ImageIcon(ControlPanel.class.getResource("/Image/logo2.png"));
		Image scaledImage = icon.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		icon.setImage(scaledImage);
		JLabel JLabelLogo = new JLabel(icon);
		JLabelLogo.setBounds(245, 24, 712, 153);
		frmDoctorNosy.getContentPane().add(JLabelLogo);
		
		
		
		/**
		 * Pannello My Host
		 */
		JPanel pannelloMyHost = new JPanel();
		tabbedPane.addTab("My Host", null, pannelloMyHost, null);
		
		pannelloMyHost.setBackground(Color.WHITE);
		tabbedPane.addTab("Host Lookup Locale", null, pannelloMyHost, null);
		pannelloMyHost.setLayout(null);

		JLabel lblHostLocale = new JLabel("Host locale: ");
		lblHostLocale.setFont(new Font("Arial", Font.PLAIN, 16));
		lblHostLocale.setBounds(12, 63, 135, 16);
		pannelloMyHost.add(lblHostLocale);

		JLabel lblIndirizzoIpLocale = new JLabel("Indirizzo IP locale:");
		lblIndirizzoIpLocale.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIndirizzoIpLocale.setBounds(278, 63, 172, 16);
		pannelloMyHost.add(lblIndirizzoIpLocale);

		JLabel lblNewLabel = new JLabel("Hostname canonico:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(549, 63, 172, 16);
		pannelloMyHost.add(lblNewLabel);

		JLabel label = new JLabel("Informazioni macchina Locale:");
		label.setForeground(new Color(255, 102, 153));
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(12, 13, 295, 38);
		pannelloMyHost.add(label);
		
		InetAddress local = InetAddress.getLocalHost();
		textField = new JTextField(local.getHostName());
		textField.setEditable(false);
		textField.setFont(new Font("Arial Black", Font.BOLD, 16));
		textField.setBounds(12, 92, 227, 31);
		pannelloMyHost.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(local.getHostAddress());
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(278, 92, 227, 31);
		pannelloMyHost.add(textField_1);

		textField_2 = new JTextField(local.getCanonicalHostName());
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(549, 92, 366, 31);
		pannelloMyHost.add(textField_2);
		
		
		/**
		 * Pannello Host Translate
		 */
		JPanel pannelloHostTrans = new JPanel();
		tabbedPane.addTab("Host Translate", null, pannelloHostTrans, null);
		pannelloHostTrans.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Informazioni macchina remota:");
		lblNewLabel_1.setBounds(12, 154, 291, 24);
		pannelloHostTrans.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 102, 102));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));

		JLabel lblHostRemoto = new JLabel("Host remoto: ");
		lblHostRemoto.setBounds(12, 191, 93, 19);
		pannelloHostTrans.add(lblHostRemoto);
		lblHostRemoto.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblIndirizzoIpRemoto = new JLabel("Indirizzo IP remoto:");
		lblIndirizzoIpRemoto.setBounds(250, 191, 131, 19);
		pannelloHostTrans.add(lblIndirizzoIpRemoto);
		lblIndirizzoIpRemoto.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel label_3 = new JLabel("Hostname canonico:");
		label_3.setBounds(498, 191, 142, 19);
		pannelloHostTrans.add(label_3);
		label_3.setFont(new Font("Arial", Font.PLAIN, 16));

		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setBounds(455, 103, 97, 25);
		pannelloHostTrans.add(btnCerca);

		textIPRemote = new JTextField();
		textIPRemote.setFont(new Font("Arial Black", Font.BOLD, 16));
		textIPRemote.setEditable(false);
		textIPRemote.setBounds(250, 224, 222, 29);
		pannelloHostTrans.add(textIPRemote);
		textIPRemote.setColumns(10);

		texthostRemote = new JTextField();
		texthostRemote.setFont(new Font("Arial", Font.BOLD, 16));
		texthostRemote.setEditable(false);
		texthostRemote.setBounds(15, 224, 203, 29);
		pannelloHostTrans.add(texthostRemote);
		texthostRemote.setColumns(10);

		textCanonicRemote = new JTextField();
		textCanonicRemote.setFont(new Font("Arial Black", Font.BOLD, 16));
		textCanonicRemote.setEditable(false);
		textCanonicRemote.setBounds(498, 224, 362, 29);
		pannelloHostTrans.add(textCanonicRemote);
		textCanonicRemote.setColumns(10);

		textInsert = new JTextField();
		textInsert.setFont(new Font("Arial Black", Font.PLAIN, 15));
		textInsert.setBounds(281, 52, 445, 28);
		pannelloHostTrans.add(textInsert);
		textInsert.setColumns(10);

		JLabel lblInserireNomeDel = new JLabel("Inserire nome del sito oppure hostname nella macchina:");
		lblInserireNomeDel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInserireNomeDel.setBounds(307, 20, 384, 19);
		pannelloHostTrans.add(lblInserireNomeDel);

		
		btnCerca.addActionListener(new ActionListener() {
			private String remoteHostname;
			private String remoteIP;
			private String remoteCanonic;

			public void actionPerformed(ActionEvent e) {

				InetAddress remote;
				try {
					remote = InetAddress.getByName(textInsert.getText());
					remoteHostname = remote.getHostName();
					remoteIP = remote.getHostAddress();
					remoteCanonic = remote.getCanonicalHostName();

				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null, "Hostname inesistente, riprova!");
				}

				texthostRemote.setText(remoteHostname);
				textIPRemote.setText(remoteIP);
				textCanonicRemote.setText(remoteCanonic);

			}
		});
		
		
		
		/**
		 * Pannello Doctor Nosy
		 */
		JPanel panelloDNosy = new JPanel();
		tabbedPane.addTab("Nosy", null, panelloDNosy, null);
		panelloDNosy.setLayout(null);
		
		JLabel lblNewLabe = new JLabel("Nome:");
		lblNewLabe.setBounds(344, 13, 83, 16);
		panelloDNosy.add(lblNewLabe);
		
		textFieldNome = new JTextField();
		textFieldNome.setToolTipText("");
		textFieldNome.setBounds(427, 10, 116, 22);
		panelloDNosy.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cognome:");
		lblNewLabel_2.setBounds(344, 42, 83, 16);
		panelloDNosy.add(lblNewLabel_2);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setBounds(427, 39, 116, 22);
		panelloDNosy.add(textFieldCognome);
		textFieldCognome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Città:");
		lblNewLabel_3.setBounds(344, 71, 56, 16);
		panelloDNosy.add(lblNewLabel_3);
		
		textFieldCittà = new JTextField();
		textFieldCittà.setBounds(427, 71, 116, 22);
		panelloDNosy.add(textFieldCittà);
		textFieldCittà.setColumns(10);
		
		final JRadioButton MicroRadioButton = new JRadioButton("Con Microdati");
		MicroRadioButton.setToolTipText("Estrae informazioni da siti che contengono Microdati");
		MicroRadioButton.setBounds(569, 9, 127, 25);
		panelloDNosy.add(MicroRadioButton);
		
		final JRadioButton NoMicroRadioButton = new JRadioButton("Senza Microdati");
		NoMicroRadioButton.setToolTipText("Estrae informazioni da siti che non contngono Microdati");
		NoMicroRadioButton.setSelected(true);
		NoMicroRadioButton.setBounds(569, 38, 127, 25);
		panelloDNosy.add(NoMicroRadioButton);
		
		final JRadioButton entrambiRadioButton = new JRadioButton("Entrambi");
		entrambiRadioButton.setToolTipText("Estrae informazioni sia dai siti con Microdati che senza");
		entrambiRadioButton.setBounds(569, 67, 127, 25);
		panelloDNosy.add(entrambiRadioButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(MicroRadioButton);
		bg.add(NoMicroRadioButton);
		bg.add(entrambiRadioButton);
		
		
		JButton nosyButton = new JButton("Nosy");
		nosyButton.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				
				
				DataLogger.Log(LOG_FLAG, "Start Crawler", LOG_FILE_NAME);
		        createDir(CSV_DIR_NAME);
				
		        nomeRicerca = textFieldNome.getText();
		        cognomeRicerca = textFieldCognome.getText();
		        cittàRicerca = textFieldCittà.getText();

		        if(MicroRadioButton.isSelected()) {
		        	struttura = "micro";
		        } else if (NoMicroRadioButton.isSelected()) {
		        	struttura = "nomicro";
		        } else {
		        	struttura = "entrambi";
		        }
		        
		        
		        

		        if(struttura.equalsIgnoreCase("MICRO")) {
		        	MultiPageCrawling(struttura, "parsermicrohttp", CSV_FILE_NAME);
		        	MultiPageCrawling(struttura, "parsermicrohttps", CSV_FILE_NAME);
		        } else if (struttura.equalsIgnoreCase("NOMICRO")) {
		        	MultiPageCrawling(struttura, "facebook", CSV_FILE_NAME);
		        	MultiPageCrawling(struttura, "instagram", CSV_FILE_NAME);
		        	MultiPageCrawling(struttura, "twitter", CSV_FILE_NAME);
		        } else {
		        	MultiPageCrawling(struttura, "parsermicrohttp", CSV_FILE_NAME);
		        	MultiPageCrawling(struttura, "parsermicrohttps", CSV_FILE_NAME);
		        	MultiPageCrawling("NOMICRO", "facebook", CSV_FILE_NAME);
		        	MultiPageCrawling("NOMICRO", "instagram", CSV_FILE_NAME);
		        	MultiPageCrawling("NOMICRO", "twitter", CSV_FILE_NAME);
		        	
		        }
		        
		        
		        
		        
			}
		});
		nosyButton.setBounds(344, 106, 352, 25);
		panelloDNosy.add(nosyButton);
		
	}
	
	
	
	 private static void createDir(String nameDir) {
	        try {
	            String nameDirectory = nameDir;
	            File dir = new File(nameDirectory);

	            if (!(dir.exists())) {
	                dir.mkdir();
	                String fileName = nameDir + "/README.md";
	                File mdFile = new File(fileName);
	                FileWriter mdFW = new FileWriter(mdFile, true);
	                BufferedWriter mdBW = new BufferedWriter(mdFW);
	                mdBW.write("This folder contains all the csv reports.");
	                mdBW.close();

	                DataLogger.Log(LOG_FLAG, "La directory " + nameDir + " è stata creata;", LOG_FILE_NAME);
	            } else {
	                DataLogger.Log(LOG_FLAG, "La directory " + nameDir + " esiste già;", LOG_FILE_NAME);
	            }

	        } catch (IOException mdE) {
	            mdE.printStackTrace();
	        }

	    }
	 
	 
	 
	 private static void MultiPageCrawling(String type, String parserName, String csvName) {

	        InfoAbstractFactory factory = FactoryProducer.getFactory(type);
	        InfoNoMicro siteParser = factory.getNoMicroInfo(parserName);

	        String[] arrayInfo = new String[siteParser.getMaxSize()];

	        for (int i = 1; i < siteParser.getMaxPage(); i++) {

	            DataLogger.Log(LOG_FLAG, "Pag." + i, LOG_FILE_NAME);
	            Elements e = siteParser.exstractInfo(i);
	           

	            for (Element info : e) {
	                arrayInfo = siteParser.printInfo(info);
	                CsvWriting.csvWriter(arrayInfo, siteParser.getMaxSize(), csvName);
	                DataLogger.Log(LOG_FLAG, "Informazione: " + arrayInfo[0], LOG_FILE_NAME);
	            }
	        }
	    }
}
