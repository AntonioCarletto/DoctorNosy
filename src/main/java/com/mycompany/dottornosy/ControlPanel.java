package com.mycompany.dottornosy;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.JFrame;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 *  DataLogger.Log(LOG_FLAG, "Start Crawler", LOG_FILE_NAME);
        createDir(CSV_DIR_NAME);

        switch (args.length) {
            case 1:

                if (args[0].equalsIgnoreCase("BAKEKA")) {
                    SiteCrawling("NO_MICRO", "BAKEKA", CSV_FILE_NAME);
                } else if (args[0].equalsIgnoreCase("SUBITO")) {
                    SiteCrawling("NO_MICRO", "SUBITO", CSV_FILE_NAME);
                } else if (args[0].equalsIgnoreCase("OGGILAVORO")) {
                    SiteCrawling("NO_MICRO", "OGGILAVORO", CSV_FILE_NAME);
                } else {
                    SiteCrawling("NO_MICRO", "BAKEKA", CSV_FILE_NAME);
                    SiteCrawling("NO_MICRO", "SUBITO", CSV_FILE_NAME);
                    SiteCrawling("NO_MICRO", "OGGILAVORO", CSV_FILE_NAME);

                }
                break;
            case 2:
                System.out.println("secondo if");
                if (args[0].equalsIgnoreCase("BAKEKA") && !(args[1].isEmpty())) {
                    SiteCrawling("NO_MICRO", "BAKEKA", args[1] + ".csv");

                } else if (args[0].equalsIgnoreCase("SUBITO") && !(args[1].isEmpty())) {
                    SiteCrawling("NO_MICRO", "SUBITO", args[1] + ".csv");

                } else if (args[0].equalsIgnoreCase("OGGILAVORO") && !(args[1].isEmpty())) {
                    SiteCrawling("NO_MICRO", "OGGILAVORO", args[1] + ".csv");
                } else if (args[0].equalsIgnoreCase("ALL") && !(args[1].isEmpty())) {
                    SiteCrawling("NO_MICRO", "BAKEKA", args[1] + ".csv");
                    SiteCrawling("NO_MICRO", "SUBITO", args[1] + ".csv");
                    SiteCrawling("NO_MICRO", "OGGILAVORO", args[1] + ".csv");

                } else {

                    SiteCrawling("NO_MICRO", "BAKEKA", args[1] + ".csv");
                    SiteCrawling("NO_MICRO", "SUBITO", args[1] + ".csv");
                    SiteCrawling("NO_MICRO", "OGGILAVORO", args[1] + ".csv");

                }
                break;
            default:

                SiteCrawling("NO_MICRO", "BAKEKA", CSV_FILE_NAME);
                SiteCrawling("NO_MICRO", "SUBITO", CSV_FILE_NAME);
                SiteCrawling("NO_MICRO", "OGGILAVORO", CSV_FILE_NAME);
                break;
        }

        DataLogger.Log(LOG_FLAG, "Crawling done!", LOG_FILE_NAME);

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
	private JTextField textField_1;
	private JTextField textField_2;

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
	 */
	public ControlPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDoctorNosy = new JFrame();
		frmDoctorNosy.setResizable(false);
		frmDoctorNosy.setTitle("Doctor Nosy");
		frmDoctorNosy.setIconImage(Toolkit.getDefaultToolkit().getImage(ControlPanel.class.getResource("/Image/iconaDoctorNosy.png")));
		frmDoctorNosy.setBounds(100, 100, 1166, 595);
		frmDoctorNosy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDoctorNosy.getContentPane().setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon(ControlPanel.class.getResource("/Image/logo2.png")));
//		lblNewLabel.setBounds(-27, -15, 1124, 133);
//		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 162, 1124, 373);
		frmDoctorNosy.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(49, 28, 56, 16);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(39, 57, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(233, 28, 56, 16);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(222, 57, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(414, 28, 56, 16);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(405, 57, 116, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(39, 92, 482, 22);
		panel.add(btnNewButton);
		
		ImageIcon icon = new ImageIcon(ControlPanel.class.getResource("/Image/logo2.png"));
		Image scaledImage = icon.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		icon.setImage(scaledImage);
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setBounds(214, 23, 712, 153);
		frmDoctorNosy.getContentPane().add(lblNewLabel);
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

	                DataLogger.Log(LOG_FLAG, "La directory " + nameDir + " Ã¨ stata creata;", LOG_FILE_NAME);
	            } else {
	                DataLogger.Log(LOG_FLAG, "La directory " + nameDir + " esiste giÃ ;", LOG_FILE_NAME);
	            }

	        } catch (IOException mdE) {
	            mdE.printStackTrace();
	        }

	    }
	 
	 private static void MultiPageCrawling(String type, String siteName, String csvName) {

	        InfoAbstractFactory factory = FactoryProducer.getFactory(type);
	        InfoNoMicro siteNoMicro = factory.getNoMicroInfo(siteName);

	        String[] InfoAd = new String[siteNoMicro.getMaxSize()];
	        HashSet<String> hS = new HashSet<String>();


	        for (int i = 2; i < siteNoMicro.getMaxPage(); i++) {

	            DataLogger.Log(LOG_FLAG, "Pag." + i, LOG_FILE_NAME);
	            Elements e = siteNoMicro.exstractInfo(i);
	            COUNT = hS.size();

	            for (Element info : e) {

	                InfoAd = siteNoMicro.printInfo(info);
	                hS.add(InfoAd[1]);
	                COUNT2 = hS.size();

	                if (COUNT != COUNT2) {
	                    CsvWriting.csvWriter(InfoAd, siteNoMicro.getMaxSize(), csvName);
	                    DataLogger.Log(LOG_FLAG, "Annuncio: " + InfoAd[0], LOG_FILE_NAME);
	                } else {
	                    DataLogger.Log(LOG_FLAG, "Annuncio: " + InfoAd[0] + " giÃ  presente.", LOG_FILE_NAME);
	                }

	            }
	        }
	    }
}
