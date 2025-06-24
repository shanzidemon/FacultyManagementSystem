import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FacultyRegGUI extends JFrame implements ActionListener{
	JTextField txtName;
	JTextField txtId;
	JTextField txtDept;
	JTextField txtSalary;
	JTextField txtAddress;
	JButton btnRegister;
	JButton btnShowAll;
	JTextArea txtShowAll;
	
	public FacultyRegGUI(){
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel lbReg = new JLabel("Registration");
		lbReg.setBounds(20,0,80,20);
		add(lbReg);
		
		JLabel lbName = new JLabel("Name");
		lbName.setBounds(20,20,50,20);
		add(lbName);
		
		txtName = new JTextField();
		txtName.setBounds(80,20,100,20);
		add(txtName);
		
		JLabel lbId = new JLabel("Id");
		lbId.setBounds(20,40,50,20);
		add(lbId);
		
		txtId = new JTextField();
		txtId.setBounds(80,40,100,20);
		add(txtId);
		
		JLabel lbDept = new JLabel("Dept");
		lbDept.setBounds(20,60,50,20);
		add(lbDept);
		
		txtDept = new JTextField();
		txtDept.setBounds(80,60,100,20);
		add(txtDept);
		
		JLabel lbSalary = new JLabel("Salary");
		lbSalary.setBounds(20,80,50,20);
		add(lbSalary);
		
		txtSalary = new JTextField();
		txtSalary.setBounds(80,80,100,20);
		add(txtSalary);
		
		JLabel lbAdd = new JLabel("Address");
		lbAdd.setBounds(20,100,50,20);
		add(lbAdd);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(80,100,100,20);
		add(txtAddress);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(80,120,100,20);
		add(btnRegister);
		btnRegister.addActionListener(this);
		
		btnShowAll = new JButton("ShowAll");
		btnShowAll.setBounds(80,140,100,20);
		add(btnShowAll);
		btnShowAll.addActionListener(this);
		
		txtShowAll = new JTextArea();
		txtShowAll.setBounds(200,20,200,400);
		txtShowAll.setText("OutPut");
		
		
		JScrollPane scroll = new JScrollPane(txtShowAll);
		scroll.setBounds(200,20,200,400);
		add(scroll);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == btnRegister){
			registerClicked();		
		}
		else if(event.getSource() == btnShowAll){
			showAllClicked();
		}
	}
	private void refreshFields(){
		txtName.setText("");
		txtId.setText("");
		txtDept.setText("");
		txtSalary.setText("");
		txtAddress.setText("");
	}
	private void showAllClicked(){
		FacultyManager sm = new FacultyManager();
		Faculty[] facultys = sm.getAllFaculty();
		String output="";
		for(int i=0;i<facultys.length;i++){
			output += facultys[i].showInfoGUI();
		}
		txtShowAll.setText(output);
	}
	
	private void registerClicked(){
		String name = txtName.getText();
		String id = txtId.getText();
		String salary = txtSalary.getText();
		String dept = txtDept.getText();
		String address = txtAddress.getText();		
		Faculty s = new Faculty(id,name,dept,salary,address);
		FacultyManager sm = new FacultyManager();
		sm.writeFaculty(s);
		JOptionPane.showMessageDialog(null,"Faculty Created");
		refreshFields();
		showAllClicked();
	}
}

