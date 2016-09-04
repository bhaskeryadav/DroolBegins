package com.learn.drool.rule;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ExecuteRules {

	public static void main(String[] args) throws DroolsParserException, IOException {
		new ExecuteRules().executeAllRulesNew();
	}

	private void executeAllRules() throws DroolsParserException, IOException {
		/*PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/discount/rule/discount.drl";
		// Convert rule file to InputStream
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		// Create new WorkingMemory session for this RuleBase. By default the
		// RuleBase retains a weak reference to returned WorkingMemory
		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		Bill bill = new Bill();
		bill.setFinalAmount(2987d);

		// Insert and fire all rules untile its empty
		workingMemory.insert(bill);
		workingMemory.fireAllRules();*/
	}
	
	private void executeAllRulesNew(){
		KieServices kServices = KieServices.Factory.get();
		KieContainer kContainer = kServices.getKieClasspathContainer();
		//KieSession kSession = kContainer.newKieSession("HelloWorldKS"); 
		KieSession kSession = kContainer.newKieSession("DiscountCal");
		/*kSession.insert(Message.HELLO);
		kSession.fireAllRules();
		
		kSession.insert(Message.GOODBYE);
		kSession.fireAllRules();*/

		Bill bill = new Bill();
		bill.setFinalAmount(2987d);

		kSession.insert(bill);
		kSession.fireAllRules();
		
		kSession.dispose();
	}

}
