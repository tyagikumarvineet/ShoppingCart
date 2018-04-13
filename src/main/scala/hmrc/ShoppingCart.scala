package hmrc

import utils.ItemRates._
import utils.Utility

object ShoppingCart {

  def checkOut(shopItems: List[ShopItem], isOfferOn: Boolean = false) = {
    val basketValue = if (shopItems.isEmpty) {
      emptyBasketValue
    } else {

      isOfferOn match {
        case true => {
          buyOneAppleGetOneFree(shopItems) + buy3OrangesFor2(shopItems)
        }
        case _ => shopItems.foldLeft(0.0)((acc, item) => acc + Utility.itemPrice(item)) / 100
      }
    }

    "£" + basketValue
  }

  def buyOneAppleGetOneFree(shopItems: List[ShopItem]) = {
    val noOfApples = Utility.totalNoOfApples(shopItems)

    val noOfPaidApples = if (noOfApples % 2 == 0) {
      noOfApples / 2
    } else {
      noOfApples / 2 + 1
    }

    noOfPaidApples * AppleCost / 100.00
  }

  def buy3OrangesFor2(shopItems: List[ShopItem]) = {
    val noOfOranges = Utility.totalNoOfOranges(shopItems)

    val noOfPaidOranges = if (noOfOranges < 3) {
      noOfOranges
    } else if (noOfOranges % 3 == 0) {
      noOfOranges / 3 * 2
    } else {
      if (noOfOranges % 3 > 1) {
        (noOfOranges / 3 * 2) + 2
      } else {
        (noOfOranges / 3 * 2) + 1
      }

    }

    noOfPaidOranges * OrangeCost / 100.00
  }

}
