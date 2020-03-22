package main.java.view.backing;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.Date;

@Named(value = "sumBean")
@RequestScoped
public class SumBean {
    private int number1;
    private int number2;
    private Date timestamp = new Date();

    public Date getTimestamp() {
        return this.timestamp;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void showMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage facesMessage1 = new FacesMessage(String.format("%d + %d = %d", number1, number2, number1 + number2));
        context.addMessage(null, facesMessage1);
    }
}
