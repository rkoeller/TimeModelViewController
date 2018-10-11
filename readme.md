# Time Model View Controller
Time Model View Controller is an app developed for Android 8.0 Oreo. It will allow the user to add various clocks to the screen, change the date/time, undo any changes, and redo undone changes.
## Installation Requirements
* Android 8.0 device
## Installation
* Store app-release.apk into android device
* Navigate to .apk in your android's file system
* Tap .apk to start installation
* Follow on screen instructions
## Usage
There is no usage. The app will just display two clocks that do not reflect the internal model.
## Preplanning Artifacts
![](/gitImages/ui.jpg?raw=true "UI")
![](/gitImages/uml.jpg?raw=true "UI")
## Build
Built with Android Studio 3.1.4; no external libraries should be needed.
## Author
* Ryan Koeller
## Design Discussion
When I began this app I started out by thinking about how to add n clocks to the app. My idea was there would be a main fragment that spawned other clock fragments from the user and those fragments would be displayed as separate tabs in the main activity. The main fragment would have five buttons: Add digital clock, add analog clock, undo, redo, change time. The main fragment would also have six small text boxes for user input: year, month, date, hours, minutes, seconds. The change time button would take the values in the text boxes and change the TimeDate model.

Next I worked on the model view controller ideas. I had developed and tested the model view controllers in Eclipse so I could use the console instead of having to install and apk an API everytime I wanted to see if my code had worked. The model is the time. The controller is what the user uses to manipulate the model. The views are the various clocks. Originally my model had been designed with a Time object and a Date object but, later I found the java.util.Date object handles both time and date. The model was to have setDate(Date) : void, getDate() : Date, setTime(Time) : void, and getTime() : Time methods but, with the Date class it was changed to be setTimeDate(long) : void, setTimeDate(int, int, int, int, int, int), updateSeconds() : void, and getTimeDate() : Date.

My TimeDateController was designed with the thought of having to change and update the models. Later it was upgraded to handle date change actions with the command design pattern. First I had to think about if the model should update its own seconds or if the controller should increase the model's time by one second every 1000 milliseconds. I decided that the controller should increase the models time every 1000 milliseconds. To implement that I made the controller implement Runnable so the ticker can be run on a separate thread independent of everything else. Next I had to separate every action the controller does to the model into Action objects so I could use the command design pattern. The android UI is supposed to call the setTimeDate(int,int,int,int,int,int) method and that method was to create a ChangeDateAction that would call its doIt() method to change the date. The previous Date and new Date were stored in the Action so if the user calls undo or redo it could remember what the old Date was and revert back to it. Every Action is stored in a "done" stack and could be popped to undo changes.

I had thought of three possible views, a digitial clock, an analog clock, and a binary clock (very cool). I had created a proto-view in my Eclipse project to make sure the controller could send and update the model and it was working.
![](/gitImages/uml.png?raw=true "UML")
Here is where the trouble began, Android UI and Clock APIs. Every clock API I found in the Java library could not, under any circumstances, be changed after creation or be set with a custom time; DigitialClock, AnalogClock, TextClock. I tried desperately to bend these clocks to my will but I was unable to do so. Any attempt at making a clock on my own was shot down after hours of frustration on each attempt.

The tabs I intended to develop also did not go as planned. I created separate fragments for each clock view and a main fragment for controlling the app. The fragments were to be stored in a list to be drawn to the screen and recalled when requested. Android UI is difficult to bend to your will and I hope it the future it is easier to design, like in Visual C#.

Advice for future Students is, don't look into the Android api for a premade clock to manipulate for your model; there isn't one. You'll save time not looking for them and just making your own or finding someone elses library to use in your app.
