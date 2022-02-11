package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	public static void main(String[] args) throws SQLException {
		String dbUrl="jdbc:sqlite:MoviesDB.db";
		Connection connect=DriverManager.getConnection(dbUrl);
		
		String tableQuery="Create Table if not exists Movies(Movie varchar(50), Actor varchar(20), Actress varchar(20), ReleaseYear int(4), Director varchar(20))";
		Statement statement=connect.createStatement();
		statement.executeUpdate(tableQuery);
		System.out.println("Table Movies is created just now");
		
		String delRecords="delete from Movies";
		statement.executeUpdate(delRecords);
		
		String insertQuery1="Insert into Movies values('The Tender bar','Ben afflek', 'Lily rabe', 2021, 'George clooney')";
		String insertQuery2="Insert into Movies values('O Kadhal Kanmani','Dulquer samaan', 'Nithya menen', 2015, 'Mani rathnam')";
		String insertQuery3="Insert into Movies values('Mersal','Vijay', 'Samantha', 2017, 'Idlee')";
		statement.executeUpdate(insertQuery1);
		statement.executeUpdate(insertQuery2);
		statement.executeUpdate(insertQuery3);
		
		System.out.println("Movies list inserted");
		
		String selectQuery="select * from Movies";
		
		ResultSet result=statement.executeQuery(selectQuery);
		
		while(result.next()) {
			String movieName=result.getString("Movie");
			String actorName=result.getString("Actor");
			String actressName=result.getString("Actress");
			int year=result.getInt("ReleaseYear");
			String directorName=result.getString("Director");
			if(movieName.equals("Mersal"))
				System.out.println("\n\t"+movieName+"  \t\tStarring: "+actorName+" and "+actressName+"  \treleased in year "+year+"  directed by "+directorName);
			else	
				System.out.println("\n\t"+movieName+"  \tStarring: "+actorName+" and "+actressName+"  \treleased in year "+year+"  directed by "+directorName);
			
		}
	
	}

}
