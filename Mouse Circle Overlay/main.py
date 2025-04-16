import sys
import ctypes
from PyQt5 import QtCore, QtGui, QtWidgets

# Windows constants
WS_EX_LAYERED = 0x80000
WS_EX_TRANSPARENT = 0x20
GWL_EXSTYLE = -20
VK_LBUTTON = 0x01
VK_RBUTTON = 0x02

def is_mouse_button_down():
    # Check if either left or right button is held
    return ctypes.windll.user32.GetAsyncKeyState(VK_LBUTTON) & 0x8000 or \
           ctypes.windll.user32.GetAsyncKeyState(VK_RBUTTON) & 0x8000


class CursorHighlighter(QtWidgets.QWidget):
    def __init__(self):
        super().__init__()

        self.setWindowFlags(
            QtCore.Qt.FramelessWindowHint |
            QtCore.Qt.WindowStaysOnTopHint |
            QtCore.Qt.Tool
        )

        self.setAttribute(QtCore.Qt.WA_TranslucentBackground)
        self.setAttribute(QtCore.Qt.WA_NoSystemBackground, True)

        self.radius = 50

        self.position_timer = QtCore.QTimer()
        self.position_timer.timeout.connect(self.updatePosition)
        self.position_timer.start(8)  # 125 FPS

        self.click_check_timer = QtCore.QTimer()
        self.click_check_timer.timeout.connect(self.checkMouseClick)
        self.click_check_timer.start(10)  # check frequently

        self.resize(self.radius * 2, self.radius * 2)
        self.show()

        if sys.platform.startswith("win"):
            hwnd = self.winId().__int__()
            ctypes.windll.user32.SetWindowLongW(
                hwnd, GWL_EXSTYLE,
                ctypes.windll.user32.GetWindowLongW(hwnd, GWL_EXSTYLE) | WS_EX_LAYERED | WS_EX_TRANSPARENT
            )

    def checkMouseClick(self):
        if is_mouse_button_down():
            self.setVisible(False)
        else:
            self.setVisible(True)

    def updatePosition(self):
        pos = QtGui.QCursor.pos()
        new_x = pos.x() - self.radius
        new_y = pos.y() - self.radius

        if self.pos() != QtCore.QPoint(new_x, new_y):
            self.move(new_x, new_y)
            self.update()

    def paintEvent(self, event):
        painter = QtGui.QPainter(self)
        painter.setRenderHint(QtGui.QPainter.Antialiasing)

        pen = QtGui.QPen(QtGui.QColor(255, 0, 0), 4)
        painter.setPen(pen)
        painter.setBrush(QtGui.QColor(255, 0, 0, 50))
        painter.drawEllipse(0, 0, self.radius * 2, self.radius * 2)


if __name__ == "__main__":
    app = QtWidgets.QApplication(sys.argv)
    app.setApplicationName("Cursor Highlighter")

    highlighter = CursorHighlighter()
    sys.exit(app.exec_())
