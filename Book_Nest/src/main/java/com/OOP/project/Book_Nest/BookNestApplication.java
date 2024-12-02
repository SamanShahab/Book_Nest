//BookNestApplication.java
//last  code...
package com.OOP.project.Book_Nest;

import com.OOP.project.Book_Nest.category.CategoriesPage;
import com.OOP.project.Book_Nest.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class BookNestApplication {

    private static JFrame mainFrame; // Reference for reuse

    public static void main(String[] args) {
        startApplication();
    }

    public static void startApplication() {
        // Initialize the user service
        UserService userService = new UserService();

        // Initialize the frame
        if (mainFrame == null) {
            mainFrame = new JFrame("Book Nest");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(500, 400);
            mainFrame.setLocationRelativeTo(null);
        }

        // Main panel with custom background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    File imageFile = new File("C:\\Users\\hp hp\\Downloads\\Book_Nest\\images\\images.jfif");
                    if (imageFile.exists()) {
                        Image background = ImageIO.read(imageFile);
                        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);
        mainFrame.add(panel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel welcomeLabel = new JLabel("Welcome to Book Nest", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(0, 0, 0, 150));


        JLabel nameLabel = createLabel("Enter your name:");
        JLabel userIdLabel = createLabel("Enter your user ID:");

        JLabel outputLabel = new JLabel("", SwingConstants.CENTER);
        outputLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        outputLabel.setForeground(Color.YELLOW);

        JTextField nameField = new JTextField(20);
        JTextField userIdField = new JTextField(20);
        styleTextField(nameField);
        styleTextField(userIdField);

        JButton registerButton = createButton("Register", new Color(51, 153, 255), Color.WHITE);
        JButton loginButton = createButton("Login", new Color(51, 204, 51), Color.WHITE);

        registerButton.setEnabled(false);
        loginButton.setEnabled(false);

        // Welcome label
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.gridy = 0;
        panel.add(welcomeLabel, constraints);

        // Name label and field
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        panel.add(nameLabel, constraints);
        constraints.gridx = 1;
        panel.add(nameField, constraints);

        // User ID label and field
        constraints.gridy = 2;
        constraints.gridx = 0;
        panel.add(userIdLabel, constraints);
        constraints.gridx = 1;
        panel.add(userIdField, constraints);

        // Buttons (aligned horizontally)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);

        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        panel.add(buttonPanel, constraints);

        // Output label
        constraints.gridy = 4;
        panel.add(outputLabel, constraints);

        // Enable buttons when text fields are not empty
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enableButtons(nameField, userIdField, registerButton, loginButton);
            }
        });

        userIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enableButtons(nameField, userIdField, registerButton, loginButton);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String userId = userIdField.getText().trim();

                if (name.isEmpty() || userId.isEmpty()) {
                    outputLabel.setText("Please enter your name and user ID.");
                    outputLabel.setForeground(Color.RED);
                    outputLabel.setOpaque(true);
                    outputLabel.setBackground(new Color(255, 228, 225)); // Light pink background
                    return;
                }

                String result = userService.registerUser(name, userId);

                if (result.equals("You have already registered. Please login.")) {
                    outputLabel.setText(result);
                    outputLabel.setForeground(Color.WHITE);
                    outputLabel.setOpaque(true);
                    outputLabel.setBackground(new Color(139, 69, 19, 150)); // Orange-red background 101, 67, 33, 150
                } else {
                    outputLabel.setText(result); // Successful registration
                    outputLabel.setForeground(Color.WHITE);
                    outputLabel.setOpaque(true);
                    outputLabel.setBackground(new Color(139, 69, 19, 150)); // Light green background
                }

                nameField.setText("");
                userIdField.setText("");
            }
        });


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText();
                String result = userService.loginUser(userId);

                if (result.startsWith("Welcome back")) {
                    outputLabel.setText(""); // Clear any previous output
                    mainFrame.setVisible(false); // Hide current frame
                    new CategoriesPage(); // Show categories
                } else {
                    outputLabel.setText(result);
                    outputLabel.setForeground(Color.WHITE);
                }

                nameField.setText("");
                userIdField.setText("");
            }
        });


        mainFrame.setVisible(true);
    }

    private static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setBackground(new Color(0, 0, 0, 150)); // Light silver background
        return label;
    }

    private static void enableButtons(JTextField nameField, JTextField userIdField, JButton registerButton, JButton loginButton) {
        String name = nameField.getText();
        String userId = userIdField.getText();
        if (!name.isEmpty() && !userId.isEmpty()) {
            registerButton.setEnabled(true);
            loginButton.setEnabled(true);
        } else {
            registerButton.setEnabled(false);
            loginButton.setEnabled(false);
        }
    }

    private static void styleTextField(JTextField textField) {
        textField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setForeground(new Color(51, 51, 51));
        textField.setPreferredSize(new Dimension(200, 30));
    }


    private static JButton createButton(String text, Color backgroundColor, Color textColor) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor); // Button background color
        button.setForeground(textColor);      // Text color
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Font settings
        button.setFocusPainted(false);        // Remove focus border
        button.setPreferredSize(new Dimension(120, 30)); // Button size

        // Ensure text color remains the same even when disabled
        button.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
                AbstractButton b = (AbstractButton) c;
                g.setColor(Color.WHITE); // Force white color for the text
                FontMetrics fm = g.getFontMetrics();
                g.drawString(text, textRect.x, textRect.y + fm.getAscent());
            }
        });

        // Add hover effect for the button
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (button.isEnabled()) {
                    button.setBackground(backgroundColor.darker());
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor);
            }
        });

        return button;
    }

    // Getter for mainFrame
    public static JFrame getMainFrame() {
        return mainFrame;
    }
}
