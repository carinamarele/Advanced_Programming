# Solitaire Version 1

## Design made by Marele Carina-Ioana 2A4

## (c) All rights to creators of the game and their rules

What you can do in this game:

 + You can see the rules
 + You can see the rules section in the middle of a game by pressing the `How to play?` in the menuBar( it will open a new window with them)
 + After a new game is created:
      + You can start a new game by pressing `New game` in the menuBar 
      + You can leave anytime the game and go back to the main page by pressing `Start menu` in the menuBar
      + You can close the game either by using the `Exit` in the menuBar, either by pressing the `X` button of the window
 
 **Algoritm:**
 
  + Separated classes for every part of the game, also the alerts windows( `Rules` & `Credits&Author` )
  + 4 packages for the cards,gui,model gaming and for the movement of the cards which contains all the necessary classes
  + When you start the game it will appear automatically 7 stacks of cards(middle down), one stack with their back shown(left up) and 4 empty stacks where it will be the final stack ordered
  + When the stack of unknown cards is empty, there are 2 options:
       + It will appear a image in that place with the message `Try again` and only if clicked it will generate another game
       + It will appear a image wiht the message `Won` only when in the 4 stacks, the last cards are only Kings( which means that there are 52 cards)
              + By clicking the image, it will generate a new game
  + If you go back to the start menu, your progress will be lost and will start a new instance of the game
  + You can go to a previous move by pressing the `Back` on the keyboard, because all of the moves are saved in an array
  + For every part of the game, there is a specific class:
      + `StackDownGame`  -> 7 Stacks of cards in the middle of the window using an Enum `IndexSStackPile` which represents the number of every pile
      + `FinalePileStack` -> the 4 spaces for the finale stack of cards ordered ( it also uses an Enum `FinaleStackOrder`: first,second,third,four)
      + `CardDragHandler` -> for the movements of the cards
      +  etc..
         
  **The programming language used for this game was Java ( using JavaFx for the graphics)**
  
  **All the images( from the cards, to the background) is made by myself using Adobe Photoshop.**
   
  **You can view a short presentation of how the game works [here](https://youtu.be/UvnvI_XSxnM).
  
