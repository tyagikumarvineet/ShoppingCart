package utils

import hmrc.{Apple, Orange}
import org.scalatest.{Matchers, WordSpec}

class UtilitySpec extends WordSpec with Matchers{
  "Utility.totalNoOfApples" must {

    "return total no of apples as 0 when List is empty" in {
      Utility.totalNoOfApples(List()) shouldBe 0
    }

    "return correct no of apples when List is not empty" in {
      Utility.totalNoOfApples(List(Apple, Apple, Apple)) shouldBe 3
    }

  }

  "Utility.totalNoOfOranges" must {
    "return total no of oranges as 0 when List is empty" in {
      Utility.totalNoOfOranges(List()) shouldBe 0
    }

    "return correct no of oranges when List is not empty" in {
      Utility.totalNoOfOranges(List(Orange, Orange, Orange)) shouldBe 3
    }
  }

  "Utility.itemPrice" must {
    "return correct Apple cost when Item is Apple" in {
      Utility.itemPrice(Apple) shouldBe ItemRates.AppleCost
    }

    "return correct Orange cost when Item is Orange" in {
      Utility.itemPrice(Orange) shouldBe ItemRates.OrangeCost
    }
  }

}
