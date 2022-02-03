Stock Control

This application requires the user to input a number of factories (in this case threads)
that will concurrently add widgets to a central warehouse. No more than 5000 widgets should
be added. For example, 5 factories would need to add 1000 widgets each, 10 factories would need
to add 500 widgets etc.

Firstly, we need to declare 2 variables, one for the number of widgets that need manufacturing
(finalWidgetTotal set to 5000) and one to act as a counter for widget production (productionCount set to 0).

Next, we need to ask the user to input the number of factories (threads) that will be running to produce the widgets.
Using a Scanner (System.in) the users input can be stored into an int variable (factoryQuantity) for use later.

A for loop in the main method will start a number of new threads (depending on user input) in another method named
warehouseAllocation. The for loop also increments the factoryID (variable declared for naming factories) so we will
be able to see which factory is producing which widget in the output. Next, the warehouseAllocation method parses the
factoryID variable and starts a number of new threads (acting as factories). For example, if the user inputs 7 factories,
the method will through 7 times and create 7 threads (factories) to create the widgets.

A Lambda expression parses these threads to the doCountdown method in the Countdown Class. This method tasks the threads to
increment the number of widgets if they total less than 5000. A thread.sleep function causes the current thread to suspend
execution for a specified period to make the processor available to other threads. An if statement within a for loop states
that if the number of widgets produced does not equal 5000, then run the final class 'IncreaseProductionCount'.

Finally, the IncreaseProductionCount class uses a 'synchronized' method. Synchronized allows threads to share resources, used
for reliable communication between threads (avoids threads printing the same widget twice). This method increments productionCount
when a thread has executed and prints output to the console. The output shows the factoryID that created a widget and the widget
number that it has produced. An if statement prints when the production of widgets have reached 5000.


