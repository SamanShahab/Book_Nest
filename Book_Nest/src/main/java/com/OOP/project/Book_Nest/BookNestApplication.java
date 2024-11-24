//package com.OOP.project.Book_Nest;
//
//import com.OOP.project.Book_Nest.service.UserService;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//import java.io.File;
//
//public class BookNestApplication {
//
//	public static void main(String[] args) {
//		// Initialize the user service
//		UserService userService = new UserService();
//
//		// Create the main frame with a modern look
//		JFrame frame = new JFrame("Book Nest");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500, 350); // Set a good initial size for the frame
//		frame.setLocationRelativeTo(null); // Center the frame on the screen
//
//		// Set the window's icon (optional, add your own image path if you want)
//		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("yourIconPathHere.png"));
//
//		// Create a panel with a responsive layout
//		JPanel panel = new JPanel() {
//			@Override
//			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				try {
//					// Add a light background image (adjust the path as needed)
//					File imageFile = new File("C:\\Users\\hp hp\\Downloads\\Book_Nest\\images\\images.jfif"); // Adjust this path
//					if (imageFile.exists()) {
//						Image background = ImageIO.read(imageFile);
//						g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
//					} else {
//						System.out.println("File not found: " + imageFile.getAbsolutePath());
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		};
//		panel.setLayout(new GridBagLayout());
//		panel.setOpaque(false); // Allow transparency so the background image shows
//		frame.add(panel);
//
//		// Use GridBagConstraints for flexible positioning and resizing
//		GridBagConstraints constraints = new GridBagConstraints();
//		constraints.insets = new Insets(10, 10, 10, 10); // Add padding around components
//		constraints.gridx = 0; // Set starting position of components in grid
//
//		// Create labels
//		JLabel welcomeLabel = new JLabel("Welcome to Book Nest", SwingConstants.CENTER);
//		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
//		welcomeLabel.setForeground(new Color(51, 102, 153)); // Cool color for header
//
//		JLabel nameLabel = new JLabel("Enter your name:");
//		JLabel userIdLabel = new JLabel("Enter your user ID:");
//		JLabel outputLabel = new JLabel("", SwingConstants.CENTER);
//		outputLabel.setFont(new Font("Arial", Font.ITALIC, 14));
//
//		// Create text fields with rounded corners
//		JTextField nameField = new JTextField(20);
//		JTextField userIdField = new JTextField(20);
//		styleTextField(nameField);
//		styleTextField(userIdField);
//
//		// Create buttons with colors and hover effect
//		JButton registerButton = createButton("Register", new Color(51, 153, 255));
//		JButton loginButton = createButton("Login", new Color(51, 204, 51));
//
//		// Initially disable buttons until both fields are filled
//		registerButton.setEnabled(false);
//		loginButton.setEnabled(false);
//
//		// Add components to the panel using GridBagConstraints
//		constraints.gridx = 0;
//		constraints.gridwidth = 2;
//		panel.add(welcomeLabel, constraints);
//
//		constraints.gridy = 1; // Move down
//		constraints.gridwidth = 1;
//		panel.add(nameLabel, constraints);
//		constraints.gridx = 1;
//		panel.add(nameField, constraints);
//
//		constraints.gridx = 0; // Move to the left column for userIdLabel
//		constraints.gridy = 2; // Move down to the second row
//		panel.add(userIdLabel, constraints);
//		constraints.gridx = 1;
//		panel.add(userIdField, constraints);
//
//		constraints.gridx = 0; // Move to a new row
//		constraints.gridy = 3;
//		panel.add(registerButton, constraints);
//
//		constraints.gridx = 1;
//		panel.add(loginButton, constraints);
//
//		// Add an output label for feedback
//		constraints.gridx = 0;
//		constraints.gridwidth = 2;
//		constraints.gridy = 4;
//		panel.add(outputLabel, constraints);
//
//		// Check if input fields are filled and enable buttons
//		nameField.addKeyListener(new java.awt.event.KeyAdapter() {
//			public void keyReleased(java.awt.event.KeyEvent evt) {
//				enableButtons(nameField, userIdField, registerButton, loginButton);
//			}
//		});
//
//		userIdField.addKeyListener(new java.awt.event.KeyAdapter() {
//			public void keyReleased(java.awt.event.KeyEvent evt) {
//				enableButtons(nameField, userIdField, registerButton, loginButton);
//			}
//		});
//
//		// Handle the registration button click
//		registerButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String name = nameField.getText();
//				String userId = userIdField.getText();
//				String result = userService.registerUser(name, userId);
//				outputLabel.setText(result);
//				outputLabel.setForeground(new Color(0, 128, 0)); // Success feedback color
//
//				// Clear input fields after registration
//				nameField.setText("");
//				userIdField.setText("");
//			}
//		});
//
//		// Handle the login button click
//		loginButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String userId = userIdField.getText();
//				String result = userService.loginUser(userId);
//				outputLabel.setText(result);
//				outputLabel.setForeground(new Color(255, 0, 0)); // Error feedback color
//
//				// Clear input fields after login
//				nameField.setText("");
//				userIdField.setText("");
//			}
//		});
//
//		// Make the frame visible
//		frame.setVisible(true);
//	}
//
//	// Enable or disable the Register/Login buttons based on user input
//	private static void enableButtons(JTextField nameField, JTextField userIdField, JButton registerButton, JButton loginButton) {
//		String name = nameField.getText();
//		String userId = userIdField.getText();
//
//		// Enable buttons only if both fields are filled
//		if (!name.isEmpty() && !userId.isEmpty()) {
//			registerButton.setEnabled(true);
//			loginButton.setEnabled(true);
//		} else {
//			registerButton.setEnabled(false);
//			loginButton.setEnabled(false);
//		}
//	}
//
//	// Style the text fields with rounded corners and soft border
//	private static void styleTextField(JTextField textField) {
//		textField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
//		textField.setFont(new Font("Arial", Font.PLAIN, 14));
//		textField.setForeground(new Color(51, 51, 51));
//		textField.setPreferredSize(new Dimension(200, 30)); // Adjust size for a better appearance
//	}
//
//	// Create a stylish button with hover effect
//	private static JButton createButton(String text, Color backgroundColor) {
//		JButton button = new JButton(text);
//		button.setBackground(backgroundColor);
//		button.setForeground(Color.WHITE);
//		button.setFont(new Font("Arial", Font.BOLD, 14));
//		button.setFocusPainted(false);
//		button.setPreferredSize(new Dimension(150, 40)); // Adjust button size
//
//		// Add a hover effect
//		button.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseEntered(java.awt.event.MouseEvent evt) {
//				button.setBackground(button.getBackground().darker());
//			}
//
//			public void mouseExited(java.awt.event.MouseEvent evt) {
//				button.setBackground(backgroundColor);
//			}
//		});
//
//		return button;
//	}
//}

