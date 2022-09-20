## Esercizio 2 ##

def elabora_lista(L1):
    L2 = []
    for i in range(len(L1)):
        spi = sum(L1[:i])
        ssi = sum(L1[i+1:])
        L2.append(max(spi,ssi))
    return L2

## Esercizio 3.1 ##

def unico_tipo(P,cognome,tipo):
    for riga in P:
        if riga[3] == cognome and riga[2] != tipo:
            return False
    return True

## Esercizio 3.2 ##

def statistiche(P):
    ret = []
    clienti = estrai_clienti(P)
    for cliente in clienti:
        ret.append([cliente,num_pren(P,cliente)])
    return ret

def estrai_clienti(P):
    ret = []
    for riga in P:
        if riga[3] not in ret:
            ret.append(riga[3])
    return ret

def num_pren(P,cliente):
    ret = 0
    for riga in P:
        if riga[3] == cliente:
            ret += 1
    return ret

## Esercizio 3.3 ##

def cliente_max(P):
    stat = statistiche(P)
    cognome_max = stat[0][0]
    max_pren = stat[0][1]
    for i in range(1,len(stat)):
        if stat[i][1] > max_pren:
            max_pren = stat[i][1]
            cognome_max = stat[i][0]
    return cognome_max
    
## Esercizio 3.4 ##

def aggiungi_prenotazione(P,giorno,ora,tipo,cognome):
    for riga in P:
        if riga[0] == giorno and riga[1] == ora:
            return
        if riga[3] == cognome and not riga[4]:
            return
    P.append([giorno,ora,tipo,cognome,False])
