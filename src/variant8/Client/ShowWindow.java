package variant8.Client;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import variant8.MilitaryTechnics;

public class ShowWindow {

    public ShowWindow(Stage primaryStage, ObservableList<MilitaryTechnics> items) {
        Stage stage = new Stage();
        stage.setTitle("Show information");

        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);

        TableMilitary table = new TableMilitary(items);

        pane.getChildren().add(table.getTable());
        Scene scene = new Scene(pane, 480,500);
        stage.setScene(scene);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);

        stage.setX(primaryStage.getX());
        stage.setY(primaryStage.getY());

        stage.showAndWait();
    }
}
