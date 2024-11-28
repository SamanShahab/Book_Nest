// LibrarianFile.java

////fine and charges final...
////LibrarianFile.java
//package com.OOP.project.Book_Nest.category;
//import javax.swing.JOptionPane;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
//public class LibrarianFile {
//
//    private static final String FILE_PATH = "C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt";
//    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    private static final int BORROW_DURATION_DAYS = 7; // Maximum borrow duration before fine
//
//    // Get books by category
//    public List<String> getBooksByCategory(String category) {
//        List<String> books = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(":");
//                if (parts.length >= 2 && parts[0].equals(category)) {
//                    books.add(parts[1].split("\\(")[0].trim()); // Add book name without status
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return books;
//    }
//
//    // Borrow a book
////    public boolean borrowBook(String book) {
////        try {
////            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"));
////            List<String> updatedLines = new ArrayList<>();
////
////            boolean bookAlreadyBorrowed = false;
////            for (String line : lines) {
////                if (line.contains(book) && line.contains("(Borrowed)")) {
////                    bookAlreadyBorrowed = true; // If already borrowed
////                    updatedLines.add(line);
////                } else if (line.contains(book)) {
////                    String newLine = line + " (Borrowed:" + LocalDate.now().format(DATE_FORMATTER) + ")";
////                    updatedLines.add(newLine); // Add borrow date
////                } else {
////                    updatedLines.add(line);
////                }
////            }
////
////            if (bookAlreadyBorrowed) {
////                return false; // Cannot borrow again
////            }
////
////            Files.write(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"), updatedLines);
////            return true;
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return false;
////    }
//
//    // Borrow a book
//    public boolean borrowBook(String book) {
//        try {
//            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
//            List<String> updatedLines = new ArrayList<>();
//            boolean bookAlreadyBorrowed = false;
//            boolean bookOverdue = false;
//            long overdueDays = 0;
//
//            for (String line : lines) {
//                if (line.contains(book) && line.contains("(Borrowed:")) {
//                    bookAlreadyBorrowed = true;
//
//                    // Check if the book is overdue
//                    String borrowDateStr = line.substring(line.indexOf("(Borrowed:") + 10, line.indexOf(")"));
//                    LocalDate borrowDate = LocalDate.parse(borrowDateStr, DATE_FORMATTER);
//                    LocalDate currentDate = LocalDate.now();
//                    long daysBorrowed = java.time.temporal.ChronoUnit.DAYS.between(borrowDate, currentDate);
//
//                    if (daysBorrowed > BORROW_DURATION_DAYS) {
//                        bookOverdue = true;
//                        overdueDays = daysBorrowed - BORROW_DURATION_DAYS;
//                    }
//                    updatedLines.add(line); // Keep the line as is
//                } else if (line.contains(book)) {
//                    updatedLines.add(line); // Keep the line as is
//                } else {
//                    updatedLines.add(line); // Add unchanged lines
//                }
//            }
//
//            if (bookOverdue) {
//                int fine = calculateFine(overdueDays);
//                int response = JOptionPane.showConfirmDialog(null,
//                        "This book is overdue by " + overdueDays + " days. Fine: Rs. " + fine + ". Pay now?",
//                        "Fine Payment",
//                        JOptionPane.YES_NO_OPTION);
//
//                if (response == JOptionPane.YES_OPTION) {
//                    // Allow borrowing after fine payment
//                    List<String> finalUpdatedLines = new ArrayList<>();
//                    for (String line : updatedLines) {
//                        if (line.contains(book) && !line.contains("(Borrowed)")) {
//                            String newLine = line + " (Borrowed:" + LocalDate.now().format(DATE_FORMATTER) + ")";
//                            finalUpdatedLines.add(newLine); // Add borrow date
//                        } else {
//                            finalUpdatedLines.add(line); // Keep unchanged lines
//                        }
//                    }
//                    Files.write(Paths.get(FILE_PATH), finalUpdatedLines);
//                    return true;
//                } else {
//                    return false; // Borrowing canceled if fine not paid
//                }
//            }
//
//            if (bookAlreadyBorrowed) {
//                JOptionPane.showMessageDialog(null, "Sorry, this book is already borrowed.");
//                return false;
//            }
//
//            // Update the book entry to borrowed status
//            List<String> finalUpdatedLines = new ArrayList<>();
//            for (String line : updatedLines) {
//                if (line.contains(book) && !line.contains("(Borrowed)")) {
//                    String newLine = line + " (Borrowed:" + LocalDate.now().format(DATE_FORMATTER) + ")";
//                    finalUpdatedLines.add(newLine); // Add borrow date
//                } else {
//                    finalUpdatedLines.add(line); // Keep unchanged lines
//                }
//            }
//
//            Files.write(Paths.get(FILE_PATH), finalUpdatedLines);
//            return true;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//
//    // Return a book
////    public void returnBook(String book) {
////        try {
////            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"));
////            List<String> updatedLines = new ArrayList<>();
////
////            for (String line : lines) {
////                if (line.contains(book) && line.contains("(Borrowed:")) {
////                    String borrowDateStr = line.substring(line.indexOf("(Borrowed:") + 10, line.indexOf(")"));
////                    LocalDate borrowDate = LocalDate.parse(borrowDateStr, DATE_FORMATTER);
////                    LocalDate currentDate = LocalDate.now();
////
////                    // Check if the book is overdue
////                    long daysBorrowed = java.time.temporal.ChronoUnit.DAYS.between(borrowDate, currentDate);
////                    if (daysBorrowed > BORROW_DURATION_DAYS) {
////                        int fine = calculateFine(daysBorrowed - BORROW_DURATION_DAYS);
////                        JOptionPane.showMessageDialog(null, "This book is overdue by " + (daysBorrowed - BORROW_DURATION_DAYS)
////                                + " days. You need to pay a fine of Rs. " + fine);
////                    }
////
////                    // Remove the borrow tag
////                    updatedLines.add(line.replaceFirst("\\(Borrowed:.*\\)", "").trim());
////                } else {
////                    updatedLines.add(line);
////                }
////            }
////
////            Files.write(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"), updatedLines);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
//
//    // Return a book
//    public void returnBook(String book) {
//        try {
//            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"));
//            List<String> updatedLines = new ArrayList<>();
//            boolean isBorrowed = false; // Flag to check if the book is borrowed
//
//            for (String line : lines) {
//                if (line.contains(book) && line.contains("(Borrowed:")) {
//                    isBorrowed = true; // Book is currently borrowed
//                    String borrowDateStr = line.substring(line.indexOf("(Borrowed:") + 10, line.indexOf(")"));
//                    LocalDate borrowDate = LocalDate.parse(borrowDateStr, DATE_FORMATTER);
//                    LocalDate currentDate = LocalDate.now();
//
//                    // Check if the book is overdue
//                    long daysBorrowed = java.time.temporal.ChronoUnit.DAYS.between(borrowDate, currentDate);
//                    if (daysBorrowed > BORROW_DURATION_DAYS) {
//                        int fine = calculateFine(daysBorrowed - BORROW_DURATION_DAYS);
//                        JOptionPane.showMessageDialog(null, "This book is overdue by " + (daysBorrowed - BORROW_DURATION_DAYS)
//                                + " days. You need to pay a fine of Rs. " + fine);
//                    }
//
//                    // Remove the borrow tag
//                    updatedLines.add(line.replaceFirst("\\(Borrowed:.*\\)", "").trim());
//                } else {
//                    updatedLines.add(line); // Keep unchanged lines
//                }
//            }
//
//            if (!isBorrowed) {
//                JOptionPane.showMessageDialog(null, "This book is not borrowed and cannot be returned.");
//                return; // Exit method if the book is not borrowed
//            }
//
//            // Write updated lines back to the file
//            Files.write(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"), updatedLines);
//            JOptionPane.showMessageDialog(null, "You have successfully returned the book: " + book);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    // Calculate fine based on overdue days
//    private int calculateFine(long overdueDays) {
//        int finePerDay = 50; // Fine amount per day
//        return (int) (overdueDays * finePerDay);
//    }
//}




