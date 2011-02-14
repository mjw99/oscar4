package uk.ac.cam.ch.wwmm.oscar.document;

import uk.ac.cam.ch.wwmm.oscar.types.BioType;

public interface IToken {

	/**Gets the <i>n</i>th token after this one, or null. For example, 
	 * getNAfter(1) would get the next token, and getNAfter(-1) would get the
	 * previous one. 
	 * 
	 * @param n The offset (in tokens) from the current token.
	 * @return The token.
	 */
	public abstract IToken getNAfter(int n);

	/**Gets the surface string of the token.
	 * 
	 * @return The string value of the token.
	 */
	public abstract String getSurface();

	public abstract void setSurface(String surface);

	/**Gets the index of the token in its TokenSequence.
	 * 
	 * @return The index of the token in its TokenSequence.
	 */
	public abstract int getId();

	public abstract void setId(int id);

	/**Gets this token's ProcessingDocument.
	 * 
	 * @return This token's ProcessingDocument.
	 */
	public abstract IProcessingDocument getDoc();

	/**Gets the start offset of this token.
	 * 
	 * @return The start offset of this token.
	 */
	public abstract int getStart();

	/**Gets the start offset of this token.
	 * 
	 * @return The end offset of this token.
	 */
	public abstract int getEnd();

	public abstract void setEnd(int end);

	/**Gets the BIO tag of this token.
	 * 
	 * @return The BIO tag of this token.
	 */
	public abstract BioType getBioTag();

	public abstract void setBioTag(BioType bioTag);

	/**Gets the TokenSequence that contains this token.
	 * 
	 * @return The TokenSequence that contains this token.
	 */

	public abstract ITokenSequence getTokenSequence();

	public abstract void setTokenSequence(ITokenSequence tokenSequence);

}