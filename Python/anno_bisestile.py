analisi_in_corso = True
while analisi_in_corso:
    richiesta = print('Inserisci un anno, o premi 0 per fermare il programma:')
    anno = int(input())
    if anno == 0:
        analisi_in_corso = False
        print('Operazione terminata.')
    else:
        if anno%4 == 0 or anno%100 == 0 or anno%400 == 0:
            print(anno, 'è un anno bisestile.')
        else:
            print(anno, 'non è bisestile.')
