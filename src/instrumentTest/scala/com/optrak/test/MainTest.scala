package com.optrak.test

import android.test.ActivityInstrumentationTestCase2
import com.robotium.solo.Solo
import org.specs2.matcher.JUnitMustMatchers

import com.optrak.Main
import android.app.Activity
import com.optrak.Second

class MainTest extends ActivityInstrumentationTestCase2[Main](classOf[Main]) with JUnitMustMatchers {
  var solo: Solo = _

  override def setUp() {
    super.setUp()
    solo = new Solo(this.getInstrumentation, this.getActivity)
  }

  def testZCalculatorBlackBox() {
    //getInstrumentation.callActivityOnDestroy()
    val mainActivity: Activity = solo.getCurrentActivity
    this.solo.clickOnButton(0) // The only button in Main starts Second
    solo.waitForActivity(classOf[Second])
    
    // The following doesn't work.
    // How can I simulate that mainActivity, now in the background, is destroyed by Android OS? 
    // getInstrumentation.callActivityOnDestroy(mainActivity) 
    
    solo.goBack()
    solo.assertCurrentActivity("Current Activity is not Main", classOf[Main], false)
  }

  override def tearDown() {
    solo.finishOpenedActivities()
  }
}
