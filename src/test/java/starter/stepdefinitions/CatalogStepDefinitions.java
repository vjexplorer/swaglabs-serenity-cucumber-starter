package starter.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.PageElement;
import starter.model.Product;

import java.util.List;
import java.util.Map;

public class CatalogStepDefinitions {
    @When("{actor} is logged onto the application")
    public void logged_onto_the_application(Actor actor) {
       actor.attemptsTo(
               Open.url("https://www.saucedemo.com/"),
               Enter.theValue("standard_user").into(InputField.withNameOrId("user-name")),
               Enter.theValue("secret_sauce").into(InputField.withNameOrId("password")),
               Click.on(Button.withText("Login"))
       );
    }

    @DataTableType
    public Product product(Map<String,String> productData){
        return new Product(productData.get("Title"),productData.get("Price"));
    }

    @Then("{actor} should be presented with following products")
    public void he_should_be_presented_with_following_products(Actor actor, List<Product> expectedProducts) {
        for(Product product: expectedProducts){

            actor.attemptsTo(
                    Ensure.that(PageElement.withCSSClass("inventory_item").containingText(product.title())).isDisplayed(),
                    Ensure.that(PageElement.withCSSClass("inventory_item").containingText(product.title())).textContent().contains(product.price())
                    //Ensure.that(PageElement.withCSSClass("inventory_item").containingText(product.price())).isDisplayed()
            );

        }



    }


}
