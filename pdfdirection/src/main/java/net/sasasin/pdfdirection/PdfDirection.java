package net.sasasin.pdfdirection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * Hello world!
 * 
 */
public class PdfDirection {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("usage PdfDirection input.pdf output.pdf R2L");
			System.out.println("usage PdfDirection input.pdf output.pdf L2R");
		}
		try {
			if (args[2].equals("R2L")) {
				setPref(args[0], args[1], PdfName.R2L);
			} else if  (args[2].equals("L2R")) {
				setPref(args[0], args[1], PdfName.L2R);
			} else {
				setPref(args[0], args[1], PdfName.R2L);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void setPref(String sourceFilePath, String targetFilePath,
			PdfObject direction) throws FileNotFoundException,
			DocumentException, IOException {
		File outFile = new File(targetFilePath);
		PdfStamper pdfStamper = new PdfStamper(new PdfReader(sourceFilePath),
				new FileOutputStream(outFile));
		pdfStamper.addViewerPreference(PdfName.DIRECTION, direction);
		pdfStamper.close();
	}

}
