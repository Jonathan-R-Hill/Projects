var r1 = parseInt(readline());
var r2 = parseInt(readline());


while (r1 != r2) {

    if (r1 == r2) {
        console.log(r1)
        break
    }

    if (r1 < r2) {
        var digits = r1.toString().split('').map(Number)
        var total = 0
        for (let i of digits) {
            total += i
        }
        r1 += total      
    }
    else if (r1 > r2) {
        var digits = r2.toString().split('').map(Number)
        var total = 0
        for (let i of digits) {
            total += i
        }
        r2 += total       
    }

    for (let j; j < digits.length; j++) {
        digits.pop(j)
    }
}

console.log(r1)
