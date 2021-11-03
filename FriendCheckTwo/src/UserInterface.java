import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

public class UserInterface extends Resources {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//labels
	private JLabel frameLabel = new JLabel("YOUR FRIENDS");
	private JLabel birthdayLabel = new JLabel("Birthday:");
	private JLabel genderLabel = new JLabel("Gender:");
	private JLabel addressLabel = new JLabel("Address:");
	private JLabel notesLabel = new JLabel("Notes:");
	private JLabel name = new JLabel();
	private JLabel age = new JLabel();
	private JLabel birthday = new JLabel();
	private JLabel gender= new JLabel();
	private JLabel address= new JLabel();
	private JTextArea notes = new JTextArea();
	private JLabel newNameLabel = new JLabel("Name:");
	private JLabel newAgeLabel = new JLabel("Age:");
	private JLabel newBirthdayLabel = new JLabel("Birthday:");
	private JLabel newGenderLabel = new JLabel("Gender:");
	private JLabel newAddressLabel = new JLabel("Address");
	private JLabel newNotesLabel = new JLabel("Notes:");
	
	
	
	public void Labels() {
		//frameLabel
		frameLabel.setBounds(50,60,400,84);
		frameLabel.setFont(robotoPlain40);
		
		//name
		name.setBounds(50,50,300,47);
		name.setFont(robotoPlain25);
		
		//age
		age.setBounds(50,90,300,47);
		age.setFont(robotoPlain25);
		
		//birthdayLabel
		birthdayLabel.setBounds(50,200,300,47);
		birthdayLabel.setFont(robotoPlain14);
		
		//genderLabel
		genderLabel.setBounds(50,240,300,47);
		genderLabel.setFont(robotoPlain14);
		
		//addressLabel
		addressLabel.setBounds(50,280,300,47);
		addressLabel.setFont(robotoPlain14);
		
		//notesLabel
		notesLabel.setBounds(50,380,300,47);
		notesLabel.setFont(robotoPlain14);
		
		//birthday
		birthday.setBounds(150,200,500,47);
		birthday.setFont(robotoPlain14);
		
		//gender
		gender.setBounds(150,240,500,47);
		gender.setFont(robotoPlain14);
		
		//address
		address.setBounds(150,280,500,47);
		address.setFont(robotoPlain14);
		
		//notes
		notes.setBounds(50,425,500,200);
		notes.setLineWrap(true);
	    notes.setWrapStyleWord(true);
	    notes.setBackground(null);
	    notes.setFont(robotoPlain14);
	    notes.setEditable(false);
	    notes.setFocusable(false);
	    notes.setOpaque(false);
	    
	    
		//adding to the panel
		getContentPane().add(frameLabel);
		getContentPane().add(newNameLabel);
		getContentPane().add(newAgeLabel);
		getContentPane().add(newBirthdayLabel);
		getContentPane().add(newGenderLabel);
		getContentPane().add(newAddressLabel);
		getContentPane().add(newNotesLabel);
	}
	
	//buttons
	private JButton addButton = new JButton("ADD");
	private JButton logoutButton = new JButton("LOGOUT");
	private JButton removeButton = new JButton("REMOVE");
	private JButton cancelButton = new JButton("CANCEL");
	private JButton confirmButton = new JButton("CONFIRM");
	
