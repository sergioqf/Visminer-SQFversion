package GUI;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class DbDialog extends JDialog {
	private String user;
	private String password;
	private String db;
	private String url;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField;
	
	public String getDb() {
		return db;
	}


	public void setDb(String db) {
		this.db = db;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public DbDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setSize(new Dimension(438, 291));
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("VISMINER");
		getContentPane().setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MySQL", "Oracle", "IBM DB2"}));
		comboBox.setBounds(131, 28, 183, 27);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 setDb((comboBox.getSelectedItem().toString()));
				 setUser(textField1.getText());
				 setPassword(textField2.getText());
				 setUrl(textField.getText());
				 setVisible(false);
			}
		});
		btnNewButton.setBounds(299, 214, 117, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lblSgbd = new JLabel("SGBD:");
		lblSgbd.setBounds(58, 32, 61, 16);
		getContentPane().add(lblSgbd);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(58, 139, 61, 16);
		getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(58, 167, 84, 16);
		getContentPane().add(lblPassword);
		
		textField1 = new JTextField();
		textField1.setBounds(131, 127, 134, 28);
		getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(131, 161, 134, 28);
		getContentPane().add(textField2);
		textField2.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(58, 72, 61, 16);
		getContentPane().add(lblUrl);
		
		textField = new JTextField();
		textField.setBounds(131, 60, 183, 28);
		getContentPane().add(textField);
		textField.setColumns(10);
	}


	
	
}
