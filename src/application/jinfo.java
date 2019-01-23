package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class jinfo {

	@FXML TextField iid;
	@FXML TextField iad;
	@FXML ComboBox<String> itype;
	@FXML TextField iauthor;
	@FXML TextField itop;
	@FXML TextField ivolume;
	@FXML TextField iissue;
	@FXML TextField iissn;
	@FXML ComboBox<String> imonth;
	@FXML TextField iyear;
	@FXML TextField inop;
	@FXML AnchorPane pane;
	public void initialize()
	{
		 itype.getItems().removeAll(itype.getItems());
		    itype.getItems().addAll("National", "International");
		    imonth.getItems().removeAll(imonth.getItems());
		    imonth.getItems().addAll("January", "Febrauary","March","April","May","June","July","August","September","October","November","December");
	}
	@FXML public void iback() throws IOException {
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("/application/home.fxml"));
		pane.getChildren().setAll(pane1);
	}
	@FXML public void iinsert() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","oracle");
		PreparedStatement stmt = conn.prepareStatement("insert into BHARATH.JOURNAL values(?,?,?,?,?,?,?,?,?,?,?)");
		stmt.setString(1,iid.getText());
		stmt.setString(2,iad.getText());
		stmt.setString(3,itype.getValue().toString());
		stmt.setString(4,iauthor.getText());
		stmt.setString(5,itop.getText());
		stmt.setString(6,inop.getText());
		stmt.setString(7,ivolume.getText());
		stmt.setString(8,iissue.getText());
		stmt.setString(9,iissn.getText());
		stmt.setString(10,imonth.getValue().toString());
		stmt.setString(11,iyear.getText());
		stmt.executeUpdate();
		iid.setText(null);
		iad.setText(null);
		itype.setValue(null);
		iauthor.setText(null);
		itop.setText(null);
		inop.setText(null);
		ivolume.setText(null);
		iissue.setText(null);
		iissn.setText(null);
		imonth.setValue(null);
		iyear.setText(null);
		
		}
	@FXML public void ireport() throws IOException {
		Pane pane1=FXMLLoader.load(getClass().getResource("/application/gen2.fxml"));
		pane.getChildren().setAll(pane1);
		
	}
	

}
