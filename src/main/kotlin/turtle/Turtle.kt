package turtle

import kotlin.math.cos
import kotlin.math.sin

data class Turtle(val x: Int = 0, val y: Int = 0, val r: Int = 0, val penDown: Boolean = false)

fun Turtle.forward(distance: Int): Turtle {
    return copy(
        x = x + (distance * cos(r.toRadians())).toInt(),
        y = y + (distance * sin(r.toRadians())).toInt())
}

fun Turtle.backward(distance: Int): Turtle {
    return forward(-distance)
}

fun Turtle.right(degrees: Int): Turtle {
    return copy(r = (r + degrees) % 360 )
}

fun Turtle.left(degrees: Int): Turtle {
    return right(-degrees)
}

private fun Int.toRadians(): Double {
    return 2 * Math.PI * this / 360
}

fun Turtle.penDown(): Turtle {
    return copy(penDown = true)
}

fun Turtle.penUp(): Turtle {
    return copy(penDown = false)
}
