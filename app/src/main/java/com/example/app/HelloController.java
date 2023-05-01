package com.example.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class HelloController {
    @FXML
    public Text title;
    @FXML
    public Button botao;
    @FXML
    public TextField searchbox;

    @FXML
    public TableView<Weather> tinfo;

    @FXML
    public TableColumn<Weather, Double> tempmin;

    @FXML
    public TableColumn<Weather, Double> tempmax;

    @FXML
    public TableColumn<Weather, Date> datetime;

    @FXML
    public TableColumn<Weather, String> description;

    @FXML
    public Text geolocalizacao;
    @FXML
    public Text instruction;


    @FXML
    public void initialize() {
        title.setText("Welcome to Japan Weather APP.");
        botao.setText("Search");
        botao.setOnAction(this::handleButtonClick);
        instruction.setText("Enter a japanese region in the search box to display the weather conditions for the next two weeks.");
    }

    @FXML
    public void handleButtonClick(ActionEvent actionEvent)  {
        AP ap = new AP();
        String city = searchbox.getText();
        System.out.println(city);
        String link = ap.getApiEndPoint()+ ap.getLocation() + city + "/?unitGroup="+ap.getUnitGroup()+"&key="+ ap.getApiKey();
        System.out.println(link);
        try {
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            int responseCode = http.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                Object file = JSONValue.parse(response.toString());
                JSONObject json = (JSONObject)file;
                // print result
                //System.out.println(json);
                updateInfo(json);
            } else {
                System.out.println("GET request did not work.");
            }
        }catch (IOException i){
            System.out.println("stop");
        }
    }

    public void updateInfo(JSONObject json){
        ArrayList<JSONObject> dias = (ArrayList<JSONObject>) json.get("days");

        tempmin.setCellValueFactory(new PropertyValueFactory<>("Tempmin"));
        tempmax.setCellValueFactory(new PropertyValueFactory<>("Tempmax"));
        datetime.setCellValueFactory(new PropertyValueFactory<>("Datetime"));
        description.setCellValueFactory(new PropertyValueFactory<>("Description"));

        String address = (String) json.get("resolvedAddress");
        Double latitude = (Double) json.get("latitude");
        Double longitude = (Double) json.get("longitude");

        String loc = "Região: "+address+"\n"+"Latitude: "+latitude+"\n"+"Longitude: "+longitude;
        geolocalizacao.setText(loc);
        ObservableList<Weather> temps = FXCollections.observableArrayList();
        for(JSONObject t : dias){
            System.out.println((Double)t.get("tempmin"));
            Weather w = new Weather((Double)t.get("tempmin"),
                     (Double)t.get("tempmax"),
                     (String)t.get("datetime"),
                     (String)t.get("description"));
            temps.add(w);
        }
        tinfo.setItems(temps);
    }
}