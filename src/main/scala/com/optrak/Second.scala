package com.optrak

import org.scaloid.common._

class Second extends SActivity {
  onCreate {
    contentView = new SVerticalLayout {
      STextView("Dummy")
    }
  }
}
