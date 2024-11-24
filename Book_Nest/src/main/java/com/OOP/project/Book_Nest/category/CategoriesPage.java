//CategoriesPage.java(categoris ke name hn sirf)
//package com.OOP.project.Book_Nest.category;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class CategoriesPage {
//
//    public CategoriesPage() {
//        // Create a new frame for categories
//        JFrame frame = new JFrame("Book Nest - Categories");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 350); // Set size
//        frame.setLocationRelativeTo(null); // Center on screen
//
//        // Create a panel with GridBagLayout
//        JPanel panel = new JPanel(new GridBagLayout());
//        panel.setBackground(new Color(240, 240, 240)); // Light background color
//
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.insets = new Insets(10, 10, 10, 10); // Padding
//
//        // Add a title label
//        JLabel titleLabel = new JLabel("Select a Category");
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 2;
//        panel.add(titleLabel, constraints);
//
//        // Category buttons
//        String[] categories = {"Islamic History", "Novels", "Computer Science", "Social Science"};
//        for (int i = 0; i < categories.length; i++) {
//            JButton categoryButton = createCategoryButton(categories[i]);
//            constraints.gridy = i + 1;
//            constraints.gridwidth = 1;
//            panel.add(categoryButton, constraints);
//        }
//
//        frame.add(panel);
//        frame.setVisible(true);
//    }
//
//    // Helper to create category buttons
//    private JButton createCategoryButton(String categoryName) {
//        JButton button = new JButton(categoryName);
//        button.setFont(new Font("Arial", Font.PLAIN, 14));
//        button.setBackground(new Color(200, 200, 255)); // Light blue
//        button.setForeground(Color.BLACK);
//        button.setFocusPainted(false);
//        button.setPreferredSize(new Dimension(200, 40));
//
//        // Add action listener to handle button clicks
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "You selected: " + categoryName);
//            }
//        });
//
//        return button;
//    }
//}
//
//
//
//


// back button
package com.OOP.project.Book_Nest.category;

import com.OOP.project.Book_Nest.BookNestApplication; // Import the main application class

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoriesPage {

    public CategoriesPage() {
        // Create a new frame for categories
        JFrame frame = new JFrame("Book Nest - Categories");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350); // Set size
        frame.setLocationRelativeTo(null); // Center on screen

        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240)); // Light background color

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Padding

        // Add a title label
        JLabel titleLabel = new JLabel("Select a Category");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(titleLabel, constraints);

        // Category buttons
        String[] categories = {"Islamic History", "Novels", "Computer Science", "Social Science"};
        for (int i = 0; i < categories.length; i++) {
            JButton categoryButton = createCategoryButton(categories[i]);
            constraints.gridy = i + 1;
            constraints.gridwidth = 1;
            panel.add(categoryButton, constraints);
        }

        // Add the "Back" button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBackground(new Color(255, 200, 200)); // Light red
        backButton.setForeground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(200, 40));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // Hide the categories page
                new BookNestApplication(); // Show the login/registration page
            }
        });

        // Add back button at the bottom of the categories
        constraints.gridy = categories.length + 1;
        constraints.gridwidth = 2;
        panel.add(backButton, constraints);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Helper to create category buttons
    private JButton createCategoryButton(String categoryName) {
        JButton button = new JButton(categoryName);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(200, 200, 255)); // Light blue
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 40));

        // Add action listener to handle button clicks
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You selected: " + categoryName);
            }
        });

        return button;
    }
}

