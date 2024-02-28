package State2.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;


public class Vacation {

    private String nationalCode;
    private Date date;

    public Vacation() {
    }
    public Vacation(String nationalCode, Date date) {
        this.nationalCode = nationalCode;
        this.date = date;
    }


    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "nationalCode='" + nationalCode + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return Objects.equals(nationalCode, vacation.nationalCode) && Objects.equals(date, vacation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalCode, date);
    }
}
