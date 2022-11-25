from datetime import datetime

valid = ['hours', 'start']
answer = ''
while answer not in valid:
    answer = input("Start and finish time  OR  Hours worked\nEnter either start  OR   hours\n").lower()


def hours_calc(hours, mins):
    
    total_minutes = (hours * 60) + mins 
    total_hours = hours + (mins / 60)
    
    print(f"\nTotal Hours =  {total_hours}")
    print(f"Total minutes = {total_minutes}\n")


def start_calc(start, finish):

    # start time
    start_time = start
    end_time = finish

    # convert time string to datetime
    t1 = datetime.strptime(start_time, "%H:%M")
    print('Start time:', t1.time())

    t2 = datetime.strptime(end_time, "%H:%M")
    print('End time:', t2.time())

    # get difference
    delta = t2 - t1

    # time difference in seconds
    print(f"\nTime difference between: {start_time} - {end_time} is:     {delta}\n")

def time_hours():
    while True:
        hour = int(input("Enter hours worked:  "))
        minutes =  float(input("Enter minutes worked:   "))
        hours_calc(hours = hour, mins = minutes)


def time_start():
    while True:
        print("Enter times as 24 hour format eg:  2:20  14:12")
        start_time = input("Enter the start time:   ")
        end_time = input("Enter the finish time:   ")
        start_calc(start = start_time, finish = end_time)


if answer == "hours":
    time_hours()
else:
    time_start()