//2 wala code..
//package com.OOP.project.Book_Nest;
//
//import com.OOP.project.Book_Nest.service.UserService;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//import java.io.File;
//
//public class BookNestApplication {
//
//	public static void main(String[] args) {
//		// Initialize the user service
//		UserService userService = new UserService();
//
//		// Create the main frame with a modern look
//		JFrame frame = new JFrame("Book Nest");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500, 350); // Set a good initial size for the frame
//		frame.setLocationRelativeTo(null); // Center the frame on the screen
//
//		// Set the window's icon (optional, add your own image path if you want)
//		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("yourIconPathHere.png"));
//
//		// Create a panel with a responsive layout
//		JPanel panel = new JPanel() {
//			@Override
//			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				try {
//					// Add a light background image (adjust the path as needed)
//					File imageFile = new File("C:\\Users\\hp hp\\Downloads\\Book_Nest\\images\\images.jfif"); // Adjust this path
//					if (imageFile.exists()) {
//						Image background = ImageIO.read(imageFile);
//						g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
//					} else {
//						System.out.println("File not found: " + imageFile.getAbsolutePath());
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		};
//		panel.setLayout(new GridBagLayout());
//		panel.setOpaque(false); // Allow transparency so the background image shows
//		frame.add(panel);
//
//		// Use GridBagConstraints for flexible positioning and resizing
//		GridBagConstraints constraints = new GridBagConstraints();
//		constraints.insets = new Insets(10, 10, 10, 10); // Add padding around components
//		constraints.gridx = 0; // Set starting position of components in grid
//
//		// Create labels
//		JLabel welcomeLabel = new JLabel("Welcome to Book Nest", SwingConstants.CENTER);
//		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
//		welcomeLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
//		welcomeLabel.setOpaque(true);
//		welcomeLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent black background
//
//		JLabel nameLabel = new JLabel("Enter your name:");
//		nameLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
//		nameLabel.setOpaque(true);
//		nameLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent background
//
//		JLabel userIdLabel = new JLabel("Enter your user ID:");
//		userIdLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
//		userIdLabel.setOpaque(true);
//		userIdLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent background
//
//		JLabel outputLabel = new JLabel("", SwingConstants.CENTER);
//		outputLabel.setFont(new Font("Arial", Font.ITALIC, 14));
//		outputLabel.setForeground(Color.YELLOW); // Make output label bright (for feedback)
//		outputLabel.setOpaque(true);
//		outputLabel.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent background for output label
//
//		// Create text fields with rounded corners
//		JTextField nameField = new JTextField(20);
//		JTextField userIdField = new JTextField(20);
//		styleTextField(nameField);
//		styleTextField(userIdField);
//
//		// Create buttons with colors and hover effect
//		JButton registerButton = createButton("Register", new Color(51, 153, 255));
//		JButton loginButton = createButton("Login", new Color(51, 204, 51));
//
//		// Initially disable buttons until both fields are filled
//		registerButton.setEnabled(false);
//		loginButton.setEnabled(false);
//
//		// Add components to the panel using GridBagConstraints
//		constraints.gridx = 0;
//		constraints.gridwidth = 2;
//		panel.add(welcomeLabel, constraints);
//
//		constraints.gridy = 1; // Move down
//		constraints.gridwidth = 1;
//		panel.add(nameLabel, constraints);
//		constraints.gridx = 1;
//		panel.add(nameField, constraints);
//
//		constraints.gridx = 0; // Move to the left column for userIdLabel
//		constraints.gridy = 2; // Move down to the second row
//		panel.add(userIdLabel, constraints);
//		constraints.gridx = 1;
//		panel.add(userIdField, constraints);
//
//		constraints.gridx = 0; // Move to a new row
//		constraints.gridy = 3;
//		panel.add(registerButton, constraints);
//
//		constraints.gridx = 1;
//		panel.add(loginButton, constraints);
//
//		// Add an output label for feedback
//		constraints.gridx = 0;
//		constraints.gridwidth = 2;
//		constraints.gridy = 4;
//		panel.add(outputLabel, constraints);
//
//		// Check if input fields are filled and enable buttons
//		nameField.addKeyListener(new java.awt.event.KeyAdapter() {
//			public void keyReleased(java.awt.event.KeyEvent evt) {
//				enableButtons(nameField, userIdField, registerButton, loginButton);
//			}
//		});
//
//		userIdField.addKeyListener(new java.awt.event.KeyAdapter() {
//			public void keyReleased(java.awt.event.KeyEvent evt) {
//				enableButtons(nameField, userIdField, registerButton, loginButton);
//			}
//		});
//
//		// Handle the registration button click
//		registerButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String name = nameField.getText();
//				String userId = userIdField.getText();
//				String result = userService.registerUser(name, userId);
//				outputLabel.setText(result);
//				outputLabel.setForeground(new Color(0, 128, 0)); // Success feedback color
//
//				// Clear input fields after registration
//				nameField.setText("");
//				userIdField.setText("");
//			}
//		});
//
//		// Handle the login button click
//		loginButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String userId = userIdField.getText();
//				String result = userService.loginUser(userId);
//				outputLabel.setText(result);
//				outputLabel.setForeground(new Color(255, 0, 0)); // Error feedback color
//
//				// Clear input fields after login
//				nameField.setText("");
//				userIdField.setText("");
//			}
//		});
//
//		// Make the frame visible
//		frame.setVisible(true);
//	}
//
//	// Enable or disable the Register/Login buttons based on user input
//	private static void enableButtons(JTextField nameField, JTextField userIdField, JButton registerButton, JButton loginButton) {
//		String name = nameField.getText();
//		String userId = userIdField.getText();
//
//		// Enable buttons only if both fields are filled
//		if (!name.isEmpty() && !userId.isEmpty()) {
//			registerButton.setEnabled(true);
//			loginButton.setEnabled(true);
//		} else {
//			registerButton.setEnabled(false);
//			loginButton.setEnabled(false);
//		}
//	}
//
//	// Style the text fields with rounded corners and soft border
//	private static void styleTextField(JTextField textField) {
//		textField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
//		textField.setFont(new Font("Arial", Font.PLAIN, 14));
//		textField.setForeground(new Color(51, 51, 51));
//		textField.setPreferredSize(new Dimension(200, 30)); // Adjust size for a better appearance
//	}
//
//	// Create a stylish button with hover effect
//	private static JButton createButton(String text, Color backgroundColor) {
//		JButton button = new JButton(text);
//		button.setBackground(backgroundColor);
//		button.setForeground(Color.WHITE);
//		button.setFont(new Font("Arial", Font.BOLD, 14));
//		button.setFocusPainted(false);
//		button.setPreferredSize(new Dimension(150, 40)); // Adjust button size
//
//		// Add a hover effect
//		button.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseEntered(java.awt.event.MouseEvent evt) {
//				button.setBackground(button.getBackground().darker());
//			}
//
//			public void mouseExited(java.awt.event.MouseEvent evt) {
//				button.setBackground(backgroundColor);
//			}
//		});
//
//		return button;
//	}
//}



