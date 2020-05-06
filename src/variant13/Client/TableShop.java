package variant13.Client;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import variant13.Shop;

public class TableShop {

    private TableView<Shop> table = null;

    public TableShop(ObservableList<Shop> items) {
        table = new TableView<>(items);
        TableColumn<Shop, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Shop, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Shop, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Shop, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Shop, Integer> retailSpaceColumn = new TableColumn<>("Retail Space");
        retailSpaceColumn.setCellValueFactory(new PropertyValueFactory<>("retailSpace"));

        TableColumn<Shop, Double> capitalColumn = new TableColumn<>("Capital");
        capitalColumn.setCellValueFactory(new PropertyValueFactory<>("capital"));

        table.getColumns().addAll(idColumn, categoryColumn, nameColumn, addressColumn, retailSpaceColumn, capitalColumn);
        table.setPrefSize(480, 500);
    }

    public TableView<Shop> getTable() {
        return table;
    }
}
