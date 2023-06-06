import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean availability) {
        isAvailable = availability;
    }

    @Override
    public String toString() {
        String availability = isAvailable ? "Available" : "Not Available";
        return "Title: " + title + ", Author: " + author + ", Availability: " + availability;
    }
}

class Member {
    private String name;
    private int id;

    public Member(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}

class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Member searchMember(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Member> getAllMembers() {
        return members;
    }

    public void issueBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.setAvailability(false);
            System.out.println("Book \"" + book.getTitle() + "\" has been issued to " + member.getName());
        } else {
            System.out.println("Book \"" + book.getTitle() + "\" is not available");
        }
    }

    public void returnBook(Book book) {
        book.setAvailability(true);
        System.out.println("Book \"" + book.getTitle() + "\" has been returned");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Add members
        Member member1 = new Member("John Doe", 123);
        Member member2 = new Member("Jane Smith", 456);

        library.addMember(member1);
        library.addMember(member2);

        // Search book
        String searchTitle = "To Kill a Mockingbird";
        Book foundBook = library.searchBook(searchTitle);
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book \"" + searchTitle + "\" not found");
        }

        // Search member
        int searchId = 123;
        Member foundMember = library.searchMember(searchId);
        if (foundMember != null) {
            System.out.println("Member found: " + foundMember);
        } else {
            System.out.println("Member with ID " + searchId + " not found");
        }

        // View all books
        System.out.println("All books:");
        List<Book> allBooks = library.getAllBooks();
        for (Book book : allBooks) {
            System.out.println(book);
        }

        // View all members
        System.out.println("All members:");
        List<Member> allMembers = library.getAllMembers();
        for (Member member : allMembers) {
            System.out.println(member);
        }

        // Issue book
        Book bookToIssue = book2;
        library.issueBook(bookToIssue, member1);

        // Return book
        Book bookToReturn = book2;
        library.returnBook(bookToReturn);
    }
}
