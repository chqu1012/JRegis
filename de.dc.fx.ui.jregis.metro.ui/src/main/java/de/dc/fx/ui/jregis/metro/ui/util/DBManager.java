package de.dc.fx.ui.jregis.metro.ui.util;

import org.h2.tools.Server;

public class DBManager {

	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
			Server server = Server.createWebServer("-web", "-webAllowOthers",
					"-webPort", "9081");
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}