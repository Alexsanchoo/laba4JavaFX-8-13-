package variant13.Client;

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
import variant13.Shop;


public class AddWindow {

    private Shop shop = null;


    Shop getShop() {
        return shop;
    }

    public AddWindow(Stage primaryStage) {
        Stage stage = new Stage();
        stage.setTitle("Add new information");

        VBox pane = new VBox(10);
        pane.setPadding(new Insets(15, 20, 10, 10));

        Label categoryLbl = new Label("Enter category: ");
        ComboBox<String> categoryCb = new ComboBox<>(FXCollections.observableArrayList("продуктовый", "хозяйственный", "одежда"));
        categoryCb.setValue("продуктовый");
        Label nameLbl = new Label("Enter name: ");
        TextField nameTf = new TextField();
        Label addressLbl = new Label("Enter address: ");
        TextField addressTf = new TextField();
        Label retailSpaceLbl = new Label("Enter retail space: ");
        TextField retailSpaceTf = new TextField();
        Label capitalLbl = new Label("Enter capital: ");
        TextField capitalTf = new TextField();

        Button addBtn = new Button("add");

        addBtn.setOnAction(event -> {
            try{
                shop = new Shop(0, categoryCb.getValue(), nameTf.getText(), addressTf.getText(),
                        Integer.parseInt(retailSpaceTf.getText()), Double.parseDouble(capitalTf.getText()));
                stage.close();
            } catch(NumberFormatException e) {
                e.printStackTrace();
                new WarningWindow(stage, "Invalid input!");
            }
        });

        pane.getChildren().addAll(categoryLbl, categoryCb, nameLbl, nameTf, addressLbl, addressTf, retailSpaceLbl, retailSpaceTf,
                capitalLbl, capitalTf, addBtn);
        Scene scene = new Scene(pane, 480, 500);
        stage.setScene(scene);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);

        stage.showAndWait();
    }
}
