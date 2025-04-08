import java.util.*;

class Book {
    private String title;
    private boolean borrowed;
    private int id;
    
    public Book(String title, int id){
        this.title = title;
        this.id = id;
        borrowed = false;
    }
    
    public void borrowBook(){
        if (!borrowed) {
            borrowed = true;
            System.out.println("You borrowed the book " + title);
        } else {
            System.out.println("This book is already borrowed");
        }
    }
    
    public void returnBook(){
        if (borrowed) {
            borrowed = false;
            System.out.println("You returned the book " + title);
        } else {
            System.out.println("This book is not borrowed and still available");
        }
    }
    
    public String getTitle(){
        return title;
    }
    
    public boolean isBorrowed(){
        return borrowed;
    }
    
    public int getID(){
        return id;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    int id;
    
    public void addBook(String title){
        Book bookWithID = new Book(title, id++);
        books.add(bookWithID);
        System.out.println("You added the book " + title + ", the id is " + bookWithID.getID());
    }
    
    public void borrowBook(String title){
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                if (!book.isBorrowed()){
                   book.borrowBook();
                   return;
                } else if (book.isBorrowed()) {
                   System.out.println("This book is already borrowed");
                   return;
                } else {
                   System.out.println("The book not found in the library");
                }
            }
        } 
    }
    
    public void returnBook(String title){
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                if (book.isBorrowed()) {
                    book.returnBook();
                    return;
                } else if (!book.isBorrowed()) {
                    System.out.println("This book is not borrowed and still available");
                    return;
                } else {
                    System.out.println("The book not found in the library");
                }
            }    
        }
    }
    
    public void displayAvailableBooks() {
        System.out.print("Available books are: ");
        int count = 0;
        for (Book book : books){
            if (!book.isBorrowed()) {
                System.out.println(book.getTitle() + "  " + book.getID());
                count++;
            }
        }   if (count == 0){
            System.out.println("There is no book available now");
        }
    }
    
    public void searchBook(String title){
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                System.out.println("The book " + book.getTitle() + ", ID is " + book.getID() + ", and borrow status is " + book.isBorrowed());
                return;
            } else {
                System.out.println("This book is not found in the library");
                return;
            }
        }
    }
}

public class Main{
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Library library = new Library();
    while (true) {
    System.out.println("1. Add new books");
    System.out.println("2. Borrow books");
    System.out.println("3. Return books");
    System.out.println("4. Display available books");
    System.out.println("5. Search book by title");
    System.out.println("6. Exit");
    System.out.println("Enter your choice");
    int menu = input.nextInt();
    input.nextLine();
    
    if (menu>=1&&menu<=5){
        switch (menu){
            case 1:
                System.out.print("Enter the book name: ");
                String bookAdd=input.nextLine();
                library.addBook(bookAdd);
                break;
            case 2:
                System.out.print("Enter the book name: ");
                String bookBorrow=input.nextLine();
                library.borrowBook(bookBorrow);
                break;
            case 3:
                System.out.print("Enter the book name: ");
                String bookReturn=input.nextLine();
                library.returnBook(bookReturn);
                break;
            case 4:
                library.displayAvailableBooks();
                break;
            case 5:
                System.out.print("Enter the book name: ");
                String bookSearch=input.nextLine();
                library.searchBook(bookSearch);
                break;
            case 6:
                System.out.println("System ends! Thank you!");
                input.close();
        }
    } else {
        throw new NumberFormatException("Choose option 1 to 6");
    }
}
}
}