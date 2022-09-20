def verifica_liste(L1,L2):
    for i in range(len(L2)):
        if L2[i] and L1.count(L1[i])!= 1:
            return False
        else:
            return True
        
L1= [7, 4, 7, 3, 5, 6]
L2 = [False, True, False, True, True, False]
print(verifica_liste(L1, L2))

def statistiche(M):
    L = []
    for i in range(len(M)):
        L.append(somma_riga(S,i))
    return L

def somma_riga(M, i):
    s=0
    for j in range(len(M[0])):
        s += M[i][j]
    return s

def controlla(A, S):
    for i in range(len(S)):
        if somma_riga(S,i) > A[i][0]:
            return False
        else:
            pass
    return True #


def dominante(M, c):
    for i in range(len(M)):
        L = []
        for j in range(len(M[0])):
            if M[c][j]>M[i][j]:
                L.append(False)
            else:
                L.append(True)
        if i!=c and False not in L:
            return i
        else:
            pass
                
                
def presenze_filtrate(S, c):
    L = []
    for i in range(len(S)):
        if i==c:
            pass
        else:
            for j in range(len(S[0])):
                L.append(somma_colonna(S, j))
    return L.index(max(L))

def somma_colonna(S, j):
    s = 0
    for i in range(len(S)):
        s += S[i][j]
    return s



A = [[9], [6], [12], [5], [10]]
S = [[2, 2, 0, 0, 1, 2, 1], [1, 0, 1, 1, 0, 0, 3], [3, 3, 1, 1, 0, 2, 2], [0, 0, 1, 2, 1, 0, 1], [0, 2, 1, 2, 2, 0, 2]]
print(statistiche(S))
print(controlla(A, S))
print(dominante(S, 3))
print(presenze_filtrate(S, 4))





            
                
        
        
