package KNN;
import java.util.*;
import java.sql.*;
import databaseconnection.databasecon;
public class KNN
{
	// the data
	static double[][] instances;
	static ArrayList al=new ArrayList();
	static ArrayList al1=new ArrayList();
public static void load(){

int row=0;
al.clear();

 		try
		{
			
 Connection con=databasecon.getconnection();
 Statement st=con.createStatement();
Statement st1=con.createStatement();
ResultSet rs1=st1.executeQuery("select count(*)from dataset");
if(rs1.next()){
row=rs1.getInt(1);
}

instances = new double[row][4];

//System.out.println(row);
ResultSet rs=st.executeQuery("select *from dataset");
while(rs.next()){
	
al.add(rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6));
al1.add(rs.getString(1));

}
//System.out.println(instances.length);
 // print array in rectangular form
 for (int r=0; r<instances.length; r++) {
	 String v=al.get(r).toString();
	 String[] v1=v.split(",");
     for (int c=0; c<4; c++) {
         instances[r][c]=(double)(Integer.parseInt(v1[c]));//your value
     }
 }

 for (int r=0; r<instances.length; r++) {
     for (int c=0; c<4; c++) {
        System.out.println(instances[r][c]);
     }
 
	}
		}
		catch(Exception e)
		{
			System.out.println("class error"+e);
		}
		

}

	/**
	 * Returns the majority value in an array of strings
	 * majority value is the most frequent value (the mode)
	 * handles multiple majority values (ties broken at random)
	 *
	 * @param  array an array of strings
	 * @return  the most frequent string in the array
	 */ 
	private static String findMajorityClass(String[] array)
	{
		//add the String array to a HashSet to get unique String values
		Set<String> h = new HashSet<String>(Arrays.asList(array));
		//convert the HashSet back to array
		String[] uniqueValues = h.toArray(new String[0]);
		//counts for unique strings
		int[] counts = new int[uniqueValues.length];
		// loop thru unique strings and count how many times they appear in origianl array   
		for (int i = 0; i < uniqueValues.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[j].equals(uniqueValues[i])){
					counts[i]++;
				}
			}        
		}

		for (int i = 0; i < uniqueValues.length; i++)
			System.out.println(uniqueValues[i]);
		for (int i = 0; i < counts.length; i++)
			System.out.println(counts[i]);


		int max = counts[0];
		for (int counter = 1; counter < counts.length; counter++) {
			if (counts[counter] > max) {
				max = counts[counter];
			}
		}
		System.out.println("max # of occurences: "+max);

		// how many times max appears
		//we know that max will appear at least once in counts
		//so the value of freq will be 1 at minimum after this loop
		int freq = 0;
		for (int counter = 0; counter < counts.length; counter++) {
			if (counts[counter] == max) {
				freq++;
			}
		}

		//index of most freq value if we have only one mode
		int index = -1;
		if(freq==1){
			for (int counter = 0; counter < counts.length; counter++) {
				if (counts[counter] == max) {
					index = counter;
					break;
				}
			}
			//System.out.println("one majority class, index is: "+index);
			return uniqueValues[index];
		} else{//we have multiple modes
			int[] ix = new int[freq];//array of indices of modes
			System.out.println("multiple majority classes: "+freq+" classes");
			int ixi = 0;
			for (int counter = 0; counter < counts.length; counter++) {
				if (counts[counter] == max) {
					ix[ixi] = counter;//save index of each max count value
					ixi++; // increase index of ix array
				}
			}

			for (int counter = 0; counter < ix.length; counter++)         
				System.out.println("class index: "+ix[counter]);       

			//now choose one at random
			Random generator = new Random();        
			//get random number 0 <= rIndex < size of ix
			int rIndex = generator.nextInt(ix.length);
			System.out.println("random index: "+rIndex);
			int nIndex = ix[rIndex];
			//return unique value at that index 
			return uniqueValues[nIndex];
		}

	}


	/**
	 * Returns the mean (average) of values in an array of doubless
	 * sums elements and then divides the sum by num of elements
	 *
	 * @param  array an array of doubles
	 * @return  the mean
	 */ 
	private static double meanOfArray(double[] m) {
		double sum = 0.0;
		for (int j = 0; j < m.length; j++){
			sum += m[j];
		}
		return sum/m.length;
	}



	public static ArrayList SecurekNN(String qury){ 

		int k=1;// # of neighbours  
		//list to save DataSet data
		List<DataSet> DataSetList = new ArrayList<DataSet>();
		ArrayList alist=new ArrayList();
		alist.clear();
		//list to save distance result
		List<Result> resultList = new ArrayList<Result>();
				load();
				
		// add DataSet data to DataSetList  
		for(int j=0;j<al.size();j++){
		DataSetList.add(new DataSet(instances[j],al1.get(j).toString()));
		}
		//data about unknown DataSet
		double[] query=new double[4]; // {0.65,0.78,0.21,0.29,0.58};
		//System.out.println("querypointssss="+qury);
		String[] q=qury.split(",");
		for(int l=0;l<q.length;l++){
		query[l]=(double)Integer.parseInt(q[l]);
		}
		//find disnaces
		for(DataSet DataSet : DataSetList){
			double dist = 0.0;  
			for(int j = 0; j < DataSet.DataSetAttributes.length; j++){    	     
				dist += Math.pow(DataSet.DataSetAttributes[j] - query[j], 2) ;
				//System.out.print(DataSet.DataSetAttributes[j]+" ");    	     
			}
			double distance = Math.sqrt( dist );
			resultList.add(new Result(distance,DataSet.DataSetName));
			//System.out.println(distance);
		} 
		

		//System.out.println(resultList);
		Collections.sort(resultList, new DistanceComparator());
		String[] ss = new String[k];
		for(int x = 0; x < k; x++){
			System.out.println(resultList.get(x).DataSetName+ " .... " + resultList.get(x).distance);
			//get classes of k nearest instances (DataSet names) from the list into an array
			ss[x] = resultList.get(x).DataSetName;
			alist.add(resultList.get(x).DataSetName+","+resultList.get(x).distance);
		}
		String majClass = findMajorityClass(ss);
		//System.out.println("Class of new instance is: "+majClass);   
		return alist;
	}//end main  

	//simple class to model instances (features + class)
	static class DataSet {	
		double[] DataSetAttributes;
		String DataSetName;
		public DataSet(double[] DataSetAttributes, String DataSetName){
			this.DataSetName = DataSetName;
			this.DataSetAttributes = DataSetAttributes;	    	    
		}
	}
	//simple class to model results (distance + class)
	static class Result {	
		double distance;
		String DataSetName;
		public Result(double distance, String DataSetName){
			this.DataSetName = DataSetName;
			this.distance = distance;	    	    
		}
	}
	//simple comparator class used to compare results via distances
	static class DistanceComparator implements Comparator<Result> {
		public int compare(Result a, Result b) {
			return a.distance < b.distance ? -1 : a.distance == b.distance ? 0 : 1;
		}
	}

}
