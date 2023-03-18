
while (true) {

    var max = 0
    var tallest = 0

    for (let i = 0; i < 8; i++) {
        const mountainH = parseInt(readline()); 


        if (max < mountainH) {
            max = mountainH
            tallest = i
        }
    }

    console.log(tallest);
}
