
while true do
    tallest = 0
    max = 0
    for i = 0, 8-1 do
        mountainH = tonumber(io.read()) -- represents the height of one mountain.
        if mountainH >= max then
            tallest = i
            max = mountainH
        end
    end

    print(tallest)


end