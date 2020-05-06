package variant13.Client;

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
import variant13.Shop;

import java.util.ArrayList;

public class EditWindow {
    private Shop shop = null;

    public Shop getShop() {
        return shop;
    }

    public EditWindow(Stage primaryStage, ObservableList<Shop> items) {
        Stage stage = new Stage();
        stage.setTitle("Edit record");

        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);

        TableShop table = new TableShop(items);

        ArrayList<Integer> choice = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            choice.add(items.get(i).getId());
        }
        ComboBox<Integer> idCb = new ComboBox<>(FXCollections.observableArrayList(choice));

        Button editBtn = new Button("edit");


        editBtn.setOnAction(event -> {

            Shop shopTemp = null;

            int recToEdit = idCb.getValue();
            for (int i = 0; i < items.size(); i++) {
                if(items.get(i).getId() == recToEdit) {
                    shopTemp = items.get(i);
                    break;
                }
            }

            VBox boxEdit = new VBox(10);
            boxEdit.setAlignment(Pos.CENTER);

            Label categoryLbl = new Label("Category: ");
            ComboBox<String> categoryCb = new ComboBox<>(FXCollections.observableArrayList("продуктовый", "хозяйственный", "одежда"));
            categoryCb.setValue(shopTemp.getCategory());

            Label nameLbl = new Label("Name: ");
            TextField nameTf = new TextField(shopTemp.getName());

            Label addressLbl = new Label("Address: ");
            TextField addressTf = new TextField(shopTemp.getAddress());

            Label retailSpaceLbl = new Label("Retail space: ");
            TextField retailSpaceTf = new TextField(String.valueOf(shopTemp.getRetailSpace()));

            Label capitalLbl = new Label("Capital: ");
            TextField capitalTf = new TextField(String.valueOf(shopTemp.getCapital()));

            Button edit2Btn = new Button("edit");

            Shop finalShopTemp = shopTemp;
            edit2Btn.setOnAction(event2 -> {
                try{
                    shop = new Shop(finalShopTemp.getId(), categoryCb.getValue(), nameTf.getText(), addressTf.getText(),
                            Integer.parseInt(retailSpaceTf.getText()), Double.parseDouble(capitalTf.getText()));
                    stage.close();
                } catch(NumberFormatException e) {
                    e.printStackTrace();
                    new WarningWindow(stage, "Invalid input!");
                }
            });

            boxEdit.getChildren().addAll(categoryLbl, categoryCb, nameLbl, nameTf, addressLbl, addressTf, retailSpaceLbl, retailSpaceTf, capitalLbl, capitalTf,
                    edit2Btn);
            Scene sceneEdit = new Scene(boxEdit, 620, 600);
            stage.setScene(sceneEdit);
        });

        box.getChildren().addAll(table.getTable(), new Label("Make a choice: "), idCb, editBtn);
        Scene scene = new Scene(box, 620, 600);
        stage.setScene(scene);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        stage.showAndWait();
    }
}
