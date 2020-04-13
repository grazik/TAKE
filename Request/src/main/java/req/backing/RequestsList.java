/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package req.backing;

import java.time.LocalDate;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import req.entities.Request;
import req.facade.RequestFacadeLocal;

/**
 *
 * @author grazik
 */
@Named(value = "requestsList")
@RequestScoped
public class RequestsList {

    @Inject
    private RequestFacadeLocal requestFacade;
    private HtmlDataTable requestsDataTable;
    
    @Size(min = 3, max=60, message="{request.size}")
    private String newRequest;

    public List<Request> getAllRequests() {
        return this.requestFacade.findAll();
    }

    /**
     * Get the value of newRequest
     *
     * @return the value of newRequest
     */
    public String getNewRequest() {
        return newRequest;
    }

    /**
     * Set the value of newRequest
     *
     * @param newRequest new value of newRequest
     */
    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    /**
     * Get the value of requestsDataTable
     *
     * @return the value of requestsDataTable
     */
    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    /**
     * Set the value of requestsDataTable
     *
     * @param requestsDataTable new value of requestsDataTable
     */
    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }

    public String deleteRequest() {
        Request req = (Request) getRequestsDataTable().getRowData();
        this.requestFacade.remove(req);

        return null;
    }

    public String addRequest() {
        Request req = new Request();
        req.setRequestText(newRequest);
        req.setRequestDate(LocalDate.now());
        this.requestFacade.create(req);
        setNewRequest("");
        return null;
    }

    /**
     * ś
     * Creates a new instance of RequestsList
     */
    public RequestsList() {
    }

}
