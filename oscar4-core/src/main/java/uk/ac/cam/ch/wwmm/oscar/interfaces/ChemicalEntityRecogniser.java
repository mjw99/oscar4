package uk.ac.cam.ch.wwmm.oscar.interfaces;

import java.util.List;

import uk.ac.cam.ch.wwmm.oscar.document.ITokenSequence;
import uk.ac.cam.ch.wwmm.oscar.document.NamedEntity;

/**
 * Abstraction of name recognition. Set chemicalEntityRecogniser system property "chemicalEntityRecogniser" to the implementing class
 * @author j_robinson
 * @author egonw
 */
public interface ChemicalEntityRecogniser {

	public List<NamedEntity> findNamedEntities(List<ITokenSequence> tokenSequences);

}
