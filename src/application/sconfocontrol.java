package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

public class sconfocontrol {

	@FXML TextField stoc;
	@FXML TextField sid;
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
	@FXML AnchorPane pane;
	@FXML public void search(ActionEvent event) throws SQLException, ClassNotFoundException {
		ctable.setItems(null);
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","oracle");
		if(sid.getText()!=null&&stoc.getText()!=null)
		{
			ObservableList<ctablemodel> oblist=FXCollections.observableArrayList();
			
			PreparedStatement st = conn.prepareStatement("select * from BHARATH.CONFERENCE where f_id=?AND top=?");    
			st.setString(1,sid.getText());
			st.setString(2,stoc.getText());
			ResultSet rs=st.executeQuery();
			while (rs.next())
			{
				oblist.add(new ctablemodel(rs.getString("f_id"),rs.getString("academic"),rs.getString("type1"),rs.getString("co_author"),rs.getString("top"),rs.getString("toc"),rs.getString("venue"), rs.getString("doa"),rs.getString("pageno")));
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
		if(!sid.getText().isEmpty()&&stoc.getText().isEmpty())
		{
			System.out.println("inside if");
			ObservableList<ctablemodel> oblist=FXCollections.observableArrayList();
			ObservableList<itablemodel> oblist1=FXCollections.observableArrayList();
			PreparedStatement st = conn.prepareStatement("select * from BHARATH.CONFERENCE where f_id=?");    
			st.setString(1,sid.getText());
			ResultSet rs=st.executeQuery();
			while (rs.next())
			{
				oblist.add(new ctablemodel(rs.getString("f_id"),rs.getString("academic"),rs.getString("type1"),rs.getString("co_author"),rs.getString("top"),rs.getString("toc"),rs.getString("venue"), rs.getString("doa"),rs.getString("pageno")));
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
		if(!stoc.getText().isEmpty()&&sid.getText().isEmpty())
		{
			ObservableList<ctablemodel> oblist=FXCollections.observableArrayList();
			ObservableList<itablemodel> oblist1=FXCollections.observableArrayList();
			PreparedStatement st = conn.prepareStatement("select * from BHARATH.CONFERENCE where top=?");    
			st.setString(1,stoc.getText());
			ResultSet rs=st.executeQuery();
			while (rs.next())
			{
				oblist.add(new ctablemodel(rs.getString("f_id"),rs.getString("academic"),rs.getString("type1"),rs.getString("co_author"),rs.getString("top"),rs.getString("toc"),rs.getString("venue"), rs.getString("doa"),rs.getString("pageno")));
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
	}
	@FXML public void back(ActionEvent event) throws IOException {
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("/application/conference.fxml"));
		pane.getChildren().setAll(pane1);
		
	}

}
