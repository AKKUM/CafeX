import com.cafe.{CafeX, CheeseSandwich, Cola, SteakSandwich}
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers


/**
 * Created by akhileshkumar on 13/05/2018.
 */
class CafeXSpec extends  AnyFreeSpec with Matchers {
  val cafe = new CafeX

    "Calling generateBill" - {
      "return 0.5 for food item Cola" in {
        cafe.generateBill(Seq("Cola")) mustBe  BigDecimal(0.50)

      }
      
      "return 1.0 for food item Coffee" in {
        cafe.generateBill(Seq("Coffee")) mustBe BigDecimal(1.00)

      }
      
      "return 2.0 for food item Cheese Sandwich" in {
        cafe.generateBill(Seq("Cheese Sandwich")) mustBe 2.20
      }
      
      "return 4.5 for food item Steak Sandwich" in {
        cafe.generateBill(Seq("Steak Sandwich")) mustBe 5.40

      }
      "return 0.0 for Other food item (Misc)" in {
        cafe.generateBill(Seq("Other")) mustBe 0.00

      }
      "return 3.5 for Cola Coffee and Chees Sandwich" in {
        cafe.generateBill(Seq("Cola","Coffee","Cheese Sandwich")) mustBe 4.20

      }
    }
    "Calling generateServiceCharge" - {
      "return no service charge for drink item" in {
        cafe.generateServiceCharge(Seq(Cola)) mustBe 0.50
      }
      "return 10% service charge for food item" in {
        cafe.generateServiceCharge(Seq(CheeseSandwich)) mustBe 2.20
      }
      "return 20% service charge for hod food item" in {
        cafe.generateServiceCharge(Seq(SteakSandwich)) mustBe 5.40
      }
      "return max £20  for service charge if service charge is more than 20 for multiple items" in {
        cafe.generateServiceCharge(Seq(CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,
          SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,
          SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich)
          ) mustBe 130.0
      }
    }
    "Calling CheckFoodAndHotFood" - {
      "return (false,false) for drink and misc items" in {
        cafe.checkFoodAndHotFood(Seq(Cola)) mustBe (false,false,0.5)
      }
      "return (true,false) for drink and misc items" in {
        cafe.checkFoodAndHotFood(Seq(CheeseSandwich,Cola)) mustBe (true,false,2.5)
      }
      "return (true,true) for drink and misc items" in {
        cafe.checkFoodAndHotFood(Seq(SteakSandwich,CheeseSandwich,Cola)) mustBe (true,true,7.0)
      }
    }


}

