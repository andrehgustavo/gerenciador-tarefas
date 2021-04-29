/**
 * 
 */
package br.com.esig.gerenciador.model;

/**
 * @author André
 *
 */
public enum Priority {
	HIGH("Alta"), 
	MEDIUM("Média"), 
	LOW("Baixa");

	private String label;

	private Priority(String label) {
	        this.label = label;
	    }

	public String getLabel() {
		return label;
	}
}
