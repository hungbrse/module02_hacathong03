package ra.run;

import com.sun.tools.javac.Main;
import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    public static Book[] books = new Book[100];
    public static int currentBook = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookManagement bm = new BookManagement();

        boolean isLoop = true;
        do {

            System.out.println("****************JAVAVAVA-HACKATATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. thoát ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    bm.addBook(sc);
                    break;
                case 2:
                    bm.showBook();
                    break;
                case 3:
                    bm.showBookbyInterest();
                    break;

                case 4 :
                    bm.deleteBook(sc);
                    break;
                    case 5 :
                        bm.searchBook(sc);
                        break;
                        case 6 :
                            bm.updataBook(sc);
                            break;
                            case 7 :
                                isLoop = false;
            }


        }while (isLoop);

    }


    public void addBook(Scanner sc) {
        System.out.println("Hãy nhập số lượng sách muốn thêm :");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Thêm sách thứ : " + (i + 1));
            books[currentBook] = new Book();
            books[currentBook].inputData(sc, books,currentBook);
            currentBook++;
        }
    }

    public void showBook() {
        for (int i =0; i < currentBook ; i++) {
            books[i].display();
        }
    }



    public void showBookbyInterest() {
        for (int i = 0; i < currentBook-1; i++) {
            for (int j = i + 1; j < currentBook; j++) {
                if (books[i].getInterest() > books[j].getInterest()) {
                    Book temp = books[j];
                    books[j] = books[i];
                    books[i] = temp;
                }
            }
        }


        for (int i = 0; i < currentBook; i++) {
            books[i].display();
        }
    }

    public void updataBook(Scanner sc) {
        System.out.println("Nhập idị muốn updata : ");
        int id = Integer.parseInt(sc.nextLine());

        int updataIndex = findId(id);

        if (updataIndex != -1) {
            Book.statusChange = false;
            books[updataIndex].inputData(sc,books,updataIndex);
        }else {
            System.err.println("không tồn tại id : " + id);

        }
    }

    public void deleteBook(Scanner sc) {

        System.out.println("Nhập id muốn xóa :");

        int id = Integer.parseInt(sc.nextLine());

        int deleteIndex = findId(id);

        if (deleteIndex != -1) {

            for (int i = deleteIndex; i < currentBook ; i++) {
                books[i] = books[i+1];

            }
            currentBook--;
        }else  {
            System.err.println("không tồn tại id : " + id);
        }

    }

    public void searchBook(Scanner sc) {
        System.out.println("Nhập tên sách muốn tìm :");
        String bookName = sc.nextLine();

        for (int i =0; i < currentBook ; i++) {
            if (books[i].getBookName().contains(bookName)) {
                books[i].display();
            }
        }
    }

    private int findId(int id) {
        for (int i =0; i < currentBook ; i++) {
            if (books[i].getBookId() == id) {
                return i;
            }
        }
        return -1;
    }


 }
