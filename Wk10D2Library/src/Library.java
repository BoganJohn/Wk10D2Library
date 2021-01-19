import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class

    String libraryAddresses;

    ArrayList<Books> books;

    public Library (String address){
        libraryAddresses = address;
        books = new ArrayList<>();
    }

    public void addBook(Books book){
        books.add(book);
    }

    public static void printOpeningHours(){
        System.out.println(" All libraries open 9am to 5pm daily. ");
    }

    public void printAddress (){
        System.out.println(libraryAddresses);
    }

    public void borrowBook(String bookTitle ){
        Books libraryBook;
        String libraryBookTitle;

        for (Books book : books) {
            libraryBook = book;
            libraryBookTitle = libraryBook.getTitle();

            if (libraryBookTitle.equals(bookTitle)) {

                if (!(libraryBook.isBorrowed())) {
                    libraryBook.borrowed();
                    System.out.println("You successfully borrowed" + libraryBookTitle);
                } else {
                    System.out.println("Sorry! This book is already borrowed");
                }
            }
        }
        System.out.println("Your book was not found in the library catalog");
    }

    public void printAvailableBooks(){
        Books libraryBook;
        boolean libraryIsEmpty = true;

        for (Books book : books) {
            libraryBook = book;

            if (!(libraryBook.isBorrowed())) {
                System.out.println(libraryBook.getTitle());
                libraryIsEmpty = false;
            }
        }
        if(libraryIsEmpty){
            System.out.println("No books in catalog");
        }
    }

    public void returnBook( String bookTitle){
        Books libraryBook;
        boolean found = false;
        String libraryBookTitle;

        for (Books book : books) {
            libraryBook = book;
            libraryBookTitle = libraryBook.getTitle();

            if (libraryBookTitle.equals(bookTitle)) {

                if (libraryBook.isBorrowed()) {
                    libraryBook.returned();
                    System.out.println("You successfully returned: " + libraryBookTitle);
                    found = true;
                    break;
                }
            }

        }
        if(!found){
            System.out.println("Your book was not found in the library catalog");
        }
    }



    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Books("The Da Vinci Code"));
        firstLibrary.addBook(new Books("Le Petite Prince"));
        firstLibrary.addBook(new Books("A Tale of Two Cities"));
        firstLibrary.addBook(new Books("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 