1. Suppose you have the following stack of activities:
 
   * Second <-- This is at the top of the stack (currently on the foreground)
   * Main

2. Then suppose Android OS destroys Main.
3. We press the back button in Second.
4. I want to test that the user sees the screen corresponding to Main (that Android OS creates Main again, as if it was never destroyed).


**Can I simulate the above with Robotium Solo?**

The project in this repository uses Scala and Scaloid to build very minimalistic activities.
Currently, the only test in https://github.com/oscarvarto/TestKillActivity/tree/master/src/instrumentTest/scala/com/optrak/test/MainTest.scala
works, but I don't know how to simulate the step 2 above.

Any suggestion to test the above steps is very welcome.
