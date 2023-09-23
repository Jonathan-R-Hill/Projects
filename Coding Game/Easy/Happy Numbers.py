n = int(input())

def is_Happy_num(n):

  past = set()

  while n != 1:

        n = sum(int(i)**2 for i in str(n))

        if n in past:

            return False

        past.add(n)

  return True


for i in range(n):

    x = input()
    
    if is_Happy_num(x) == True:
        print(x, ':)')
    else:
        print(x, ':(')
