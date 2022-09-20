print('---- PRIMA OPZIONE DI PROGRAMMA PER EFFETTUARE LA POTENZA DI UN NUMERO b RISPETTO AD UN ESPONENTE e ----')
b = int(input('base='))
e = int(input("esponente="))

potenza = 1
for i in range (0,e):
    potenza = potenza * b #potenza = potenza * b

print("potenza=", potenza)
    
#scriverlo adoperando il while e/o utilizzando una lista

print('---- SECONDO ESEMPIO ----')
b = int(input('b ='))
e = int(input("e ="))

x = pow(b,e)
print(x)

print('---- TERZO ESEMPIO ----')
def potenza(b,e):
    i = 1
    potenziando = 1
    while i <= e:
        risultato = potenziando * b
        potenziando = risultato
        i += 1
    print(risultato)


print('--- QUARTO ESEMPIO ---')




