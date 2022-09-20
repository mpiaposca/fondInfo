#Questo programma  serve a creare una lista data dalla somma delle coppie di elementi consecutivi.
def rollup (lista):
    lista_risultato=[]
    for i in range(0, len(lista)//2):
        lista_risultato.append(lista[2*i]+lista[(2*i)+1])
    print(lista_risultato)

        
lista_1 = list(input('Inserisci la lista:'))
rollup(lista_1)
