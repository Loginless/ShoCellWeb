package ua.com.shocell.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@Component
@Entity
@Cacheable
@Table(
        name = "activated_services"
)
public class ActivatedServices {
    @Id
    @GeneratedValue
    @Column(
            name = "Activated_Services_ID"
    )
    private int activatedServicesID;
    @Column(
            name = "Date"
    )
    private Date date;
    @Column(
            name = "Total_Price"
    )
    private int totalPrice;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "Abonent_ID",
            foreignKey = @ForeignKey(
                    name = "Fk_Abonents_ActServ"
            )
    )
    private Abonents abonentActServ;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "Tarif_ID",
            foreignKey = @ForeignKey(
                    name = "Fk_Tarifs_ActServ"
            )
    )
    private TarifPlans tarifPlansRecord;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "Service_ID",
            foreignKey = @ForeignKey(
                    name = "Fk_Services_ActServ"
            )
    )
    private Services servicesRecord;

    public ActivatedServices() {
    }

    public ActivatedServices(Date date, int totalPrice) {
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public int getActivatedServicesID() {
        return this.activatedServicesID;
    }

    public void setActivatedServicesID(int activatedServicesID) {
        this.activatedServicesID = activatedServicesID;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Abonents getAbonentActServ() {
        return this.abonentActServ;
    }

    public void setAbonentActServ(Abonents abonentActServ) {
        this.abonentActServ = abonentActServ;
    }

    public TarifPlans getTarifPlansRecord() {
        return this.tarifPlansRecord;
    }

    public void setTarifPlansRecord(TarifPlans tarifPlansRecord) {
        this.tarifPlansRecord = tarifPlansRecord;
    }

    public Services getServicesRecord() {
        return this.servicesRecord;
    }

    public void setServicesRecord(Services servicesRecord) {
        this.servicesRecord = servicesRecord;
    }

    public String toString() {
        return "ActivatedServices{activatedServicesID=" + this.activatedServicesID + ", date=" + this.date + ", totalPrice=" + this.totalPrice + ", abonentActServ=" + this.abonentActServ + ", tarifPlansRecord=" + this.tarifPlansRecord + ", servicesRecord=" + this.servicesRecord + '}';
    }
}

