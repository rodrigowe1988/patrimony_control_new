package application.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Investment {

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private Date date;
    private Double cash;

    public Investment(Date date, Double cash) {
        this.date = date;
        this.cash = cash;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Invest{" +
                "date=" + format.format(date) +
                ", cash=" + cash +
                '}';
    }
}
