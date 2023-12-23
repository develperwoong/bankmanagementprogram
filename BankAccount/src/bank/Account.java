package bank;

public class Account {
	private String accountNum;
	private String owner;
	private int balance;
	
	public Account(String accountNum, String owner, int balance) {
		this.accountNum = accountNum;
		this.owner = owner;
		this.balance = balance;
	}
	public String getAccountNum(){return accountNum;}
	public void setAccountNum(String accountNum) {this.accountNum = accountNum;}
	public String getOwner() {return owner;}
	public void setOwner(String owner) {this.owner=owner;}
	public int getBalance() {return balance;}
	public void setBalance(int balance) {this.balance = balance;}
}
