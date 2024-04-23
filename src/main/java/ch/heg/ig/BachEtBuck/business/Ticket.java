package ch.heg.ig.BachEtBuck.business;

import ch.heg.ig.BachEtBuck.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

	@Column(name = "receipt_number")
	@NotNull
	private int receiptNumber;

	@Column(name = "purchase_date")
	@NotNull
	private Date purchaseDate;

	@Column(name = "total_amount")
	@NotNull
	private BigDecimal totalAmount;

	@Column(name = "items_purchased")
	@NotBlank
	private String itemsPurchased;

	@Column(name = "payment_method")
	@NotBlank
	private String paymentMethod;

	@Column(name = "store_location")
	@NotBlank
	private String storeLocation;

	@Column(name = "cashier_name")
	@NotBlank
	private String cashierName;

	@Column(name = "card_number")
	@NotBlank
	private String cardNumber;

	public int getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(int receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getItemsPurchased() {
		return itemsPurchased;
	}

	public void setItemsPurchased(String itemsPurchased) {
		this.itemsPurchased = itemsPurchased;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

	public String getCashierName() {
		return cashierName;
	}

	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "Ticket{" + "receiptNumber=" + receiptNumber + ", purchaseDate=" + purchaseDate + ", totalAmount="
				+ totalAmount + ", itemsPurchased='" + itemsPurchased + '\'' + ", paymentMethod='" + paymentMethod
				+ '\'' + ", storeLocation='" + storeLocation + '\'' + ", cashierName='" + cashierName + '\''
				+ ", cardNumber='" + cardNumber + '\'' + '}';
	}

}
