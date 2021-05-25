package com.sample;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import utils.KnowledgeSessionHelper;

class TestKnowledgeSessionHelper {
	
	StatelessKieSession sessionStateless = null;
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
