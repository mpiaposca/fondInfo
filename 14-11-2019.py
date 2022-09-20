def main():
L1 = [1,2,3,4,5]
L2 = ['a','b','c','d','e']

for i in range(len(L1)):
    print(L1[i], L2[i])
# avendo due liste, se vogliamo stampare gli elementi con il medesimo indice adoperiamo un'iterazione piuttosto semplice;
#volendo potremmo ricorrere alla funzione zip, che ci permette di applicare un for tra due liste come se fosse una sola,
#iterando le coppie di elementi (tuple di elementi, in questo caso 2) anzicchè gli elementi singoli
for (x,y) in zip(L1,L2):
    print(x,y)


# volendo enumerare la lista, ovvero riportare indice ed elemento corrispondente
for i in range(len(L1)):
    print(i, L1[i])

for (i,v) in enumerate(L1):
    print(i,v)
    


