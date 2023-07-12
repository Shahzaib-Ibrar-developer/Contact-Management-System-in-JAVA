
        panel.add(updateButton);
        getContentPane().add(panel);
        
        // Create panel for contact information
        JPanel infoPanel = new JPanel();
        nameLabel = new JLabel("");
        emailLabel = new JLabel("");
        phoneLabel = new JLabel("");
        infoPanel.add(nameLabel);
        infoPanel.add(emailLabel);
        infoPanel.add(phoneLabel);
        getContentPane().add(infoPanel);
    }

    public void addNewNumber() {