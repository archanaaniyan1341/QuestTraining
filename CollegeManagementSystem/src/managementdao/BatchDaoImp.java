package managementdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BatchDaoImp implements BatchDao {
	static Connection conn = DatabaseConnection.getConnection(); 
	@Override
	public List<Batch> getAllBatches() {
		List<Batch>batch=new ArrayList<Batch>();
		 String query="SELECT * FROM batch_details";
			try {
				
				Statement st=conn.createStatement();
				ResultSet res=st.executeQuery(query);
				while(res.next()) {
					Batch b=new Batch();
					b.setBatchID(res.getInt("batch_id"));
					b.setBatchName(res.getString("batch_name"));
					b.setFeeDetails(res.getInt("fee"));
				batch.add(b);
				conn.commit();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return batch;
		
	}

	@Override
	public void addBatch(Batch batch) {
		String query="INSERT INTO batch_details values("+batch.getBatchID()+","+"'"+ batch.getBatchName()+"'"+","+
				 batch.getFeeDetails()+")";
					try {
						Statement st=conn.prepareStatement(query);
						st.executeUpdate(query);
						System.out.println("Record inserted to student for"+batch.getBatchName());
						conn.commit();
					} catch (SQLException e) {
						e.printStackTrace();
					}	
		
	}
	

}
