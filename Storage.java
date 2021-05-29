import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

public class Storage {
	
	static ArrayList<App> appList = new ArrayList<App>();
	
	public static void loadData() {
		
		try {
			File inputFile = new File("storedData.txt");
			Scanner fileScan = new Scanner(inputFile);
				
			while(fileScan.hasNextLine()) {
				App a = new App();
				
				a.setName(fileScan.nextLine());
				a.setDescription(fileScan.nextLine());
				a.setOrganization(fileScan.nextLine());
				a.setPlatform(fileScan.nextLine());
				a.setLink(fileScan.nextLine());
				a.setVersion(fileScan.nextLine());
				a.setPrice(Double.parseDouble(fileScan.nextLine()));
				
				appList.add(a);
			}
				
			fileScan.close();
			System.out.println("Apps loaded successfully");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Input file not found");
		}
		
	}
	
	public static void saveData() {
		
		try {
			PrintWriter pw = new PrintWriter("storedData.txt");
			for(App a : appList) {
				pw.println(a.toString());
			}
			
			pw.close();
			System.out.println("Apps saved successfully");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Output file not found");
		}
		
		
	}
	
	public static boolean removeApp(String appName) {
		for(int i = 0; i < appList.size(); i++) {
			if(appList.get(i).getName().contentEquals(appName)) {
				appList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
}
