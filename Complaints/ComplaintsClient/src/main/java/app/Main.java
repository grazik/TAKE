package app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;

public class Main {
    private static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").create();;

    private static void printAllComplaints() {
        Client client = ClientBuilder.newClient();
        Complain[] allComplaints =
                gson.fromJson(client.target("http://localhost:8080/Complaints/resources/complaints/")
                        .request(MediaType.APPLICATION_JSON_TYPE)
                        .get(String.class), Complain[].class);
        client.close();

        System.out.println("-------------------------------------------------------------");
        for (Complain complain : allComplaints){
            System.out.println(complain);
        }
        System.out.println("-------------------------------------------------------------");
    }

    private static Complain getComplain(int id) {
        Client client = ClientBuilder.newClient();
        return gson.fromJson(client.target(String.format("http://localhost:8080/Complaints/resources/complaints/%d", id))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(String.class), Complain.class);
    }

    private static void modifyComplaint(Complain complain) {
        Client client = ClientBuilder.newClient();

        client.target(String.format("http://localhost:8080/Complaints/resources/complaints/%d", complain.getId()))
                .request()
                .put(Entity.entity(gson.toJson(complain), MediaType.APPLICATION_JSON_TYPE));
    }

    public static void main(String[] args) {
        printAllComplaints();
        Complain complain = getComplain(3);
        System.out.println(complain);

        complain.setComplaintText("altered foo Complain Text ");
        complain.setStatus("closed");

        modifyComplaint(complain);

        printAllComplaints();
    }
}
