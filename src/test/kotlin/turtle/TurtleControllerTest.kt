package turtle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TurtleControllerTest {

    private lateinit var controller: TurtleController

    @BeforeEach
    fun before() {
        controller = TurtleController(Turtle())
    }

    @Test
    fun forward() {
        val (x,y,r) = controller.forward(10).turtle()
        assertThat(x).isEqualTo(10)
        assertThat(y).isEqualTo(0)
        assertThat(r).isEqualTo(0)
    }

    @Test
    fun forwardNegative() {
        val (x,y,r) = controller.forward(-10).turtle()
        assertThat(x).isEqualTo(-10)
        assertThat(y).isEqualTo(0)
    }

    @Test
    fun backward() {
        val (x,y,r) = controller.backward(10).turtle()
        assertThat(x).isEqualTo(-10)
        assertThat(y).isEqualTo(0)
    }

    @Test
    fun backwardNegative() {
        val (x,y,r) = controller.backward(-10).turtle()
        assertThat(x).isEqualTo(10)
        assertThat(y).isEqualTo(0)
    }

    @Test
    fun right() {
        val (x,y,r) = controller.right(90).turtle()
        assertThat(x).isEqualTo(0)
        assertThat(y).isEqualTo(0)
        assertThat(r).isEqualTo(90)
    }

    @Test
    fun rightNegative() {
        val (x,y,r) = controller.right(-90).turtle()
        assertThat(x).isEqualTo(0)
        assertThat(y).isEqualTo(0)
        assertThat(r).isEqualTo(-90)
    }

    @Test
    fun left() {
        val (x,y,r) = controller.left(-90).turtle()
        assertThat(x).isEqualTo(0)
        assertThat(y).isEqualTo(0)
        assertThat(r).isEqualTo(90)
    }

    @Test
    fun leftNegative() {
        val (x,y,r) = controller.left(90).turtle()
        assertThat(x).isEqualTo(0)
        assertThat(y).isEqualTo(0)
        assertThat(r).isEqualTo(-90)
    }

    @Test
    fun forwardRightForward() {
        val (x, y, r) = controller.forward(10).right(90).forward(10).turtle()
        assertThat(x).isEqualTo(10)
        assertThat(y).isEqualTo(10)
        assertThat(r).isEqualTo(90)
    }

    @Test
    fun forwardRightNegativeForward() {
        val (x, y, r) = controller.forward(10).right(-90).forward(10).turtle()
        assertThat(x).isEqualTo(10)
        assertThat(y).isEqualTo(-10)
        assertThat(r).isEqualTo(-90)
    }

    @Test
    fun rightBackward() {
        val (x, y, r) = controller.right(90).backward(10).turtle()
        assertThat(x).isEqualTo(0)
        assertThat(y).isEqualTo(-10)
        assertThat(r).isEqualTo(90)
    }

    @Test
    fun left45Forward10() {
        val (x,y,r) = controller.left(45).forward(10).turtle()
        assertThat(x).isEqualTo(7)
        assertThat(y).isEqualTo(-7)
        assertThat(r).isEqualTo(-45)
    }

    @Test
    fun right20Forward10() {
        val (x,y,r) = controller.right(20).forward(10).turtle()
        assertThat(x).isEqualTo(9)
        assertThat(y).isEqualTo(3)
        assertThat(r).isEqualTo(20)
    }

    @Test
    fun right20Forward10Left90Forward10() {
        val (x,y,r) = controller.right(20).forward(10).left(90).forward(10).turtle()
        assertThat(x).isEqualTo(12)
        assertThat(y).isEqualTo(-6)
        assertThat(r).isEqualTo(-70)
    }

    @Test
    fun square() {
        val (x,y,r) = controller
            .forward(10)
            .right(90)
            .forward(10)
            .right(90)
            .forward(10)
            .right(90)
            .forward(10)
            .right(90).turtle()

        assertThat(x).isEqualTo(0)
        assertThat(y).isEqualTo(0)
        assertThat(r).isEqualTo(0)
    }

    @Test
    fun squareApply() {
        val (x,y,r) = controller.apply {
            forward(10)
            right(90)
            forward(10)
            right(90)
            forward(10)
            right(90)
            forward(10)
            right(90)
        }.turtle()

        assertThat(x).isEqualTo(0)
        assertThat(y).isEqualTo(0)
        assertThat(r).isEqualTo(0)
    }

    @Test
    fun squareDsl() {
        val (x,y,r) = turtle {
            forward(10)
            right(90)
            forward(10)
            right(90)
            forward(10)
            right(90)
            forward(10)
            right(90)
        }.go()

        assertThat(x).isEqualTo(0)
        assertThat(y).isEqualTo(0)
        assertThat(r).isEqualTo(0)
    }

}