//3 wala code
//package com.OOP.project.Book_Nest;
//
//import com.OOP.project.Book_Nest.service.UserService;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//import java.io.File;
//
//public class BookNestApplication {
//
//	public static void main(String[] args) {
//		// Initialize the user service
//		UserService userService = new UserService();
//
//		// Create the main frame with a modern look
//		JFrame frame = new JFrame("Book Nest");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500, 350); // Set a good initial size for the frame
//		frame.setLocationRelativeTo(null); // Center the frame on the screen
//
//		// Set the window's icon (optional, add your own image path if you want)
//		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("yourIconPathHere.png"));
//
//		// Create a panel with a responsive layout
//		JPanel panel = new JPanel() {
//			@Override
//			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				try {
//					// Add a light background image (adjust the path as needed)
//					File imageFile = new File("C:\\Users\\hp hp\\Downloads\\Book_Nest\\images\\images.jfif"); // Adjust this path
//					if (imageFile.exists()) {
//						Image background = ImageIO.read(imageFile);
//						g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
//					} else {
//						System.out.println("File not found: " + imageFile.getAbsolutePath());
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		};
//		panel.setLayout(new GridBagLayout());
//		panel.setOpaque(false); // Allow transparency so the background image shows
//		frame.add(panel);
//
//		// Use GridBagConstraints for flexible positioning and resizing
//		GridBagConstraints constraints = new GridBagConstraints();
//		constraints.insets = new Insets(10, 10, 10, 10); // Add padding around components
//		constraints.gridx = 0; // Set starting position of components in grid
//
//		// Create labels
//		JLabel welcomeLabel = new JLabel("Welcome to Book Nest", SwingConstants.CENTER);
//		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
//		welcomeLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
//		welcomeLabel.setOpaque(true);
//		welcomeLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent black background
//
//		JLabel nameLabel = new JLabel("Enter your name:");
//		nameLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
//		nameLabel.setOpaque(true);
//		nameLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent background
//
//		JLabel userIdLabel = new JLabel("Enter your user ID:");
//		userIdLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
//		userIdLabel.setOpaque(true);
//		userIdLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent background
//
//		JLabel outputLabel = new JLabel("", SwingConstants.CENTER);
//		outputLabel.setFont(new Font("Arial", Font.ITALIC, 14));
//		outputLabel.setForeground(Color.YELLOW); // Make output label bright (for feedback)
//		outputLabel.setOpaque(true);
//		outputLabel.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent background for output label
//
//		// Create text fields with rounded corners
//		JTextField nameField = new JTextField(20);
//		JTextField userIdField = new JTextField(20);
//		styleTextField(nameField);
//		styleTextField(userIdField);
//
//		// Create buttons with colors and hover effect
//		JButton registerButton = createButton("Register", new Color(51, 153, 255));
//		JButton loginButton = createButton("Login", new Color(51, 204, 51));
//
//		// Initially disable buttons until both fields are filled
//		registerButton.setEnabled(false);
//		loginButton.setEnabled(false);
//
//		// Add components to the panel using GridBagConstraints
//		constraints.gridx = 0;
//		constraints.gridwidth = 2;
//		panel.add(welcomeLabel, constraints);
//
//		constraints.gridy = 1; // Move down
//		constraints.gridwidth = 1;
//		panel.add(nameLabel, constraints);
//		constraints.gridx = 1;
//		panel.add(nameField, constraints);
//
//		constraints.gridx = 0; // Move to the left column for userIdLabel
//		constraints.gridy = 2; // Move down to the second row
//		panel.add(userIdLabel, constraints);
//		constraints.gridx = 1;
//		panel.add(userIdField, constraints);
//
//		constraints.gridx = 0; // Move to a new row
//		constraints.gridy = 3;
//		panel.add(registerButton, constraints);
//
//		constraints.gridx = 1;
//		panel.add(loginButton, constraints);
//
//		// Add an output label for feedback
//		constraints.gridx = 0;
//		constraints.gridwidth = 2;
//		constraints.gridy = 4;
//		panel.add(outputLabel, constraints);
//
//		// Check if input fields are filled and enable buttons
//		nameField.addKeyListener(new java.awt.event.KeyAdapter() {
//			public void keyReleased(java.awt.event.KeyEvent evt) {
//				enableButtons(nameField, userIdField, registerButton, loginButton);
//			}
//		});
//
//		userIdField.addKeyListener(new java.awt.event.KeyAdapter() {
//			public void keyReleased(java.awt.event.KeyEvent evt) {
//				enableButtons(nameField, userIdField, registerButton, loginButton);
//			}
//		});
//
//		// Handle the registration button click
//		registerButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String name = nameField.getText();
//				String userId = userIdField.getText();
//				String result = userService.registerUser(name, userId);
//				outputLabel.setText(result);
//				outputLabel.setForeground(new Color(0, 128, 0)); // Success feedback color
//
//				// Clear input fields after registration
//				nameField.setText("");
//				userIdField.setText("");
//			}
//		});
//
//		// Handle the login button click
//		loginButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String userId = userIdField.getText();
//				String result = userService.loginUser(userId);
//				outputLabel.setText(result);
//				outputLabel.setForeground(new Color(255, 0, 0)); // Error feedback color
//
//				// Clear input fields after login
//				nameField.setText("");
//				userIdField.setText("");
//			}
//		});
//
//		// Make the frame visible
//		frame.setVisible(true);
//	}
//
//	// Enable or disable the Register/Login buttons based on user input
//	private static void enableButtons(JTextField nameField, JTextField userIdField, JButton registerButton, JButton loginButton) {
//		String name = nameField.getText();
//		String userId = userIdField.getText();
//
//		// Enable buttons only if both fields are filled
//		if (!name.isEmpty() && !userId.isEmpty()) {
//			registerButton.setEnabled(true);
//			loginButton.setEnabled(true);
//		} else {
//			registerButton.setEnabled(false);
//			loginButton.setEnabled(false);
//		}
//	}
//
//	// Style the text fields with rounded corners and soft border
//	private static void styleTextField(JTextField textField) {
//		textField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
//		textField.setFont(new Font("Arial", Font.PLAIN, 14));
//		textField.setForeground(new Color(51, 51, 51));
//		textField.setPreferredSize(new Dimension(200, 30)); // Adjust size for a better appearance
//	}
//
//	// Create a stylish button with hover effect
//	private static JButton createButton(String text, Color backgroundColor) {
//		JButton button = new JButton(text);
//		button.setBackground(backgroundColor);
//		button.setForeground(Color.WHITE); // Set text color to white
//		button.setFont(new Font("Arial", Font.BOLD, 14));
//		button.setFocusPainted(false);
//		button.setPreferredSize(new Dimension(150, 40)); // Adjust button size
//
//		// Add a hover effect
//		button.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseEntered(java.awt.event.MouseEvent evt) {
//				button.setBackground(button.getBackground().darker());
//			}
//
//			public void mouseExited(java.awt.event.MouseEvent evt) {
//				button.setBackground(backgroundColor);
//			}
//		});
//
//		return button;
//	}
//}




