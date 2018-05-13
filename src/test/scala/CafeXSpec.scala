import com.cafe.CafeX
import org.scalatest.{Matchers, WordSpec}

/**
 * Created by akhileshkumar on 13/05/2018.
 */
class CafeXSpec extends  WordSpec with Matchers {
  val cafe = new CafeX
  "CafeX" when {
    "Calling generateBill" should {
      "return 0.5 for food item Cola" in {
        cafe.generateBill("Cola") shouldBe 0.5

      }
      "return 1.0 for food item Coffee" in {
        cafe.generateBill("Coffee") shouldBe 1.0

      }
      "return 2.0 for food item Cheese Sandwich" in {
        cafe.generateBill("Cheese Sandwich") shouldBe 2.0

      }
      "return 4.5 for food item Steak Sandwich" in {
        cafe.generateBill("Steak Sandwich") shouldBe 4.5

      }
      "return 0.0 for Other food item (Misc)" in {
        cafe.generateBill("Other") shouldBe 0.0

      }
    }
  }

}

