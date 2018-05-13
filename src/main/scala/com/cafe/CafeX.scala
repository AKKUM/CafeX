package com.cafe

/**
 * Created by akhileshkumar on 13/05/2018.
 */
sealed abstract class MenuItems(val name:String,val menuType :String,val beverageType:String, val price:BigDecimal)

case object Cola extends MenuItems("Cola","Drink","Cold",0.5)
case object Coffee extends MenuItems("Coffee","Drink","Hot",1.0)
case object CheeseSandwich extends MenuItems("Cheese Sandwich","Food","Cold",2.0)
case object SteakSandwich extends MenuItems("Steak Sandwich","Food","Hot",4.5)
case object Other extends MenuItems("Misc","Misc","Misc",0.0)


class CafeX {

  def generateBill(menuItems:Seq[String]) : BigDecimal = {
   menuItems.map{ item =>

     item match {
     case "Cola" => Cola
     case "Coffee" => Coffee
     case "Cheese Sandwich" => CheeseSandwich
     case "Steak Sandwich" => SteakSandwich
     case _ => Other

   }
   }.foldLeft(BigDecimal(0))((a,b)=> a + b.price)
  }

  def generateServiceCharge(menuItems:Seq[MenuItems], totalBill:BigDecimal) = {
    val food = menuItems.find(_.menuType == "Food")
    val hotfood = menuItems.find(data => data.menuType == "Food" && data.beverageType == "Hot")
    food match {
      case Some(x) if(hotfood.isDefined) => {
        val serviceCharge = totalBill * 0.2
        if (serviceCharge <= 20.0) serviceCharge else BigDecimal(20.0)
      }
      case Some(x) => totalBill * 0.1
      case _ => 0.0
    }
  }
}
