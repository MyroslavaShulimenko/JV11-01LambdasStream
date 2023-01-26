package JV2301;

import java.util.*;

public class Student {
    private String id;
    private String name;
    private Set<String>books;
    public Student(String name){
        this.name=name;
        this.books=new HashSet<>();
       this.id= UUID.randomUUID().toString();
    }
    public Set<String> getBooks(){
        return books;
    }
    public void addBook(String bookName){
        books.add(bookName);
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String toString(){
        return id+"  "+name;
    }
}
