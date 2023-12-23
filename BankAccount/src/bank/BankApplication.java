package bank;

import java.util.*;

public class BankApplication {
	private static Account[] accountArrayAccounts = new Account[120];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	boolean run = true;
	while(run) {
	System.out.println("----------------------------------------------------------");
	System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
	System.out.println("----------------------------------------------------------");
	System.out.print("선택> ");
	int selectNo = Integer.parseInt(scanner.nextLine());
	if(selectNo == 1) {
		createAccount();
	} else if(selectNo == 2) {
		accountList();
	} else if(selectNo == 3) {
		deposit();
	} else if(selectNo == 4) {
		withdraw();
	} else if(selectNo == 5) {
	run = false;
	}
	}
	System.out.println("프로그램 종료");
	}
	
	private static void createAccount() {
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		
		System.out.println("계좌번호:");
		String accountNum = scanner.nextLine();
		
		System.out.println("계좌주: ");
		String owner = scanner.nextLine();
		
		System.out.println("초기입금액: ");
		int balance  = Integer.parseInt(scanner.nextLine());
		
		Account newAccount = new Account(accountNum, owner, balance);
		for(int i = 0; i<accountArrayAccounts.length;i++) {
			if(accountArrayAccounts[i] == null) {
				accountArrayAccounts[i] = newAccount;
				System.out.println("출금: 계좌가 생성되었습니다.");
				break;
			}
		}
	}
	private static void accountList() {
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		for(int i=0; i<accountArrayAccounts.length; i++) {
			Account account = accountArrayAccounts[i];
			if(account !=null) {
			System.out.print(account.getAccountNum());
			System.out.println("          ");
			System.out.print(account.getOwner());
			System.out.println("          ");
			System.out.print(account.getBalance());
			System.out.println();
			}
		}
	}
	private static void deposit() {
		System.out.println("----------");
		System.out.println("예금");
		System.out.println("----------");
		System.out.println("계좌번호");
		String accountNum = scanner.nextLine();
		System.out.println("예금액");
		int deposit = Integer.parseInt(scanner.nextLine());
		Account account = findAccount(accountNum);
		if(account == null) {
			System.out.println("결과: 계좌가 없습니다.");
			return;
		}
		account.setBalance(account.getBalance()+deposit);
		System.out.println("결과: 예금성공");
	}
	private static void withdraw() {
		System.out.println("----------");
		System.out.println("예금");
		System.out.println("----------");
		System.out.println("계좌번호");
		String accountNum = scanner.nextLine();
		System.out.println("출금액");
		int deposit = Integer.parseInt(scanner.nextLine());
		Account account = findAccount(accountNum);
		if(account == null) {
			System.out.println("결과: 계좌가 없습니다.");
			return;
		}
			account.setBalance(account.getBalance()-deposit);
			System.out.println("결과: 출금성공");
		}	
	private static Account findAccount(String accountNum) {
		Account account = null;
		for(int i=0; i<accountArrayAccounts.length;i++) {
			if(accountArrayAccounts[i] !=null) {
				String dbAno = accountArrayAccounts[i].getAccountNum();
				if(dbAno.equals(accountNum)) {
					account = accountArrayAccounts[i];
					break;
				}
			}
		}
		return account;
	}
}
