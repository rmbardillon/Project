
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Main {
	
	static final long serialVersionUID = 1L;
	
	static Main mainWindow;
	static JFrame frameMainMenu;
	static JButton btnreturnMainMenu;
	static JButton btnClear;
	static JTextArea txtArea;
	static JButton btnBack;
	static JScrollPane scroll;
	static JLabel lblNewLabel_3;
	static JPanel contentPane;
	
	static JTextField txtBookTitle;
	static JTextField txtBookAuthor;
	static JTextField txtBookISBN;
	static JTextField txtBookGenre;
	static JLabel lblBookTitle;
	static JLabel lblBookAuthor;
	static JLabel lblBookISBN;
	static JLabel lblBookGenre;
	static JButton btnAddBook;
	
	static JTextField txtMemberName;
	static JTextField txtMemberID;
	static JTextField txtMemberContact;
	static JLabel lblMemberName;
	static JLabel lblMemberID;
	static JLabel lblSelectMember;
	
	
	static ArrayList<String> staffName = new ArrayList<>();
	static ArrayList<String> staffPass = new ArrayList<>();
	
	static ArrayList<String> bookTitle = new ArrayList<>();
	static ArrayList<String> bookAuthor = new ArrayList<>();
	static ArrayList<String> bookISBN = new ArrayList<>();
	static ArrayList<String> bookGenre = new ArrayList<>();
	static ArrayList<Boolean> bookAvailable = new ArrayList<>();
	
	static ArrayList<String> memberName = new ArrayList<>();
	static ArrayList<String> memberID = new ArrayList<>();
	static ArrayList<String> memberContact = new ArrayList<>();
	static ArrayList<Boolean> membershipStatus = new ArrayList<>();

	static int id = memberID.size()+1;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow = new Main();
					frameMainMenu.setVisible(true);
					frameMainMenu.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main() {
		initialize();
	}

	static void initialize() {
		frameMainMenu = new JFrame();
		frameMainMenu.setBackground(Color.WHITE);
		frameMainMenu.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameMainMenu.setTitle("Library Management System");
		frameMainMenu.setResizable(false);
		frameMainMenu.setBounds(100, 100, 400, 300);
		frameMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMainMenu.getContentPane().setLayout(null);
		frameMainMenu.setVisible(true);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu.setBounds(146, 35, 92, 14);
		frameMainMenu.getContentPane().add(lblMainMenu);
		
		JButton btnSearchBorrow = new JButton("Search / Borrow Book");
		btnSearchBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        borrowBookPanel();
			}
		});
		btnSearchBorrow.setForeground(Color.WHITE);
		btnSearchBorrow.setBackground(new Color(102, 204, 204));
		btnSearchBorrow.setBounds(107, 84, 169, 23);
		frameMainMenu.getContentPane().add(btnSearchBorrow);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBookPanel();
			}
		});
		btnReturnBook.setForeground(Color.WHITE);
		btnReturnBook.setBackground(new Color(102, 204, 204));
		btnReturnBook.setBounds(107, 142, 169, 23);
		frameMainMenu.getContentPane().add(btnReturnBook);
		
		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMemberPanel();
			}
		});
		btnAddMember.setForeground(Color.WHITE);
		btnAddMember.setBackground(new Color(102, 204, 204));
		btnAddMember.setBounds(107, 200, 169, 23);
		frameMainMenu.getContentPane().add(btnAddMember);
		
	}
	
	static void borrowBookPanel() {
		 	frameMainMenu.setBounds(100, 100, 769, 423);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(192, 192, 192));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        frameMainMenu.setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        JLabel brrwLabel = new JLabel("Search / Borrow Book");
	        brrwLabel.setBounds(20, -30, 300, 100 );
	        contentPane.add(brrwLabel);
	        
	        lblBookTitle = new JLabel("Book Name:");
	        lblBookTitle.setForeground(new Color(0, 0, 0));
	        lblBookTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
	        lblBookTitle.setBounds(10, 30, 142, 38);
	        contentPane.add(lblBookTitle);
	        
	        txtBookTitle = new JTextField();
	        txtBookTitle.setBounds(99, 30, 457, 38);
	        contentPane.add(txtBookTitle);
	        
	        JLabel lblAuthor = new JLabel("Author:");
	        lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 11));
	        lblAuthor.setBounds(10, 79, 142, 38);
	        contentPane.add(lblAuthor);
	        
	        txtBookAuthor = new JTextField();
	        txtBookAuthor.setColumns(10);
	        txtBookAuthor.setBounds(99, 79, 457, 38);
	        contentPane.add(txtBookAuthor);
	        
	        JLabel lblIsbn = new JLabel("ISBN:");
	        lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 11));
	        lblIsbn.setBounds(10, 128, 142, 38);
	        contentPane.add(lblIsbn);
	        
	        txtBookISBN = new JTextField();
	        txtBookISBN.setColumns(10);
	        txtBookISBN.setBounds(99, 128, 457, 38);
	        contentPane.add(txtBookISBN);
	        
	        JLabel lblGenre = new JLabel("Genre:");
	        lblGenre.setFont(new Font("Tahoma", Font.BOLD, 11));
	        lblGenre.setBounds(10, 177, 142, 38);
	        contentPane.add(lblGenre);
	        
	        txtBookGenre = new JTextField();
	        txtBookGenre.setColumns(10);
	        txtBookGenre.setBounds(99, 177, 457, 38);
	        contentPane.add(txtBookGenre);
	        
	        JButton btnBorrow = new JButton("Borrow");
	        btnBorrow.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnBorrow.setBounds(595, 269, 145, 38);
	        contentPane.add(btnBorrow);
	        btnBorrow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectMember();
				}
			});
	        
	        JButton btnSearch = new JButton("Search");
	        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnSearch.setBounds(595, 112, 145, 38);
	        btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchBooks(txtBookTitle.getText(), txtBookAuthor.getText(), txtBookISBN.getText(), txtBookGenre.getText());
				}
			});
	        contentPane.add(btnSearch);
	        
	        txtArea = new JTextArea("Genre \tISBN \t Title \t\t Author\n");
	        txtArea.setEditable(false);
			scroll = new JScrollPane(txtArea);
			scroll.setBounds(99, 241, 457, 102);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			contentPane.add(scroll);
	        
	        btnAddBook = new JButton("Add Book");
	        btnAddBook.setBounds(595, 20, 145, 38);
	        contentPane.add(btnAddBook);
	        btnAddBook.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		addBookPanel();
	        	}
	        });
	        
	        btnreturnMainMenu = new JButton("Return to Main Menu");
	        btnreturnMainMenu.setBounds(10, 350, 152, 23);
	        contentPane.add(btnreturnMainMenu);
	        btnreturnMainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frameMainMenu.setVisible(false);
					initialize();
					frameMainMenu.setLocationRelativeTo(null);
				}
			});
	        
	        frameMainMenu.setLocationRelativeTo(null);
	        
	}

	static void returnBookPanel() {
		frameMainMenu.setResizable(false);
		frameMainMenu.setTitle("Return Book");
		frameMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMainMenu.setBounds(100, 100, 712, 437);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frameMainMenu.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBookTitle = new JTextField();
		txtBookTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtBookTitle.setHorizontalAlignment(SwingConstants.LEFT);
		txtBookTitle.setBounds(214, 27, 452, 33);
		contentPane.add(txtBookTitle);
		txtBookTitle.setColumns(10);
		
		txtBookAuthor = new JTextField();
		txtBookAuthor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtBookAuthor.setHorizontalAlignment(SwingConstants.LEFT);
		txtBookAuthor.setColumns(10);
		txtBookAuthor.setBounds(214, 72, 452, 33);
		contentPane.add(txtBookAuthor);
		
		txtBookISBN = new JTextField();
		txtBookISBN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtBookISBN.setHorizontalAlignment(SwingConstants.LEFT);
		txtBookISBN.setColumns(10);
		txtBookISBN.setBounds(214, 117, 452, 33);
		contentPane.add(txtBookISBN);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(234, 206, 134, 33);
		contentPane.add(btnNewButton);
		
		txtBookGenre = new JTextField();
		txtBookGenre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtBookGenre.setHorizontalAlignment(SwingConstants.LEFT);
		txtBookGenre.setColumns(10);
		txtBookGenre.setBounds(214, 162, 452, 33);
		contentPane.add(txtBookGenre);
		
		lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookTitle.setBounds(79, 27, 111, 33);
		contentPane.add(lblBookTitle);
		
		lblBookAuthor = new JLabel("Author Name:");
		lblBookAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookAuthor.setBounds(79, 72, 111, 33);
		contentPane.add(lblBookAuthor);
		
		lblBookISBN = new JLabel("ISBN:");
		lblBookISBN.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookISBN.setBounds(79, 117, 111, 33);
		contentPane.add(lblBookISBN);
		
		lblBookGenre = new JLabel("Genre:");
		lblBookGenre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookGenre.setBounds(79, 162, 111, 33);
		contentPane.add(lblBookGenre);
		
		btnClear= new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBookTitle.setText("");
				txtBookAuthor.setText("");
				txtBookISBN.setText("");
				txtBookGenre.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(511, 206, 134, 33);
		contentPane.add(btnClear);

		txtArea = new JTextArea("Genre \tISBN \t Title \t\t Author\n");
		txtArea.setEditable(false);
		txtArea.setTabSize(10);
		scroll = new JScrollPane(txtArea);
		scroll.setBounds(214, 249, 452, 141);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);

		
		 btnreturnMainMenu = new JButton("Return to Main Menu");
		 btnreturnMainMenu.setBounds(10, 367, 152, 23);
	     contentPane.add(btnreturnMainMenu);
	        btnreturnMainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frameMainMenu.setVisible(false);
					initialize();
					frameMainMenu.setLocationRelativeTo(null);
				}
			});
		
		 frameMainMenu.setLocationRelativeTo(null);
	}
	
	static void addMemberPanel() {
		frameMainMenu.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frameMainMenu.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setBounds(54, 79, 58, 26);
		contentPane.add(lblName);
		
		JLabel lblMemInfo = new JLabel("MEMBERS INFORMATION");
		lblMemInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemInfo.setFont(new Font("Showcard Gothic", Font.PLAIN, 27));
		lblMemInfo.setBounds(10, 10, 416, 59);
		contentPane.add(lblMemInfo);
		
		txtMemberName = new JTextField();
		txtMemberName.setBounds(112, 78, 277, 29);
		contentPane.add(txtMemberName);
		txtMemberName.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(54, 115, 58, 26);
		contentPane.add(lblId);
		
		JLabel lblContact = new JLabel("CONTACT:");
		lblContact.setBounds(54, 151, 58, 26);
		contentPane.add(lblContact);
		
		txtMemberID = new JTextField();
		txtMemberID.setColumns(10);
		txtMemberID.setBounds(112, 115, 277, 29);
		txtMemberID.setText(Integer.toString(memberID.size()+1));
		txtMemberID.setEditable(false);
		contentPane.add(txtMemberID);
		
		txtMemberContact = new JTextField();
		txtMemberContact.setColumns(10);
		txtMemberContact.setBounds(112, 151, 277, 29);
		contentPane.add(txtMemberContact);
		
		JButton btnSubmit = new JButton("Add Member");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkAddMemberTextFields(txtMemberName.getText(), txtMemberID.getText(), txtMemberContact.getText())) {
					 JOptionPane.showMessageDialog(null,"Please enter all required information. Thank you!");
				} else {
					addMember(txtMemberName.getText(), txtMemberID.getText(), txtMemberContact.getText());
					txtMemberName.setText("");
					txtMemberID.setText(Integer.toString(memberID.size()+1));
					txtMemberContact.setText("");
				}
			}
		});
		
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSubmit.setBounds(257, 190, 120, 20);
		contentPane.add(btnSubmit);
		
		btnreturnMainMenu = new JButton("Return to Main Menu");
        btnreturnMainMenu.setBounds(10, 230, 152, 23);
        contentPane.add(btnreturnMainMenu);
        btnreturnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMainMenu.setVisible(false);
				initialize();
				frameMainMenu.setLocationRelativeTo(null);
			}
		});
		frameMainMenu.setLocationRelativeTo(null);
	}
	
	static void addBookPanel() {
		frameMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMainMenu.setBounds(100, 100, 400, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frameMainMenu.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 12, 63, 20);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowBookPanel();
			}
		});
		
		txtBookTitle = new JTextField();
		txtBookTitle.setBounds(98, 72, 234, 20);
		contentPane.add(txtBookTitle);
		txtBookTitle.setColumns(10);
		
		lblBookTitle = new JLabel("Title");
		lblBookTitle.setBounds(59, 75, 46, 14);
		contentPane.add(lblBookTitle);
		
		lblBookAuthor = new JLabel("Author");
		lblBookAuthor.setBounds(59, 100, 46, 14);
		contentPane.add(lblBookAuthor);
		
		txtBookAuthor = new JTextField();
		txtBookAuthor.setBounds(98, 97, 234, 20);
		contentPane.add(txtBookAuthor);
		txtBookTitle.setColumns(10);
		
		txtBookISBN = new JTextField();
		txtBookISBN.setBounds(98, 123, 234, 20);
		contentPane.add(txtBookISBN);
		txtBookISBN.setColumns(10);
		
		txtBookGenre = new JTextField();
		txtBookGenre.setBounds(98, 147, 234, 20);
		contentPane.add(txtBookGenre);
		txtBookGenre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ISBN");
		lblNewLabel_2.setBounds(59, 125, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Genre");
		lblNewLabel_3.setBounds(59, 150, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Add Book");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(127, 29, 129, 20);
		contentPane.add(lblNewLabel_4);
		
		JButton btnAddBook = new JButton("Add");
		btnAddBook.setBounds(147, 178, 89, 23);
		contentPane.add(btnAddBook);
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBookTextFields(txtBookTitle.getText(), txtBookTitle.getText(), txtBookISBN.getText(), txtBookGenre.getText())) {
					JOptionPane.showMessageDialog(null,"Please enter all required information. Thank you!");
				} else {
					addBook(txtBookTitle.getText(), txtBookAuthor.getText(), txtBookISBN.getText(), txtBookGenre.getText());
					txtBookTitle.setText("");
					txtBookAuthor.setText("");
					txtBookISBN.setText("");
					txtBookGenre.setText("");
				}
			}
		});
		
		frameMainMenu.setLocationRelativeTo(null);
		
	}
	
	public static void selectMember() {
		frameMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMainMenu.setBounds(100, 100, 495, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frameMainMenu.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 12, 63, 20);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowBookPanel();
			}
		});
		
		txtMemberName = new JTextField();
		txtMemberName.setBounds(170, 63, 230, 25);
		contentPane.add(txtMemberName);
		txtMemberName.setColumns(10);
		
		JLabel lblMemberName = new JLabel("Member Name:");
		lblMemberName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMemberName.setBounds(63, 55, 97, 36);
		contentPane.add(lblMemberName);
		
		lblMemberID = new JLabel("Member ID:");
		lblMemberID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMemberID.setBounds(84, 89, 97, 36);
		contentPane.add(lblMemberID);
		
		txtMemberID = new JTextField();
		txtMemberID.setBounds(170, 99, 86, 20);
		contentPane.add(txtMemberID);
		txtMemberID.setColumns(10);
		
		lblSelectMember = new JLabel("Select Member");
		lblSelectMember.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectMember.setBounds(100, 11, 279, 25);
		contentPane.add(lblSelectMember);
		
		JButton btnAssignBook = new JButton("Assign Book");
		btnAssignBook.setBounds(191, 129, 126, 23);
		contentPane.add(btnAssignBook);
		btnAssignBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowBookPanel();
			}
		});
		
		JTextArea textArea = new JTextArea(" ID  \t  Member Name\n");
		textArea.setEditable(false);
		scroll = new JScrollPane(textArea);
		scroll.setBounds(45, 163, 388, 167);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		for (int index = 0; index < memberName.size(); index++) {
			textArea.append(memberID.get(index) + " \t " + memberName.get(index) + "\n");
		}
		frameMainMenu.setLocationRelativeTo(null);
	}
	
	static void searchBooks(String title, String author, String ISBN, String genre) {
	    txtArea.setText("Genre \tISBN \tTitle \t\tAuthor\n"); // Clear the text area before displaying new results

	    // Iterate through the books list to search for matching books
	    for (int iterate = 0; iterate < bookTitle.size(); iterate++) {
	        String currentTitle = bookTitle.get(iterate);
	        String currentAuthor = bookAuthor.get(iterate);
	        String currentISBN = bookISBN.get(iterate);
	        String currentGenre = bookGenre.get(iterate);

	        // Check if the current book matches the search criteria
	        if (currentTitle.toLowerCase().contains(title.toLowerCase()) ||
	            currentAuthor.toLowerCase().contains(author.toLowerCase()) ||
	            currentISBN.toLowerCase().contains(ISBN.toLowerCase()) ||
	            currentGenre.toLowerCase().contains(genre.toLowerCase())) {
	            txtArea.append(currentGenre + "\t" + currentISBN + "\t" + currentTitle + "\t\t" + currentAuthor + "\n");
	        }
	    }
	}
	
	static void addBook(String title, String author, String ISBN, String genre) {
		bookTitle.add(title);
		bookAuthor.add(author);
		bookISBN.add(ISBN);
		bookGenre.add(genre);
	}
	
	public static void addMember(String name, String ID, String contact) {
		memberName.add(name);
		memberID.add(ID);
		memberContact.add(contact);
	}
	
	public static boolean checkBookTextFields(String title, String author, String ISBN, String genre) {
		if (title.isEmpty()) {
			txtBookTitle.requestFocus();
			return true;
		}
		if (author.isEmpty()) {
			txtBookTitle.requestFocus();
			return true;
		}
		if (ISBN.isEmpty()) {
			txtBookISBN.requestFocus();
			return true;
		}
		if (genre.isEmpty()) {
			txtBookGenre.requestFocus();
			return true;
		}
		return false;
	}
	
	public static boolean checkAddMemberTextFields(String name, String ID, String contact) {
		if (name.isEmpty()) {
			txtMemberName.requestFocus();
			return true;
		}
		if (contact.isEmpty()) {
			txtMemberContact.requestFocus();
			return true;
		}
		return false;
	}
}
