
// This file have to be burnt in nodemcu to program the device
// It makes the device collect data from the sensor and send it to the firebase database
// The wiring between nodemcu and temerature sensor is widely available on internet


#include <ESP8266WiFi.h>
#include <SoftwareSerial.h>
#include <FirebaseArduino.h>
#include <ArduinoJson.h>
#include <ESP8266HTTPClient.h>

#define FIREBASE_HOST "project-*****-*******-rtdb.firebaseio.com" //     Firebase credentials
#define FIREBASE_AUTH "hEZLG******************************XwP5m"  //  to integrate their service 

#define WIFI_SSID "**********"                                    //      wifi credentials for
#define WIFI_PASSWORD "***********"                               //  internet connection of nodemcu

String uid = "6xvKg4WfRac**********jj3owH2";                      // This is user id.Every user have to find his id from his/her profile and add that here
String area = "********";                                         // Set device information here.It will be displayed on the app.

String mystring;
int vr = A0,temp;
int sdata = 0;

void setup() {
  Serial.begin(9600);
  pinMode(A0,INPUT);
  pinMode(D0,OUTPUT);
  // connect to wifi.
  
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("connecting");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }
  Serial.println();
  Serial.print("connected: ");
  Serial.println(WiFi.localIP());
  
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
}

int n = 0;

void loop() {
  float temp = analogRead(A0);
  temp *= 0.58828125;
  temp *= 0.48;
  Serial.println(temp);
  Serial.println();
  String str = "                                                ";
  mystring = String(temp); 
  String dir = "Temparature/" + uid + "/" + area + "/";
  
  Firebase.setString(dir,area + str + mystring);
  delay(12000);
}
