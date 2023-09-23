
const [nbFloors,width,nbRounds,exitFloor,exitPos,nbTotalClones,nbAdditionalElevators,nbElevators] = readline().split` `.map(Number);

elevators={}

for (i=0;i<nbElevators;i++) { 
    const [elevatorFloor, elevatorPos] = readline().split` `.map(Number)
    elevators[elevatorFloor]=elevatorPos
} 

getAction = (clonePos, cloneFloor, direction) => { 
    // ELEVATOR IS ON LEFT AND CLONE IS MOVING TO THE RIGHT
    if(elevators[cloneFloor] < clonePos && direction == 'RIGHT'){
        return 'BLOCK'
    } 
    // ELEVATOR IS ON RIGHT AND CLONE IS MOVING TO THE LEFT
    if(elevators[cloneFloor] > clonePos && direction == 'LEFT') {
        return 'BLOCK'
    }
    // IF ON EXIT FLOOR, EXIT POS IS TO LEFT AND CLONE IS GOING TO THE RIGHT 
    if(cloneFloor == exitFloor && exitPos < clonePos && direction == 'RIGHT') {
        return 'BLOCK'
    }
    // F ON EXIT FLOOR, EXIT POS IS TO RIGHT AND CLONE IS GOING TO THE LEFT 
    if(cloneFloor == exitFloor && exitPos > clonePos && direction == 'LEFT') {
        return 'BLOCK'
    }
    // DON'T RUN INTO LASERS 😆
    if(clonePos==width-1 && direction == "RIGHT" || clonePos==0 && direction == 'LEFT') return 'BLOCK'
    return 'WAIT'
}


while (true) {
    const [cloneFloor, clonePos, direction] = readline().split` `.map((d,i)=>i<2?+d:d)

    action = getAction(clonePos, cloneFloor, direction)
    console.log(action)
}