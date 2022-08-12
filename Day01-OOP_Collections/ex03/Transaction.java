import java.util.UUID;

public class Transaction {
    public enum    TransferCategory {
        DEBITS,
        CREDITS
    }

    private UUID                identifier;
    private User                recipient;
    private User                sender;
    private TransferCategory    transferCategory;
    private Integer             transferAmount;

    public Transaction(User recipient, User sender, Integer transferAmount) {
        if (transferAmount == 0) {
            System.out.println("Transfer amount should not be equal to zero!");
        } else if (transferAmount < 0 && sender.getBalance() < transferAmount * (-1)) {
            System.out.println("The sender does not have enough money to transfer!");
        } else if (transferAmount < 0) {
            this.transferCategory = TransferCategory.CREDITS;
            this.identifier = UUID.randomUUID();
            this.recipient = recipient;
            this.sender = sender;
            this.transferAmount = transferAmount;
            sender.setBalance(sender.getBalance() + transferAmount);
            sender.getTransactionsList().addTransaction(this);
        } else {
            this.transferCategory = TransferCategory.DEBITS;
            this.identifier = UUID.randomUUID();
            this.recipient = recipient;
            this.sender = sender;
            this.transferAmount = transferAmount;
            recipient.setBalance(recipient.getBalance() + transferAmount);
            recipient.getTransactionsList().addTransaction(this);
        }
    }

    public Transaction(Transaction copy) {
        this.identifier = copy.getIdentifier();
        this.recipient = copy.getRecipient();
        this.sender = copy.getSender();
        this.transferCategory = copy.getTransferCategory();
        this.transferAmount = copy.getTransferAmount();
    }

    public TransferCategory getTransferCategory() {
        return transferCategory;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }
}
