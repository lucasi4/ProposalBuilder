package proposalBuilder;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanel contentPane;
	private ProposalBuilder builder;
	
	private String projectNameString = "Project Name:";
	private String clientNameString = "Client Name:";
	private String clientContactNameString = "To:";
	private String clientContactPhoneString = "Phone:";
	private String typeInteriorString = "Interior";
	private String typeExteriorString = "Exterior";
	private String typeInteriorExteriorString = "Interior & Exterior";
	
	private JTextField projectNameTextField;
	private JTextField clientNameTextField;
	private JTextField clientContactNameTextField;
	private JTextField clientContactPhoneTextField;
	private JLabel clientNameLabel;
	private JLabel projectNameLabel;
	private JLabel clientContactNameLabel;
	private JLabel clientContactPhoneLabel;
	
	private JRadioButton interiorRadio;
	private JRadioButton exteriorRadio;
	private JRadioButton interiorExteriorRadio;
			
	
	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 494);
		contentPane = new JPanel();
		JScrollPane scroll = new JScrollPane(contentPane);
		add(scroll);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(250, 250));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		init();		
	}
	
	public void init(){
		addLogo();
		projectName();
		clientInfo();
		projectType();
		//createButton();
		builder = new ProposalBuilder();
	}
	
	public void addLogo(){
		try {
			BufferedImage logo = ImageIO.read(new File("D:\\Users\\Lucas\\workspace\\ProposalBuilder\\Resources\\logo.jpg"));			
			JLabel logoLabel = new JLabel(new ImageIcon(logo));
			logoLabel.setBounds(130, 11, 472, 116);
			contentPane.add(logoLabel);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void projectName(){
		projectNameLabel = new JLabel(projectNameString);
		projectNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		projectNameLabel.setBounds(10, 170, 120, 14);
		contentPane.add(projectNameLabel);
		
		projectNameTextField = new JTextField();
		projectNameTextField.setBounds(106, 168, 168, 20);
		contentPane.add(projectNameTextField);
		projectNameTextField.setColumns(10);		
	}
	
	public void clientInfo(){
		clientNameLabel = new JLabel(clientNameString);
		clientNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		clientNameLabel.setBounds(10, 199, 104, 14);
		contentPane.add(clientNameLabel);
		
		clientNameTextField = new JTextField();
		clientNameTextField.setBounds(106, 195, 168, 20);
		contentPane.add(clientNameTextField);
		
		clientContactNameLabel = new JLabel(clientContactNameString);
		clientContactNameLabel.setFont((new Font("Tahoma", Font.PLAIN, 12)));
		clientContactNameLabel.setBounds(10, 229, 90, 14);
		contentPane.add(clientContactNameLabel);
		
		clientContactNameTextField = new JTextField();
		clientContactNameTextField.setBounds(106, 227, 168, 20);
		contentPane.add(clientContactNameTextField);
		
		clientContactPhoneLabel = new JLabel(clientContactPhoneString);
		clientContactPhoneLabel.setFont((new Font("Tahoma", Font.PLAIN, 12)));
		clientContactPhoneLabel.setBounds(10, 259, 76, 14);
		contentPane.add(clientContactPhoneLabel);
		
		clientContactPhoneTextField = new JTextField();
		clientContactPhoneTextField.setBounds(106, 254, 168, 20);
		contentPane.add(clientContactPhoneTextField);				
	}

	public void projectType(){
		interiorRadio = new JRadioButton(typeInteriorString);
		interiorRadio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		interiorRadio.setBackground(Color.WHITE);
		interiorRadio.setBounds(375, 180, 109, 23);
		contentPane.add(interiorRadio);
		
		exteriorRadio = new JRadioButton(typeExteriorString);
		exteriorRadio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		exteriorRadio.setBackground(Color.WHITE);
		exteriorRadio.setBounds(375, 205, 182, 23);
		contentPane.add(exteriorRadio);
		
		interiorExteriorRadio = new JRadioButton(typeInteriorExteriorString);
		interiorExteriorRadio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		interiorExteriorRadio.setBackground(Color.WHITE);
		interiorExteriorRadio.setBounds(375, 230, 168, 23);
		contentPane.add(interiorExteriorRadio);
		
		ButtonGroup typeRadioGroup = new ButtonGroup();
		typeRadioGroup.add(interiorRadio);
		typeRadioGroup.add(exteriorRadio);
		typeRadioGroup.add(interiorExteriorRadio);
	}
}
