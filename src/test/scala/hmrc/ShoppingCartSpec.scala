package hmrc

import org.scalatest.{Matchers, WordSpec}

class ShoppingCartSpec extends WordSpec with Matchers{
  "ShoppingCart.checkOut" must {

    "return total value as 0 if the basket is empty" in {
      ShoppingCart.checkOut(List()) shouldBe "£" + 0.0
    }

    "return correct value of basket with Apples and Oranges" in {
      ShoppingCart.checkOut(List(Apple, Orange, Orange,Apple)) shouldBe "£" + 1.70
    }

    "return correct value of basket only with Apples" in {
      ShoppingCart.checkOut(List(Apple, Apple, Apple, Apple)) shouldBe "£" + 2.40
    }

    "return correct value of basket only with Oranges" in {
      ShoppingCart.checkOut(List(Orange, Orange, Orange, Orange)) shouldBe "£" + 1.00
    }
  }

}
