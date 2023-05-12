package DAL;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOUtils<T,U> {
	

		
		public int insert(T t) throws SQLException, ClassNotFoundException ;
		
		public int delete(U t) throws SQLException, ClassNotFoundException ;
		
		public int update(T t) throws SQLException, ClassNotFoundException ;
		
		public ArrayList<T> selectAll() throws SQLException, ClassNotFoundException ;
		
		public T selectByID(U t) throws SQLException, ClassNotFoundException ;

}
