import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.PayloadLBI;
import Files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {

	@Test(dataProvider="Bookdata")
	public void addBook(String name,String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
	String response=	given().header("Content-Type","application/json").body(PayloadLBI.AddBook(name,aisle))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
	JsonPath js=ReusableMethod.rowtoJson(response);
	String id=js.get("ID");
	System.out.println(id);
	//delete book
	if(name.equalsIgnoreCase("Kolsi")) {
	String response1=	given().header("Content-Type", "application/json").body(PayloadLBI.deleteBook(id))
		.when().delete("/Library/DeleteBook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(response1);
	}
	
	
	}
	@DataProvider(name="Bookdata")
	public Object[][] getData() {
		return new Object[][] {{"Kishore","7865420"},{"Jokei","1236547"},{"Kolsi","75412"}};
	}
}
