import com.cafe.{SteakSandwich, CheeseSandwich, Cola, CafeX}
import org.scalatest.{Matchers, WordSpec}

/**
 * Created by akhileshkumar on 13/05/2018.
 */
class CafeXSpec extends  WordSpec with Matchers {
  val cafe = new CafeX
  "CafeX" when {
    "Calling generateBill" should {
      "return 0.5 for food item Cola" in {
        cafe.generateBill(Seq("Cola")) shouldBe 0.5

      }
      "return 1.0 for food item Coffee" in {
        cafe.generateBill(Seq("Coffee")) shouldBe 1.0

      }
      "return 2.0 for food item Cheese Sandwich" in {
        cafe.generateBill(Seq("Cheese Sandwich")) shouldBe 2.20

      }
      "return 4.5 for food item Steak Sandwich" in {
        cafe.generateBill(Seq("Steak Sandwich")) shouldBe 5.40

      }
      "return 0.0 for Other food item (Misc)" in {
        cafe.generateBill(Seq("Other")) shouldBe 0.0

      }
      "return 3.5 for Cola Coffee and Chees Sandwich" in {
        cafe.generateBill(Seq("Cola","Coffee","Cheese Sandwich")) shouldBe 4.20

      }
    }
    "Calling generateServiceCharge" should {
      "return no service charge for drink item" in {
        cafe.generateServiceCharge(Seq(Cola), 0.5) shouldBe 0.0
      }
      "return 10% service charge for food item" in {
        cafe.generateServiceCharge(Seq(CheeseSandwich),2.0) shouldBe 0.2
      }
      "return 20% service charge for hod food item" in {
        cafe.generateServiceCharge(Seq(SteakSandwich),4.5) shouldBe 0.9
      }
      "return max £20  for service charge if service charge is more than 20 for multiple items" in {
        cafe.generateServiceCharge(Seq(CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,CheeseSandwich,
          SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,
          SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich,SteakSandwich)
          ,110) shouldBe 20.0
      }
    }
    "Calling CheckFoodAndHotFood" should {
      "return (false,false) for drink and misc items" in {
        cafe.checkFoodAndHotFood(Seq(Cola)) shouldBe (false,false)
      }
      "return (true,false) for drink and misc items" in {
        cafe.checkFoodAndHotFood(Seq(CheeseSandwich,Cola)) shouldBe (true,false)
      }
      "return (true,true) for drink and misc items" in {
        cafe.checkFoodAndHotFood(Seq(SteakSandwich,CheeseSandwich,Cola)) shouldBe (true,true)
      }
    }
  }

}

