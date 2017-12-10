package com.mycompany.dottornosy;

import java.awt.EventQueue;
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

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPanel window = new ControlPanel();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 1166, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(494, 36, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 76, 1124, 459);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
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
