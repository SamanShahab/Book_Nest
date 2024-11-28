// BookListPage.java

// final...
//// BookListPage.java
//package com.OOP.project.Book_Nest.category;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class BookListPage {
//
//    public BookListPage(String categoryName) {
//        // Create a new frame for the category's books
//        JFrame frame = new JFrame("Books in " + categoryName);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 350); // Set size
//        frame.setLocationRelativeTo(null); // Center on screen
//
//        // Create a panel with BoxLayout for dynamic arrangement
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Change to BoxLayout for a more flexible layout
//        panel.setBackground(new Color(240, 240, 240)); // Light background color
//
//        // Add a title label
//        JLabel titleLabel = new JLabel("Books in " + categoryName);
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        panel.add(titleLabel);
//
//        // Fetch books for the selected category
//        LibrarianFile librarianFile = new LibrarianFile();
//        List<String> books = librarianFile.getBooksByCategory(categoryName);
//
//        // Display books and borrow/return options
//        for (String book : books) {
//            JPanel bookPanel = new JPanel();
//            bookPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//
//            JLabel bookLabel = new JLabel(book);
//            bookLabel.setFont(new Font("Arial", Font.PLAIN, 14));
//
//            JButton borrowButton = new JButton("Borrow");
//            JButton returnButton = new JButton("Return");
//
//            bookPanel.add(bookLabel);
//            bookPanel.add(borrowButton);
//            bookPanel.add(returnButton);
//
//            panel.add(bookPanel);
//
//            // Borrow button action listener
//            borrowButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // Try to borrow the book
//                    boolean success = librarianFile.borrowBook(book);
//
//                    if (success) {
//                        JOptionPane.showMessageDialog(frame, "You have borrowed: " + book);
//                    } else {
//                        JOptionPane.showMessageDialog(frame, "Sorry, this book is already borrowed.");
//                    }
//
//                    // Refresh the book list to update the borrow status
//                    refreshBookList(frame, categoryName);
//                }
//            });
//
//            // Return button action listener
//            returnButton.addActionListener(e -> {
//                librarianFile.returnBook(book);
//                JOptionPane.showMessageDialog(frame, "You have returned: " + book);
//                refreshBookList(frame, categoryName); // Update the list dynamically
//            });
//        }
//
//        // Add the panel to the frame
//        frame.add(new JScrollPane(panel));  // Add scroll functionality to the panel
//        frame.setVisible(true);
//    }
//
//    private void refreshBookList(JFrame frame, String categoryName) {
//        frame.dispose(); // Close the current frame
//        new BookListPage(categoryName); // Refresh the book list page
//    }
//}


//yeh back to category page ke lye kya final..
////BookListPage.java
//package com.OOP.project.Book_Nest.category;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class BookListPage {
//
//    public BookListPage(String categoryName) {
//        // Create a new frame for the category's books
//        JFrame frame = new JFrame("Books in " + categoryName);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 350); // Set size
//        frame.setLocationRelativeTo(null); // Center on screen
//
//        // Create a panel with BoxLayout for dynamic arrangement
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Change to BoxLayout for a more flexible layout
//        panel.setBackground(new Color(240, 240, 240)); // Light background color
//
//        // Add a title label
//        JLabel titleLabel = new JLabel("Books in " + categoryName);
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        panel.add(titleLabel);
//
//        // Fetch books for the selected category
//        LibrarianFile librarianFile = new LibrarianFile();
//        List<String> books = librarianFile.getBooksByCategory(categoryName);
//
//        // Display books and borrow/return options
//        for (String book : books) {
//            JPanel bookPanel = new JPanel();
//            bookPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//
//            JLabel bookLabel = new JLabel(book);
//            bookLabel.setFont(new Font("Arial", Font.PLAIN, 14));
//
//            JButton borrowButton = new JButton("Borrow");
//            JButton returnButton = new JButton("Return");
//
//            bookPanel.add(bookLabel);
//            bookPanel.add(borrowButton);
//            bookPanel.add(returnButton);
//
//            panel.add(bookPanel);
//
//            // Borrow button action listener
//            borrowButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // Try to borrow the book
//                    boolean success = librarianFile.borrowBook(book);
//
//                    if (success) {
//                        JOptionPane.showMessageDialog(frame, "You have borrowed: " + book);
//                    } else {
//                        JOptionPane.showMessageDialog(frame, "Sorry, this book is already borrowed.");
//                    }
//
//                    // Refresh the book list to update the borrow status
//                    refreshBookList(frame, categoryName);
//                }
//            });
//
//            // Return button action listener
//            returnButton.addActionListener(e -> {
//                librarianFile.returnBook(book);
//                JOptionPane.showMessageDialog(frame, "You have returned: " + book);
//                refreshBookList(frame, categoryName); // Update the list dynamically
//            });
//        }
//
//        // Add the "Back" button at the bottom of the panel
//        JButton backButton = new JButton("Back");
//        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
//        backButton.setBackground(new Color(255, 69, 0));
//        backButton.setForeground(Color.WHITE);
//
//        // Action listener for the Back button
//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.dispose(); // Close the current frame
//                new CategoriesPage(); // Open the CategoriesPage
//            }
//        });
//
//        // Add the Back button to the panel
//        panel.add(backButton);
//
//        // Add the panel to the frame
//        frame.add(new JScrollPane(panel)); // Add scroll functionality to the panel
//        frame.setVisible(true);
//    }
//
//    private void refreshBookList(JFrame frame, String categoryName) {
//        frame.dispose(); // Close the current frame
//        new BookListPage(categoryName); // Refresh the book list page
//    }
//}


