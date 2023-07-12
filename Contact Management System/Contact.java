import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
//Completed contact management system 
 class DesignContact extends JFrame {
    private JTable contactTable;
    private DefaultTableModel tableModel;

    public DesignContact() {
        setTitle("Contact Management System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize the contact table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone Number");
        contactTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(contactTable);
        scrollPane.setPreferredSize(getSize());

        // Create panel for buttons and labels
        JPanel panel = new JPanel();

        // Adding buttons on JPanel
        JButton addButton = new JButton("ADD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewNumber();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });

        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(updateButton);

        // Add the components to the main frame
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(scrollPane);
        getContentPane().add(panel);

        setVisible(true);
    }

    public void addNewNumber() {
        JFrame numberframe = new JFrame();
        numberframe.setSize(300, 250);
        numberframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        numberframe.setResizable(false);
        numberframe.setTitle("Adding Number");
        numberframe.setLocationRelativeTo(null);

        JPanel numberpanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel namelabel = new JLabel("Name");
        JTextField nameTextField = new JTextField();
        namelabel.setLabelFor(nameTextField);
        constraints.gridx = 0;
        constraints.gridy = 0;
        numberpanel.add(namelabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        numberpanel.add(nameTextField, constraints);

        JLabel emaillabel = new JLabel("Email");
        JTextField emailTextField = new JTextField();
        emaillabel.setLabelFor(emailTextField);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.0;
        numberpanel.add(emaillabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        numberpanel.add(emailTextField, constraints);

        JLabel phonelabel = new JLabel("Phone Number");
        JTextField phoneTextField = new JTextField();
        phonelabel.setLabelFor(phoneTextField);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 0.0;
        numberpanel.add(phonelabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 1.0;
        numberpanel.add(phoneTextField, constraints);

        JButton savebutton = new JButton("Save");
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx = 0.0;
        constraints.anchor = GridBagConstraints.CENTER;
        numberpanel.add(savebutton, constraints);

        savebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String phoneNumber = phoneTextField.getText();

                if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(numberframe, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    saveContact(name, email, phoneNumber);
                    numberframe.dispose(); // Close the numberframe
                }
            }
        });

        numberframe.getContentPane().add(numberpanel);
        numberframe.setVisible(true);
    }

    public void saveContact(String name, String email, String phoneNumber) {
        Object[] rowData = { name, email, phoneNumber };
        tableModel.addRow(rowData);
    }

    public void deleteContact() {
        int[] selectedRows = contactTable.getSelectedRows();
        if (selectedRows.length > 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete selected contacts?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    tableModel.removeRow(selectedRows[i]);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select at least one contact to delete.", "No Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void updateContact() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow != -1) {
            String name = JOptionPane.showInputDialog(this, "Enter new name", tableModel.getValueAt(selectedRow, 0));
            String email = JOptionPane.showInputDialog(this, "Enter new Email", tableModel.getValueAt(selectedRow, 1));
            String phone = JOptionPane.showInputDialog(this, "Enter new Phone", tableModel.getValueAt(selectedRow, 2));

            if (name != null && email != null && phone != null) {
                tableModel.setValueAt(name, selectedRow, 0);
                tableModel.setValueAt(email, selectedRow, 1);
                tableModel.setValueAt(phone, selectedRow, 2);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pleaseselect a contact to update.", "No Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            // Set the system default look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DesignContact();
            }
        });
    }
}
