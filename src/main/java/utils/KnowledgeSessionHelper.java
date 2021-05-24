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

//	public static KieSession testSpecificDrl(Object context, KieContainer kieContainer, String ruleName) {
//		
//		URL resource = context.getClass().getResource(ruleName);
//		if (resource == null) {
//			throw new IllegalArgumentException("ruleName '" + ruleName + "' does not resolve to a resource");
//		}
//
//		File ruleFile = new File(resource.getPath());
//        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//		kieFileSystem.write(ResourceFactory.newFileResource(ruleFile).setResourceType(ResourceType.DRL));
//		
//		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
//		kieBuilder.buildAll();
//		
//		if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
//			throw new RuntimeException("Build Errors:\n" + kieBuilder.getResults().toString());
//		}
//		
//		KieSession statefulSession = kieContainer.newKieSession();
//		return statefulSession;
//	}	

}
