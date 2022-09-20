def moda(l):
    moda = l[0]
    numero_occorrenze_moda = l.count(moda)
    for numero in lista[1:]:
        if l.count(numero) > numero_occorrenze_moda_attuale:
            moda = numero
            numero_occorrenze_moda = l.count(moda)
    return moda


#upgrade
def moda(l):
    moda = l(0)
    numero_occorrenze_moda = l.count(moda)
    for num in lista[1:]:
        numero_occorrenze_num = l.count(num)
        if numero_occorrenze_num > numero_occorrenze_moda:
            moda = num
            numero_occorrenze_moda = numero_occorrenze_num
    return moda

