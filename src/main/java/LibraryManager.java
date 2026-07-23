public class LibraryManager {

    public static void main(String[] args) {

        //Step 4: Creating Book[] array with many EBooks
        EBook ebook1 = new EBook("The Great Gatsby", "F. Scott Fitzgerald", 2.5);
        EBook ebook2 = new EBook("1984", "George Orwell", 1);
        EBook ebook3 = new EBook("To Kill a Mockingbird", "Harper Lee", 3);
        EBook ebook4 = new EBook("The Catcher in the Rye", "J.D. Salinger", 2);

        Book[] bookArr = new Book[4];
        bookArr[0] = ebook1;
        bookArr[1] = ebook2;
        bookArr[2] = ebook3;
        bookArr[3] = ebook4;
        System.out.println(ebook1);

        //Loop and borrow each item
        for (Book b : bookArr) {
            if (b instanceof Borrowable book) {
                book.borrowItem();
            }
        }

        //Loop and return each item
        for (Book b: bookArr) {
            if (b instanceof Borrowable book) {
                book.returnItem();
            }
        }


    }
}
