package com.Bharani.week1.Ex2;

public class PdfDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening Pdf document.");
    }

    @Override
    public void save() {
        System.out.println("Saving Pdf document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Pdf document.");
    }

}
