import java.awt.EventQueue;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.util.*;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font; 

public class GraphicalUserInterface {

	private JFrame frame;
	private JTextField makeTextField;
	private JTextField modelTextField;
	private JTextField priceTextField;
	private JTextField warrantyTextField;
	private JTextField serieNumberTextField;
	private JTable table;
	private JTextField textField;
	
	private LinkedList<Processor> processors;
	private LinkedList<SoundCard> soundCards;
	private LinkedList<SSD> ssd;
	private LinkedList<VideoCard> videoCards;
	
	private JPanel showProcessorsPanel;
	private JPanel showSoundCardsPanel;
	private JPanel showSSDPanel;
	private JPanel showVideoCardsPanel;
	
	JLayeredPane layeredPane;
	
	
	
    
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicalUserInterface window = new GraphicalUserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}            

	public GraphicalUserInterface() {
		layeredPane = new JLayeredPane();
		
		processors = new LinkedList<Processor>();
		soundCards = new LinkedList<SoundCard>();
		ssd = new LinkedList<SSD>();
		videoCards = new LinkedList<VideoCard>();
		
		initialize();
	}
	
	private void CleanTextFields() {
		makeTextField.setText("");
		modelTextField.setText("");
		priceTextField.setText("");
		warrantyTextField.setText("");
		serieNumberTextField.setText("");
		
	}
	
	private void ShowLabels(JPanel panel) {
		JLabel make = new JLabel("Make");
		make.setBounds(12, 0, 114, 34);
		panel.add(make);
		
		JLabel model = new JLabel("Model");
		model.setBounds(12, 41, 114, 34);
		panel.add(model);
		
		JLabel price = new JLabel("Price");
		price.setBounds(12, 88, 114, 34);
		panel.add(price);
		
		JLabel warranty = new JLabel("Warranty");
		warranty.setBounds(12, 149, 114, 34);
		panel.add(warranty);
		
		JLabel serieNumber = new JLabel("Serie Number");
		serieNumber.setBounds(12, 211, 114, 34);
		panel.add(serieNumber);
		
	}
	
	private void ShowInput(JPanel panel) {
        textField = new JTextField();
		textField.setBounds(464, 461, 39, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		makeTextField = new JTextField();
		makeTextField.setBounds(105, 6, 165, 22);
		panel.add(makeTextField);
		makeTextField.setColumns(10);
		
		modelTextField = new JTextField();
		modelTextField.setColumns(10);
		modelTextField.setBounds(105, 47, 165, 22);
		panel.add(modelTextField);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBounds(105, 94, 165, 22);
		panel.add(priceTextField);
		
		warrantyTextField = new JTextField();
		warrantyTextField.setColumns(10);
		warrantyTextField.setBounds(105, 155, 165, 22);
		panel.add(warrantyTextField);
		
		serieNumberTextField = new JTextField();
		serieNumberTextField.setColumns(10);
		serieNumberTextField.setBounds(105, 217, 165, 22);
		panel.add(serieNumberTextField);
		
	}
	
	private void OpenPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	private JPanel ProcessorPanel() {
		JPanel processorPanel = new JPanel();
		layeredPane.add(processorPanel, "name_681604646307100");
		processorPanel.setLayout(null);
		
		JLabel input = new JLabel("Input form for Processor");
		input.setBounds(400, 8, 341, 49);
		processorPanel.add(input);
		input.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		ShowLabels(processorPanel);
		
		JLabel cores = new JLabel("Cores");
		cores.setBounds(12, 270, 114, 34);
		processorPanel.add(cores);
		
		JLabel mhz = new JLabel("MHZ");
		mhz.setBounds(12, 320, 114, 34);
		processorPanel.add(mhz);
		
		ShowInput(processorPanel);
		
		JTextField coresTextField = new JTextField();
		coresTextField.setColumns(10);
		coresTextField.setBounds(105, 270, 165, 22);
		processorPanel.add(coresTextField);
		
		JTextField mhzTextField = new JTextField();
		mhzTextField.setColumns(10);
		mhzTextField.setBounds(105, 320, 165, 22);
		processorPanel.add(mhzTextField);
		
		int countProcessors = processors.size();
		String convertedCountProcessors = Integer.toString(countProcessors);
		textField.setText(convertedCountProcessors);
		
		JButton addProcessorBtn = new JButton("Add");
		addProcessorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String make = makeTextField.getText();
				String model = modelTextField.getText();
				int warranty = Integer.parseInt(warrantyTextField.getText());
				String serieNumber = serieNumberTextField.getText();
				int cores = Integer.parseInt(coresTextField.getText());
				int mhz = Integer.parseInt(mhzTextField.getText());
				double price = Double.parseDouble(priceTextField.getText());
				
				CleanTextFields();
				coresTextField.setText("");
				mhzTextField.setText("");
				
				Manufacturer manufacturer = new Manufacturer(make,model);
				Processor processor = new Processor(manufacturer,price,warranty,serieNumber,cores,mhz);
				processors.add(processor);
				
				showProcessorsPanel = new JPanel();
				layeredPane.add(showProcessorsPanel, "name_681415529124300");
				showProcessorsPanel.setLayout(null);
				
				JLabel processorsLabel = new JLabel("Processors");
				processorsLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				processorsLabel.setBounds(163, 0, 112, 25);
				showProcessorsPanel.add(processorsLabel);
				
			    String header[] = new String[]{"ID","Make","Model","Price","Warranty","Serie Number","Cores","MHZ"};
				table = new JTable();
			    DefaultTableModel dtm = new DefaultTableModel(header,0);
				 
				for(int i=0;i<processors.size();i++) {
					Object[] objs = {processors.get(i).getId(),processors.get(i).getManufacturer().getMake(),processors.get(i)
							.getManufacturer().getModel(),processors.get(i).getPrice()
							,processors.get(i).getWarranty(),processors.get(i).getSerieNumber(),
							processors.get(i).getNumberOfCores(), processors.get(i).getMhz()}; 
					dtm.addRow(objs);
				}
				table.setModel(dtm);
				JScrollPane sp = new JScrollPane(table);
				sp.setBounds(0, 34, 741, 497);
				showProcessorsPanel.add(sp);
				OpenPanel(showProcessorsPanel);
			}
		});
		addProcessorBtn.setBounds(138, 466, 97, 25);
		processorPanel.add(addProcessorBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Current Processors");
		lblNewLabel_1.setBounds(328, 466, 114, 25);
		processorPanel.add(lblNewLabel_1);
		
		JButton showProcessorsBtn = new JButton("Show");
		showProcessorsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OpenPanel(showProcessorsPanel);
			}
		});
		showProcessorsBtn.setBounds(12, 466, 97, 25);
		processorPanel.add(showProcessorsBtn);
		
	  return processorPanel;
	}
	
	private JPanel SSDPanel() {
		JPanel ssdPanel = new JPanel();
		layeredPane.add(ssdPanel, "name_681604646307100");
		ssdPanel.setLayout(null);
		
		JLabel input = new JLabel("Input form for SSD");
		input.setBounds(400, 8, 341, 49);
		ssdPanel.add(input);
		input.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		ShowLabels(ssdPanel);
		
		JLabel capacity = new JLabel("Capacity");
		capacity.setBounds(12, 270, 114, 34);
		ssdPanel.add(capacity);
		
		ShowInput(ssdPanel);
		
		JTextField capacityTextField = new JTextField();
		capacityTextField.setColumns(10);
		capacityTextField.setBounds(105, 270, 165, 22);
		ssdPanel.add(capacityTextField);
		
		int countSSDs = ssd.size();
		String convertedCountSSDs = Integer.toString(countSSDs);
		textField.setText(convertedCountSSDs);
		
		JButton addSSDBtn = new JButton("Add");
		addSSDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String make = makeTextField.getText();
				String model = modelTextField.getText();
				int warranty = Integer.parseInt(warrantyTextField.getText());
				String serieNumber = serieNumberTextField.getText();
				int capacity = Integer.parseInt(capacityTextField.getText());
				double price = Double.parseDouble(priceTextField.getText());
				
				CleanTextFields();
				capacityTextField.setText("");
				
				Manufacturer manufacturer = new Manufacturer(make,model);
				SSD ssdobject = new SSD(manufacturer,price,warranty,serieNumber,capacity);
				ssd.add(ssdobject);
				
				showSSDPanel = new JPanel();
				layeredPane.add(showSSDPanel, "name_681415529124300");
				showSSDPanel.setLayout(null);
				
				JLabel ssdLabel = new JLabel("SSD");
				ssdLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				ssdLabel.setBounds(163, 0, 112, 25);
				showSSDPanel.add(ssdLabel);
				
			    String header[] = new String[]{"ID","Make","Model","Price","Warranty","Serie Number","Capacity"};
				table = new JTable();
			    DefaultTableModel dtm = new DefaultTableModel(header,0);
				 
				for(int i=0;i<ssd.size();i++) {
					Object[] objs = {ssd.get(i).getId(),ssd.get(i).getManufacturer().getMake(),ssd.get(i)
							.getManufacturer().getModel(),ssd.get(i).getPrice()
							,ssd.get(i).getWarranty(),ssd.get(i).getSerieNumber(),
							ssd.get(i).getCapacity()}; 
					dtm.addRow(objs);
				}
				table.setModel(dtm);
				JScrollPane sp = new JScrollPane(table);
				sp.setBounds(0, 34, 741, 497);
				showSSDPanel.add(sp);
				OpenPanel(showSSDPanel);
			}
		});
		addSSDBtn.setBounds(138, 466, 97, 25);
		ssdPanel.add(addSSDBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Current SSD");
		lblNewLabel_1.setBounds(328, 466, 114, 25);
		ssdPanel.add(lblNewLabel_1);
		
		JButton showSSDBtn = new JButton("Show");
		showSSDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OpenPanel(showSSDPanel);
			}
		});
		showSSDBtn.setBounds(12, 466, 97, 25);
		ssdPanel.add(showSSDBtn);
		
	  return ssdPanel;
	}
	
	private JPanel SoundCardPanel() {
		JPanel soundCardPanel = new JPanel();
		layeredPane.add(soundCardPanel, "name_681604646307100");
		soundCardPanel.setLayout(null);
		
		JLabel input = new JLabel("Input form for Sound Card");
		input.setBounds(400, 8, 341, 49);
		soundCardPanel.add(input);
		input.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		ShowLabels(soundCardPanel);
		
		JLabel db = new JLabel("Db");
		db.setBounds(12, 270, 114, 34);
		soundCardPanel.add(db);
		
		ShowInput(soundCardPanel);
		
		JTextField dbTextField = new JTextField();
		dbTextField.setColumns(10);
		dbTextField.setBounds(105, 270, 165, 22);
		soundCardPanel.add(dbTextField);
		
		int countSoundCards = soundCards.size();
		String convertedCountSoundCards = Integer.toString(countSoundCards);
		textField.setText(convertedCountSoundCards);
		
		JButton addSoundCardBtn = new JButton("Add");
		addSoundCardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String make = makeTextField.getText();
				String model = modelTextField.getText();
				int warranty = Integer.parseInt(warrantyTextField.getText());
				String serieNumber = serieNumberTextField.getText();
				int db = Integer.parseInt(dbTextField.getText());
				double price = Double.parseDouble(priceTextField.getText());
				
				CleanTextFields();
				dbTextField.setText("");
				
				Manufacturer manufacturer = new Manufacturer(make,model);
				SoundCard soundCard = new SoundCard(manufacturer,price,warranty,serieNumber,db);
				soundCards.add(soundCard);
				
				showSoundCardsPanel = new JPanel();
				layeredPane.add(showSoundCardsPanel, "name_681415529124300");
				showSoundCardsPanel.setLayout(null);
				
				JLabel soundCardLabel = new JLabel("Sound Cards");
				soundCardLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				soundCardLabel.setBounds(163, 0, 112, 25);
				showSoundCardsPanel.add(soundCardLabel);
				
			    String header[] = new String[]{"ID","Make","Model","Price","Warranty","Serie Number","DB"};
				table = new JTable();
			    DefaultTableModel dtm = new DefaultTableModel(header,0);
				 
				for(int i=0;i<soundCards.size();i++) {
					Object[] objs = {soundCards.get(i).getId(),soundCards.get(i).getManufacturer().getMake(),soundCards.get(i)
							.getManufacturer().getModel(),soundCards.get(i).getPrice()
							,soundCards.get(i).getWarranty(),soundCards.get(i).getSerieNumber(),
							soundCards.get(i).getDb()}; 
					dtm.addRow(objs);
				}
				table.setModel(dtm);
				JScrollPane sp = new JScrollPane(table);
				sp.setBounds(0, 34, 741, 497);
				showSoundCardsPanel.add(sp);
				OpenPanel(showSoundCardsPanel);
			}
		});
		addSoundCardBtn.setBounds(138, 466, 97, 25);
		soundCardPanel.add(addSoundCardBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Current Sound Cards");
		lblNewLabel_1.setBounds(328, 466, 124, 25);
		soundCardPanel.add(lblNewLabel_1);
		
		JButton showSoundCardsBtn = new JButton("Show");
		showSoundCardsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OpenPanel(showSoundCardsPanel);
			}
		});
		showSoundCardsBtn.setBounds(12, 466, 97, 25);
		soundCardPanel.add(showSoundCardsBtn);
		
	  return soundCardPanel;
	}
	
	private JPanel VideoCardPanel() {
		JPanel videoCardPanel = new JPanel();
		layeredPane.add(videoCardPanel, "name_671604646307100");
		videoCardPanel.setLayout(null);
        
		JLabel input = new JLabel("Input form for Video Card");
		input.setBounds(400, 8, 341, 49);
		videoCardPanel.add(input);
		input.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		ShowLabels(videoCardPanel);
		
		JLabel ram = new JLabel("RAM");
		ram.setBounds(12, 270, 114, 34);
		videoCardPanel.add(ram);
		
		JLabel bitRate = new JLabel("Bit Rate");
		bitRate.setBounds(12, 320, 114, 34);
		videoCardPanel.add(bitRate);
		
        ShowInput(videoCardPanel);
		
		JTextField ramTextField = new JTextField();
		ramTextField.setColumns(10);
		ramTextField.setBounds(105, 270, 165, 22);
		videoCardPanel.add(ramTextField);
		
		JTextField bitRateTextField = new JTextField();
		bitRateTextField.setColumns(10);
		bitRateTextField.setBounds(105, 320, 165, 22);
		videoCardPanel.add(bitRateTextField);
		
		int countVideoCards = videoCards.size();
		String convertedCountVideoCards = Integer.toString(countVideoCards);
		textField.setText(convertedCountVideoCards);
		
		JButton addVideoCardBtn = new JButton("Add");
		addVideoCardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String make = makeTextField.getText();
				String model = modelTextField.getText();
				int warranty = Integer.parseInt(warrantyTextField.getText());
				String serieNumber = serieNumberTextField.getText();
				int ram = Integer.parseInt(ramTextField.getText());
				int bitRate = Integer.parseInt(bitRateTextField.getText());
				double price = Double.parseDouble(priceTextField.getText());
				
				CleanTextFields();
				bitRateTextField.setText("");
				ramTextField.setText("");

				Manufacturer manufacturer = new Manufacturer(make,model);
				
				VideoCard videoCard = new VideoCard(manufacturer,price,warranty,serieNumber,ram,bitRate);
				videoCards.add(videoCard);
				
				showVideoCardsPanel = new JPanel();
				layeredPane.add(showVideoCardsPanel, "name_681415529124300");
				showVideoCardsPanel.setLayout(null);
				
				JLabel videoCardsLabel = new JLabel("Video Cards");
				videoCardsLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				videoCardsLabel.setBounds(163, 0, 112, 25);
				showVideoCardsPanel.add(videoCardsLabel);
				

			    String header[] = new String[]{"ID","Make","Model","Price","Warranty","Serie Number","RAM","Bit Rate"};
				table = new JTable();
			    DefaultTableModel dtm = new DefaultTableModel(header,0);
				 
			    for(int i=0;i<videoCards.size();i++) {
					Object[] objs = {videoCards.get(i).getId(),videoCards.get(i).getManufacturer().getMake(),videoCards.get(i)
							.getManufacturer().getModel(),videoCards.get(i).getPrice()
							,videoCards.get(i).getWarranty(),videoCards.get(i).getSerieNumber(),
							videoCards.get(i).getRam(),videoCards.get(i).getBitRate()}; 
					dtm.addRow(objs);
				}
			    table.setModel(dtm);
				JScrollPane sp = new JScrollPane(table);
				sp.setBounds(0, 34, 741, 497);
				showVideoCardsPanel.add(sp);
				OpenPanel(showVideoCardsPanel);
			}
		});
		addVideoCardBtn.setBounds(138, 466, 97, 25);
		videoCardPanel.add(addVideoCardBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Current Video Cards");
		lblNewLabel_1.setBounds(328, 466, 124, 25);
		videoCardPanel.add(lblNewLabel_1);
		
		JButton showVideoCardsBtn = new JButton("Show");
		showVideoCardsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OpenPanel(showVideoCardsPanel);
			}
		});
		showVideoCardsBtn.setBounds(12, 466, 97, 25);
		videoCardPanel.add(showVideoCardsBtn);
	  return videoCardPanel;
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		
		layeredPane.setBounds(406, 13, 741, 531);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel welcomePanel = new JPanel();
		layeredPane.add(welcomePanel, "name_671430906635100");
		welcomePanel.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 41, 43, -31);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel introLabel = new JLabel("Choose for which component you want to fill the data");
		introLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		introLabel.setBounds(12, 13, 364, 96);
		frame.getContentPane().add(introLabel);
		
		JButton processorInputBtn = new JButton("Processor");
		processorInputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			OpenPanel(ProcessorPanel());
			
			}
		});
		processorInputBtn.setBounds(46, 122, 141, 43);
		frame.getContentPane().add(processorInputBtn);
		
		JButton soundCardInputBtn = new JButton("Sound Card");
		soundCardInputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenPanel(SoundCardPanel());
			}
		});
		soundCardInputBtn.setBounds(46, 190, 141, 43);
		frame.getContentPane().add(soundCardInputBtn);
		
		JButton ssdInputBtn = new JButton("SSD");
		ssdInputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenPanel(SSDPanel());
			}
		});
		ssdInputBtn.setBounds(46, 269, 141, 49);
		frame.getContentPane().add(ssdInputBtn);
		
		JButton videoCardInputBtn = new JButton("Video Card");
		videoCardInputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenPanel(VideoCardPanel());
			}
		});
		videoCardInputBtn.setBounds(46, 350, 141, 49);
		frame.getContentPane().add(videoCardInputBtn);
		frame.setBounds(100, 100, 1144, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
