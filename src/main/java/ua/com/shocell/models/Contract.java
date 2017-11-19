package ua.com.shocell.models;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Entity
@Table(
        name = "Contract_Abonents"
)
public class Contract extends Abonents {
    @Column(
            name = "Contract_ID"
    )
    private int contractID;
    @Column(
            name = "Passport_ID",
            unique = true
    )
    private int passportID;
    @Column(
            name = "Discounts"
    )
    private int discount;

    public Contract() {
    }

    public Contract(int contractID, int passportID, int discount, long mobileNumber, boolean abonentStatus, WebUsers webUserID) {
        super(mobileNumber, abonentStatus, webUserID);
        this.contractID = contractID;
        this.passportID = passportID;
        this.discount = discount;
    }

    public int getContractID() {
        return this.contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getPassportID() {
        return this.passportID;
    }

    public void setPassportID(int quantityOfWorkers) {
        this.passportID = quantityOfWorkers;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String toString() {
        return super.toString() + "Contract{contractID=" + this.contractID + ", passportID=" + this.passportID + ", discount=" + this.discount + '}';
    }
}

