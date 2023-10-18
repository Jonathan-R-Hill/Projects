{
    init: function (elevators, floors) {
        console.clear();
        const weight = 0.3;
        const maxFloor = floors.length - 1;
        let spreadOut = true;

        let distance =  (elevator, floorNum) => {
            return Math.abs(elevator.currentFloor() - floorNum);
        }

        let findIdle =  (floorNum) => {
            return elevators.filter((elevator) => (elevator.destinationQueue.length == 0))
                .sort((a, b) => (distance(a, floorNum) - distance(b, floorNum)));
        };

        floors.forEach(function (floor) {
            floor.on("up_button_pressed down_button_pressed", function () {
                let choice = findIdle(floor.floorNum());
                if (choice.length) {
                    choice[0].goToFloor(floor.floorNum());
                }
            });
        });

        elevators.forEach(function (elevator, index) {
            elevator.id = index;

            elevator.on("idle", function () {
                if (spreadOut) {
                    elevator.goToFloor(elevator.id * Math.floor(maxFloor / elevators.length));
                } else {
                    let demand = floors.filter((floor) => (floor.buttonStates.up || floor.buttonStates.down));
                    if (demand.length) {
                        target = demand[0].floorNum();
                    } else {
                        target = 0;
                    }
                    elevator.goToFloor(target);
                }
            });

            elevator.on("floor_button_pressed", function (floorNum) {
                let target = floorNum;
                elevator.goToFloor(target);
            });

            elevator.on("passing_floor", function (floorNum, direction) {
                let floor = floors[floorNum];
                let pressed = elevator.getPressedFloors();
                let stop = floor.buttonStates[direction] && elevator.loadFactor() < weight;

                if (stop || (pressed.indexOf(floorNum) >= 0)) {
                    elevator.destinationQueue = elevator.destinationQueue.filter((d) => (d !== floorNum));
                    elevator.goToFloor(floorNum, true);
                }
            });

            elevator.on("stopped_at_floor", function (floorNum) {
                let up = true;
                let down = true;
                if (floorNum === 0) {
                    up = true;
                    down = false;
                } else if (floorNum === maxFloor) {
                    up = false;
                    down = true;
                }
                elevator.goingUpIndicator(up);
                elevator.goingDownIndicator(down);
            });
        });

        // Set a timer to switch spreadOut mode off
        setTimeout(function () {
            spreadOut = false;
        }, 2000); // (5 seconds)
    },

        update: function (dt, elevators, floors) {
            // We normally don't need to do anything here
        }
}
