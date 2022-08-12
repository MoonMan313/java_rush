public class User {
    private Integer                 id;
    private String                  name;
    private Integer                 balance;
    private TransactionsLinkedList  transactionsList;

    public TransactionsLinkedList getTransactionsList() {
        return transactionsList;
    }

    public User (String name, Integer balance) {
        this.name = name;
        if (balance > 0) {
            this.balance = balance;
        }
        else {
            this.balance = 0;
        }
        this.id = UserIdsGenerator.getInstance().generateId();
        this.transactionsList = new TransactionsLinkedList();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        if (balance > 0) {
            this.balance = balance;
        }
        else {
            this.balance = 0;
        }
    }
}