def scambio_index(x,y):
    t = L[x]
    L[x] = L[y]
    L[y] = t

def insertion_sort(L):
    dim = len(L)
    for l in range(dim):
        a = min(L[l:])
        i = L.index(a)
        scambio_index(i, l)
    return L
