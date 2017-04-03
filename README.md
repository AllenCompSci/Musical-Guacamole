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

@since we don't wanna convert from graphics2D to libgdx just to use tilemaps for wall collision detection, we decided to just get the individual pixels color
