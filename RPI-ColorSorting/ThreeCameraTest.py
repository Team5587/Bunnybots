import cv2
from networktables import NetworkTables
import numpy as np

# To see messages from networktables, you must setup logging
import logging
logging.basicConfig(level=logging.DEBUG)

NetworkTables.initialize(172.22.11.2)
sd = NetworkTables.getTable("SmartDashboard")

# cam0 = cv2.VideoCapture(0)
cam1 = cv2.VideoCapture(1)
# cam2 = cv2.VideoCapture(2)
# cam3 = cv2.VideoCapture(3)

#Lower color limit for red: 
lowerRed = np.array([169, 100, 100])
#Upper color limit for red:
upperRed = np.array([189, 255,255])
#Lower color limit for blue:
lowerBlue = np.array([95, 100, 100])
#Upper color limit for blue:
upperBlue = np.array([115, 255,255])

def findColors(frame, camNum):
    #boolean for identified colors
    red = False
    blue = False

    #switch color space to HSV
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)

    #Make mask of image, only showing color in between upper and lower color values
    redMask = cv2.inRange(hsv, lowerRed, upperRed)
    blueMask = cv2.inRange(hsv, lowerBlue, upperBlue)
    
    #find contours of colors in respective masks
    im2, redContours, hierarchy = cv2.findContours(redMask, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    im2, blueContours, hierarchy = cv2.findContours(blueMask, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

    #get the sizes of all contours
    red_contour_sizes = [(cv2.contourArea(red_contour), red_contour) for red_contour in redContours]
    blue_contour_sizes = [(cv2.contourArea(blue_contour), blue_contour) for blue_contour in blueContours]

    #if there are contorurs, find the biggest one and draw it
    if len(red_contour_sizes) > 0:
        red = True

    if len(blue_contour_sizes) > 0:
        blue = True
    
    sd.putBoolean("Camera " + str(camNum) + " Red", red)
    sd.putBoolean("Camera " + str(camNum) + " Blue", blue)

while True:
    # _, cam0Frame = cam0.read()
    _, cam1Frame = cam1.read()
    # _, cam2Frame = cam2.read()
    # _, cam3Frame = cam3.read()

    # findColors(cam0Frame, 0)
    findColors(cam1Frame, 1)
    # findColors(cam2Frame, 2)
    # findColors(cam3Frame, 3)

    print("Camera 1 ")
    #if the key 'q' is pressed, exit while loop
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# cam0.release()   
cam1.release()
# cam2.release()
# cam3.release()

cv2.destroyAllWindows()