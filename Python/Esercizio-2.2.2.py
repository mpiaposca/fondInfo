prezzo_di_copertina = 24.95
sconto_libreria = (prezzo_di_copertina*0.4)
costo_totale_copie = (prezzo_di_copertina - sconto_libreria)*60
costi_di_spedizione = 3 + (0.75)*(59)
costo_complessivo = costo_totale_copie + costi_di_spedizione
print(costo_complessivo)
