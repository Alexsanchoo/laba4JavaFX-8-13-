package variant8.Client;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import variant8.MilitaryTechnics;

public class TableMilitary {

    private TableView<MilitaryTechnics> table = null;

    public TableMilitary(ObservableList<MilitaryTechnics> items) {
        table = new TableView<>(items);
        TableColumn<MilitaryTechnics, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<MilitaryTechnics, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<MilitaryTechnics, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<MilitaryTechnics, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn<MilitaryTechnics, Integer> yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<MilitaryTechnics, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(idColumn, categoryColumn, nameColumn, countryColumn, yearColumn, priceColumn);
        table.setPrefSize(480, 500);
    }

    public TableView<MilitaryTechnics> getTable() {
        return table;
    }
}
