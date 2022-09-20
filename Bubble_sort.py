#la funzione seguente riceve due parametri, che corrispondono
#agli indici degli elementi che vogliamo scambiare
def scambio_index(x,y):
    t = L[x]
    L[x] = L[y]
    L[y] = t
    
 

def bubble_sort(L):
    dim = len(L) #memorizzo la lunghezza della lista
    for j in range(dim): #scorro ogni elemento della lista
        for i in range(1, dim): #scorro ogni confronto possibile 
            if L[dim - i] < L[dim -1 -i]: # confronto tra successivo e precedente
                scambio_index((dim - i), (dim - 1 - i))
            pass
            
