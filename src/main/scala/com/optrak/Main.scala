package com.optrak

import org.scaloid.common._

class Main extends SActivity {
  onCreate {
    contentView = new SVerticalLayout {
      SButton("Start Second", startActivity[Second])
    }
  }
}
