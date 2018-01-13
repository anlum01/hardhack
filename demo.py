#!/usr/bin/env python

# Author: Thomas Ingleby <thomas.c.ingleby@intel.com>
# Copyright (c) 2014 Intel Corporation.
#
# Permission is hereby granted, free of charge, to any person obtaining
# a copy of this software and associated documentation files (the
# "Software"), to deal in the Software without restriction, including
# without limitation the rights to use, copy, modify, merge, publish,
# distribute, sublicense, and/or sell copies of the Software, and to
# permit persons to whom the Software is furnished to do so, subject to
# the following conditions:
#
# The above copyright notice and this permission notice shall be
# included in all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
# EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
# MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
# NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
# LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
# OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
# WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

import mraa
import time
import hard

x = mraa.Gpio(23)
x.dir(mraa.DIR_OUT)
y = mraa.Gpio(25)
y.dir(mraa.DIR_OUT)
z = mraa.Gpio(27)
z.dir(mraa.DIR_OUT)
def init():
    curr_vals = hard.getVals()
    a = curr_vals[0]
    b = curr_vals[1]
    c = curr_vals[2]

    if (a >= 50):
        x.write(0)

    elif (a < 50):
        x.write(1)

    if (b >= 50):
        y.write(0)

    elif (b < 50):
        y.write(1)

    if (c >= 50):
        z.write(0)

    elif (c < 50):
        z.write(1)

def main():
    init()
    old_values = hard.getVals() 
    while(True):
       curr_values = hard.getVals()
       if(curr_values != old_values):
           #Update the lights
           init()
       time.sleep(1)
