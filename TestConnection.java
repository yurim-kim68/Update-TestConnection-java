package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {
	//'김행복'의 총매출 구하기
	private static Connection getConnection() throws Exception,SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/xe","shop","1234");
		return con;
}
		private static int getKimsID() throws SQLException, Exception {
			//데이터 베이스 테이블에 아이디 정보가 있다.
			// select custno from member_tbl_02 where custname = '김행복';
			int custno = 0;
			String query = "select custno from member_tbl_02 where custname = '최사랑'";
			ResultSet result;
			Connection con = getConnection();
			result = con.prepareStatement(query).executeQuery();
			result.next();
			custno = result.getInt("CUSTNO");
		//	while(result.next()) {
			//	custno = result.getInt("CUSTNO");
				//System.out.println("custno: " + custno);
	//	}
			return custno;
	}
		public static void main(String[] args) throws Exception {
			int sum = 0; int custno = 0; int price = 0;
			String query = "select custno, price from money_tbl_02";
			ResultSet result;
			Connection con = getConnection();
			result = con.prepareStatement(query).executeQuery();
			
			while(result.next()) {
				custno = result.getInt("CUSTNO");
				if (custno != getKimsID()) continue;
				price = result.getInt("PRICE");
				sum += price;
				System.out.println("custno: " + custno + " price: " + price);
			}
			System.out.println("합계는" + sum + "입니다.");
		}
		
		
}
