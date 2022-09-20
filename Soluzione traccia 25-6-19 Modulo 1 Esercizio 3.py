def unico_treno(P,cognome,treno):
    for prenotazione in P:
        if prenotazione[3] == cognome and prenotazione[0] != treno:
            return False
    return True

def cliente_max(P,giorno):
    clienti = estrai_clienti(P)
    cliente_max = clienti[0]
    max_num_prenotazioni = prenotazioni_cliente_giorno(P,clienti[0],giorno)
    for cliente in clienti[1:]:
        p = prenotazioni_cliente_giorno(P,cliente,giorno)
        if p > max_num_prenotazioni:
            cliente_max = cliente
            max_num_prenotazioni = p
    return cliente_max

def estrai_clienti(P):
    ret = []
    for prenotazione in P:
        cognome = prenotazione[3]
        if cognome not in ret:
            ret.append(cognome)
    return ret

def prenotazioni_cliente_giorno(P,cliente,giorno):
    c = 0
    for prenotazione in P:
        if prenotazione[3] == cliente and prenotazione[1] == giorno:
            c += 1
    return c

def statistiche(P):
    treni = estrai_treni(P)
    ret = []
    for treno in treni:
        ret.append([treno,prenotazioni_treno(P,treno)])
    return ret

def estrai_treni(P):
    ret = []
    for prenotazione in P:
        treno = prenotazione[0]
        if treno not in ret:
            ret.append(treno)
    return ret

def prenotazioni_treno(P,treno):
    c = 0
    for prenotazione in P:
        if prenotazione[0] == treno:
            c += 1
    return c

def aggiungi_prenotazione(P, treno, giorno, num_posto, cognome):
    if not posto_gia_prenotato(P,treno,giorno,num_posto) and not cliente_prenotato_treno_giorno(P,treno,giorno,cognome):
            P.append([treno, giorno, num_posto, cognome])

def posto_gia_prenotato(P,treno,giorno,num_posto):
    for prenotazione in P:
        if prenotazione[0] == treno and prenotazione[1] == giorno and prenotazione[2] == num_posto:
                return True
    return False

def cliente_prenotato_treno_giorno(P,treno,giorno,cognome):
    for prenotazione in P:
        if prenotazione[0] == treno and prenotazione[1] == giorno and prenotazione[3] == cognome:
                return True
    return False




