package com.cafe

/**
 * Created by akhileshkumar on 13/05/2018.
 */
class CafeX {

  def generateBill(menuItem:String) : BigDecimal = {
   menuItem match {
     case "Cola" => 0.5
     case "Coffee" => 1.0
     case "Cheese Sandwich" => 2.0
     case "Steak Sandwich" => 4.5
     case _ => 0.0

   }
  }
}
