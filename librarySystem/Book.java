/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EB
 */
public class Book implements Comparable<Book> {

    String title;
    String isbn;
    String author;

    Book(String name, String number, String writer) {
        title = name;
        isbn = number;
        author = writer;
    }

    public int compareTo(Book b) {

        int comparison = this.title.compareTo(b.title);
        return (comparison);

    }

    public String gettitle() {
        return title;
    }

    public String getisbn() {
        return isbn;
    }

    public String getauthor() {
        return author;
    }

    @Override
    public String toString() {
        return (title);
    }

}
