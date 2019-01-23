package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

public class homecontroller {
	@FXML
	private TextField fid ;
	@FXML
	 private TextField fname ;
	@FXML
	 private DatePicker fdate ;
	@FXML
	 private Button fadd ;
	@FXML
	private AnchorPane pane;
	
	public void add()
	{ 
		PreparedStatement stmt;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","oracle");
			stmt = conn.prepareStatement("insert into BHARATH.FACULTY values(?,?,?)");
			stmt.setString(1,fid.getText());
			stmt.setString(2,fname.getText());
			stmt.setString(3,fdate.getValue().toString());
			stmt.executeUpdate();
			fid.setText("");
			fname.setText("");
			fdate.setValue(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void confo() throws IOException
	{
	AnchorPane pane1=FXMLLoader.load(getClass().getResource("/application/conference.fxml"));
	pane.getChildren().setAll(pane1);
	
	}
	@FXML public void jinfo() throws IOException {
		AnchorPane pane2=FXMLLoader.load(getClass().getResource("/application/journal.fxml"));
		pane.getChildren().setAll(pane2);
	}
	@FXML public void repo(ActionEvent event) throws IOException {
		AnchorPane pane2=FXMLLoader.load(getClass().getResource("/application/report1.fxml"));
		pane.getChildren().setAll(pane2);
	}

}
