package turtle

import kotlin.math.cos
import kotlin.math.sin

class TurtleController constructor(private var turtle: Turtle = Turtle()) {

    fun go(): Turtle {
        println(turtle.toString())
        return turtle
    }

    fun forward(distance: Int): TurtleController {
        turtle = turtle.copy(
            x = turtle.x + (distance * cos(turtle.r.toRadians())).toInt(),
            y = turtle.y + (distance * sin(turtle.r.toRadians())).toInt())
        return this
    }

    fun backward(distance: Int): TurtleController {
        return forward(-distance)
    }

    fun left(angle: Int): TurtleController {
        return right(-angle)
    }

    fun right(angle: Int): TurtleController {
        turtle = turtle.copy(r = (turtle.r + angle) % 360 )
        return this
    }

    fun penDown(): TurtleController {
        turtle = turtle.copy(penDown = true)
        return this
    }

    fun penUp(): TurtleController {
        turtle = turtle.copy(penDown = false)
        return this
    }

    /**
     * get a copy of the current turtle
     */
    fun turtle(): Turtle {
        return turtle.copy()
    }

}

fun turtle(initializer: TurtleController.() -> Unit): TurtleController {
    return TurtleController().apply(initializer)
}

private fun Int.toRadians(): Double {
    return 2 * Math.PI * this / 360
}
