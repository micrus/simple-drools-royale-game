package test.com.sample;

import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import utils.KnowledgeSessionHelper;

class testKnowledgeSessionHelper {
	
	KieSession sessionStateful = null;
	static KieContainer kContainer;
	
	@Test
	void testCreationOfARuleBase() {
		kContainer = KnowledgeSessionHelper.createRuleBase();		
	}
	
	@Test
	void testCreationOfAStatefulSession() {
		sessionStateful = KnowledgeSessionHelper.getStatefulKnowledgeSession(kContainer, "ksession-rules");		
	}
	 

}
