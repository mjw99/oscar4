package uk.ac.cam.ch.wwmm.oscarMEMM;

import nu.xom.Document;
import uk.ac.cam.ch.wwmm.oscar.document.NamedEntity;
import uk.ac.cam.ch.wwmm.oscar.document.ProcessingDocument;
import uk.ac.cam.ch.wwmm.oscar.document.ProcessingDocumentFactory;
import uk.ac.cam.ch.wwmm.oscarMEMM.tools.ResourceGetter;

public class Main {

	
	public static void main (String[] args)
	{
		MEMMRecogniser MER = new MEMMRecogniser();
		ResourceGetter rg = new ResourceGetter("uk/ac/cam/ch/wwmm/oscarMEMM/input/");
		String resourceName = "source.xml";
		Document sourceDoc = rg.getXMLDocument(resourceName);
		ProcessingDocument procDoc = null;
		
		try 
		{
			procDoc = new ProcessingDocumentFactory().makeTokenisedDocument(sourceDoc, true, false, false);
		    
		 } 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			
			java.util.List<NamedEntity> Entities = MER.findNamedEntities(procDoc.getTokenSequences());
			for (NamedEntity namedEntity : Entities) {
				System.out.println("********************");
				System.out.println("NamedEntity= "+namedEntity.getSurface());
				System.out.println("Type="+namedEntity.getType());
				System.out.println("Confidence="+namedEntity.getConfidence());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
