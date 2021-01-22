
import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceEx
{
  Connection      connection = null;
  BasicDataSource bdSource   = new BasicDataSource();

  public DataSourceEx()
  {
    bdSource.setDriverClassName("com.mysql.jdbc.Driver");
    bdSource.setUrl("jdbc:mysql://localhost:3306/NEWDB");
    bdSource.setUsername("root");
    bdSource.setPassword("root");
  }

  public Connection createConnection()
  {
    Connection con = null;
    try
    {
      if( connection != null )
      {
        System.out.println("Cant create a New Connection");
      }
      else
      {
        con = bdSource.getConnection();
      }
    }
    catch( Exception e )
    {
      System.out.println("Error Occured " + e.toString());
    }
    return con;
  }
}
