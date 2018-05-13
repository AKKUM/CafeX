import com.cafe.CafeX
import org.scalatest.{Matchers, WordSpec}

/**
 * Created by akhileshkumar on 13/05/2018.
 */
class CafeXSpec extends  WordSpec with Matchers {
  val cafe = new CafeX
  "CafeX" when {
    "Calling generateBill" should {
      "return number" in {
        cafe.generateBill() shouldBe 1

      }
    }
  }

}

