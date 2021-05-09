package utils;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Utility class per la creazione di rule base e sessioni relative.
 *
 */
public class KnowledgeSessionHelper {
	
	/**
	 * Crea la rule base partendo da un oggetto KieSession.
	 * 
	 * @return la rule base contenuta nel KieContainer.
	 */
	public static KieContainer createRuleBase() {
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		return kieContainer;
		
	}
	
	/**
	 * Crea una sessione stateful.
	 * 
	 * @param kieContainer contenente la rule base
	 * @param nome della sessione descritto nel kmodule
	 * 
	 * @return la sessione stateful
	 */
	public static KieSession getStatefulKnowledgeSession(KieContainer kieContainer, String sessionName) {
		KieSession kieSession = kieContainer.newKieSession(sessionName);
		return kieSession;
	}
	
	

}
