package hmrc

import org.scalatest.{Matchers, WordSpec}

class ShoppingCartSpec extends WordSpec with Matchers{
  "ShoppingCart.checkOut without offer" must {

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

  "ShoppingCart.buyOneGetOneFree" must {

    "return correct value of basket only with Apples in Even numbers" in {
      ShoppingCart.buyOneAppleGetOneFree(List(Apple, Apple, Apple, Apple)) shouldBe 1.20
    }

    "return correct value of basket only with Apples in Odd numbers" in  {
      ShoppingCart.buyOneAppleGetOneFree(List(Apple, Apple, Apple)) shouldBe 1.20
    }

    "return correct value of basket with Odd numbers of Apples with Oranges" in {
      ShoppingCart.buyOneAppleGetOneFree(List(Apple, Orange, Apple, Apple)) shouldBe 1.20
    }

    "return correct value of basket with Even numbers of Apples and even no of Oranges" in {
      ShoppingCart.buyOneAppleGetOneFree(List(Apple, Orange, Orange, Apple, Apple, Apple)) shouldBe 1.20
    }

  }

  "ShoppingCart.buyOneGetOneFree" must {

    "return correct value of basket only with Oranges in Even numbers" in {
      ShoppingCart.buy3OrangesFor2(List(Orange, Orange, Orange, Orange)) shouldBe 0.75
    }

    "return correct value of basket only with Oranges in Odd numbers" in  {
      ShoppingCart.buy3OrangesFor2(List(Orange, Orange, Orange)) shouldBe  0.50
    }

    "return correct value of basket with Odd numbers of Oranges with Apples" in {
      ShoppingCart.buy3OrangesFor2(List(Orange, Apple, Orange, Orange)) shouldBe   0.50
    }

    "return correct value of basket with Even numbers of Oranges and even no of Apples" in {
      ShoppingCart.buy3OrangesFor2(List(Apple, Orange, Orange, Apple, Apple, Apple)) shouldBe 0.50
    }

  }

  "ShoppingCart.checkOut with offers" must {

    "return correct value of basket with the offers" in {
      ShoppingCart.checkOut(List(Apple, Orange, Orange, Orange, Apple, Apple, Apple), true) shouldBe "£" + 1.70
    }

    "return correct value of basket with only Apples with the offers" in {
      ShoppingCart.checkOut(List(Apple, Apple, Apple, Apple, Apple), true) shouldBe "£" + 1.80
    }

    "return correct value of basket with only 5 Oranges with the offers" in {
      ShoppingCart.checkOut(List(Orange, Orange, Orange, Orange, Orange), true) shouldBe "£" + 1.00
    }

    "return correct value of basket with only Oranges with the offers" in {
      ShoppingCart.checkOut(List(Orange, Orange, Orange, Orange, Orange, Orange, Orange), true) shouldBe "£" + 1.25
    }

    "return basket value as 0 with offers when there is no Item" in {
      ShoppingCart.checkOut(List(), true) shouldBe "£" + 0.0
    }

  }

}
