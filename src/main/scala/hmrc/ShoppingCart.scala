package hmrc

import utils.ItemRates._
import utils.Utility

object ShoppingCart {

  def checkOut(shopItems: List[ShopItem]) = {
    val basketValue = if(shopItems.isEmpty) {
      emptyBasketValue
    } else {
      shopItems.foldLeft(0.0)((acc, item) => acc + itemPrice(item))/100
    }

    "£"+basketValue
  }

  private def itemPrice(item: ShopItem) =
    item match {
      case Apple => AppleCost
      case _ => OrangeCost
    }

  def buyOneAppleGetOneFree(shopItems: List[ShopItem]) = {
    val noOfApples = Utility.totalNoOfApples(shopItems)
    val noOfOranges = Utility.totalNoOfOranges(shopItems)

    val noOfPaidApples = if(noOfApples % 2 == 0 ){
      noOfApples/2
    } else {
      noOfApples/2 + 1
    }

    noOfPaidApples * AppleCost/100.00 + noOfOranges * OrangeCost/100.00
  }

  def buy3OrangesFor2(shopItems: List[ShopItem]) = {
    val noOfApples = Utility.totalNoOfApples(shopItems)
    val noOfOranges = Utility.totalNoOfOranges(shopItems)

    val noOfPaidOranges = if(noOfOranges % 3 == 0 ){
      noOfOranges/3 * 2
    } else {
      noOfOranges/3 + 1
    }

    0.0
  }

}
