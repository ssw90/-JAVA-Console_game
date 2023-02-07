package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import method.Set_Position;
import page.Main;
import page.Set_page;


public class PlayersDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt=0;
	private void connDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String dbid="hr";
			String dbpw="hr";
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (ClassNotFoundException e) {
			System.out.println("Db connect error");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int insert(PlayersDTO dto) {	
		try {
			connDB();
			String hp = dto.getHp();
			System.out.println("PlayersDAO : "+hp);
			int pc = dto.getPc();
			int pn = dto.getPlayernumber();
			int won = dto.getWon();
			String banned = dto.getBanned();
			
			String sql = "insert into player values(?,?,?,?,?)";
		
			psmt = conn.prepareStatement(sql); 	
			psmt.setInt(1, pn);
			psmt.setString(2, hp);
			psmt.setInt(3, pc);
			psmt.setInt(4, won);
			psmt.setString(5, banned);
			cnt = psmt.executeUpdate();
			
			if(cnt>0) {	
				System.out.println("����");
			}else {
				System.out.println("����");
			}
		}catch(SQLException e){
			e.printStackTrace();
		 }finally {
			 getClose();
		 }
		
		return cnt;
		
	}
	
	public void selectRank() {
		connDB();
		try {
			String sql = "SELECT * FROM player where HP = ? ORDER BY won DESC";
			psmt = conn.prepareStatement(sql); 	
			String HP = Main.HP;
			psmt.setString(1, HP);
			rs = psmt.executeQuery();
			
			while(rs.next()==true) {					
				int PN = rs.getInt(1);
				String HP2 = rs.getString(2);
				int won = rs.getInt(3);
				System.out.printf("%s\t%s\t%s\t%d\t",PN,HP2,won);
				System.out.println();
			}
		
		}catch(SQLException e){
			e.printStackTrace();
		 }finally {
			 getClose();
		}
	}
	public void selectAllRank() {
		connDB();
		try {
			String sql = "SELECT PLAYERNUMBER,HP,WON FROM player ORDER BY won DESC";
			psmt = conn.prepareStatement(sql); 	
			rs = psmt.executeQuery();
			while(rs.next()==true) {					
				int PN = rs.getInt(1);
				String HP = rs.getString(2);
				int won = rs.getInt(3);
				Set_Position position = new Set_Position();
				int x=position.getXposition();
				position = null;
				System.out.printf("%-"+(x-(36/2))+"s","");
				System.out.printf("%s\t%s\t%s\t%d\t",PN,HP,won);
				System.out.println();
				
			}
		
		}catch(SQLException e){
			e.printStackTrace();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 getClose();
		}
	}
	
	
	public boolean hpCheck(String hp) {
		connDB();
		boolean result = false;
		try {
			String sql ="select HP from Player where HP = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, hp);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return result = true; 
			}else {
				return result = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
	return result;
	}

	
	
	public boolean login(PlayersDTO dto) {
		connDB();
		String hp = dto.getHp();
		int pc = dto.getPc();
		boolean result = false;
		try {
			String sql ="select * from Player where (HP = ? and PERSONALCODE = ?) and banned = 'N'";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, hp);
			psmt.setLong(2, pc);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return result = true;
			}else {
				return result = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
	return result;
	}
	private void getClose() {
		try {
			if(rs!=null) {				
				rs.close();
			}
			if(psmt!=null) {
				psmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void checkTable() {
		connDB();
		try {
			String sql ="select * from tab where tname=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "PLAYER");
			rs = psmt.executeQuery();
			if(rs.next()) {
				System.out.println("Player Table Exist");
			}else {
				System.out.println("table does not exsist.create new one");
				sql = "create table Player(PLAYERNUMBER NUMBER(12),HP VARCHAR2(12),PERSONALCODE NUMBER(12),WON NUMBER(12), banned varchar(1))";
				psmt = conn.prepareStatement(sql);
				cnt = psmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		
		connDB();
		try {
			String sql ="select HP from player where HP = 1";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				System.out.println("Player Exist");
			}else {
				System.out.println("player does not exsist.insert new one");
				sql ="insert into player values(9999,1,1,99,'N')";
				psmt = conn.prepareStatement(sql);
				cnt = psmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
	}

	public void hpBan() {
		connDB();
		try {
			String HP = Main.HP;
			String sql = "insert into player values(9998,?,9998,-1,'y')";
			psmt = conn.prepareStatement(sql);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
	}

}



