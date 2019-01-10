import time
from collections import deque
import cv2
import numpy as np  # noqa: F401
import imutils
from networktables import NetworkTables
import logging

# Whether or not the camera is flipped relative to left and right
img_is_flipped = True

# All of the below colors are in HSV
color_lower = (119, 70, 130)
# White lower: (0, 0, 0)
# Green lower: (28, 0, 0) or (29, 86, 6)
# Purple lower: (119, 70, 89)
color_upper = (144, 140, 255)
# White upper: (25, 63, 255)
# Green upper: (91, 255, 255)
# Purple upper: (144, 140, 255)

# NetworkTables publishing addresses
heading_addr = "Px From Crate"

# Buffer to show motion over time
buffer = 25
pts = deque(maxlen=buffer)

# Set up NetworkTables to use SmartDashboard
logging.basicConfig(level=logging.DEBUG)
ip = "10.55.87.2"
NetworkTables.initialize(server=ip)
sd = NetworkTables.getTable("SmartDashboard")

# grab the reference to the webcam
cam = cv2.VideoCapture(0)

# Width to set frame to
frame_width = cam.get(3)

# allow the camera or video file to warm up
time.sleep(2.0)


def dist_color_update(color, heading_addr):
    while True:
        # grab the current frame
        frame = cam.read()[1]

        # blur frame, and convert it to the HSV color space
        # frame = imutils.resize(frame, width=frame_width) <- too costly
        blurred = cv2.GaussianBlur(frame, (11, 11), 0)
        hsv = cv2.cvtColor(blurred, cv2.COLOR_BGR2HSV)

        # construct a mask for the color "green", then perform
        # a series of dilations and erosions to remove any small
        # blobs left in the mask
        mask = cv2.inRange(hsv, color_lower, color_upper)
        mask = cv2.erode(mask, None, iterations=2)
        mask = cv2.dilate(mask, None, iterations=2)

        # find contours in the mask and initialize the current
        # (x, y) center of the ball
        cnts = cv2.findContours(mask, cv2.RETR_EXTERNAL,
                                cv2.CHAIN_APPROX_SIMPLE)
        cnts = imutils.convenience.grab_contours(cnts)
        center = None

        # only proceed if at least one contour was found
        if len(cnts) > 0:
            # find the largest contour in the mask, then use it to compute the
            # minimum enclosing circle and centroid
            c = max(cnts, key=cv2.contourArea)
            rect = cv2.minAreaRect(c)
            ((center_x, center_y), (width, _), _) = rect

            # only proceed if the radius meets a minimum size
            if width >= 10.0:
                center = (int(center_x), int(center_y))
                dist_center = (frame_width / 2) - center_x
                sd.putNumber(heading_addr, dist_center)

                print("Side: {} | Dist: {}".format(
                    "Left" if center[0] <= (frame_width / 2) else "Right",
                    dist_center))

                # Convert RotatedRect to array of points of corners
                #         box = cv2.boxPoints(rect)
                #         box = np.int0(box)

                #         # Draw RotatedRect and then the center point
                #         cv2.drawContours(frame, [box], 0, (0, 0, 255), 2)
                # cv2.circle(frame, (int(center_x), int(center_y)), 5,
                #            (0, 255, 255), -1)

        # # update the points queue
        # pts.appendleft(center)  # loop over the set of tracked points
        # for i in range(1, len(pts)):
        #     # if either of the tracked points are None, ignore
        #     # them
        #     if pts[i - 1] is None or pts[i] is None:
        #         continue

        #     # otherwise, compute the thickness of the line and
        #     # draw the connecting lines
        #     thickness = int(np.sqrt(buffer / float(i + 1)) * 2.5)
        #     cv2.line(frame, pts[i - 1], pts[i], (0, 0, 255), thickness)

        # # show the frame to our screen
        # cv2.imshow("Frame", frame)
        # key = cv2.waitKey(1) & 0xFF

        # # if the 'q' key is pressed, stop the loop
        # if key == ord("q"):
        #     break


if __name__ == "__main__":
    # p = Process(target=f, args=('bob',))
    # p.start()
    pass

# release the camera
cam.release()

# close all windows
cv2.destroyAllWindows()
