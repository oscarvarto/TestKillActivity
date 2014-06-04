package com.optrak

import org.scaloid.common._

/**
 * Created by oscarvarto on 2014/06/03.
 */
class Second extends SActivity {
  onCreate {
    contentView = new SVerticalLayout {
      STextView("Dummy")
    }
  }
}
