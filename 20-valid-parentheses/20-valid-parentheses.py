class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) % 2 == 1:
            return False
        else:
            st = []
            symbol = s
            for index in range(len(s)): # s = "(){}[]"
                if s[index] == "(":
                    st.append(")")
                elif s[index] == "{":
                    st.append("}")
                elif s[index] == "[":
                    st.append("]")
                elif len(st) == 0 or st.pop() != s[index]:
                    return False
            return len(st) == 0
            
            
        