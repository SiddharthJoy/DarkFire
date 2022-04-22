# **Dark Fire**

**What it does:** Basically it's a fire alarming app.This app receives temperature data(in centigrade) from remote sensors.
               Sensor data are sent to the app through internet by an IoT device. The data keep updating itself within ~10 seconds. A fixed
              temperature is set into the app. When the collected temperature crosses this limit,the alarm starts ringing.An option is given 
              to the users that, they can call fire-station directly from this app.

**Features:** 
          
          - Account Creation

          - Multiple Device Support for Each Account
          
          - Real Time Data Upadate
          
          - Automatic Alarm with Device Information
          
          - Calling Option to Fire Station
          
**Platform/Language:** 

          - Android Studio (for app building)
          
          - Arduino (to program the IoT platform)
          
          - Google Firebase (for real time remote data handling)
          
**Data Flow:** _Sensor -> IoT device -> [Internet] -> Firebase Real Time DB -> [Internet] -> App_

**Hardwares Used:** 

           - LM35 (Temperature Sensor)
           - NodeMCU (IoT Platform)
           - Wires

**Limitatios:** 

           - One IoT device is needed here to transmit data of one sensor.It'll be very costly for the users.
           - Hardware installation is difficult.Experts are needed here to install all those staffs.
           - Fire Station calling option is quite manual.The dialing number is given into the code.This is not the optimized way.
           - Users cannot update their own and device info from the app.
                  
      
  # **Demonstration:** 
  
   <pre> <b>Registration:                  Login:                           Dashboard:</b></pre>
   
   <p float="left">
     <img src="https://user-images.githubusercontent.com/57936009/164331617-d390c4c6-4824-4079-b189-81ff46e0ec08.jpg" width="250" />
     &nbsp &nbsp <img src="https://user-images.githubusercontent.com/57936009/164326902-186127c3-f366-4411-8c29-363b32421b59.jpg" width="250" />
    &nbsp &nbsp <img src="https://user-images.githubusercontent.com/57936009/164332568-126c6217-d5ca-459f-aee7-bd546536fe96.jpg" width="250" />

  </p>
  
  <pre> <b>Status & Alarm:</b> </pre>
     A user may have number of devices those are installed in various places.In this page all the device readings and 
     device name according to their location are listed. Device name can be any other name,and to do this one have to 
     change in the arduino code. This page keeps tracking to all the readings and if any sensor reading passes a certain
     value (here is 40*) the alarm page will open and will ring the alarm bell.
     
  <p float="left">
   <img src="https://user-images.githubusercontent.com/57936009/164334672-94888ae5-34df-44ea-871b-e19969c95903.gif" width="250" />
    &nbsp &nbsp <img src="https://user-images.githubusercontent.com/57936009/164335035-0b210f02-e18d-43da-b753-f98b90a8201c.png" width="200"/>
    &nbsp &nbsp <img src="https://user-images.githubusercontent.com/57936009/164335542-d87ebfde-78b5-41e0-af16-9b5443ae6de4.jpg" width="250" />
  </p>
  
  <pre> <b>Profile:                            Installation Guide: </b> </pre>
  
   <p float="left">
     <img src="https://user-images.githubusercontent.com/57936009/164335931-96f3e4ac-82c4-4ee5-9e09-f376c3008876.jpg" width="250" />
     &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <img src="https://user-images.githubusercontent.com/57936009/164335987-6fe60ca4-3e41-460b-a841-de473c89c8bc.jpg" width="250" />
  </p>

**Conclusion:**

Although the app is not very user friendly, it is fully functional. Many upgradation is possible in this app. 
Project related all files(**including arduino code[darkfire.ino]**) are uploaded here. Thanks for reading. Happy Coding! :)

                     