//fine and charges final...
//LibrarianFile.java
//package com.OOP.project.Book_Nest.category;
//import javax.swing.JOptionPane;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
//public class LibrarianFile {
//
//    private static final String FILE_PATH = "C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt";
//    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    private static final int BORROW_DURATION_DAYS = 7; // Maximum borrow duration before fine
//
//    // Get books by category
//    public List<String> getBooksByCategory(String category) {
//        List<String> books = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(":");
//                if (parts.length >= 2 && parts[0].equals(category)) {
//                    books.add(parts[1].split("\\(")[0].trim()); // Add book name without status
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return books;
//    }
//
//
//    // Borrow a book
//    public boolean borrowBook(String book) {
//        try {
//            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"));
//            List<String> updatedLines = new ArrayList<>();
//            boolean bookAlreadyBorrowed = false;
//            boolean bookOverdue = false;
//            long overdueDays = 0;
//
//            for (String line : lines) {
//                if (line.contains(book) && line.contains("(Borrowed:")) {
//                    bookAlreadyBorrowed = true;
//
//                    // Check if the book is overdue
//                    String borrowDateStr = line.substring(line.indexOf("(Borrowed:") + 10, line.indexOf(")"));
//                    LocalDate borrowDate = LocalDate.parse(borrowDateStr, DATE_FORMATTER);
//                    LocalDate currentDate = LocalDate.now();
//                    long daysBorrowed = java.time.temporal.ChronoUnit.DAYS.between(borrowDate, currentDate);
//
//                    if (daysBorrowed > BORROW_DURATION_DAYS) {
//                        bookOverdue = true;
//                        overdueDays = daysBorrowed - BORROW_DURATION_DAYS;
//                    }
//                    updatedLines.add(line); // Keep the line as is
//                } else if (line.contains(book)) {
//                    updatedLines.add(line); // Keep the line as is
//                } else {
//                    updatedLines.add(line); // Add unchanged lines
//                }
//            }
//
//            if (bookOverdue) {
//                int fine = calculateFine(overdueDays);
//                int response = JOptionPane.showConfirmDialog(null,
//                        "This book is overdue by " + overdueDays + " days. Fine: Rs. " + fine + ". Pay now?",
//                        "Fine Payment",
//                        JOptionPane.YES_NO_OPTION);
//
//                if (response == JOptionPane.YES_OPTION) {
//                    // Allow borrowing after fine payment
//                    List<String> finalUpdatedLines = new ArrayList<>();
//                    for (String line : updatedLines) {
//                        if (line.contains(book) && !line.contains("(Borrowed)")) {
//                            String newLine = line + " (Borrowed:" + LocalDate.now().format(DATE_FORMATTER) + ")";
//                            finalUpdatedLines.add(newLine); // Add borrow date
//                        } else {
//                            finalUpdatedLines.add(line); // Keep unchanged lines
//                        }
//                    }
//                    Files.write(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"), finalUpdatedLines);
//                    return true;
//                } else {
//                    return false; // Borrowing canceled if fine not paid
//                }
//            }
//
//            if (bookAlreadyBorrowed) {
//                JOptionPane.showMessageDialog(null, "Sorry, this book is already borrowed.");
//                return false;
//            }
//
//            // Update the book entry to borrowed status
//            List<String> finalUpdatedLines = new ArrayList<>();
//            for (String line : updatedLines) {
//                if (line.contains(book) && !line.contains("(Borrowed)")) {
//                    String newLine = line + " (Borrowed:" + LocalDate.now().format(DATE_FORMATTER) + ")";
//                    finalUpdatedLines.add(newLine); // Add borrow date
//                } else {
//                    finalUpdatedLines.add(line); // Keep unchanged lines
//                }
//            }
//
//            Files.write(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"), finalUpdatedLines);
//            return true;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
////    public boolean borrowBook(String book) {
////        try {
////            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"));
////            List<String> updatedLines = new ArrayList<>();
////            boolean bookAlreadyBorrowed = false;
////            boolean bookOverdue = false;
////            long overdueDays = 0;
////
////            for (String line : lines) {
////                if (line.contains(book) && line.contains("(Borrowed:")) {
////                    bookAlreadyBorrowed = true;
////
////                    // Check if the book is overdue
////                    String borrowDateStr = line.substring(line.indexOf("(Borrowed:") + 10, line.indexOf(")"));
////                    LocalDate borrowDate = LocalDate.parse(borrowDateStr, DATE_FORMATTER);
////                    LocalDate currentDate = LocalDate.now();
////                    long daysBorrowed = java.time.temporal.ChronoUnit.DAYS.between(borrowDate, currentDate);
////
////                    if (daysBorrowed > BORROW_DURATION_DAYS) {
////                        bookOverdue = true;
////                        overdueDays = daysBorrowed - BORROW_DURATION_DAYS;
////                    }
////                    updatedLines.add(line); // Keep the line as is
////                } else if (line.contains(book)) {
////                    updatedLines.add(line); // Keep the line as is
////                } else {
////                    updatedLines.add(line); // Add unchanged lines
////                }
////            }
////
////            if (bookOverdue) {
////                int fine = calculateFine(overdueDays);
////                int response = JOptionPane.showConfirmDialog(null,
////                        "This book is overdue by " + overdueDays + " days. Fine: Rs. " + fine + ". Pay now?",
////                        "Fine Payment", JOptionPane.YES_NO_OPTION);
////
////                if (response == JOptionPane.YES_OPTION) {
////                    // Allow borrowing after fine payment
////                    List<String> finalUpdatedLines = new ArrayList<>();
////                    for (String line : updatedLines) {
////                        if (line.contains(book) && !line.contains("(Borrowed)")) {
////                            String newLine = line + " (Borrowed:" + LocalDate.now().format(DATE_FORMATTER) + ")";
////                            finalUpdatedLines.add(newLine); // Add borrow date
////                        } else {
////                            finalUpdatedLines.add(line); // Keep unchanged lines
////                        }
////                    }
////                    Files.write(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"), finalUpdatedLines);
////                    JOptionPane.showMessageDialog(null, "You have successfully borrowed: " + book);
////                    return true;
////                } else {
////                    return false; // Borrowing canceled if fine not paid
////                }
////            }
////
////            if (bookAlreadyBorrowed) {
////                JOptionPane.showMessageDialog(null, "Sorry, this book is already borrowed.");
////                return false;
////            }
////
////            // Update the book entry to borrowed status
////            List<String> finalUpdatedLines = new ArrayList<>();
////            for (String line : updatedLines) {
////                if (line.contains(book) && !line.contains("(Borrowed)")) {
////                    String newLine = line + " (Borrowed:" + LocalDate.now().format(DATE_FORMATTER) + ")";
////                    finalUpdatedLines.add(newLine); // Add borrow date
////                } else {
////                    finalUpdatedLines.add(line); // Keep unchanged lines
////                }
////            }
////
////            Files.write(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"), finalUpdatedLines);
////            JOptionPane.showMessageDialog(null, "You have successfully borrowed: " + book);
////            return true;
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return false;
////    }
//
//
//    // Return a book
//    public void returnBook(String book) {
//        try {
//            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"));
//            List<String> updatedLines = new ArrayList<>();
//            boolean isBorrowed = false; // Flag to check if the book is borrowed
//
//            for (String line : lines) {
//                if (line.contains(book) && line.contains("(Borrowed:")) {
//                    isBorrowed = true; // Book is currently borrowed
//                    String borrowDateStr = line.substring(line.indexOf("(Borrowed:") + 10, line.indexOf(")"));
//                    LocalDate borrowDate = LocalDate.parse(borrowDateStr, DATE_FORMATTER);
//                    LocalDate currentDate = LocalDate.now();
//
//                    // Check if the book is overdue
//                    long daysBorrowed = java.time.temporal.ChronoUnit.DAYS.between(borrowDate, currentDate);
//                    if (daysBorrowed > BORROW_DURATION_DAYS) {
//                        int fine = calculateFine(daysBorrowed - BORROW_DURATION_DAYS);
//                        JOptionPane.showMessageDialog(null, "This book is overdue by " + (daysBorrowed - BORROW_DURATION_DAYS)
//                                + " days. You need to pay a fine of Rs. " + fine);
//                    }
//
//                    // Remove the borrow tag
//                    updatedLines.add(line.replaceFirst("\\(Borrowed:.*\\)", "").trim());
//                } else {
//                    updatedLines.add(line); // Keep unchanged lines
//                }
//            }
//
//            if (!isBorrowed) {
//                JOptionPane.showMessageDialog(null, "This book is not borrowed and cannot be returned.");
//                return; // Exit method if the book is not borrowed
//            }
//
//            // Write updated lines back to the file
//            Files.write(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"), updatedLines);
//            JOptionPane.showMessageDialog(null, "You have successfully returned the book: " + book);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Calculate fine based on overdue days
//    private int calculateFine(long overdueDays) {
//        int finePerDay = 10; // Fine amount per day
//        return (int) (overdueDays * finePerDay);
//    }
//}




