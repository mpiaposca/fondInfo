def verifica_matrice_identita(M):
    m = len(M) #len(M) == dimensione della matrice se quadrata
    n = len(M[0])
    matrice_diagonale = True
    if m != n:
        return 'La matrice non è quadrata, quindi non può essere diagonale nè identità.'
    for i in range(m):
        for j in range(n):
            if i != j and M[i][j] != 0:
                return False
            else:
                for i in range(m):
                    for j in range(n):
                        if i==j and M[i][j] != 1:
                            return False
                        return True
