import random

def prodotto_vettore_scalare(vettore,scalare):
    ret = []
    for valore in vettore:
        ret.append(valore * scalare)
    return ret

def somma_vettori(vettore_1,vettore_2):
    ret = []
    for i in range(len(vettore_1)):
        ret.append(vettore_1[i]+vettore_2[i])
    return ret

def leggi_lista_int_lunghezza(n):
    ret = []
    for i in range(n):
        v = int(input("Inserisci l'elemento di indice "+str(i)+":"))
        ret.append(v)
    return ret

def leggi_lista_int():
    n = int(input('Lunghezza:'))
    return leggi_lista_int_lunghezza(n)

def leggi_lista_float_lunghezza(n):
    ret = []
    for i in range(n):
        v = float(input("Inserisci l'elemento di indice "+str(i)+":"))
        ret.append(v)
    return ret

def leggi_lista_float():
    n = int(input('Lunghezza:'))
    return leggi_lista_float_lunghezza(n)

def prodotto_scalare(vettore_1,vettore_2):
    s = 0
    for i in range(len(vettore_1)):
        s += vettore_1[i] * vettore_2[i]
    return s

def e_quadrata(M):
    return len(M) == len(M[0])

def e_nulla(M):
    m = len(M)
    n = len(M[0])
    for i in range(m):
        for j in range(n):
            if M[i][j] != 0:
                return False
    return True

def e_diagonale(M):
    if not e_quadrata(M):
        return False
    dim = len(M)
    for i in range(dim):
        for j in range(dim):
            if i != j and M[i][j] != 0:
                return False
    return True

def e_identita(M):
    if not e_quadrata(M):
        return False
    dim = len(M)
    for i in range(dim):
        for j in range(dim):
            if i == j and M[i][j] != 1 or i != j and M[i][j] != 0:
                return False
    return True

def crea_matrice(num_righe, num_colonne, valore):
    ret = []
    for i in range(num_righe):
        riga = [valore] * num_colonne
        ret.append(riga)
    return ret

def stampa_matrice(M):
    for riga in M:
        print(riga)

def crea_matrice_nulla(num_righe,num_colonne):
    return crea_matrice(num_righe,num_colonne,0)

def crea_matrice_identita(dim):
    ret = crea_matrice_nulla(dim,dim)
    for k in range(dim):
        ret[k][k] = 1
    return ret

def somma_diagonale_principale(M):
    s = 0
    dim = len(M)
    for k in range(dim):
        s += M[k][k]
    return s

def somma_diagonale_secondaria(M):
    s = 0
    dim = len(M)
    for i in range(dim):
        s += M[i][dim-1-i]
    return s

def elimina_riga(M,i):
    del M[i]

def elimina_colonna(M,j):
    for riga in M:
        del riga[j]

def scambia_righe(M,i1,i2):
    t = M[i1]
    M[i1] = M[i2]
    M[i2] = t

def scambia_colonne(M,j1,j2):
    for riga in M:
        t = riga[j1]
        riga[j1] = riga[j2]
        riga[j2] = t

def prodotto_matrice_vettore(M,V):
    ret = []
    for riga in M:
        ps = prodotto_scalare(riga,V)
        ret.append(ps)
    return ret

def prodotto_matrice_scalare(M,s):
    num_righe = len(M)
    num_colonne = len(M[0])
    ret = crea_matrice_nulla(num_righe,num_colonne)
    for i in range(num_righe):
        for j in range(num_colonne):
            ret[i][j] = M[i][j] * s
    return ret

def trasposta(M):
    num_righe_M = len(M)
    num_colonne_M = len(M[0])
    ret = crea_matrice_nulla(num_colonne_M,num_righe_M)
    for i in range(num_righe_M):
        for j in range(num_colonne_M):
            ret[j][i] = M[i][j]
    return ret

def copia_matrice(M):
    ret = []
    for riga in M:
        ret.append(riga[:])
    return ret

def e_simmetrica(M):
    if not e_quadrata(M):
        return False
    dim = len(M)
    for i in range(dim-1):
        for j in range(i+1,dim):
            if M[i][j] != M[j][i]:
                return False
    return True

def crea_matrice_random(num_righe,num_colonne,valore_max):
    ret = []
    for i in range(num_righe):
        riga = []
        for j in range(num_colonne):
            riga.append(random.randint(0,valore_max))
        ret.append(riga)
    return ret

def prodotto_matrici(A,B):
    m = len(A)
    n = len(A[0])
    p = len(B[0])
    R = crea_matrice_nulla(m,p)
    for i in range(m):
        for j in range(p):
            valore = 0
            for k in range(n):
                valore += A[i][k] * B[k][j]
            R[i][j] = valore
    return R

def leggi_matrice_int_dimensioni(nr,nc):
    matrice = []
    for i in range(nr):
        print('-- Riga '+str(i)+' --')
        riga = leggi_lista_int_lunghezza(nc)
        matrice.append(riga)
    return matrice

def leggi_matrice_int():
    r = int(input('Numero righe = '))
    c = int(input('Numero colonne = '))
    return leggi_matrice_int_dimensioni(r,c)

def leggi_matrice_float_dimensioni(nr,nc):
    matrice = []
    for i in range(nr):
        print('-- Riga '+str(i)+' --')
        riga = leggi_lista_float_lunghezza(nc)
        matrice.append(riga)
    return matrice

def leggi_matrice_float():
    r = int(input('Numero righe = '))
    c = int(input('Numero colonne = '))
    return leggi_matrice_float_dimensioni(r,c)

def stampa_matrice_incolonnata(matrice,n):
    '''Incolonna numeri fino a n cifre'''
    for riga in matrice:
        for elemento in riga:
            print(str(elemento).rjust(n+1), end='')
        print()
