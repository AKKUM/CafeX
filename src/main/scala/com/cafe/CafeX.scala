package com.cafe

import scala.annotation.tailrec

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
   val mItems = menuItems.map{ item =>

     item match {
     case "Cola" => Cola
     case "Coffee" => Coffee
     case "Cheese Sandwich" => CheeseSandwich
     case "Steak Sandwich" => SteakSandwich
     case _ => Other

   }
   }
    generateServiceCharge(mItems)

  }

  def generateServiceCharge(menuItems:Seq[MenuItems]) = {

   val (food,hotfood,bill) =  checkFoodAndHotFood(menuItems)
   val serviceTax = (food,hotfood)match  {
     case (true,true) => {
       val serviceCharge = bill * 0.2
       bill + (if (serviceCharge <= 20.0) serviceCharge  else BigDecimal(20.0))
     }
     case (true,false) => bill + (bill * 0.1)
     case _ => bill
   }
    serviceTax
  }


  def checkFoodAndHotFood (items:Seq[MenuItems]) : (Boolean,Boolean,BigDecimal) = {
    @tailrec
    def checkFoodItems(itemList:Seq[MenuItems],isFood : Boolean, isHotFood:Boolean, totalBil:BigDecimal) : (Boolean,Boolean,BigDecimal)= {
      if (itemList.isEmpty) {
        (isFood,isHotFood,totalBil)
      } else {
        checkFoodItems(itemList.tail,
          if (isFood) isFood else itemList.head.menuType == "Food",
          if (isHotFood) isHotFood else itemList.head.beverageType == "Hot",
        itemList.head.price+totalBil)
      }
    }
    checkFoodItems(items,false,false,BigDecimal(0.0))
  }
}
