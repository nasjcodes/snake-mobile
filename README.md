# snake-mobile
Ported snake game from java to android

## Description
I had originally completed the University of Helsinki's MOOC course (Both [Part 1](http://moocfi.github.io/courses/2013/programming-part-1/) and [Part 2](http://moocfi.github.io/courses/2013/programming-part-2/)), and wanted to port their [Worm Game](https://materiaalit.github.io/2013-oo-programming/part2/week-12/) (Exercise 49) to Android to get a feel of the differences. The Java code that I programmed for that exercise can be found in ["java-code"](https://github.com/nasjcodes/snake-mobile/tree/master/java-code).

Prior to this, I had only did an extremely simple [QuoteBook App](https://github.com/nasjcodes/android-quotebook) with almost all instructions followed from the [Reddit post](https://www.reddit.com/r/Android/comments/2tpjep/the_new_step_by_step_guide_detailing_how_to_get/).

### Update 3 Nov 2018
Given that learning programming is a virtually endless cycle, I have decided to focus on web development to build up my basic skills in all areas. I will still update this periodically.

## Challenges
For record purposes, I have listed down (from memory) some challenges I faced when porting the application. In the future, I will try to record these down while programming to have a more complete list.

### Main differences
There were 2 main differences to porting the code in terms of functionality:
* The Java code used [javax.swing.Timer](https://docs.oracle.com/javase/7/docs/api/javax/swing/Timer.html) to update the graphics at fixed intervals. I followed [this](https://stackoverflow.com/questions/4597690/android-timer-how-to) answer on StackOverflow to implement a similar function.
* Android uses [Canvases](https://developer.android.com/reference/android/graphics/Canvas) to draw graphics, and I had no experience since Java uses [JPanel](https://docs.oracle.com/javase/7/docs/api/javax/swing/JPanel.html). I followed [this](https://google-developer-training.gitbooks.io/android-developer-advanced-course-practicals/content/unit-5-advanced-graphics-and-views/lesson-11-canvas/11-1a-p-create-a-simple-canvas/11-1a-p-create-a-simple-canvas.html) tutorial to make it work. Additionally, I refactored it into a separate class for (hopefully) cleaner code.

### Other challenges
#### First commit (1 Nov 2018)
* I wanted to add a settings page so that the application would not be too simple. The current iteration has a difficulty spinner which limits the maximum speed of the snake. Additionally, settings are saved using SharedPreferences.
* This application has 3 Activities and 1 Fragment. I tried to keep good programming practice by storing all strings in strings.xml. Additionally, most dimensions are astored in dimens.xml.
* I could not find a way to simply set the text size of the spinner using layouts. I found a workaround to programatically generate the spinner with a larger size.

#### Second commit (2 Nov 2018)
* I create a new subclass of ImageView (SquareImageView) to programatically determine the side length of the game and generate a square view. This was done by overriding the onMeasure method, and subtracting the heights of the other views. I tried to keep good coding practice so that if additional views are added, the code should not change much.

#### Third commit (3 Nov 2018)
* Changed gameView type in GameBoard to SquareImageView as the method to set bitmap is meant to be square.
* Change doFirstUpdate() to setBitmapSize()
* I noticed that the bitmap size in the current iteration is not equal to the imageView size. I managed to update the bitmap size every step the snake moves until it eventually matches the imageView size. However, this does not look good on screen.
* I also noticed that the 3 views (difficulty text, gameView, dPad) are not aligned perfectly. I think that this is because of the above issue - the bitmap size is supposed to iterate until it is the same as the imageView size, and then the layout can draw the views properly.

## TO-DO
### Issues
* see "Third commit (3 Nov 2018)"
* Pressing "Default" in the Settings Activity will overwrite and save the default settings even if "Save" is not pressed.
* Pressing the back button on the game screen might cause some issues. This is because I did not define the other methods in the activity (e.g. onStop(), onDestroy() etc.).

### Things to improve
* More settings such as snake/apple/background colours.
* The directional keys could be changed to arrow icons.
* Animations can be more consistent throughout the application.
* Adding a "Back" and "Reset" button on the game screen.
* Randomize snake starting direction.
