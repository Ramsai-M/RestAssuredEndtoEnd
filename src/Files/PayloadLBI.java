package Files;

public class PayloadLBI {

	public static String AddBook(String isbn,String aisle) {
		String payloadLBI="{\r\n"
				+ " \r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		return payloadLBI;
	}
	public static String deleteBook(String Id) {
		String PayloadLBID="{\r\n"
				+ "\"ID\":\""+Id+"\"\r\n"
				+ "}";
		return PayloadLBID;
	}
}