//LibrarianFile.java
package com.OOP.project.Book_Nest.category;
import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LibrarianFile {

    private static final String FILE_PATH = "C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final int BORROW_DURATION_DAYS = 7; // Maximum borrow duration before fine

    // Get books by category
    public List<String> getBooksByCategory(String category) {
        List<String> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= 2 && parts[0].equals(category)) {
                    books.add(parts[1].split("\\(")[0].trim()); // Add book name without status
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }



    // Borrow a book
    public boolean borrowBook(String book) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"));
            List<String> updatedLines = new ArrayList<>();
            boolean bookAlreadyBorrowed = false;
            boolean bookOverdue = false;
            long overdueDays = 0;

            for (String line : lines) {
                if (line.contains(book) && line.contains("(Borrowed:")) {
                    bookAlreadyBorrowed = true;

                    // Check if the book is overdue
                    String borrowDateStr = line.substring(line.indexOf("(Borrowed:") + 10, line.indexOf(")"));
                    LocalDate borrowDate = LocalDate.parse(borrowDateStr, DATE_FORMATTER);
                    LocalDate currentDate = LocalDate.now();
                    long daysBorrowed = java.time.temporal.ChronoUnit.DAYS.between(borrowDate, currentDate);

                    if (daysBorrowed > BORROW_DURATION_DAYS) {
                        bookOverdue = true;
                        overdueDays = daysBorrowed - BORROW_DURATION_DAYS;
                    }
                    updatedLines.add(line); // Keep the line as is
                } else if (line.contains(book)) {
                    updatedLines.add(line); // Keep the line as is
                } else {
                    updatedLines.add(line); // Add unchanged lines
                }
            }

            if (bookOverdue) {
                int fine = calculateFine(overdueDays);
                int response = JOptionPane.showConfirmDialog(null,
                        "This book is overdue by " + overdueDays + " days. Fine: Rs. " + fine + ". Pay now?",
                        "Fine Payment",
                        JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    // Allow borrowing after fine payment
                    List<String> finalUpdatedLines = new ArrayList<>();
                    for (String line : updatedLines) {
                        if (line.contains(book) && !line.contains("(Borrowed)")) {
                            String newLine = line + " (Borrowed:" + LocalDate.now().format(DATE_FORMATTER) + ")";
                            finalUpdatedLines.add(newLine); // Add borrow date
                        } else {
                            finalUpdatedLines.add(line); // Keep unchanged lines
                        }
                    }
                    Files.write(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"), finalUpdatedLines);
                    return true;
                } else {
                    return false; // Borrowing canceled if fine not paid
                }
            }

            if (bookAlreadyBorrowed) {
                JOptionPane.showMessageDialog(null, "Sorry, this book is already borrowed.");
                return false;
            }

            // Update the book entry to borrowed status
            List<String> finalUpdatedLines = new ArrayList<>();
            for (String line : updatedLines) {
                if (line.contains(book) && !line.contains("(Borrowed)")) {
                    String newLine = line + " (Borrowed:" + LocalDate.now().format(DATE_FORMATTER) + ")";
                    finalUpdatedLines.add(newLine); // Add borrow date
                } else {
                    finalUpdatedLines.add(line); // Keep unchanged lines
                }
            }

            Files.write(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"), finalUpdatedLines);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    // Return a book
    public void returnBook(String book) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"));
            List<String> updatedLines = new ArrayList<>();

            for (String line : lines) {
                if (line.contains(book) && line.contains("(Borrowed:")) {
                    String borrowDateStr = line.substring(line.indexOf("(Borrowed:") + 10, line.indexOf(")"));
                    LocalDate borrowDate = LocalDate.parse(borrowDateStr, DATE_FORMATTER);
                    LocalDate currentDate = LocalDate.now();

                    // Check if the book is overdue
                    long daysBorrowed = java.time.temporal.ChronoUnit.DAYS.between(borrowDate, currentDate);
                    if (daysBorrowed > BORROW_DURATION_DAYS) {
                        int fine = calculateFine(daysBorrowed - BORROW_DURATION_DAYS);
                        JOptionPane.showMessageDialog(null, "This book is overdue by " + (daysBorrowed - BORROW_DURATION_DAYS)
                                + " days. You need to pay a fine of Rs. " + fine);
                    }

                    // Remove the borrow tag
                    updatedLines.add(line.replaceFirst("\\(Borrowed:.*\\)", "").trim());
                } else {
                    updatedLines.add(line);
                }
            }

            Files.write(Paths.get("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\booksData.txt"), updatedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Calculate fine based on overdue days
    private int calculateFine(long overdueDays) {
        int finePerDay = 50; // Fine amount per day
        return (int) (overdueDays * finePerDay);
    }
}

