package com.example.aop;

import com.example.aop.dao.AccountDAO;
import com.example.aop.dao.MembershipDAO;
import com.example.aop.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
                                               MembershipDAO membershipDAO,
                                               TrafficFortuneService trafficFortuneService){
        return runner -> {

            // demoTheBeforeAdvice(accountDAO, membershipDAO);
            // demoTheAfterReturningAdvice(accountDAO);
            // demoTheAfterThrowingAdvice(accountDAO);
            // demoTheAfterAdvice(accountDAO);
            demoTheAroundAdvice(trafficFortuneService);
        };
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");

        System.out.println("Calling getFortune()");

        String data = trafficFortuneService.getFortune();

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished"  );
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {
        // call method to find the accounts
        List<Account> theAccounts = null;

        try{
            // add a boolean flag to simulate exceptions
            boolean tripWire = false;
            theAccounts = accountDAO.findAccounts(tripWire);
        }catch (Exception exc){
            System.out.println("\n\nMain Program: ... caught exception: " + exc);
        }

        // display the accounts
        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {

        // call method to find the accounts
        List<Account> theAccounts = null;

        try{
            // add a boolean flag to simulate exceptions
            boolean tripWire = true;
            theAccounts = accountDAO.findAccounts(tripWire);
        }catch (Exception exc){
            System.out.println("\n\nMain Program: ... caught exception: " + exc);
        }

        // display the accounts
        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
        // call method to find the accounts
        List<Account> theAccounts = accountDAO.findAccounts();

        // display the accounts
        System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        // call the business method
        Account account = new Account();
        account.setName("Madhu");
        account.setLevel("Platinum");
        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        // call the accountdao getter/setter methods
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        // call the membership business method
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
    }

}
