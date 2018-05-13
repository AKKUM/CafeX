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
    val bill = mItems.foldLeft(BigDecimal(0))((a,b)=> a + b.price)
    val tax = generateServiceCharge(mItems,bill)
    bill + tax
  }

  def generateServiceCharge(menuItems:Seq[MenuItems], totalBill:BigDecimal) = {

   val (food,hotfood) =  checkFoodAndHotFood(menuItems)
   val serviceTax = (food,hotfood)match  {
     case (true,true) => {
       val serviceCharge = totalBill * 0.2
       if (serviceCharge <= 20.0) serviceCharge else BigDecimal(20.0)
     }
     case (true,false) => totalBill * 0.1
     case _ => BigDecimal(0.0)
   }
    serviceTax
  }


  def checkFoodAndHotFood (items:Seq[MenuItems]) : (Boolean,Boolean) = {
    @tailrec
    def checkFoodItems(itemList:Seq[MenuItems],isFood : Boolean, isHotFood:Boolean) : (Boolean,Boolean)= {
      if (itemList.isEmpty) {
        (isFood,isHotFood)
      } else {
        checkFoodItems(itemList.tail,
          if (isFood) isFood else itemList.head.menuType == "Food",
          if (isHotFood) isHotFood else itemList.head.beverageType == "Hot")
      }
    }
    checkFoodItems(items,false,false)
  }
}
