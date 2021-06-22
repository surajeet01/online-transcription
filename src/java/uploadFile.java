package testPackage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
 


import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;


@WebServlet("/upload")

public class uploadFile extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String fileName;
    private String outputFormat;
    private String InputLang;
    private String uploadFolder;
	
    //MAX_MEMORY SIZE denotes maximum size of the file that can be uploaded
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 10; 
    private static final int MAX_REQUEST_SIZE = 102400 * 1024;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	//*****************UPLOAD THE FILE**********************************
    	// Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            return;
        }

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        
        // Sets the size threshold beyond which files are written directly to
        // disk.
        factory.setSizeThreshold(MAX_MEMORY_SIZE);

        
        // Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for
        // java
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        
        // constructs the folder where uploaded file will be stored
        //present working directory will be the upload location
        //in linux the location is "/var/lib/tomcat7"
        //through the following line we get the present working directory location 
        uploadFolder = Paths.get(".").toAbsolutePath().normalize().toString(); 
        //System.out.println(uploadFolder);
        uploadFolder = uploadFolder + "/webapps/test-app/temp" ;
        
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        try {
            // Parse the request
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (!item.isFormField()) {
                    fileName = new File(item.getName()).getName();
                    String filePath = uploadFolder + File.separator + fileName;
                    File uploadedFile = new File(filePath);
                    
                    // saves the file to upload directory
                    item.write(uploadedFile);
                }else{
                	//GET DATA FROM THE SELECT FIELD OF HTML FORM
                	String x = item.getString();
                	if(x.equals("Bengali") || x.equals("English"))
                		InputLang = x;
                	else if(x.equals("html") || x.equals("pdf") || x.equals("doc"))
                		outputFormat = x;
                	
                }
            }
            
        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    	
        //*******************FILE UPLOADED*********************************
        
        //create new Transcriptor object for the newly uploaded file
        Transcriptor t = new Transcriptor(fileName,InputLang);  
        try{
        	//trancript the file, take a look on Transcriptor object for further details 
    		t.transcript();
    	}catch(Exception e){
    		throw new ServletException(e);
    	}
        
        System.out.println(outputFormat);
        //*****************TRANSCRIPTION TO HTML DONE**************************
        
        if(outputFormat.equals("pdf")){
        	
        	String fileName2 = fileName;
        	String fileName1 = fileName.replaceFirst("[.][^.]+$", "") + ".pdf";
        	
        	try{
        		ProcessBuilder pb = new ProcessBuilder("/usr/local/bin/wkhtmltopdf","http://localhost:8080/test-app/temp/new_"+fileName2,uploadFolder+"/"+fileName1);
        		Process p = pb.start();
        		p.getErrorStream();
                p.getInputStream();
        		try {
        			p.waitFor();
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		}
        	}catch(Exception e){
        		//
        	}
 
        	
        	String filePath = uploadFolder + File.separator + fileName;
        	File uploadedFile = new File(filePath);
            if(uploadedFile.exists())
             	uploadedFile.delete();
        	
            filePath = uploadFolder + File.separator + "new_" + fileName;
        	uploadedFile = new File(filePath);
            if(uploadedFile.exists())
             	uploadedFile.delete();
            
            fileName = fileName1;
            
        	response.sendRedirect("http://localhost:8080/test-app/temp/" + fileName);
        	
        }
        else if(outputFormat.equals("doc")){
        	String fileName2 = fileName;
        	String fileName1 = fileName.replaceFirst("[.][^.]+$", "") + ".pdf";
        	
        	try{
        		ProcessBuilder pb = new ProcessBuilder("/usr/local/bin/wkhtmltopdf","http://localhost:8080/test-app/temp/new_"+fileName2,uploadFolder+"/"+fileName1);
        		Process p = pb.start();
        		p.getErrorStream();
                p.getInputStream();
        		try {
        			p.waitFor();
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		}
        	}catch(Exception e){
        		//
        	}
        	
        	String filePath = uploadFolder + File.separator + fileName;
        	File uploadedFile = new File(filePath);
            if(uploadedFile.exists())
             	uploadedFile.delete();
        	
            filePath = uploadFolder + File.separator + "new_" + fileName;
        	uploadedFile = new File(filePath);
            if(uploadedFile.exists())
             	uploadedFile.delete();
            
            fileName = fileName1;
            
            ConvertPdf2Word c = new ConvertPdf2Word();
            c.create(fileName, uploadFolder);
            
            filePath = uploadFolder + File.separator + fileName;
            uploadedFile = new File(filePath);
            if(uploadedFile.exists())
             	uploadedFile.delete();
            
            fileName = fileName.replaceFirst("[.][^.]+$", "") + ".doc";
            
            response.sendRedirect("http:///localhost:8080/test-app/temp/" + fileName);
        }
        	
        else{
        	String filePath = uploadFolder + File.separator + fileName;
        	File uploadedFile = new File(filePath);
        	if(uploadedFile.exists())
        		uploadedFile.delete();
        
        	//NOW DISPLAY THE TRANSCRIPTED FILE
        	//FOR THIS PURPOSE, REDIRECT TO TRANSCRIPTED FILE 
        	response.sendRedirect("http:///localhost:8080/test-app/temp/new_" + fileName);
        }
    }

}
 

class ConvertPdf2Word {
 
    public void create(String fileName, String uploadFolder) throws IOException {
        //System.out.println("Document converted started");
        XWPFDocument doc = new XWPFDocument();
        //String pdf = "D:\\javadomain.pdf";
        PdfReader reader = new PdfReader(uploadFolder + File.separator + fileName);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            TextExtractionStrategy strategy = parser.processContent(i,
                    new SimpleTextExtractionStrategy());
            String text = strategy.getResultantText();
            XWPFParagraph p = doc.createParagraph();
            XWPFRun run = p.createRun();
            run.setText(text);
            run.addBreak(BreakType.PAGE);
        }
        fileName = fileName.replaceFirst("[.][^.]+$", "") + ".doc";
        FileOutputStream out = new FileOutputStream(uploadFolder + File.separator + fileName);
        
        doc.write(out);
        out.close();
        reader.close();
        //System.out.println("Document converted successfully");
    }
}
