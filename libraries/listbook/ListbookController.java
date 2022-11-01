package libraries.listbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import libraries.Book;
import libraries.createbook.Main;
import libraries.edit.EditController;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ListbookController implements Initializable {
    public TableView<Book> tbBook;
    public static ObservableList<Book> tb = FXCollections.observableArrayList();
    public TextField txtSearch;
    public TableColumn<Book,String> clCode;
    public TableColumn<Book,String> clName;

    public TableColumn<Book,String> clAuthor;
    public TableColumn<Book,String> clpPublishingCompanny;
    public TableColumn<Book,String> clType;
    public TableColumn<Book,String> clPrice;
    public TableColumn<Book,String> clAmount;
    private boolean sortName = true;
    private boolean sortAmount = true;
     public final static String connectionString = "jdbc:mysql://localhost:3306/t2204m";
     public final  static String user = "root";
     public  final static  String pwd ="";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        clName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        clpPublishingCompanny.setCellValueFactory(new PropertyValueFactory<>("publishingCompany"));
        clType.setCellValueFactory(new PropertyValueFactory<>("type"));
        clPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        clAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tbBook.setItems(tb);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);
            Statement stt =conn.createStatement();
            String sql_txt = "select * from libraries";
            ResultSet rs =stt.executeQuery(sql_txt);
            while (rs.next()){
                int code = rs.getInt("code");
                String name =rs.getString("name");
                String author =rs.getString("author");
                String publishingCompany =rs.getString("publishingCompany");
                String type =rs.getString("type");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                Book b = new Book(code,name,author,publishingCompany,type,price,amount);
                tb.add(b);
            }

        } catch (ClassNotFoundException | SQLException e) {
         System.out.println(e.getMessage());
        }
        tbBook.setItems(tb);
    }


    public void add(ActionEvent actionEvent) throws IOException {
        Parent listScene = FXMLLoader.load(getClass().getResource("../createbook/addbook.fxml"));
        Scene sc = new Scene(listScene,800,600);
        Main.rootStage.setScene(sc);
    }

    public void edit(ActionEvent actionEvent) throws IOException {
        Book editBook = (Book) tbBook.getSelectionModel().getSelectedItem();
        EditController.editBook = editBook;
        EditController.tb = tb;
        Parent listScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../edit/edit.fxml")));
        Scene sc = new Scene(listScene,800,600);
        Main.rootStage.setTitle("EDIT BOOK");
        Main.rootStage.setScene(sc);
    }

    public void delete(ActionEvent actionEvent) {
        Book delete = (Book) tbBook.getSelectionModel().getSelectedItem();
        tb.remove(delete);
    }

    public void search(ActionEvent actionEvent) {
        try {
            String s = txtSearch.getText();
            if(s.isEmpty()){
                tbBook.setItems(tb);
                throw new Exception("Vui lòng nhập từ cần tìm kiếm");
            }

            ObservableList<Book> results = tb.stream()
                    .filter(student -> student.getName().toLowerCase().contains(s.toLowerCase()))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            tbBook.setItems(results);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void sortByName(ActionEvent actionEvent) {
        Collections.sort(tb, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return sortName?o1.getName().compareTo(o2.getName()):o2.getName().compareTo(o1.getName());
            }
        });
        sortName = !sortName;
        tbBook.refresh();
    }

    public void sortByAmount(ActionEvent actionEvent) {
        Collections.sort(tb, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return sortAmount?o1.getAmount().compareTo(o2.getAmount()):o2.getAmount().compareTo(o1.getAmount());
            }
        });
        sortAmount = !sortAmount;
        tbBook.refresh();
    }
}
