n = int(input('Inserisci un numero:'))
divisori = [1, n]
x = 2
while x <= n//2:           #2 è il primo dei divisori dopo 1 ed n
    if n% x ==0:
        divisori.append(x)
    x += 1
    divisori.append(n)
if len(divisori) == 2:
    print(n, 'è numero primo.')
else:
    print(n, 'non è un numero primo.')




n = int(input('Inserisci un numero:'))
divisori = [1, n]
x = 2
while x <= n//2:
    if n% x ==0:
        divisori.append(x)
        #la prima volta che entriamo nell'if abbiamo già aggiunto un divisore: ora potremmo interrompere l'iterazione fermando il while (basta un break o rendere falsa la condizione)
        break
    x += 1
    divisori.append(n)
if len(divisori) == 2:
    print(n, 'è numero primo.')
else:
    print(n, 'non è un numero primo.')





n = int(input('Inserisci un numero:'))
divisori = [1, n]
x = 2
trovato_terzo_divisore = False
while x <= n//2 and not trovato_terzo_divisore:
    if n%x == 0:
        divisori.append(x)
        trovato_terzo_divisore = True
    x += 1
if len(divisori) == 2:
    print(n, 'è numero primo.')
else:
    print(n, 'non è un numero primo.')





#come sostituire la lista? eliminando la condizione x <= n e considerando come divisori possibili 
n = int(input('Inserisci un numero:'))
divisori = [1, n]
x = 2
trovato_terzo_divisore = False
while x <= n//2 and not trovato_terzo_divisore:
    if n%x == 0:
        divisori.append(x)
        trovato_terzo_divisore = True
    x += 1
if trovato_terzo_divisore: #schifezza: trovato_terzo_divisore == True
    print(n, 'non è numero primo.')
else:
    print(n, 'è un numero primo.')


#il for in python nasce con il significato del for each, ed ha perciò un altro significato, non alternativo al while come in Java.

    
#dopo "in" qualsiasi oggetto iterabile come una stringa 

for x in 'abcde':
    print(x) #primo giro x=0; secondo x=1; ecc...

for x in [a, b, c, d, e]:
    print(x)
    
for x in ['Fondamenti','di','informatica']:
    print(len(x), x)


#stampare i numeri da 1 a n, non potendo usare un oggetto itrabile come una lista; il for GENERA
for x in range(1, 11):
    print(x)






































    



    
