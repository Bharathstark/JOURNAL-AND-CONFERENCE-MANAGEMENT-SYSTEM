package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

public class ctablecontrol implements Initializable{

	@FXML TableView<ctablemodel> ctable;
	@FXML TableColumn<ctablemodel, String> fid;
	@FXML TableColumn<ctablemodel, String> fad;
	@FXML TableColumn<ctablemodel, String> ftype;
	@FXML TableColumn<ctablemodel, String> fcoauthor;
	@FXML TableColumn<ctablemodel, String> ftoc;
	@FXML TableColumn<ctablemodel, String> ftop;
	@FXML TableColumn<ctablemodel, String> fvenue;
	@FXML TableColumn<ctablemodel, String> fdate;
	@FXML TableColumn<ctablemodel, String> fpgno;
	ObservableList<ctablemodel> oblist=FXCollections.observableArrayList();
	@FXML AnchorPane pane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","oracle");
			ResultSet rs=conn.createStatement().executeQuery("select * from bharath.conference");
			while (rs.next())
			{
				oblist.add(new ctablemodel(rs.getString("f_id"),rs.getString("academic"),rs.getString("type1"),rs.getString("co_author"),rs.getString("top"),rs.getString("toc"),rs.getString("venue"), rs.getString("doa"),rs.getString("pageno")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		
		fid.setCellValueFactory(new PropertyValueFactory("id"));
		fad.setCellValueFactory(new PropertyValueFactory("ad"));
		ftype.setCellValueFactory(new PropertyValueFactory("type"));
		fcoauthor.setCellValueFactory(new PropertyValueFactory("coauthor"));
		ftoc.setCellValueFactory(new PropertyValueFactory("toc"));
		ftop.setCellValueFactory(new PropertyValueFactory("top"));
		fvenue.setCellValueFactory(new PropertyValueFactory("venue"));
		fdate.setCellValueFactory(new PropertyValueFactory("date"));
		fpgno.setCellValueFactory(new PropertyValueFactory("pgno"));
		
	ctable.setItems(oblist);
	}

	@FXML public void back() throws IOException {
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("/application/conference.fxml"));
		pane.getChildren().setAll(pane1);
	}
	

}