import time
from collections import deque
import cv2
import numpy as np
import imutils

# All of the below colors are in HSV
white_lower = (0, 0, 0)
# White lower: (0, 0, 0)
# Green lower: (28, 0, 0) or (29, 86, 6)
white_upper = (45, 63, 255)
# White upper: (25, 63, 255)
# Green upper: (91, 255, 255)

buffer = 25
pts = deque(maxlen=buffer)

# grab the reference to the webcam
cam = cv2.VideoCapture(0)

# allow the camera or video file to warm up
time.sleep(2.0)

# keep looping
while True:
    # grab the current frame
    frame = cam.read()[1]

    # if we are viewing a video and we did not grab a frame,
    # then we have reached the end of the video
    if frame is None:
        break

    # resize the frame, blur it, and convert it to the HSV
    # color space
    frame = imutils.resize(frame, width=600)
    blurred = cv2.GaussianBlur(frame, (11, 11), 0)
    hsv = cv2.cvtColor(blurred, cv2.COLOR_BGR2HSV)

    # construct a mask for the color "green", then perform
    # a series of dilations and erosions to remove any small
    # blobs left in the mask
    mask = cv2.inRange(hsv, white_lower, white_upper)
    mask = cv2.erode(mask, None, iterations=2)
    mask = cv2.dilate(mask, None, iterations=2)

    # find contours in the mask and initialize the current
    # (x, y) center of the ball
    cnts = cv2.findContours(mask.copy(), cv2.RETR_EXTERNAL,
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
        center = (int(center_x), int(center_y))

        # only proceed if the radius meets a minimum size
        if width >= 10.0:
            # Convert RotatedRect to array of points of corners
            box = cv2.boxPoints(rect)
            box = np.int0(box)

            # Draw RotatedRect and then the center point
            cv2.drawContours(frame, [box], 0, (0, 0, 255), 2)
            cv2.circle(frame, (int(center_x), int(center_y)), 5, (0, 255, 255),
                       -1)

    # update the points queue
    pts.appendleft(center)  # loop over the set of tracked points
    for i in range(1, len(pts)):
        # if either of the tracked points are None, ignore
        # them
        if pts[i - 1] is None or pts[i] is None:
            continue

        # otherwise, compute the thickness of the line and
        # draw the connecting lines
        thickness = int(np.sqrt(buffer / float(i + 1)) * 2.5)
        cv2.line(frame, pts[i - 1], pts[i], (0, 0, 255), thickness)

    # show the frame to our screen
    cv2.imshow("Frame", frame)
    key = cv2.waitKey(1) & 0xFF

    # if the 'q' key is pressed, stop the loop
    if key == ord("q"):
        break

# release the camera
cam.release()

# close all windows
cv2.destroyAllWindows()
