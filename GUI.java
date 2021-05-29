import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

public class GUI extends Storage implements ActionListener {

	JTextField app_title;
	JTextField version;
	JTextField found;
	JTextField organization;
	JTextField description;
	JTextField platform;
	JTextField price;
	JTextField user_name;
	JTextField password;
	JList<App> appJList = new JList<App>();
	DefaultListModel<App> origListModel = new DefaultListModel<App>();
	Font appFont = new Font("Ariel", Font.BOLD, 14);

	String usernameString;
	String passwordString;
	String userTypeString;

	String[] userTypeChoices = { "Normal User", "Moderator", "Admin" };
	JComboBox<String> userTypeBox = new JComboBox<String>(userTypeChoices);

	String[] sortChoices = { "None", "Price Least", "Price Most", "Platform" };
	JComboBox<String> sortBox = new JComboBox<String>(sortChoices);

	String[] filterChoices = { "None", "Platform", "Organization", "Free" };
	JComboBox<String> filterBox = new JComboBox<String>(filterChoices);

	GUI() {
		JFrame jfrm = new JFrame("Applipedia");
		jfrm.setLocation(100, 100);
		jfrm.setLayout(new BorderLayout());
		jfrm.setSize(700, 500);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		app_title = new JTextField(10);
		platform = new JTextField(10);
		organization = new JTextField(10);
		found = new JTextField(10);
		found.setEditable(false);

		// set input fields
		JPanel inFieldPane = new JPanel();
		inFieldPane.setLayout(new GridLayout(6, 1));
		inFieldPane.add(new JLabel("App title:"));
		inFieldPane.add(app_title);
		app_title.addActionListener(this);
		inFieldPane.add(new JLabel("platform:"));
		inFieldPane.add(platform);
		platform.addActionListener(this);
		inFieldPane.add(new JLabel("Organization:"));
		inFieldPane.add(organization);
		organization.addActionListener(this);
		inFieldPane.add(new JLabel("Sort"));
		inFieldPane.add(sortBox);
		sortBox.addActionListener(this);
		inFieldPane.add(new JLabel("Filter"));
		inFieldPane.add(filterBox);
		filterBox.addActionListener(this);
		JButton searchButton = new JButton("Search");
		inFieldPane.add(new JLabel("Press to search"));
		searchButton.addActionListener(this);
		inFieldPane.add(searchButton);
		jfrm.add(inFieldPane, BorderLayout.NORTH);

		// display results
		JPanel outFieldPane = new JPanel();
		outFieldPane.setLayout(new GridLayout(1, 5));
		JButton logInButton = new JButton("Log In");
		outFieldPane.add(logInButton);
		logInButton.addActionListener(this);
		JButton requestButton = new JButton("Request");
		outFieldPane.add(new JLabel("Request"));
		outFieldPane.add(requestButton);
		requestButton.addActionListener(this);
		outFieldPane.add(new JLabel("Found?"));
		outFieldPane.add(found);
		jfrm.add(outFieldPane, BorderLayout.SOUTH);

		DefaultListModel<App> listModel = new DefaultListModel<App>();
		for (int i = 0; i < appList.size(); i++) {
			listModel.addElement(appList.get(i));
		}

		// saving original list order
		origListModel = listModel;

		// adding converted appList to JList
		appJList.setModel(listModel);
		appJList.setFont(appFont);

		// creating JPanel for appJList
		JPanel listPanel = new JPanel();
		listPanel.add(appJList);
		jfrm.add(listPanel, BorderLayout.CENTER);

		jfrm.setVisible(true);

	}

	public void Request() {
		JTextField app_title;
		JTextField link;

		JFrame reqFrame = new JFrame("Request");
		reqFrame.setLocation(100, 100);
		reqFrame.setLayout(new BorderLayout());
		reqFrame.setSize(200, 200);
		reqFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		app_title = new JTextField(10);
		link = new JTextField(10);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(new JLabel("App title:"));
		panel.add(app_title);
		panel.add(new JLabel("Link to App:"));
		panel.add(link);
		int result = JOptionPane.showConfirmDialog(null, panel, "Test", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			System.out.println(app_title.getText() + "\n" + link.getText());
		} else {
			System.out.println("Cancelled");
		}
		reqFrame.add(panel, BorderLayout.NORTH);
		reqFrame.setVisible(true);
	}

