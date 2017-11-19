package ua.com.shocell.models;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Entity
@Table(
        name = "Individual_Abonents"
)
public class PrePaid extends Abonents {
    @Column(
            name = "Abonents_First_Name"
    )
    private String firstName;
    @Column(
            name = "Abonents_Second_Name"
    )
    private String secondName;

    public PrePaid() {
    }

    public PrePaid(String firstName, String secondName, long mobileNumber, boolean abonentStatus, WebUsers webUserID) {
        super(mobileNumber, abonentStatus, webUserID);
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String toString() {
        return super.toString() + "PrePaid{firstName='" + this.firstName + '\'' + ", secondName='" + this.secondName + '\'' + '}';
    }
}

