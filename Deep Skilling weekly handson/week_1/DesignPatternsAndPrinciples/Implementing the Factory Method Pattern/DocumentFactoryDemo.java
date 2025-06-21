// Step 1 & 2: Document Interface
interface Document {
    void open();
}

// Step 3: Concrete Document Classes
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document...");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document...");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document...");
    }
}

// Step 4: Factory Method Structure

// Abstract Factory
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Concrete Factories
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Step 5: Test Class
public class DocumentFactoryDemo {
    public static void main(String[] args) {
        // Word document creation
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        // PDF document creation
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        // Excel document creation
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
