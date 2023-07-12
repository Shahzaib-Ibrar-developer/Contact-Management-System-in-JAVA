//design no 2 also check this design 
//without look and feel


// import java.awt.GridBagConstraints;
// import java.awt.GridBagLayout;
// import java.awt.Insets;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.ArrayList;
// import java.util.List;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JTable;
// import javax.swing.JTextField;
// import javax.swing.table.DefaultTableModel;

// class DesignContact extends JFrame {
//     private JTable contactTable;
//     private DefaultTableModel tableModel;

//     public DesignContact() {
//         setTitle("Contact Management System");
//         setSize(500, 500);
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setResizable(false);
//         setLocationRelativeTo(null);

//         // Initialize the contact table
//         tableModel = new DefaultTableModel();
//         tableModel.addColumn("Name");
//         tableModel.addColumn("Email");
//         tableModel.addColumn("Phone Number");
//         contactTable = new JTable(tableModel);

//         JScrollPane scrollPane = new JScrollPane(contactTable);
//         scrollPane.setPreferredSize(getSize());

//         // Create panel for buttons and labels
//         JPanel panel = new JPanel();

//         // Adding buttons on JPanel
//         JButton addButton = new JButton("ADD");
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 addNewNumber();
//             }
//         });

//         JButton deleteButton = new JButton("Delete");
//         deleteButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 deleteContact();
//             }
//         });

//         JButton updateButton = new JButton("Update");


//           updateButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 updateContact();
             
//             }
//         });

//         panel.add(addButton);
//         panel.add(deleteButton);
//         panel.add(updateButton);

//         // Add the components to the main frame
//         getContentPane().setLayout(new GridBagLayout());
//         GridBagConstraints constraints = new GridBagConstraints();
//         constraints.fill = GridBagConstraints.BOTH;
//         constraints.gridx = 0;
//         constraints.gridy = 0;
//         constraints.weightx = 1.0;
//         constraints.weighty = 1.0;
//         getContentPane().add(scrollPane, constraints);

//         constraints.gridy = 1;
//         constraints.weighty = 0.0;
//         getContentPane().add(panel, constraints);

//         setVisible(true);
//     }

//     public void addNewNumber() {
//         JFrame numberframe = new JFrame();
//         numberframe.setSize(300, 250);
//         numberframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         numberframe.setResizable(false);
//         numberframe.setTitle("Adding Number");
//         numberframe.setLocationRelativeTo(null);

//         JPanel numberpanel = new JPanel(new GridBagLayout());
//         GridBagConstraints constraints = new GridBagConstraints();
//         constraints.fill = GridBagConstraints.HORIZONTAL;
//         constraints.insets = new Insets(5, 5, 5, 5);

//         JLabel namelabel = new JLabel("Name");
//         JTextField nameTextField = new JTextField();
//         namelabel.setLabelFor(nameTextField);
//         constraints.gridx = 0;
//         constraints.gridy = 0;
//         numberpanel.add(namelabel, constraints);
//         constraints.gridx = 1;
//         constraints.gridy = 0;
//         constraints.weightx = 1.0;
//         numberpanel.add(nameTextField, constraints);

//         JLabel emaillabel = new JLabel("Email");
//         JTextField emailTextField = new JTextField();
//         emaillabel.setLabelFor(emailTextField);
//         constraints.gridx = 0;
//         constraints.gridy = 1;
//         constraints.weightx = 0.0;
//         numberpanel.add(emaillabel, constraints);
//         constraints.gridx = 1;
//         constraints.gridy = 1;
//         constraints.weightx = 1.0;
//         numberpanel.add(emailTextField, constraints);

//         JLabel phonelabel = new JLabel("Phone Number");
//         JTextField phoneTextField = new JTextField();
//         phonelabel.setLabelFor(phoneTextField);
//         constraints.gridx = 0;
//         constraints.gridy = 2;
//         constraints.weightx = 0.0;
//         numberpanel.add(phonelabel, constraints);
//         constraints.gridx = 1;
//         constraints.gridy = 2;
//         constraints.weightx = 1.0;
//         numberpanel.add(phoneTextField, constraints);

//         JButton savebutton = new JButton("Save");
//         constraints.gridx = 1;
//         constraints.gridy = 3;
//         constraints.weightx = 0.0;
//         constraints.anchor = GridBagConstraints.CENTER;
//         numberpanel.add(savebutton, constraints);

//         savebutton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 String name = nameTextField.getText();
//                 String email = emailTextField.getText();
//                 String phoneNumber = phoneTextField.getText();
//                 saveContact(name, email, phoneNumber);
//                 numberframe.dispose(); // Close the numberframe
//             }
//         });

//         numberframe.getContentPane().add(numberpanel);
//         numberframe.setVisible(true);
//     }

//     public void saveContact(String name, String email, String phoneNumber) {
//         Object[] rowData = { name, email, phoneNumber };
//         tableModel.addRow(rowData);
//     }

//     public void deleteContact() {
//         int selectedRow = contactTable.getSelectedRow();
//         if (selectedRow != -1) {
//             tableModel.removeRow(selectedRow);
//         }
//     }

//     // now writing code for update the values

//     public void updateContact() {
//         int selectedRow = contactTable.getSelectedRow();
//         if (selectedRow != -1) {

//             String name = JOptionPane.showInputDialog("Enter new name ");
//             String email = JOptionPane.showInputDialog("Enter new Email ");
//             String phone = JOptionPane.showInputDialog("Enter new Phone ");

//             tableModel.setValueAt(name, selectedRow, 0);
//             tableModel.setValueAt(email, selectedRow, 1);
//             tableModel.setValueAt(phone, selectedRow, 2);
//         }
//     }

//     public static void main(String[] args) {
//         DesignContact design = new DesignContact();
//     }
// }
