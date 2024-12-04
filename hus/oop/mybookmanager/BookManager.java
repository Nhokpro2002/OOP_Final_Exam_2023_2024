package hus.oop.mybookmanager;

import java.util.ArrayList;

public class BookManager {
    private static BookManager instance;
    private MyList bookList;

    private BookManager() {
        /* TODO */
        bookList = new MyLinkedList();
    }

    public static BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public MyList getBookList() {
        /* TODO */
        return bookList;
    }

    /**
     * Thêm book vào đầu danh sách.
     * @param book
     */
    public void insertAtStart(Book book) {
        /* TODO */
        bookList.insertAtStart(book);
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void insertAtEnd(Book book) {
        /* TODO */
        bookList.insertAtEnd(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAPosition(Book book, int index) {
        /* TODO */
        bookList.insertAtPosition(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
       return (Book) bookList.get(index).data;
    }

    /**
     * Lấy ra sách có giá cao nhất.
     * @return
     */
    public Book highestPriceBook() {
        /* TODO */
        for (int i = 0; i < bookList.size() - 1; i++) {
            for (int j  = 0; j < bookList.size() - i - 1; j++) {
                if (bookAt(j).getPrice() < bookAt(j + 1).getPrice()) {
                    Book temp = bookAt(j);
                    bookList.set(bookAt(j + 1), j );
                    bookList.set(temp,j + 1);
                }
            }
        }
        return bookAt(0);
    }


    /**
     * Lấy ra sách có giá thấp nhất.
     * @return
     */
    public Book lowestPriceBook() {
       /* TODO */
        for (int i = 0; i < bookList.size() - 1; i++) {
            for (int j  = 0; j < bookList.size() - i - 1; j++) {
                if (bookAt(j).getPrice() > bookAt(j + 1).getPrice()) {
                    Book temp = bookAt(j);
                    bookList.set(bookAt(j + 1), j );
                    bookList.set(temp,j + 1);
                }
            }
        }
        return bookAt(0);
    }

    /**
     * Lấy ra sách có số trang cao nhất.
     * @return
     */
    public Book highestNumberOfPagesBook() {
        /* TODO */
        for (int i = 0; i < bookList.size() - 1; i++) {
            for (int j  = 0; j < bookList.size() - i - 1; j++) {
                if (bookAt(j).getPages() < bookAt(j + 1).getPages()) {
                    Book temp = bookAt(j);
                    bookList.set(bookAt(j + 1), j );
                    bookList.set(temp,j + 1);
                }
            }
        }
        return bookAt(0);

    }

    /**
     * Lấy ra sách có số trang thấp nhất.
     * @return
     */
    public Book lowestNumberOfPagesBook() {

        for (int i = 0; i < bookList.size() - 1; i++) {
            for (int j  = 0; j < bookList.size() - i - 1; j++) {
                if (bookAt(j).getPages() > bookAt(j + 1).getPages()) {
                    Book temp = bookAt(j);
                    bookList.set(bookAt(j + 1), j );
                    bookList.set(temp,j + 1);
                }
            }
        }
        return bookAt(0);
    }

    /**
     * Lọc ra những book theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        /* TODO */
        MyList newList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookAt(i).getPublisher().equals(publisher)) {
                newList.insertAtEnd(bookAt(i));
            }
        }
        return newList;
    }

    /**
     * Lọc ra những book theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        /* TODO */
        MyList newList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookAt(i).getGenre().equals(genre)) {
                newList.insertAtEnd(bookAt(i));
            }
        }
        return newList;
    }

    /**
     * Lọc ra những book theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        /* TODO */
        MyList newList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookAt(i).getAuthor().equals(author)) {
                newList.insertAtEnd(bookAt(i));
            }
        }
        return newList;
    }
}
