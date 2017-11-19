package ua.com.shocell.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
@Cacheable
@Table(
        name = "tarif_plans"
)
public class TarifPlans {
    @Id
    @GeneratedValue
    @Column(
            name = "Tarif_ID"
    )
    private int tarifID;
    @Column(
            name = "Tarif_Name"
    )
    private String tarifName;
    @Column(
            name = "Minutes_to_ShoCell"
    )
    private int minutesToShoCell;
    @Column(
            name = "Minutes_to_other_operators"
    )
    private int minutesToOtherOperators;
    @Column(
            name = "SMS"
    )
    private int SMS;
    @Column(
            name = "Internet_volume"
    )
    private int internetVolume;
    @Column(
            name = "Tarif_Plan_Status"
    )
    private boolean tarifPlanStatus;
    @Column(
            name = "Tarif_Price"
    )
    private int tarifPrice;
    @Column(
            name = "Migration_Price"
    )
    private int migrationPrice;
    @OneToMany(
            mappedBy = "tarifPlansRecord",
            fetch = FetchType.LAZY
    )
    private Set<ActivatedServices> actTarifPlansRecords = new HashSet();

    public TarifPlans() {
    }

    public TarifPlans(String tarifName, int minutesToShoCell, int minutesToOtherOperators, int SMS, int internetVolume, boolean tarifPlanStatus, int tarifPrice, int migrationPrice) {
        this.tarifName = tarifName;
        this.minutesToShoCell = minutesToShoCell;
        this.minutesToOtherOperators = minutesToOtherOperators;
        this.SMS = SMS;
        this.internetVolume = internetVolume;
        this.tarifPlanStatus = tarifPlanStatus;
        this.tarifPrice = tarifPrice;
        this.migrationPrice = migrationPrice;
    }

    public int getTarifID() {
        return this.tarifID;
    }

    public void setTarifID(int tarifID) {
        this.tarifID = tarifID;
    }

    public String getTarifName() {
        return this.tarifName;
    }

    public void setTarifName(String tarifName) {
        this.tarifName = tarifName;
    }

    public int getMinutesToShoCell() {
        return this.minutesToShoCell;
    }

    public void setMinutesToShoCell(int minutesToShoCell) {
        this.minutesToShoCell = minutesToShoCell;
    }

    public int getMinutesToOtherOperators() {
        return this.minutesToOtherOperators;
    }

    public void setMinutesToOtherOperators(int minutesToOtherOperators) {
        this.minutesToOtherOperators = minutesToOtherOperators;
    }

    public int getSMS() {
        return this.SMS;
    }

    public void setSMS(int SMS) {
        this.SMS = SMS;
    }

    public int getInternetVolume() {
        return this.internetVolume;
    }

    public void setInternetVolume(int internetVolume) {
        this.internetVolume = internetVolume;
    }

    public boolean isTarifPlanStatus() {
        return this.tarifPlanStatus;
    }

    public void setTarifPlanStatus(boolean tarifPlanStatus) {
        this.tarifPlanStatus = tarifPlanStatus;
    }

    public int getTarifPrice() {
        return this.tarifPrice;
    }

    public void setTarifPrice(int tarifPrice) {
        this.tarifPrice = tarifPrice;
    }

    public int getMigrationPrice() {
        return this.migrationPrice;
    }

    public void setMigrationPrice(int migrationPrice) {
        this.migrationPrice = migrationPrice;
    }

    public Set<ActivatedServices> getActTarifPlansRecords() {
        return this.actTarifPlansRecords;
    }

    public void setActTarifPlansRecords(Set<ActivatedServices> actTarifPlansRecords) {
        this.actTarifPlansRecords = actTarifPlansRecords;
    }

    public String toString() {
        return "TarifPlans{tarifID=" + this.tarifID + ", tarifName='" + this.tarifName + '\'' + ", minutesToShoCell=" + this.minutesToShoCell + ", minutesToOtherOperators=" + this.minutesToOtherOperators + ", SMS=" + this.SMS + ", internetVolume=" + this.internetVolume + ", tarifPlanStatus=" + this.tarifPlanStatus + ", tarifPrice=" + this.tarifPrice + ", migrationPrice=" + this.migrationPrice + ", actTarifPlansRecords=" + this.actTarifPlansRecords + '}';
    }
}

