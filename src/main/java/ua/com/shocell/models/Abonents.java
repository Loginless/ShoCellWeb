package ua.com.shocell.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Cacheable
@Inheritance(
        strategy = InheritanceType.JOINED
)
@Table(
        name = "Abonents"
)
public class Abonents {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "Abonent_ID"
    )
    private int abonentID;
    @Column(
            name = "Mobile_Number"
    )
    private long mobileNumber;
    @Column(
            name = "Abonent_Status",
            nullable = false
    )
    private boolean abonentStatus;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "WebUserID",
            foreignKey = @ForeignKey(
                    name = "Fk_WebUsers_Abonents"
            )
    )
    private WebUsers webUserID;
    @OneToMany(
            mappedBy = "abonentID",
            fetch = FetchType.LAZY
    )
    private List<Payments> paymentRecords = new ArrayList();
    @OneToMany(
            mappedBy = "abonentStatsRecord",
            fetch = FetchType.LAZY
    )
    private List<Abonent_Statistics> abonStatRecords = new ArrayList();
    @OneToMany(
            mappedBy = "abonentActServ",
            fetch = FetchType.LAZY
    )
    private List<ActivatedServices> actServicesRecords = new ArrayList();

    public Abonents() {
    }

    public Abonents(long mobileNumber, boolean abonentStatus, WebUsers webUserID) {
        this.mobileNumber = mobileNumber;
        this.abonentStatus = abonentStatus;
        this.webUserID = webUserID;
    }

    public int getAbonentID() {
        return this.abonentID;
    }

    public void setAbonentID(int abonentID) {
        this.abonentID = abonentID;
    }

    public long getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isAbonentStatus() {
        return this.abonentStatus;
    }

    public void setAbonentStatus(boolean abonentStatus) {
        this.abonentStatus = abonentStatus;
    }

    public WebUsers getWebUserID() {
        return this.webUserID;
    }

    public void setWebUserID(WebUsers webUserID) {
        this.webUserID = webUserID;
    }

    public List<Payments> getPaymentRecords() {
        return this.paymentRecords;
    }

    public void setPaymentRecords(List<Payments> paymentRecords) {
        this.paymentRecords = paymentRecords;
    }

    public List<Abonent_Statistics> getAbonStatRecords() {
        return this.abonStatRecords;
    }

    public void setAbonStatRecords(List<Abonent_Statistics> abonStatRecords) {
        this.abonStatRecords = abonStatRecords;
    }

    public List<ActivatedServices> getActServicesRecords() {
        return this.actServicesRecords;
    }

    public void setActServicesRecords(List<ActivatedServices> actServicesRecords) {
        this.actServicesRecords = actServicesRecords;
    }

    public String toString() {
        return "Abonents{abonentID=" + this.abonentID + ", mobileNumber=" + this.mobileNumber + ", abonentStatus=" + this.abonentStatus + ", webUserID=" + this.webUserID + ", paymentRecords=" + this.paymentRecords + ", abonStatRecords=" + this.abonStatRecords + ", actServicesRecords=" + this.actServicesRecords + '}';
    }
}

