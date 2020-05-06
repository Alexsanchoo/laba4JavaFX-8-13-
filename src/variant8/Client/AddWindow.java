package variant8.Client;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import variant8.MilitaryTechnics;


public class AddWindow {

    private MilitaryTechnics technic = null;


    MilitaryTechnics getTechnic() {
        return technic;
    }

    public AddWindow(Stage primaryStage) {
        Stage stage = new Stage();
        stage.setTitle("Add new information");

        VBox pane = new VBox(10);
        pane.setPadding(new Insets(15, 20, 10, 10));

        Label categoryLbl = new Label("Enter category: ");
        ComboBox<String> categoryCb = new ComboBox<>(FXCollections.observableArrayList("сухопутная", "воздушная", "водная"));
        categoryCb.setValue("сухопутная");
        Label nameLbl = new Label("Enter name: ");
        TextField nameTf = new TextField();
        Label countryLbl = new Label("Enter country: ");
        TextField countryTf = new TextField();
        Label yearLbl = new Label("Enter year: ");
        TextField yearTf = new TextField();
        Label priceLbl = new Label("Enter price: ");
        TextField priceTf = new TextField();

        Button addBtn = new Button("add");

        addBtn.setOnAction(event -> {
            try{
                technic = new MilitaryTechnics(0, categoryCb.getValue(), nameTf.getText(), countryTf.getText(),
                        Integer.parseInt(yearTf.getText()), Double.parseDouble(priceTf.getText()));
                stage.close();
            } catch(NumberFormatException e) {
                e.printStackTrace();
                new WarningWindow(stage, "Invalid input!");
            }
        });

        pane.getChildren().addAll(categoryLbl, categoryCb, nameLbl, nameTf, countryLbl, countryTf, yearLbl, yearTf,
                priceLbl, priceTf, addBtn);
        Scene scene = new Scene(pane, 480, 500);
        stage.setScene(scene);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);

        stage.showAndWait();
    }
}
