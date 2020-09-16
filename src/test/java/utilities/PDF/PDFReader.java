package utilities.PDF;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;

public class PDFReader {

    public static void readFile (String file, String contains_string) throws IOException {
        FileInputStream fis = new FileInputStream(file);

        PDDocument pdDoc = PDDocument.load(fis);
        PDFTextStripper strip = new PDFTextStripper();
        String data = strip.getText(pdDoc);
        fis.close();
        pdDoc.close();

        Assert.assertTrue(data.contains(contains_string));
        System.out.print("Search string found!");

    }
}
