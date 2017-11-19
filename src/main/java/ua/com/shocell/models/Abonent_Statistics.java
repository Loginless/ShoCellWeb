package ua.com.shocell.models;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@Component
@Entity
@Cacheable
@Table(
        name = "abonent_statistics"
)
public class Abonent_Statistics {
    @Id
    @GeneratedValue
    @Column(
            name = "Abonent_Statistics",
            unique = true,
            nullable = false
    )
    private int abonentStatistics;
    @Column(
            name = "Tarif_ID"
    )
    private int tarifID;
    @Column(
            name = "Service_ID"
    )
    private int serviceID;
    @Column(
            name = "Used_Voice_Services_Min"
    )
    private int usedVoiceServicesMin;
    @Column(
            name = "Used_Messaging_Services"
    )
    private int usedMessagingServices;
    @Column(
            name = "Used_Internet_Traffic"
    )
    private int usedInternetTraffic;
    @Column(
            name = "DATE_From",
            nullable = false
    )
    private Date dateFrom;
    @Column(
            name = "DATE_To",
            nullable = false
    )
    private Date dateTo;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            referencedColumnName = "Abonent_ID",
            foreignKey = @ForeignKey(
                    name = "fk_abon_abonStat"
            )
    )
    private Abonents abonentStatsRecord;

    public Abonent_Statistics() {
    }

    public Abonent_Statistics(int tarifID, int serviceID, int usedVoiceServicesMin, int usedMessagingServices, int usedInternetTraffic, Date dateFrom, Date dateTo, Abonents abonentStatsRecord) {
        this.tarifID = tarifID;
        this.serviceID = serviceID;
        this.usedVoiceServicesMin = usedVoiceServicesMin;
        this.usedMessagingServices = usedMessagingServices;
        this.usedInternetTraffic = usedInternetTraffic;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.abonentStatsRecord = abonentStatsRecord;
    }

    public int getAbonentStatistics() {
        return this.abonentStatistics;
    }

    public void setAbonentStatistics(int abonentStatistics) {
        this.abonentStatistics = abonentStatistics;
    }

    public int getTarifID() {
        return this.tarifID;
    }

    public void setTarifID(int tarifID) {
        this.tarifID = tarifID;
    }

    public int getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public int getUsedVoiceServicesMin() {
        return this.usedVoiceServicesMin;
    }

    public void setUsedVoiceServicesMin(int usedVoiceServicesMin) {
        this.usedVoiceServicesMin = usedVoiceServicesMin;
    }

    public int getUsedMessagingServices() {
        return this.usedMessagingServices;
    }

    public void setUsedMessagingServices(int usedMessagingServices) {
        this.usedMessagingServices = usedMessagingServices;
    }

    public int getUsedInternetTraffic() {
        return this.usedInternetTraffic;
    }

    public void setUsedInternetTraffic(int usedInternetTraffic) {
        this.usedInternetTraffic = usedInternetTraffic;
    }

    public Date getDateFrom() {
        return this.dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return this.dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Abonents getAbonentStatsRecord() {
        return this.abonentStatsRecord;
    }

    public void setAbonentStatsRecord(Abonents abonentStatsRecord) {
        this.abonentStatsRecord = abonentStatsRecord;
    }

    public String toString() {
        return "Abonent_Statistics{abonentStatistics=" + this.abonentStatistics + ", tarifID=" + this.tarifID + ", serviceID=" + this.serviceID + ", usedVoiceServicesMin=" + this.usedVoiceServicesMin + ", usedMessagingServices=" + this.usedMessagingServices + ", usedInternetTraffic=" + this.usedInternetTraffic + ", dateFrom=" + this.dateFrom + ", dateTo=" + this.dateTo + ", abonentStatsRecord=" + this.abonentStatsRecord + '}';
    }
}

