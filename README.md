# Musical-Guacamole
John Bandelaria, Tong Chen

(Read Me instructions 1 (#) at the begining of a line followed by space for Small Heading 2(#) for large font heading. Keep Weekly Progress in Read Me)

## Tong: @   John: $

## Week 1
@$Musical Guacamole flow chart presentation added to github

@worked and researched on sound for game (audioinputstream)
 Link: http://stackoverflow.com/questions/953598/audio-volume-control-increase-or-decrease-in-java

$added pictures for use in game textures (chip and guac) to github

@$ analyzed block the pig code on the AllenCompSci repository to learn graphics

$tested and played around with graphics.java code 

@tried getting mp3 instead of wav to work (much more efficient in size)

$experimented with drawing and moving polygons 

## Week 2 

@experimented using different decibel values with master gain in audioInputStream to change volume of sound.

$more shapes and moving https://mathbits.com/MathBits/Java/Graphics/GraphingMethods.htm 

$moving based on the players movements

@was able to have music play at the same time as graphics in the driver using John's src and putting in audioInputStream

$experimented and researched moving objects and hitboxes http://stackoverflow.com/questions/19629257/java-moving-an-object-across-the-screen and http://www.dreamincode.net/forums/topic/100531-how-to-create-a-circle-eclipse-that-will-move/

@used photoshop to try and get some good chip textures

@looked at Galaga 2.0 graphics to see how to use variables and keylistener with draw to make the image move with the key clicks. (graphicss.java)

## Week 3

$tried writing font, started on start screen, worked on worksheet, started working on actual screens used in the game

@ worked on mouselistener, recording x and y, to be used for starting the game from the start menu (graphicss.java)

@more audio scaling tests (audioInputStream.java)

$made start screen, created separate graphics class, tried moving rectangles

@tried to get mouse clicking to work with screen and tried to make screen come before graphics start

$finished start screen, tried getting objects to move on its own for ai

## Week 4

@continued working on start screen and mouse detection to start the game

$finally got objects to move, working on hit detection and getting objects to move back and forth

@finally finished mouse detection for screen (ditched using a separate "Screen" class for start menu, just integrated into "Graphics")

@edited guacamole image in photoshop like the chip character, for enemies

$with objects movement, got it to loop and bounce back and forth with boolean

## Week 5

$worked on hitboxes with enemies and walls

@worked on photoshop with guacamole(having trouble with making background transparent to make guacamole a circle) and making methods for the different screens at the beginning

$refined hitboxes, tried getting color of each pixel to function as walls, did research:http://stackoverflow.com/questions/16738588/if-the-color-on-the-screen-equals-a-certain-color-java and http://apcmag.com/how-to-code-java-12-basic-game-development.htm/ (TONG ABSENT)

## Week 6

@combined the 2 codes between John and Tong, in tongstuff/graphicss

## Week 7

@learned about "tiled" program, tile sets, setting them with properties from Chris and Zach. looked at the overstory github code on implementation to check properties to get wall collision.

$worked on end screen, fixed hitboxes, started working on layering to set up field of view

## Week 8

@Tried to create map in tiled and do collision, researched ways to make collision layers for tilemap

$finished endscreen, tried making field of view in photoshop, made markers for the maze

## Week 9

$Refined markers, refined borders and what happens when the border is reached

@finished background tilemap terrain

$Got credits screen, got game to exit and pause with button presses

@Set properties for 2 new layers on the tilemap, uploaded as tilemaptest

## Week 10

@since we don't wanna convert from graphics2D to libgdx just to use tilemaps for wall collision detection, we decided to just get the individual pixels color. Back to the drawing board:  http://stackoverflow.com/questions/22839618/how-to-get-pixel-color-from-graphics-g. New plan: draw a map of a maze with walls, set that as an image, get color of pixel of where the character moves, if possible move that way, if not do nothing, then draw black overlay to make a square field of vision instead of a circle (easier).

$finished options screen-went back to old research over getting each individual pixel color (SEE WEEK 5) http://stackoverflow.com/questions/8350073/getting-pixel-information-from-the-screen-quickly
https://kodejava.org/how-do-i-get-the-colour-of-a-screen-pixel/

@http://stackoverflow.com/questions/7168839/how-does-robots-getpixelcolorint-x-int-y-method-work Figured out collision using getRGB, only tested coming from the left

$finished all the screens, refined options with buttons, figured out how to insert key presses with certain screens

$helped refine hitboxes, tried working on walls

## Week 11

@investigated walls

$helped refine walls and hitboxes

@started enemy class (using rectangles, bufferedimage, and distance formula for distance from player to enemy)

$finished walls and hitboxes, finished pause screen-TIME FOR CLASSES

## Week 12

$finished with the screens

$refined walls cause its bad-helped omar a lot

@worked on guac class (the enemy class for creating a lot of guacamoles) and the implementation in graphics

@worked on guac class

$actually finished walls, worked on layering

@worked on the use of guac in graphics class with guacmove and guacamole

## Week 13

$worked on layering, transparent walls, tried invisible enemies

$worked on layering

@implemented guacaomole enemy classes13234yhq53;p@$#

@tried to get proximity with music from player to enemy to work

$tried getting layering to work, working on photoshop, failed rectangles

@working on enemy class

## Week 14

$finally finished pov, working on the walls of the maze

@worked on music detection/sound effects

$working on the maze

@finished enemy class and combined codes

$finished the maze

## Week 15

$finished code, started presentation

@working on more enemies

$finished presentation
