package models;

import java.util.HashMap;
import java.util.Map;

public class AccountDataBase {

	private static Map<String, Account> accounts = new HashMap<>();
	
	public void addAccount(Account acc) {
		accounts.put(acc.getUserName(), acc);
	}
	
	public Account getAccount(String userName) {
		return accounts.get(userName);
	}
	
	static {
        accounts.put("kito", new Account("kito", "bla"));
    }
}
