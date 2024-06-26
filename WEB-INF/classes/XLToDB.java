	package CT;

	import databaseconnection.*;


	import java.io.*;
    import org.apache.poi.hssf.usermodel.HSSFWorkbook;
    import org.apache.poi.hssf.usermodel.HSSFSheet;
    import org.apache.poi.ss.usermodel.*;
    import org.apache.poi.xssf.usermodel.XSSFSheet;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import javax.swing.JOptionPane;

	import java.util.*;
    import java.sql.*; 

    public class XLToDB {  

	public static final String INSERT_RECORDS = "INSERT INTO dataset(sno, SoilName, soilMoisture, Temp,Humidity,PH,CropType)VALUES(?,?,?,?,?,?,?)";


	
	

			 public static void main(String[] args) throws Exception{
					XLToDB.insertRecords("SampleDataSet.xlsx");
			  }
            
			
			public static int insertRecords(String s){
			int cpp=0;
			File f=new File("D:/"+s);


            Connection con = null;
            PreparedStatement prepStmt = null;
            java.sql.Statement stmt = null;
            int count = 0;
            ArrayList<String> mylist = new ArrayList<String>();

            try{
				con =databasecon.getconnection();
                prepStmt = con.prepareStatement(INSERT_RECORDS);
                stmt = con.createStatement();
                FileInputStream fis = new FileInputStream(f);
                XSSFWorkbook workbook = new XSSFWorkbook (fis);
                XSSFSheet sheet = workbook.getSheetAt(0);
                Iterator ite = sheet.rowIterator();

                   while(ite.hasNext()) {
                            Row row = (Row) ite.next(); 
//                            System.out.println("Row value fetched..! "+row);
                            Iterator<Cell> cellIterator = row.cellIterator();
                            int index=1;
							int c=1;
                                    while(cellIterator.hasNext()) {

                                            Cell cell = cellIterator.next();
                                            System.out.println("getting cell value..! "+index);

                                            
											
									

//							
	//											prepStmt.setInt(1, count);                        
//											prepStmt.setString(2, "sajid");                        
 											

									
																						
											switch(cell.getCellType()) { 
									
											case Cell.CELL_TYPE_STRING: //handle string columns
											System.out.println("in case1///// "+(index));
                                          prepStmt.setString((index), cell.getStringCellValue()); 
                        index++;		            
                                                   break;

                                            case Cell.CELL_TYPE_NUMERIC: //handle double data
                                                int i = (int)cell.getNumericCellValue();
										prepStmt.setInt((index), (int) cell.getNumericCellValue());
																							System.out.println("in case1 "+(index));
index++;		                                    
													break;

									
											}


								

			


                                    }
					//we can execute the statement before reading the next row
try{                  int i= prepStmt.executeUpdate();
						if(i>=1){
							cpp++;
					  System.out.println("inseted");
					  }
               
}
catch(Exception e){
System.out.println(e);
}

				}
                   /* Close input stream */
                   fis.close();
                   /* Close prepared statement */
                   prepStmt.close();

                   /* Close connection */
                   con.close();

            }catch(Exception e){
                e.printStackTrace();            
            }

return cpp;
            }
    }