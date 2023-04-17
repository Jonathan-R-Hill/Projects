
var inputs = readline().split(' ');
const height = parseInt(inputs[0]);
const width = parseInt(inputs[1]);

const XO = []
const numbers = []
const check = []
var answer = 'true'

// Numbers
for (let i = 0; i < height; i++) {
    const line = readline();
    numbers.push(line.split(' '))
}

// X & O
for (let i = 0; i < height; i++) {
    const line = readline();
    XO.push(line.split(' '))
}

for (let i = 0; i < XO.length; i++) {
    for (let j = 0; j < XO[i].length; j++) {
        if (XO[i][j] == "X") {
            check.push(numbers[i][j])
        }
    }
}

for (let i = 0; i < check.length; i++) {
    if ((check[i] > 0 && check[i + 1] > 0) || check[i] < 0 && check[i + 1] < 0) {
        answer = 'false'
        break
    }
}

console.log(answer)