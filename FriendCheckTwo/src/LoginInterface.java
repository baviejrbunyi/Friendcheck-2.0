import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.swing.*;

public class LoginInterface extends Resources implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//labels
	private JLabel usernameLabel = new JLabel("Username:");
	private JLabel passwordLabel = new JLabel("Password:");
	private JLabel errorLabel = new JLabel();
	
	private static int loginId;
	
	void Labels() {
		//usernmaeLabel
		usernameLabel.setBounds(100,110,130,39);
		usernameLabel.setFont(robotoPlain25);
		
		//passwordLabel
		passwordLabel.setBounds(100,175,130,39);
		passwordLabel.setFont(robotoPlain25);
		
		//errorLabel
		errorLabel.setBounds(100,240,500,39);
		errorLabel.setFont(robotoPlain14);
		errorLabel.setForeground(red);
		
		//adding to the frame
		this.add(usernameLabel);
		this.add(passwordLabel);
		this.add(errorLabel);
	}
	
	static //textfields and passwordfields
	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	
	void Fields() {
		//Username Field
				username.setBounds(229,110,271,30);
				username.setFont(robotoPlain25);
				username.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
				username.setBackground(null);
				
				//Password Field
				password.setBounds(229,175,271,30);
				password.setFont(robotoPlain25);
				password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
				password.setBackground(null);
				
				//Adding to the JFrame
				this.add(username);
				this.add(password);
	}
	
	//jbutton
	private JButton loginButton = new JButton("Log In");
	
	void Buttons() {
		//Log In Button
			loginButton.setBounds(200,300,200,60);
			loginButton.setBackground(grey);
			loginButton.setFont(robotoPlain25);
			loginButton.setFocusable(false);
			loginButton.addActionListener(this);
				
		//Adding to the JFrame
			this.add(loginButton);
	}
	
	LoginInterface(){
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setTitle("FriendCheck");
		this.setIconImage(logo.getImage());
		this.setLayout(null);
		
		Labels();
		Fields();
		Buttons();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton) {
			Check_User();
		}
		
	}
	
	//check user
	public void Check_User() {
		String usernameValue = username.getText();
		@SuppressWarnings("deprecation")
		String passwordValue = password.getText();
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/friendcheckone","root", "465a7dhn");
			String queryOne = "SELECT * FROM friendcheckone.users WHERE username = '" + usernameValue + "' and password = '" + passwordValue + "'";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(queryOne);
			

			if (rs.next()) {
				new UserInterface();
				this.dispose();
			} else {
				errorLabel.setText("Wrong Username or Password. Try Again");
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} 
	
	//getting the user id
	public static void setLoginId(String usernameValue) {
		String username = usernameValue;
		
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/friendcheckone","root", "465a7dhn");
			String queryOne = "SELECT * FROM friendcheckone.users WHERE username ='" + username + "'";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(queryOne);
			
			
			rs.next();
			LoginInterface.loginId = rs.getInt("id");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static int getLoginId() {
		setLoginId(username.getText());
		return loginId;
	}
}
