package semanticwebproject;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.riot.RDFLanguages;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class finalproject 
{
	private static String dataDir = "D:/Bhavana/Summer_Semester/Semantic_web/Input.rdf";

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// System.out.print("hai hello world");
		Model model = ModelFactory.createDefaultModel();
		try 
		{
			// read the original ttl file, using the TURTLE format
			RDFDataMgr.read(model, new FileInputStream(dataDir),
					RDFLanguages.RDFXML);
			RDFDataMgr.write(System.out, model, RDFFormat.RDFXML_PRETTY);

			String filename = "Input.rdf";
			FileWriter out = new FileWriter( filename );
			try {
			    model.write( out, "RDF/XML-ABBREV" );
			}
			finally {
			   try {
			       out.close();
			   }
			   
			   
			   catch (IOException closeException) {
			       // ignore
			   }
			}
			 String fileName = "file.rdf"; //The file that will be saved on your computer
			 URL link = new URL("http://dbpedia.org/data/Roger_Federer"); //The file that you want to download
			
	     //Code to download
			 InputStream in = new BufferedInputStream(link.openStream());
			 ByteArrayOutputStream out1 = new ByteArrayOutputStream();
			 byte[] buf = new byte[1024];
			 int n = 0;
			 while (-1!=(n=in.read(buf)))
			 {
			    out1.write(buf, 0, n);
			 }
			 out1.close();
			 in.close();
			 byte[] response = out1.toByteArray();
	 			 FileOutputStream fos = new FileOutputStream(fileName);
			 fos.write(response);
			 fos.close();
	     //End file download code
			 System.out.println("Finished");
			 
		} 
		catch (Exception e) 
		{
			System.out.println("something wrong...");
			e.printStackTrace();
		}
	}
}
