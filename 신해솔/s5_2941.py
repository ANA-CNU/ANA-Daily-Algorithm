def croatia(word, count=0):
    croatian_char = ["c=", "c-", "dz=", "d-",
                     "lj", "nj", "s=", "z="]

    if len(word) > 0:
        count += 1
        if word[0:2] in croatian_char:
            return croatia(word[2:], count)
        elif word[0:3] in croatian_char:
            return croatia(word[3:], count)
        else:
            return croatia(word[1:], count)
    else:
        return count


word = input()
print(croatia(word))
