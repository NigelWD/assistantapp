import java.util.Comparator;

public class App implements Comparable<App> {
	
	private String name;
	private String description;
	private String organization;
	private String platform;
	private String link;
	private String version;
	private double price;
	
	public App() {
		name = "Dummy App";
		description = "Dummy object for testing purposes";
		organization = "none";
		platform = "iOS";
		link = "google.com";
		version = "1.0";
		price = 0.99;
	}
	
	public App(String name, String description, String organization, String platform,
			String link, String version, double price) {
		this.name = name;
		this.description = description;
		this.organization = organization;
		this.platform = platform;
		this.link = link;
		this.version = version;
		this.price = price;
	}
	
	
	
	 public String toString() { return this.name + ", " + this.description + ", "
	 +this.organization + ", " + this.platform + ", " + this.link + ", " +
	 this.version + ", " + this.price; }
	  
	
	
	
	/*
	 * public String toString() { return
	 * String.format("%-15s%\t-50s\t%4s\t%-10s\t%-10s\t", this.name,
	 * this.description, this.organization, this.platform, this.link, this.version)
	 * + " " + this.price; }
	 */
	
	 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int compareTo(App app) {
		int comp = 0;
	      if (price < app.getPrice()) {
	         comp = -1;
	      }
	      else if (price > app.getPrice()) {
	         comp = 1;
	      }
	      return comp;
	}
	
	
	public static Comparator<App> AppPlatform = new Comparator<App>() {

		public int compare(App app1, App app2) {
		   String App1 = app1.getPlatform().toUpperCase();
		   String App2 = app2.getPlatform().toUpperCase();

		   return App1.compareTo(App2);

	    }};
	
	
}
