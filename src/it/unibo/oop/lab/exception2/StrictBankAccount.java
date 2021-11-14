package it.unibo.oop.lab.exception2;

/**
 * Class modeling a BankAccount with strict policies: getting money is allowed
 * only with enough founds, and there are also a limited number of free ATM
 * transaction (this number is provided as a input in the constructor).
 * 
 */
public class StrictBankAccount implements BankAccount {
	
	private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;

    private final int usrID;
    private double balance;
    private int totalTransactionCount;
    private final int maximumAllowedATMTransactions;

    /**
     * 
     * @param usrID
     *            user id
     * @param balance
     *            initial balance
     * @param maximumAllowedAtmTransactions
     *            max no of ATM transactions allowed
     */
    public StrictBankAccount(final int usrID, final double balance, final int maximumAllowedAtmTransactions) {
        this.usrID = usrID;
        this.balance = balance;
        this.maximumAllowedATMTransactions = maximumAllowedAtmTransactions;
    }

    /**
     * 
     * @param usrID
     *            id of the user requesting this operation
     * @param amount
     *            amount to be credited
     * @throws WrongAccountHolderException
     *             if an unauthorized account tries to deposit
     */
    public void deposit(final int usrID, final double amount) {
    	checkUser(usrID);
        
        this.balance += amount;
        increaseTransactionsCount();
    }

    /**
     * @param usrID
     *            id of the user requesting this operation
     * @param amount
     *            amount to be withdrawn
     * @throws WrongAccountHolderException
     *             if an unauthorized account tries to withdraw
     * @throws NotEnoughFoundsException
     *             if there is not enough founds for a draw operation to complete
     */
    public void withdraw(final int usrID, final double amount) {
    	checkUser(usrID);
        isWithdrawAllowed(amount);
        
        this.balance -= amount;
        increaseTransactionsCount();
    }

    /**
     * 
     * @param usrID
     *            id of the user requesting this opera
     * @param amount
     *            amount to be deposited via ATM
     * @throws WrongAccountHolderException
     *             if an unauthorized account tries to deposit from an ATM
     * @throws TransactionsOverQuotaException
     *              if the count of total transactions gets over the maximum allowed
     */
    public void depositFromATM(final int usrID, final double amount) {
    	checkTransactionsQuota();
        this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
    }

    /**
     * @param usrID
     *            id of the user requesting this operation
     * @param amount
     *            amount to be withdrawn via ATM
     * @throws WrongAccountHolderException
     *             if an unauthorized account tries to withdraw
     * @throws NotEnoughFoundsException
     *             if there is not enough founds for a draw operation to complete
     * @throws TransactionsOverQuotaException
     *              if the count of total transactions gets over the maximum allowed
     */
    public void withdrawFromATM(final int usrID, final double amount) {
    	checkTransactionsQuota();
        this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
    }

    /**
     * 
     * {@inheritDoc}
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getTransactionCount() {
        return totalTransactionCount;
    }

    /**
     * 
     * @param usrID
     *            id of the user related to these fees
     * @throws WrongAccountHolderException
     *             if an unauthorized account tries to compute
     * @throws NotEnoughFoundsException
     *             if there is not enough founds for a draw operation to complete
     */
    public void computeManagementFees(final int usrID) {
        final double feeAmount = MANAGEMENT_FEE + (totalTransactionCount * StrictBankAccount.TRANSACTION_FEE);
        checkUser(usrID);
        isWithdrawAllowed(feeAmount);
        
        balance -= feeAmount;
        totalTransactionCount = 0;
    }

    private void checkUser(final int id) {
    	if (this.usrID != id) {
    		throw new WrongAccountHolderException();
    	}
    }

    private void isWithdrawAllowed(final double amount) {
        if (!(balance > amount)) {
        	throw new NotEnoughFoundsException();
        }
    }

    private void increaseTransactionsCount() {
        totalTransactionCount++;
    }
    
    private void checkTransactionsQuota() {
    	if (!(totalTransactionCount < maximumAllowedATMTransactions)) {
    		throw new TransactionsOverQuotaException();
        }
    }
}
