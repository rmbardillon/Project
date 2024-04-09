package com.library.management.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.CardLayout;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;
	private JPanel contentPane;
	public static JTable membersTable;
	public static JTable booksTable;
	public static JTable borrowedBooksTable;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField titleTextField;
	private JTextField authorTextField;
	private JTextField genreTextField;
	private JTextField isbnTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard("username");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
     * Switch Panels
     */
    public void switchPanels(JPanel panel) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.revalidate();
    }

	/**
	 * Create the frame.
	 */
	public Dashboard(String username) {
		JPanel tabPanel = new JPanel();
		JPanel headerPanel = new JPanel();
		JPanel addMemberPanel = new JPanel();
		JPanel addBookPanel = new JPanel();
		JPanel borrowedBooksPanel = new JPanel();
		JPanel booksPanel = new JPanel();
		JPanel membersPanel = new JPanel();
		JPanel memberTablePanel = new JPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(812, 497); // Set the size of the frame
		setLocationRelativeTo(null); // Center the frame on the screen
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Header Panel
		headerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerPanel.setLayout(null);
		headerPanel.setBounds(0, 0, 796, 38);
		contentPane.add(headerPanel);
		
		JLabel lblNewLabel = new JLabel("Welcome " + username);
		lblNewLabel.setBounds(10, 11, 153, 14);
		headerPanel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Logout Successful");
				dispose();
				new Login().setVisible(true);
			}
		});
		btnNewButton.setBounds(687, 7, 89, 23);
		headerPanel.add(btnNewButton);
		
		layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 34, 796, 413);
        contentPane.add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));
        
        //Add Panel to layer
        layeredPane.add(tabPanel, "name_17638472223100");
        layeredPane.add(addMemberPanel, "name_4955119067200");
		layeredPane.add(addBookPanel, "name_19629355443100");

        //Add Member Panel
		addMemberPanel.setLayout(null);
		addMemberPanel.setBounds(5, 26, 786, 427);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(291, 93, 61, 22);
		addMemberPanel.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(357, 93, 144, 22);
		addMemberPanel.add(nameTextField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(291, 126, 61, 22);
		addMemberPanel.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(357, 126, 144, 22);
		addMemberPanel.add(emailTextField);
		
		JLabel addMemberLabel = new JLabel("Add Member");
		addMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addMemberLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		addMemberLabel.setBounds(291, 52, 210, 30);
		addMemberPanel.add(addMemberLabel);
		
		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = generate16CharUUID();
				String name = nameTextField.getText();
				String email = emailTextField.getText();
				String membershipStatus = "Active";
				Member newMember = new Member(id, name, email, membershipStatus);
				CSVFileManager csvFileManager = new CSVFileManager();
				csvFileManager.createNewFile("Members.csv");
				csvFileManager.addMember(newMember);
				JOptionPane.showMessageDialog(null, "Add Member successful");
				getMembersData();
				switchPanels(tabPanel);
			}
		});
		btnAddMember.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddMember.setBounds(357, 159, 144, 34);
		addMemberPanel.add(btnAddMember);
		
		JButton addMemberCancelBtn = new JButton("Cancel");
		addMemberCancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(tabPanel);
			}
		});
		addMemberCancelBtn.setForeground(Color.WHITE);
		addMemberCancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addMemberCancelBtn.setBackground(Color.RED);
		addMemberCancelBtn.setBounds(268, 166, 84, 23);
		addMemberPanel.add(addMemberCancelBtn);
		
		// Tab Panel
        tabPanel.setLayout(null);
		tabPanel.setBounds(0, 0, 796, 447);
		
		//Tab Pane
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 796, 402);
		tabPanel.add(tabbedPane);
		
		//Members Panel
		tabbedPane.addTab("Members", null, membersPanel, null);
		membersPanel.setLayout(null);
		
		JScrollPane memberScrollPane = new JScrollPane();
		memberScrollPane.setBounds(31, 52, 719, 345);
		membersPanel.add(memberScrollPane);
		
		membersTable = new JTable();
		memberScrollPane.setViewportView(membersTable);
		membersTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Contact"
			}
		));
		
		JButton addMemberButton = new JButton("Add Member");
		addMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(addMemberPanel);
			}
		});
		addMemberButton.setBounds(637, 16, 113, 23);
		membersPanel.add(addMemberButton);
		
		memberTablePanel.setBounds(0, 0, 10, 10);
		membersPanel.add(memberTablePanel);
		
		JLabel membersLabelHeader = new JLabel("Members");
		membersLabelHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
		membersLabelHeader.setBounds(31, 11, 97, 30);
		membersPanel.add(membersLabelHeader);
		
		//Books Panel
		tabbedPane.addTab("Books", null, booksPanel, null);
		booksPanel.setLayout(null);
		
		JLabel booksLabelHeader = new JLabel("Books");
		booksLabelHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
		booksLabelHeader.setHorizontalAlignment(SwingConstants.CENTER);
		booksLabelHeader.setBounds(10, 11, 97, 30);
		booksPanel.add(booksLabelHeader);
		
		JScrollPane bookScrollPane = new JScrollPane();
		bookScrollPane.setBounds(31, 52, 719, 345);
		booksPanel.add(bookScrollPane);
		
		booksTable = new JTable();
		bookScrollPane.setViewportView(booksTable);
		booksTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Title", "Author", "Genre", "ISBN", "Status"
			}
		));
		
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(addBookPanel);
			}
		});
		btnAddBooks.setBounds(514, 18, 113, 23);
		booksPanel.add(btnAddBooks);
		
		JButton btnBorrowBooks = new JButton("Borrow Books");
		btnBorrowBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get list of members' names and IDs
			    List<Object[]> memberNamesAndIds = new CSVFileManager().getMemberNamesAndIds();

			    // Create an array to hold the string representation of each member
			    String[] memberStrings = new String[memberNamesAndIds.size()];

			    // Convert each member object array to a string representation
			    for (int i = 0; i < memberNamesAndIds.size(); i++) {
			        Object[] member = memberNamesAndIds.get(i);
			        memberStrings[i] = (String) member[0] + " (ID: " + (String) member[1] + ")";
			    }

			    // Show the input dialog with JComboBox
			    JComboBox<String> memberDropdown = new JComboBox<>(memberStrings);
			    int option = JOptionPane.showOptionDialog(
			            null, // Parent component
			            memberDropdown, // Message
			            "Select Member", // Title
			            JOptionPane.OK_CANCEL_OPTION, // Option type
			            JOptionPane.QUESTION_MESSAGE, // Message type
			            null, // Icon
			            null, // Options (use default options)
			            null // Initial value (use default)
			    );

			    // Check if OK button is clicked and a member is selected
			    if (option == JOptionPane.OK_OPTION && memberDropdown.getSelectedItem() != null) {
			        // Extract the selected member's ID from the string representation
			        String selectedMemberString = (String) memberDropdown.getSelectedItem();
			        String selectedMemberId = selectedMemberString.substring(selectedMemberString.lastIndexOf("(") + 4, selectedMemberString.lastIndexOf(")"));
			        int selectedBook = booksTable.getSelectedRow();
					// Check if a row is selected
			        if (selectedBook != -1) {
			            // Get the book details from the selected row
			            String bookId = (String) booksTable.getValueAt(selectedBook, 0);
			            String bookTitle = (String) booksTable.getValueAt(selectedBook, 1);
			            String bookAuthor = (String) booksTable.getValueAt(selectedBook, 2);
			            String bookGenre = (String) booksTable.getValueAt(selectedBook, 3);
			            String bookISBN= (String) booksTable.getValueAt(selectedBook, 4);
			            boolean isAvailable = false;
			            Book updatedBook = new Book(bookId, bookTitle, bookAuthor, bookGenre, bookISBN, isAvailable, selectedMemberId);
			            
			            new CSVFileManager().updateBook(bookId, updatedBook);
			            
			            // Show a success message to the user
			            JOptionPane.showMessageDialog(null, "Book '" + bookTitle + "' borrowed successfully.");
			            
			            getBorrowedBooksData();
			            getBooksData();
			            tabbedPane.setSelectedComponent(borrowedBooksPanel);
			        } else {
			            // If no row is selected, show an error message
			            JOptionPane.showMessageDialog(null, "Please select a book to borrow.");
			        }			        // Refresh the borrowed books data after borrowing
			    } else {
			        // If no member is selected or Cancel button is clicked, show an error message
			        JOptionPane.showMessageDialog(null, "Please select a member to borrow the book.");
			    }
			}
		});
		btnBorrowBooks.setBounds(637, 18, 113, 23);
		booksPanel.add(btnBorrowBooks);
		
		//Borrowed Books Panel
		tabbedPane.addTab("Borrowed Books", null, borrowedBooksPanel, null);
		borrowedBooksPanel.setLayout(null);

		JLabel borrowedBooksLabelHeader = new JLabel("Borrowed Books");
		borrowedBooksLabelHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
		borrowedBooksLabelHeader.setHorizontalAlignment(SwingConstants.CENTER);
		borrowedBooksLabelHeader.setBounds(10, 11, 150, 30);
		borrowedBooksPanel.add(borrowedBooksLabelHeader);

		JScrollPane borrowedBookScrollPane = new JScrollPane();
		borrowedBookScrollPane.setBounds(31, 52, 719, 345);
		borrowedBooksPanel.add(borrowedBookScrollPane);

		borrowedBooksTable = new JTable();
		borrowedBookScrollPane.setViewportView(borrowedBooksTable);
		borrowedBooksTable.setModel(new DefaultTableModel(
		    new Object[][] {
		    },
		    new String[] {
		        "ID", "Title", "Author", "Genre", "ISBN", "Borrower Id"
		    }
		));
		
		JButton btnReturnBooks = new JButton("Return Books");
		btnReturnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedBook = borrowedBooksTable.getSelectedRow();
				// Check if a row is selected
		        if (selectedBook != -1) {
		            // Get the book details from the selected row
		            String bookId = (String) borrowedBooksTable.getValueAt(selectedBook, 0);
		            String bookTitle = (String) borrowedBooksTable.getValueAt(selectedBook, 1);
		            String bookAuthor = (String) borrowedBooksTable.getValueAt(selectedBook, 2);
		            String bookGenre = (String) borrowedBooksTable.getValueAt(selectedBook, 3);
		            String bookISBN= (String) borrowedBooksTable.getValueAt(selectedBook, 4);
		            boolean isAvailable = true;
		            Book updatedBook = new Book(bookId, bookTitle, bookAuthor, bookGenre, bookISBN, isAvailable, "");
		            
		            new CSVFileManager().updateBook(bookId, updatedBook);
		            JOptionPane.showMessageDialog(null, "Book returned successfully");
		            getBorrowedBooksData();
		            getBooksData();
		            tabbedPane.setSelectedComponent(booksPanel);
		        } else {
		            // If no row is selected, show an error message
		            JOptionPane.showMessageDialog(null, "Please select a book to return.");
		        }
			}
		});
		btnReturnBooks.setBounds(637, 16, 113, 23);
		borrowedBooksPanel.add(btnReturnBooks);
		
		// Add Books Panel
		addBookPanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(291, 93, 61, 22);
		addBookPanel.add(lblTitle);
		
		titleTextField = new JTextField();
		titleTextField.setColumns(10);
		titleTextField.setBounds(357, 93, 144, 22);
		addBookPanel.add(titleTextField);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(291, 126, 61, 22);
		addBookPanel.add(lblAuthor);
		
		authorTextField = new JTextField();
		authorTextField.setColumns(10);
		authorTextField.setBounds(357, 126, 144, 22);
		addBookPanel.add(authorTextField);
		
		JLabel addMemberLabel_1 = new JLabel("Add Member");
		addMemberLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		addMemberLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		addMemberLabel_1.setBounds(291, 52, 210, 30);
		addBookPanel.add(addMemberLabel_1);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = generate16CharUUID();
				String title = titleTextField.getText();
				String author = authorTextField.getText();
				String genre = genreTextField.getText();
				String isbn = isbnTextField.getText();
				Boolean isAvailable = true;
				String borrowerId = "";
				Book newBook = new Book(id, title, author, genre, isbn, isAvailable, borrowerId);
				CSVFileManager csvFileManager = new CSVFileManager();
				csvFileManager.createNewFile("Books.csv");
				csvFileManager.addBook(newBook);
				JOptionPane.showMessageDialog(null, "Add Book successful");
				getBooksData();
				switchPanels(tabPanel);
			}
		});
		btnAddBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddBook.setBounds(357, 232, 144, 34);
		addBookPanel.add(btnAddBook);
		
		JButton addBookCancelBtn = new JButton("Cancel");
		addBookCancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(tabPanel);
			}
		});
		addBookCancelBtn.setForeground(Color.WHITE);
		addBookCancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addBookCancelBtn.setBackground(Color.RED);
		addBookCancelBtn.setBounds(268, 239, 84, 23);
		addBookPanel.add(addBookCancelBtn);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(291, 159, 61, 22);
		addBookPanel.add(lblGenre);
		
		genreTextField = new JTextField();
		genreTextField.setColumns(10);
		genreTextField.setBounds(357, 159, 144, 22);
		addBookPanel.add(genreTextField);
		
		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setBounds(291, 192, 61, 22);
		addBookPanel.add(lblISBN);
		
		isbnTextField = new JTextField();
		isbnTextField.setColumns(10);
		isbnTextField.setBounds(357, 192, 144, 22);
		addBookPanel.add(isbnTextField);
		
		getMembersData();
		getBooksData();
		getBorrowedBooksData();
	}
	
	public static void getMembersData() {
	    DefaultTableModel model = (DefaultTableModel) membersTable.getModel();
	    // Clear existing data in the table
	    model.setRowCount(0);
	    // Get member data from readMemberData() function
	    List<Member> members = new CSVFileManager().readMemberData("Members.csv");
	    // Add data to the table from the retrieved members list
	    for (Member member : members) {
	        model.addRow(new Object[]{member.getId(), member.getName(), member.getEmail()});
	    }
	}
	
	public static void getBooksData() {
	    DefaultTableModel model = (DefaultTableModel) booksTable.getModel();
	    // Clear existing data in the table
	    model.setRowCount(0);
	    // Get book data from readBooksData() function
	    List<Book> books = new CSVFileManager().readBookData("Books.csv", true);
	    // Add data to the table from the retrieved books list
	    for (Book book : books) {
	        model.addRow(new Object[]{book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getIsbn(), book.isAvailable()});
	    }
	}

	public static void getBorrowedBooksData() {
	    DefaultTableModel model = (DefaultTableModel) borrowedBooksTable.getModel();
	    // Clear existing data in the table
	    model.setRowCount(0);
	    // Get book data from readBooksData() function
	    List<Book> books = new CSVFileManager().readBookData("Books.csv", false);
	    // Add data to the table from the retrieved books list
	    for (Book book : books) {
	        model.addRow(new Object[]{book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getIsbn(), book.getBorrowerId()});
	    }
	}
	
	public static String generate16CharUUID() {
	    UUID uuid = UUID.randomUUID();
	    String fullUUID = uuid.toString();
	    // Remove hyphens
	    String sixteenCharUUID = fullUUID.replaceAll("-", "");
	    // Extract the first 16 characters
	    sixteenCharUUID = sixteenCharUUID.substring(0, 16);
	    return sixteenCharUUID;
	}
}
