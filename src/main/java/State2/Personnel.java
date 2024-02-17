package State2;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PERSONNEL")
public class Personnel implements Serializable {
    private long personnelID;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String cityName;

    public Personnel() {
    }

    public Personnel(long personnelID, String firstName, String lastName, String nationalCode, String cityName) {
        this.personnelID = personnelID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.cityName = cityName;
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
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "cityName")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    @Column(name = "nationalCode")
    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personnel personnel = (Personnel) o;
        return personnelID == personnel.personnelID && Objects.equals(firstName, personnel.firstName) && Objects.equals(lastName, personnel.lastName) && Objects.equals(nationalCode, personnel.nationalCode) && Objects.equals(cityName, personnel.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personnelID, firstName, lastName, nationalCode, cityName);
    }
}
