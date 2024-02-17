package State2;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "VACATION")
public class Vacation {

    private long personnelID;


    private Personnel personnel;

    private Date date;

    public Vacation() {
    }

    public Vacation(long personnelID, Personnel personnel, Date date) {
        this.personnelID = personnelID;
        this.personnel = personnel;
        this.date = date;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personnelID")
    public long getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(long personnelID) {
        this.personnelID = personnelID;
    }
    @Column(name = "personnel")
    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return personnelID == vacation.personnelID && Objects.equals(personnel, vacation.personnel) && Objects.equals(date, vacation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personnelID, personnel, date);
    }
}
