/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * base book constructor, holds all base variables of a book.
 */
public class Book {
    
    private String title;
    private int id;
    private double ISBN;
    private String author;
    private int pages;
    private String dateOfIssue; //dd-mm-yy
    private String borrowerName;
    
    public Book()
    {
        title = "def";
        id = 0;
        ISBN = 0;
        author = "def";
        pages = 0;
        dateOfIssue = "00/00/00";
        borrowerName = "def";
    }
    
    public Book(String t, int i, double s, String a, int p, String d, String n)
    {
        title = t;
        id = i;
        ISBN = s;
        author = a;
        pages = p;
        dateOfIssue = d;
        borrowerName = n;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
}
