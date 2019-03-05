package de.ics.cardmarket4j;

import java.net.HttpURLConnection;

public class HTTPUtils {
	public static String getFullResponse(HttpURLConnection connection) {
		return getHeader(connection);
	}

	private static String getHeader(HttpURLConnection connection) {
		StringBuilder sb = new StringBuilder();

		sb.append("\n-- Response Header--");
		for (String headerKey : connection.getHeaderFields().keySet()) {
			sb.append("\n" + headerKey + "=");
			for (String headerContent : connection.getHeaderFields().get(headerKey)) {
				sb.append("\t" + headerContent);
			}
		}
		return sb.toString();
	}

}
