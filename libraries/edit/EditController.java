package libraries.edit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import libraries.Book;
import libraries.listbook.ListbookController;
import libraries.createbook.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.sql.*;

public class EditController implements Initializable {

    public TextField txteditCode;
    public TextField txteditName;
    public TextField txteditAuthor;
    public TextField txteditPrice;
    public TextField txteditAmount;
    public ComboBox cbeditPubCompany;
    public ComboBox cbeditType;
    public static ObservableList<Book> tb;
    public static Book editBook;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> publishingCompany = FXCollections.observableArrayList();
        publishingCompany.add("nha xuat ban Tre");
        publishingCompany.add("nha xuat ban Kim Dong");
        publishingCompany.add("nha xuat ban tong hop tp.HCM");
        publishingCompany.add("nha xuat ban Hoi Nha Van");
        publishingCompany.add("nha xuat ban Phu Nu Viet Nam");
        publishingCompany.add("nha xuat ban Lao Dong");
        publishingCompany.add("nha xuat ban Giao Duc");
        publishingCompany.add("nha xuat ban Thong Tin va Truyen Thong");
        ObservableList<String> typebook = FXCollections.observableArrayList();
        typebook.add("sach chinh tri va phap luat");
        typebook.add("sach khoa hoc cong nghe - kinh te");
        typebook.add("sach van hoc nghe thuat");
        typebook.add("sach van hoa xa hoi - lich su");
        typebook.add("sach truyen, tieu thuyet");
        typebook.add("sach tam li ,tam linh ,ton giao");
        typebook.add("sach thieu nhi");
        txteditCode.setText(editBook.getCode().toString());
        txteditName.setText(editBook.getName());
        txteditAuthor.setText(editBook.getAuthor());
        txteditPrice.setText(editBook.getPrice().toString());
        cbeditPubCompany.setItems(publishingCompany);
        cbeditType.setItems(typebook);
        cbeditPubCompany.setValue(editBook.getPublishingCompany());
        cbeditType.setValue(editBook.getType());
        txteditAmount.setText(editBook.getAmount().toString());

    }

    public void listBook(ActionEvent actionEvent) throws IOException {
        Parent listScene = FXMLLoader.load(getClass().getResource("../listbook/listbook.fxml"));
        Scene sc = new Scene(listScene, 800, 600);
        Main.rootStage.setScene(sc);
   }

    public void update(ActionEvent actionEvent) {
        try {
            Integer pr = Integer.parseInt(txteditPrice.getText());
            Integer amounts = Integer.parseInt(txteditAmount.getText());
            Integer code = Integer.parseInt(txteditCode.getText());
            editBook.setCode(code);
            editBook.setName(txteditPrice.getText());
            editBook.setAuthor(txteditAuthor.getText());
            editBook.setPrice(pr);
            editBook.setAmount(amounts);
            editBook.setPublishingCompany(cbeditPubCompany.getValue().toString());
            editBook.setType(cbeditType.getValue().toString());
            int index = tb.indexOf(editBook);
            tb.remove(index);
            tb.add(index, editBook);
            ListbookController.tb = tb;
            listBook(null);


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }
}
