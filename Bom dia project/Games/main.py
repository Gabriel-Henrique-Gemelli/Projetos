import pygame
from os.path import join
from random import randint

# Inicia o py game sempre precisa ter 
pygame.init()

class Player(pygame.sprite.Sprite):
    def __init__(self,groups):
        super().__init__(groups)
        self.image = pygame.image.load(join("Assets","5games-main","space shooter",'images','player.png'))
        self.rect = self.image.get_frect(center = ((WIDTH /2,HEIGHT - 40)))
        self.Player_direction = pygame.math.Vector2()
        self.player_speed = 300

        
       
    def player_moviment(self,dt):
        # print('movimento')
        keys = pygame.key.get_pressed()
        self.Player_direction.x = int(keys[pygame.K_d]) - int(keys[pygame.K_a])
        self.Player_direction.y = int(keys[pygame.K_s]) - int(keys[pygame.K_w])
        self.Player_direction = self.Player_direction.normalize() if self.Player_direction else self.Player_direction
        self.rect.center += self.Player_direction * self.player_speed * dt
        recent_keys = pygame.key.get_just_pressed()
        if int(recent_keys[pygame.K_SPACE]) == 1:
            print('fire lazer')

class Star(pygame.sprite.Sprite):
     def __init__(self,groups):
        super().__init__(groups)
        self.image = pygame.image.load(join("Assets","5games-main","space shooter",'images','Star.png'))
        self.rect = self.image.get_frect(center = ((WIDTH /2,HEIGHT - 40)))


# CRIAR A TELA
WIDTH,HEIGHT = 1280,720
Display_surface = pygame.display.set_mode((WIDTH,HEIGHT))
#Mudar o nome da janela 
pygame.display.set_caption('Gemas')
#Pegar o fps do jogo 
Clock = pygame.time.Clock()

All_sprites = pygame.sprite.Group()
player = Player(All_sprites)

#importar a imagem do jogador
Star_Path = join("Assets","5games-main","space shooter",'images','Star.png')
Meteor_Path = join("Assets","5games-main","space shooter",'images','meteor.png')
laser_path = join("Assets","5games-main","space shooter",'images','laser.png')


Star_surface = pygame.image.load(Star_Path).convert_alpha()
Star_Position = [(randint(0,WIDTH),randint(0,HEIGHT)) for i in range(20)]

Meteor_Surface = pygame.image.load(Meteor_Path).convert_alpha()
Meteor_rect = Meteor_Surface.get_frect(center = (WIDTH/2,HEIGHT/2))

laser_surface = pygame.image.load(laser_path).convert_alpha()
laser_rect = laser_surface.get_frect(bottomleft = (20,HEIGHT -20))

running = True


while running:
    #Controla o fps do jogo 
    dt = Clock.tick() / 1000
    #Event loop
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

             
            
    # Player input
    Keys = pygame.key.get()
    if int(Keys[pygame.K_a]) == 1 :
        print('aaaaaa')
    elif int(Keys[pygame.K_w]) == 1 :
        print('wwwwww')
    elif int(Keys[pygame.K_s]) == 1 :
        print('ssssss')
    elif int(Keys[pygame.K_d]) == 1 :
        print('dddddd')

    
    
    
    All_sprites.update()
    # # draw the game 
    Display_surface.fill('darkgrey')
    
    Display_surface.blit(Meteor_Surface,Meteor_rect)
    for pos in Star_Position:
        Display_surface.blit(Star_surface,pos)  

    Display_surface.blit(laser_surface,laser_rect)
    All_sprites.draw(Display_surface)
   
    player.player_moviment(dt)
    pygame.display.update() # atualiza a pagina inteira  
    # Ja o pygame.display.flip() Atualiza apenas uma parta de tela nao ela inteira
# Termina o jogo
pygame.quit()