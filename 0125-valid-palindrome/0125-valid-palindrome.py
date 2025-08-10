class Solution:
    def isPalindrome(self, s: str) -> bool:
         filtered_chars=''.join(char.lower() for char in s if char.isalnum())
         return filtered_chars==filtered_chars[::-1]       