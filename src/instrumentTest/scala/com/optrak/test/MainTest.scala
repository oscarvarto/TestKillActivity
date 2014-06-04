package com.optrak.test

import android.test.ActivityInstrumentationTestCase2
import com.robotium.solo.Solo
import org.specs2.matcher.JUnitMustMatchers

import com.optrak.Main
import android.app.Activity
import com.optrak.Second

//import junit.framework.Assert._

/**
 * Created by oscarvarto on 3/10/14.
 */

class MainTest extends ActivityInstrumentationTestCase2[Main](classOf[Main]) with JUnitMustMatchers {
  var solo: Solo = _

  override def setUp() {
    super.setUp()
    solo = new Solo(this.getInstrumentation, this.getActivity)
  }

  def testZCalculatorBlackBox() {
    //getInstrumentation.callActivityOnDestroy()
    val mainActivity: Activity = solo.getCurrentActivity
    // Click on get result button
    this.solo.clickOnButton(0)
    solo.waitForActivity(classOf[Second])
    //getInstrumentation.callActivityOnDestroy(mainActivity)
    solo.goBack()
    solo.assertCurrentActivity("Current Activity is not Main", classOf[Main], false)
  }

  override def tearDown() {
    solo.finishOpenedActivities()
  }
}