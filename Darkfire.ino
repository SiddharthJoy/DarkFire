#include <ESP8266WiFi.h>
#include <SoftwareSerial.h>
#include <FirebaseArduino.h>
#include <ArduinoJson.h>
#include <ESP8266HTTPClient.h>

#define FIREBASE_HOST "project-ce84f-default-rtdb.firebaseio.com"
#define FIREBASE_AUTH "hEZLG22ZTE0JnF0HWZa5tyMYXBfe9m4sQWzXwP5m"
#define WIFI_SSID "zulfiqure"
#define WIFI_PASSWORD "11223344"

String uid = "6xvKg4WfRacUyyb06Nr2pjj3owH2";
String area = "Gendaria";

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
