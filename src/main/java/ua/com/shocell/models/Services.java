package ua.com.shocell.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
@Cacheable
@Table(
        name = "services"
)
public class Services {
    @Id
    @GeneratedValue
    @Column(
            name = "Service_ID"
    )
    private int serviceID;
    @Column(
            name = "Service_Name"
    )
    private String serviceName;
    @Column(
            name = "Category"
    )
    private String category;
    @Column(
            name = "Description"
    )
    private String Description;
    @Column(
            name = "Add_Minutes_to_ShoCell"
    )
    private int addMinutesToShoCell;
    @Column(
            name = "Add_Minutes_to_other_operators"
    )
    private int addMinutesToOtherOperators;
    @Column(
            name = "Add_SMS"
    )
    private int addSMS;
    @Column(
            name = "Add_Internet_volume"
    )
    private int addInternetVolume;
    @Column(
            name = "Activation_Price"
    )
    private int activationPrice;
    @OneToMany(
            mappedBy = "servicesRecord",
            fetch = FetchType.LAZY
    )
    private Set<ActivatedServices> activateServRecords = new HashSet();

    public Services() {
    }

    public Services(String serviceName, String category, String description, int addMinutesToShoCell, int addMinutesToOtherOperators, int addSMS, int addInternetVolume, int activationPrice) {
        this.serviceName = serviceName;
        this.category = category;
        this.Description = description;
        this.addMinutesToShoCell = addMinutesToShoCell;
        this.addMinutesToOtherOperators = addMinutesToOtherOperators;
        this.addSMS = addSMS;
        this.addInternetVolume = addInternetVolume;
        this.activationPrice = activationPrice;
    }

    public int getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public int getAddMinutesToShoCell() {
        return this.addMinutesToShoCell;
    }

    public void setAddMinutesToShoCell(int addMinutesToShoCell) {
        this.addMinutesToShoCell = addMinutesToShoCell;
    }

    public int getAddMinutesToOtherOperators() {
        return this.addMinutesToOtherOperators;
    }

    public void setAddMinutesToOtherOperators(int addMinutesToOtherOperators) {
        this.addMinutesToOtherOperators = addMinutesToOtherOperators;
    }

    public int getAddSMS() {
        return this.addSMS;
    }

    public void setAddSMS(int addSMS) {
        this.addSMS = addSMS;
    }

    public int getAddInternetVolume() {
        return this.addInternetVolume;
    }

    public void setAddInternetVolume(int addInternetVolume) {
        this.addInternetVolume = addInternetVolume;
    }

    public int getActivationPrice() {
        return this.activationPrice;
    }

    public void setActivationPrice(int activationPrice) {
        this.activationPrice = activationPrice;
    }

    public Set<ActivatedServices> getActivateServRecords() {
        return this.activateServRecords;
    }

    public void setActivateServRecords(Set<ActivatedServices> activateServRecords) {
        this.activateServRecords = activateServRecords;
    }

    public String toString() {
        return "Services{serviceID=" + this.serviceID + ", serviceName='" + this.serviceName + '\'' + ", category='" + this.category + '\'' + ", Description='" + this.Description + '\'' + ", addMinutesToShoCell=" + this.addMinutesToShoCell + ", addMinutesToOtherOperators=" + this.addMinutesToOtherOperators + ", addSMS=" + this.addSMS + ", addInternetVolume=" + this.addInternetVolume + ", activationPrice=" + this.activationPrice + ", activateServRecords=" + this.activateServRecords + '}';
    }
}

