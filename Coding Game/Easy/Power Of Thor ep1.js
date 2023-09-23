/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/

var inputs = readline().split(' ');
const lightX = parseInt(inputs[0]); // the X position of the light of power
const lightY = parseInt(inputs[1]); // the Y position of the light of power
var intX = parseInt(inputs[2]); // Thor's starting X position
var intY = parseInt(inputs[3]); // Thor's starting Y position



while (true) {
    const remainingTurns = parseInt(readline());

    var resultX =''
    var resultY = ''

    if (intX < lightX) {
        resultX = "E"
        intX += 1
    }
    else if (intX > lightX){
        resultX = "W"
        intX -= 1
    }

    if (intY < lightY) {
        resultY = "S"
        intY += 1
    }
    else if (intY > lightY) {
        resultY = "N"
        intY -= 1
    }


    console.log(resultY + resultX)

}
    