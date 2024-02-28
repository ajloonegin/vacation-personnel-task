package State2.entity;



import java.io.Serializable;
import java.util.Objects;


public class Personnel implements Serializable {
    private String nationalCode;
    private String firstName;
    private String lastName;
    private String cityName;

    public Personnel() {
    }

    public Personnel(String nationalCode, String firstName, String lastName, String cityName) {
        setNationalCode(nationalCode);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cityName = cityName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        if(nationalCode.length()<=10){
            this.nationalCode = nationalCode;
        } else {
            System.out.println("invalid national code");

        }


    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "nationalCode='" + nationalCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personnel personnel = (Personnel) o;
        return Objects.equals(nationalCode, personnel.nationalCode);
    }


    @Override
    public int hashCode() {
        return Objects.hash(nationalCode, firstName, lastName, cityName);
    }
}
