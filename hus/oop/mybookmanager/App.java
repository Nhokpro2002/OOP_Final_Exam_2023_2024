package hus.oop.mybookmanager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static final String OUTPUT_FILE = "output_file";
    private static final BookManager bookManager = BookManager.getInstance();

    public static void main(String[] args) {
        init();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_MyBookManager>.txt (Ví dụ, NguyenVanA_123456_MyBookManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BookMyManager>.zip (Ví dụ, NguyenVanA_123456_BookMyManager.zip),
          nộp lên classroom.
         */
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE))) {
            /* ghi kq vao file chay chuong trinh */
            writer.println("Test data init");
            testOriginalData(writer);
            testFilterBooksOfAuthor(writer);
            testFilterBooksOfPublisher(writer);
            testFilterBooksOfGenre(writer);
            testGetHighestPriceBook(writer);
            testGetLowestPriceBook(writer);
            testGetHighestNumberOfPagesBook(writer);
            testGetLowestNumberOfPagesBook(writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        String filePath = "C:\\Users\\Admin\\Desktop\\2324OOP_FinalExam_ToanTin\\data\\books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

                /*
                TODO
                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào BookManager để quản lý.

                Gợi ý:
                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Book newBook = new Book.BookBuilder(title).
                    .withAuthor(author)
                    .withGenre(genre)
                    ...
                    .build();
                */
                try {
                    String title = dataList.get(0);
                    String author = dataList.get(1);
                    String genre = dataList.get(2);
                    int pages = Integer.parseInt(dataList.get(3));
                    double price = Double.parseDouble(dataList.get(4));
                    String publisher = dataList.get(5);

                    Book newBook = new Book.BookBuilder(title)
                            .withAuthor(author)
                            .withGenre(genre)
                            .withPages(pages)
                            .withPrice(price)
                            .withPublisher(publisher).build();

                    bookManager.insertAtEnd(newBook);

                }

                catch (NumberFormatException e) {
                    e.printStackTrace();

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData(PrintWriter writer) {
        for (int i = 0; i < bookManager.getBookList().size(); i++) {
            writer.println(bookManager.getBookList().get(i).data);
        }
    }


    /**
     * Test lọc ra những book theo tác giả.
     */
    public static void testFilterBooksOfAuthor(PrintWriter writer) {
        /* TODO */
        writer.println("test FilterBooksOfAuthor:");
        MyList newList = bookManager.filterBooksOfAuthor("Doyle Arthur Conan");
       for (int i = 0; i < newList.size(); i++) {
           writer.println(newList.get(i).data);
       }
    }

    /**
     * Test lọc ra những book theo nhà xuất bản.
     */
    public static void testFilterBooksOfPublisher(PrintWriter writer) {
        /* TODO */
        writer.println("test FilterBooksOfPublisher:");
        MyList newList = bookManager.filterBooksOfPublisher("Random House");
        for (int i = 0; i < newList.size(); i++) {
            writer.println(newList.get(i).data);
        }
    }

    /**
     * Test lọc ra những book theo thể loại.
     */
    public static void testFilterBooksOfGenre(PrintWriter writer) {
        /* TODO */
        writer.println("test FilterBooksOfGenre:");
        MyList newList = bookManager.filterBooksOfGenre("fiction");
        for (int i = 0; i < newList.size(); i++) {
            writer.println(newList.get(i).data);
        }
    }

    /**
     * Test lấy ra sách có giá cao nhất.
     */
    public static void testGetHighestPriceBook(PrintWriter writer) {
        writer.println("test GetHighestPriceBook:");
        Book book = bookManager.highestPriceBook();
        writer.println(book);
    }

    /**
     * Test lấy ra sách có giá thấp nhất.
     */
    public static void testGetLowestPriceBook(PrintWriter writer) {
        writer.println("test GetLowestPriceBook:");
        Book book = bookManager.lowestPriceBook();
        writer.println(book);
    }

    /**
     * Test lấy ra sách có số trang cao nhất.
     */
    public static void testGetHighestNumberOfPagesBook(PrintWriter writer) {
        writer.println("test HighestNumberOfPagesBook:");
        Book book = bookManager.highestNumberOfPagesBook();
        writer.println(book);
    }

    /**
     * Test lấy ra sách có số trang thấp nhất.
     */
    public static void testGetLowestNumberOfPagesBook(PrintWriter writer) {
        writer.println("test LowestNumberOfPagesBook:");
        Book book = bookManager.lowestNumberOfPagesBook();
        writer.println(book);
    }
}
