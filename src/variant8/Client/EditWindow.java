package variant8.Client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import variant8.MilitaryTechnics;

import java.util.ArrayList;

public class EditWindow {
    private MilitaryTechnics technic = null;

    public MilitaryTechnics getTechnic() {
        return technic;
    }

    public EditWindow(Stage primaryStage, ObservableList<MilitaryTechnics> items) {
        Stage stage = new Stage();
        stage.setTitle("Edit record");

        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);

        TableMilitary table = new TableMilitary(items);

        ArrayList<Integer> choice = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            choice.add(items.get(i).getId());
        }
        ComboBox<Integer> idCb = new ComboBox<>(FXCollections.observableArrayList(choice));

        Button editBtn = new Button("edit");


        editBtn.setOnAction(event -> {

            MilitaryTechnics technicTemp = null;

            int recToEdit = idCb.getValue();
            for (int i = 0; i < items.size(); i++) {
                if(items.get(i).getId() == recToEdit) {
                    technicTemp = items.get(i);
                    break;
                }
            }

            VBox boxEdit = new VBox(10);
            boxEdit.setAlignment(Pos.CENTER);

            Label categoryLbl = new Label("Category: ");
            ComboBox<String> categoryCb = new ComboBox<>(FXCollections.observableArrayList("сухопутная", "воздушная", "водная"));
            categoryCb.setValue(technicTemp.getCategory());

            Label nameLbl = new Label("Name: ");
            TextField nameTf = new TextField(technicTemp.getName());

            Label countryLbl = new Label("Country: ");
            TextField countryTf = new TextField(technicTemp.getCountry());

            Label yearLbl = new Label("Year: ");
            TextField yearTf = new TextField(String.valueOf(technicTemp.getYear()));

            Label priceLbl = new Label("Price: ");
            TextField priceTf = new TextField(String.valueOf(technicTemp.getPrice()));

            Button edit2Btn = new Button("edit");

            MilitaryTechnics finalTechnicTemp = technicTemp;
            edit2Btn.setOnAction(event2 -> {
                try{
                    technic = new MilitaryTechnics(finalTechnicTemp.getId(), categoryCb.getValue(), nameTf.getText(), countryTf.getText(),
                            Integer.parseInt(yearTf.getText()), Double.parseDouble(priceTf.getText()));
                    stage.close();
                } catch(NumberFormatException e) {
                    e.printStackTrace();
                    new WarningWindow(stage, "Invalid input!");
                }
            });

            boxEdit.getChildren().addAll(categoryLbl, categoryCb, nameLbl, nameTf, countryLbl, countryTf, yearLbl, yearTf, priceLbl, priceTf,
                    edit2Btn);
            Scene sceneEdit = new Scene(boxEdit, 480, 600);
            stage.setScene(sceneEdit);
        });

        box.getChildren().addAll(table.getTable(), new Label("Make a choice: "), idCb, editBtn);
        Scene scene = new Scene(box, 480, 600);
        stage.setScene(scene);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        stage.showAndWait();
    }
}
