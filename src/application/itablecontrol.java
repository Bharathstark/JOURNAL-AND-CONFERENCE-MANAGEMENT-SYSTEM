package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class itablecontrol implements Initializable {

	@FXML Pane pane;
	@FXML TableView<itablemodel> Table;
	@FXML TableColumn<itablemodel, String> fid;
	@FXML TableColumn<itablemodel, String> academic;
	@FXML TableColumn<itablemodel, String> Type;
	@FXML TableColumn<itablemodel, String> author;
	@FXML TableColumn<itablemodel, String> top;
	@FXML TableColumn<itablemodel, String> nop;
	@FXML TableColumn<itablemodel, String> volume;
	@FXML TableColumn<itablemodel, String> issue;
	@FXML TableColumn<itablemodel, String> issn;
	@FXML TableColumn<itablemodel, String> month;
	@FXML TableColumn<itablemodel, String> year;
	ObservableList<itablemodel> oblist=FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","oracle");
			ResultSet rs=conn.createStatement().executeQuery("select * from bharath.journal");
			while (rs.next())
			{
				oblist.add(new itablemodel(rs.getString("f_id"),rs.getString("academic"),rs.getString("type1"),rs.getString("co_author"),rs.getString("top"),rs.getString("nop"),rs.getString("volume"), rs.getString("issue"),rs.getString("issn"), rs.getString("month"),rs.getString("year")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
		fid.setCellValueFactory(new PropertyValueFactory("id"));
		academic.setCellValueFactory(new PropertyValueFactory("academic"));
		Type.setCellValueFactory(new PropertyValueFactory("type"));
		author.setCellValueFactory(new PropertyValueFactory("author"));
		top.setCellValueFactory(new PropertyValueFactory("top"));
		nop.setCellValueFactory(new PropertyValueFactory("nop"));
		volume.setCellValueFactory(new PropertyValueFactory("volume"));
		issue.setCellValueFactory(new PropertyValueFactory("issue"));
		issn.setCellValueFactory(new PropertyValueFactory("issn"));
		month.setCellValueFactory(new PropertyValueFactory("month"));
		year.setCellValueFactory(new PropertyValueFactory("year"));
		Table.setItems(oblist);
	}
	@FXML
	public void iback() throws IOException {
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("/application/conference.fxml"));
		pane.getChildren().setAll(pane1);
	}
	
}
