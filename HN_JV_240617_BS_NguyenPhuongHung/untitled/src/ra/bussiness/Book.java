package ra.bussiness;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;
    public static boolean  statusChange = true;

    public Book() {
    }

    public Book(int bookId, float interest, double importPrice, String bookName, String bookAuthor, String descriptions, double exportPrice, boolean bookStatus) {
        this.bookId = bookId;
        this.interest = interest;
        this.importPrice = importPrice;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.descriptions = descriptions;
        this.exportPrice = exportPrice;
        this.bookStatus = true;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void inputData(Scanner sc, Book[] books, int currentBook) {

        this.bookId = inputBookId(books, currentBook);
        this.bookName = inputBookName(sc);
        this.bookAuthor = inputAuthor(sc);
        this.descriptions = inputDescriptions(sc);
        this.importPrice = inputImportPrice(sc);
        this.exportPrice = importPrice * 1.2;
        this.interest = (float) (exportPrice - importPrice);
        this.bookStatus = inputBookStatus(sc);
    }

    private boolean inputBookStatus(Scanner sc) {


        if (statusChange) {
            return true;
        }else {
            System.out.println("nhập trạng thái của sách :");

            do { String status = sc.nextLine();

                if (status.trim().equals("true") || status.trim().equals("false")) {
                    return  Boolean.parseBoolean(status);
                }else {
                    System.err.println("hãy nhập lại trạng thái của sách  true or false : ");
                }

            }while (true);
        }
    }

    private double inputImportPrice(Scanner sc) {
        System.out.println("Hãy nhập giá tiền của sách : ");
        do {
            double importPrice = Double.parseDouble(sc.nextLine());

            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("giá phải lớn hơn 0 ");
            }

        } while (true);
    }

    private String inputDescriptions(Scanner sc) {
        System.out.println("Hãy nhập miêu tả : ");

        do {
            String bookDescriptions = sc.nextLine();
            if (bookDescriptions.trim().isEmpty()) {
                System.err.println("đừng để miêu tả   trống : ");
            } else {

                if (bookDescriptions.trim().length() < 10) {
                    System.out.println("Miêu tả sách phải lớn hơn 10 : ");
                } else {
                    return bookDescriptions;
                }

            }
        } while (true);
    }

    private String inputAuthor(Scanner sc) {

        System.out.println("Hãy nhập tên tác giả  : ");

        do {
            String bookAuthor = sc.nextLine();
            if (bookAuthor.trim().isEmpty()) {
                System.err.println("đừng để tên tác giả  trống : ");
            } else {
                return bookAuthor;
            }
        } while (true);
    }

    private String inputBookName(Scanner sc) {

        System.out.println("Hãy nhập tên sách : ");

        do {
            String bookName = sc.nextLine();
            if (bookName.trim().isEmpty()) {
                System.err.println("đừng để tên sách trống : ");
            } else {
                return bookName;
            }
        } while (true);

    }

    private int inputBookId(Book[] books, int currentBook) {

        int maxId = 0;


        for (int i = 0; i < currentBook; i++) {
            if (books[i].getBookId() > maxId) {
                maxId = books[i].getBookId();
            }
        }
        return maxId + 1;
    }

    public void display() {
//
//

        System.out.printf("[ bookID : %d | bookName : %s | author : %s | descriptions : %s | importPrice : %.3f | exportPrice : %.3f | interest : %.3f | bookStatus : %s ]\n",
                this.getBookId(),
                this.getBookName(),
                this.getBookAuthor(),
                this.getDescriptions(),
                this.importPrice,
                this.exportPrice,
                this.interest,
                this.bookStatus
        );

    }
}

