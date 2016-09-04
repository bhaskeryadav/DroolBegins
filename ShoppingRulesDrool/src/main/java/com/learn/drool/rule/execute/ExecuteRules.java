package com.learn.drool.rule.execute;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.learn.drool.rule.Bill;

public class ExecuteRules {

	public static void main(String[] args) throws DroolsParserException, IOException {
		new ExecuteRules().executeAllRulesNew();
	}
	
	private void executeAllRulesNew(){
		KieServices kServices = KieServices.Factory.get();
		KieContainer kContainer = kServices.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("DiscountCal");

		Bill bill = new Bill();
		bill.setFinalAmount(2987d);

		kSession.insert(bill);
		kSession.fireAllRules();
		
		kSession.dispose();
	}

}
