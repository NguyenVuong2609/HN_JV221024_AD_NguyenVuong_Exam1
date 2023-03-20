package Rikkei.academy.run;

import Rikkei.academy.businessImp.Author;
import Rikkei.academy.businessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Author> authorList = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();
        int choice;
        int authorSize = 0;
        int bookSize = 0;
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả\n" +
                    "2. Nhập số sách và nhập thông tin các sách\n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator)\n" +
                    "4. Tìm kiếm sách theo tên tác giả sách\n" +
                    "5. Thoát");
            System.out.println("Vui lòng lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Nhập số tác giả bạn muốn thêm: ");
                        authorSize = Integer.parseInt(sc.nextLine());
                        if (authorSize <= 0)
                            System.err.println("Không hợp lệ.");
                    } while (authorSize <= 0);
                    for (int i = 0; i < authorSize; i++) {
                        System.out.println("Nhập thông tin tác giả thứ " + (i + 1));
                        authorList.add(new Author());
                        authorList.get(i).inputData();
                    }
                    break;
                case 2:
                    if (authorList.size() != 0) {
                        do {
                            System.out.println("Nhập số sách muốn thêm: ");
                            bookSize = Integer.parseInt(sc.nextLine());
                            if (bookSize <= 0)
                                System.err.println("Không hợp lệ.");
                        } while (bookSize <= 0);
                        for (int i = 0; i < bookSize; i++) {
                            System.out.println("Nhập thông tin sách thứ " + (i + 1));
                            bookList.add(new Book());
                            bookList.get(i).setAuthorsList(authorList);
                            bookList.get(i).inputData();
                            bookList.get(i).setExportPrice();
                        }
                        for (int i = 0; i < bookList.size(); i++) {
                            bookList.get(i).displayData();
                        }
                    } else {
                        System.out.println("Danh sách tác giả đang trống, vui lòng thêm tác giả.");
                    }
                    break;
                case 3:
                    Collections.sort(bookList);
                    break;
                case 4:
                    System.out.println("Nhập vào tên tác giả: ");
                    boolean flag = false;
                    String name = sc.nextLine();
                    for (int i = 0; i < bookList.size(); i++) {
                        if (bookList.get(i).getAuthor().getAuthorName().equalsIgnoreCase(name)){
                            bookList.get(i).displayData();
                            flag = true;
                        }
                    }
                    if (!flag)
                        System.out.println("Không có tác giả này.");
                    break;
                case 5:
                    System.exit(0);
            }
        } while (choice != 5);
    }
}
