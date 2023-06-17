/*
This assignment was done in group with Gokul Saji Kumar(A00273682), Rohan Yesudasan Kalathivila(A00278674), Kamaljit Kaur(A00278618)
We did brainstorming in developing the logic and debugging the code.
*/
package game

import kotlin.random.Random

//The enum color defines the color of the die
enum class Color {
    RED,
    WHITE,
    YELLOW,
    ORANGE,
    BLACK 
}

//The enum sides defines number of sides of the die
enum class Sides(val value: Int) {
    THREE(3),
    FOUR(4),
    SIX(6),
    TWENTY(20)
}

//The 'Die' class represents a single die
class Die(private val color: Color, private val numSides: Sides) {
    var sideUp: Int = 1
        private set
        
        //The primary constructor is defined in the class signature

    //The 'init' block is executed every time a new 'Die' object is created
    init {
        roll()
        
    }

    //Secondary constructor with no arguments, defaults to a white six-sided die 
    constructor(): this(Color.WHITE, Sides.SIX)
    //Secondary constructor with a single argument for the number of sides, defaults to a white die
    constructor(numSides: Sides): this(Color.WHITE, numSides)
    //The 'roll' function simulates rolling the die and generates a random side facing up
    fun roll() {
        
        sideUp = Random.nextInt(1, numSides.value + 1) 
    }
    //This function returns the highest possible value on the die 
    fun highestValue(): Int{
      
        return numSides.value
    }

        
    //The 'toString' function provides a string representation of the die object
    override fun toString(): String {
        return "A ${color.name.lowercase()} die with ${numSides.value} faces and currently showing a $sideUp."
    }
}
