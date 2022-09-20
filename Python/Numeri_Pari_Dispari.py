verifica_in_corso = True
while  verifica_in_corso:
    numero = int(input('Inserisci un numero, o digita "0" per terminare:'))
#Verifico se il resto della divisione intera di tale numero per 2 è zero o un qualsiasi altro numero.
#Basta pensare alla condizione di parità e di disparità.
    if  numero == 0:
        verifica_in_corso = False
        print('Operazione terminata.')
    elif numero % 2 == 0:
        print("Il numero selezionato è pari.")
    else:
        numero %2 != 0
        print("Il numero selezionato è dispari.")

    