//fine and charges final
//BookListPage.java
//package com.OOP.project.Book_Nest.category;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class BookListPage {
//
//    private static JFrame frame;  // Keep a reference to the frame to prevent multiple instances
//
//    public BookListPage(String categoryName) {
//        if (frame != null) {
//            frame.dispose();  // Dispose of the existing frame if already opened
//        }
//
//        // Create a new frame for the category's books
//        frame = new JFrame("Books in " + categoryName);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 350); // Set size
//        frame.setLocationRelativeTo(null); // Center on screen
//
//        // Synchronize window state with the CategoriesPage
//        JFrame mainFrame = CategoriesPage.getMainFrame(); // You can retrieve the main frame if needed for state sync
//        frame.setExtendedState(mainFrame.getExtendedState());  // Synchronize the window state
//
//        // Create a panel with BoxLayout for dynamic arrangement
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Change to BoxLayout for a more flexible layout
//        panel.setBackground(new Color(222, 184, 135)); // Light background color
//
//        // Add a title label
//        JLabel titleLabel = new JLabel("Books in " + categoryName);
//        titleLabel.setFont(new Font("Cooper Black", Font.BOLD, 33));
//        panel.add(titleLabel);
//
//        // Fetch books for the selected category
//        LibrarianFile librarianFile = new LibrarianFile();
//        List<String> books = librarianFile.getBooksByCategory(categoryName);
//
//        // Display books and borrow/return options
//        for (String book : books) {
//            JPanel bookPanel = new JPanel();
//            bookPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//            bookPanel.setBackground(new Color(222, 184, 135));
//
//            JLabel bookLabel = new JLabel(book);
//            bookLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
//
//            JButton borrowButton = new JButton("Borrow");
//            JButton returnButton = new JButton("Return");
//
//            bookPanel.add(bookLabel);
//            bookPanel.add(borrowButton);
//            bookPanel.add(returnButton);
//
//            panel.add(bookPanel);
//
//            // Borrow button action listener
//            borrowButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // Try to borrow the book
//                    boolean success = librarianFile.borrowBook(book);
//
//                    if (success) {
//                        JOptionPane.showMessageDialog(frame, "You have borrowed: " + book);
//                    } else {
//                        JOptionPane.showMessageDialog(frame, "Sorry, this book is already borrowed.");
//                    }
//
//                    // Refresh the book list to update the borrow status
//                    refreshBookList(frame, categoryName);
//                }
//            });
//
//            // Return button action listener
//            returnButton.addActionListener(e -> {
//                librarianFile.returnBook(book);
//                JOptionPane.showMessageDialog(frame, "You have returned: " + book);
//                refreshBookList(frame, categoryName); // Update the list dynamically
//            });
//        }
//
//        // Add the "Back" button at the bottom of the panel
//        JButton backButton = new JButton("Back");
//        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
//        backButton.setBackground(new Color(255, 69, 0));
//        backButton.setForeground(Color.WHITE);
//
//        // Action listener for the Back button
//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.dispose(); // Close the current frame
//                CategoriesPage.openCategoriesPage(); // Open the CategoriesPage (use the static method to open it)
//            }
//        });
//
//        // Add the Back button to the panel
//        panel.add(backButton);
//
//        // Add the panel to the frame
//        frame.add(new JScrollPane(panel)); // Add scroll functionality to the panel
//        frame.setVisible(true);
//    }
//
//    private void refreshBookList(JFrame frame, String categoryName) {
//        frame.dispose(); // Close the current frame
//        new BookListPage(categoryName); // Refresh the book list page
//    }
//}



