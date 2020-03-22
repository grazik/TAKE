/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.ResourceBundle;

/**
 *
 * @author grazik
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    private String username;
    private String password;
    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;

    public LoginBean() {}

    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }

    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox) {
        this.acceptCheckbox = acceptCheckbox;
    }

    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
        if(username.equals("scott") && password.equals("Tiger")){
            FacesContext context = FacesContext.getCurrentInstance();
            ResourceBundle properites = ResourceBundle.getBundle("ApplicationMessages", context.getViewRoot().getLocale());
            FacesMessage errorMessage = new FacesMessage(properites.getString("validation.oracle"));
            errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, errorMessage);
            context.renderResponse();
            return null;
        } else if (username.equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }

    public void activateButton(ValueChangeEvent e) {
        if (acceptCheckbox.isSelected()) {
            loginButton.setDisabled(false);
        } else {
            loginButton.setDisabled(true);
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
    }
}
