
const numbers = {
    0: [],
    1: [],
    2: [],
    3: [],
    4: [],
    5: [],
    6: [],
    7: [],
    8: [],
}

for (let i = 0; i < 9; i++) {
    var inputs = readline().split(' ');
    for (let j = 0; j < 9; j++) {
        const n = parseInt(inputs[j]);
        numbers[i].push(n)
    }
}

var topLeft = [
    numbers[0][0], numbers[0][1], numbers[0][2], 
    numbers[1][0], numbers[1][1], numbers[1][2],
    numbers[2][0], numbers[2][1], numbers[2][2],
]

var topMiddle = [
    numbers[0][3], numbers[0][4], numbers[0][5], 
    numbers[1][3], numbers[1][4], numbers[1][5],
    numbers[2][3], numbers[2][4], numbers[2][5],
]

var topRight = [
    numbers[0][6], numbers[0][7], numbers[0][8], 
    numbers[1][6], numbers[1][7], numbers[1][8],
    numbers[2][6], numbers[2][7], numbers[2][8],
]

var middleLeft = [
    numbers[3][0], numbers[3][1], numbers[3][2], 
    numbers[4][0], numbers[4][1], numbers[4][2],
    numbers[5][0], numbers[5][1], numbers[5][2],
]

var middleMiddle = [
    numbers[3][3], numbers[3][4], numbers[3][5], 
    numbers[4][3], numbers[4][4], numbers[4][5],
    numbers[5][3], numbers[5][4], numbers[5][5],
]

var middleRight = [
    numbers[3][6], numbers[3][7], numbers[3][8], 
    numbers[4][6], numbers[4][7], numbers[4][8],
    numbers[5][6], numbers[5][7], numbers[5][8],
]

var bottomLeft = [
    numbers[6][0], numbers[6][1], numbers[6][2], 
    numbers[7][0], numbers[7][1], numbers[7][2],
    numbers[8][0], numbers[8][1], numbers[8][2],
]

var bottomMiddle = [
    numbers[6][3], numbers[6][4], numbers[6][5], 
    numbers[7][3], numbers[7][4], numbers[7][5],
    numbers[8][3], numbers[8][4], numbers[8][5],
]

var bottomRight = [
    numbers[6][6], numbers[6][7], numbers[6][8], 
    numbers[7][6], numbers[7][7], numbers[7][8],
    numbers[8][6], numbers[8][7], numbers[8][8],
]

var Top = [topLeft, topMiddle, topRight]
var Middle = [middleLeft, middleMiddle, middleRight]
var Bottom = [bottomLeft, bottomMiddle, bottomRight]


function totals() {
    var topTotal = 0
    for (let i of Top) {
        for (let j of i) {
        topTotal = topTotal + parseInt(j)
        }
    }

    var midTotal = 0
    for (let i of Middle) {
        for (let j of i) {
        midTotal = midTotal + parseInt(j)
        }
    }

    var botTotal = 0
    for (let i of Bottom) {
        for (let j of i) {
        botTotal = botTotal + parseInt(j)
        }
    }

    if (botTotal == 135 && midTotal == 135 && topTotal == 135) {
        return true
    }
    else {
        return false
    }
}

function checkRow() {
    if (totals() == true) {
        for (let i in numbers) {
            var myNumbers = []

            for (j in numbers[i]) {
                myNumbers.push(numbers[i][j])
            }
            
            const mySet = new Set(myNumbers)

            if (mySet.size != 9) {
                return false
                
            }
        }
        return true
    }
    return false
}

function checkCol() {
    if (checkRow() == true) {
        for (let j = 0; j != 9; j++) {
            var myNumbers = []
            for (let i = 0; i < Object.keys(numbers).length; i++) {
                myNumbers.push(numbers[i][j])
            }
        const mySet = new Set(myNumbers)
    
        if (mySet.size != 9) {
            return false
        }
        
        }
        return true
    }
    return false
}

function top3() {
    for (let i = 0; i < Top.length; i++) {
        var myNumbers = []
        for (let j = 0; j != 9; j++) {
            myNumbers.push(Top[i][j])
        }
        const mySet = new Set(myNumbers)
        
        if (mySet.size != 9) {
            return false
        }
      
    }
   
    return true   
}

function middle3() {
    for (let i = 0; i < Middle.length; i++) {
        var myNumbers = []
        for (let j = 0; j != 9; j++) {
            myNumbers.push(Middle[i][j])
        }
        const mySet = new Set(myNumbers)
        
        if (mySet.size != 9) {
            return false
        }
    }

    return true   
}

function bottom3() {
    for (let i = 0; i < Bottom.length; i++) {
        var myNumbers = []
        for (let j = 0; j != 9; j++) {
            myNumbers.push(Bottom[i][j])
        }
        const mySet = new Set(myNumbers)

        if (mySet.size != 9) {
            return false
        }
    }
   
    return true   
}

if (checkRow() && checkCol() && top3() && middle3() && bottom3()) {
    console.log("true")
}
else {
    console.log("false")
}
