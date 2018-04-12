package utils

import hmrc.{Apple, Orange, ShopItem}

object Utility {

  def totalNoOfApples(shopItems: List[ShopItem]) = shopItems.foldLeft(0)((acc, item) => acc + isItemApple(item))

  def totalNoOfOranges(shopItems: List[ShopItem]) = shopItems.foldLeft(0)((acc, item) => acc + isItemOrange(item))

  private def isItemApple(item: ShopItem) = {
    item match {
      case Apple => 1
      case _ => 0
    }
  }

  private def isItemOrange(item: ShopItem) = {
    item match {
      case Orange => 1
      case _ => 0
    }
  }

}
