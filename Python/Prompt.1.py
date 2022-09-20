lunghezza = int(input("inserisci la lunghezza della lista:"))
lista = []
for i in range (lunghezza):
    prompt = "Inserisci l'elemento di indice " + str(i) + ". "
    #lista.append(elemento): agginge un elemento in coda alla lista
    #lista.append(int(input(ptompt))
    x = int(input(prompt))
    lista.append(x)

print("---Conteggio degli zeri e dei pari ---")
conta_zeri = 0
conta_pari = 0 for i in range(len(lista)):
    if lista [i] == 0:
        conta_zeri += 1
    if lista[i]%2 == 0:
        conta pari += 1
#oppure: for x in lista:
        #if  x==0:
         #conta_zeri += 1
        #if x%2 == 0
         #conta_pari +=1

print("La lista contiene", conta_zeri, "zeri e"; conta_pari, "numeri pari.")


        
