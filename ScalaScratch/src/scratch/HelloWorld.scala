package scratch

import scala.swing._
import javax.swing.JPanel

object HelloWorld extends SimpleSwingApplication {

  class CirclePanel extends Panel {
    preferredSize = new Dimension(20, 20)
    
    override def paintComponent(g: Graphics2D) {
      g.fillOval(0, 0, size.width, size.height)
    }
  }

  def top = new MainFrame {
    contents = new GridPanel(30, 20) {
      contents ++= List.fill(600)(new CirclePanel)
    }
  }

}