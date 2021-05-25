package utils;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class KnowledgeSessionHelper {
	
;
	private static KieServices kieServices;
	private static KieContainer kieContainer;
	private static KieSession statefulSession;
	
	public static KieContainer createRuleBase() {
		kieServices = KieServices.Factory.get();
		kieContainer = kieServices.getKieClasspathContainer();
		return kieContainer;
	}

	public static KieSession getStatefulKnowledgeSession(KieContainer kieContainer, String sessionName) {
		if (statefulSession != null) {
			throw new IllegalStateException("Kie Session has already been built.");
		}
		KieSession statefulSession = kieContainer.newKieSession(sessionName);
		return statefulSession;
	}

}