//final...
package com.OOP.project.Book_Nest.category;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookListPage {

    private static JFrame frame; // Keep a reference to the frame to prevent multiple instances

    public BookListPage(String categoryName) {
        if (frame != null) {
            frame.dispose(); // Dispose of the existing frame if already opened
        }

        // Create a new frame for the category's books
        frame = new JFrame("Books in " + categoryName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350); // Set size
        frame.setLocationRelativeTo(null); // Center on screen

        // Synchronize window state with the CategoriesPage
        JFrame mainFrame = CategoriesPage.getMainFrame(); // Retrieve the main frame if needed
        frame.setExtendedState(mainFrame.getExtendedState()); // Synchronize the window state

        // Create a panel with BoxLayout for dynamic arrangement
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout
        panel.setBackground(new Color(222, 184, 135)); // Light background color

        // Add a title label
        JLabel titleLabel = new JLabel("Books in " + categoryName);
        titleLabel.setFont(new Font("Cooper Black", Font.BOLD, 33));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the title
        panel.add(titleLabel);

        // Fetch books for the selected category
        LibrarianFile librarianFile = new LibrarianFile();
        List<String> books = librarianFile.getBooksByCategory(categoryName);

        // Display books and borrow/return options
        for (String book : books) {
            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            bookPanel.setBackground(new Color(222, 184, 135));

            JLabel bookLabel = new JLabel(book);
            bookLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));

            JButton borrowButton = new JButton("Borrow");
            JButton returnButton = new JButton("Return");

            bookPanel.add(bookLabel);
            bookPanel.add(borrowButton);
            bookPanel.add(returnButton);

            panel.add(bookPanel);

            // Borrow button action listener
            borrowButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Try to borrow the book
                    boolean success = librarianFile.borrowBook(book);

                    if (success) {
                        JOptionPane.showMessageDialog(frame, "You have borrowed: " + book);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Sorry, this book is already borrowed.");
                    }

                    // Refresh the book list to update the borrow status
                    refreshBookList(frame, categoryName);
                }
            });

            // Return button action listener
            returnButton.addActionListener(e -> {
                librarianFile.returnBook(book);
                JOptionPane.showMessageDialog(frame, "You have returned: " + book);
                refreshBookList(frame, categoryName); // Update the list dynamically
            });
        }

        // Add the "Back" button at the bottom of the panel
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBackground(new Color(255, 69, 0));
        backButton.setForeground(Color.WHITE);

        // Action listener for the Back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current frame
                CategoriesPage.openCategoriesPage(); // Open the CategoriesPage
            }
        });

        // Create a panel specifically for the Back button
        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new BoxLayout(backButtonPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment
        backButtonPanel.setBackground(new Color(222, 184, 135)); // Match the background color

        // Add spacing to center the Back button vertically
        backButtonPanel.add(Box.createVerticalGlue());
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button horizontally
        backButtonPanel.add(backButton);
        backButtonPanel.add(Box.createVerticalGlue());

        // Add the Back button panel to the main panel
        panel.add(backButtonPanel);

        // Add the panel to the frame
        frame.add(new JScrollPane(panel)); // Add scroll functionality to the panel
        frame.setVisible(true);
    }

    private void refreshBookList(JFrame frame, String categoryName) {
        frame.dispose(); // Close the current frame
        new BookListPage(categoryName); // Refresh the book list page
    }
}

