import com.cafe.{Cola, CafeX}
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
        cafe.generateBill(Seq("Cheese Sandwich")) shouldBe 2.0

      }
      "return 4.5 for food item Steak Sandwich" in {
        cafe.generateBill(Seq("Steak Sandwich")) shouldBe 4.5

      }
      "return 0.0 for Other food item (Misc)" in {
        cafe.generateBill(Seq("Other")) shouldBe 0.0

      }
      "return 3.5 for Cola Coffee and Chees Sandwich" in {
        cafe.generateBill(Seq("Cola","Coffee","Cheese Sandwich")) shouldBe 3.5

      }
    }
    "Calling generateServiceCharge" should {
      "return no service charge for drink item" in {
        cafe.generateServiceCharge(Seq(Cola)) shouldBe 0.0
      }
    }
  }

}

