package stepdefs;


import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import java.util.List;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PetStoreStepDefinitions {


	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_GET_PETS_BY_STATUS = "https://petstore.swagger.io/v2/pet/findByStatus";

	@Given("a pets available with status of (.*)")
	public void a_pets_available_with_status(String status) {
		request = given().param("status", status);


	}

	@When("user retrieves the pets by status")
	public void user_retrieves_the_pets_by_status() {
		response = request.when().get(ENDPOINT_GET_PETS_BY_STATUS);
	}

	@Then("status code is (\\d+)")
	public void verifystatus(int statusCode) {
		json = response.then().statusCode(statusCode);


	}

	@And("validate how many pets have the name (.*)")
	public void validate_how_many_pets_have_the_status( String name) {

		//Creation of JsonPath object
		JsonPath jsonPathValidator = response.jsonPath();
		// Get the list of all the pet names
		List < String > allEmployeeNames = jsonPathValidator.getList("name");

		for (String petname: allEmployeeNames) {
          // Here checking the petname "doggie"
			if(petname.equals(name)){

				int count=0;
				count++;
				System.out.println(count);

			}
		}


	}
}