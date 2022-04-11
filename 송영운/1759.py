from itertools import combinations
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    l, c = map(int, input().split())
    vowel = []
    consonant = []
    alpha = list(map(str, input().split()))
    for c in alpha:
        if c == 'a' or c == 'e' or c == 'i' or \
                c == 'o' or c == 'u':
            vowel.append(c)
        else:
            consonant.append(c)
    len_v = len(vowel)
    len_c = len(consonant)
    ans = []
    for i in range(2, len_c+1):
        if 1 <= l - i <= len_v:
            comb_vowel = list(combinations(vowel, l - i))
            comb_consonant = list(combinations(consonant, i))
            for aa in comb_vowel:
                for bb in comb_consonant:
                    tmp = list(aa) + list(bb)
                    tmp.sort()
                    ans.append("".join(tmp))
    ans.sort()
    for i in range(len(ans)):
        print(ans[i])

