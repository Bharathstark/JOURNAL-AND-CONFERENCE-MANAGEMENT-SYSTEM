package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class repocontrol {
	@FXML private AnchorPane pane;
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
	@FXML TableView<itablemodel> iTable;
	@FXML TableColumn<itablemodel, String> fid1;
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
	@FXML TextField sid;
	@FXML TextField sad;
	

	
	@FXML public void back(ActionEvent event) throws IOException {
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("/application/home.fxml"));
		pane.getChildren().setAll(pane1);
		
	}


	@FXML public void search(ActionEvent event) throws ClassNotFoundException, SQLException {
		ctable.setItems(null);
		iTable.setItems(null);
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","SYSTEM","oracle");
		if(sid.getText()!=null&&sad.getText()!=null)
		{
			ObservableList<ctablemodel> oblist=FXCollections.observableArrayList();
			ObservableList<itablemodel> oblist1=FXCollections.observableArrayList();
			
			PreparedStatement st = conn.prepareStatement("select * from BHARATH.CONFERENCE where f_id=?AND academic=?");    
			st.setString(1,sid.getText());
			st.setString(2,sad.getText());
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
	PreparedStatement st1 = conn.prepareStatement("select * from BHARATH.JOURNAL where f_id=? AND academic=?");    
	st1.setString(1,sid.getText());
	st1.setString(2,sad.getText());
	ResultSet rs1=st1.executeQuery();
			while (rs1.next())
			{
				oblist1.add(new itablemodel(rs1.getString("f_id"),rs1.getString("academic"),rs1.getString("type1"),rs1.getString("co_author"),rs1.getString("top"),rs1.getString("nop"),rs1.getString("volume"), rs1.getString("issue"),rs1.getString("issn"), rs1.getString("month"),rs1.getString("year")));
			}
			fid1.setCellValueFactory(new PropertyValueFactory("id"));
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
			iTable.setItems(oblist1);
		}
		if(!sid.getText().isEmpty()&&sad.getText().isEmpty())
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
	PreparedStatement st1 = conn.prepareStatement("select * from BHARATH.JOURNAL where f_id=?");    
	st1.setString(1,sid.getText());
	ResultSet rs1=st1.executeQuery();
			while (rs1.next())
			{
				oblist1.add(new itablemodel(rs1.getString("f_id"),rs1.getString("academic"),rs1.getString("type1"),rs1.getString("co_author"),rs1.getString("top"),rs1.getString("nop"),rs1.getString("volume"), rs1.getString("issue"),rs1.getString("issn"), rs1.getString("month"),rs1.getString("year")));
			}
			fid1.setCellValueFactory(new PropertyValueFactory("id"));
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
			iTable.setItems(oblist1);
		
			
			
		}
		if(!sad.getText().isEmpty()&&sid.getText().isEmpty())
		{
			ObservableList<ctablemodel> oblist=FXCollections.observableArrayList();
			ObservableList<itablemodel> oblist1=FXCollections.observableArrayList();
			PreparedStatement st = conn.prepareStatement("select * from BHARATH.CONFERENCE where academic=?");    
			st.setString(1,sad.getText());
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
	PreparedStatement st1 = conn.prepareStatement("select * from BHARATH.JOURNAL where academic=?");    
	st1.setString(1,sad.getText());
	ResultSet rs1=st1.executeQuery();
			while (rs1.next())
			{
				oblist1.add(new itablemodel(rs1.getString("f_id"),rs1.getString("academic"),rs1.getString("type1"),rs1.getString("co_author"),rs1.getString("top"),rs1.getString("nop"),rs1.getString("volume"), rs1.getString("issue"),rs1.getString("issn"), rs1.getString("month"),rs1.getString("year")));
			}
			fid1.setCellValueFactory(new PropertyValueFactory("id"));
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
			iTable.setItems(oblist1);
		
		}
			
	}


	@FXML public void journal(ActionEvent event) throws IOException {
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("/application/journo.fxml"));
		pane.getChildren().setAll(pane1);
	}
	


	@FXML public void confo(ActionEvent event) throws IOException {
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("/application/confo.fxml"));
		pane.getChildren().setAll(pane1);
		
	}
	

}
