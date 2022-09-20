print('---Verifica tutti uguali ad un dato valore. ---')
valore = int( input("Inserisci valore:"))
tutti_uguali = True
i = 0
while i < lunghezza and tutti_uguali:
    if lista[i] != valore:
        tutti_uguali = False
    i+=1
if tutti_uguali:
    print("Tutti gli elementi sono uguali")
else:
    ('Non tutti gli elementi sono uguali.')

        