//4 wala code
//package com.OOP.project.Book_Nest;
//
//import com.OOP.project.Book_Nest.service.UserService;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//import java.io.File;
//
//public class BookNestApplication {
//
//	public static void main(String[] args) {
//		// Initialize the user service
//		UserService userService = new UserService();
//
//		// Create the main frame with a modern look
//		JFrame frame = new JFrame("Book Nest");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500, 350); // Set a good initial size for the frame
//		frame.setLocationRelativeTo(null); // Center the frame on the screen
//
//		// Set the window's icon (optional, add your own image path if you want)
//		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("yourIconPathHere.png"));
//
//		// Create a panel with a responsive layout
//		JPanel panel = new JPanel() {
//			@Override
//			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				try {
//					// Add a light background image (adjust the path as needed)
//					File imageFile = new File("C:\\Users\\hp hp\\Downloads\\Book_Nest\\images\\images.jfif"); // Adjust this path
//					if (imageFile.exists()) {
//						Image background = ImageIO.read(imageFile);
//						g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
//					} else {
//						System.out.println("File not found: " + imageFile.getAbsolutePath());
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		};
//		panel.setLayout(new GridBagLayout());
//		panel.setOpaque(false); // Allow transparency so the background image shows
//		frame.add(panel);
//
//		// Use GridBagConstraints for flexible positioning and resizing
//		GridBagConstraints constraints = new GridBagConstraints();
//		constraints.insets = new Insets(10, 10, 10, 10); // Add padding around components
//		constraints.gridx = 0; // Set starting position of components in grid
//
//		// Create labels
//		JLabel welcomeLabel = new JLabel("Welcome to Book Nest", SwingConstants.CENTER);
//		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
//		welcomeLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
//		welcomeLabel.setOpaque(true);
//		welcomeLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent black background
//
//		JLabel nameLabel = new JLabel("Enter your name:");
//		nameLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
//		nameLabel.setOpaque(true);
//		nameLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent background
//
//		JLabel userIdLabel = new JLabel("Enter your user ID:");
//		userIdLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
//		userIdLabel.setOpaque(true);
//		userIdLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent background
//
//		JLabel outputLabel = new JLabel("", SwingConstants.CENTER);
//		outputLabel.setFont(new Font("Arial", Font.ITALIC, 14));
//		outputLabel.setForeground(Color.YELLOW); // Make output label bright (for feedback)
//		outputLabel.setOpaque(true);
//		outputLabel.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent background for output label
//
//		// Create text fields with rounded corners
//		JTextField nameField = new JTextField(20);
//		JTextField userIdField = new JTextField(20);
//		styleTextField(nameField);
//		styleTextField(userIdField);
//
//		// Create buttons with colors and hover effect
//		JButton registerButton = createButton("Register", new Color(51, 153, 255));
//		JButton loginButton = createButton("Login", new Color(51, 204, 51));
//
//		// Set button text color to match "Welcome to Book Nest" label
//		Color buttonTextColor = Color.WHITE;
//		registerButton.setForeground(buttonTextColor);
//		loginButton.setForeground(buttonTextColor);
//
//		// Initially disable buttons until both fields are filled
//		registerButton.setEnabled(false);
//		loginButton.setEnabled(false);
//
//		// Add components to the panel using GridBagConstraints
//		constraints.gridx = 0;
//		constraints.gridwidth = 2;
//		panel.add(welcomeLabel, constraints);
//
//		constraints.gridy = 1; // Move down
//		constraints.gridwidth = 1;
//		panel.add(nameLabel, constraints);
//		constraints.gridx = 1;
//		panel.add(nameField, constraints);
//
//		constraints.gridx = 0; // Move to the left column for userIdLabel
//		constraints.gridy = 2; // Move down to the second row
//		panel.add(userIdLabel, constraints);
//		constraints.gridx = 1;
//		panel.add(userIdField, constraints);
//
//		constraints.gridx = 0; // Move to a new row
//		constraints.gridy = 3;
//		panel.add(registerButton, constraints);
//
//		constraints.gridx = 1;
//		panel.add(loginButton, constraints);
//
//		// Add an output label for feedback
//		constraints.gridx = 0;
//		constraints.gridwidth = 2;
//		constraints.gridy = 4;
//		panel.add(outputLabel, constraints);
//
//		// Check if input fields are filled and enable buttons
//		nameField.addKeyListener(new java.awt.event.KeyAdapter() {
//			public void keyReleased(java.awt.event.KeyEvent evt) {
//				enableButtons(nameField, userIdField, registerButton, loginButton);
//			}
//		});
//
//		userIdField.addKeyListener(new java.awt.event.KeyAdapter() {
//			public void keyReleased(java.awt.event.KeyEvent evt) {
//				enableButtons(nameField, userIdField, registerButton, loginButton);
//			}
//		});
//
//		// Handle the registration button click
//		registerButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String name = nameField.getText();
//				String userId = userIdField.getText();
//				String result = userService.registerUser(name, userId);
//				outputLabel.setText(result);
//				outputLabel.setForeground(new Color(0, 128, 0)); // Success feedback color
//
//				// Clear input fields after registration
//				nameField.setText("");
//				userIdField.setText("");
//			}
//		});
//
//		// Handle the login button click
//		loginButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String userId = userIdField.getText();
//				String result = userService.loginUser(userId);
//				outputLabel.setText(result);
//				outputLabel.setForeground(new Color(255, 0, 0)); // Error feedback color
//
//				// Clear input fields after login
//				nameField.setText("");
//				userIdField.setText("");
//			}
//		});
//
//		// Make the frame visible
//		frame.setVisible(true);
//	}
//
//	// Enable or disable the Register/Login buttons based on user input
//	private static void enableButtons(JTextField nameField, JTextField userIdField, JButton registerButton, JButton loginButton) {
//		String name = nameField.getText();
//		String userId = userIdField.getText();
//
//		// Enable buttons only if both fields are filled
//		if (!name.isEmpty() && !userId.isEmpty()) {
//			registerButton.setEnabled(true);
//			loginButton.setEnabled(true);
//		} else {
//			registerButton.setEnabled(false);
//			loginButton.setEnabled(false);
//		}
//	}
//
//	// Style the text fields with rounded corners and soft border
//	private static void styleTextField(JTextField textField) {
//		textField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
//		textField.setFont(new Font("Arial", Font.PLAIN, 14));
//		textField.setForeground(new Color(51, 51, 51));
//		textField.setPreferredSize(new Dimension(200, 30)); // Adjust size for a better appearance
//	}
//
//	// Create a stylish button with hover effect
//	private static JButton createButton(String text, Color backgroundColor) {
//		JButton button = new JButton(text);
//		button.setBackground(backgroundColor);
//		button.setFont(new Font("Arial", Font.BOLD, 14));
//		button.setFocusPainted(false);
//		button.setPreferredSize(new Dimension(150, 40)); // Adjust button size
//
//		// Add a hover effect
//		button.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseEntered(java.awt.event.MouseEvent evt) {
//				button.setBackground(button.getBackground().darker());
//			}
//
//			public void mouseExited(java.awt.event.MouseEvent evt) {
//				button.setBackground(backgroundColor);
//			}
//		});
//
//		return button;
//	}
//}