	public void Buttons() {
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add();
			}
		});
		//addButton
		addButton.setBounds(50,700,190,50);
		addButton.setFocusable(false);
		
		//logoutButton
		logoutButton.setBounds(260,700,190,50);
		logoutButton.setFocusable(false);
		logoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Log_Out();
			}
		});
		
		//removeButton
		removeButton.setBounds(50,660,190,50);
		removeButton.setFocusable(false);
		removeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Delete_Friend();
			}
		});
		
		//adding buttons
		getContentPane().add(addButton);
		getContentPane().add(logoutButton);
		getContentPane().add(cancelButton);
		getContentPane().add(confirmButton);
		
		
		panel.add(removeButton);
	}
	
	//textfields
	private JTextField newName = new JTextField();
	private JTextField newAge = new JTextField();
	private JTextField newBirthday = new JTextField();
	private JTextField newGender= new JTextField();
	private JTextField newAddress = new JTextField();
	private JTextArea newNotes = new JTextArea();
	
	//adding textfields
	public void Text_Fields() {
		//newName
		newName.setBounds(125,356,325,16);
		newName.setFont(robotoPlain14);
		newName.setBackground(null);
		newName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		newName.setText(null);
		
		//newAge
		newAge.setBounds(125,396,325,16);
		newAge.setFont(robotoPlain14);
		newAge.setBackground(null);
		newAge.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		newAge.setText(null);
		
		//newBirthday
		newBirthday.setBounds(125,436,325,16);
		newBirthday.setFont(robotoPlain14);
		newBirthday.setBackground(null);
		newBirthday.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		newBirthday.setText(null);
		
		//newGender
		newGender.setBounds(125,476,325,16);
		newGender.setFont(robotoPlain14);
		newGender.setBackground(null);
		newGender.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		newGender.setText(null);
		
		//newAddress
		newAddress.setBounds(125,516,325,16);
		newAddress.setFont(robotoPlain14);
		newAddress.setBackground(null);
		newAddress.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		newAddress.setText(null);
		
		//newNotes
		newNotes.setBounds(125,556,325,50);
		newNotes.setFont(robotoPlain14);
		newNotes.setBackground(null);
		notes.setLineWrap(true);
	    notes.setWrapStyleWord(true);
		newNotes.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		newNotes.setText(null);
		
		//adding textfields
		getContentPane().add(newName);
		getContentPane().add(newAge);
		getContentPane().add(newBirthday);
		getContentPane().add(newGender);
		getContentPane().add(newAddress);
		getContentPane().add(newNotes);
	}
	
	//table
	
	private JTable table;
	
	private void Table() {
		
		//header
		String[] column = {"NAME", "AGE", "Birthday", "Gender", "Address","Notes", "Id"};
		
		//data
		Object[][] row = {};
		
		//table
		table = new JTable() {
			
			

			public boolean isCellEditable(int data, int columnLabel) {
				
				return false;
			}
			
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_Panel();
			}
		});
		
		//properties
		table.setModel(new DefaultTableModel(row,column));
		table.setPreferredScrollableViewportSize(new Dimension(450,100));
		table.setFillsViewportHeight(true);
		table.removeColumn(table.getColumn("Birthday"));
		table.removeColumn(table.getColumn("Gender"));
		table.removeColumn(table.getColumn("Address"));
		table.removeColumn(table.getColumn("Notes"));
		table.removeColumn(table.getColumn("Id"));
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.setFont(robotoPlain14);
		table.setRowHeight(40);
		table.setShowVerticalLines(false);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setFocusable(false);	
		
		//update
		try {
			Show_User();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//scrollpane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50,150,400,200);
		getContentPane().add(scrollPane);
	}
	
	//panel
	private JPanel panel = new JPanel();
	
	public void Panel() {
		//panel
		panel.setBounds(600,42,830,753);
		panel.setLayout(null);
		
		//adding panel to the frame
		getContentPane().add(panel);
		
		//adding to this panel
		panel.add(name);
		panel.add(age);
		panel.add(birthdayLabel);
		panel.add(genderLabel);
		panel.add(addressLabel);
		panel.add(notesLabel);
		panel.add(birthday);
		panel.add(gender);
		panel.add(address);
		panel.add(notes);
		
	}

	UserInterface() {
		this.setSize(1380,1024);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setIconImage(logo.getImage());
		this.getContentPane().setLayout(null);
		
		Labels();
		Buttons();
		Table();
		Panel();

				
		this.getContentPane().setBackground(grey);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	//display adding textfields
	public void Add() {
		
		newNameLabel.setVisible(true);
		newAgeLabel.setVisible(true);
		newBirthdayLabel.setVisible(true);
		newGenderLabel.setVisible(true);
		newAddressLabel.setVisible(true);
		newNotesLabel.setVisible(true);
		newName.setVisible(true);
		newAge.setVisible(true);
		newBirthday.setVisible(true);
		newGender.setVisible(true);
		newAddress.setVisible(true);
		newNotes.setVisible(true);
		cancelButton.setVisible(true);
		confirmButton.setVisible(true);
		
		//newNameLabel
	    newNameLabel.setBounds(50,340,150,47);
	    newNameLabel.setFont(robotoPlain14);
	    
		//newAgeLabel
	    newAgeLabel.setBounds(50,380,150,47);
	    newAgeLabel.setFont(robotoPlain14);
	    
		//newBirthdayLabel
	    newBirthdayLabel.setBounds(50,420,150,47);
	    newBirthdayLabel.setFont(robotoPlain14);
	    
		//newGenderLabel
	    newGenderLabel.setBounds(50,460,150,47);
	    newGenderLabel.setFont(robotoPlain14);
	    
		//newAddressLabel
	    newAddressLabel.setBounds(50,500,150,47);
	    newAddressLabel.setFont(robotoPlain14);
	    
		//newNotesLabel
	    newNotesLabel.setBounds(50,540,150,47);
	    newNotesLabel.setFont(robotoPlain14);
	    
		Text_Fields();
		
		//cancelButton
		cancelButton.setBounds(50,630,190,50);
		cancelButton.setFocusable(false);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hide();
			}
		});
				
		//confirmButton
		confirmButton.setBounds(260,630,190,50);
		confirmButton.setFocusable(false);
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_To_Database();
			}
		});

	}
	
	//remove adding option
	
	public void Hide() {
		newNameLabel.setVisible(false);
		newAgeLabel.setVisible(false);
		newBirthdayLabel.setVisible(false);
		newGenderLabel.setVisible(false);
		newAddressLabel.setVisible(false);
		newNotesLabel.setVisible(false);
		newName.setVisible(false);
		newAge.setVisible(false);
		newBirthday.setVisible(false);
		newGender.setVisible(false);
		newAddress.setVisible(false);
		newNotes.setVisible(false);
		cancelButton.setVisible(false);
		confirmButton.setVisible(false);
		
	}
	
	//creating an array list object
	public ArrayList<User> userList() throws SQLException{
		ArrayList<User> usersList = new ArrayList<>();
		
		int id = LoginInterface.getLoginId();
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/friendcheckone","root", "465a7dhn");
			String queryOne = "SELECT * FROM friendcheckone.friends WHERE ref_id = " + id;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(queryOne);
			
			
			User user;
			while(rs.next()) {
				
				user = new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("birthday"), rs.getString("gender"), rs.getString("address"), rs.getString("notes"));
				usersList.add(user);
				
			}
			
			statement.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return usersList;
	}
	
	//showing data to the table
	public void Show_User() throws SQLException {
		ArrayList<User> list = userList();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		Object[] row = new Object[7];
	

		try {
			for(int i=0; i<list.size(); i++) {
				row[0] = list.get(i).getName();
				row[1] = list.get(i).getAge();
				row[2] = list.get(i).getBirthday();
				row[3] = list.get(i).getGender();
				row[4] = list.get(i).getAddress();
				row[5] = list.get(i).getNotes();
				row[6] = list.get(i).getId();

				
				model.addRow(row);
				
				
			}
		} catch (Exception e) {
			
		}
	}
	
	//displaying friend information to the panel
	public void Add_Panel() {
		int i = table.getSelectedRow();
		TableModel model = table.getModel();
				
		try {
			
			name.setText(null);
			age.setText(null);
			birthday.setText(null);
			gender.setText(null);
			address.setText(null);
			notes.setText(null);
			
			name.setText(model.getValueAt(i, 0).toString());
			age.setText(model.getValueAt(i,1).toString());
			birthday.setText(model.getValueAt(i,2).toString());
			gender.setText(model.getValueAt(i,3).toString());
			address.setText(model.getValueAt(i,4).toString());
			notes.setText(model.getValueAt(i,5).toString());
					
			} catch (Exception e2) {
					
			}
	}
	
	
	//adding a friend to the table
	public void Add_To_Database() {
		
		try {
			
			int id = LoginInterface.getLoginId();
			String name = newName.getText();
			String age = newAge.getText();
			String birthday = newBirthday.getText();
			String gender = newGender.getText();
			String address = newAddress.getText();
			String notes = newNotes.getText();
		
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/friendcheckone","root", "465a7dhn");
			String queryOne = "INSERT INTO `friendcheckone`.`friends` (`ref_id`,`name`, `age`, `birthday`, `gender`,`address`,`notes`) VALUES ('" + id +"', '" + name + "', '" + age + "', '" + birthday + "','" + gender + "','" + address + "','" + notes + "' );";                 
			java.sql.Statement statement = connection.createStatement();
			
			statement.execute(queryOne);
			
			
			Show_User();
			Hide();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "Employee is added Unuccessfully! \n Try Again Later");
		}
		//INSERT INTO `hms`.`user` (`user_name`, `user_password`, `user_role`, `user_telephone`, `user_email`, `employee_name`) VALUES ('user_four', 'user4', 'Chef', 'N/A', 'N/A', 'Lady Gaga');
	}
	
	//removing a friend from the table
	public void Delete_Friend() {
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		int i = table.getSelectedRow();
		String id = model.getValueAt(i, 6).toString();
		System.out.println(id);
		
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/friendcheckone","root", "465a7dhn");
			String queryOne = "DELETE FROM friendcheckone.friends WHERE id = " + id;
			Statement statement = connection.createStatement();
			
			
			int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				statement.execute(queryOne);
				JOptionPane.showMessageDialog(null, "Deleted Successfully");
			}
			
			Show_User();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Deleted Unsuccessfully");
		}

	}
	
	//logout
	public void Log_Out() {
		int response = JOptionPane.showConfirmDialog(this, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(response == JOptionPane.YES_OPTION) {
			new LoginInterface();
			this.dispose();
		} 
	}
	 
}