	public void LogIn() {
		JTextField userName;
		JTextField password;

		JFrame reqFrame = new JFrame("Log In");
		reqFrame.setLocation(100, 100);
		reqFrame.setLayout(new BorderLayout());
		reqFrame.setSize(200, 200);
		reqFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		userName = new JTextField(10);
		password = new JTextField(10);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		panel.add(new JLabel("Username:"));
		panel.add(userName);
		panel.add(new JLabel("Password:"));
		panel.add(password);
		panel.add(new JLabel("User Type:"));
		panel.add(userTypeBox);
		int result = JOptionPane.showConfirmDialog(null, panel, "Test", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			usernameString = userName.getText();
			passwordString = password.getText();
			userTypeString = (String) userTypeBox.getSelectedItem();
			System.out.println(usernameString + "\n" + passwordString + "\n" + userTypeString);
		} else {
			System.out.println("Cancelled");
		}
		reqFrame.add(panel, BorderLayout.NORTH);
		reqFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Search")) {
			String fullString = "";

			for (int i = 0; i < appList.size(); i++) {

				String var = appList.get(i).getName();

				if (app_title.getText().isEmpty()) {
					break;
				} else if (var.toLowerCase().contains(app_title.getText().toLowerCase())
						&& !app_title.getText().isEmpty()) {
					fullString = "Found";
					found.setText(fullString);
					break;
				} else {
					fullString = "Not Found";
					found.setText(fullString);
				}
			}

			for (int i = 0; i < appList.size(); i++) {

				String var = appList.get(i).getPlatform();

				if (!fullString.equals("Not Found") && platform.getText().isEmpty()) {
					break;
				} else if (!fullString.equals("Not Found")
						&& var.toLowerCase().contains(platform.getText().toLowerCase())
						&& !platform.getText().isEmpty()) {
					fullString = "Found";
					found.setText(fullString);
					break;
				} else {
					fullString = "Not Found";
					found.setText(fullString);
				}
			}

			for (int i = 0; i < appList.size(); i++) {

				String var = appList.get(i).getOrganization();

				if (!fullString.equals("Not Found") && organization.getText().isEmpty()) {
					break;
				} else if (!fullString.equals("Not Found")
						&& var.toLowerCase().contains(organization.getText().toLowerCase())
						&& !organization.getText().isEmpty()) {
					fullString = "Found";
					found.setText(fullString);
					break;
				} else {
					fullString = "Not Found";
					found.setText(fullString);
				}
			}
			found.setText(fullString);
		}

		if (e.getActionCommand().equals("Request")) {
			Request();
		}

		if (e.getActionCommand().equals("Log In")) {
			LogIn();
		}

		if (sortBox.getSelectedItem().equals("Platform")) {
			sortPlatform(appList);
			DefaultListModel<App> listModel = new DefaultListModel<App>();
			for (int i = 0; i < appList.size(); i++) {
				listModel.addElement(appList.get(i));
			}
			appJList.setModel(listModel);
		}

		if (sortBox.getSelectedItem().equals("Price Least")) {
			sortPriceLeast(appList);
			DefaultListModel<App> listModel = new DefaultListModel<App>();
			for (int i = 0; i < appList.size(); i++) {
				listModel.addElement(appList.get(i));
			}
			appJList.setModel(listModel);
		}

		if (sortBox.getSelectedItem().equals("Price Most")) {
			sortPriceLeast(appList);
			DefaultListModel<App> listModel = new DefaultListModel<App>();
			for (int i = appList.size() - 1; i >= 0; i--) {
				listModel.addElement(appList.get(i));
			}
			appJList.setModel(listModel);
		}

		if (sortBox.getSelectedItem().equals("None")) {
			DefaultListModel<App> listModel = new DefaultListModel<App>();
			listModel = origListModel;
			appJList.setModel(listModel);
		}

		if (filterBox.getSelectedItem().equals("Free")) {
			sortPriceLeast(appList);
			int freeCount;
			freeCount = 0;

			for (int i = 0; i < appList.size(); i++) {
				if (appList.get(i).getPrice() < 0.1) {
					freeCount++;
				}
			}

			DefaultListModel<App> listModel = new DefaultListModel<App>();
			for (int i = 0; i < freeCount; i++) {
				listModel.addElement(appList.get(i));
			}
			appJList.setModel(listModel);
		}

		if (filterBox.getSelectedItem().equals("Free")) {
			String str = platform.getText().toString();

		}

	}

	// sorts appList by price alphabetically
	public static ArrayList<App> sortPriceLeast(ArrayList<App> appList) {
		Collections.sort(appList);
		return appList;
	}

	// sorts appList by platform alphabetically
	public static ArrayList<App> sortPlatform(ArrayList<App> appList) {
		Collections.sort(appList, App.AppPlatform);
		return appList;
	}

	public static void main(String[] args) {
		// Storage.loadData();
		App a = new App("Instagram", "post pictures and videos", "org1", "iPhone", "instagram.com", "1.0.5", 0.0);
		App b = new App("Snapchat", "send pictures and videos to friends", "org1", "iPhone", "snapchat.com", "2.2.4",
				0.99);
		App c = new App("Facebook", "communicate with friends and update status", "org3", "android", "facebook.com",
				"5.1.3", 1.99);
		App d = new App("Twitter", "send tweets for the world to see", "org2", "iPhone", "twitter.com", "13.4.9", 0.0);
		App e = new App("TikTok", "share short video clips with friends", "org2", "iPhone", "tiktok.com", "23.2.0",
				0.99);
		App f = new App("Flappy Bird", "help your bird avoid obstacles", "org3", "android", "flappybird.com", "4.4.2",
				1.99);
		App g = new App("Venmo", "send and request money from friends", "org4", "android", "venmo.com", "9.1.3", 0.0);

		appList.add(a);
		appList.add(b);
		appList.add(c);
		appList.add(d);
		appList.add(e);
		appList.add(f);
		appList.add(g);

		for (App element : appList) {
			System.out.println(element.getName());
		}
		System.out.println();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUI();
			}
		});
		Storage.saveData();

	}
}
