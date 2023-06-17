/*
This assignment was done in group with Gokul Saji Kumar(A00273682), Rohan Yesudasan Kalathivila(A00278674), Kamaljit Kaur(A00278618)
We did brainstorming in developing the logic and debugging the code.
*/
package game

fun main() {
   
    val game = DiceGame()
    game.run()
} 

class DiceGame() {

    fun run() 
    {
        var repeat = true //Boolean value set to 'true' so that the while loop executes until the value becomes false
        while(repeat) //as long as the repeat value is true the while loop executes
        {
            //Displaying the menu option
            println("1-> Create dice of different sides and roll them") 
            println("2-> Select one die and get it highest value")
            println("3-> Roll five six-sided dice until you get a value 5  and count its number")
            print("Select an option from the above ")
            val inputUser = readLine()?.toIntOrNull()
            when (inputUser) 
            {
                1 -> {
                    rollDiceOfDifferentSides() //Option 1: Create and roll different sized dice
                }
                2 -> {
                    highestValueOfDie6() //Option 2: Showing the highest value when a die with 6sides is rolled
                }
                    3 -> {
                    rollToGetFive() //Option 3: Roll five dice until you get 5 of a kind and count iterations
                }
                else -> {
                    println("Invalid input.")
                }
            }
            println("Press q to exit and y to do further conversion")  //Prompt the user to decide whether to continue or exit
            val quit = readLine()  //Read user input to determine whether to continue or exit
            if (quit == "q") 
                {
                repeat = false //if user enters 'q' then repeat is set to 'false' which means it exit the while loop and program terminates
                }
        }
    }

    private fun rollDiceOfDifferentSides() 
    {
        println("Creates a die object with the default number of sides ")
        val die1 = Die() //Create a default die using 0 argument constructor                                
        println("Creating a die with 20 sides...")
        val die2 = Die(Sides.TWENTY) //Create a die with 20 sides using 1 argument constructor
        println("Creating a YELLOW die with 6 sides\n")
        val die3 = Die(Color.YELLOW, Sides.SIX) //Create a YELLOW die with  6 sides using 2 argument constructor
        println(die1)  //Printing the initial values of the dice before rolling
        println(die2)                                 
        println(die3)
        println("***Rolling the dice***")
        die1.roll() //Roll the dice
        die2.roll()
        die3.roll()
        println("Current side of die1: ${die1.sideUp}") //Display the new side of each die
        println("Current side of die2: ${die2.sideUp}")
        println("Current side of die3: ${die3.sideUp}")
    }

     //To show the highest side
     private fun highestValueOfDie6() 
    {
        val die = Die(Sides.SIX)
        println("${die.highestValue()} is the highest value in the dice with 6 sides")
    }
    //It shows the number of times the dice is rolled to get 5
    private fun  rollToGetFive() 
    {
        println("Rolling 5 dice with 6 sides")
        //Creating objects for die class
        val die1 = Die()
        val die2 = Die()
        val die3 = Die()
        val die4 = Die()
        val die5 = Die()
        var count = 0
        while (!(die1.sideUp == die2.sideUp 
                && die2.sideUp == die3.sideUp 
                && die3.sideUp == die4.sideUp 
                && die4.sideUp == die5.sideUp)) 
        {
            die1.roll() //Rolling all the 5 dice
            die2.roll()
            die3.roll()
            die4.roll()
            die5.roll()
            count += 1                                            
        }

        println("$count times rolled to get 5")
    }
    
}
