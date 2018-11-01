# snake-mobile
Ported snake game from java to android

## Description
I had originally completed the University of Helsinki's MOOC course (Both [Part 1](http://moocfi.github.io/courses/2013/programming-part-1/) and [Part 2](http://moocfi.github.io/courses/2013/programming-part-2/)), and wanted to port their [Worm Game](https://materiaalit.github.io/2013-oo-programming/part2/week-12/) (Exercise 49) to Android to get a feel of the differences.

Prior to this, I had only did an extremely simple [QuoteBook App](https://github.com/nasjcodes/android-quotebook) with almost all instructions followed from the [Reddit post](https://www.reddit.com/r/Android/comments/2tpjep/the_new_step_by_step_guide_detailing_how_to_get/).

## Challenges
For record purposes, I have listed down (from memory) some challenges I faced when porting the application. In the future, I will try to record these down while programming to have a more complete list.

### Main differences
There were 2 main differences to porting the code in terms of functionality:
* The Java code used [javax.swing.Timer](https://docs.oracle.com/javase/7/docs/api/javax/swing/Timer.html) to update the graphics at fixed intervals. I followed [this](https://stackoverflow.com/questions/4597690/android-timer-how-to) answer on StackOverflow to implement a similar function.
* Android uses [Canvases](https://developer.android.com/reference/android/graphics/Canvas) to draw graphics, and I had no experience since Java uses [JPanel](https://docs.oracle.com/javase/7/docs/api/javax/swing/JPanel.html). I followed [this](https://google-developer-training.gitbooks.io/android-developer-advanced-course-practicals/content/unit-5-advanced-graphics-and-views/lesson-11-canvas/11-1a-p-create-a-simple-canvas/11-1a-p-create-a-simple-canvas.html) tutorial to make it work. Additionally, I refactored it into a separate class for (hopefully) cleaner code.

### Other challenges
* I wanted to add a settings page so that the application would not be too simple. The current iteration has a difficulty spinner which limits the maximum speed of the snake.
* This application has 3 Activities and 1 Fragment. I tried to keep good programming practice by storing all strings in strings.xml. Additionally, most dimensions are astored in dimens.xml.
* I could not find a way to simply set the text size of the spinner using layouts. I found a workaround to programatically generate the spinner with a larger size.

## TO-DO
### Issues
* Pressing "Default" in the Settings Activity will overwrite and save the default settings even if "Save" is not pressed.
* Pressing the back button on the game screen might cause some issues. This is because I did not define the other methods in the activity (e.g. onStop(), onDestroy() etc.).

### Things to improve
* More settings such as snake/apple/background colours.
* The game screen could be better fit to the edges of the screen.
* The directional keys could be changed to arrow icons.
* Animations can be more consistent throughout the application.
* Adding a "Back" and "Reset" button on the game screen.
