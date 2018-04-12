package hmrc

import utils.ItemRates._

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

}
