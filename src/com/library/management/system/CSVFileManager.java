package com.library.management.system;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class CSVFileManager {
    private String filePath;

    public void createNewFile(String fileName) {
        this.filePath = "src/com/library/management/system/" + fileName;
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

    public List<Book> readBookData(String filePath) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/com/library/management/system/" + filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Book book = new Book();
                book.setId(values[0]);
                book.setTitle(values[1]);
                book.setAuthor(values[2]);
                book.setGenre(values[3]);
                book.setIsbn(values[4]);
                book.setAvailable(Boolean.parseBoolean(values[5]));
                if (values.length > 6) {
                    book.setBorrowerId(values[6]);
                }
                books.add(book);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return books;
    }
    
    public List<Book> readBookData(String filePath, boolean isAvailable) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/com/library/management/system/" + filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // Check if the book is available based on the provided condition
                boolean available = Boolean.parseBoolean(values[5]);
                if (available == isAvailable) {
                    Book book = new Book();
                    book.setId(values[0]);
                    book.setTitle(values[1]);
                    book.setAuthor(values[2]);
                    book.setGenre(values[3]);
                    book.setIsbn(values[4]);
                    book.setAvailable(available);
                    if (values.length > 6) {
                        book.setBorrowerId(values[6]);
                    }
                    books.add(book);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return books;
    }

    public void writeData(List<Book> books) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/library/management/system/Books.csv"))) {
            for (Book book : books) {
                StringBuilder sb = new StringBuilder();
                sb.append(book.getId()).append(",")
                        .append(book.getTitle()).append(",")
                        .append(book.getAuthor()).append(",")
                        .append(book.getGenre()).append(",")
                        .append(book.getIsbn()).append(",")
                        .append(book.isAvailable()).append(",")
                        .append(book.getBorrowerId());
                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void addBook(Book book) {
        List<Book> books = readBookData("Books.csv");
        if (books != null) {
            books.add(book);
            writeData(books);
        }
    }

    public void updateBook(String id, Book updatedBook) {
        List<Book> books = readBookData("Books.csv");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                books.set(i, updatedBook);
                writeData(books);
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    public boolean validateFile() {
        File file = new File(filePath);
        return file.exists() && !file.isDirectory();
    }

    public List<Member> readMemberData(String filePath) {
        List<Member> members = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/com/library/management/system/" + filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Member member = new Member();
                member.setId(values[0]);
                member.setName(values[1]);
                member.setEmail(values[2]);
                member.setMembershipStatus(values[3]);
                members.add(member);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return members;
    }
    
    public List<Object[]> getMemberNamesAndIds() {
        List<Object[]> memberNamesAndIds = new ArrayList<>();
        // Read member data from file
        List<Member> members = readMemberData("Members.csv");
        // Extract member names and IDs from the list of members
        for (Member member : members) {
            memberNamesAndIds.add(new Object[]{member.getName(), member.getId()});
        }
        return memberNamesAndIds;
    }

    public void writeMemberData(List<Member> members) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/library/management/system/Members.csv"))) {
            for (Member member : members) {
                StringBuilder sb = new StringBuilder();
                sb.append(member.getId()).append(",")
	                .append(member.getName()).append(",")
	                .append(member.getEmail()).append(",")
	                .append(member.getMembershipStatus());
                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void addMember(Member member) {
        List<Member> members = readMemberData("Members.csv");
        if (member != null) {
            members.add(member);
            writeMemberData(members);
        }
    }
}

