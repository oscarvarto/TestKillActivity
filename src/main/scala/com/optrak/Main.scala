package com.optrak

import org.scaloid.common._

/**
 * Created by oscarvarto on 3/7/14.
 */
class Main extends SActivity {
  onCreate {
    contentView = new SVerticalLayout {
      SButton("Start Second", {
        startActivity[Second]
      })
    }
  }
}
