import pyrebase
import time

### Firebase init
config = {
    "apiKey": "AIzaSyD-53mgwhgF7WVDiw5YYys_egUI_htkyUM",
    "authDomain": "hardhack2018-35975.firebaseapp.com",
    "databaseURL": "https://hardhack2018-35975.firebaseio.com",
    "projectId": "hardhack2018-35975",
    "storageBucket": "hardhack2018-35975.appspot.com",
    "messagingSenderId": "114502595329"
}

firebase = pyrebase.initialize_app(config)
db = firebase.database()

### Getters
def getVals():
    light1 = db.child("light1").get()
    light2 = db.child("light2").get()
    light3 = db.child("light3").get()
    return (light1.val(), light2.val(), light3.val())
 
### Setters
def setlight(light,val):
    if(val>100 or val<0):
        raise Exception
    db.child(light).set(val)

def setl1(l1):
    setlight('light1',l1)

def setl2(l2):
    setlight('light2',l2)
  
def setl3(l3):
    setlight('light3',l3)

def setall(l1,l2,l3):
    setl1(l1)
    setl2(l2)
    setl3(l3)