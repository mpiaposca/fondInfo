import pygame

pygame.init()

width = 360
height = 400
gameDisplay = pygame.display.set_mode((width, height))
pygame.display.set_caption('SnackMachine')
run = True
while run: # main game loop
    pygame.time.delay(50)
    for event in pygame.event.get():
        if event.type == pygame.quit:
            run = False
        keys = pygame.key.get.get_pressed()



        
pygame.quit()
