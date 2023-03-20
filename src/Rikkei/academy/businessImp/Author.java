package Rikkei.academy.businessImp;

import Rikkei.academy.business.IShop;

import java.util.Scanner;

public class Author implements IShop {
    private int authorId;
    private String authorName;
    private boolean sex;
    private int year;

    public Author() {
    }

    public Author(int authorId, String authorName, boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã tác giả: ");
        this.authorId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên tác giả: ");
        this.authorName = sc.nextLine();
        System.out.println("Nhập giới tính: (Nam = true, Nữ = false)");
        this.sex = sc.nextBoolean();
        sc.nextLine();
        System.out.println("Nhập năm sinh: ");
        this.year = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                '}');
    }

}
