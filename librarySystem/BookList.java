/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EB
 */
import java.util.*;

public class BookList {

    private ArrayList<Book> books;

    public BookList() {
        books = new ArrayList<Book>();
    }

    public void addBook(String t, String i, String a) {

        Book Book1 = new Book(t, i, a);
        books.add(Book1);
    }

    public String toString() {
        return books.toString();
    }

    public void sort() {
        Collections.sort(books);
    }

    public static void main(String[] args) {
        BookList bList = new BookList();
        bList.addBook("Calculus", "1234", "Goldstein");
        bList.addBook("Java", "5678", "Gosling");
        bList.addBook("Algorithms", "4629", "Cormen");
        System.out.println(bList);
        bList.sort();
        System.out.println(bList);
    }
}
