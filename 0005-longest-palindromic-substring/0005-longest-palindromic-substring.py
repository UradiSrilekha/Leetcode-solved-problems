class Solution:
    def longestPalindrome(self, s: str) -> str:
        a,word="",""
        if s[::-1]!=s and len(s)<=2:
            return s[0]
        elif s[::-1]==s:
            return s
        for i in range(len(s)):
            for j in range(i+1,len(s)):
                a=s[i:j+1]
                if a==a[::-1]:
                    if  word=="":
                        word=a
                    elif len(a)>len(word) and word !="":
                        word = a
            a=""
        if word:
            del a
            del s
            return word
        else:
            return s[0]