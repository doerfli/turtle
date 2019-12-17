package turtle

class TurtleBuilder constructor(private var turtle: Turtle = Turtle()) {

    fun go(): Turtle {
        println(turtle.toString())
        return turtle
    }

    fun forward(distance: Int) {
        turtle = turtle.forward(distance)
    }

    fun backward(distance: Int) {
        turtle = turtle.backward(distance)
    }

    fun left(angle: Int) {
        turtle = turtle.left(angle)
    }

    fun right(angle: Int) {
        turtle = turtle.right(angle)
    }

    fun penDown() {
        turtle = turtle.penDown()
    }

    fun penUp() {
        turtle = turtle.penUp()
    }
}

fun turtle(initializer: TurtleBuilder.() -> Unit): TurtleBuilder {
    return TurtleBuilder().apply(initializer)
}

