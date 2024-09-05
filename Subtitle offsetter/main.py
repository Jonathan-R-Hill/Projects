# ---------- Constants for time covnersion ---------- #
HOURS = 3600000
MINS = 60000
SECONDS = 1000

# ---------- Functions ---------- #
def time_to_milliseconds(time: str) -> int:
    # Split time
    hours, minutes, seconds_milliseconds = time.split(":")
    seconds, milliseconds = seconds_milliseconds.split(",")

    # Convert to ms
    total_milliseconds = (int(hours) * HOURS) + (int(minutes) * MINS) + (int(seconds) * SECONDS) + int(milliseconds)

    return total_milliseconds


def milliseconds_to_time(ms: int) -> str:
    # Extract times
    hour = ms // HOURS
    ms %= HOURS

    minute = ms // MINS
    ms %= MINS

    second = ms // SECONDS
    milli = ms % 1000

    # was doing it in cpp but idk how to do this in cpp :)))))
    time_str = f"{int(hour):02}:{int(minute):02}:{int(second):02},{int(milli):03}"

    return time_str


def shift_subtitles(input_file, output_file, time_to_shift):
    with open(input_file, 'r') as f:
        file_data = f.readlines()
    
    with open(output_file, 'w') as output_file:
        for line in file_data:
            if "-->" in line:
                # Split the timecode
                start_time = line[:12]  # 12 chars
                end_time = line[17:29]  # chars 17-29
                
                # Convert
                start_ms = time_to_milliseconds(start_time)
                end_ms = time_to_milliseconds(end_time)
                
                # Apply the shift
                start_ms = max(0, start_ms + time_to_shift)
                end_ms = max(0, end_ms + time_to_shift)
                
                # Convert back to time
                shifted_start_time = milliseconds_to_time(start_ms)
                shifted_end_time = milliseconds_to_time(end_ms)
                
                # Add new time to le file
                output_file.write(f"{shifted_start_time} --> {shifted_end_time}\n")
            else:
                # Copy other lines
                output_file.write(line)

# ---------- File ---------- # 
inputFile = "yourFile.srt"     # ---------- UPDATE ME ---------- #   Use your subtile file name / path

outputFile = inputFile[:-4] + " updated.srt"    # ---------- DON'T CHANGE ME ---------- #

# ---------- Time to move by ---------- #
shift = 2000   # Miliseconds    # ---------- UPDATE ME ---------- #     1000 = 1 second

# ---------- Function call ---------- #
shift_subtitles(input_file=inputFile, output_file=outputFile, time_to_shift=shift)      # ---------- DON'T CHANGE ME ---------- #
