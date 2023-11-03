package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService) {
		return runner -> {

			//demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAfterAdvice(theAccountDAO);
			//demoTheAroundAdvice(theTrafficFortuneService);
			//demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);



		};
	}

	private void demoTheAroundAdviceRethrowException (TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n\n Main Program: demoTheAroundAdviceRethrowException");
        System.out.println("Calling getFortune()");
        boolean tripWired = true;
        String data = theTrafficFortuneService.getFortune(tripWired);
        System.out.println("\nMy fortune is: " + data);
        System.out.println("Finished!!");
	}

	private void demoTheAroundAdviceHandleException (TrafficFortuneService theTrafficFortuneService) throws InterruptedException {
		System.out.println("\n\n Main Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");
		boolean tripWired = true;
		String data = theTrafficFortuneService.getFortune(tripWired);
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished!!");
	}

	private void demoTheAroundAdvice (TrafficFortuneService theTrafficFortuneService) throws InterruptedException {
		System.out.println("\n\n Main Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String data = theTrafficFortuneService.getFortune();
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished!!");

	}

	private void demoTheAfterAdvice (AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try {
			boolean tripWired = false;
			theAccounts = theAccountDAO.findAccounts(tripWired);
		} catch (Exception exc) {
			System.out.println("\n\n Main Program: .. caught exception: " + exc);
		}



		System.out.println("\n\n Main Program: demoTheAfterAdvice");
		System.out.println("---------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice (AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try {
			boolean tripWired = true;
			theAccounts = theAccountDAO.findAccounts(tripWired);
		} catch (Exception exc) {
			System.out.println("\n\n Main Program: .. caught exception: " + exc);
		}



		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
		System.out.println("---------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice (AccountDAO theAccountDAO) {
		List<Account> theAccounts = theAccountDAO.findAccounts();

		System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
		System.out.println("---------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice (AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount);
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();


		theMembershipDAO.addSillyMember();
	}

}