//5 wala code (yeh login wale ke lye best hai)..
//BookNestApplication.java
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

	public static void main(String[] args) {
		// Initialize the user service
		UserService userService = new UserService();

		// Create the main frame with a modern look
		JFrame frame = new JFrame("Book Nest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 350); // Set a good initial size for the frame
		frame.setLocationRelativeTo(null); // Center the frame on the screen

		// Set the window's icon (optional, add your own image path if you want)
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("yourIconPathHere.png"));

		// Create a panel with a responsive layout
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					// Add a light background image (adjust the path as needed)
					File imageFile = new File("C:\\Users\\hp hp\\Downloads\\Book_Nest\\images\\images.jfif"); // Adjust this path
					if (imageFile.exists()) {
						Image background = ImageIO.read(imageFile);
						g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
					} else {
						System.out.println("File not found: " + imageFile.getAbsolutePath());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		panel.setLayout(new GridBagLayout());
		panel.setOpaque(false); // Allow transparency so the background image shows
		frame.add(panel);

		// Use GridBagConstraints for flexible positioning and resizing
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10); // Add padding around components
		constraints.gridx = 0; // Set starting position of components in grid

		// Create labels
		JLabel welcomeLabel = new JLabel("Welcome to Book Nest", SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
		welcomeLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
		welcomeLabel.setOpaque(true);
		welcomeLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent black background

		JLabel nameLabel = new JLabel("Enter your name:");
		nameLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
		nameLabel.setOpaque(true);
		nameLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent background

		JLabel userIdLabel = new JLabel("Enter your user ID:");
		userIdLabel.setForeground(Color.WHITE); // Change the color to white for better contrast
		userIdLabel.setOpaque(true);
		userIdLabel.setBackground(new Color(0, 0, 0, 100)); // Semi-transparent background

		JLabel outputLabel = new JLabel("", SwingConstants.CENTER);
		outputLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		outputLabel.setForeground(Color.YELLOW); // Make output label bright (for feedback)
		outputLabel.setOpaque(true);
		outputLabel.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent background for output label

		// Create text fields with rounded corners
		JTextField nameField = new JTextField(20);
		JTextField userIdField = new JTextField(20);
		styleTextField(nameField);
		styleTextField(userIdField);

		// Create buttons with colors and hover effect
		JButton registerButton = createButton("Register", new Color(51, 153, 255), Color.WHITE);  // Button with white text
		JButton loginButton = createButton("Login", new Color(51, 204, 51), Color.WHITE);  // Button with white text

		// Initially disable buttons until both fields are filled
		registerButton.setEnabled(false);
		loginButton.setEnabled(false);

		// Add components to the panel using GridBagConstraints
		constraints.gridx = 0;
		constraints.gridwidth = 2;
		panel.add(welcomeLabel, constraints);

		constraints.gridy = 1; // Move down
		constraints.gridwidth = 1;
		panel.add(nameLabel, constraints);
		constraints.gridx = 1;
		panel.add(nameField, constraints);

		constraints.gridx = 0; // Move to the left column for userIdLabel
		constraints.gridy = 2; // Move down to the second row
		panel.add(userIdLabel, constraints);
		constraints.gridx = 1;
		panel.add(userIdField, constraints);

		constraints.gridx = 0; // Move to a new row
		constraints.gridy = 3;
		panel.add(registerButton, constraints);

		constraints.gridx = 1;
		panel.add(loginButton, constraints);

		// Add an output label for feedback
		constraints.gridx = 0;
		constraints.gridwidth = 2;
		constraints.gridy = 4;
		panel.add(outputLabel, constraints);

		// Check if input fields are filled and enable buttons
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

		// Handle the registration button click
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String userId = userIdField.getText();
				String result = userService.registerUser(name, userId);
				outputLabel.setText(result);
				outputLabel.setForeground(new Color(0, 128, 0)); // Success feedback color

				// Clear input fields after registration
				nameField.setText("");
				userIdField.setText("");
			}
		});

		// Handle the login button click
