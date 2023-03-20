package Rikkei.academy.businessImp;

import Rikkei.academy.business.IShop;

import java.util.ArrayList;
import java.util.Scanner;

public class Book implements IShop, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private boolean bookStatus;
    private ArrayList<Author> authorsList;

    public ArrayList<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(ArrayList<Author> authorsList) {
        this.authorsList = authorsList;
    }

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, float importPrice, float exportPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice() {
        this.exportPrice = this.importPrice * RATE;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        if (authorsList.size() != 0){
        System.out.println("Nhập mã sách: ");
        this.bookId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên sách: ");
        this.bookName = sc.nextLine();
        System.out.println("Nhập tiêu đề sách: ");
        this.title = sc.nextLine();
        System.out.println("Nhập số trang sách: ");
        this.numberOfPages = Integer.parseInt(sc.nextLine());
        while (!flag) {
            System.out.println("Chọn tác giả(Vui lòng nhập mã tác giả): ");
            for (int i = 0; i < authorsList.size(); i++) {
                authorsList.get(i).displayData();
            }
            int choice = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < authorsList.size(); i++) {
                if (choice == authorsList.get(i).getAuthorId()) {
                    this.author = authorsList.get(i);
                    flag = true;
                }
            }
        }
        System.out.println("Nhập giá nhập sách: ");
        this.importPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập số lượng sách: ");
        this.quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập trạng thái sách: ");
        this.bookStatus = sc.nextBoolean();
        }
    }

    @Override
    public void displayData() {
        System.out.println("Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author=" + author.getAuthorName() +
                ", exportPrice=" + exportPrice +
                ", quantity=" + quantity +
                ", bookStatus=" + bookStatus +
                '}');
    }

    @Override
    public int compareTo(Book o) {
        return (int) (this.exportPrice - o.getExportPrice());
    }
}
