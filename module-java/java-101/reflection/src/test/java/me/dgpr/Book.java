package me.dgpr;

public class Book {
    private String nameA;
    private static String nameB = "BOOK";
    private static final String nameC = "BOOK";
    public String nameD = "d";
    protected String nameE = "e";

    public Book() {
    }

    public Book(String nameA, String nameD, String nameE) {
        this.nameA = nameA;
        this.nameD = nameD;
        this.nameE = nameE;
    }

    private void methodF() {
        System.out.println("F");
    }

    public void methodG() {
        System.out.println("F");
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
