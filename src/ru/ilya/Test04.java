package ru.ilya;

public class Test04 {
    public static void main(String[] args) throws Exception {

        try (ImageScanner ir = new ImageScanner();
             ImagePrinter iw = new ImagePrinter()) {
            ir.scanImage();
            iw.printImage();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}

class ImageScanner implements AutoCloseable {
    public void close() throws Exception {
        System.out.print("Scanner closed.");
    }

    public void scanImage() throws Exception {
        System.out.print("Scan.");
        throw new Exception("Unable to scan.");
    }
}

class ImagePrinter implements AutoCloseable {
    public void close() throws Exception {
        System.out.print("Printer closed.");
    }

    public void printImage() {
        System.out.print("Print.");
    }
}