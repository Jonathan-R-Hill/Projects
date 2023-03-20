
const valid = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
invalid = []
const N = parseInt(readline());

for (let i = 0; i < N; i++) {
    const ISBN = readline();
    if (ISBN.length == 10) {
        check10(ISBN)
    } 
    else if (ISBN.length == 13) {
        check13(ISBN)
    }
    else {
        invalid.push(ISBN)
    }
}


function check10(ISBN) {
    var multiplyBy = 10
    var result = 0

    for ( let i = 0; i < ISBN.length; i++) {
        if (parseInt(ISBN[i]) in valid) {
            result = result + (parseInt(ISBN[i] * multiplyBy))
            multiplyBy--
        }
        else if (ISBN[i] == 'X') {
            result = result + 10
        }
    }

    if (result % 11 != 0) {
        invalid.push(ISBN)
    }
}

function check13(ISBN) {
    var result = 0

    for ( let i = 0; i < ISBN.length; i++) {
        if (i % 2 == 0 || i == 0) {
            result = result + (parseInt(ISBN[i] * 1))
        }
    
        else if (i % 2 != 0) {
            result = result + (parseInt(ISBN[i] * 3))
        }

        else if (ISBN[i] == 'X') {
             result = result + 13
        }
    }

    if (result % 10 != 0) {
        invalid.push(ISBN)
    }
}


console.log(`${invalid.length} invalid:`)
for (i of invalid) {
    console.log(i)
}