//package com.OOP.project.Book_Nest.category;
//
//import com.OOP.project.Book_Nest.BookNestApplication; // Import the main application class
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class CategoriesPage {
//
//    public CategoriesPage() {
//        // Create a new frame for categories
//        JFrame frame = new JFrame("Book Nest - Categories");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 350); // Set size
//        frame.setLocationRelativeTo(null); // Center on screen
//
//        // Create a panel with GridBagLayout
//        JPanel panel = new JPanel(new GridBagLayout());
//        panel.setBackground(new Color(240, 240, 240)); // Light background color
//
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.insets = new Insets(10, 10, 10, 10); // Padding
//
//        // Add a title label
//        JLabel titleLabel = new JLabel("Select a Category");
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 2;
//        panel.add(titleLabel, constraints);
//
//        // Category buttons
//        String[] categories = {"Islamic History", "Novels", "Computer Science", "Social Science"};
//        for (int i = 0; i < categories.length; i++) {
//            JButton categoryButton = createCategoryButton(categories[i]);
//            constraints.gridy = i + 1;
//            constraints.gridwidth = 1;
//            panel.add(categoryButton, constraints);
//        }
//
//        // Add the "Back" button
//        JButton backButton = new JButton("Back");
//        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
//        backButton.setBackground(new Color(255, 200, 200)); // Light red
//        backButton.setForeground(Color.BLACK);
//        backButton.setFocusPainted(false);
//        backButton.setPreferredSize(new Dimension(200, 40));
//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false); // Hide the categories page
//                new BookNestApplication(); // Show the login/registration page
//            }
//        });
//
//        // Add back button at the bottom of the categories
//        constraints.gridy = categories.length + 1;
//        constraints.gridwidth = 2;
//        panel.add(backButton, constraints);
//
//        frame.add(panel);
//        frame.setVisible(true);
//    }
//
//    // Helper to create category buttons
//    private JButton createCategoryButton(String categoryName) {
//        JButton button = new JButton(categoryName);
//        button.setFont(new Font("Arial", Font.PLAIN, 14));
//        button.setBackground(new Color(200, 200, 255)); // Light blue
//        button.setForeground(Color.BLACK);
//        button.setFocusPainted(false);
//        button.setPreferredSize(new Dimension(200, 40));
//
//        // Add action listener to handle button clicks
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showBooksInCategory(categoryName);  // Show books in selected category
//            }
//        });
//
//        return button;
//    }
//
//    // Method to show books in a selected category
//    private void showBooksInCategory(String categoryName) {
//        // Create a new frame to show books in the selected category
//        JFrame booksFrame = new JFrame(categoryName + " Books");
//        booksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        booksFrame.setSize(500, 350); // Set size
//        booksFrame.setLocationRelativeTo(null); // Center on screen
//
//        // Create a panel to display the books
//        JPanel booksPanel = new JPanel();
//        booksPanel.setLayout(new BoxLayout(booksPanel, BoxLayout.Y_AXIS));
//
//        // Example book list for each category
//        String[] books;
//        switch (categoryName) {
//            case "Islamic History":
//                books = new String[]{"Book 1: History of Islam", "Book 2: Early Islamic Civilization", "Book 3: Islam in the Modern World"};
//                break;
//            case "Novels":
//                books = new String[]{"Book 1: The Great Gatsby", "Book 2: Moby Dick", "Book 3: To Kill a Mockingbird"};
//                break;
//            case "Computer Science":
//                books = new String[]{"Book 1: Introduction to Algorithms", "Book 2: Computer Networking", "Book 3: Data Structures"};
//                break;
//            case "Social Science":
//                books = new String[]{"Book 1: Sociology 101", "Book 2: Social Theories", "Book 3: Understanding Society"};
//                break;
//            default:
//                books = new String[]{};
//        }
//
//        // Add book titles to the panel
//        for (String book : books) {
//            JLabel bookLabel = new JLabel(book);
//            booksPanel.add(bookLabel);
//        }
//
//        // Add books panel to the frame
//        booksFrame.add(new JScrollPane(booksPanel));
//        booksFrame.setVisible(true);
//    }
//}


// back button hai isme link kerwa hai.
//package com.OOP.project.Book_Nest.category;
//
//import com.OOP.project.Book_Nest.BookNestApplication; // Import the main application class
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class CategoriesPage {
//
//    public CategoriesPage() {
//        // Create a new frame for categories
//        JFrame frame = new JFrame("Book Nest - Categories");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 350); // Set size
//        frame.setLocationRelativeTo(null); // Center on screen
//
//        // Create a panel with GridBagLayout
//        JPanel panel = new JPanel(new GridBagLayout());
//        panel.setBackground(new Color(240, 240, 240)); // Light background color
//
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.insets = new Insets(10, 10, 10, 10); // Padding
//
//        // Add a title label
//        JLabel titleLabel = new JLabel("Select a Category");
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 2;
//        panel.add(titleLabel, constraints);
//
//        // Category buttons
//        String[] categories = {"Islamic History", "Novels", "Computer Science", "Social Science"};
//        for (int i = 0; i < categories.length; i++) {
//            JButton categoryButton = createCategoryButton(categories[i]);
//            constraints.gridy = i + 1;
//            constraints.gridwidth = 1;
//            panel.add(categoryButton, constraints);
//        }
//
//        // Add the "Back" button
//        JButton backButton = new JButton("Back");
//        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
//        backButton.setBackground(new Color(255, 200, 200)); // Light red
//        backButton.setForeground(Color.BLACK);
//        backButton.setFocusPainted(false);
//        backButton.setPreferredSize(new Dimension(200, 40));
//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Hide the categories page
//                frame.setVisible(false);
//                // Open the BookNestApplication (login/registration page)
//                new BookNestApplication();
//            }
//        });
//
//        // Add back button at the bottom of the categories
//        constraints.gridy = categories.length + 1;
//        constraints.gridwidth = 2;
//        panel.add(backButton, constraints);
//
//        frame.add(panel);
//        frame.setVisible(true);
//    }
//
//    // Helper to create category buttons
//    private JButton createCategoryButton(String categoryName) {
//        JButton button = new JButton(categoryName);
//        button.setFont(new Font("Arial", Font.PLAIN, 14));
//        button.setBackground(new Color(200, 200, 255)); // Light blue
//        button.setForeground(Color.BLACK);
//        button.setFocusPainted(false);
//        button.setPreferredSize(new Dimension(200, 40));
//
//        // Add action listener to handle button clicks
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showBooksInCategory(categoryName);  // Show books in selected category
//            }
//        });
//
//        return button;
//    }
//
//    // Method to show books in a selected category
//    private void showBooksInCategory(String categoryName) {
//        // Create a new frame to show books in the selected category
//        JFrame booksFrame = new JFrame(categoryName + " Books");
//        booksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        booksFrame.setSize(500, 350); // Set size
//        booksFrame.setLocationRelativeTo(null); // Center on screen
//
//        // Create a panel to display the books
//        JPanel booksPanel = new JPanel();
//        booksPanel.setLayout(new BoxLayout(booksPanel, BoxLayout.Y_AXIS));
//
//        // Example book list for each category
//        String[] books;
//        switch (categoryName) {
//            case "Islamic History":
//                books = new String[]{"Book 1: History of Islam", "Book 2: Early Islamic Civilization", "Book 3: Islam in the Modern World"};
//                break;
//            case "Novels":
//                books = new String[]{"Book 1: The Great Gatsby", "Book 2: Moby Dick", "Book 3: To Kill a Mockingbird"};
//                break;
//            case "Computer Science":
//                books = new String[]{"Book 1: Introduction to Algorithms", "Book 2: Computer Networking", "Book 3: Data Structures"};
//                break;
//            case "Social Science":
//                books = new String[]{"Book 1: Sociology 101", "Book 2: Social Theories", "Book 3: Understanding Society"};
//                break;
//            default:
//                books = new String[]{};
//        }
//
//        // Add book titles to the panel
//        for (String book : books) {
//            JLabel bookLabel = new JLabel(book);
//            booksPanel.add(bookLabel);
//        }
//
//        // Add books panel to the frame
//        booksFrame.add(new JScrollPane(booksPanel));
//        booksFrame.setVisible(true);
//    }
//}

