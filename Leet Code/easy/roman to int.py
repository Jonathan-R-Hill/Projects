class Solution:
    
    def romanToInt(self, s: str) -> int:
        
        
        s = s.replace("IV", "IIII")
        s = s.replace("IX", "VIIII")
        s = s.replace("XL", "XXXX")
        s = s.replace("XC", "LXXXX")
        s = s.replace("CD", "CCCC")
        s = s.replace("CM", "DCCCC")
        
        nums = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000
        }
        
        total = 0
        
        for i in range(len(s)):
            
            if s[i] in nums:
                
                a = nums.get(s[i])
                
                total = total + a
                
            
        return total
        