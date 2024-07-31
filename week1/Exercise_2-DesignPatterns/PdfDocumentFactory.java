package com.Bharani.week1.Ex2;

public class PdfDocumentFactory extends DocumentFactory{
    public Document createDocument() {
        return new PdfDocument();
    }
}
