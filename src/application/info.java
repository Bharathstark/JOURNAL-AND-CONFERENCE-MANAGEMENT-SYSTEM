package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;

public class info {

	@FXML AnchorPane pane;
	@FXML TextField cid;
	@FXML TextField cad;
	@FXML ComboBox<String> ctype;
	@FXML TextField coauthor;
	@FXML TextField ctoc;
	@FXML TextField cvenue;
	@FXML DatePicker cdate;
	@FXML TextField cpgno;
	@FXML TextField ctop;
	
	
public void initialize() {
		
		ctype.getItems().removeAll(ctype.getItems());
	    ctype.getItems().addAll("National", "International");
	    	}
	@FXML public void cinsert(ActionEvent event) {
		PreparedStatement stmt;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","oracle");
			stmt = conn.prepareStatement("insert into BHARATH.CONFERENCE values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,cid.getText());
			stmt.setString(2,cad.getText());
			stmt.setString(3,ctype.getValue().toString());
			stmt.setString(4,coauthor.getText());
			stmt.setString(5,ctoc.getText());
			stmt.setString(6,ctop.getText());
			stmt.setString(7,cvenue.getText());
			stmt.setString(8,cdate.getValue().toString());
			stmt.setString(9,cpgno.getText());
			stmt.executeUpdate();
			cid.setText(null);
			cad.setText(null);
			ctype.setValue(null);
			coauthor.setText(null);
			ctoc.setText(null);
			ctop.setText(null);
			cvenue.setText(null);
			cdate.setValue(null);
			cpgno.setText(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@FXML public void back(ActionEvent event) throws IOException {
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("/application/home.fxml"));
		pane.getChildren().setAll(pane1);
	}
	@FXML public void gen(ActionEvent event) throws IOException {
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("/application/gen1.fxml"));
		pane.getChildren().setAll(pane1);
	}
	
}
	