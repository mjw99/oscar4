package uk.ac.cam.ch.wwmm.oscar.chemnamedict.core;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

import nu.xom.ParsingException;
import uk.ac.cam.ch.wwmm.oscar.chemnamedict.ChemNameDictIO;
import uk.ac.cam.ch.wwmm.oscar.chemnamedict.data.MutableChemNameDict;
import uk.ac.cam.ch.wwmm.oscar.exceptions.ResourceInitialisationException;
import uk.ac.cam.ch.wwmm.oscar.tools.ResourceGetter;

public class DefaultDictionary extends MutableChemNameDict {

	private static final URI DEFAULT_DICTIONARY_URL;

	static {
		try {
			DEFAULT_DICTIONARY_URL = new URI("http://wwmm.ch.cam.ac.uk/dictionary/default/");
		}
		catch (URISyntaxException e) {
			// Should not be thrown, as URL is valid.
			throw new RuntimeException(e);
		}
	}

	public DefaultDictionary() {
		super(DEFAULT_DICTIONARY_URL, Locale.ENGLISH);

		ResourceGetter rg = new ResourceGetter(getClass().getClassLoader(),"uk/ac/cam/ch/wwmm/oscar/chemnamedict/");
		try {
			ChemNameDictIO.readXML(rg.getXMLDocument("defaultCompounds.xml"),this);
		} catch (ParsingException e) {
			throw new ResourceInitialisationException("failed to load default dictionary", e);
		} catch (IOException e) {
			throw new ResourceInitialisationException("failed to load default dictionary", e);
		}
	}
}