//		loginButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String userId = userIdField.getText();
//				String result = userService.loginUser(userId);
//				outputLabel.setText(result);
//				outputLabel.setForeground(new Color(255, 0, 0)); // Error feedback color
//
//				// Clear input fields after login
//				nameField.setText("");
//				userIdField.setText("");
//			}
//		});

		// Handle the login button click
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userId = userIdField.getText();
				String result = userService.loginUser(userId);

				if (result.startsWith("Welcome back")) {
					// Successful login
					frame.dispose(); // Close the current login window
					new CategoriesPage(); // Open the CategoriesPage
				} else {
					// Failed login
					outputLabel.setText(result);
					outputLabel.setForeground(new Color(255, 0, 0)); // Error feedback color
				}

				// Clear input fields after login
				nameField.setText("");
				userIdField.setText("");
			}
		});


		// Make the frame visible
		frame.setVisible(true);
	}

	// Enable or disable the Register/Login buttons based on user input
	private static void enableButtons(JTextField nameField, JTextField userIdField, JButton registerButton, JButton loginButton) {
		String name = nameField.getText();
		String userId = userIdField.getText();

		// Enable buttons only if both fields are filled
		if (!name.isEmpty() && !userId.isEmpty()) {
			registerButton.setEnabled(true);
			loginButton.setEnabled(true);
		} else {
			registerButton.setEnabled(false);
			loginButton.setEnabled(false);
		}
	}

	// Style the text fields with rounded corners and soft border
	private static void styleTextField(JTextField textField) {
		textField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setForeground(new Color(51, 51, 51));
		textField.setPreferredSize(new Dimension(200, 30)); // Adjust size for a better appearance
	}

	// Create a stylish button with hover effect and set the text color
	private static JButton createButton(String text, Color backgroundColor, Color textColor) {
		JButton button = new JButton(text);
		button.setBackground(backgroundColor);
		button.setForeground(textColor);  // Set the text color to the provided value
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setFocusPainted(false);
		button.setPreferredSize(new Dimension(150, 40)); // Adjust button size

		// Add a hover effect
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setBackground(button.getBackground().darker());
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setBackground(backgroundColor);
			}
		});

		return button;
	}
}




