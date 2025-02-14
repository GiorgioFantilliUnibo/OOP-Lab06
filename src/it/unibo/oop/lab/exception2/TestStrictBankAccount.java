package it.unibo.oop.lab.exception2;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {
	
	private static final int MAX_ATM_TRANSACTIONS = 10;
	private static final double INITIAL_BALANCE = 10000;
	
    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	final AccountHolder usr1 = new AccountHolder("Giorgio", "Fantilli", 1);
    	final AccountHolder usr2 = new AccountHolder("Mario", "Rossi", 2);
    	
    	final BankAccount account1 = new StrictBankAccount(usr1.getUserID(), INITIAL_BALANCE, MAX_ATM_TRANSACTIONS);
    	final BankAccount account2 = new StrictBankAccount(usr2.getUserID(), INITIAL_BALANCE, MAX_ATM_TRANSACTIONS);
    	
    	/* 
    	 * WrongAccountHolderException test
    	 * 
    	 * This instruction throw a WrongAccountHolderException as a mismatched user ID is passed
    	 */
    	System.out.println("WrongAccountHolderException test");
    	try {
    		account1.deposit(usr2.getUserID(), 100.0);
    		fail("You shouldn't be here: indicated user incorrect");
    	} catch (WrongAccountHolderException e) {
    		assertNotNull(e);
    		System.out.println(e);
    		System.out.println(account1.getBalance());
    	}
    	
    	/* 
    	 * NotEnoughFoundsException test
    	 * 
    	 * This instruction throw a NotEnoughFoundsException as the funds
    	 * to be withdrawn are more than those available
    	 */
    	System.out.println();
    	System.out.println();
    	System.out.println("NotEnoughFoundsException test");
    	try {
    		account2.withdraw(usr2.getUserID(), 100000);
    		fail("You shouldn't be here: no more founds");
    	} catch (WrongAccountHolderException e) {
    		fail("You shouldn't be here: indicated user correct");
    	} catch (NotEnoughFoundsException e) {
    		assertNotNull(e);
    		System.out.println(e);
    		System.out.println(account2.getBalance());
    	} catch (TransactionsOverQuotaException e) {
    		fail("You shouldn't be here: this transaction should be always available");
    	}
    	
    	/* 
    	 * TransactionsOverQuotaException test
    	 * 
    	 * Last withdrawFromATM method throw a TransactionsOverQuotaException as 
    	 * the transactions that are still available were previously terminated
    	 */
    	System.out.println();
    	System.out.println();
    	System.out.println("TransactionsOverQuotaException test");
    	try {
    		for (int i = 0; i < MAX_ATM_TRANSACTIONS; i++) {
    			account2.withdrawFromATM(usr2.getUserID(), 1);
    		}
    	} catch (WrongAccountHolderException e) {
    		fail("You shouldn't be here: indicated user correct");
    	} catch (NotEnoughFoundsException e) {
    		fail("You shouldn't be here: there are enought founds");
    	} catch (TransactionsOverQuotaException e) {
    		fail("You shouldn't be here: there are enought transation left");
    	}
    		
    	try {
    		account2.withdrawFromATM(usr2.getUserID(), 1);
    	} catch (WrongAccountHolderException e) {
    		fail("You shouldn't be here: indicated user correct");
    	} catch (NotEnoughFoundsException e) {
    		fail("You shouldn't be here: there are enought founds");
    	} catch (TransactionsOverQuotaException e) {
    		assertNotNull(e);
    		System.out.println(e);
    		System.out.println("There are not other transation left: "+
    							(account2.getTransactionCount() == MAX_ATM_TRANSACTIONS));
    	}

    }
}
